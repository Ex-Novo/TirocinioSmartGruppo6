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

import bean.Convenzione;


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
		 
		 String uniqueID = (String) session.getAttribute("uniqueID");
		
		 String filename = request.getParameter("filename");
		 String tipo = request.getParameter("tipo");
		 
		 //Metodo per scaricare il file presente nel file system
		 if(tipo.equals("notFirma")) {
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
		 
		 //metodo per generare il pdf dalle informazioni della form
		 if(tipo.equals("firmaConvenzione")) {
			 
			 Convenzione conv = (Convenzione) session.getAttribute("convenzione"); 
			 
			 response.setContentType("application/pdf");
			 response.setHeader("Content-disposition","attachment; filename = richiesta.pdf");
			 
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

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
