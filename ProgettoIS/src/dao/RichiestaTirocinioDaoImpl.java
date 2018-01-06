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

	/**
	 * Il metodo prende come parametro la richiesta di tirocinio da voler inoltrare ed
	 * Effettua la query di inserimento nel database
	 * @return ritorna true se la query ha successo 
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	
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


	/**
	 * Il metodo prende come parametro l'id della richiesta del tirocinio
	 * della quale cui si vuole accettare la richiesta
	 * @return ritorna true se la richiesta di tirocinio è accettata
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	
	@Override
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {


		Connection con = null;
		PreparedStatement preparedStatement=null;

		try
		{

			con = DBConnection.createConnection();
			String query ="UPDATE richiestatirocinio SET status='accettata' WHERE idRichiestaTirocinio= ?";
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setInt(1, richiestaTirocinio.getIdRichiestaTirocinio());

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
	 * @return ritorna un arrayList di Richieste Tirocinio che sono in attesa di approvazione
	 * 
	 * @author: Luca Lamberti , Francesco D'Auria
	 */
	
	@Override
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio() {


		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<RichiestaTirocinio> listaRichiesteTirocinio = new ArrayList<RichiestaTirocinio>();

		try
		{

			con = DBConnection.createConnection();
			String query =  "SELECT * FROM richiestatirocinio WHERE status='in attesa'";
			preparedStatement = con.prepareStatement(query); 


			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {

				RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();

				richiestaTirocinio.setIdRichiestaTirocinio(rs.getInt(1));
				richiestaTirocinio.setNomeTutorAccademico(rs.getString(2));
				richiestaTirocinio.setStatus(rs.getString(3));
				richiestaTirocinio.setData(rs.getDate(4).toString());
				richiestaTirocinio.setEmailTutAcc(rs.getString(5));
				richiestaTirocinio.setEmailDir(rs.getString(6));
				richiestaTirocinio.setMatricola(rs.getString(7));
				richiestaTirocinio.setIdTirocinio(rs.getInt(8));

				listaRichiesteTirocinio.add(richiestaTirocinio);

			}

			con.close();
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}


		return listaRichiesteTirocinio;



	}


}
