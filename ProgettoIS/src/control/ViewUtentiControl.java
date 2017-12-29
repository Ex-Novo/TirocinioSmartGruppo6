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
import dao.StudenteDaoImpl;

/**
 * Servlet implementation class ViewUtentiControl
 */
@WebServlet("/ViewUtentiControl")
public class ViewUtentiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUtentiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		ArrayList<Azienda> aziende = aziendaDAO.getAziende();
		ArrayList<Studente> studenti = studenteDAO.getStudenti();
		
		request.setAttribute("aziende", aziende);
		request.setAttribute("studenti", studenti);
		
		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/ListaUtenti.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
