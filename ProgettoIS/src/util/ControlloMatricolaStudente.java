package util;

import bean.Studente;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet per il controllo dell' univocità della matricola 
 * inserita dallo studente in fase della registrazione.
 */
@WebServlet("/ControlloMatricolaStudente")
public class ControlloMatricolaStudente extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    
  public ControlloMatricolaStudente() {
      super();

  }

  /**
   *  controlla nel db la presenza di uno studente
   *  che abbia la matricola passata come parametro.
   *  
   *  @author Luca Lamberti , Simone Torluccio
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text");
    
    String risultato = "";
    String matricola = request.getParameter("matricola");
    
    StudenteDaoInterface studenteDao = new StudenteDaoImpl();
    Studente studente = new Studente();
    
    studente = studenteDao.getStudenteByMatricola(matricola);
    
    if (studente.getMatricola() != null && studente.getMatricola().equals(matricola)) {
      
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
