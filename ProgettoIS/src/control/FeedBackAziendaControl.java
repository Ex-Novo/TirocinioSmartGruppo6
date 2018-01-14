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

import bean.Azienda;
import bean.Feedback;
import bean.RichiestaTirocinio;
import bean.Tirocinio;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.FeedBackDaoImpl;
import dao.FeedBackDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

/**
 * Servlet implementation class FeedBackStudenteControl
 */
@WebServlet("/FeedBackAziendaControl")
public class FeedBackAziendaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackAziendaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String matricola = (String) session.getAttribute("matricola");
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("sendValutazione")) {
			
			
			RichiestaTirocinioDaoInterface rTirDao = new RichiestaTirocinioDaoImpl();
			RichiestaTirocinio rTir = rTirDao.getRichTirocinio(matricola);
			
			int idTirocinio = rTir.getIdTirocinio();
			
			TirocinioDaoInterface tirDao = new TirocinioDaoImpl();
			Tirocinio t = tirDao.getPivaByIdTirocinio(idTirocinio);
			
			session.setAttribute("pivaAzienda", t.getP_iva());
			session.setAttribute("tipoVal", "fbAzienda");
			
			getServletConfig().getServletContext().getRequestDispatcher("/checkVal").forward(request, response);
		}
		
		if(tipo.equals("confermaForm")) {
			
			double rating1 = Double.parseDouble(request.getParameter("rating1"));
			double rating2 = Double.parseDouble(request.getParameter("rating2"));
			double rating3 = Double.parseDouble(request.getParameter("rating3"));
			double rating4 = Double.parseDouble(request.getParameter("rating4"));
			double rating5 = Double.parseDouble(request.getParameter("rating5"));
			double rating6 = Double.parseDouble(request.getParameter("rating6"));
			
			double finalRating = (rating1 + rating2 + rating3 + rating4 + rating5 + rating6) / 6; //calcolo media valutazione
			
			RichiestaTirocinioDaoInterface rTirDao = new RichiestaTirocinioDaoImpl();
			RichiestaTirocinio rTir = rTirDao.getRichTirocinio(matricola);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			
			Feedback fb = new Feedback();
			fb.setMatricola(matricola);
			fb.setPiva((String)session.getAttribute("pivaAzienda"));
			fb.setValutazioneAzienda(finalRating);
			fb.setIdTirocinio(rTir.getIdTirocinio());
			fb.setData(dateFormat.format(date));
			
			FeedBackDaoInterface fbDao = new FeedBackDaoImpl();
			boolean result = fbDao.inviaFeedBackAzienda(fb);
			
			PrintWriter out = response.getWriter();
			//se la query è andata a buon fine
			if(result){
					
				session.removeAttribute("pivaAzienda");
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
