package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Attivita;
import bean.Registro;
import bean.RichiestaTirocinio;
import dao.AttivitaDaoImpl;
import dao.AttivitaDaoInterface;
import dao.RegistroDaoImpl;
import dao.RegistroDaoInterface;
import dao.RichiestaTirocinioDaoImpl;
import dao.RichiestaTirocinioDaoInterface;

/**
 * Servlet implementation class CompilaRegistroControl
 */
@WebServlet("/CompilaRegistroControl")
public class CompilaRegistroControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompilaRegistroControl() {
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
	 * Il metodo prende in input i dati dell'attività da registrare dal form e la richiamo i dao per salvarla nel database
	 * 
	 * @author Mario Procida.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String tipo = request.getParameter("tipo");
		
		
		if(tipo.equals("addAtt")) {
			String matricola = request.getParameter("matricola");
			session.setAttribute("matricolaStudente", matricola);
			response.sendRedirect("CompilaRegistro.jsp");
		}
		
		if(tipo.equals("sendAtt")) {
			
			String matricolaStudente = (String) session.getAttribute("matricolaStudente");
			String data = request.getParameter("data");
			int oreLavoro = Integer.parseInt(request.getParameter("oreLavoro"));
			String 	descrizione = request.getParameter("descrizione");
			
			RichiestaTirocinioDaoInterface richTirDao = new RichiestaTirocinioDaoImpl();
			RichiestaTirocinio richTir = richTirDao.getRichTirocinio(matricolaStudente);
			
			RegistroDaoInterface regDao = new RegistroDaoImpl();
			Registro reg = regDao.getRegistroByMatricola(matricolaStudente);
			
			Attivita att = new Attivita();
			att.setData(data);
			att.setOre(oreLavoro);
			att.setDescrizione(descrizione);
			att.setIdTirocinio(richTir.getIdTirocinio());
			att.setIdRegistro(reg.getIdRegistro());
			
			AttivitaDaoInterface attDao = new AttivitaDaoImpl();
			
			boolean result = attDao.inserisciAttivita(att);
			
			
			if(result) {
				out.println("<script>");
				out.println("alert('Attivita registrata con successo')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('Non e stato possibile aggiungere l attivita')");
				out.println("window.history.back()");
				out.println("</script>");
			}
		}
		
		
		out.flush();
		out.close();
	}

}
