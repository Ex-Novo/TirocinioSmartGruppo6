package control.gestioneFeedback;

import bean.Attivita;
import bean.Registro;

import dao.AttivitaDaoImpl;
import dao.AttivitaDaoInterface;
import dao.RegistroDaoImpl;
import dao.RegistroDaoInterface;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ConsultazioneRegistroControl.
 */

@WebServlet("/ConsultazioneRegistroControl")
public class ConsultazioneRegistroControl extends HttpServlet {
  private static final long serialVersionUID = 1L;
       

  public ConsultazioneRegistroControl() {
        super();
        // TODO Auto-generated constructor stub
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    String matricola = (String) session.getAttribute("matricola");
    
    RegistroDaoInterface regDao = new RegistroDaoImpl();
    Registro reg = regDao.getRegistroByMatricola(matricola);
    int idRegistro = reg.getIdRegistro();
    
    AttivitaDaoInterface attDao = new AttivitaDaoImpl();
    
    ArrayList<Attivita> activities = attDao.getAttivitaByIdRegistro(idRegistro);
    
    request.setAttribute("activities", activities);
    
    
    
    /* Reindirizza alla jsp dove verr� visualizzata la lista */
    getServletConfig().getServletContext()
    .getRequestDispatcher("/RegistroStudente.jsp").forward(request, response);
    
    
  }

}
