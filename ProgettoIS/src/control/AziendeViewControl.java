package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.StudenteDaoImpl;

/**
 * Servlet implementation class AziendeViewControl
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
		ArrayList<Azienda> aziende = aziendaDAO.getAziendeConvenzionate();		
		request.setAttribute("aziendeConvenzionate", aziende);
		
		
		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/AziendeView.jsp").forward(request, response);
		
	}

}
