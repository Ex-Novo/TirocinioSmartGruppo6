package dao;

import java.util.ArrayList;

import bean.RichiestaTirocinio;

/**
 * DAO che permette le operazioni sul database riguardanti le richieste  di tirocinio
 *
 */
public class RichiestaTirocinioDaoImpl implements RichiestaTirocinioDaoInterface {

	@Override
	public boolean invioRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
		/*	
		 * IMPLEMENTAZIONE FRANCESCO
		 * 
		 * 
		 * Connection con = null;
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
				
				
			}
			
			con.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return richiesteTirocinio;
	}
*/
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
