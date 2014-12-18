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
    public Boolean addPost(@WebParam(name = "post") Post post) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/post/");
        Map<String, Object> _post = new HashMap<String, Object>();
        _post.put("judul",post.getJudul());
        _post.put("tanggal",post.getDate());
        _post.put("author",post.getAuthor());
        _post.put("konten",post.getKonten());
        _post.put("published",false);
        ref.push().setValue(_post);
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
                if (!postJSON.getBoolean("published")) {
                    Post _post;
                    _post = new Post();
                    _post.setPID(postID);
                    _post.setAuthor(postJSON.getString("author"));
                    _post.setDate(postJSON.getString("tanggal"));
                    _post.setJudul(postJSON.getString("judul"));
                    _post.setKonten(postJSON.getString("konten"));
                    _post.setPublished(postJSON.getBoolean("published"));
                    listUnpublishedPost.add(_post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUnpublishedPost;
    }
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getPublishedPost")
    public ArrayList<Post> getPublishedPost() {
        //TODO write your implementation code here:
        ArrayList<Post> listPublishedPost = new ArrayList<Post>();
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
                if (postJSON.getBoolean("published")) {
                    Post _post;
                    _post = new Post();
                    _post.setPID(postID);
                    _post.setAuthor(postJSON.getString("author"));
                    _post.setDate(postJSON.getString("tanggal"));
                    _post.setJudul(postJSON.getString("judul"));
                    _post.setKonten(postJSON.getString("konten"));
                    _post.setPublished(postJSON.getBoolean("published"));
                    listPublishedPost.add(_post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPublishedPost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "post") Post post) {
        // Get a reference to our posts
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase _post = ref.child("post/"+post.getPID());
        Map<String, Object> postMap = new HashMap<String, Object>();
        postMap.put("judul",post.getJudul());
        postMap.put("tanggal",post.getDate());
        postMap.put("author",post.getAuthor());
        postMap.put("konten",post.getKonten());
        _post.updateChildren(postMap);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "PID") String PID) {
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post/"+PID);
        post.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "PID") String PID) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post/"+PID);
        Map<String, Object> postMap = new HashMap<String, Object>();
        postMap.put("published",true);
        post.updateChildren(postMap);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPost")
    public Post getPost(@WebParam(name = "PID") String PID) {
        //TODO write your implementation code here:
        //TODO write your implementation code here:
        ArrayList<Post> thispost = new ArrayList<Post>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("post");
        Post ret = null;
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
                if (postID.equalsIgnoreCase(PID)) {
                    Post _post;
                    _post = new Post();
                    _post.setPID(PID);
                    _post.setAuthor(postJSON.getString("author"));
                    _post.setDate(postJSON.getString("tanggal"));
                    _post.setJudul(postJSON.getString("judul"));
                    _post.setKonten(postJSON.getString("konten"));
                    _post.setPublished(postJSON.getBoolean("published"));
                    thispost.add(_post);
                }
            }
            if (thispost.size()!=0)
                ret = thispost.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "user") UserBean user) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/user/");
        Map<String, Object> users = new HashMap<String, Object>();
        users.put("username",user.getUsername());
        users.put("role",user.getRole());
        users.put("password",user.getPassword());
        users.put("email",user.getEmail());
        ref.push().setValue(users);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public ArrayList<UserBean> listUser(){
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
    public Boolean editUser(@WebParam(name = "user") UserBean _user) {
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
                
                if(userJSON.getString("username").equals(_user.getUsername())) {
                    Firebase user = ref.child("user/"+userID);
                    Map<String, Object> userMap = new HashMap<String, Object>();
                    userMap.put("username",_user.getUsername());
                    userMap.put("role",_user.getRole());
                    userMap.put("password",_user.getPassword());
                    userMap.put("email",_user.getEmail());user.updateChildren(userMap);
                    user.updateChildren(userMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "username") String username) {
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
                
                if(userJSON.getString("username").equals(username)) {
                    Firebase user = ref.child("user/"+userID);
                    user.removeValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public UserBean getUser(@WebParam(name = "username") String username) {
        ArrayList<UserBean> thisuser = new ArrayList<UserBean>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase user = ref.child("user");
        UserBean ret = null;
        try {
            URLConnection conn = (new URL(user.toString() + ".json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject usersJSON = new JSONObject(jsonString);
            JSONArray userIDJSON = usersJSON.names();
            System.out.println(userIDJSON.length());
            for (int it = 0; it < userIDJSON.length(); ++it) {
                String postID = userIDJSON.getString(it);
                JSONObject userJSON = usersJSON.getJSONObject(postID);
                if (userJSON.getString("username").equals(username)) {
                    UserBean _user;
                    _user = new UserBean();
                    _user.setEmail(userJSON.getString("email"));
                    _user.setPassword(userJSON.getString("password"));
                    _user.setRole(userJSON.getInt("role"));
                    _user.setUsername(userJSON.getString("username"));
                    thisuser.add(_user);
                }
            }
            if (thisuser.size()!=0)
                ret = thisuser.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "komentar") Komentar komentar) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase comment = ref.child("/comment/");
        Map<String, Object> commentMap = new HashMap<String, Object>();
        commentMap.put("PID", komentar.getPID());
        commentMap.put("nama",komentar.getNama());
        commentMap.put("email",komentar.getEmail());
        commentMap.put("tanggal",komentar.getTanggal());
        commentMap.put("komentar",komentar.getKomentar());
        comment.push().setValue(commentMap);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public ArrayList<Komentar> listComment(@WebParam(name = "PID") String PID) {
        ArrayList<Komentar> listKomen = new ArrayList<Komentar>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("comment");
        try {
            URLConnection conn = (new URL(post.toString() + ".json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject commentsJSON = new JSONObject(jsonString);
            JSONArray commentIDJSON = commentsJSON.names();
            System.out.println(commentIDJSON.length());
            for (int it = 0; it < commentIDJSON.length(); ++it) {
                String postID = commentIDJSON.getString(it);
                JSONObject commentJSON = commentsJSON.getJSONObject(postID);
                if (commentJSON.getString("PID").equals(PID)) {
                    Komentar _komen;
                    _komen = new Komentar();
                    _komen.setPID(commentJSON.getString("PID"));
                    _komen.setEmail(commentJSON.getString("email"));
                    _komen.setKID(postID);
                    _komen.setKomentar(commentJSON.getString("komentar"));
                    _komen.setNama(commentJSON.getString("nama"));
                    _komen.setTanggal(commentJSON.getString("tanggal"));
                   listKomen.add(_komen);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKomen;
     }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getKomentar")
    public Komentar getKomentar(@WebParam(name = "KID") String KID) {
        ArrayList<Komentar> listKomen = new ArrayList<Komentar>();
        Firebase ref = new Firebase("https://tubes3wbd.firebaseio.com/");
        Firebase post = ref.child("comment");
        Komentar ret = null;
        try {
            URLConnection conn = (new URL(post.toString() + ".json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject commentsJSON = new JSONObject(jsonString);
            JSONArray commentIDJSON = commentsJSON.names();
            System.out.println(commentIDJSON.length());
            for (int it = 0; it < commentIDJSON.length(); ++it) {
                String postID = commentIDJSON.getString(it);
                JSONObject commentJSON = commentsJSON.getJSONObject(postID);
                if (commentJSON.getString("KID").equalsIgnoreCase(KID)) {
                    Komentar _komen;
                    _komen = new Komentar();
                    _komen.setPID(commentJSON.getString("PID"));
                    _komen.setEmail(commentJSON.getString("email"));
                    _komen.setKID(commentJSON.getString("KID"));
                    _komen.setKomentar(commentJSON.getString("komentar"));
                    _komen.setNama(commentJSON.getString("nama"));
                    _komen.setTanggal(commentJSON.getString("tanggal"));
                   listKomen.add(_komen);
                }
            }
            if (listKomen.size()!=0)
                ret = listKomen.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchPost")
    public ArrayList<Post> searchPost(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        ArrayList<Post> listPublishedPost = new ArrayList<Post>();
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
                if (postJSON.getString("judul").matches("(.*)"+query+"(.*)") 
                        || postJSON.getString("konten").matches("(.*)"+query+"(.*)")) {
                    Post _post;
                    _post = new Post();
                    _post.setPID(postID);
                    _post.setAuthor(postJSON.getString("author"));
                    _post.setDate(postJSON.getString("tanggal"));
                    _post.setJudul(postJSON.getString("judul"));
                    _post.setKonten(postJSON.getString("konten"));
                    _post.setPublished(postJSON.getBoolean("published"));
                    listPublishedPost.add(_post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPublishedPost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isExistUser")
    public Boolean isExistUser(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        ArrayList<UserBean> users = listUser();
        boolean exist=false;
        int i = 0;
        while (i<users.size() && !exist) {
            if (users.get(i).getUsername().equals(username)) {
                exist=true;
            }
            i++;
        }
        return exist;
    }
}
