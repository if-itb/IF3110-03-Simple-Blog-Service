/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;
import org.chamerling.heroku.service.ParseException_Exception;

/**
 *
 * @author Anggi
 */
@ManagedBean(name = "userManagement", eager = true)
@RequestScoped
public class UserManagement {

	private List<org.chamerling.heroku.service.User> arrUser;

	
	public UserManagement(){
        try {
            //       try {
            //		arrUser = new ArrayList<>();
//		String url = "jdbc:mysql://localhost:3306/datapost";
//		String driver = "com.mysql.jdbc.Driver";
//		String userName = "root"; 
//		String password = "";
//		try {
//			Class.forName(driver).newInstance();
//			Connection conn = DriverManager.getConnection(url,userName,password);
//			Statement st = conn.createStatement();
//			ResultSet res= st.executeQuery("Select * from user");
//			User user = null;
//			while(res.next()){ 
//				user = new User();
//				user.setUserID(res.getString("username_id"));
//				user.setUsername(res.getString("username"));
//				user.setPassword(res.getString("password"));
//				user.setRole(res.getString("role"));                
//				user.setEmail(res.getString("email"));
//                                arrUser.add(user);
//			}
//			conn.close();
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		}
            //       arrUser=getListUser(); //nanti aja
            //    } catch (ParseException_Exception | JSONException_Exception | MalformedURLException_Exception | IOException_Exception ex) {
            //      Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);        }
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            arrUser = new ArrayList<>();
            
            arrUser = hello.getListUser();
        } catch (ParseException_Exception | JSONException_Exception | MalformedURLException_Exception | IOException_Exception ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public List<org.chamerling.heroku.service.User> getArrUser(){
		return arrUser;
	}
	
	
}
