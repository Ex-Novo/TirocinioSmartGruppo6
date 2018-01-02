package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import bean.Convenzione;
import bean.RichiestaTirocinio;
import bean.Studente;
import util.DBConnection;

public class RichiesteDaoImpl implements RichiesteDaoInterface {

	@Override
	public boolean invioRichiestaTirocinio(String tutorAccademico) {
		/* Studente che invia una richiesta di tirocinio 
		 Deve inserire il nome del tutor accademico 
		 Lo puoi ottenere dalla servlet tramite:
		 (String)request.getParameter("tutorAccademico") (da implementare)
		 */
		
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query =  null;	/*Query per creare richiesta tirocinio */
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();

				richiestaTirocinio.setIdRichiestaTirocinio(rs.getInt(1));
				richiestaTirocinio.setNomeTutorAccademico(rs.getString(2));
				richiestaTirocinio.setStatus(rs.getString(3));
				richiestaTirocinio.setData(rs.getDate(4));
				
				/* */
			}
			
			con.close();
			
			return true;
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return false;
		

		
	}

	@Override
	public boolean invioRichiestaConvenzione() {
	
		return false;
	}

	@Override
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
		
		return false;
	}

	@Override
	public boolean approvazioneRichiestaConvenzione(Convenzione convenzione) {
	
		return false;
	}

	@Override
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio() {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<RichiestaTirocinio> richiesteTirocinio = new ArrayList<RichiestaTirocinio>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM richiestatirocinio WHERE status='in attesa'";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();

				richiestaTirocinio.setIdRichiestaTirocinio(rs.getInt(1));
				richiestaTirocinio.setNomeTutorAccademico(rs.getString(2));
				richiestaTirocinio.setStatus(rs.getString(3));
				richiestaTirocinio.setData(rs.getDate(4));
				
				/* */
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return richiesteTirocinio;
	}

	@Override
	public ArrayList<Convenzione> getRichiesteConvenzione() {
	
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Convenzione> richiesteTirocinio = new ArrayList<Convenzione>();
		
		try
		{
			
			con = DBConnection.createConnection();
			String query = "SELECT * FROM convenzione WHERE status='in attesa'";
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Convenzione convenzione = new Convenzione();
				
				convenzione.setData(rs.getDate(2));
				
				/* */
				convenzione.setDescrizione(rs.getString(4));
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return richiesteTirocinio;
		
	}

}
