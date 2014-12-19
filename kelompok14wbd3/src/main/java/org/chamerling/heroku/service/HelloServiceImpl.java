/**
 * 
 */
package org.chamerling.heroku.service;

import com.firebase.client.Firebase;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import datatype.*;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {

    Firebase ref = new Firebase("https://wbd3.firebaseio.com/");
    String allJsonString = new String();
    JSONObject AllData = new JSONObject();
    /**
     * This is a sample web service operation
     */
    public HelloServiceImpl() {
	try{
	    InputStream in = new URL("https://wbd3.firebaseio.com.json").openStream();
	    allJsonString = IOUtils.toString(in);
	    IOUtils.closeQuietly(in);
	    AllData = new JSONObject(allJsonString);
	}
	catch (Exception E){}
    }
    
    public void updateJSONString(){
	try{
	    InputStream in = new URL("https://wbd3.firebaseio.com.json").openStream();
	    allJsonString = IOUtils.toString(in);
	    IOUtils.closeQuietly(in);
	    AllData = new JSONObject(allJsonString);
	}
	catch (Exception E){}
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public boolean addPost(@WebParam(name = "title") String title, @WebParam(name = "content") String content, @WebParam(name = "date") String date, @WebParam(name = "authorid") String authorid) {
	//TODO write your implementation code here:
   	Firebase Postref = ref.child("post").push();
	Map<String, String> tempMap = new HashMap();
	
	tempMap.put("authorid", authorid);	
	tempMap.put("postcontent", content);
	tempMap.put("postdate", date);
	tempMap.put("titlepost", title);
	tempMap.put("status", "unpublished");
	
	Postref.setValue(tempMap);
	updateJSONString();
	//done
	return true;
    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost") 
    public boolean editPost(@WebParam(name = "postid") String postid, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) { 
	Firebase Postref = ref.child("post").child(postid);
	Map<String, Object> tempMap = new HashMap();
		
	tempMap.put("postcontent", konten);
	tempMap.put("postdate", tanggal);
	tempMap.put("titlepost", judul);
	
	Postref.updateChildren(tempMap);
	updateJSONString();
	//done
	return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public boolean publishPost(@WebParam(name = "id") String id) {
	//TODO write your implementation code here:
	ref.child("post").child(id + "/status").setValue(true);
	
	updateJSONString();
	return true; 
	
	//done
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public List<post> listPost() {
	//TODO write your implementation code here:
	
	    
	    
	try {
	InputStream in = new URL("https://wbd3.firebaseio.com/.json").openStream();
	String allString = IOUtils.toString(in);
	IOUtils.closeQuietly(in);
	JSONObject AllDat = new JSONObject(allString);
	    JSONObject J = AllDat.getJSONObject("post");
	    Iterator<String> postIterator = J.keys();
	    post P = new post();
	    List<post> lisp = new ArrayList<post>();
	    
	    while (postIterator.hasNext()) {
		P.setPost(postIterator.next() , J.getString("authorid"), J.getString("judul"), J.getString("konten"), J.getString("tanggal"));
		lisp.add(P);
	    }
	    return lisp;
	}
	catch (Exception E){}
	return null;
    }

    /**
     */
    @WebMethod(operationName = "deletePost")
    public boolean deletePost(@WebParam(name = "postid") String postid) {
	//TODO write your implementation code here:
	ref.child(postid).removeValue();
	//done
	return true;
   }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
	//TODO write your implementation code here:
	Firebase newUser = ref.child("User").push();
	Map<String, String> tempMap = new HashMap();
	
	tempMap.put("nama", nama);	
	tempMap.put("email", email);
	tempMap.put("role", role);
	
	newUser.setValue(tempMap);
	//done
	return true;
    }
    
    @WebMethod(operationName = "listUser")
    public List<User> listUser(){
	try {
	    JSONObject J = AllData.getJSONObject("User");
	    Iterator<String> postIterator = J.keys();
	    User U = new User();
	    List<User> lisp = new ArrayList<User>();
	    
	    while (postIterator.hasNext()) {
		U.setEmail(J.getString("email"));
		U.setPW(J.getString("password"));
		String rl = J.getString("role");
		
		if (rl.equalsIgnoreCase("admin")) { U.setRole(3); }
		else if (rl.equalsIgnoreCase("editor")) { U.setRole(2); }
		else if (rl.equalsIgnoreCase("owner")) { U.setRole(1); }
		U.setUserID(postIterator.next());
		
		lisp.add(U);
	    }
	    
	    return lisp;
	}
	catch (Exception E){}
	return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
	//TODO write your implementation code here:
	Firebase newUser = ref.child("User").child(id);
	Map<String, Object> tempMap = new HashMap();
	
	tempMap.put("nama", nama);	
	tempMap.put("email", email);
	tempMap.put("role", role);
	
	newUser.updateChildren(tempMap);
	//done
	return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name = "id") String id) {
	//TODO write your implementation code here:
	Firebase deletesThis = ref.child("User").child(id);
	deletesThis.removeValue();
	return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public boolean addComment(@WebParam(name = "postid") String postid, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
	//TODO write your implementation code here:
	Firebase newComm = ref.child(postid + "/komentar").push();
	Map<String, String> tempMap = new HashMap();
	
	tempMap.put("nama", nama);	
	tempMap.put("email", email);
	tempMap.put("konten", konten);
	tempMap.put("tanggal", tanggal);
	
	newComm.setValue(tempMap);
	
	
	return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteComment")
    public boolean deleteComment(@WebParam(name = "postid") String postid, @WebParam(name = "commid") String commid) {
	//TODO write your implementation code here:
	Firebase delComm = ref.child(postid + "/komentar" + commid);
	delComm.removeValue();
	return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public ArrayList search(@WebParam(name = "query") String query) {
	//TODO write your implementation code here:
	return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public ArrayList listComment(@WebParam(name = "postid") String postid) {
	try {
	    JSONObject J = AllData.getJSONObject("post");
	    Iterator<String> postIterator = J.keys();
	    Komentar K  = new Komentar();
	    ArrayList<Komentar> lisp = new ArrayList<Komentar>();
	    JSONObject KomenObject;
	    while (postIterator.hasNext()) {
		if (postIterator.next().equalsIgnoreCase(postid)){
		    KomenObject = J.getJSONObject("komentar");
		    Iterator<String> cI = KomenObject.keys();
		    while(cI.hasNext()){
			K.setKomentar(KomenObject.getString("konten"), KomenObject.getString("tanggal"), KomenObject.getString("name"));
			lisp.add(K);
		    }
				
		}
	    }
	    
	    return lisp;
	}
	catch (Exception E){}
	return null;
    }
    public String getUserID(@WebParam(name = "username") String username){
	try {
	    JSONObject J = AllData.getJSONObject("User");
	    Iterator<String> postIterator = J.keys();
	    String uid = new String();
	    boolean found = false;
	    while (!found){
		if (postIterator.hasNext()){
		    uid = postIterator.next();
		    found = (J.get("nama")).toString().compareToIgnoreCase(username) == 0;
		    
		}
	    }
	    return uid;
	    
	}catch (Exception E){}
	return null;
	
    }
    public String getRolebyUsername(String username){
	try {
	    JSONObject J = AllData.getJSONObject("User");
	    Iterator<String> postIterator = J.keys();
	    String uid = new String();
	    String role = new String();
	    boolean found = false;
	    while (!found){
		if (postIterator.hasNext()){
		    uid = postIterator.next();
		    found = (J.get("nama")).toString().compareToIgnoreCase(username) == 0;
		    if (found){
			role = J.getString("role");
		    }
		    
		}
	    }
	    return role;
	}
	catch (Exception E){}
	return null;
    }
    
    
    
}
