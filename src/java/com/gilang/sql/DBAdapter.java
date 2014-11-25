/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gilang.sql;

import com.gilang.beans.Post;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Gilang
 */
@ManagedBean(name="sql", eager=false)
@SessionScoped
public class DBAdapter {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/tubes_wbd";
	private String user = "root";
	private String pass = "";
	
	public DBAdapter(){
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Post getPost(int postID){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM post WHERE post_id = " + postID);
			if(resultSet.next()){
				int post_id = resultSet.getInt("post_id");
				String user_id = resultSet.getString("user_id");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String date = resultSet.getDate("date").toString();
				boolean published = resultSet.getBoolean("published");
				boolean deleted = resultSet.getBoolean("deleted");
				Post post = new Post(post_id, user_id, title, content, date, published, deleted);
				return post;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Post> getPosts(boolean unPublished){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			List<Post> postList = new ArrayList<>();
			statement = connection.createStatement();
			if(unPublished)
				resultSet = statement.executeQuery("SELECT * FROM post WHERE published=0");
			else
				resultSet = statement.executeQuery("SELECT * FROM post WHERE published=1");
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
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addPost(String user_id, String title, String date, String content){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			prepStatement = connection.prepareStatement("INSERT INTO post VALUES (default, ?, ?, ?, ?, 0, 0)");
			prepStatement.setString(1, user_id);
			prepStatement.setString(2, title);
			prepStatement.setString(3, content);
			String[] temp = date.split("-");
			prepStatement.setDate(4, new Date(Integer.valueOf(temp[0]), 
									Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
			prepStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				prepStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updatePost(String post_id, String user_id, String title, String date, String content){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			prepStatement = connection.prepareStatement("UPDATE post SET user_id=?, title=?, content=?, date=? WHERE post_id=" + Integer.valueOf(post_id));
			prepStatement.setString(1, user_id);
			prepStatement.setString(2, title);
			prepStatement.setString(3, content);
			String[] temp = date.split("-");
			prepStatement.setDate(4, new Date(Integer.valueOf(temp[0]), 
									Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
			prepStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				prepStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletePost(String postId){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			prepStatement = connection.prepareStatement("DELETE FROM post WHERE post_id=" + postId);
			prepStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				prepStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void publishPost(String postId){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			prepStatement = connection.prepareStatement("UPDATE post SET published=1 WHERE post_id=" + postId);
			prepStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				prepStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int checkCredential(String username, String password){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id='" + username + "' AND password='" + password + "'");
			if(resultSet.next())
				return resultSet.getInt("role");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public int getRole(String username){
		try{
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id='" + username + "'");
			if(resultSet.next())
				return resultSet.getInt("role");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
}
