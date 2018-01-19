package control.gestioneTirocinio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RichiestaTirocinio;
import bean.Tirocinio;
import dao.RegistroDaoImpl;
import dao.RegistroDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

/**
 * Servlet implementation class ApprovaTirocinioControl
 */
@WebServlet("/ApprovaTirocinioControl")
public class ApprovaTirocinioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovaTirocinioControl() {
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
	 * Il metodo richiama i metodi dao per cambiare lo stato della richiesta di tirocinio nel database a seconda del tipo (accettata o rifiutata)
	 * 
	 * @author Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");
		String matricola = request.getParameter("matricola");
		
		RichiestaTirocinioDaoInterface rTirDao = new RichiestaTirocinioDaoImpl();
		
		//Recupero idTirocinio della richiesta
		RichiestaTirocinio rTir = rTirDao.getRichTirocinio(matricola);
		int idTirocinio = rTir.getIdTirocinio();
		
		//Recupero partita iva azienda rispetto al tirocinio offerto
		TirocinioDaoInterface tirDao = new TirocinioDaoImpl();
		Tirocinio tir = tirDao.getPivaByIdTirocinio(idTirocinio);
		String piva = tir.getP_iva();
		
		RegistroDaoInterface regDao = new RegistroDaoImpl();
		
		PrintWriter out = response.getWriter();
		
		// L'utente didattica ha premuto sul pulsate accetta e la convenzione viene approvata
		if(tipo.equals("accetta")) {
			
			boolean result = rTirDao.approvazioneRichiestaTirocinio(matricola); //approvazione richiesta
		    result = regDao.inserisciRegistro(matricola, piva); //creazione registro studente
			
			
			if(result) {
				out.println("<script>");
				out.println("alert('Richiesta tirocinio approvata')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('Si � verificato un errore')");
				out.println("window.history.back()");
				out.println("</script>");
			}
			
			
		}
		
		if(tipo.equals("rifiuta")) {
			
			boolean result = rTirDao.rifiutoRichiestaTirocinio(matricola);
			
			if(result) {
				out.println("<script>");
				out.println("alert('Richiesta tirocinio rifiutata')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('Si � verificato un errore')");
				out.println("window.history.back()");
				out.println("</script>");
			}
		}
	}

}