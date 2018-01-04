package util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe che istanzia la connessione con il database
 *
 */
public class DBConnection {

	public static Connection createConnection()
	{
		Connection con = null;
		try 
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tirociniosmart", "root", "root"); //attempting to connect to MySQL database
			System.out.println("Printing connection object "+con);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return con; 
	}

}
