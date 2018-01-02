package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Convenzione;

import util.DBConnection;

public class ConvenzioneDaoImpl implements ConvenzioneDaoInterface{

	@Override  //da implementare
	public boolean approvazioneRichiestaConvenzione(Convenzione convenzione) {
		
		return false;
	}

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
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, piva);
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

}
