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
import bean.Convenzione;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;

/**
 * Servlet che permette ad una azienda non convenzionata di effettuare la richiesta di convenzione
 */
@WebServlet("/RichiestaConvenzioneControl")
public class RichiestaConvenzioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EMAIL_DIRETTORE = "fverdi@unisa.it";   
    
    public RichiestaConvenzioneControl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");//email dell'azienda loggata
		String tipo = request.getParameter("tipo");
		
		
		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda azienda = aziendaDao.getAziendaByEmail(email);
		
		//conferma del form per la richiesta di convenzione
		if(tipo.equals("confermaForm")){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			
			String piva=azienda.getP_iva();
			String stato ="in attesa";
			String dataConv = dateFormat.format(date);
			String dettaglioConv = request.getParameter("descrizione");
			String tutorAziendale= request.getParameter("tutorAziendale");
			int numPosti = Integer.parseInt( request.getParameter("numPosti"));
			
			Convenzione convenzione= new Convenzione();
			convenzione.setData(dataConv);
			convenzione.setStato(stato);
			convenzione.setDescrizione(dettaglioConv);
			convenzione.setP_iva(piva);
			convenzione.setTutorAziendale(tutorAziendale);
			convenzione.setNumPosti(numPosti);
			
			session.setAttribute("convenzione", convenzione);
			
			getServletConfig().getServletContext().getRequestDispatcher("/FirmaConvenzione.jsp").forward(request, response);
			
		}
		
		//Conferma della richiesta di convenzione dopo aver caricato il documento firmato salvando i dati nel database
		if(tipo.equals("confermaRichiesta")){
			
			Convenzione convenzione = (Convenzione) session.getAttribute("convenzione");
			
			aziendaDao.addTutorAziendale(convenzione.getTutorAziendale(), convenzione.getP_iva());//salvo il tutor aziendale nel db
			ConvenzioneDaoInterface convenzioneDao = new ConvenzioneDaoImpl();
			boolean result = convenzioneDao.invioRichiestaConvenzione(convenzione, EMAIL_DIRETTORE, convenzione.getP_iva());//salva la convenzione del database
			
			PrintWriter out =response.getWriter();
			//se la query è andata a buon fine
			if(result){
				out.println("<script>");
				out.println("alert('Richiesta Effettuata')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
				
			}
			//se la query non è andata a buon fine
			else{
				out.println("<script>");
				out.println("alert('Non è stato possibile effettuare la richiesta')");
				out.println("window.history.back()");
				out.println("</script>");
				
			}
			out.close();
		}
		
	}

}
