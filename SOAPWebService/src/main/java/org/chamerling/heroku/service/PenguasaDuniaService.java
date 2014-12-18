package org.chamerling.heroku.service;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author wira gotama
 */
@WebService(serviceName = "PenguasaDuniaService")
public class PenguasaDuniaService {
    private Firebase postsRef;
    private Firebase usersRef;
    private Firebase commentsRef;
    
    /**
     * This is a sample web service operation
     */
    
    public PenguasaDuniaService() {

    	postsRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/posts/"); 
        usersRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/users/"); 
        commentsRef = new Firebase("https://luminous-inferno-4376.firebaseio.com/comments/"); 
    }
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
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
    public Vector<String> listPost() { //outputnya arrayPost
    	
        return null;
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
    public Vector<String> listUser() { //output adalah listUserResponse2
        return null;
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
    public Vector<String> listComment() { //output listCommentResponse2
        return null;
    }
    
    @WebMethod(operationName = "deleteComment")
    public boolean deleteComment(@WebParam(name="id") String id) {
        commentsRef.child(id).removeValue();
        return true;
    }
    
    @WebMethod(operationName = "search")
    public boolean search(@WebParam(name="query") String query) {
        return true;
    }
}