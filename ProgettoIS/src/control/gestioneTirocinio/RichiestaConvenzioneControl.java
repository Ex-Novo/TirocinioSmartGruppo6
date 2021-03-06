package control.gestioneTirocinio;

import bean.Azienda;
import bean.Convenzione;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet che permette ad una azienda non convenzionata
 * di effettuare la richiesta di convenzione.
 */

@WebServlet("/RichiestaConvenzioneControl")
public class RichiestaConvenzioneControl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String EMAIL_DIRETTORE = "fverdi@unisa.it"; 
    
  public RichiestaConvenzioneControl() {
        super();
        
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  
  /**
   * Questo metodo salva i valori della form nel Bean convenzione
   * e nel caso l'utente confermi la convenzione
   * salva i dati di quest'ultima nel database.
   * 
   * @author Luca Lamberti
     modifiche: Mario Procida
   */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
  
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");//email dell'azienda loggata
    String tipo = request.getParameter("tipo");
    
    PrintWriter out = response.getWriter();
    
    AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
    Azienda azienda = aziendaDao.getAziendaByEmail(email);
    
    //conferma del form per la richiesta di convenzione
    if (tipo.equals("confermaForm")) {
      
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date date = new Date();
      
      String piva = azienda.getP_iva();
      String stato = "in attesa";
      String dataConv = dateFormat.format(date);
      String dettaglioConv = request.getParameter("descrizione");
      String tutorAziendale = request.getParameter("tutorAziendale");
      int numPosti = Integer.parseInt(request.getParameter("numPosti"));
      
      
      Convenzione convenzione = new Convenzione();
      convenzione.setData(dataConv);
      convenzione.setStato(stato);
      convenzione.setDescrizione(dettaglioConv);
      convenzione.setP_iva(piva);
      convenzione.setTutorAziendale(tutorAziendale);
      convenzione.setNumPosti(numPosti);
      convenzione.setNomeFile("richiesta" + "_" + azienda.getNomeAzienda() + ".pdf");
      
      session.setAttribute("convenzione", convenzione);
      session.setAttribute("azienda", azienda);
      
      getServletConfig().getServletContext()
      .getRequestDispatcher("/FirmaConvenzione.jsp").forward(request, response);
      
    }
    
    /* Conferma della richiesta di convenzione
    dopo aver caricato il documento firmato salvando i dati nel database */
    
    if (tipo.equals("confermaRichiesta") && (boolean)session.getAttribute("fileUploaded")) {
      
      Convenzione convenzione = (Convenzione) session.getAttribute("convenzione");
      
      //salvo il tutor aziendale nel db
      aziendaDao.addTutorAziendale(convenzione.getTutorAziendale(), convenzione.getP_iva());
      
      ConvenzioneDaoInterface convenzioneDao = new ConvenzioneDaoImpl();
      
      boolean result = convenzioneDao
          .invioRichiestaConvenzione(convenzione, EMAIL_DIRETTORE,
              convenzione.getP_iva());//salva la convenzione del database
      
      session.removeAttribute("fileUploaded");
      
      
      //se la query � andata a buon fine
      if (result) {
        out.println("<script>");
        out.println("alert('Richiesta Effettuata')");
        out.println("window.open('index.jsp','_self')");
        out.println("</script>");
      } else {  //se la query non � andata a buon fine
        out.println("<script>");
        out.println("alert('Non � stato possibile effettuare la richiesta')");
        out.println("window.history.back()");
        out.println("</script>");
        
      }
      out.close();
    } else {
      out.println("<script>");
      out.println("alert('Non hai caricato il documento firmato. Non puoi inviare la richiesta')");
      out.println("window.history.back()");
      out.println("</script>");
    }
  }

}
