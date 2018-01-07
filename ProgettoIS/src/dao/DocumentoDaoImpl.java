package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Documento;
import util.DBConnection;

/**
 * DAO che permette le operazioni sul database riguardanti i documenti
 *
 */
public class DocumentoDaoImpl implements DocumentoDaoInterface{
	
	/**
	 * Il metodo effettua una query per ricercare i documenti caricati dall'utente
	 * @author Mario Procida
	 * @return Arraylist di tutti i documenti caricati dall'utente
	 */
	public ArrayList<Documento> getDocumenti(String chiave){
		
	    
		ArrayList<Documento> documenti = new ArrayList<Documento>();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = DBConnection.createConnection();
			
			String query = "SELECT `tipo`, `nome` FROM `documento` WHERE matricola = ? OR p_iva = ?";
			
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, chiave);
			preparedStatement.setString(2, chiave);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				Documento doc = new Documento();
				
				doc.setTipo(rs.getString(1));
				doc.setNome(rs.getString(2));
				
				documenti.add(doc);
				
				
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return documenti;
	}
	
	/**
	 * Il metodo salva il nome del file caricato dall'utente nel database
	 * @author Mario Procida
	 */
	public boolean saveFile(String nome, String chiave, String tipoUtente) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		String query = "";
		if(tipoUtente.equals("Studente")) {
			query = "INSERT into documento(tipo,matricola,emailDI,p_iva,nome)"
					+ "VALUES ('rTirocinio',?,null,null,?)" ;  
		}

		if(tipoUtente.equals("Azienda")) {
			query = "INSERT into documento(tipo,matricola,emailDI,p_iva,nome)"
					+ "VALUES ('rConvenzione',null,null,?,?)" ;
		}

		try {

			con = DBConnection.createConnection();

			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, chiave);
			preparedStatement.setString(2, nome);

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
