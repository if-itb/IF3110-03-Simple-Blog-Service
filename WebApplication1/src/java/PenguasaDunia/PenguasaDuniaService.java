/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PenguasaDunia;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import datastructure.Post;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import datastructure.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author wira gotama
 */
@WebService(serviceName = "PenguasaDuniaService")
public class PenguasaDuniaService {
    private final String firebaseURl = "https://luminous-inferno-4376.firebaseio.com/";
    private final Firebase postsRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/posts/"); ;
    private final Firebase usersRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/users/"); ;
    private final Firebase commentsRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/comments/"); ; 
    
    public PenguasaDuniaService() {
    }
    
    @WebMethod(operationName = "addPost")
    public boolean addPost(@WebParam(name="judul") String judul, @WebParam(name="konten") String konten, @WebParam(name="tanggal") String tanggal, @WebParam(name="id_user") String id_user) {
        Map<String, String> post = new HashMap<String, String>();
        post.put("deleted", "false");
        post.put("published", "false");
        post.put("id_user", id_user);
        post.put("judul", judul);
        post.put("konten", konten);
        post.put("tanggal", tanggal);
        postsRef.push().setValue(post);
        return true;
    }
    
    @WebMethod(operationName = "listPost")
    public List<Post> listPost() { //outputnya Vector<Post>
        List<Post> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURl + "/posts.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti elemen
            {
                Map<String,String>post = (Map<String,String>) m.getValue();
                String deleted, published, id_user, judul, konten, tanggal;
                deleted = post.get("deleted");
                published = post.get("published");
                id_user = post.get("id_user");
                judul = post.get("judul");
                konten = post.get("konten");
                tanggal = post.get("tanggal");
                Post temp = new Post(m.getKey(), deleted, published, id_user, judul, konten, tanggal);
                System.out.println(m.getKey()+" "+deleted+" "+published+" "+id_user+" "+judul+" "+konten+" "+tanggal);
                list.add(temp);
            }
        }
        return list;
    }
    
    @WebMethod(operationName = "editPost")
    public boolean editPost(@WebParam(name="id_post") String id_post, @WebParam(name="judul") String judul, @WebParam(name="konten") String konten, @WebParam(name="tanggal") String tanggal) {
        Firebase post = postsRef.child(id_post);
        post.child("judul").setValue(judul);
        post.child("konten").setValue(konten);
        post.child("tanggal").setValue(tanggal);
        return true;
    }
    
    @WebMethod(operationName = "deletePost")
    public boolean deletePost(@WebParam(name="id") String id_post) {
        postsRef.child(id_post).removeValue();
        return true;
    }
    
    @WebMethod(operationName = "publishPost")
    public boolean publishPost(@WebParam(name="id") String id_post) {
        postsRef.child(id_post).child("published").setValue("true");
        return true;
    }
    
    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name="username") String username, @WebParam(name="email") String email, @WebParam(name="role") String role, @WebParam(name="password") String password) {
        Map<String, String> user = new HashMap<String, String>();
        user.put("username", username);
        user.put("email", email);
        user.put("role", role);
        user.put("password", password);
        usersRef.push().setValue(user);
        return true;
    }
    
    @WebMethod(operationName = "listUser")
    public List<User> listUser() { 
        List<User> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURl + "/users.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti elemen
            {
                Map<String,String>user = (Map<String,String>) m.getValue();
                String key, username , email, role , password; 
                username = user.get("username");
                email = user.get("email");
                role = user.get("role");
                password = user.get("password");
                User temp = new User(m.getKey(), username, email, role, password);
                list.add(temp);
            }
        }
        return list;
    }
    
    @WebMethod(operationName = "editUser")
    public boolean editUser(@WebParam(name="id") String id, @WebParam(name="username") String name, @WebParam(name="email") String email, @WebParam(name="role") String role) {
        Firebase user = usersRef.child(id);
        user.child("username").setValue(name);
        user.child("email").setValue(email);
        user.child("role").setValue(role);
        return true;
    }
    
    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name="id") String id) {
        usersRef.child(id).removeValue();
        return true;
    }
    
    @WebMethod(operationName = "addComment")
    public boolean addComment(@WebParam(name="username") String name, @WebParam(name="email") String email, @WebParam(name="komentar") String komentar, @WebParam(name="tanggal") String tanggal, @WebParam(name="id_post") String id_post, @WebParam(name="id_user") String id_user, @WebParam(name="guest") String guest) {
        Map<String, String> comment = new HashMap<String, String>();
        comment.put("username", name);
        comment.put("email", email);
        comment.put("komentar", komentar);
        comment.put("tanggal", tanggal);
        comment.put("id_post", id_post);
        comment.put("id_user", id_user);
        comment.put("guest", guest);
        commentsRef.push().setValue(comment);
        return true;
    }
    
    @WebMethod(operationName = "listComment")
    public List<Comment> listComment() {
        List<Comment> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURl + "/comments.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti id
            {
                Map<String,String>comment = (Map<String,String>) m.getValue();
                String email, guest, id_post, id_user, komentar, tanggal, username;
                email = comment.get("email");
                guest = comment.get("guest");
                id_post = comment.get("id_post");
                id_user = comment.get("id_user");
                komentar = comment.get("komentar");
                tanggal = comment.get("tanggal");
                username = comment.get("username");
                Comment temp = new Comment(m.getKey(), email, guest, id_post, id_user, komentar, tanggal, username);
                list.add(temp);
            }
        }
        return list;
    }
    
    @WebMethod(operationName = "deleteComment")
    public boolean deleteComment(@WebParam(name="id") String id) {
        commentsRef.child(id).removeValue();
        return true;
    }
    
    @WebMethod(operationName = "search")
    public List<Post> search(@WebParam(name="query") final String query) { //result arrayPost
        List<Post> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURl + "/posts.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti elemen
            {
                Map<String,String>post = (Map<String,String>) m.getValue();
                String deleted, published, id_user, judul, konten, tanggal;
                deleted = post.get("deleted");
                published = post.get("published");
                id_user = post.get("id_user");
                judul = post.get("judul");
                konten = post.get("konten");
                tanggal = post.get("tanggal");
                if (judul.toLowerCase().contains(query.toLowerCase()) || konten.toLowerCase().contains(query.toLowerCase()) || judul.equalsIgnoreCase(query) || konten.equalsIgnoreCase(query)) {
                    Post temp = new Post(m.getKey(), deleted, published, id_user, judul, konten, tanggal);
                    System.out.println(m.getKey()+" "+deleted+" "+published+" "+id_user+" "+judul+" "+konten+" "+tanggal);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    
    private JSONObject getJSON(String path)
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String JSON = "";
        String line = "";
        JSONArray array = new JSONArray();
        
        try {
            url = new URL(path);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            while((line = br.readLine()) != null)
            {
                JSON += line;
            }
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(JSON);
            array.add(obj);
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        JSONObject obj = (JSONObject) array.get(0);
        return obj;
    }
}
