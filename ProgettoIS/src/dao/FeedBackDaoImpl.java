package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Convenzione;
import bean.Feedback;
import util.DBConnection;

public class FeedBackDaoImpl implements FeedBackDaoInterface {

	
	/**
	 * Questo metodo salva i dati della valutazione dello studente da parte dell'azienda nel database.
	 * 
	 * @author Mario Procida ,Luca Lamberti
	 */
	@Override
	public boolean inviaFeedBackStudente(Feedback fb) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;


		try
		{

			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "feedback"
					+ " (data, valutazioneStudente, idTirocinio, p_iva, matricola) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1,"" + fb.getData());
			preparedStatement.setDouble(2, fb.getValutazioneStudente());
			preparedStatement.setInt(3, fb.getIdTirocinio());
			preparedStatement.setString(4, fb.getPiva());
			preparedStatement.setString(5, fb.getMatricola());


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
	 * Questo metodo effettua una query per ricercareil feedback tramite le tre chiavi passate come parametro.
	 * 
	 * @return Ritorna un istanza di feedback
	 * @author Mario Procida, Luca Lamberti
	 */
	@Override
	public Feedback getFeedBack(String piva, String matricola, int idTirocinio) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Feedback fb = new Feedback();

		try
		{
			con = DBConnection.createConnection();
			String query ="SELECT idFeedback, valutazioneStudente,valutazioneAzienda, data, idTirocinio, p_iva,matricola FROM feedback "
					+ "WHERE p_iva = ? AND matricola = ? AND idTirocinio = ? ";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, piva);
			preparedStatement.setString(2, matricola);
			preparedStatement.setInt(3, idTirocinio);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				fb.setIdFeedback(rs.getInt(1));
				fb.setValutazioneStudente(rs.getDouble(2));
				fb.setValutazioneAzienda(rs.getDouble(3));
				fb.setData("" + rs.getDate(4));
				fb.setPiva(rs.getString(5));
				fb.setMatricola(rs.getString(6));	
			}
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return fb;
	}
	
	/**
	 * Questo metodo salva i dati della valutazione dell'azienda da parte dello studente nel database.
	 * 
	 * @author Mario Procida
	 */
	@Override
	public boolean inviaFeedBackAzienda(Feedback fb) {
		Connection con = null;
		PreparedStatement preparedStatement = null;


		try
		{

			con = DBConnection.createConnection();
			String query ="INSERT INTO " + "feedback"
					+ " (data, valutazioneAzienda, idTirocinio, p_iva, matricola) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1,"" + fb.getData());
			preparedStatement.setDouble(2, fb.getValutazioneAzienda());
			preparedStatement.setInt(3, fb.getIdTirocinio());
			preparedStatement.setString(4, fb.getPiva());
			preparedStatement.setString(5, fb.getMatricola());


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
