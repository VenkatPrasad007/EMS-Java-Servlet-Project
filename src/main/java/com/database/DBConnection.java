package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static final String URL = "jdbc:mysql://localhost:3306/ems";
	static final String USR = "root";
	static final String PWD = "root";

	public static Connection getConnnection() throws ClassNotFoundException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			con = DriverManager.getConnection(URL, USR, PWD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
