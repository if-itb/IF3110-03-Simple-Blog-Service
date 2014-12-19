/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datatype;

/**
 *
 * @author SPM
 */
public class User {
    String userID;
    String password;
    String email;
    int role;
    
    public User(){
	userID = null;
	password = null;
	email = null;
	role = 0;
    }
    public User(String uid, String pw, String eml, int RP){
	userID = uid;
	password = pw;
	email = eml;
	role = RP; // 0 = Guest, 1 = Owner, 2 = Editor, 3 = Admin
    }
    
    public void setUserID(String uid){
	userID = uid;
    }
    public void setPW(String pw){
	password = pw;
    }
    public void setEmail(String eml){
	email = eml;
    }
    public void setRole(int RP){
	role = RP;
    }
    
    public String getUID(){
	return userID;
    }
    public String getPW(){
	return password;
    }
    public String getEM(){
	return email;
    }
    public int getrole(){
	return role;
    }
    
}
