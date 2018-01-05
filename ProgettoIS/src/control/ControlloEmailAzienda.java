package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;

/**
 * Servlet per il controllo dell' univocità dell' email 
 * inserita dall'azienda in fase della registrazione
 */
@WebServlet("/ControlloEmailAzienda")
public class ControlloEmailAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlloEmailAzienda() {
        super();
        
    }

    /**
   	 *  controlla nel db la presenza di un' azienda
   	 *  che abbia la mail passata come parametro 
   	 *  
   	 *  @author Luca Lamberti , Simone Torluccio
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text");
		
		String risultato="";
 		String email=request.getParameter("email");
 		
 		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda azienda = new Azienda();
		
		azienda= aziendaDao.getAziendaByEmail(email);
		
		if(azienda== null){risultato="Email valida";}
		else{risultato="Email non  valida, gia' presente nel database";}
		
		response.getWriter().write(risultato);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
