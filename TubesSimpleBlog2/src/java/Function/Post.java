/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Anggi
 */
@ManagedBean(name = "post", eager = true)
@ViewScoped
public class Post {

    
	private String IDPost;
	private String title;
	private String content;
	private Date date;
	private String status;
        private String deletedStatus;
	
        public String getDeletedStatus(){
            return deletedStatus;
        }
        public void setDeletedStatus(String st){
            this.deletedStatus = st;
        }
	public String getIDPost(){
		return IDPost;
	}
	public String getStatus(){
		return status;
	}
	public String getTitle(){
		return title;
	}
	public String getContent(){
		return content;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setContent(String content){
		this.content = content;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public void setIDPost(String id){
		this.IDPost = id;
	}
	    
	public String addPost(){
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//			java.sql.Date sqlDate= new java.sql.Date(date.getTime());
//			Class.forName(driver).newInstance();
//			Connection conn = DriverManager.getConnection(url,userName,password);
//			String insertToDB = "insert into posts (`Judul`,`Tanggal`,`Konten`,`Status`,`Delete`) value (?,?,?,?,?)";
//			PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//			preparedStatement.setString(1, this.title);
//			preparedStatement.setDate(2, sqlDate);
//			preparedStatement.setString(3, this.content);
//			preparedStatement.setString(4, "unpublished");
//			preparedStatement.setString(5, "notdeleted");
//			preparedStatement.executeUpdate();
//			conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            Calendar currentDate = Calendar.getInstance(); //Get the current date
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd"); //format it as per your requirement
            String dateNow = formatter.format(currentDate.getTime());
            hello.addPost(this.title, this.content, dateNow);
            return "unpublished_post?faces-redirect=true";
	}

	public void showPost(String id){
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try{
//			Class.forName(driver).newInstance();
//			Connection conn = DriverManager.getConnection(url,userName,password);
//			Statement st = conn.createStatement();
//			ResultSet res = st.executeQuery("Select * from posts where pid = " +id);
//
//			if(res.next()){
//				title = res.getString("Judul");
//				date = res.getDate("Tanggal");
//				content = res.getString("Konten");
//				IDPost = id;
//			}
//			conn.close();
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            org.chamerling.heroku.service.Post temp = new org.chamerling.heroku.service.Post();
            try{
                temp = hello.showPost(id);
                title = temp.getTitle();
                
                DateFormat dformatter = new SimpleDateFormat("yyyy-MM-DD"); 
                date = (Date)dformatter.parse(temp.getDate());
                
                content = temp.getContent();
                IDPost = id;
            } catch (Exception e) { }
            
            
	}

	public String editPost(){
//		System.out.println("idedit="+IDPost);
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//			java.sql.Date sqlDate= new java.sql.Date(date.getTime());
//			Class.forName(driver).newInstance();
//			Connection conn = DriverManager.getConnection(url,userName,password);
//			String insertToDB = "update posts set Judul =?, Tanggal =? ,Konten=? where PID=?";
//			PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//			preparedStatement.setString(1, this.title);
//			preparedStatement.setDate(2, sqlDate);
//			preparedStatement.setString(3, this.content);
//			preparedStatement.setString(4,IDPost);
//			preparedStatement.executeUpdate();
//			conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd"); //format it as per your requirement
            String myDate = formatter.format(this.date);
            hello.editPost(this.title,this.content,myDate,this.IDPost);
		return "index?faces-redirect=true";
	}
		
	public String deletePost(String id){
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//		   Class.forName(driver).newInstance();
//		   Connection conn = DriverManager.getConnection(url,userName,password);
//                   String insertToDB = "update posts set `Delete`='deleted' where PID=?";
//		   PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//		   preparedStatement.setString(1,id);
//		   preparedStatement.executeUpdate();
//		   conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            hello.deletePost(id);
            return "index?faces-redirect=true";
         }
        
        public String restorePost(String id){
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//                System.out.println("masuk restore");
//		try {
//		   Class.forName(driver).newInstance();
//		   Connection conn = DriverManager.getConnection(url,userName,password);
//                   String insertToDB = "update posts set `Delete`='notdeleted' where PID=?";
//		   PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//		   preparedStatement.setString(1,id);
//		   preparedStatement.executeUpdate();
//		   conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            hello.restorePost(id);
		return "deleted_post?faces-redirect=true";
         }
     
	public String changeStatus(String id){
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//			Class.forName(driver).newInstance();
//			Connection conn = DriverManager.getConnection(url,userName,password);
//
//			String insertToDB = "update posts set Status='published' where PID=?";
//			PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//			preparedStatement.setString(1,id);
//			preparedStatement.executeUpdate();
//			conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            hello.publishPost(id);
		return "unpublished_post?faces-redirect=true";
     } 



        

 
}
