package dao;

import bean.Azienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnection;

/**
 * DAO che permette le operazioni sul database riguardanti le aziende.
 *
 */
public class AziendaDaoImpl implements AziendaDaoInterface {
  
  
  /**
   * Il metodo registerUser prende i parametri dal bean e richiama il metodo di DBConnection 
   * per connettersi al database, per poi effettuare la query di inserimento.
   * Ritorna true se l'inserimento � andato a buon fine
   * 
   * @author:Mario Procida
   */
  @Override
  public boolean registerUser(Azienda user) {
    String nomeAzienda = user.getNomeAzienda();
    String partitaIva = user.getP_iva();
    String email = user.getEmail();
    String password = user.getPassword();
    String sede = user.getSede();
    String telefono = user.getTelefono();
    String uniqueID = user.getUniqueID();
    
    Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
      con = DBConnection.createConnection();
      String query = "insert into azienda(p_iva,nomeAzienda,email,password,sede,telefono,uniqueID) "
          + "values (?,?,?,?,?,?,?)"; 
      preparedStatement = con.prepareStatement(query); 
      preparedStatement.setString(1, partitaIva);
      preparedStatement.setString(2, nomeAzienda);
      preparedStatement.setString(3, email);
      preparedStatement.setString(4, password);
      preparedStatement.setString(5, sede);
      preparedStatement.setString(6, telefono);
      preparedStatement.setString(7, uniqueID);
      
      int i = preparedStatement.executeUpdate();

      // ritorna true se l'operazione � riuscita
      if (i != 0) {  
        con.close();
        return true; 
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }

    return false;  //ritorna false se non � riuscita
  }
  
  /**
   * Il metodo prende i parametri di login dal bean dell'user ed effettua la connessione al db. 
   * Se la query � riuscita ritorna status = true.
   * 
   * @author: Mario Procida
   */
  @Override
  public boolean loginUser(Azienda user) {
    boolean status = false;
    String email = user.getEmail();
    String password = user.getPassword();
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT * FROM azienda WHERE email = ? AND password = ?";
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

  /**
   * Il metodo restituisce la lista completa delle aziende convenzionate presenti nel DB. 
   * Istanzia un bean per ogni azienda e la aggiunge all'arraylist da restituire
   * 
   * @author: Luca Lamberti
   */
  @Override
  public ArrayList<Azienda> getAziendeConvenzionate() {
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ArrayList<Azienda> aziende = new ArrayList<Azienda>();
    
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT  azienda.nomeAzienda,azienda.email,azienda.telefono,"
          + "azienda.sede,azienda.p_iva,azienda.tutorAziendale, azienda.uniqueID FROM convenzione "
          + "INNER JOIN azienda ON convenzione.p_iva = azienda.p_iva "
          + "where convenzione.stato = 'approvata'";
      preparedStatement = con.prepareStatement(query); 
      
      
      ResultSet rs = preparedStatement.executeQuery();
      
      while (rs.next()) {
        
        Azienda azienda = new Azienda();
        
        azienda.setNomeAzienda(rs.getString(1));      
        azienda.setEmail(rs.getString(2));
        azienda.setTelefono(rs.getString(3));
        azienda.setSede(rs.getString(4));
        azienda.setP_iva(rs.getString(5));
        azienda.setTutorAziendale(rs.getString(6));
        azienda.setUniqueID(rs.getString(7));

        aziende.add(azienda);
        
      }
      
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
    return aziende;
  }
  
  /**
   * Il metodo restituisce la lista completa delle aziende presenti nel DB. 
   * Istanzia un bean per ogni azienda e la aggiunge all'arraylist da restituire
   * 
   * @author: Mario Procida, Francesco D'auria
   */
  @Override
  public ArrayList<Azienda> getAziende() {
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ArrayList<Azienda> aziende = new ArrayList<Azienda>();
    
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT * FROM azienda";
      preparedStatement = con.prepareStatement(query); 
      
      
      ResultSet rs = preparedStatement.executeQuery();
      
      while (rs.next()) {
        
        Azienda azienda = new Azienda();
        
        azienda.setP_iva(rs.getString(1));
        azienda.setNomeAzienda(rs.getString(2));
        azienda.setTutorAziendale(rs.getString(3));
        azienda.setEmail(rs.getString(4));
        azienda.setPassword(rs.getString(5));
        azienda.setSede(rs.getString(6));
        azienda.setTelefono(rs.getString(7));
        azienda.setUniqueID(rs.getString(8));

        aziende.add(azienda);
        
      }
      
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
    return aziende;
  }
  
  /**
   * Il metodo ritorna un istanza di azienda trovata dall'email passata come parametro.
   * 
   * @author:Mario Procida
   */
  @Override
  public Azienda getAziendaByEmail(String email) {
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    
    Azienda azienda = new Azienda();
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT * FROM azienda WHERE email = ?";
      preparedStatement = con.prepareStatement(query); 
      
      preparedStatement.setString(1, email);
      ResultSet rs = preparedStatement.executeQuery();
      
      while (rs.next()) {
        
        azienda.setP_iva(rs.getString(1));
        azienda.setNomeAzienda(rs.getString(2));
        azienda.setTutorAziendale(rs.getString(3));
        azienda.setEmail(rs.getString(4));
        azienda.setPassword(rs.getString(5));
        azienda.setSede(rs.getString(6));
        azienda.setTelefono(rs.getString(7));
        azienda.setUniqueID(rs.getString(8));
      
      }
      
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
    return azienda;
  }

  /**
   * Il metodo aggiunge il valore del tutorAziendale all' interno dell' azienda avente come 
   * partita iva piva.
   * 
   * @return: true se l'inserimento ha avuto successo 
   * 
   * @author: Luca Lamberti
   */
  @Override
  public boolean addTutorAziendale(String tutor, String piva) {
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    
    try {
      
      con = DBConnection.createConnection();
      String query = "UPDATE azienda SET tutorAziendale = ? WHERE p_iva= ?";
      preparedStatement = con.prepareStatement(query);
      
      preparedStatement.setString(1, tutor);
      preparedStatement.setString(2, piva);
      
      
      int rs = preparedStatement.executeUpdate();
      
      if (rs!=0 ) {
      
        con.close();
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
  }

  
  /**
   * Il metodo ritorna un istanza di azienda trovata dalla partita iva passata come parametro.
   * 
   * @author:Luca Lamberti, Simone Torluccio
   */
  @Override
  public Azienda getAziendaBypiva(String piva) {
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    
    Azienda azienda = new Azienda();
    try {
      
      con = DBConnection.createConnection();
      String query = "SELECT * FROM azienda WHERE p_iva = ?";
      preparedStatement = con.prepareStatement(query); 
      
      preparedStatement.setString(1, piva);
      ResultSet rs = preparedStatement.executeQuery();
      
      while (rs.next()) {
        
        azienda.setP_iva(rs.getString(1));
        azienda.setNomeAzienda(rs.getString(2));
        azienda.setTutorAziendale(rs.getString(3));
        azienda.setEmail(rs.getString(4));
        azienda.setPassword(rs.getString(5));
        azienda.setSede(rs.getString(6));
        azienda.setTelefono(rs.getString(7));
        azienda.setUniqueID(rs.getString(8));
      
      }
      
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
    return azienda;
  }
  
  

  
}
  


