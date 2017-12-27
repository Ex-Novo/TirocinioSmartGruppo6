package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import bean.Studente;
import util.DBConnection;

public class StudenteDaoImpl implements StudenteDaoInterface {

	@Override
	public boolean registerUser(Studente user)
	{

		String matricola = user.getMatricola();
		String nome = user.getNome();
		String cognome = user.getCognome();
		String password = user.getPassword();
		String codiceFiscale = user.getCodiceFiscale();
		String email = user.getEmail();
		String dataNascita = user.getDataNascita();
		String luogoNascita = user.getLuogoNascita();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			con = DBConnection.createConnection();
			String query = "insert into studente(matricola,nome,cognome,password,codiceFiscale,email,dataNascita,luogoNascita) values (?,?,?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, matricola);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, cognome);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, codiceFiscale);
			preparedStatement.setString(6, email);
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			Date date;
			try {
				date = format.parse(dataNascita);
				preparedStatement.setDate(7,(java.sql.Date) date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			preparedStatement.setString(8, luogoNascita);

			int i = preparedStatement.executeUpdate();

			if (i!=0){  // ritorna true se l'operazione è riuscita
				con.close();
				return true; 
			}
		}
		catch(SQLException e)
		{

			e.printStackTrace();
		}

		return false;  //ritorna false se non è riuscita


	}
}
