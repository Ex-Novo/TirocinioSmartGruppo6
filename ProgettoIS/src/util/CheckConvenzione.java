package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Convenzione;
import dao.ConvenzioneDaoImpl;
import dao.ConvenzioneDaoInterface;

/**
 * La servlet controlla se è già presente nel database una richiesta di convenzione da parte dell'azienda.
 */
@WebServlet("/CheckConvenzione")
public class CheckConvenzione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckConvenzione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * Prende come parametro la partita iva dell'azienda e richiama un metodo dao per eseguire una query e controllare se è già presente una convenzione nel database
	 * 
	 * @author Mario Procida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String piva = (String) session.getAttribute("piva");

		ConvenzioneDaoInterface convDao = new ConvenzioneDaoImpl();
		Convenzione convenzione = convDao.getConvenzione(piva); //ritorna true se trova la convenzione

		PrintWriter out = response.getWriter();
		if(convenzione.getP_iva() != null && convenzione.getStato().equals("in attesa")) {
			session.setAttribute("canRequest", false);
			
			out.println("<script>");
			out.println("alert('Hai già richiesto una convenzione. La preghiamo di attendere la risposta del Direttore')");
			out.println("window.history.back()");
			out.println("</script>");
		}else if(convenzione.getP_iva() != null && convenzione.getStato().equals("rifiutata")) {
		
			session.setAttribute("canRequest", true);
			out.println("<script>");
			out.println("alert('La richiesta di convenzione che hai effettuato è stata rifiutata. Per chiarimenti contattare la didattica.')");
			out.println("window.open('RichiestaConvenzione.jsp','_self')");
			out.println("</script>");
		
		}else if(convenzione.getP_iva() != null && convenzione.getStato().equals("approvata")){
			session.setAttribute("canRequest", false);
			out.println("<script>");
			out.println("alert('La tua azienda è già convenzionata con il dipartimento')");
			out.println("window.history.back()");
			out.println("</script>");
		}else {
			session.setAttribute("canRequest", true);
			out.println("<script>");
			out.println("window.open('RichiestaConvenzione.jsp','_self')");
			out.println("</script>");
		}
	}

}
