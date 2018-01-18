package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Azienda;
import bean.Feedback;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.FeedBackDaoImpl;
import dao.FeedBackDaoInterface;
import dao.StudenteDaoImpl;

/**
 * Servlet che contiene il metodo doPost che recupera le aziende convenzionate dal database
 * e le inoltra alla jsp AziendeView come attributo
 */
@WebServlet("/AziendeViewControl")
public class AziendeViewControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AziendeViewControl() {
       
    	super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	/**Il metodo chiama il metodo del dao dell'azienda per restituire un array di aziende convenzionate
	 * 
	 * @author: Luca Lamberti
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AziendaDaoInterface aziendaDAO = new AziendaDaoImpl();
		ArrayList<Azienda> aziende = aziendaDAO.getAziendeConvenzionate();		
		
		request.setAttribute("aziendeConvenzionate", aziende);

		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/AziendeView.jsp").forward(request, response);
		
	}

}
