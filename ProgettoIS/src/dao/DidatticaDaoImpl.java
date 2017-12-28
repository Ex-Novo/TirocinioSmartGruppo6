package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Didattica;
import util.DBConnection;

public class DidatticaDaoImpl implements DidatticaDaoInterface {
	
	
	/**
	 * Il metodo prende i parametri di login dal bean dell'user ed effettua la connessione al db. Se la query è riuscita ritorna status = true.
	 */
	@Override
	public boolean loginUser(Didattica user)
	{
		boolean status = false;
		String email = user.getEmail();
		String password = user.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM didattica WHERE email = ? AND password = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status=rs.next(); //ritorna true se trova l'utente
			
			con.close();
		}
		
		catch(SQLException e)
		{

			e.printStackTrace();
		}
		
		return status;
	}
}
