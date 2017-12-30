package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Azienda;
import bean.Tirocinio;
import util.DBConnection;

public class TirocinioDaoImpl implements TirocinioDaoInterface{

	@Override
	public ArrayList<Tirocinio> getDettagliAziendeConvenzionate() {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Tirocinio> tirocini = new ArrayList<Tirocinio>();
		ArrayList<Azienda> aziende = new ArrayList<Azienda>();
		
		try{
			
			con = DBConnection.createConnection();
			String query =
					"SELECT *"
					+ "FROM tirocinio"
					+ "INNER JOIN azienda ON tirocinio.p_iva = azienda.p_iva";
			preparedStatement = con.prepareStatement(query); 
			
			ResultSet rs = preparedStatement.executeQuery();
			
			/* Eseguire la query su "Phpmyadmin -> SQL" per ottenere un esempio di result */
			
			while(rs.next()) {

				/* PROBLEMA: COME RITORNA ENTRAMBI GLI OGGETTI (O I SUOI VALORI)? */
				
				/* Prende i primi campi che sono del tirocinio */
				Tirocinio tirocinio = new Tirocinio();
				
				tirocinio.setIdTirocinio(rs.getInt(1));			
				tirocinio.setDescrizione(rs.getString(2));
				tirocinio.setNumPosti(rs.getInt(3));
				
				/* Gli altri campi sono dell'azienda connessa al rispettivo tirocinio */
				
				Azienda azienda = new Azienda();
				
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		/* Vedere per bene cosa deve ritornare*/
		return null;
	
		
		
		
	}
	
	
	

}
