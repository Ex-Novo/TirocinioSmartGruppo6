package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.DidatticaDaoImpl;
import dao.DidatticaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

import bean.Studente;
import bean.Azienda;
import bean.Didattica;

/**
 * Servlet che permette il login e la creazione della sessione
 * in base al tipo di utente
 *
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginControl() {
        super();
        
    }

    /**
     * Prende il tipo di utente che vuole loggarsi e a seconda del tipo istanzia il bean e il dao e esegui la query. 
     * Ritorna true se il login avviene con successo.
     * 
     * @author: Mario Procida, Luca Lamberti, 
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("Studente")){
			
			Studente user = new Studente();
			
			user.setEmail(email);
			user.setPassword(password);
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			boolean logUser = studenteDao.loginUser(user); //true se la query è andata a buon fine
			
			user = studenteDao.getStudenteByEmail(email);
			
			String uniqueID = user.getUniqueID();
			String matricola = user.getMatricola();
			
			if(logUser){
			    
				// creazione della sessione utente
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);         
				session.setAttribute("password",password);
				session.setAttribute("uniqueID", uniqueID);
				session.setAttribute("matricola", matricola);
				session.setAttribute("tipoUtente", "Studente");
				session.setAttribute("fileUploaded", false);
				session.setAttribute("canRequest", false);
				session.setAttribute("canFeed", false);
				session.setMaxInactiveInterval(600); //tempo di inattività massimo prima del logout = 10 minuti
				
				
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Accesso effettuato');");
			    out.println("location='index.jsp';");
			    out.println("</script>");
					
			
				
			}
			
			else if(!logUser){ // login errato
				
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Credenziali errate')");
				out.println("window.history.back()");
				out.println("</script>");
			}
		}
		
        if(tipo.equals("Azienda")){
			
            Azienda user = new Azienda();
			
			user.setEmail(email);
			user.setPassword(password);
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			boolean logUser = aziendaDao.loginUser(user); //true se la query è andata a buon fine
			
			user = aziendaDao.getAziendaByEmail(email);
			String uniqueID = user.getUniqueID();
			String piva = user.getP_iva();
			
			if(logUser){
				
				// creazione della sessione utente
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);         
				session.setAttribute("password",password);
				session.setAttribute("uniqueID", uniqueID);
				session.setAttribute("piva", piva);
				session.setAttribute("tipoUtente", "Azienda");
				session.setMaxInactiveInterval(600); //tempo di inattività massimo prima del logout = 10 minuti
				
			
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Accesso effettuato');");
			    out.println("location='index.jsp';");
			    out.println("</script>");
				
			}
			
			else{ //login errato
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Credenziali errate')");
				out.println("window.history.back()");
				out.println("</script>");
			}
		}
        
        if(tipo.equals("Didattica")){
        	Didattica user = new Didattica();

        	user.setEmail(email);
        	user.setPassword(password);

        	DidatticaDaoInterface didatticaDao = new DidatticaDaoImpl();

        	boolean logUser = didatticaDao.loginUser(user); //true se la query è andata a buon fine

        	if(logUser){
        		
        		// creazione della sessione utente
        		HttpSession session = request.getSession(true);
        		session.setAttribute("email", email);         
        		session.setAttribute("password",password);
        		session.setAttribute("tipoUtente", "Didattica");
        		session.setMaxInactiveInterval(600); //tempo di inattività massimo prima del logout = 10 minuti
        		
        		out.println("<script type=\"text/javascript\">");
			    out.println("alert('Accesso effettuato');");
			    out.println("location='index.jsp';");
			    out.println("</script>");
        	}

        	else{ //login errato
        		out.println("<script type=\"text/javascript\">");
				out.println("alert('Credenziali errate')");
				out.println("window.history.back()");
				out.println("</script>");
        	}
		}
		
        out.flush();
        out.close();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
