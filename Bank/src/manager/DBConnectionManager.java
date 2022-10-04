package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	
	private static DBConnectionManager instance;
	
	private Connection conn;
	
	public DBConnectionManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root");
			System.out.println(conn.isClosed() + " : 연결 됨.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnectionManager getInstance() {
		// getinstance -> singleton 디자인이란거를 간접적으로 알 수 있음..??
		if(instance == null)
			instance = new DBConnectionManager();
		return instance;
	}
	
	public Connection getConnection() {
		return this.conn;
	}

	
}
