package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Studente;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

/**
 * Servlet per il controllo dell' univocità dell' email 
 * inserita dallo studente in fase della registrazione
 */
@WebServlet("/ControlloEmailStudente")
public class ControlloEmailStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControlloEmailStudente() {
        super();
        
    }

    /**
	 *  controlla nel db la presenza di uno studente
	 *  che abbia la mail passata come parametro 
	 *  
	 *  @author Luca Lamberti , Simone Torluccio
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text");
		
		String risultato="";
 		String email=request.getParameter("email");
 		
 		StudenteDaoInterface studenteDao = new StudenteDaoImpl();
		Studente studente = new Studente();
		
		studente = studenteDao.getStudenteByEmail(email);
		
		if(studente.getEmail().equals(email)){
			
			risultato="Email non  valida, gia' presente nel database";
	    }
		
		response.getWriter().write(risultato);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
