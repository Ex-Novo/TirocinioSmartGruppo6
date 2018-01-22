package control.gestioneDocumenti;

import bean.Azienda;
import bean.Convenzione;
import bean.RichiestaTirocinio;
import bean.Studente;
/*
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;*/

import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.PdfCreator;
import util.PdfCreatorAdapter;
import util.PdfCreator;

/**
 * La servlet gestisce i vari tipi di download dei documenti,
 * sia generandoli sia scaricando i documenti già caricati nel server
 * appartenenti ai singoli utenti.
 */

/**
 * Servlet implementation class DownloadControl.
 */

@WebServlet("/DownloadControl")
public class DownloadControl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  
  
  public DownloadControl() {
        super();
  }
    

  /**
   * Questo metodo permette di scaricare il documento
   * salvato dall'utente o il documento pdf della richiesta auto generato.
   * 
   * @author Mario Procida
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
     
    String filename = request.getParameter("filename");
    String tipo = request.getParameter("tipo");
     
     
    //per scaricare la richiesta di convenzione dell'azienda
    if (tipo.equals("tirocinio")) {
       
      String matricola = request.getParameter("matricola");
      StudenteDaoInterface sDao = new StudenteDaoImpl();
      Studente studente = sDao.getStudenteByMatricola(matricola);
       
      String uniqueID = studente.getUniqueID();
       
      String rootPath =  getServletContext().getInitParameter("fsroot");
       
      response.setContentType("application/pdf");
        
      response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\""  );
           
      File my_file = new File(rootPath + File.separator
          + uniqueID + File.separator + filename);
        
      OutputStream out = response.getOutputStream();
      FileInputStream in = new FileInputStream(my_file);
      byte[] buffer = new byte[4096];
      int length;
      while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
      }
      
      in.close();
      out.flush();
    }
     
    //per scaricare la richiesta di convenzione dell'azienda
    if (tipo.equals("convenzione")) {
       
      String piva = request.getParameter("piva");
      AziendaDaoInterface azDao = new AziendaDaoImpl();
      Azienda azienda = azDao.getAziendaBypiva(piva);
       
      String uniqueID = azienda.getUniqueID();
       
      String rootPath =  getServletContext().getInitParameter("fsroot");
       
      response.setContentType("application/pdf");
        
      response.setHeader("Content-disposition","attachment; filename=\""
          + filename + "\"");
           
      File my_file = new File(rootPath + File.separator +
          uniqueID + File.separator + filename);
        
      OutputStream out = response.getOutputStream();
      FileInputStream in = new FileInputStream(my_file);
      byte[] buffer = new byte[4096];
      int length;
      while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
      }
      
      in.close();
      out.flush();
    }
     
    //per scaricare il file presente nella cartella dell'utente
    if (tipo.equals("myFile")) {
       
      String uniqueID = (String) session.getAttribute("uniqueID");
      String rootPath =  getServletContext().getInitParameter("fsroot");
          
      response.setContentType("application/pdf");
  
      response.setHeader("Content-disposition","attachment; filename=\""
          + filename + "\"");
       
      File my_file = new File(rootPath + File.separator
            + uniqueID + File.separator + filename);
  
      OutputStream out = response.getOutputStream();
      FileInputStream in = new FileInputStream(my_file);
      byte[] buffer = new byte[4096];
      int length;
      while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
      }
      
      in.close();
      out.flush();
    }
     
    //per generare il pdf dalle informazioni della form di richiesta convenzione
    if (tipo.equals("firmaConvenzione")) {
       
      String logo = getServletContext().getInitParameter("fsroot") + "/img/logoDipartimento.jpg";
       
      Convenzione conv = (Convenzione) session.getAttribute("convenzione"); 
      Azienda azienda = (Azienda) session.getAttribute("azienda");
       
      response.setContentType("application/pdf");
      response.setHeader("Content-disposition","attachment; filename = richiesta\""
          + azienda.getNomeAzienda() + ".pdf");
       
      OutputStream out = response.getOutputStream();
      
      PdfCreator pdfCreator = new PdfCreatorAdapter();
      
      ByteArrayOutputStream baos = pdfCreator.creaPdfConv(azienda.getNomeAzienda(), azienda.getP_iva(),
            conv.getDescrizione(), "" + conv.getNumPosti(), conv.getData(), logo);
      
      response.setContentLength(baos.size());
      
      
      baos.writeTo(out);
      out.flush();
      out.close();
      
      /* 
      //font da utilizzare
      Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD,
          new BaseColor(0, 0, 0)); 
      
      Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC,
          new BaseColor(0, 0, 0)); 
      
      Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12,Font.BOLD); 
       
      Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
      
      try {   
          
        //proprietà header
        doc.addAuthor("utente");
        doc.addCreationDate();
        doc.addProducer();
        doc.addCreator("TirocinioSmart");
        doc.addTitle("Richiesta");
        doc.setPageSize(PageSize.LETTER);
        doc.open();
          
        //aggiunta paragraph 
        Image logoDip = Image.getInstance(logo);
        logoDip.setAlignment(logoDip.MIDDLE);
        doc.add(logoDip);
          
        Paragraph dipInf = new Paragraph("Università degli Studi di Salerno -"
            + "Dipartimento di Informatica", bfBold12);
        dipInf.setAlignment(dipInf.ALIGN_CENTER);
        doc.add(dipInf);
          
        Paragraph title = new Paragraph("Dati Richiesta di Convenzione", bfBold18);
        title.setAlignment(title.ALIGN_CENTER);
          
        doc.add(title);
          
        doc.add(new Paragraph("Nome Azienda:  " + azienda.getNomeAzienda(), bf12));
        
        doc.add(new Paragraph("Partita Iva:  " + azienda.getP_iva(), bf12));
        
        doc.add(new Paragraph("Descrizione Tirocinio:  "
            + conv.getDescrizione(), bf12));
        
        doc.add(new Paragraph("Numeri Posti Tirocinio:  "
            + conv.getNumPosti(), bf12));
        doc.add(new Paragraph("Data:  " + conv.getData(),bf12));
          
        Paragraph firma = new Paragraph("Firma:", bf12);
        firma.setAlignment(firma.ALIGN_BOTTOM);
        firma.setAlignment(firma.ALIGN_RIGHT);
        doc.add(firma);
          
        doc.close(); 
          
          
      } catch (DocumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       
      */
    }
    
    //per generare il pdf dalle informazioni della form di richiesta convenzione
    if (tipo.equals("firmaTirocinio")) {
       
      String logo = getServletContext().getInitParameter("fsroot") + "/img/logoDipartimento.jpg";
       
      RichiestaTirocinio rTirocinio = (RichiestaTirocinio) session
          .getAttribute("rTirocinio");
      
      Studente studente = (Studente) session.getAttribute("studente");
       
      String nomeAzienda = (String) session.getAttribute("nomeAz");
       
      response.setContentType("application/pdf");
      response.setHeader("Content-disposition","attachment; filename = richiesta\""
          + studente.getNome() + studente.getCognome() + ".pdf");
       
      OutputStream out = response.getOutputStream();
      
      PdfCreator pdfCreator = new PdfCreatorAdapter();
      
      ByteArrayOutputStream baos = pdfCreator.creaPdfTir(studente.getNome(), studente.getCognome(),
          studente.getMatricola(), nomeAzienda,rTirocinio.getNomeTutorAccademico(), rTirocinio.getData(), logo);
      
      response.setContentLength(baos.size());
      
      baos.writeTo(out);
      out.flush();
      out.close();
      
      /* 
      //font da utilizzare
      Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD,
            new BaseColor(0, 0, 0));
      
      Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC,
            new BaseColor(0, 0, 0)); 
      Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12,Font.BOLD); 
       
      Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
      try {
         
        PdfWriter writer = PdfWriter.getInstance(doc, out); 
          
        //proprietà header
        doc.addAuthor("utente");
        doc.addCreationDate();
        doc.addProducer();
        doc.addCreator("TirocinioSmart");
        doc.addTitle("Richiesta");
        doc.setPageSize(PageSize.LETTER);
        doc.open();
          
        //aggiunta paragraph
        Image logoDip = Image.getInstance(logo);
        logoDip.setAlignment(logoDip.MIDDLE);
        doc.add(logoDip);
          
        Paragraph dipInf = new Paragraph("Università degli Studi di Salerno -"
            + "Dipartimento di Informatica", bfBold12);
        
        dipInf.setAlignment(dipInf.ALIGN_CENTER);
        doc.add(dipInf);
          
        Paragraph title = new Paragraph("Dati Richiesta di Tirocinio", bfBold18);
        title.setAlignment(title.ALIGN_CENTER);
        doc.add(title);
          
        doc.add(new Paragraph("Nome:  " + studente.getNome(), bf12));
        doc.add(new Paragraph("Cognome:  " + studente.getCognome(), bf12));
        doc.add(new Paragraph("Matricola: " + studente.getMatricola(), bf12));
        doc.add(new Paragraph("Nome azienda scelta che offre il tirocinio:  " + nomeAzienda, bf12));
        doc.add(new Paragraph("Tutor Accademico scelto:  "
            + rTirocinio.getNomeTutorAccademico(), bf12));
        
        doc.add(new Paragraph("Data:  " + rTirocinio.getData(),bf12));
          
        Paragraph firma = new Paragraph("Firma:", bf12);
        firma.setAlignment(firma.ALIGN_BOTTOM);
        firma.setAlignment(firma.ALIGN_RIGHT);
        doc.add(firma);
          
        doc.close(); 
          
          
      } catch (DocumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       */
      
    }

  }



  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    doGet(request, response);
  }

}
