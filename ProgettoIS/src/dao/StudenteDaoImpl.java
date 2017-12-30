package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Studente;
import util.DBConnection;

public class StudenteDaoImpl implements StudenteDaoInterface {

	/**
	 * Il metodo registerUser prende i parametri dal bean e richiama il metodo di DBConnection per connettersi al database, per poi effettuare la query di inserimento.
	 * Ritorna true se l'inserimento è andato a buon fine
	 */
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
			
			status=rs.next();  // ritorna true se utente trovato
			
			con.close();
		}
		
		catch(SQLException e)
		{

			e.printStackTrace();
		}
		
		return status;
	}

	/**
	 * Il metodo restituisce la lista completa degli studenti presenti nel DB. 
	 * Istanzia un bean per ogni studente e lo aggiunge all'arraylist da restituire
	 */
	@Override
	public ArrayList<Studente> getStudenti() {
			
			Connection con = null;
			PreparedStatement preparedStatement = null;
			ArrayList<Studente> studenti = new ArrayList<Studente>();
			
			try
			{
				
				con = DBConnection.createConnection();
				String query = "SELECT * FROM studente";
				preparedStatement = con.prepareStatement(query); 
				
				
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					
					Studente studente = new Studente();
					
					studente.setMatricola(rs.getString(1));
					studente.setNome(rs.getString(2));
					studente.setCognome(rs.getString(3));
					studente.setPassword(rs.getString(4));
					studente.setCodiceFiscale(rs.getString(5));
					studente.setEmail(rs.getString(6));
					studente.setDataNascita(""+ rs.getDate(7));
					studente.setLuogoNascita(rs.getString(8));

					studenti.add(studente);
					
				}
				
				con.close();
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			return studenti;
		}
	
	/**
	 * Il metodo ritorna un istanza di studente trovata dall'email passata come parametro.
	 */
	public Studente getStudenteByEmail(String email){
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		Studente studente = new Studente();
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM studente WHERE email = ?";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.setString(1, email);
			
			while(rs.next()) {
				
				studente.setMatricola(rs.getString(1));
				studente.setNome(rs.getString(2));
				studente.setCognome(rs.getString(3));
				studente.setPassword(rs.getString(4));
				studente.setCodiceFiscale(rs.getString(5));
				studente.setEmail(rs.getString(6));
				studente.setDataNascita(""+ rs.getDate(7));
				studente.setLuogoNascita(rs.getString(8));
			
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return studente;
	}

}
