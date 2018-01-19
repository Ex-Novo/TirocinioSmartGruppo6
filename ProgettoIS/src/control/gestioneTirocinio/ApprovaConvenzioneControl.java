package control.gestioneTirocinio;

import bean.Convenzione;
import bean.Tirocinio;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;
import dao.TirocinioDaoImpl;
import dao.TirocinioDaoInterface;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ApprovaConvenzioneControl")
public class ApprovaConvenzioneControl extends HttpServlet {
  private static final long serialVersionUID = 1L;
       

  public ApprovaConvenzioneControl() {
        super();
        // TODO Auto-generated constructor stub
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doPost(request, response);
  }

  /**
   * Il metodo richiama i metodi dao
   * per cambiare lo stato della convenzione nel database
   * a seconda del tipo (accettata o rifiutata).
   * 
   * @author Mario Procida
   */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String tipo = request.getParameter("tipo");
    String piva = request.getParameter("piva");
    
    ConvenzioneDaoInterface convDao = new ConvenzioneDaoImpl();
    Convenzione conv = convDao.getConvenzione(piva);
    
    PrintWriter out = response.getWriter();
    
    // L'utente didattica ha premuto sul pulsate accetta e la convenzione viene approvata
    if (tipo.equals("accetta")) {
      
      convDao.approvazioneRichiestaConvenzione(piva);
      
      TirocinioDaoInterface tirDao = new TirocinioDaoImpl();
      
      Tirocinio tirocinio = new Tirocinio();
      tirocinio.setDescrizione(conv.getDescrizione());
      tirocinio.setNumPosti(conv.getNumPosti());
      tirocinio.setP_iva(piva);
      
      //crea il tirocinio nel database e in caso di successo ritorna true nella variabile "result"
      boolean result = tirDao.creaTirocinio(tirocinio);
      
      
      if (result) {
        out.println("<script>");
        out.println("alert('Richiesta convenzione approvata')");
        out.println("window.open('index.jsp','_self')");
        out.println("</script>");
      } else {
        out.println("<script>");
        out.println("alert('Si è verificato un errore')");
        out.println("window.history.back()");
        out.println("</script>");
      }
      
      
    }
    
    if (tipo.equals("rifiuta")) {
      
      boolean result = convDao.rifiutoRichiestaConvenzione(piva);
      
      if (result) {
        out.println("<script>");
        out.println("alert('Richiesta convenzione rifiutata')");
        out.println("window.open('index.jsp','_self')");
        out.println("</script>");
      } else {
        out.println("<script>");
        out.println("alert('Si è verificato un errore')");
        out.println("window.history.back()");
        out.println("</script>");
      }
    }
  }

}
