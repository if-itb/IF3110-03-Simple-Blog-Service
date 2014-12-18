/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paket;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.apache.cxf.helpers.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;


/**
 *
 * @author TOSHIBA
 */
@WebService(serviceName = "simpleblog")
public class simpleblog {

    private final Firebase fbase;
    String dbname = "https://boiling-torch-615.firebaseio.com/";

    public simpleblog() {
        this.fbase = new Firebase(dbname);
    }
        
    /**
     * Web service operation
     * @param mode
     * @return 
     * @throws java.io.IOException 
     * @throws java.text.ParseException 
     * @throws org.codehaus.jettison.json.JSONException 
     */
    
    @WebMethod(operationName = "listPost")
    public List<Post> listPost() throws IOException, ParseException, JSONException {
        //TODO write your implementation code here:
        List<Post> list = new ArrayList<>();
         
        try{ 
            URL url = new URL(fbase + "post.json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
            JSONObject jsonPost = json.getJSONObject(keys.next());
            Post post = new Post();
            post.setId(jsonPost.getString("id"));
            post.setJudul(jsonPost.getString("judul"));
            post.setKonten(jsonPost.getString("konten"));
            post.setTanggal(jsonPost.getString("tanggal"));
            post.setIspublished(jsonPost.getBoolean("published"));
            list.add(post);
            }
        }catch ( JSONException | IOException ex){
             Logger.getLogger(simpleblog.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return list;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        fbase.child("post").child(key).child("published").setValue(-1, true);
        return true;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        fbase.child("post").child(key).child("published").setValue(1, true);
        
        return true;
    }

    /**
     * Web service operation
     * @param nama
     * @param email
     * @param role
     * @param password
     * @return 
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "role") String role, @WebParam(name = "password") String password) {
        Firebase users = fbase.child("user");
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put("nama", nama);
        newUser.put("email", email);
        newUser.put("role", role);
        newUser.put("password", password);
        users.push().setValue(newUser);
        
        return true;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listUser")
    public List<User> listUser() {
        List<User> list = new ArrayList<>();
        try {
            URL url = new URL(fbase + "user" + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                JSONObject jsonUser = json.getJSONObject(keys.next());
                User user = new User();
                user.setId(jsonUser.getInt("id"));
                user.setNama(jsonUser.getString("username"));
                user.setPass(jsonUser.getString("password"));
                user.setEmail(jsonUser.getString("email"));
                user.setRole(jsonUser.getString("role"));
                list.add(user);
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Web service operation
     * @param id
     * @param nama
     * @param role
     * @param email
     * @param password
     * @return 
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id") Integer id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        String key = getUserKey(id);
        if (key == null) return false;
        
        // masukkan konten ke HashMap
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", nama);
        map.put("password", password);
        map.put("email", email);
        map.put("role", role);
        
        // push ke firebase
        fbase.child("user").push().setValue(map, true);
        
        return true;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") Integer id) {
        String key = getUserKey(id);
        if (key == null) return false;
        
        // push ke firebase
        fbase.child("user").child(key).removeValue();
        
        return true;
    }

    /**
     * Web service operation
     * @param postId
     * @param nama
     * @param email
     * @param konten
     * @return 
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "postId") String postId, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", getNewCommentId());
        map.put("postId", postId);
        map.put("name", nama);
        map.put("email", email);
        map.put("content", konten);
        map.put("time", (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(Calendar.getInstance().getTime()) + " UTC");
        
        // push ke firebase
        fbase.child("comment").push().setValue(map, true);
        
        return true;
    }

    /**
     * Web service operation
     * @param postId
     * @return 
     */
    @WebMethod(operationName = "listComment")
    public List<Comment> listComment(Integer postId) {
         List<Comment> list = new ArrayList<>();
        try {
            URL url = new URL(fbase + "comment" + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                JSONObject jsonComment = json.getJSONObject(keys.next());
                Comment comment = new Comment();
                comment.setId(jsonComment.getInt("id"));
                comment.setPost_id(jsonComment.getInt("postId"));
                comment.setNama(jsonComment.getString("name"));
                comment.setEmail(jsonComment.getString("email"));
                comment.setKonten(jsonComment.getString("content"));
                comment.setTanggal(jsonComment.getString("time"));
                
                if (comment.getPost_id() == postId) {
                    list.add(comment);
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deleteComment")
    public Boolean deleteComment(@WebParam(name = "id") Integer id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param query
     * @return 
     * @throws java.io.IOException 
     * @throws java.text.ParseException 
     * @throws org.codehaus.jettison.json.JSONException 
     */
    @WebMethod(operationName = "search")
    public List<Post> search(@WebParam(name = "query") String query) throws IOException, ParseException, JSONException {
        List<Post> allPost = listPost();
        List<Post> list = new ArrayList<>();
        
        String[] token = query.toLowerCase().split(" \t\n\r");
        for (Post post : allPost) {
            String text = post.getJudul().toLowerCase() + " " + post.getKonten().toLowerCase();
            boolean match = true;
            for (String word : token) {
                if (!text.contains(word)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(post);
            }
        }
        return list;
    }

    /**
     * Web service operation
     * @param judul
     * @param konten
     * @param tanggal
     * @return 
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase posts = fbase.child("post");
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("judul", judul);
        newPost.put("konten", konten);
        newPost.put("tanggal", tanggal);
        newPost.put("published", false);
        newPost.put("deleted", false);
        posts.push().setValue(newPost);
        return true;
    }

    /**
     * Web service operation
     * @param id
     * @param judul
     * @param konten
     * @param tanggal
     * @return 
     */
    @WebMethod(operationName = "editPost")
    @RequestWrapper(className = "paket.editPost")
    @ResponseWrapper(className = "paket.editPostResponse")
    public Boolean editPost(@WebParam(name = "id") Integer id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase post = fbase.child("post").child(id.toString());
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("judul", judul);
        newPost.put("konten", konten);
        newPost.put("tanggal", tanggal);
        post.updateChildren(newPost);
        return true;
    }
    
    /* Mengembalikan key dari post dengan id tertentu */
    private String getPostKey(Integer id) {
        String key = null;
        try {
            URL url = new URL(fbase + "post" + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String currentKey = keys.next();
                if (json.getJSONObject(currentKey).getInt("id") == id) {
                    key = currentKey;
                    break;
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(simpleblog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(simpleblog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    
    /* Mengembalikan key dari post dengan id tertentu */
    private String getUserKey(Integer id) {
        String key = null;
        try {
            URL url = new URL(fbase + "post" + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String currentKey = keys.next();
                if (json.getJSONObject(currentKey).getInt("id") == id) {
                    key = currentKey;
                    break;
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    
    /* Mengembalikan post id baru */
    private Integer getNewPostId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(fbase + "post_id_counter" + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            fbase.child("post_id_counter").setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }
    
    /* Mengembalikan user id baru */
    private Integer getNewUserId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(fbase + "user_id_counter" + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            fbase.child("user_id_counter").setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }
    
    /* Mengembalikan user id baru */
    private Integer getNewCommentId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(fbase + "comment_id_counter" + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            fbase.child("comment_id_counter").setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }
}
