package control.gestioneDocumenti;

import bean.Azienda;
import bean.Documento;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.DocumentoDaoImpl;
import dao.DocumentoDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/DocumentsViewControl")
public class DocumentsViewControl extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  
  public DocumentsViewControl() {
        super();
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doPost(request,response);
  }

  /**
   * Prende la sessione dell'utente loggato
   * e si ricava la lista dei documenti caricati dai metodi chiama nel dao.
   * @author Mario Procida , Anna Maria Rosanova
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    String email = (String) session.getAttribute("email");
    String tipo = (String) session.getAttribute("tipoUtente");
    
    ArrayList<Documento> documenti = new ArrayList<Documento>();
    DocumentoDaoInterface docDao = new DocumentoDaoImpl();
    
    if (tipo.equals("Studente")) {
      
      StudenteDaoInterface studenteDao = new StudenteDaoImpl();
      Studente s = studenteDao.getStudenteByEmail(email);
      String matricola = s.getMatricola();
      
      documenti = docDao.getDocumenti(matricola);
        
    }  else if (tipo.equals("Azienda")) {
      
      AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
      Azienda a = aziendaDao.getAziendaByEmail(email);
      String piva = a.getP_iva();
      
      documenti = docDao.getDocumenti(piva);
      
    }
    
    request.setAttribute("documenti", documenti);
    
    getServletConfig().getServletContext()
    .getRequestDispatcher("/DocumentsView.jsp").forward(request, response);
    
    
  }

}
