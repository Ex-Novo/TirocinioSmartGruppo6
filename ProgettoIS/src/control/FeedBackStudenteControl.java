package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Feedback;
import bean.Tirocinio;
import dao.FeedBackDaoImpl;
import dao.FeedBackDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

/**
 * Servlet implementation class FeedBackAziendaControl
 */
@WebServlet("/FeedBackStudenteControl")
public class FeedBackStudenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackStudenteControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * Il metodo prende le valutazioni dell'utente e fa la media. Infine chiama i metodi dao per salvare il feedback nel database.
	 * @author Mario Procida, Luca Lamberti
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String piva = (String) session.getAttribute("piva");
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("sendValutazione")) {
			
			String matricola = request.getParameter("matricola");
			session.setAttribute("matricolaStudente", matricola);
			session.setAttribute("tipoVal", "fbStudente");
			
			getServletConfig().getServletContext().getRequestDispatcher("/checkVal").forward(request, response);
		}
		
		if(tipo.equals("confermaForm")) {
			
			double rating1 = Double.parseDouble(request.getParameter("rating1"));
			double rating2 = Double.parseDouble(request.getParameter("rating2"));
			double rating3 = Double.parseDouble(request.getParameter("rating3"));
			
			double finalRating = (rating1 + rating2 + rating3) / 3; //calcolo media valutazione
			
			TirocinioDaoInterface tirDao = new TirocinioDaoImpl();
			Tirocinio tir = tirDao.getDettagliAziendeConvenzionate(piva);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			
			Feedback fb = new Feedback();
			fb.setPiva(piva);
			fb.setMatricola((String)session.getAttribute("matricolaStudente"));
			fb.setValutazioneStudente(finalRating);
			fb.setIdTirocinio(tir.getIdTirocinio());
			fb.setData(dateFormat.format(date));
			
			FeedBackDaoInterface fbDao = new FeedBackDaoImpl();
			boolean result = fbDao.inviaFeedBackStudente(fb);
			
			PrintWriter out = response.getWriter();
			//se la query è andata a buon fine
			if(result){
					
				session.removeAttribute("matricolaStudente");
				session.setAttribute("canFeed", false);
				out.println("<script>");
				out.println("alert('Valutazione inviata con successo')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
				
			}
			//se la query non è andata a buon fine
			else{
				out.println("<script>");
				out.println("alert('Non è stato possibile inviare la valutazione')");
				out.println("window.history.back()");
				out.println("</script>");
				
			}
		}
		
		
	}

}
