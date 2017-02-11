package allg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author mmuerz </br>
 *         </br>
 *         <b> Beschreibung </b></br>
 *         </br>
 *         Die AccessDB stellt eine Verbindung zur Datenbank her, und bietet die
 *         Moeglichkeit String queries an die Datenbank zu senden
 * 
 *         </br>
 * @attributes instance, ist eine Instanz der <b>{@link UserDAO}</b> dbaccess,
 *             ist eine Instanz der <b>{@link AcessDB}</b> Klasse
 *
 */

public class AccessDB {

	private static final String url = "jdbc:mysql://localhost/adressapp";
	private static final String passwort = "ItsMyLife!";
	private static final String user = "MyLife";
	private String query;
	private Statement stmt;
	private ResultSet result;
	private Connection connection;
	private boolean connected;

	public boolean isConnected() {
		return connected;
	}

	private static AccessDB instance;

	public static AccessDB getInstance() {
		if (instance == null) {
			instance = new AccessDB();

		}
		return instance;
	}

	private AccessDB() {
		super();
	}

	/**
	 * 
	 * Es wird eine verbindung mit der Datenbank hergestellt
	 * 
	 * @return <b>{@link #connected}</b> , boolean describing the connection
	 *         status
	 */
	public boolean connect() {
		connected = false;
		try {

			connected = true;
			Class.forName("com.mysql.jdbc.Driver");
			connection = (DriverManager.getConnection(url, user, passwort));

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException "+e.getMessage());
			connected = false;
		} catch (SQLException e) {
			System.out.println("SQLException "+e.getMessage());
			connected = false;
		}
		return connected;
	}

	/**
	 * 
	 * Es wird ein Statement auf der datenbank conneciton aufgebaut und der
	 * String qry ausgefuert.
	 * 
	 * @return <b>{@link #result}</b> , ResultSet
	 */
	public ResultSet executeQuery(String qry) {
		result = null;

		try {
			this.query = (qry);
			stmt = (connection.createStatement());
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * Es wird ein Statement auf der datenbank conneciton aufgebaut und der
	 * String qry ausgefuert.
	 * 
	 * @return int , Anzahl der geaenderten Zeilen
	 */
	public int executeUpdate(String qry) throws SQLException {
		if (connected) {
			stmt = connection.createStatement();
			return stmt.executeUpdate(qry);
		} else {
			throw new SQLException("Database not connected");
		}

	}

	/**
	 * 
	 * Die datenbank verbindung wird geschlossen
	 * 
	 * @return <b>{@link #connected}</b> , boolean der die connection angibt
	 */
	public boolean close() {
		connected = true;
		try {
			connection.close();
			connected = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connected;

	}

}
