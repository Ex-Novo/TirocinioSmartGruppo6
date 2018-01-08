package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Convenzione;
import util.DBConnection;

/**
 * DAO che permette le operazioni sul database riguardanti le convenzioni
 *
 */
public class ConvenzioneDaoImpl implements ConvenzioneDaoInterface{

	/**
	 * Il metodo prende come parametro la partita iva dell'azienda di cui si vuole accettare la convenzione
	 * @return ritorna true se la convenzione è accettata
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	@Override  
	public boolean approvazioneRichiestaConvenzione(String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement=null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="UPDATE convenzione SET stato= 'accettata' WHERE p_iva= ?";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, piva);
			
			int rs = preparedStatement.executeUpdate();
			
			if(rs!=0 ){
			
			con.close();
			return true;
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * @return ritorna un arrayList di Convenzioni che sono in attesa di approvazione
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	@Override
	public ArrayList<Convenzione> getRichiesteConvenzione() {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Convenzione> richiesteConvenzione = new ArrayList<Convenzione>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT dataConvenzione, stato, dettaglioConvenzione, tutorAziendale, numPosti FROM convenzione WHERE stato='in attesa'";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Convenzione convenzione = new Convenzione();
				
				convenzione.setData(rs.getString(1));
				convenzione.setStato(rs.getString(2));
				convenzione.setDescrizione(rs.getString(3));
				convenzione.setTutorAziendale(rs.getString(4));
				convenzione.setNumPosti(rs.getInt(5));
				
				richiesteConvenzione.add(convenzione);
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return richiesteConvenzione;
	}

	
	/**
	 * Il metodo prende come parametro la convenzione da voler inoltrare e altri 2 parametri rappresentanti le chiavi esterne
	 * Effettua la query di inserimento nel database
	 * @return ritorna true se la query ha successo 
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	
	@Override 
	public boolean invioRichiestaConvenzione(Convenzione convenzione, String email ,String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "convenzione "
				+ " (dataConvenzione, stato, dettaglioConvenzione, p_iva, email, tutorAziendale, numPosti) VALUES (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, convenzione.getData());
			preparedStatement.setString(2, convenzione.getStato());
			preparedStatement.setString(3, convenzione.getDescrizione());
			preparedStatement.setString(4, piva);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, convenzione.getTutorAziendale());
			preparedStatement.setInt(7, convenzione.getNumPosti());
			
			
			int rs = preparedStatement.executeUpdate();
			
			if(rs!=0 ){
			
			con.close();
			return true;
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Questo metodo controlla se è presente nel database una convenzione con la partita iva dell'azienda
	 * @return Ritorna true se è già presente altrimenti false
	 * 
	 * @author Mario Procida
	 */
	@Override
	public boolean getConvenzione(String piva) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		

		try
		{
			con = DBConnection.createConnection();
			String query ="SELECT * FROM convenzione WHERE p_iva = ?  ";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, piva);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				con.close();
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
