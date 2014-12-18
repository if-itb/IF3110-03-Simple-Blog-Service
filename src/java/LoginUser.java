/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;
import service.User;

/**
 *
 * @author A 46 CB i3
 */
@Named(value = "loginUser")
@SessionScoped
public class LoginUser implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;
    
    //attribute
    private String username;
    private String password;
    private String role;
    private String email;
    private final int expiry;
    
    /**
     * Creates a new instance of LoginUser
     */
    public LoginUser() {
        expiry = 60*60*24;
    }
    
    // setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // getter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    private java.util.List<service.User> loadUser() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadUser();
    }
    
    public void load(String username){
        List<User> user = this.loadUser();
        int i = 0;
        boolean found = false;
        while(i < user.size() && !found) {
            if(user.get(i).getUsername().equals(username)){
                this.username = user.get(i).getUsername();
                this.password = user.get(i).getPassword();
                this.email = user.get(i).getEmail();
                this.role = user.get(i).getRole();
                found = true;
            }
            else {
                i++;
            }
        }
    }
    
    public boolean check(String username, String password) {
        List<User> user = this.loadUser();
        int i=0;
        boolean found = false;
        while(!found && i < user.size()) {
            if(user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)) {
                found = true;
            }
            else {
                i++;
            }
        }
        return found;
    }
    
    public void login(String username, String password) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        if(this.check(username, password)){
            this.load(username);
            Cookie usernameCookie = new Cookie("username", username);
            Cookie roleCookie = new Cookie("role", role);
            Cookie emailCookie = new Cookie("email", email);
            usernameCookie.setMaxAge(expiry);
            roleCookie.setMaxAge(expiry);
            emailCookie.setMaxAge(expiry);
            response.addCookie(usernameCookie);
            response.addCookie(roleCookie);
            response.addCookie(emailCookie);
            
            System.out.println("inirole"+role);
            switch (role) {
                case "admin":
                    response.sendRedirect("index.xhtml");
                    break;
                case "editor":
                    response.sendRedirect("publish.xhtml");
                    break;
                case "owner":
                    response.sendRedirect("index.xhtml");
                    break;
                default:
                    response.sendRedirect("index.xhtml");
                    break;
            }
        }
        else{
            response.sendRedirect("login.xhtml");
        }
    }
    
    public void logout() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Cookie usernameCookie = new Cookie("username", "");
        Cookie roleCookie = new Cookie("role", "");
        Cookie emailCookie = new Cookie("email", "");
        usernameCookie.setMaxAge(0);
        roleCookie.setMaxAge(0);
        emailCookie.setMaxAge(0);
        response.addCookie(usernameCookie);
        response.addCookie(roleCookie);
        response.addCookie(emailCookie);
        response.sendRedirect("index.xhtml");
    }
    
    public boolean isAdmin() {
        if (role != null) {
            return role.equals("admin");
        }
        
        return false;
    }
    
    public boolean isOwner() {
        if (role != null) {
            return role.equals("owner");
        }
        
        return false;
    }
    
    public boolean isEditor() {
        if (role != null) {
            return role.equals("editor");
        }
        
        return false;
    }
}
