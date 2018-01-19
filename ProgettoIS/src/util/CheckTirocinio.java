package util;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * La servlet controlla se è già presente nel database 
 * una richiesta di tirocinio da parte dello studente.
 */
@WebServlet("/CheckTirocinio")
public class CheckTirocinio extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  
  public CheckTirocinio() {
      super();
      
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request,response);
  }

  /**
   * Prende come parametro la matricola dello studente e richiama un metodo dao 
   * per eseguire una query e controllare se è già presente una richiesta di tirocinio nel database.
   * 
   * @author Mario Procida
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();

    String matricola = (String) session.getAttribute("matricola");
    String nomeAzienda = request.getParameter("nomeAz");
  
    int idTirocinio = Integer.parseInt(request.getParameter("t"));

    RichiestaTirocinioDaoInterface rTirocinioDao = new RichiestaTirocinioDaoImpl();
    
    //ritorna true se trova la richiesta di tirocinio
    RichiestaTirocinio richTir = rTirocinioDao.getRichTirocinio(matricola); 

    PrintWriter out = response.getWriter();
    if (richTir.getMatricola() != null && richTir.getStatus().equals("in attesa")) {
      
      session.setAttribute("canRequest", false);
      
      out.println("<script>");
      out.println("alert('Hai gia richiesto un tirocinio.Si prega di attendere una risposta.')");
      out.println("window.history.back()");
      out.println("</script>");
    } else if (richTir.getMatricola() != null && richTir.getStatus().equals("rifiutata")) {
      session.setAttribute("canRequest", true);
      session.setAttribute("idTirocinio", idTirocinio);
      session.setAttribute("nomeAz", nomeAzienda);
      out.println("<script>");
      out.println("alert('La precedente richiesta di tirocinio che hai effettuato "
          + "e stata rifiutata.Puoi effettuarne un altra."
          + " Per chiarimenti contattare la didattica')");
      out.println("window.open('RichiestaTirocinio.jsp','_self')");
      out.println("</script>");
  
    } else if (richTir.getMatricola() != null && richTir.getStatus().equals("approvata")) {
      session.setAttribute("canRequest", false);
      out.println("<script>");
      out.println("alert('Impossibile effettuare la richiesta."
          + " Richiesta di tirocinio gia inviata ed approvata')");
      out.println("window.history.back()");
      out.println("</script>");
    } else {
      session.setAttribute("canRequest", true);
      session.setAttribute("idTirocinio", idTirocinio);
      session.setAttribute("nomeAz", nomeAzienda);
      out.println("<script>");
      out.println("window.open('RichiestaTirocinio.jsp','_self')");
      out.println("</script>");
    }
    
    out.flush();
    out.close();
  }

}
