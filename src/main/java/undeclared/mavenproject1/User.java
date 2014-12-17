/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package undeclared.mavenproject1;

/**
 *
 * @author Gilang
 */
public class User {
	
	int id;
	String name;
	String email;
	String role;
	
	public User(){
		
	}
	
	public User(int id, String name, String email, String role){
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
}
