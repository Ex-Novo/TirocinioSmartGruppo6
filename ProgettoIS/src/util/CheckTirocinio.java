package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;


/**
 * La servlet controlla se è già presente nel database una richiesta di tirocinio da parte dello studente.
 */
@WebServlet("/CheckTirocinio")
public class CheckTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTirocinio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * Prende come parametro la matricola dello studente e richiama un metodo dao per eseguire una query e controllare se è già presente una richiesta di tirocinio nel database
	 * 
	 * @author Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String matricola = (String) session.getAttribute("matricola");
		int idTirocinio = Integer.parseInt(request.getParameter("t"));

		RichiestaTirocinioDaoInterface rTirocinioDao = new RichiestaTirocinioDaoImpl();
		RichiestaTirocinio richTir = rTirocinioDao.getRichTirocinio(matricola); //ritorna true se trova la richiesta di tirocinio

		PrintWriter out = response.getWriter();
		if(richTir.getMatricola() != null) {
			
			out.println("<script>");
			out.println("alert('Hai già richiesto un tirocinio.')");
			out.println("window.history.back()");
			out.println("</script>");
		}else {
			
			session.setAttribute("idTirocinio", idTirocinio) ;
			out.println("<script>");
			out.println("window.open('RichiestaTirocinio.jsp','_self')");
			out.println("</script>");
		}
	}

}
