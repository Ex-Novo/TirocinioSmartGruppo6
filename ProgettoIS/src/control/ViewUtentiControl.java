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
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;


@WebServlet("/ViewUtentiControl")
public class ViewUtentiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewUtentiControl() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
		
	}

	/**
	 * Chiama due metodi dao per ricavare la lista completa di tutti gli studenti e aziende registrate al sistema
	 * 
	 * @author: Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AziendaDaoInterface aziendaDAO = new AziendaDaoImpl();
		StudenteDaoInterface studenteDAO = new StudenteDaoImpl();
		
		ArrayList<Azienda> aziende = aziendaDAO.getAziende();
		ArrayList<Studente> studenti = studenteDAO.getStudenti();
		
		out.println("Numero aziende =" + aziende.size());
		
		request.setAttribute("aziende", aziende);
		request.setAttribute("studenti", studenti);
		
		/* Reindirizza alla jsp dove visualizza la lista */
		getServletConfig().getServletContext().getRequestDispatcher("/ListaUtenti.jsp").forward(request, response);
		
	}

}
