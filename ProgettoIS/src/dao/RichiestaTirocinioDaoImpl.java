package dao;

import java.util.ArrayList;

import bean.RichiestaTirocinio;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * DAO che permette le operazioni sul database riguardanti le richieste  di tirocinio
 *
 */
public class RichiestaTirocinioDaoImpl implements RichiestaTirocinioDaoInterface {

	@Override
	public boolean invioRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		
		try
		{
			
			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "richiestatirocinio "
				+ " (nomeTutorAccademico, status, dataInvio, p_iva, emailTA, emailDI, matricola, idTirocinio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, richiestaTirocinio.getNomeTutorAccademico());
			preparedStatement.setString(2, richiestaTirocinio.getStatus());
			preparedStatement.setString(3, richiestaTirocinio.getData());
			preparedStatement.setString(4, richiestaTirocinio.getEmailTutAcc());
			preparedStatement.setString(5, richiestaTirocinio.getEmailDir());
			preparedStatement.setString(6, richiestaTirocinio.getMatricola());
			preparedStatement.setInt(7, richiestaTirocinio.getIdTirocinio());
			
			
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
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
		
		return false;
	}

	@Override
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio() {
		/*
		 * IMPLEMENTAZIONE FRANCESCO
		 *  
		 *  
		 *  
		 *  Studente che invia una richiesta di tirocinio 
		 Deve inserire il nome del tutor accademico 
		 Lo puoi ottenere dalla servlet tramite:
		 (String)request.getParameter("tutorAccademico") (da implementare)
		 */
		
/*		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			con = DBConnection.createConnection();
			String query =  null;	/*Query per creare richiesta tirocinio 
			preparedStatement = con.prepareStatement(query); 
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();

				richiestaTirocinio.setIdRichiestaTirocinio(rs.getInt(1));
				richiestaTirocinio.setNomeTutorAccademico(rs.getString(2));
				richiestaTirocinio.setStatus(rs.getString(3));
				richiestaTirocinio.setData(rs.getDate(4));
				
				
			}
			
			con.close();
			
			return true;
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return false;
		

		
	}*/
		return null;
	}

}
