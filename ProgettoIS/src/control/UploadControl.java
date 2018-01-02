package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Studente;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

@WebServlet("/UploadControl")
@MultipartConfig
public class UploadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadControl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * Il
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String tipo = (String) session.getAttribute("tipoUtente");
		
		String filename = request.getParameter("nome");
		
		
		if(tipo.equals("Studente")) {
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			Studente user = studenteDao.getStudenteByEmail(email);
			
			String uniqueID = user.getUniqueID();
			
			
		}
	}

}
