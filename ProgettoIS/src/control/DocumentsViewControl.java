package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Azienda;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;


@WebServlet("/DocumentsViewControl")
public class DocumentsViewControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public DocumentsViewControl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * Prende la sessione dell'utente loggato e si ricava 
	 * @author Mario Procida , Anna Maria Rosanova
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		String tipo = (String) session.getAttribute("tipo");
		
		
		
		
		if(tipo.equals("Studente")) {
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			Studente s = studenteDao.getStudenteByEmail(email);
			
			String matricola = s.getMatricola();
		}
		
		else if(tipo.equals("Azienda")) {
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			
			Azienda a = aziendaDao.getAziendaByEmail(email);
			
			String partitaIva = a.getP_iva();
		}
		
		
	}

}
