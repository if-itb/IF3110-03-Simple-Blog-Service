/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.datastructure;

/**
 *
 * @author user
 */
public class ServiceUser {
        
    private String key, username , email, role , password ; 
    
    public ServiceUser() {
    	
    }
    
    public ServiceUser (String key, String username, String email, String role, String password){
        this.key = key;
        this.username = username ;
        this.email = email;
        this.role = role ;
        this.password = password;
		
    }
    
    public String getKey ()
    {
           return key;
    }
    public String getUsername ()
    {
     return username;
    }
    
    public String getEmail ()
    {
        return email;
    }
    
    public String getRole ()
    {
        return role;
    }
    
    public String getPassword ()
    {
        return password;
    }
   
    public void setKey (String key)
    {
      this.key = key;
    }
    
    public void setUsername (String username)
    {
      this.username = username;
    }
    
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    public void setRole (String role)
    {
        this.role = role;
    }
    
    public void setPassword (String password)
    {
        this.password = password;
    }
}