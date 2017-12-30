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
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda a = aziendaDao.getAziendaByEmail(email);
		String piva = request.getParameter("piva");
		
		TirocinioDaoInterface tirocinioDao = new TirocinioDaoImpl();
		Tirocinio tirocinio = tirocinioDao.getDettagliAziendeConvenzionate(piva);
		
		request.setAttribute("tirocinio", tirocinio);
		
		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/DettaglioAzienda.jsp").forward(request, response);
	}

}
