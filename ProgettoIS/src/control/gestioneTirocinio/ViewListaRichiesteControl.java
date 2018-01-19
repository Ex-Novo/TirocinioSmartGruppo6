package control.gestioneTirocinio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import bean.Convenzione;
import bean.RichiestaTirocinio;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.ConvenzioneDaoImpl;
import dao.RichiestaTirocinioDaoImpl;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

/**
 * Servlet usata per mandare alla jsp le richieste di tirocinio e di convenzione da visualizzare
 */
@WebServlet("/ViewListaRichiesteControl")
public class ViewListaRichiesteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListaRichiesteControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * Chiama due metodi dao per ricavare la lista completa di tutti gli studenti e aziende registrate al sistema
	 * 
	 * @author: Francesco D'Auria, Luca Lamberti
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RichiestaTirocinioDaoImpl richiesteTirocinioDAO = new RichiestaTirocinioDaoImpl();
		ConvenzioneDaoImpl richiesteConvenzioneDAO = new ConvenzioneDaoImpl();
		
		// Metodi DAO usati per ottenere gli ArrayList di richieste
		ArrayList<RichiestaTirocinio> listaRichiesteTirocinio = richiesteTirocinioDAO.getRichiesteTirocinio();
		ArrayList<Convenzione> listaRichiesteConvenzione = richiesteConvenzioneDAO.getRichiesteConvenzione();
		
		// Invio alle .jsp degli ArrayList tramite attributi
		
		request.setAttribute("listRichTirocinio", listaRichiesteTirocinio);
		request.setAttribute("listRichConvenzione", listaRichiesteConvenzione);
		
		/* Reindirizza alla jsp dove verrà visualizzata la lista */
		getServletConfig().getServletContext().getRequestDispatcher("/ListaRichieste.jsp").forward(request, response);
		
	}

}
