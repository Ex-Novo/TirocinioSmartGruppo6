package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Attivita;
import bean.Registro;
import util.DBConnection;

public class AttivitaDaoImpl implements AttivitaDaoInterface{

	@Override
	public boolean inserisciAttivita(Attivita a) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "attivita "
				+ " (data, ore, descrizione, idTirocinio, idRegistro) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, a.getData());
			preparedStatement.setInt(2, a.getOre());
			preparedStatement.setString(3, a.getDescrizione());
			preparedStatement.setInt(4, a.getIdTirocinio());
			preparedStatement.setInt(5, a.getIdRegistro());
			
			
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

	@Override
	public ArrayList<Attivita> getAttivitaByIdRegistro(int idRegistro) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Attivita> listaAttivita = new ArrayList<Attivita>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT  idAttivita , data, ore , descrizione, idTirocinio, idRegistro FROM attivita WHERE idRegistro = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setInt(1, idRegistro);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Attivita attivita = new Attivita();
				attivita.setIdAttivita(rs.getInt(1));
				attivita.setData(rs.getString(2));
				attivita.setOre(rs.getInt(3));
				attivita.setDescrizione(rs.getString(4));
				attivita.setIdTirocinio(rs.getInt(5));
				attivita.setIdRegistro(rs.getInt(6));
				
				listaAttivita.add(attivita);
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return listaAttivita;
	}


}
