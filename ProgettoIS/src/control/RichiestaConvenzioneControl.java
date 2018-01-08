package control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
		if(tipo.equals("confermaForm")){
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			Azienda azienda = aziendaDao.getAziendaByEmail(email);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			String piva=azienda.getP_iva();
			String stato="in attesa";
			String dataConv = "" + dateFormat.format(date);
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

			/*ConvenzioneDaoInterface convenzioneDao = new ConvenzioneDaoImpl();
			convenzioneDao.invioRichiestaConvenzione(convenzione, EMAIL_DIRETTORE, piva);
			aziendaDao.addTutorAziendale(tutorAziendale, piva);//salvo il tutor aziendale nel db*/
			
			session.setAttribute("convenzione", convenzione);
			
			getServletConfig().getServletContext().getRequestDispatcher("/FirmaConvenzione.jsp").forward(request, response);
			
		}
		/*
		if(tipo.equals("confermaRichiesta")){
			
			//richiesta effettuata correttamente. Dispatcher ad un altra pagina
		}*/
		
	}

}
