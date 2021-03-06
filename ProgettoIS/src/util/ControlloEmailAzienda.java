package util;

import bean.Azienda;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet per il controllo dell' univocitÓ dell' email 
 * inserita dall'azienda in fase della registrazione.
 */
@WebServlet("/ControlloEmailAzienda")
public class ControlloEmailAzienda extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  public ControlloEmailAzienda() {
      super();
        
  }

  /**
   *  Controlla nel db la presenza di un' azienda
   *  che abbia la mail passata come parametro .
   *  
   *  @author Luca Lamberti , Simone Torluccio
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text");
    
    String risultato = "";
    String email = request.getParameter("email");
    
    AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
    Azienda azienda = new Azienda();
    
    azienda = aziendaDao.getAziendaByEmail(email);
    
    if (azienda.getEmail() != null && azienda.getEmail().equals(email)) {
      
      risultato = "no";
      
    } else {
      risultato = "si";
    }
    
    response.getWriter().write(risultato);
      
    
  }

  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
