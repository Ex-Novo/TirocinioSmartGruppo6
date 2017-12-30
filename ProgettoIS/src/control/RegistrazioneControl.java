package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import bean.Studente;

import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;



@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public RegistrazioneControl() {

	}

    /**
     * Prende il parametro per controllare il tipo di utente da registrare e a seconda se è uno Studente o Azienda istanzia il bean.
     * Subito dopo istanzia l'interfaccia dao e l'implementazione dell'interfaccia per eseguire le query e ritorna un risoltato a seconda se
     * l'operazione è riuscita oppure no.
     * 
     * @author: Mario Procida,  Francesco D'auria
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String userType = request.getParameter("tipo");
		
		if(userType.equals("Studente")){
			
			String matricola = request.getParameter("matricola");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String password = request.getParameter("password");
			String codiceFiscale = request.getParameter("codiceFiscale");
			String email = request.getParameter("email");
			String dataNascita = request.getParameter("dataNascita");
			String luogoNascita = request.getParameter("luogoNascita");
			
			Studente user = new Studente();

			user.setMatricola(matricola);
			user.setNome(nome);
			user.setCognome(cognome);
			user.setPassword(password);
			user.setCodiceFiscale(codiceFiscale);
			user.setEmail(email);
			user.setDataNascita(dataNascita);
			user.setLuogoNascita(luogoNascita);
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			boolean userRegistered = studenteDao.registerUser(user);

			if(userRegistered){
				out.println("<script>");
				out.println("alert('Registrazione riuscita. Ora puoi effettuare l'accesso')");
				out.println("window.history.back()");
				out.println("</script>");
			}
			else{
				out.println("<script>");
				out.println("alert('Registrazione non riuscita. Riprova!')");
				out.println("window.history.back()");
				out.println("</script>");
				
				
			}
		}
		
		else if(userType.equals("Azienda")){
			
			String nomeAzienda = request.getParameter("nomeAzienda");
			String partitaIva = request.getParameter("partitaIva");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String sede = request.getParameter("sede");
			String telefono = request.getParameter("telefono");
			
			Azienda user = new Azienda();
			
			user.setNomeAzienda(nomeAzienda);
			user.setP_iva(partitaIva);
			user.setEmail(email);
			user.setPassword(password);
			user.setSede(sede);
			user.setTelefono(telefono);
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			
			boolean userRegistered = aziendaDao.registerUser(user);
			
			if(userRegistered){
				
				out.println("<script>");
				out.println("alert('Registrazione riuscita. Ora puoi effettuare l'accesso')");
				out.println("window.history.back()");
				out.println("</script>");
			}
			else{
				
				out.println("<script>");
				out.println("alert('Registrazione non riuscita. Riprova!')");
				out.println("window.history.back()");
				out.println("</script>");
			}
			
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
