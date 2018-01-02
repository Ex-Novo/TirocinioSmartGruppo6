package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Documento;
import util.DBConnection;

public class DocumentoDaoImpl implements DocumentoDaoInterface{
	
	
	public ArrayList<Documento> getDocumenti(String chiave){
		
	    
		ArrayList<Documento> documenti = new ArrayList<Documento>();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = DBConnection.createConnection();
			
			String query = "SELECT `tipo`, `path` FROM `documento` WHERE matricola = ? OR p_iva = ?";
			
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, chiave);
			preparedStatement.setString(2, chiave);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				Documento doc = new Documento();
				
				doc.setTipo(rs.getString(1));
				doc.setPath(rs.getString(2));
				
				
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return documenti;
	}

	
}
