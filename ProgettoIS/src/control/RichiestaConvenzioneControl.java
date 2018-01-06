package control;

import java.io.IOException;
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
		
		//if(submit.equals("confermaForm")){
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			Azienda azienda = aziendaDao.getAziendaByEmail(email);

			String piva=azienda.getP_iva();
			String stato="in attesa";
			String dataConv = request.getParameter("dataConvenzione");
			String dettaglioConv = request.getParameter("descrizione");
			String tutorAziendale= request.getParameter("tutorAziendale");
			int numPosti = Integer.parseInt( request.getParameter("numPosti"));

			aziendaDao.addTutorAziendale(tutorAziendale, piva);//salvo il tutor aziendale nel db

			Convenzione convenzione= new Convenzione();
			convenzione.setData(dataConv);
			convenzione.setStato(stato);
			convenzione.setDescrizione(dettaglioConv);
			convenzione.setP_iva(piva);
			convenzione.setTutorAziendale(tutorAziendale);
			convenzione.setNumPosti(numPosti);

			ConvenzioneDaoInterface convenzioneDao = new ConvenzioneDaoImpl();
			convenzioneDao.invioRichiestaConvenzione(convenzione, EMAIL_DIRETTORE, piva);
			getServletConfig().getServletContext().getRequestDispatcher("/FirmaConvenzione.jsp").forward(request, response);
			
	//	}
		//if(submit.equals("confermaForm")){
			
			//richiesta effettuata correttamente. Dispatcher ad un altra pagina
	//	}
		
	}

}
