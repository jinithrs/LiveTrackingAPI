package com.api.rest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String url = "jdbc:postgresql://localhost:5432/dishadb";
	private static final String user = "postgres";
	private static final String password = "Reading@123";

	public static Connection connect() {
		
        Connection conn = null;
        try {
        	Class.forName("org.postgresql.Driver");
        	
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 
        return conn;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection dbconn = new DBConnection();
		dbconn.connect();		
	}

}
