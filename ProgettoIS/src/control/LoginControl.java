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

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginControl() {
        super();
        
    }

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
			
			boolean logUser = studenteDao.loginUser(user);
			
			if(logUser){
			
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);         
				session.setAttribute("password",password);
				
			
				out.println("Loggato");
			
				//request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			else if(!logUser){
				
				
				out.println("No");
			}
		}
		
        if(tipo.equals("Azienda")){
			
            Azienda user = new Azienda();
			
			user.setEmail(email);
			user.setPassword(password);
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			
			boolean logUser = aziendaDao.loginUser(user);
			
			if(logUser){
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);         
				session.setAttribute("password",password);
				
			
				out.println("Loggato");
				
			}
			
			else{
				out.println("No");
			}
		}
        
        if(tipo.equals("Didattica")){
        	Didattica user = new Didattica();

        	user.setEmail(email);
        	user.setPassword(password);

        	DidatticaDaoInterface didatticaDao = new DidatticaDaoImpl();

        	boolean logUser = didatticaDao.loginUser(user);

        	if(logUser){
        		HttpSession session = request.getSession(true);
        		session.setAttribute("email", email);         
        		session.setAttribute("password",password);


        		out.println("Loggato");

        	}

        	else{
        		out.println("No");
        	}
		}
		
		
	}

}
