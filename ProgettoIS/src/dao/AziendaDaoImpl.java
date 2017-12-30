package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Azienda;
import bean.Studente;
import util.DBConnection;

public class AziendaDaoImpl implements AziendaDaoInterface{
	
	
	/**
	 * Il metodo registerUser prende i parametri dal bean e richiama il metodo di DBConnection per connettersi al database, per poi effettuare la query di inserimento.
	 * Ritorna true se l'inserimento � andato a buon fine
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
	
	/**
	 * Il metodo prende i parametri di login dal bean dell'user ed effettua la connessione al db. Se la query � riuscita ritorna status = true.
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

	/**
	 * Il metodo restituisce la lista completa delle aziende convenzionate presenti nel DB. 
	 * Istanzia un bean per ogni azienda e la aggiunge all'arraylist da restituire
	 */
	@Override
	public ArrayList<Azienda> getAziendeConvenzionate() {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Azienda> aziende = new ArrayList<Azienda>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT	azienda.nomeAzienda,azienda.email,azienda.telefono,azienda.sede FROM convenzione INNER JOIN azienda ON convenzione.p_iva = azienda.p_iva where convenzione.stato = 'accettata'";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Azienda azienda = new Azienda();
				
				azienda.setNomeAzienda(rs.getString(1));			
				azienda.setEmail(rs.getString(2));
				azienda.setTelefono(rs.getString(3));
				azienda.setEmail(rs.getString(4));

				aziende.add(azienda);
				
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return aziende;
	}
	
	/**
	 * Il metodo restituisce la lista completa delle aziende presenti nel DB. 
	 * Istanzia un bean per ogni azienda e la aggiunge all'arraylist da restituire
	 */
	@Override
	public ArrayList<Azienda> getAziende() {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Azienda> aziende = new ArrayList<Azienda>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM azienda";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Azienda azienda = new Azienda();
				
				azienda.setP_iva(rs.getString(1));
				azienda.setNomeAzienda(rs.getString(2));
				azienda.setTutorAziendale(rs.getString(3));
				azienda.setEmail(rs.getString(4));
				azienda.setPassword(rs.getString(5));
				azienda.setSede(rs.getString(6));
				azienda.setTelefono(rs.getString(7));

				aziende.add(azienda);
				
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return aziende;
	}
	
	/**
	 * Il metodo ritorna un istanza di azienda trovata dall'email passata come parametro.
	 */
	@Override
	public Azienda getAziendaByEmail(String email) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		Azienda azienda = new Azienda();
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM azienda WHERE email = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				azienda.setP_iva(rs.getString(1));
				azienda.setNomeAzienda(rs.getString(2));
				azienda.setTutorAziendale(rs.getString(3));
				azienda.setEmail(rs.getString(4));
				azienda.setPassword(rs.getString(5));
				azienda.setSede(rs.getString(6));
				azienda.setTelefono(rs.getString(7));
			
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return azienda;
	}

	
	
}
	


