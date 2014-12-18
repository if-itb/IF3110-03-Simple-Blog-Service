/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tubes2.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author adwisatya
 */
public class userPaket {
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
	public static boolean addUser(String nama, String username, String password, String email, String status){
		boolean statusOp = false;
		userPaket newUser = new userPaket();
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
		Map<String, userPaket> user1 = new HashMap<String, userPaket>();
		//user1.put(username, newUser);
		user1.put(username, newUser);
		userRef.setValue(newUser);
		return statusOp;
	}
	public static boolean delUser(String Username){
		boolean statusOp = false;
		userPaket newUser = new userPaket();
		Firebase ref = new Firebase("https://popping-fire-1228.firebaseio.com/");
		
		/* input ke firebase */
		Firebase userRef = ref.child("users");
		userRef.child(Username).removeValue();
		return statusOp;
	}
	public static boolean updateUser(String Nama, String Username,String Password, String Email, String Status){
		boolean statusOp = false;
		userPaket newUser = new userPaket();
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
		Map<String, userPaket> user1 = new HashMap<String, userPaket>();
		//user1.put(username, newUser);
		user1.put(Username, newUser);
		userRef.setValue(newUser);
		return statusOp;	
	}
	
	public static ArrayList<String> readUser(String Username) throws IOException {
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
	   return dataUser;
   }
}
