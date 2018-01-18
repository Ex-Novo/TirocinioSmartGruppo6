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
import bean.RichiestaTirocinio;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

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
	 * 	/**
	 * Questo metodo salva i valori della form nel Bean richiesta tirocinio e nel caso l'utente confermi la richiesta salva i dati di quest'ultima nel database.
	 * 
	 * @author Luca Lamberti,  Mario Procida, Francesco Maria D'auria
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");//email dello studente loggata
			String tipo = request.getParameter("tipo");
			
			PrintWriter out =response.getWriter();
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			Studente studente = studenteDao.getStudenteByEmail(email);
			
			//conferma del form per la richiesta di convenzione
			if(tipo.equals("confermaForm")){
				
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				
				String matricola=studente.getMatricola();
				String stato ="in attesa";
				String dataTirocinio = dateFormat.format(date);
				String tutorAccademico = request.getParameter("tutorAccademico");
				int idTirocinio = (int) session.getAttribute("idTirocinio");
				
				RichiestaTirocinio rTirocinio = new RichiestaTirocinio();
				rTirocinio.setData(dataTirocinio);
				rTirocinio.setEmailTutAcc("mrossi@unisa.it");
				rTirocinio.setEmailDir("grusso@unisa.it");
				rTirocinio.setMatricola(matricola);
				rTirocinio.setNomeTutorAccademico(tutorAccademico);
				rTirocinio.setStatus(stato);
				rTirocinio.setIdTirocinio(idTirocinio);
				rTirocinio.setNomeFile("richiesta" + "_" + studente.getNome() + studente.getCognome() + ".pdf");
				
				session.setAttribute("rTirocinio", rTirocinio);
				session.setAttribute("studente", studente);
				
				getServletConfig().getServletContext().getRequestDispatcher("/FirmaTirocinio.jsp").forward(request, response);
				
			}
			
			//Conferma della richiesta di tirocinio dopo aver caricato il documento firmato salvando i dati nel database
			if(tipo.equals("confermaRichiesta") && (boolean)session.getAttribute("fileUploaded")){
				
				RichiestaTirocinio rTirocinio = (RichiestaTirocinio) session.getAttribute("rTirocinio");
				
				
				RichiestaTirocinioDaoInterface rTirocinioDao = new RichiestaTirocinioDaoImpl();
				boolean result = rTirocinioDao.invioRichiestaTirocinio(rTirocinio);//salva la richiesta di tirocinio del database
				
				session.setAttribute("fileUploaded",false);
				
				
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
			}else if(tipo.equals("confermaRichiesta") && !(boolean)session.getAttribute("fileUploaded")){
				out.println("<script>");
				out.println("alert('Non hai caricato il documento firmato. Non puoi inviare la richiesta')");
				out.println("window.history.back()");
				out.println("</script>");
			}
		
		
	}

}
