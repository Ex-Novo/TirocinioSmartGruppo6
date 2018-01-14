package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Studente;
import util.DBConnection;

/**
 * DAO che permette le operazioni sul database riguardanti gli studenti
 *
 */
public class StudenteDaoImpl implements StudenteDaoInterface {

	/**
	 * Il metodo registerUser prende i parametri dal bean e richiama il metodo di DBConnection per connettersi al database, per poi effettuare la query di inserimento.
	 * Ritorna true se l'inserimento è andato a buon fine
	 * 
	 * @author: Mario Procida
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
		String uniqueID = user.getUniqueID();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{
			con = DBConnection.createConnection();
			String query = "insert into studente(matricola,nome,cognome,password,codiceFiscale,email,dataNascita,luogoNascita,uniqueID) values (?,?,?,?,?,?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, matricola);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, cognome);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, codiceFiscale);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, dataNascita);
			preparedStatement.setString(8, luogoNascita);
			preparedStatement.setString(9, uniqueID);
			
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
	 * 
	 * @author: Mario Procida
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
	 * 
	 * @author: Mario Procida, Francesco D'auria
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
					studente.setUniqueID(rs.getString(9));

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
	 * 
	 * @author: Mario Procida
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
			
			preparedStatement.setString(1, email);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				studente.setMatricola(rs.getString(1));
				studente.setNome(rs.getString(2));
				studente.setCognome(rs.getString(3));
				studente.setPassword(rs.getString(4));
				studente.setCodiceFiscale(rs.getString(5));
				studente.setEmail(rs.getString(6));
				studente.setDataNascita(""+ rs.getDate(7));
				studente.setLuogoNascita(rs.getString(8));
				studente.setUniqueID(rs.getString(9));
			
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return studente;
	}
	
	
	/**
	 * Il metodo ritorna un istanza di studente trovata dalla matricola  passata come parametro.
	 * 
	 * @author: Simone Torluccio ,Luca Lamberti
	 */
	public Studente getStudenteByMatricola(String matricola){
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		Studente studente = new Studente();
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM studente WHERE matricola = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, matricola);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				studente.setMatricola(rs.getString(1));
				studente.setNome(rs.getString(2));
				studente.setCognome(rs.getString(3));
				studente.setPassword(rs.getString(4));
				studente.setCodiceFiscale(rs.getString(5));
				studente.setEmail(rs.getString(6));
				studente.setDataNascita(""+ rs.getDate(7));
				studente.setLuogoNascita(rs.getString(8));
				studente.setUniqueID(rs.getString(9));
			
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return studente;
	}
	
	
	/**
	 * Il metodo restituisce la lista dei tirocinanti  presenti nel DB dell'azienda specificata. 
	 * Istanzia un bean per ogni studente e lo aggiunge all'arraylist da restituire
	 * @author: Luca Lamberti
	 */
	@Override
	public ArrayList<Studente> getTirocinanti(String p) {
			
			Connection con = null;
			PreparedStatement preparedStatement = null;
			ArrayList<Studente> studenti = new ArrayList<Studente>();
			
			try
			{
				
				con = DBConnection.createConnection();
				String query = "SELECT studente.matricola, studente.nome , studente.cognome , studente.codiceFiscale ,studente.email ,studente.dataNascita ,studente.luogoNascita, studente.uniqueID "
						+ "FROM (((studente INNER JOIN richiestatirocinio on studente.matricola=richiestatirocinio.matricola)INNER JOIN tirocinio on richiestatirocinio.idTirocinio=tirocinio.idTirocinio) "
						+ "INNER JOIN azienda on tirocinio.p_iva=azienda.p_iva) WHERE azienda.p_iva= ? AND richiestatirocinio.status = 'approvata'";
				preparedStatement = con.prepareStatement(query); 
				
				preparedStatement.setString(1, p);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					
					Studente studente = new Studente();
					
					studente.setMatricola(rs.getString(1));
					studente.setNome(rs.getString(2));
					studente.setCognome(rs.getString(3));
					studente.setCodiceFiscale(rs.getString(4));
					studente.setEmail(rs.getString(5));
					studente.setDataNascita(""+ rs.getDate(6));
					studente.setLuogoNascita(rs.getString(7));
					studente.setUniqueID(rs.getString(8));

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

}
