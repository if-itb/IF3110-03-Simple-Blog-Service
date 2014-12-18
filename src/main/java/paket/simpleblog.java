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
import java.util.ArrayList;
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
     * @return 
     */
    
    @WebMethod(operationName = "listPost")
    public List<Post> listPost(@WebParam(name = "mode")String mode) throws IOException, ParseException, JSONException {
        //TODO write your implementation code here:
        List<Post> list = new ArrayList<Post>();
         
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
//    @WebMethod(operationName = "listUser")
//    public ArrayList<User> listUser() {
//        //TODO write your implementation code here:
//        return null;
//    }

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
//    @WebMethod(operationName = "listComment")
//    public ArrayList<Comment> listComment() {
//        //TODO write your implementation code here:
//        return null;
//    }

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
//    @WebMethod(operationName = "search")
//    public ArrayList<Post> search(@WebParam(name = "query") String query) {
//        //TODO write your implementation code here:
//        return null;
//    }

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
    
//    private JSONObject getJSONObject(String url) throws IOException, ParseException {
//        JSONArray array = new JSONArray();
//        try {
//            InputStream is = new URL(url).openStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String line = "";
//            String JSONString = "";
//            while((line = br.readLine()) != null)
//            {
//            JSONString += line;
//            }
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(JSONString);
//            array.add(obj);
//        } catch (MalformedURLException ex) {
//        System.out.println(ex.toString());
//        } catch (IOException ex) {
//        System.out.println(ex.toString());
//        }
//        JSONObject object = (JSONObject) array.get(0);
//        return object;
//     }
}
