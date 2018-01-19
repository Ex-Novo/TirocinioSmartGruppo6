package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Feedback;
import bean.RichiestaTirocinio;
import bean.Tirocinio;
import dao.FeedBackDaoImpl;
import dao.FeedBackDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

/**
 * Servlet implementation class CheckValutazione
 */
@WebServlet("/CheckValutazione")
public class CheckValutazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckValutazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * Il metodo richiama i dao per controllare se è già presente nel database un feedback inviato dall'utente. In caso negativo esegue un redirect alla pagina per il form
	 * valutativo associato.
	 * @author Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		String tipoValutazione = (String) session.getAttribute("tipoVal");
		
		
		
		//Controllo se lo studente ha già effettuato un feedback sull'azienda
		if(tipoValutazione.equals("fbAzienda")) {
			
			
			String matricola = (String) session.getAttribute("matricola");
			String piva = (String) session.getAttribute("pivaAzienda");
			
			RichiestaTirocinioDaoInterface rTirDao = new RichiestaTirocinioDaoImpl();
			RichiestaTirocinio rTir = rTirDao.getRichTirocinio(matricola);
			
			int idTirocinio = rTir.getIdTirocinio();
			
			FeedBackDaoInterface fbDao = new FeedBackDaoImpl();
			
			ArrayList<Feedback> fbs = fbDao.getFeedBacks(piva, matricola, idTirocinio);
			
			boolean result = false;
			for(int i = 0 ; i< fbs.size(); i++) {
				if(fbs.get(i).getValutazioneAzienda() != 0) {
					result = true;
				}
			}
			
			if(rTir.getStatus()== null){
				
				
					session.setAttribute("canFeed", false);
					out.println("<script>");
					out.println("alert('Non hai effettuato un tirocinio. Effettua una richiesta di tirocinio ')");
					out.println("window.history.back()");
					out.println("</script>");
					
				
				
			}
			
			if(result) {
				
				session.setAttribute("canFeed", false);
				
				out.println("<script>");
				out.println("alert('Hai gia valutato l azienda')");
				out.println("window.history.back()");
				out.println("</script>");
				
				
			}else {
				session.setAttribute("canFeed", true);
				
				out.println("<script>");
				out.println("window.open('FeedBackAzienda.jsp','_self')");
				out.println("</script>");
			}
		}
		
		//Controllo se l'azienda ha già effettuato un feedback sullo studente
		if(tipoValutazione.equals("fbStudente")) {
			
			String piva = (String) session.getAttribute("piva");
			String matricolaStudente = (String) session.getAttribute("matricolaStudente");
			
			TirocinioDaoInterface tirDao = new TirocinioDaoImpl();
			Tirocinio tir = tirDao.getDettagliAziendeConvenzionate(piva);
			
			int idTirocinio = tir.getIdTirocinio();
			
			FeedBackDaoInterface fbDao = new FeedBackDaoImpl();
			
			ArrayList<Feedback> fbs = fbDao.getFeedBacks(piva, matricolaStudente, idTirocinio);
			
			boolean result = false;
			for(int i = 0 ; i< fbs.size(); i++) {
				
				if(fbs.get(i).getValutazioneStudente() != 0) {
					result = true;
				}
			}
			
			
			if(result) {
				
				session.setAttribute("canFeed", false);
				out.println("<script>");
				out.println("alert('Hai gia valutato lo studente')");
				out.println("window.history.back()");
				out.println("</script>");
			}else {
				session.setAttribute("canFeed", true);
				out.println("<script>");
				out.println("window.open('FeedBackStudente.jsp','_self')");
				out.println("</script>");
			}
		}
		
		out.flush();
		out.close();
			
	}

}
