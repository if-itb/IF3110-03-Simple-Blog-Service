/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riady
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.test.WSDLConnector;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*; 
import com.test.WSDLConnector;
import org.chamerling.heroku.service.UserModel;

@ManagedBean(name = "loginHandler",eager=true)
@SessionScoped
public class LoginHandler {
    private String username;
    private String password;
    private String email;
    private String cookiename = "username";
    private int expiry = 60*30;
    private int role; //0=guest, 1=owner, 2=editor, 3=admin 
    private Connection con;
    private boolean loginAttempted = false;
    private boolean loginSucc = false;
    private String test;

    
    
    public int getRole(){
        return role;
    }
    
    public boolean getLoginAttempted(){
        return loginAttempted&&!loginSucc;
    }
    
    public boolean getLoginSucc(){
        return loginSucc;
    }
    
    public LoginHandler(){
        username="";
        password="";
        email="";
        role=0;
    }
    
    public String getMail() {
        return email;
    }

    public void setMail(String emaill) {
        email = emaill;
    }
    
    public void setUsername(String user){
        username=user;
    }
    
    public String getUsername(){
		if(getCookie()!=null){
			String a = getCookie().getValue();
			if(a==null){
				return "";
			}
			else{
				return a;
			}
		}
		else{
			return "";
		}
    }
    
    public void setPassword(String pass){
        password=pass;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void login() throws IOException, SQLException, ClassNotFoundException{
        execute();
        if(!getLoginAttempted()){ 
           FacesContext facesContext = FacesContext.getCurrentInstance();
           Cookie userName = new Cookie(cookiename, username);
           userName.setMaxAge(expiry);
           HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
           response.addCookie(userName);
           response.sendRedirect("index.jsp");
        }
        
    }
    
    public void makeConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd_db","root","");
        
    }
    
    public void execute() throws SQLException, ClassNotFoundException{
        boolean loginB = false;
		List<UserModel> listUser = new ArrayList();
		listUser = WSDLConnector.listUser();
		int n;
		for(UserModel um : listUser){
			if(um.getUsername().equals(username)){
				if(um.getPassword().equals(password)){
					loginB=true;
					if(um.getRole().equals("owner")){
						role=1;
					}
					else if(um.getRole().equals("editor")){
						role=2;
					}
					else if(um.getRole().equals("admin")){
						role=3;
					}
					email = um.getEmail();
				}  
			}
		}
        loginSucc=loginB;
        loginAttempted = true;
      //  con.close();
    }
    
    public void logout() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Cookie cookie =getCookie();
        cookie.setValue(null);
        cookie.setMaxAge(0);
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(cookie);
        response.sendRedirect("faces/index.jsp");
        role=0;
    }
    
    
    
    public Cookie getCookie() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(cookiename)) {
                    cookie = userCookies[i];
                    return cookie;
                }
            }
        }
        return null;
    }
    
    public boolean isLogin(){
        Cookie cookie = getCookie();
        if(cookie==null){
            return false;
        }
        else{
            return cookie.getValue()!=null;
        }
    }
    
    public boolean isGuest(){
        return role==0;
    }
    
    public boolean isOwner(){
        return role==1;
    }
    
    public boolean isEditor(){
        return role==2;
    }
    
    public boolean isAdmin(){
        return role==3;
    }
}
