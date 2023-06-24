package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import extras.GlobalConstants;

public class ConnectionClient {
	
	private static Connection client = null;
	
	private ConnectionClient() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			client = DriverManager.getConnection(GlobalConstants.DB, GlobalConstants.DB_USER, GlobalConstants.DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getClient() {
		if(client == null)
			new ConnectionClient();
		return client;
	}
}