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
	
	public int id;
	public String name;
	public String email;
	public int role;
	public String password;
	
	public User(){
		
	}
	
	public User(int id, String name, String email, int role, String password){
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}
	
	public User(int id, String name, String email, int role){
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
}
