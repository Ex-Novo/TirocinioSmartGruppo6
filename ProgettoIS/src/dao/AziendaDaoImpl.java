package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Azienda;

import util.DBConnection;

public class AziendaDaoImpl implements AziendaDaoInterface{
	
	
	/**
	 * Il metodo registerUser prende i parametri dal bean e richiama il metodo di DBConnection per connettersi al database, per poi effettuare la query di inserimento.
	 * Ritorna true se l'inserimento è andato a buon fine
	 */
	@Override
	public boolean registerUser(Azienda user)
	{
		String nomeAzienda = user.getNomeAzienda();
		String partitaIva = user.getP_iva();
		String email = user.getEmail();
		String password = user.getPassword();
		String sede = user.getSede();
		String telefono = user.getTelefono();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			con = DBConnection.createConnection();
			String query = "insert into azienda(p_iva,nomeAzienda,email,password,sede,telefono) values (?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, partitaIva);
			preparedStatement.setString(2, nomeAzienda);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, sede);
			preparedStatement.setString(6, telefono);
			
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
	
	/**
	 * Il metodo prende i parametri di login dal bean dell'user ed effettua la connessione al db. Se la query è riuscita ritorna status = true.
	 */
	@Override
	public boolean loginUser(Azienda user)
	{
		boolean status = false;
		String email = user.getEmail();
		String password = user.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM azienda WHERE email = ? AND password = ?";
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
	


