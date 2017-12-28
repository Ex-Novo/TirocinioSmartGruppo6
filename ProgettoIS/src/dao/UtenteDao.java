package dao;

import bean.Utente;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtenteDao {
	
	public boolean registerUser(Utente utente)
	{
		
		String email = utente.getEmail();
		String password = utente.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			con = DBConnection.createConnection();
			String query = "insert into studente(matricola,nome,cognome,password,codiceFiscale,email,dataNascita,luogoNascita) values (123,NULL,NULL,?,NULL,?,NULL,NULL)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

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
