/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;
import org.chamerling.heroku.service.ParseException_Exception;

/**
 *
 * @author ASUS
 */
@ManagedBean(name = "listKomentar", eager = true)
@ViewScoped
public class ListKomentar {

    private List<org.chamerling.heroku.service.Komentar> arrKomentar;
    @ManagedProperty(value="#{viewPost.postId}")
    private String postid;
   
    public List<org.chamerling.heroku.service.Komentar> getArrKomentar(){
		return arrKomentar;
	}
	public void setArrKomentar(List<org.chamerling.heroku.service.Komentar> a){
		this.arrKomentar = a;
	}
	
	public void showPage(){
        try {
            //postid = id;
//		System.out.println("listkomentar="+postid);
//		arrKomentar = new ArrayList<>();
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//			 Class.forName(driver).newInstance();
//			 Connection conn = DriverManager.getConnection(url,userName,password);
//			 Statement st = conn.createStatement();
//			ResultSet res= st.executeQuery("Select * from komentar where postid="+postid);
//
//			Komentar komen = null;
//			while(res.next()){ 
//				komen = new Komentar();
//				komen.setCommentid(res.getString("commentid"));
//				komen.setNama(res.getString("Nama"));
//				komen.setEmail(res.getString("Email"));
//				komen.setKomentar(res.getString("Komentar"));                
//				komen.setTanggal(res.getString("Tanggal"));
//				System.out.println("komenid="+komen.commentid);
//				arrKomentar.add(komen);
//			}
//			conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            arrKomentar = new ArrayList<>();
            arrKomentar = hello.getListKomentar(postid);
        } catch (IOException_Exception | ParseException_Exception | JSONException_Exception | MalformedURLException_Exception ex) {
            Logger.getLogger(ListKomentar.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    public String getPostid(){
    return postid;}
    public void setPostid(String p){
    this.postid=p;}

}

