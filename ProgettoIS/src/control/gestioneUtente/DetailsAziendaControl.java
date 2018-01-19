package control.gestioneUtente;

import bean.Azienda;
import bean.Feedback;
import bean.Tirocinio;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.FeedBackDaoImpl;
import dao.FeedBackDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet che recupera le informazioni del tirocinio dell'azienda e
 * le inoltra alla jsp DettaglioAzienda. 
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

  
  /**Il metodo prende come parametro la partita iva e l'email dell'azienda
   * convenzionata selezionata per poi chiamare i metodi
   * del dao del tirocinio associato all'azienda. Il metodo restituisce un bean di tirocinio.
   * 
   * @author: Luca Lamberti
    modifiche: Mario Procida
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String piva = request.getParameter("piva");
    String email = request.getParameter("email");
    
    AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
    Azienda a = aziendaDao.getAziendaByEmail(email);
    
    request.setAttribute("azienda", a);
    
    TirocinioDaoInterface tirocinioDao = new TirocinioDaoImpl();
    Tirocinio tirocinio = tirocinioDao.getDettagliAziendeConvenzionate(piva);
    
    FeedBackDaoInterface fbDao = new FeedBackDaoImpl();
    ArrayList<Feedback> feedBacks = fbDao.getFeedBacksAzienda(piva);
    
    double valutazione = 0;
    for (int i =  0; i < feedBacks.size(); i++) {
      
      valutazione = valutazione + feedBacks.get(i).getValutazioneAzienda();
      
    }
    
    valutazione = valutazione / feedBacks.size();
    
    request.setAttribute("tirocinio", tirocinio);
    request.setAttribute("valutazione", valutazione);
    
    /* Crea lista */
    getServletConfig().getServletContext()
      .getRequestDispatcher("/DettaglioAzienda.jsp").forward(request, response);
  }

}
