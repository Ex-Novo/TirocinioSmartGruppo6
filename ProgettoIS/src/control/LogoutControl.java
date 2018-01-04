package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet che permette di effettuare il logout, teminando la sessione
 *
 */
@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutControl() {
        super();
        
    }

	/**
	 * il metodo doGet prende la sessione dell'utente e la rimuove, rimuovendo anche gli attributi email e password associati.
	 * 
	 * @author: Mario Procida
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.removeAttribute("tipoUtente");
		session.invalidate();
		
		out.println("Utente sloggato");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
