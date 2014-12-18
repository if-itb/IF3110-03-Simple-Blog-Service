/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arina Listyarini DA
 */
@ManagedBean(name = "login")
@RequestScoped
public class Login {
    private String email;
    private String password;
    private String role;
    private String id;
    private String dbEmail;
    private String dbPassword;
    private String dbRole;
    private String dbId;
    
    public Login(){
        checkCookie();
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getDbRole(){
        return dbRole;
    }
    
    public String getId(){
        return id;
    }
    
    public String getDbEmail(){
        return dbEmail;
    }
    
    public String getDbPassword(){
        return dbPassword;
    }
    
    public String getDbId(){
        return dbId;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public void setDbEmail(String dbEmail){
        this.dbEmail = dbEmail;
    }
    
    public void setDbPassword(String dbPassword){
        this.dbPassword = dbPassword;
    }
    
    public void setDbRole(String dbRole){
        this.dbRole = dbRole;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setDbId(String dbId){
        this.dbId = dbId;
    }
    
    public void fetchDb(String email_){
        ListMember lm = new ListMember();
        if(lm.getMembers().size()>0){            
            int i = 0;
            while(!lm.getMembers().get(i).getEmail().equals(email_) && i < lm.getMembers().size()-1){
                i++;
            }
            if(i == lm.getMembers().size()-1){
                if(!lm.getMembers().get(lm.getMembers().size()-1).getEmail().equals(email_)){
                    i = lm.getMembers().size();
                }
            }
            if(i < lm.getMembers().size()){
                dbEmail = lm.getMembers().get(i).getEmail();
                dbId = lm.getMembers().get(i).getId();
                dbPassword = lm.getMembers().get(i).getPassword();
                dbRole = lm.getMembers().get(i).getRole();
            }
        }
    }
    
    public String startLogin(){
        fetchDb(email);
        System.out.println("ciao " + dbPassword + " " + password);
        if((email.equals(dbEmail)) && (password.equals(dbPassword))){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            
            Cookie cEmail = new Cookie("cEmail", email);
            Cookie cPassword = new Cookie("cPassword", password);
            Cookie cRole = new Cookie("cRole", dbRole);
            Cookie cId = new Cookie("cId", dbId);
            
            cEmail.setMaxAge(86400);
            cPassword.setMaxAge(86400);
            cRole.setMaxAge(86400);
            cId.setMaxAge(86400);
		  
            ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cEmail);
            ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cPassword);
            ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cRole);
            ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cId);
            return "success";
        }
        else{
            return "failure";
        }
    }
    
    public String startLogout(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        email = "";
        password = "";
        role = "";
        String id_ = "";
        
        Cookie cEmail = new Cookie("cEmail", email);
        Cookie cPassword = new Cookie("cPassword", password);
        Cookie cRole = new Cookie("cRole", role);
        Cookie cId = new Cookie("cId", id_);
        
        cEmail.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRole.setMaxAge(0);
        cId.setMaxAge(0);
		  
        ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cEmail);
        ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cPassword);
        ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cRole);
        ((HttpServletResponse)facesContext.getExternalContext().getResponse()).addCookie(cId);
        
        return "logout";
    }
    
    public void checkCookie(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String cookieName = null;
        Cookie cookie[] = ((HttpServletRequest)facesContext.getExternalContext().getRequest()).getCookies();
        if(cookie != null && cookie.length > 0){
            for(int i = 0; i<cookie.length; i++){
                cookieName = cookie[i].getName();
                if(cookieName.equals("cEmail")){
                    email = cookie[i].getValue();
                }
                else if(cookieName.equals("cPassword")){
                    password = cookie[i].getValue();
                }
                else if(cookieName.equals("cRole")){
                    role = cookie[i].getValue();
                }
            }
        }
        else{
            System.out.println("Cannot find any cookie");
        }
    }
}
