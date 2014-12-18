/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataType.Komentar;
import DataType.Post;
import DataType.User;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.firebase.client.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author timothy.pratama
 */
@WebService(serviceName = "DatabaseService")
public class DatabaseService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "author")String author, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String, String> p = new HashMap<>();
        p.put("judul",judul);
        p.put("author",author);
        p.put("konten",konten);
        p.put("tanggal",tanggal);
        p.put("status","unpublished");
        ref.child("post").push().setValue(p);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public List<Post> listPost(@WebParam(name = "post_status")String post_status) {
        //post dengan status post_status yang akan diambil dari firebase.
        List<Post> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURL + "/post.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti post
            {
                Map<String,String>post = (Map<String,String>) m.getValue();
                String author,judul,konten,status,tanggal,id;
                author = post.get("author");
                judul = post.get("judul");
                konten = post.get("konten");
                status = post.get("status");
                tanggal = post.get("tanggal");
                id = m.getKey();
                Post temp = new Post(author, judul, konten, status, tanggal, id);
                if(status.toLowerCase().equals(post_status.toLowerCase()))
                {
                    list.add(temp);
                }
            }
        }
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name="author")String author, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,Object>p = new HashMap<>();
        p.put("judul", judul);
        p.put("author",author);
        p.put("konten", konten);
        p.put("tanggal",tanggal);
        ref.child("post").child(id).updateChildren(p);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,Object>p = new HashMap<>();
        p.put("status","deleted");
        ref.child("post").child(id).updateChildren(p);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,Object>p = new HashMap<>();
        p.put("status","published");
        ref.child("post").child(id).updateChildren(p);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,String> u = new HashMap<>();
        u.put("username", username);
        u.put("password",password);
        u.put("email", email);
        u.put("role", role);
        ref.child("user").push().setValue(u);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public List<User> listUser() 
    {
        List<User> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURL + "/user.json");
        System.out.println("json: " + json);
        Map<String,Object>map = json;
        for(Map.Entry<String,Object>m : map.entrySet())
        {
            Map<String,String>user = (Map<String,String>) m.getValue();
            String username, password, role, email, id;
            username = user.get("username");
            password = user.get("password");
            role = user.get("role");
            email = user.get("email");
            id = m.getKey();
            User temp = new User(username, email, password, role, id);
            list.add(temp);
        }
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id")String id, @WebParam(name = "username") String username, @WebParam(name = "password")String password, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,Object>u = new HashMap<>();
        u.put("username", username);
        u.put("password", password);
        u.put("email", email);
        u.put("role", role);
        ref.child("user").child(id).updateChildren(u);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL + "/user/" + id);
        ref.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "id_post")String id_post, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String komentar) {
        Firebase ref = new Firebase(firebaseURL);
        HashMap<String, String> newComment = new HashMap<>();
        newComment.put("Nama", nama);
        newComment.put("Email", email);
        newComment.put("Komentar", komentar);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal = format.format(date);
        newComment.put("Tanggal", tanggal);
        ref.child("post").child(id_post).push().setValue(newComment);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public List<Komentar> listComment(@WebParam(name = "id_post")String id_post) {
        List<Komentar> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURL + "/post/" + id_post + ".json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti comment
            {
                Map<String,String>comment = (Map<String,String>) m.getValue();
                Komentar temp = new Komentar(comment.get("Email"),comment.get("Komentar") ,comment.get("Nama"), comment.get("Tanggal"));
                list.add(temp);
            }
        }
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public List<Post> search(@WebParam(name = "query") String query) {
        List<Post> list = new ArrayList<>();
        JSONObject json = getJSON(firebaseURL + "/post.json");
        Map<String,Object>map = (Map<String,Object>)json;
        for(Map.Entry<String,Object> m : map.entrySet())
        {
            System.out.println("Key:" + m.getKey());
            if(m.getKey().charAt(0)=='-')//berarti post
            {
                Map<String,String>post = (Map<String,String>) m.getValue();
                String author,judul,konten,status,tanggal,id;
                author = post.get("author");
                judul = post.get("judul");
                konten = post.get("konten");
                status = post.get("status");
                tanggal = post.get("tanggal");
                id = m.getKey();
                Post temp = new Post(author, judul, konten, status, tanggal, id);
                if(judul.toLowerCase().contains(query.toLowerCase()) || konten.toLowerCase().contains(query.toLowerCase()))  
                {
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public DatabaseService() {
        firebaseURL = "https://vivid-torch-7169.firebaseio.com";
        finish = false;
    }
    
    //Methods
    private final String firebaseURL;
    private Boolean finish;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restorePost")
    public Boolean restorePost(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,Object>p = new HashMap<>();
        p.put("status","published");
        ref.child("post").child(id).updateChildren(p);
        return true;
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
            java.util.logging.Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            java.util.logging.Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
            java.util.logging.Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject obj = (JSONObject) array.get(0);
        return obj;
    }
}
