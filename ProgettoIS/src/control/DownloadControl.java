package control;

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

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import bean.Azienda;
import bean.Convenzione;
import bean.RichiestaTirocinio;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;
/**
 * La servlet gestisce i vari tipi di download dei documenti, sia generandoli sia scaricando i documenti già caricati nel server appartenenti ai singoli utenti.
 */

/**
 * Servlet implementation class DownloadControl
 */
@WebServlet("/DownloadControl")
public class DownloadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Questo metodo permette di scaricare il documento salvato dall'utente o il documento pdf della richiesta auto generato
	 * 
	 * @author Mario Procida
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 
		 String filename = request.getParameter("filename");
		 String tipo = request.getParameter("tipo");
		 
		 
		//per scaricare la richiesta di convenzione dell'azienda
		 if(tipo.equals("tirocinio")) {
			 
			 String matricola = request.getParameter("matricola");
			 StudenteDaoInterface sDao = new StudenteDaoImpl();
			 Studente studente = sDao.getStudenteByMatricola(matricola);
			 
			 String uniqueID = studente.getUniqueID();
			 
			 String rootPath =  getServletContext().getInitParameter("fsroot");
			 
			 response.setContentType("application/pdf");
				
	         response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\""  );
	         
	         File my_file = new File(rootPath + File.separator + uniqueID + File.separator + filename);
	     	
	         OutputStream out = response.getOutputStream();
	         FileInputStream in = new FileInputStream(my_file);
	         byte[] buffer = new byte[4096];
	         int length;
	         while ((length = in.read(buffer)) > 0){
	            out.write(buffer, 0, length);
	         }
	         in.close();
	         out.flush();
		 }
		 
		 //per scaricare la richiesta di convenzione dell'azienda
		 if(tipo.equals("convenzione")) {
			 
			 String piva = request.getParameter("piva");
			 AziendaDaoInterface azDao = new AziendaDaoImpl();
			 Azienda azienda = azDao.getAziendaBypiva(piva);
			 
			 String uniqueID = azienda.getUniqueID();
			 
			 String rootPath =  getServletContext().getInitParameter("fsroot");
			 
			 response.setContentType("application/pdf");
				
	         response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\""  );
	         
	         File my_file = new File(rootPath + File.separator + uniqueID + File.separator + filename);
	     	
	         OutputStream out = response.getOutputStream();
	         FileInputStream in = new FileInputStream(my_file);
	         byte[] buffer = new byte[4096];
	         int length;
	         while ((length = in.read(buffer)) > 0){
	            out.write(buffer, 0, length);
	         }
	         in.close();
	         out.flush();
		 }
		 
		 //per scaricare il file presente nella cartella dell'utente
		 if(tipo.equals("myFile")) {
			 
			 String uniqueID = (String) session.getAttribute("uniqueID");
	         String rootPath =  getServletContext().getInitParameter("fsroot");
	        
	         response.setContentType("application/pdf");
	
	         response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\""  );
	     
	         File my_file = new File(rootPath + File.separator + uniqueID + File.separator + filename);
	
	         OutputStream out = response.getOutputStream();
	         FileInputStream in = new FileInputStream(my_file);
	         byte[] buffer = new byte[4096];
	         int length;
	         while ((length = in.read(buffer)) > 0){
	            out.write(buffer, 0, length);
	         }
	         in.close();
	         out.flush();
		 }
		 
		 //per generare il pdf dalle informazioni della form di richiesta convenzione
		 if(tipo.equals("firmaConvenzione")) {
			 
			 Convenzione conv = (Convenzione) session.getAttribute("convenzione"); 
			 Azienda azienda = (Azienda) session.getAttribute("azienda");
			 
			 response.setContentType("application/pdf");
			 response.setHeader("Content-disposition","attachment; filename = richiesta\"" + azienda.getNomeAzienda() + ".pdf");
			 
			 OutputStream out = response.getOutputStream();
			 
			 //font da utilizzare
			 Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
			 Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
			 Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
			 
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
					
					doc.add(new Paragraph("Università degli Studi di Salerno - Dipartimento di Informatica", bfBold12));
					
					doc.add(new Paragraph("Dati Richiesta", bfBold18));
					doc.add(new Paragraph("Nome Azienda:" + azienda.getNomeAzienda(), bf12));
					doc.add(new Paragraph("Partita Iva: "+ azienda.getP_iva(), bf12));
					doc.add(new Paragraph("Descrizione Tirocinio:" + conv.getDescrizione() ,bf12 ));
					doc.add(new Paragraph("Numeri Posti Tirocinio:" + conv.getNumPosti() ,bf12 ));
					doc.add(new Paragraph("Firma:", bf12));
					doc.add(new Paragraph("Data:" + conv.getData(),bf12));
					doc.close(); 
					
					
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		 }
		 
		 //per generare il pdf dalle informazioni della form di richiesta convenzione
		 if(tipo.equals("firmaTirocinio")) {
			 
			 RichiestaTirocinio rTirocinio = (RichiestaTirocinio) session.getAttribute("rTirocinio"); 
			 Studente studente = (Studente) session.getAttribute("studente");
			 
			 response.setContentType("application/pdf");
			 response.setHeader("Content-disposition","attachment; filename = richiesta\"" + studente.getNome() + studente.getCognome() + ".pdf");
			 
			 OutputStream out = response.getOutputStream();
			 
			 //font da utilizzare
			 Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
			 Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
			 Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
			 
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
					
					doc.add(new Paragraph("Università degli Studi di Salerno - Dipartimento di Informatica", bfBold18));
					doc.add(new Paragraph("Richiesta di Tirocinio", bfBold12));
					doc.add(new Paragraph("Dati Richiesta", bfBold18));
					doc.add(new Paragraph("Nome:" + studente.getNome(), bf12));
					doc.add(new Paragraph("Cognome:" + studente.getCognome(), bf12));
					doc.add(new Paragraph("Matricola: "+ studente.getMatricola(), bf12));
					doc.add(new Paragraph("Tutor Accademico scelto:" + rTirocinio.getNomeTutorAccademico(),bf12 ));
					doc.add(new Paragraph("Data:" + rTirocinio.getData(),bf12));
					doc.add(new Paragraph("Firma:", bf12));
					doc.close(); 
					
					
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		 }

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
