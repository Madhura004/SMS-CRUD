package com.util;

//import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class JDBCConnector {

	private static Connection connection = null;

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException  {
		if(connection == null) {
			//reading application.properties file
//			FileInputStream fis = new FileInputStream("application.properties");
//			
//			Properties dbconfig = new Properties();
//			dbconfig.load(fis);
//			
//			String url = (String) dbconfig.get("url");
//			String username = (String) dbconfig.get("username");
//			String password = (String) dbconfig.get("password");
//			String driver = (String) dbconfig.get("Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb1",  "root", "WJ28@krhps");
	
			//connection object-address
		}
		return connection;
	}
	
	
	public static void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		 }
	    }
	}
}