package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutControl() {
        super();
        
    }

	/**
	 * il metodo doGet prende la sessione dell'utente e la rimuove, rimuovendo anche gli attributi email e password associati.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.invalidate();
		
		out.println("Utente sloggato");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
