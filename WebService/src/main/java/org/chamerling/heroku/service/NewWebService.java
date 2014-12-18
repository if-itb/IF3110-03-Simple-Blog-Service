/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.chamerling.heroku.service;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.*;
import org.json.*;

/**
 *
 * @author Afik
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten, @WebParam(name = "published") int published, @WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/post/");
        
        Map<String, Object> post = new HashMap<String, Object>();
        post.put("judul",judul);
        post.put("tanggal",tanggal);
        post.put("konten",konten);
        post.put("published",published);
        post.put("author",author);
        ref.push().setValue(post);
        return true;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getUnpublishedPost")
    public ArrayList<Post> getUnpublishedPost() {
        //TODO write your implementation code here:
        ArrayList<Post> listUnpublishedPost = new ArrayList<Post>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post");
        try {
            URLConnection conn = (new URL(post.toString() + ".json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject postsJSON = new JSONObject(jsonString);
            JSONArray postIDJSON = postsJSON.names();
            System.out.println(postIDJSON.length());
            for (int it = 0; it < postIDJSON.length(); ++it) {
                String postID = postIDJSON.getString(it);
                JSONObject postJSON = postsJSON.getJSONObject(postID);
                Post _post;
                _post = new Post();
                _post.setAuthor(postJSON.getString("author"));
                _post.setDate(postJSON.getString("date"));
                _post.setJudul(postJSON.getString("judul"));
                listUnpublishedPost.add(_post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUnpublishedPost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "PID") int PID, @WebParam(name = "published") int published, @WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten, @WebParam(name = "author") String author) {
        // Get a reference to our posts
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post/"+PID);
        Map<String, Object> postMap = new HashMap<String, Object>();
        postMap.put("judul",judul);
        postMap.put("tanggal",tanggal);
        postMap.put("konten",konten);
        postMap.put("published",published);
        postMap.put("author",author);
        post.updateChildren(postMap);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "PID") int PID) {
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post/"+PID);
        post.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "PID") int PID) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post/"+PID);
        Map<String, Object> postMap = new HashMap<String, Object>();
        postMap.put("published",1);
        post.updateChildren(postMap);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "role") int role, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/user/");
        
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("username",username);
        user.put("password",password);
        user.put("role",role);
        user.put("email",email);
        
        ref.push().setValue(user);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public ArrayList<UserBean> listUser() throws Exception {
        //TODO write your implementation code here:
        ArrayList<UserBean> allUser = new ArrayList<UserBean>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("user");
        try {
            URLConnection conn = (new URL(post.toString() + ".json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject usersJSON = new JSONObject(jsonString);
            JSONArray usersIDJSON = usersJSON.names();
            System.out.println(usersIDJSON.length());
            for (int it = 0; it < usersIDJSON.length(); ++it) {
                String userID = usersIDJSON.getString(it);
                JSONObject userJSON = usersJSON.getJSONObject(userID);
                UserBean user = new UserBean();
                user.setEmail(userJSON.getString("email"));
                user.setUsername(userJSON.getString("username"));
                user.setPassword(userJSON.getString("password"));
                user.setRole(userJSON.getInt("role"));
                allUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUser;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "role") int role, @WebParam(name = "email") String email) {
       Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase user = ref.child("user/"+username);
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("username",username);
        userMap.put("password",password);
        userMap.put("role",role);
        userMap.put("email",email);
        user.updateChildren(userMap);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "username") String username) {
       Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
       Firebase user = ref.child("user/"+username);
       user.removeValue();
       return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "PID") int PID, @WebParam(name = "KID") int KID, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "komentar") String komentar) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase comment = ref.child("post"+PID+"/comment/");
        Map<String, Object> commentMap = new HashMap<String, Object>();
        commentMap.put("nama",nama);
        commentMap.put("email",email);
        commentMap.put("tanggal",tanggal);
        commentMap.put("komentar",komentar);
        
        comment.push().setValue(commentMap);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public ArrayList listComment(@WebParam(name = "PID") int PID) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase comment = ref.child("comment");
//        String json = getData(comment.toString()+".json");
        ArrayList<Komentar> listPost = new ArrayList<Komentar>();
        
        return listPost;
     }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchPost")
    public ArrayList searchPost(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isExistUser")
    public Boolean isExistUser(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        return null;
    }
}
