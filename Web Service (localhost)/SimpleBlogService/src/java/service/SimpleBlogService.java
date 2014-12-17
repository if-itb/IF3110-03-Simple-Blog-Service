/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.firebase.client.Firebase;
import entities.Komentar;
import entities.Post;
import entities.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author A46CB
 */
@WebService(serviceName = "SimpleBlogService")
public class SimpleBlogService {
    
    private static final String Firebase_URL = "https://brilliant-torch-1213.firebaseio.com";
    private Firebase myFirebase;

    public SimpleBlogService() {
            myFirebase = new Firebase(Firebase_URL);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
        Post newPost = new Post();
        newPost.setJudul(judul);
        newPost.setTanggal(tanggal);
        newPost.setKonten(konten);
        newPost.setIsDeleted("no");
        newPost.setStatus("unpublished");
        myFirebase.child("post").push().setValue(newPost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public List<Post> listPost(@WebParam(name = "mode")String mode) {
        List<Post> listPost = new ArrayList<>();
        JSONObject json = getJSONObject(Firebase_URL + "/post.json");
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject postObject = (JSONObject) json.get(key);
                String judul = postObject.get("judul").toString();
                String tanggal = postObject.get("tanggal").toString();
                String konten = postObject.get("konten").toString();
                String status = postObject.get("status").toString();
                String isDeleted = postObject.get("isDeleted").toString();
            switch (mode) {
                case "published":
                    if ((status.equals("published")) && (isDeleted.equals("no"))) {
                        Post post = new Post(key,judul,tanggal,konten,status,isDeleted);
                        listPost.add(post);
                    }
                    break;
                case "unpublished":
                    if (status.equals("unpublished")) {
                        Post post = new Post(key,judul,tanggal,konten,status,isDeleted);
                        listPost.add(post);
                    }
                    break;
                case "deleted":
                    if (isDeleted.equals("yes")) {
                        Post post = new Post(key,judul,tanggal,konten,status,isDeleted);
                        listPost.add(post);
                    }
                    break;
            }
        }
        return listPost;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
        Map<String,Object>editedpost = new HashMap<>();
        editedpost.put("judul", judul);
        editedpost.put("tanggal",tanggal);
        editedpost.put("konten", konten);
        myFirebase.child("post").child(id).updateChildren(editedpost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") String id) {
        Map<String,Object>deletedpost = new HashMap<>();
        deletedpost.put("isDeleted","yes");
        myFirebase.child("post").child(id).updateChildren(deletedpost);
        return true;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPost")
    public Post getPost(@WebParam(name = "id") String id) {
        JSONObject postObject = getJSONObject(Firebase_URL + "/post/" + id + ".json");
        String judul = postObject.get("judul").toString();
        String tanggal = postObject.get("tanggal").toString();
        String konten = postObject.get("konten").toString();
        String status = postObject.get("status").toString();
        String isDeleted = postObject.get("isDeleted").toString();
        Post post = new Post(id,judul,tanggal,konten,status,isDeleted);
        return post;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") String id) {
        Map<String,Object>deletedpost = new HashMap<>();
        deletedpost.put("status","published");
        myFirebase.child("post").child(id).updateChildren(deletedpost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restorePost")
    public Boolean restorePost(@WebParam(name = "id") String id) {
        Map<String,Object>restoredpost = new HashMap<>();
        restoredpost.put("isDeleted","no");
        myFirebase.child("post").child(id).updateChildren(restoredpost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "role") String role) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setName(name);
        newUser.setRole(role);
        myFirebase.child("user").push().setValue(newUser);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public List<User> listUser() 
    {   
        List<User> listUser = new ArrayList<>();
        JSONObject json = getJSONObject(Firebase_URL + "/user.json");
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject userObject = (JSONObject) json.get(key);
                String email = userObject.get("email").toString();
                String password = userObject.get("password").toString();
                String name = userObject.get("name").toString();
                String role = userObject.get("role").toString();
                User user = new User(key,email,password,name,role);
                listUser.add(user);
        }
        return listUser;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id")String id, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "role") String role) {
        Map<String,Object>editeduser = new HashMap<>();
        editeduser.put("email", email);
        editeduser.put("password",password);
        editeduser.put("name", name);
        editeduser.put("role", role);
        myFirebase.child("user").child(id).updateChildren(editeduser);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String id) {
        myFirebase.child("user").child(id).removeValue();
        return true;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "id") String id) {
        JSONObject userObject = getJSONObject(Firebase_URL + "/user/" + id + ".json");
        String email = userObject.get("email").toString();
        String password = userObject.get("password").toString();
        String name = userObject.get("name").toString();
        String role = userObject.get("role").toString();
        User user = new User(id,email,password,name,role);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String komentar, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "id_post")String id_post) {
        Komentar newKomentar = new Komentar();
        newKomentar.setNama(nama);
        newKomentar.setEmail(email);
        newKomentar.setKomentar(komentar);
        newKomentar.setIdPost(id_post);
        
        newKomentar.setTanggal(tanggal);
        myFirebase.child("komentar").push().setValue(newKomentar);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public List<Komentar> listComment(@WebParam(name = "id_post")String id_post) {
        List<Komentar> listKomentar = new ArrayList<>();
        JSONObject json = getJSONObject(Firebase_URL + "/komentar.json");
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject komentarObject = (JSONObject) json.get(key);
                String nama = komentarObject.get("nama").toString();
                String email = komentarObject.get("email").toString();
                String tanggal = komentarObject.get("tanggal").toString();
                String komentar = komentarObject.get("komentar").toString();
                String idPost = komentarObject.get("idPost").toString();
                if (idPost.equals(id_post)) {
                    Komentar tmpkomentar = new Komentar(nama,email,tanggal,komentar);
                    listKomentar.add(tmpkomentar);
                }
        }
        return listKomentar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public List<Post> search(@WebParam(name = "keyword") String keyword) {
        List<Post> listPost = new ArrayList<>();
        JSONObject json = getJSONObject(Firebase_URL + "/post.json");
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject postObject = (JSONObject) json.get(key);
                String judul = postObject.get("judul").toString();
                String tanggal = postObject.get("tanggal").toString();
                String konten = postObject.get("konten").toString();
                String status = postObject.get("status").toString();
                String isDeleted = postObject.get("isDeleted").toString();
                if (judul.contains(keyword) || konten.contains(keyword)) {
                    Post post = new Post(key,judul,tanggal,konten,status,isDeleted);
                    listPost.add(post);
                }
        }
        return listPost;
    }
    
    private JSONObject getJSONObject(String url) {
        JSONArray array = new JSONArray();       
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            String JSONString = "";
            while((line = br.readLine()) != null)
            {
                JSONString += line;
            }
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(JSONString);
            array.add(obj);
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
            java.util.logging.Logger.getLogger(SimpleBlogService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.toString());
            java.util.logging.Logger.getLogger(SimpleBlogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject object = (JSONObject) array.get(0);
        return object;
    }
}

