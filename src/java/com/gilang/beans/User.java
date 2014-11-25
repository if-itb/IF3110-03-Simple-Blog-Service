/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gilang.beans;

import com.gilang.sql.DBAdapter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilang
 */
@ManagedBean(name="user", eager=true)
public class User {
	
	FacesContext faces;
	HttpServletRequest request;
	HttpServletResponse response;
	String username;
	
	public User(){
		faces = FacesContext.getCurrentInstance();
		request = (HttpServletRequest) faces.getExternalContext().getRequest();
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("wbduser"))
				username = c.getValue();
		}
		System.out.println("created");
	}
	
	public void login(String username, String password){
		faces = FacesContext.getCurrentInstance();
		response = (HttpServletResponse) faces.getExternalContext().getResponse();
		DBAdapter sql = new DBAdapter();
		if(sql.checkCredential(username, password)){
			Cookie cookie = new Cookie("wbduser", username);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			this.username = username;
		}
	}
	
	public void logout(){
		faces = FacesContext.getCurrentInstance();
		request = (HttpServletRequest) faces.getExternalContext().getRequest();
		response = (HttpServletResponse) faces.getExternalContext().getResponse();
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("wbduser")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		username = null;
	}
	
	public String getUsername(){
		return username;
	}
}
