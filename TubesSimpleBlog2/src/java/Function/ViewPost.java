/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;
import org.chamerling.heroku.service.ParseException_Exception;
import org.chamerling.heroku.service.Post;

/**
 *
 * @author ASUS
 */
@ManagedBean(name = "viewPost", eager = true)
@SessionScoped
public class ViewPost{

    private String postId;
    private String judul;
    private String konten;
    private Date tanggal;
	
    public String showPage(String id) throws ParseException{
        try {
            //        postId = id;
//        System.out.println("viewpost="+id);
//        String url = "jdbc:mysql://localhost:3306/datapost";
//        String driver = "com.mysql.jdbc.Driver";
//        String userName = "root"; 
//        String password = "";
//         try {
//            Class.forName(driver).newInstance();
//            Connection conn = DriverManager.getConnection(url,userName,password);
//            Statement st = conn.createStatement();
//            ResultSet res= st.executeQuery("Select * from posts where PID = "+id);
//
//            if(res.next()){
//                judul=res.getString("Judul");
//                tanggal = res.getDate("Tanggal");                
//                konten = res.getString("Konten");
//                postId = id;
//            }
//            conn.close();
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//            }
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
         org.chamerling.heroku.service.Post temp = new org.chamerling.heroku.service.Post();
                temp = hello.showPost(id);
                judul = temp.getTitle();
                
                DateFormat dformatter = new SimpleDateFormat("yyyy-MM-DD"); 
                tanggal = (Date)dformatter.parse(temp.getDate());
                
                konten = temp.getContent();
                postId = id;
                System.out.println("postid="+postId);
            
        } catch (JSONException_Exception | IOException_Exception | MalformedURLException_Exception | ParseException_Exception ex) {
            Logger.getLogger(ViewPost.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "view_post";
    }
	
    public String getPostId(){
            return postId;
    }
    
    public String getJudul(){
            return judul;
    }
    
    public String getKonten(){
            return konten;
    }
    
    public Date getTanggal(){
            return tanggal;
    }
	
    public void setPostId(String postId){
            this.postId = postId;
    }
    public void setJudul(String judul){
            this.judul = judul;
    }
    public void setKonten(String konten){
            this.konten = konten;
    }
    public void setTanggal(Date tanggal){
            this.tanggal = tanggal;
    }


    

 }
