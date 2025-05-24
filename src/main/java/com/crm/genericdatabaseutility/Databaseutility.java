package com.crm.genericdatabaseutility;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class Databaseutility {
	Connection con;

	public void getDbconnection(String url, String username, String password) throws SQLException {
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}
	public void getDbconnection() throws SQLException {
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}

		return result;

	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}

		return result;

	}
	
	public void closeDbconnection() {
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			
		}
	}
	

}
