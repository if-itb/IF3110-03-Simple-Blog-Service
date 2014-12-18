/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firebasews;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "FirebaseWS")
@Stateless()
public class FirebaseWS {
    
    private final String fireurl = "https://asd2938ryrhkjfhsikfh.firebaseio.com/";


    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"Post");
        Map<String,String> post = new HashMap<String, String>();
        post.put("author", author);
        post.put("judul", judul);
        post.put("konten", konten);
        post.put("status", "unpublished");
        post.put("tanggal", tanggal);
        conn.push().setValue(post);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public boolean deletePost(@WebParam(name = "id") String id) {
        //TODO write your implementation code here
        Firebase conn = new Firebase(fireurl+"Post/"+id);
        conn.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"Post/"+id);
        conn.child("judul").setValue(judul);
        conn.child("konten").setValue(konten);
        conn.child("tanggal").setValue(tanggal);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public boolean publishPost(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"Post/"+id);
        conn.child("status").setValue("published");
        return true;
    }

    /**
     * Web service operation
     * @throws java.io.IOException
     */
    @WebMethod(operationName = "listPost")
    public ArrayList<Post> listPost() throws IOException {
        //TODO write your implementation code here:
        ArrayList<Post> arrpost = new ArrayList<Post>();
        String json = URLtoJSON(fireurl+"Post/.json");
        Object obj=JSONValue.parse(json);
        JSONObject jsono = (JSONObject) obj;
        for(Object key : jsono.keySet())
        {
            Post po = new Post();
            String k = (String) key;
            String jsons = URLtoJSON(fireurl+"Post/"+k+"/.json");
            Object objs=JSONValue.parse(jsons);
            JSONObject jsonos = (JSONObject) objs;
            po.setId(k);
            po.setJudul((String) jsonos.get("judul"));
            po.setKonten((String) jsonos.get("konten"));
            po.setTanggal((String) jsonos.get("tanggal"));
            po.setAuthor((String) jsonos.get("author"));
            arrpost.add(po);
        }
        return arrpost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "role") String role, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"User");
        Map<String,String> post = new HashMap<String, String>();
        post.put("email", email);
        post.put("name", nama);
        post.put("password", password);
        post.put("role", role);
        post.put("username", username);
        conn.push().setValue(post);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public ArrayList<User> listUser() throws IOException {
        //TODO write your implementation code here:
        ArrayList<User> arruser = new ArrayList<User>();
        String json = URLtoJSON(fireurl+"User/.json");
        Object obj=JSONValue.parse(json);
        JSONObject jsono = (JSONObject) obj;
        for(Object key : jsono.keySet())
        {
            User us = new User();
            String k = (String) key;
            String jsons = URLtoJSON(fireurl+"User/"+k+"/.json");
            Object objs=JSONValue.parse(jsons);
            JSONObject jsonos = (JSONObject) objs;
            us.setId(k);
            us.setName((String) jsonos.get("name"));
            us.setEmail((String) jsonos.get("email"));
            us.setUsername((String) jsonos.get("username"));
            us.setPassword((String) jsonos.get("password"));
            us.setRole((String) jsonos.get("Role"));
            arruser.add(us);
        }
        return arruser;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"User/"+id);
        conn.child("name").setValue(nama);
        conn.child("role").setValue(role);
        conn.child("email").setValue(email);
        conn.child("username").setValue(username);
        conn.child("password").setValue(password);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"/User/"+id);
        conn.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public boolean addComment(@WebParam(name = "post_id") String post_id, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"/Comment/"+post_id);
        Map<String,String> post = new HashMap<String, String>();
        Date d = new Date();
        String year = Integer.toString(d.getYear());
        String month = Integer.toString(d.getMonth());
        String day = Integer.toString(d.getDay());
        post.put("name", nama);
        post.put("email", email);
        post.put("komentar", konten);
        post.put("tanggal", year+"-"+month+"-"+day);
        conn.push().setValue(post);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public ArrayList<Comment> listComment(@WebParam(name = "pid") String pid) throws IOException {
        //TODO write your implementation code here:
        ArrayList<Comment> arrcomm = new ArrayList<Comment>();
        String json = URLtoJSON(fireurl+"User/"+pid+"/.json");
        Object obj=JSONValue.parse(json);
        JSONObject jsono = (JSONObject) obj;
        for(Object key : jsono.keySet())
        {
            Comment co = new Comment();
            String k = (String) key;
            String jsons = URLtoJSON(fireurl+"User/"+pid+"/"+k+"/.json");
            Object objs=JSONValue.parse(jsons);
            JSONObject jsonos = (JSONObject) objs;
            co.setPid(pid);
            co.setId(k);
            co.setName((String) jsonos.get("name"));
            co.setEmail((String) jsonos.get("email"));
            co.setKomentar((String) jsonos.get("komentar"));
            co.setTanggal((String) jsonos.get("tanggal"));
            arrcomm.add(co);
        }
        return arrcomm;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteComment")
    public boolean deleteComment(@WebParam(name = "pid") String pid, @WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Firebase conn = new Firebase(fireurl+"/Comment/"+pid+"/"+id);
        conn.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public ArrayList<Post> search(@WebParam(name = "query") String query) throws IOException {
        //TODO write your implementation code here:
        ArrayList<Post> arrpost = new ArrayList<Post>();
        String[] srcquery = query.split(query);
        String json = URLtoJSON(fireurl+"Post/.json");
        Object obj=JSONValue.parse(json);
        JSONObject jsono = (JSONObject) obj;
        for(Object key : jsono.keySet())
        {
            Post po = new Post();
            String k = (String) key;
            String jsons = URLtoJSON(fireurl+"Post/"+k+"/.json");
            Object objs=JSONValue.parse(jsons);
            JSONObject jsonos = (JSONObject) objs;
            po.setId(k);
            po.setJudul((String) jsonos.get("judul"));
            po.setKonten((String) jsonos.get("konten"));
            po.setTanggal((String) jsonos.get("tanggal"));
            po.setAuthor((String) jsonos.get("author"));
            arrpost.add(po);
        }
        return arrpost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "URLtoJSON")
    public String URLtoJSON(@WebParam(name = "url") String url) throws MalformedURLException, IOException {
        //TODO write your implementation code here:
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        StringBuilder response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()))) {
            response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
        }
        
        return response.toString();
    }

    
    
}
