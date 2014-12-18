/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@ManagedBean(name="login_bean")
public class login_bean implements Serializable {
    private String username;
    private String password;
    private boolean remember;
    private String role;
    public static String passMySql = "9999";
    
    public login_bean(){
        this.checkCookie();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null){
            session.invalidate();;
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean getRemember(){
        return remember;
    }
    
    public void setRemember(boolean remember){
        this.remember = remember;
    }
    
    public String getRole(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String navto;
        if (request.isUserInRole("admin")){
            navto = "admin";
        } else if (request.isUserInRole("editor")){
            navto = "editor";
        } else if (request.isUserInRole("owner")){
            navto = "owner";
        } else {
            navto ="guest";
        }
        return navto;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String login(){
        String message="";
        String navto="";
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            request.login(username, password);
            
            Principal principal = request.getUserPrincipal();
            
            if (request.isUserInRole("admin")){
                message = "Username: " + principal.getName() + " You are an Admin";
                navto = "admin";
            } else if (request.isUserInRole("editor")){
                message = "Username: " + principal.getName() + " You are an editor";
                navto = "editor";
            } else if (request.isUserInRole("owner")){
                message = "Username: " + principal.getName() + " You are an owner";
                navto = "owner";
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
            System.out.println("navto = " + navto);
            this.doCookie();
            return navto;
        } catch (ServletException ex) {
            Logger.getLogger(login_bean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error occured: Login failed", null));
            ex.printStackTrace();
        }
        return "failure";
    }
    
    public void logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null){
            session.invalidate();;
        }
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/login.xhtml");
    }
    
    public void doCookie(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        Cookie usercookie = new Cookie("usercookie", username);
        Cookie passcookie = new Cookie("passcookie", password);
        
        String rememberstr;
        if (remember == false){
            rememberstr = "false";
        } else {
            rememberstr = "true";
        }
        
        Cookie remembercookie = new Cookie("remembercookie", rememberstr);
        
        usercookie.setMaxAge(86400);
        passcookie.setMaxAge(86400);
        remembercookie.setMaxAge(86400);
        
        ((HttpServletResponse) facesContext.getExternalContext().getResponse()).addCookie(usercookie);
        ((HttpServletResponse) facesContext.getExternalContext().getResponse()).addCookie(passcookie);
        ((HttpServletResponse) facesContext.getExternalContext().getResponse()).addCookie(remembercookie);
    }
    
    public void checkCookie(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String cookiename, rememberstr;
        Cookie cookies[] = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getCookies();
        if ((null != cookies) && (cookies.length > 0)){
            for (int i=0; i<cookies.length; i++){
                cookiename = cookies[i].getName();
                if (cookiename.equals("usercookie")){
                    this.username = cookies[i].getValue();
                } else if(cookiename.equals("passcookie")){
                    this.password = cookies[i].getValue();
                } else if(cookiename.equals("remembercookie")){
                    rememberstr = cookies[i].getValue();
                    if (rememberstr.equals("true")){
                        this.remember = true;
                    } else if (rememberstr.equals("false")){
                        this.remember = false;
                    }
                }
            }
        } else {
            System.out.println("Cannot find any cookie");
        }
    }
}
