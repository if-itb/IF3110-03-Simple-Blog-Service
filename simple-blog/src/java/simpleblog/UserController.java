package simpleblog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import simpleblog.model.CookieHelper;
import simpleblog.heroku.service.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import simpleblog.heroku.service.IOException_Exception;
import simpleblog.heroku.service.SimpleblogService;
import simpleblog.heroku.service.SimpleblogServiceImplService;
import simpleblog.model.Post;

/**
 *
 * @author Ichwan Haryo Sembodo
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable{
    
    private CookieHelper cookie;
    private User user;
    private String username;
    private String password;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        System.out.println("user ctrl dibuat");
        user = new User();
        user.setRole("guest");
        cookie = new CookieHelper();
    }

    public User loginValidator(String username, String password) throws IOException_Exception{
        SimpleblogService service = new SimpleblogServiceImplService().getSimpleblogServiceImplPort();
        user = service.getUser(username, password);
        
        return user;
    }
    
    /**
     * @return the user
     */
    public User getUser() throws IOException_Exception {
        return loginValidator(username, password);
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        System.out.println("set user");
        this.user = user;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        System.out.println("set username");
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        System.out.println("set password");
        this.password = password;
    }
    
    public boolean showEditHapus(int id){
        System.out.println("=========show edit hapus method=========");
        System.out.println("role diset = " + user.getRole());
        System.out.println("user id = " + user.getId());
        System.out.println("post user id = " + id);
        if(user.getRole().equals("admin"))
        {   
            return true;
        }
        else if(user.getRole().equals("owner") && user.getId() == id)
        {
            return true;
        }
        else if(user.getRole().equals("editor"))
        {
            return true;
        }
        return false;
    }    
    
    public String actionLogin() throws IOException_Exception{
        System.out.println("=========action login method=========");
        getUser();
        if(showEditHapus(user.getId())){
            cookie.setCookie("username", username, 86400);
            cookie.setCookie("password", password, 86400);
            return "";
        }
        else return "";
    }

    /**
     * @return the cookie
     */
    public CookieHelper getCookie() {
        return cookie;
    }

    /**
     * @param cookie the cookie to set
     */
    public void setCookie(CookieHelper cookie) {
        this.cookie = cookie;
    }
    
    public boolean isUsernamePasswordExist() throws IOException_Exception{
        System.out.println("=========is Username Password exist method=========");
        if(cookie.getCookie("username") != null && cookie.getCookie("password") != null){
            System.out.println("username cookie = " + cookie.getCookie("username").getValue());
            System.out.println("password cookie = " + cookie.getCookie("password").getValue());
            if(user.getRole().equals("guest")){
                if(username == null && password == null){
                    setUsername(cookie.getCookie("username").getValue());
                    setPassword(cookie.getCookie("password").getValue());
                    getUser();
                    if(showEditHapus(user.getId())){
                        System.out.println("cookie != null dan guest dan username & password == null dan valid");
                        return true;
                    }
                    else{
                        System.out.println("cookie != null dan guest dan username & password == null dan tidak valid");
                        return false;
                    } 
                }
                else {
                    if(username.equals("") && password.equals("")){
                        System.out.println("cookie != null dan guest dan username & password = ''");
                        return false;
                    }
                    else{
                        System.out.println("cookie != null dan guest dan username & password = " + username + " & " + password);
                        return true;
                    }
                }
            }
            else {
                System.out.println("cookie != null dan !guest dan username & password != null");
                return true;
            }
        }
        else{
            if(username != null && password != null){
                if(showEditHapus(user.getId())){
                    System.out.println("cookie = null dan username & password != null dan valid");
                    return true;
                }
                else {
                    System.out.println("cookie = null dan username & password != null dan tidak valid");
                    return false;
                }
            }
            else {
                System.out.println("cookie = null dan username & password = null");
                return false;
            }
        }
    }
    
    public String actionLogout(){
        System.out.println("=========action logout method=========");
        cookie.setCookie("username", null, 0);
        cookie.setCookie("password", null, 0);
        User tmp = new User();
        user = tmp;
        user.setRole("guest");
        setUsername("");
        System.out.println("set username to null");
        setPassword("");
        System.out.println("set password to null");
        System.out.println("cookie dihapus");
        System.out.println("username time left = "+cookie.getCookie("username").getMaxAge());
        System.out.println("password time left = "+cookie.getCookie("password").getMaxAge());
        System.out.println("username cookie = " + cookie.getCookie("username").getValue());
        System.out.println("password cookie = " + cookie.getCookie("password").getValue());
        return "";
    }
    
    public void redirect() throws IOException{
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("faces/index.xhtml");
    }
    
    public void test(){
        System.out.println("=======================selesai iterasi==========================");
    }
    
    public boolean isAdmin(){
        return user.getRole().equals("admin");
    }
    
    public boolean isOwner(){
        return user.getRole().equals("owner");
    }
    
    public boolean isEditor(){
        return user.getRole().equals("editor");
    }
    
    public boolean isGuest(){
        return user.getRole().equals("guest");
    }
    
}
