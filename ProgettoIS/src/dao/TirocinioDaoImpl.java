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
	public Tirocinio getDettagliAziendeConvenzionate(String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Tirocinio tirocinio = new Tirocinio();
		
		try{
			
			con = DBConnection.createConnection();
			String query =
					"SELECT *"
					+ "FROM tirocinio"
					+ "INNER JOIN azienda ON tirocinio.p_iva = azienda.p_iva WHERE azienda.p_iva= ?";
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
	
	
	

}
