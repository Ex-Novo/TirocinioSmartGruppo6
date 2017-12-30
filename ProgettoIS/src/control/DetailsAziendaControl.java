package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Azienda;
import bean.Tirocinio;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

/**
 * Servlet implementation class DetailsAziendaControl
 */
@WebServlet("/DetailsAziendaControl")
public class DetailsAziendaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DetailsAziendaControl() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	/**Il metodo prende come parametro la partita iva e l'email dell'azienda convenzionata selezionata per poi chiamare i metodi
	 * del dao del tirocinio associato all'azienda. Il metodo restituisce un bean di tirocinio e azienda.
	 * 
	 * @author: Luca Lamberti
	 * modifiche: Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String piva = request.getParameter("piva");
		String email = request.getParameter("email");
		
		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda a = aziendaDao.getAziendaByEmail(email);
		
		request.setAttribute("azienda", a);
		
		TirocinioDaoInterface tirocinioDao = new TirocinioDaoImpl();
		Tirocinio tirocinio = tirocinioDao.getDettagliAziendeConvenzionate(piva);
		
		request.setAttribute("tirocinio", tirocinio);
		
		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/DettaglioAzienda.jsp").forward(request, response);
	}

}
