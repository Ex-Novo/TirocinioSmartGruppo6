package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import bean.Azienda;
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
			preparedStatement.setString(7, dataNascita);
			preparedStatement.setString(8, luogoNascita);
			/*
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			Date date;
			try {
				date = format.parse(dataNascita);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} */
			
			int i = preparedStatement.executeUpdate();

			if (i!=0){  // ritorna true se l'operazione � riuscita
				con.close();
				return true; 
			}
		}
		catch(SQLException e)
		{

			e.printStackTrace();
		}

		return false;  //ritorna false se non � riuscita
    }
	
	
	@Override
	public boolean loginUser(Studente user)
	{
		
		boolean status = false;
		String email = user.getEmail();
		String password = user.getPassword();
	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM studente WHERE email = ? AND password = ?";
			
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status=rs.next();
			
			con.close();
		}
		
		catch(SQLException e)
		{

			e.printStackTrace();
		}
		
		return status;
	}
}