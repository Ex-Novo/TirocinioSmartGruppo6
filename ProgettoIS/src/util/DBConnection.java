package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe che istanzia la connessione con il database.
 *
 *@author Mario Procida
 */
public class DBConnection {

  /**
   * Crea la connessione con il database.
   * @return ritorna una nuova istanza di connessione
   */
  public static Connection createConnection() {
    Connection con = null;
    try {
      try {
        //loading MySQL drivers. This differs for database servers 
        Class.forName("com.mysql.jdbc.Driver");
        
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      //attempting to connect to MySQL database
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/tirociniosmart", "root", "root"); 
      System.out.println("Printing connection object " + con);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return con; 
  }

}
