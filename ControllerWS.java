package ConnectFirebase;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONObject;
@WebService(serviceName = "ControllerWS")
public class ControllerWS {
    //parameter
    private final Firebase ref = new Firebase("https://connectfirebase.firebaseio.com/");
    
    // complementer function
    public String readJSON(String urlString) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
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
    
    public List<String> loadPost() {
        List<String> posts = new ArrayList();
        
        // mendapatkan id
        String s = readJSON("https://connectfirebase.firebaseio.com/posts.json");
        JSONObject Obj = new JSONObject(s);
        Iterator<String> id = Obj.keys();
        
        // mendapatkan isi
        while (id.hasNext()) {
            String p = id.next();
            JSONObject Obj2 = Obj.getJSONObject(p);
            String judul = Obj2.getString("judul");
            System.out.println("judul nih  : " + judul + "judul");
            // String blabla
            posts.add(p);
        }
        
        return posts;
    }
    
    
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase postsRef = ref.child("posts");
        
        Map<String,String> post = new HashMap();
        post.put("judul",judul);
        post.put("konten",konten);
        post.put("tanggal",tanggal);
        
        postsRef.push().setValue(post);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
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
        
        postsRef.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "postID") String postID, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String komentar) {
        Firebase postsRef = ref.child("comments");
        
        Map<String,String> comment = new HashMap();
        comment.put("postID",postID);
        comment.put("nama",nama);
        comment.put("email",email);
        comment.put("komentar",komentar);
        
        postsRef.push().setValue(comment);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        Firebase postsRef = ref.child("users");
        
        Map<String,String> user = new HashMap();
        user.put("username",username);
        user.put("password",password);
        user.put("email",email);
        user.put("role",role);
        
        postsRef.push().setValue(user);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        Firebase postsRef = ref.child("users/" + id);
        
        Map<String, Object> user = new HashMap();
        user.put("username", username);
        user.put("password", password);
        user.put("email", email);
        user.put("role", role);
        
        postsRef.updateChildren(user);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String id) {
        Firebase postsRef = ref.child("users/" + id);
        
        postsRef.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadComment")
    public List<JSONObject> loadComment() {
        List<JSONObject> comments = new ArrayList();
        
        // mendapatkan id
        String s = readJSON("https://connectfirebase.firebaseio.com/comments.json");
        JSONObject Obj = new JSONObject(s);
        Iterator<String> id = Obj.keys();
        
        // mendapatkan isi
        while (id.hasNext()) {
            String p = id.next();
            JSONObject Obj2 = Obj.getJSONObject(p);
            comments.add(Obj2);
        }
        return comments;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadUser")
    public List<JSONObject> loadUser() {
        List<JSONObject> users = new ArrayList();
        
        // mendapatkan id
        String s = readJSON("https://connectfirebase.firebaseio.com/users.json");
        JSONObject Obj = new JSONObject(s);
        Iterator<String> id = Obj.keys();
        
        // mendapatkan isi
        while (id.hasNext()) {
            String p = id.next();
            JSONObject Obj2 = Obj.getJSONObject(p);
            users.add(Obj2);
        }
        return users;
    }
}
