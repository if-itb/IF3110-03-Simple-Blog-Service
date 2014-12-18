package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */

import com.firebase.client.Firebase;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sun.misc.IOUtils;
/**
 *
 * @author adwisatya
 */
public class User {
	public String nama;
	public String username;
	public String password;
	public String email;
	public String status;
	//public Date created;
	
	public String getNama(){
		return nama;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getStatus(){
		return status;
	}
	public String getTanggal(){
		//return new SimpleDateFormat("y-MMM-d").format(created);
		return null;
	}
	public void setNama(String input){
		this.nama = input;
	}
	public void setUsername(String input){
		this.username = input;
	}
	public void setPassword(String input){
		this.password = input;
	}
	public void setEmail(String input){
		this.email = input;
	}
	public void setStatus(String input){
		this.status = input;
	}
        public static ArrayList<String> JSONtoUser(String in) throws IOException {
            ArrayList<String> dataUser=new ArrayList<String>();
            try {
            JSONObject jsonUser = new JSONObject(in);
            dataUser.add(0,jsonUser.getString("nama"));
            dataUser.add(1,jsonUser.getString("username"));
            dataUser.add(2,jsonUser.getString("password"));
            dataUser.add(3,jsonUser.getString("email"));
            dataUser.add(4,jsonUser.getString("status"));
            } catch (JSONException ex) {
            dataUser.add(0,"Invalid User");
            dataUser.add(1,"Invalid Username");
            dataUser.add(2,"Invalid Passqword");
            dataUser.add(3,"Invalid Email");
            dataUser.add(4,"4");
            }
            return dataUser;
            }
	public static boolean addUser(String nama, String username, String password, String email, String status){
		boolean statusOp = false;
		User newUser = new User();
		Firebase ref = new Firebase("https://popping-fire-1228.firebaseio.com/");
		
		/* masukkan input ke atribut user baru */
		newUser.setNama(nama);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setStatus(status);
		
		/* input ke firebase */
		Firebase userRef = ref.child("users").child(username);
		Firebase newUserRef = userRef.push();
		Map<String, User> user1 = new HashMap<String, User>();
		//user1.put(username, newUser);
		user1.put(username, newUser);
		userRef.setValue(newUser);
		return statusOp;
	}
	public static boolean delUser(String Username){
		boolean statusOp = false;
		User newUser = new User();
		Firebase ref = new Firebase("https://popping-fire-1228.firebaseio.com/");
		
		/* input ke firebase */
		Firebase userRef = ref.child("users");
		userRef.child(Username).removeValue();
		return statusOp;
	}
	public static boolean updateUser(String Nama, String Username,String Password, String Email, String Status){
		boolean statusOp = false;
		User newUser = new User();
		Firebase ref = new Firebase("https://popping-fire-1228.firebaseio.com/");
		
		/* masukkan input ke atribut user baru */
		newUser.setNama(Nama);
		newUser.setUsername(Username);
		newUser.setPassword(Password);
		newUser.setEmail(Email);
		newUser.setStatus(Status);
		
		/* input ke firebase */
		Firebase userRef = ref.child("users").child(Username);
		Firebase newUserRef = userRef.push();
		Map<String, User> user1 = new HashMap<String, User>();
		//user1.put(username, newUser);
		user1.put(Username, newUser);
		userRef.setValue(newUser);
		return statusOp;	
	}
	
	/*public static ArrayList<String> readUser(String Username) throws IOException {
	   String URLi = "https://popping-fire-1228.firebaseio.com/users/";
	   ArrayList<String> dataUser = new ArrayList<String>();
	   try {
		URL url = new URL(URLi +Username+ ".json");
		URLConnection connection = url.openConnection();
		JSONObject jsonUser = new JSONObject(IOUtils.toString(connection.getInputStream()));
		dataUser.add(0,jsonUser.getString("nama"));
		dataUser.add(1,jsonUser.getString("username"));
		dataUser.add(2,jsonUser.getString("password"));
		dataUser.add(3,jsonUser.getString("email"));
		dataUser.add(4,jsonUser.getString("status"));
	   } catch (JSONException ex) {
		   
	   } catch (IOException ex) {

	   }
	   return dataUser;*/
}
