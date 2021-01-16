package books.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/books";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "D3rek12@5G";
	private static DbConnection INSTANCE = new DbConnection();
	
	private Connection connection;
	
	private DbConnection() {
	}
	
	public static DbConnection getInstance() {
		return INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		//try {
			INSTANCE.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("Connection successful");
	//	}
	//	catch(SQLException e) {
	//		e.printStackTrace();
	//	}
	return connection;
	}		
}
