/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.json.JsonObject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONObject;

/**
 *
 * @author A 46 CB i3
 */
@WebService(serviceName = "ControllerImplement")
public class ControllerImplement {

    private final Firebase ref = new Firebase("https://webservice.firebaseio.com/");
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
        
        Firebase postsRef = ref.child("posts");
        Map<String, String> post = new HashMap();
        
        post.put("judul", judul);
        post.put("konten", konten);
        post.put("tanggal", tanggal);
        post.put("status", "unpublished");
        
        postsRef.push().setValue(post);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
        
        Firebase postsRef = ref.child("posts/" + id);
        Map<String, Object> post = new HashMap();
        
        post.put("judul", judul);
        post.put("konten", konten);
        post.put("tanggal", tanggal);
        
        postsRef.updateChildren(post);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") String id) {
        
        Firebase postsRef = ref.child("posts/" + id);
        Map<String, Object> post = new HashMap();
        
        post.put("status", "deleted");
        
        postsRef.updateChildren(post);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restorePost")
    public Boolean restorePost(@WebParam(name = "id") String id) {
        
        Firebase postsRef = ref.child("posts/" + id);
        Map<String, Object> post = new HashMap();
        
        post.put("status", "unpublished");
        
        postsRef.updateChildren(post);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") String id) {
        
        Firebase postsRef = ref.child("posts/" + id);
        Map<String, Object> post = new HashMap();
        
        post.put("status", "published");
        
        postsRef.updateChildren(post);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "load")
    public String load(@WebParam(name = "urlstring") String urlstring) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlstring);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadUnpublishedPost")
    public List<Post> loadUnpublishedPost() {
        List<Post> post = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/posts.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> key = Obj.keys();

            while (key.hasNext()) {
                String id = key.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                if(Obj2.getString("status").equals("unpublished")) {
                    Post p = new Post();
                    p.setId(id);
                    p.setJudul(Obj2.getString("judul"));
                    p.setTanggal(Obj2.getString("tanggal"));
                    p.setKonten(Obj2.getString("konten"));
                    p.setStatus(Obj2.getString("status"));
                    post.add(p);
                }
            }
            return post;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadPublishedPost")
    public List<Post> loadPublishedPost() {
        List<Post> post = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/posts.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> key = Obj.keys();

            while (key.hasNext()) {
                String id = key.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                if(Obj2.getString("status").equals("published")) {
                    Post p = new Post();
                    p.setId(id);
                    p.setJudul(Obj2.getString("judul"));
                    p.setTanggal(Obj2.getString("tanggal"));
                    p.setKonten(Obj2.getString("konten"));
                    p.setStatus(Obj2.getString("status"));
                    post.add(p);
                }
            }
            return post;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadDeletedPost")
    public List<Post> loadDeletedPost() {
        List<Post> post = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/posts.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> key = Obj.keys();

            while (key.hasNext()) {
                String id = key.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                if(Obj2.getString("status").equals("deleted")) {
                    Post p = new Post();
                    p.setId(id);
                    p.setJudul(Obj2.getString("judul"));
                    p.setTanggal(Obj2.getString("tanggal"));
                    p.setKonten(Obj2.getString("konten"));
                    p.setStatus(Obj2.getString("status"));
                    post.add(p);
                }
            }
            return post;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadPost")
    public Post loadPost(@WebParam(name = "id") String id) {
        try {
            String s = load("https://webservice.firebaseio.com/posts.json");
            JSONObject Obj = new JSONObject(s);
            JSONObject Obj2 = Obj.getJSONObject(id);
            Post p = new Post();
            p.setId(id);
            p.setJudul(Obj2.getString("judul"));
            p.setTanggal(Obj2.getString("tanggal"));
            p.setKonten(Obj2.getString("konten"));
            p.setStatus(Obj2.getString("status"));
            return p;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        
        Firebase usersRef = ref.child("users");
        Map<String, String> user = new HashMap();
        
        user.put("username", username);
        user.put("password", password);
        user.put("email", email);
        user.put("role", role);
        
        usersRef.push().setValue(user);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        
        Firebase usersRef = ref.child("users/" + id);
        Map<String, Object> user = new HashMap();
        
        user.put("username", username);
        user.put("password", password);
        user.put("email", email);
        user.put("role", role);
        
        usersRef.updateChildren(user);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String id) {
        
        Firebase usersRef = ref.child("users/" + id);
        
        usersRef.removeValue();
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadUser")
    public List<User> loadUser() {
        List<User> user = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/users.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> key = Obj.keys();

            while (key.hasNext()) {
                String id = key.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                User u = new User();
                u.setId(id);
                u.setUsername(Obj2.getString("username"));
                u.setPassword(Obj2.getString("password"));
                u.setEmail(Obj2.getString("email"));
                u.setRole(Obj2.getString("role"));
                user.add(u);
            }
            return user;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "postid") String postid, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String komentar) {
        
        Firebase commentsRef = ref.child("comments");
        Map<String, String> comment = new HashMap();
        
        comment.put("postid", postid);
        comment.put("nama", nama);
        comment.put("email", email);
        comment.put("komentar", komentar);
        
        commentsRef.push().setValue(comment);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadComment")
    public List<Comment> loadComment(@WebParam(name = "postid") String postid) {
        List<Comment> comment = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/comments.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> key = Obj.keys();

            while (key.hasNext()) {
                String id = key.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                if(Obj2.getString("postid").equals(postid)) {
                    Comment c = new Comment();
                    c.setId(id);
                    c.setPostid(Obj2.getString("postid"));
                    c.setNama(Obj2.getString("nama"));
                    c.setEmail(Obj2.getString("email"));
                    c.setKomentar(Obj2.getString("komentar"));
                    comment.add(c);
                }
            }
            return comment;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchPost")
    public List<Post> searchPost(@WebParam(name = "key") String key) {
        List<Post> post = new ArrayList();
        try {
            String s = load("https://webservice.firebaseio.com/posts.json");
            JSONObject Obj = new JSONObject(s);
            Iterator<String> k = Obj.keys();

            while (k.hasNext()) {
                String id = k.next();
                JSONObject Obj2 = Obj.getJSONObject(id);
                String test = Obj2.getString("judul") + Obj2.getString("konten");
                if(test.toLowerCase().contains(key)) {
                    Post p = new Post();
                    p.setId(id);
                    p.setJudul(Obj2.getString("judul"));
                    p.setTanggal(Obj2.getString("tanggal"));
                    p.setKonten(Obj2.getString("konten"));
                    p.setStatus(Obj2.getString("status"));
                    post.add(p);
                }
            }
            return post;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
