package com.gilang.sql;

import com.gilang.beans.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="sql", eager=false)
@SessionScoped
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
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Post> getPosts(){
		try{
			List<Post> postList = new ArrayList<>();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM post");
			while(resultSet.next()){
				int post_id = resultSet.getInt("post_id");
				String user_id = resultSet.getString("user_id");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String date = resultSet.getDate("date").toString();
				boolean published = resultSet.getBoolean("published");
				boolean deleted = resultSet.getBoolean("deleted");
				postList.add(new Post(post_id, user_id, title, content, date, published, deleted));
			}
			return postList;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void readDB(){
		try{
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

