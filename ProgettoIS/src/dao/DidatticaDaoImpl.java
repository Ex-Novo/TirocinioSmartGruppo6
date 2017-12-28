package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Didattica;
import util.DBConnection;

public class DidatticaDaoImpl implements DidatticaDaoInterface {
	
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
