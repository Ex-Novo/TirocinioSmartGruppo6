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
import bean.RichiestaTirocinio;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;

/**
 * Servlet implementation class RichiestaTirocinioControl
 */
@WebServlet("/RichiestaTirocinioControl")
public class RichiestaTirocinioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiestaTirocinioControl() {
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
		
		
		//if(submit.equals("confermaForm")){
			RichiestaTirocinioDaoInterface richiestaTirocinioDAO = new RichiestaTirocinioDaoImpl();
			RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();
			
			/*
			 * Flusso dell'USE CASE:
			 * 
			1	Utente:	È intenzionato a inoltrare una richiesta di tirocinio
				e clicca sul pulsante “Richiesta Tirocinio” presente nella pagina dei dettagli dell’azienda.
			2	Sistema:	Mostra le informazioni riguardo il tirocinio e l’azienda scelta e un campo dove immettere il nome del tutor accademico scelto. (MU_GT_1)
			3	Utente:	Compila il campo con il nome del tutor accademico secondo il formato consentito e clicca su conferma scelta.
			4	Sistema:	Mostra una pagina dove poter scaricare il documento precompilato e poterlo ricaricare e confermare la richiesta. Il pulsante per confermare la richiesta verrà visualizzato solo in caso in cui lo studente avrà caricato un documento valido.
			5	Utente:	Carica il documento firmato e clicca sul pulsante per confermare.
			6	Sistema:	Il sistema salva i dati della richiesta di tirocinio e imposta il suo status in “in sospeso”. Notifica l’utente dell’operazione riuscita e lo reindirizza nella home studente.
			 */
			
									/* */
			
			/* Servono i seguenti dati per creare una richiesta di tirocinio:
			 * 
			 * idRichiestaTirocinio: intero (autogenerato ?)
			 * 
			 * nomeTutorAccademico: lo inserisce lo studente nella form
			 * 
			 * status: "in attesa", visto che viene appena creata
			 * 
			 * dataInvio: va presa con request.getParameter della data
			 * 
			 *  emailTutorAccademico:
			 * 				dobbiamo prendere la mail dal nome del tutor accademico inserito
			 * 
			 * emailDIrettore: dovrebbe essere vuoto, sarà poi riempito quando verrà
			 * 			accettata la richiesta (indica quale direttore accetta la richiesta (?))
			 * 
			 * matricola: la prendiamo dalla sessione dello studente loggato
			 * 
			 * idTirocinio: dobbiamo prenderlo da (?)
			 * 
			 */
			
			
			
			// Valori inseriti da parte dello studente
			String tutorAccademico = (String) request.getAttribute("nomeTutorAccademico");
			
			// Matricola dello studente loggato
			String matricola = (String) session.getAttribute("matricola");
			
			// Valore creato di default, usato quando si crea una nuova richiesta di tirocinio
			String status="in attesa";	
			
		
			
			richiestaTirocinio.setStatus(status);
			richiestaTirocinio.setNomeTutorAccademico(tutorAccademico);
			richiestaTirocinio.setMatricola(matricola);

			 


			
			richiestaTirocinioDAO.invioRichiestaTirocinio(richiestaTirocinio);//Invia la richiesta di tirocinio
			getServletConfig().getServletContext().getRequestDispatcher("/FirmaConvenzione.jsp").forward(request, response);
			
	//	}
		//if(submit.equals("confermaForm")){
			
			//richiesta effettuata correttamente. Dispatcher ad un altra pagina
	//	}
	
		
		
	}

}
