package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class DBConnection {
	
	private static final String driver = "net.sourceforge.jtds.jdbc.Driver";
	String connectionString; 	
		
	public DBConnection (String dbServer,String userName, String password){
		
		this.connectionString = dbServer+";user="+userName+";password="+password;
	}
	
	/**
	 * Make a connection to database and query the database
	 */ 
	
	public ResultSet queryDatabase (String sqlQuery){
		ResultSet resultSet = null;
		Log.info("Making a connection to database: "+connectionString);
		Log.info("Querying the database : "+sqlQuery);
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sqlQuery);
		} catch (ClassNotFoundException CNFE) {			
			Log.info(ExceptionUtils.getStackTrace(CNFE));
		} catch (SQLException SQLE) {			
			Log.info(ExceptionUtils.getStackTrace(SQLE));
		}
		
		return resultSet;
	}

}
