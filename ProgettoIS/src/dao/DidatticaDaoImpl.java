package dao;

import bean.Didattica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;

/**
 * DAO che permette le operazioni sul database riguardanti la didattica.
 *
 */
public class DidatticaDaoImpl implements DidatticaDaoInterface {
  
  
  /**
   * Il metodo prende i parametri di login dal bean dell'user 
   * ed effettua la connessione al db. Se la query è riuscita ritorna status = true.
   * 
   * @author: Mario Procida
   */
  @Override
  public boolean loginUser(Didattica user) {
    boolean status = false;
    String email = user.getEmail();
    String password = user.getPassword();
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT * FROM didattica WHERE email = ? AND password = ?";
      preparedStatement = con.prepareStatement(query); 
      
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);
      
      ResultSet rs = preparedStatement.executeQuery();
      
      //ritorna true se trova l'utente
      status = rs.next(); 
      
      con.close();
    } catch (SQLException e) {

      e.printStackTrace();
    }
    
    return status;
  }
}
