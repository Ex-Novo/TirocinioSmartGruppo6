package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Registro;
import util.DBConnection;

public class RegistroDaoImpl implements RegistroDaoInterface{

	/**
	 * inserisce un registro nel database 
	 * 
	 * @author Luca Lamberti , Mario Procida
	 */
	@Override
	public boolean inserisciRegistro(String matricola, String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="INSERT INTO registro ( matricola , p_iva) VALUES (?,?)";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, matricola);
			preparedStatement.setString(2, piva);
			
			
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
	 * restituisce il registro  dello studente con la matricola specificata
	 * 
	 * @author Luca Lamberti , Mario Procida
	 */
	@Override
	public Registro getRegistroByMatricola(String matricola) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		Registro registro = new Registro();
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT  idRegistro , matricola, p_iva FROM registro WHERE matricola = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, matricola);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				registro.setIdRegistro(rs.getInt(1));
				registro.setMatricola(rs.getString(2));
				registro.setP_iva(rs.getString(3));
			
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return registro;
	}
	
	
	/**
	 * restituisce tutti i registri dei tirocinanti presso l' azienda che ha la p_iva specificata
	 * 
	 * @author Luca Lamberti , Mario Procida
	 */
	@Override
	public ArrayList<Registro> getRegistriByP_IVA(String piva) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Registro> registri = new ArrayList<Registro>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT  idRegistro , matricola, p_iva FROM registro WHERE p_iva = ?";
			preparedStatement = con.prepareStatement(query); 
			
			preparedStatement.setString(1, piva);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Registro registro = new Registro();
				registro.setIdRegistro(rs.getInt(1));
				registro.setMatricola(rs.getString(2));
				registro.setP_iva(rs.getString(3));
				
				registri.add(registro);
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return registri;
	}

}
