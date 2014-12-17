/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.ccw.heroku.service.UserModel;

/**
 *
 * @author christangga
 */
public class User {

	private String id;
	private String email;
	private String username;
	private String password;
	private String role;
	
	/**
	 * Creates a new instance of User
	 */
	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
	
	public void setUserFromUsermodel(UserModel userModel) {
		this.id = userModel.getId();
		this.username = userModel.getUsername();
		this.password = userModel.getPassword();
		this.email = userModel.getEmail();
		this.role = userModel.getRole();
	}
	
	@Override
	public String toString() {
		return String.valueOf(id) + " " + email + " " + username + " " + password + " " + role;
	}
}
