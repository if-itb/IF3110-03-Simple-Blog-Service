/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paket;

import com.firebase.client.Firebase;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author TOSHIBA
 */
@WebService(serviceName = "simpleblog")
public class simpleblog {

    private final Firebase fbase;
    String dbname = "https://sizzling-heat-3244.firebaseio.com/";

    public simpleblog() {
        this.fbase = new Firebase(dbname);
    }
        
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listPost")
    public ArrayList<Post> listPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") Integer id) {
        Firebase post = fbase.child("post").child(id.toString());
        post.removeValue();
        return true;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") Integer id) {
        //TODO write your implementation code here:
        return null;
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
    public ArrayList<User> listUser() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @param nama
     * @param role
     * @param email
     * @return 
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id") Integer id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") Integer id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param nama
     * @param email
     * @param konten
     * @return 
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listComment")
    public ArrayList<Comment> listComment() {
        //TODO write your implementation code here:
        return null;
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
     */
    @WebMethod(operationName = "search")
    public ArrayList<Post> search(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
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
}
