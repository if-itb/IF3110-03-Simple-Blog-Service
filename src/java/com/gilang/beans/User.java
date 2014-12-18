/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gilang.beans;

import com.gilang.sql.DBAdapter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import undeclared.service.Service;

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
	int role;
	
	public User(){
		faces = FacesContext.getCurrentInstance();
		request = (HttpServletRequest) faces.getExternalContext().getRequest();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("wbduser")){
					username = c.getValue();
					DBAdapter sql = new DBAdapter();
					role = sql.getRole(username);
				}
			}
		}
	}
	
	public void login(String username, String password){
		faces = FacesContext.getCurrentInstance();
		response = (HttpServletResponse) faces.getExternalContext().getResponse();
		//DBAdapter sql = new DBAdapter();
		if(!username.equals("guest"))
			role = checkCredential(username, password);
		else
			role = 4;
		if(role != -1){
			if(role == 4){
				Cookie cookie = new Cookie("wbduser", username);
				cookie.setMaxAge(30*60);
				response.addCookie(cookie);
				this.username = username;
			}
			else{
				Cookie cookie = new Cookie("wbduser", username);
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
				this.username = username;
			}
		}
	}
	
	public int checkCredential(String username, String password){
		List<undeclared.mavenproject1.User> users = Service.listUser();
		for(undeclared.mavenproject1.User u : users){
			System.out.println(u.getName());
			System.out.println(u.getEmail());
			System.out.println(u.getPassword());
		}
		for(undeclared.mavenproject1.User u : users){
			if(u.getName().equals(username) && u.getPassword().equals(password)){
				return u.getRole();
			}
		}
		return -1;
	}
	
	public void logout(){
		faces = FacesContext.getCurrentInstance();
		request = (HttpServletRequest) faces.getExternalContext().getRequest();
		response = (HttpServletResponse) faces.getExternalContext().getResponse();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("wbduser")){
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		username = null;
		role = -1;
	}
	
	public String getUsername(){
		return username;
	}
	
	public int getRole(){
		return role;
	}
	
	public static void main(String[] args){
		Service.addUser("guest", "", 4, "");
	}
}
