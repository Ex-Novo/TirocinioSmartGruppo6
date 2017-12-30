package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Studente;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;


@WebServlet("/ViewProfileControl")
public class ViewProfileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewProfileControl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String tipoUtente = (String) session.getAttribute("tipoUtente");
		String email = (String) session.getAttribute("email");
		
		Studente user = new Studente();
		
		if(tipoUtente.equals("Studente")){
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			user = studenteDao.getStudenteByEmail(email);    //istanzia il bean restituito dal metodo del dao
			
			request.setAttribute("beanStudente", user); //
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
