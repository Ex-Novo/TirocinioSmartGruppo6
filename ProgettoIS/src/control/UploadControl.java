package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Azienda;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.DocumentoDaoImpl;
import dao.DocumentoDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;


@WebServlet("/UploadControl")

/*
 * Dimensioni file da caricare
 */
@MultipartConfig( fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024	 * 50 )
public class UploadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadControl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * Il metodo prende in input il nome del file da caricare e il file stesso e lo carica nella directory associata all'utente tramite il suo unique ID
	 * preso dalla sessione. Inoltre salva alcune info del file caricato nel DB.
	 * @author Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String tipoUtente = (String) session.getAttribute("tipoUtente");
		String uniqueID = (String) session.getAttribute("uniqueID");
		
		String rootPath = getServletContext().getInitParameter("fsroot");
		String userPath = rootPath + File.separator + uniqueID;
		String fileName = null;
		
		
		for(Part part : request.getParts()) {
			fileName = extractFileName(part);
			if (fileName != null && !fileName.equals("")) {
				part.write(userPath + File.separator + fileName);
			}
		}
		
		/*
		 * Salva le info del documento nel db
		 */
		
		DocumentoDaoInterface dDao = new DocumentoDaoImpl();
		
		if(tipoUtente.equals("Studente")) {
			StudenteDaoInterface sDao = new StudenteDaoImpl();
			Studente s = sDao.getStudenteByEmail(email);
			
			
			dDao.saveFile(fileName, s.getMatricola(), tipoUtente);
		}
		
		else if (tipoUtente.equals("Azienda")){
			AziendaDaoInterface aDao = new AziendaDaoImpl();
			Azienda a = aDao.getAziendaByEmail(email);
			
			dDao.saveFile(fileName, a.getP_iva(), tipoUtente);
		}
		
		PrintWriter out =response.getWriter();
		 out.println("<script>");
		 out.println("alert('File caricato')");
		 out.println("window.open('documents','_self')");
		 out.println("</script>");
		 
		 out.close();
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2 , s.length() -1);
			}
		}
		return "";
	}

}
