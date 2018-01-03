package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Tirocinio;
import util.DBConnection;

public class TirocinioDaoImpl implements TirocinioDaoInterface{

	
	/**
	 * Il metodo prende come parametro la partita iva dell'azienda ed effettua una query nel database per cercare il tirocinio associato
	 * @return ritorna un bean di tirocinio con le info associate
	 * 
	 * @author: Francesco D'auria, Luca Lamberti
	 * modifiche: Mario Procida
	 */
	@Override
	public Tirocinio getDettagliAziendeConvenzionate(String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Tirocinio tirocinio = new Tirocinio();
		
		try{
			
			con = DBConnection.createConnection();
			String query =
					"SELECT tirocinio.idTirocinio, tirocinio.descrizione, tirocinio.numPosti "
					+ "FROM tirocinio "
					+ "INNER JOIN azienda ON tirocinio.p_iva = azienda.p_iva WHERE azienda.p_iva = ?";
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, piva);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while(rs.next()) {
					
				tirocinio.setIdTirocinio(rs.getInt(1));
				tirocinio.setDescrizione(rs.getString(2));
				tirocinio.setNumPosti(rs.getInt(3));
										
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return tirocinio;
	
		
		
		
	}
	
	/**
	 * Il metodo prende come parametro il tirocinio da inserire ed effettua la query nel database
	 * @return ritorna true se l'inserimento ha avuto successo false altrimenti
	 * 
	 * @author: Luca Lamberti
	 * 
	 */
	@Override
	public boolean creaTirocinio(Tirocinio t) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "tirocinio "
				+ " (descrizione, numPosti, p_iva) VALUES (?, ?, ?)";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, t.getDescrizione());
			preparedStatement.setInt(2, t.getNumPosti());
			preparedStatement.setString(3, t.getP_iva());
			
			
			
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
	
	

}
