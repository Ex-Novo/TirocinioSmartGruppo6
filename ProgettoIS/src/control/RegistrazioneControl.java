package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utente;
import dao.UtenteDao;


@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public RegistrazioneControl() {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Utente utente = new Utente();

		utente.setEmail(email);
		utente.setPassword(password);

		UtenteDao utenteDao = new UtenteDao();
		boolean userRegistered = utenteDao.registerUser(utente);

		if(userRegistered){
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();

			out.println("Registrazione non riuscita. Riprova!");
			request.getRequestDispatcher("registrazione.jsp").forward(request, response);
		}

	}

}
