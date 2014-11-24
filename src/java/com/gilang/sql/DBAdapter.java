package com.gilang.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAdapter {

	Connection connection;
	Statement statement;
	PreparedStatement prepStatement;
	ResultSet resultSet;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tubes_wbd";
	String user = "root";
	String pass = "";
	
	public DBAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public void readDB(){
		try{
			
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
			prepStatement = connection.prepareStatement("insert into user values (?, ?, 1)");
			prepStatement.setString(1, "gilang");
			prepStatement.setString(2, "wohoho");
			prepStatement.executeUpdate();
			System.out.println("DB write");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

