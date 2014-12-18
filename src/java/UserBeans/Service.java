/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@WebService(serviceName = "Service")
public class Service {
//    public Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
   
    /**
     * This is a sample web service operation
     * @param id
     */
//    @WebMethod(operationName = "addComment")
//    public String addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {

//        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
//        
//        Firebase komenRef = ref.child("komentar");
//        Map<String, Object> komentar = new HashMap<String, Object>();
//        komentar.put("konten", konten);
//        komentar.put("nama", nama);
//        komentar.put("email",email);
//        komenRef.push().setValue(komentar);
//        return "success";
//        
//    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public boolean publishPost(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/blogpost/" + id);
        Firebase publishStatus = ref.child("publish");
        publishStatus.setValue("true");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name = "fullname") String fullname, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
        Firebase userRef = ref.child("user");
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("fullname", fullname);
        user.put("username", username);
        user.put("password", password);
        user.put("email", email);
        user.put("role", role);
        userRef.push().setValue(user);
        return true;
    }

    /**
     * Web service operation
     */
//    @WebMethod(operationName = "listUser")
//    public List<User> listUser() throws MalformedURLException, IOException, JSONException {
//        //TODO write your implementation code here:
////        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/user");
//        URL linkJson = new URL("https://simpleblogjsf.firebaseio.com/user.json");
//        URLConnection con = linkJson.openConnection();
//        List<User> list_user = new ArrayList<>();
//        JSONTokener tokenListUser = new JSONTokener(con.getInputStream());
//        JSONObject list = new JSONObject(tokenListUser);
//        Iterator<String> key_user = list.keys();
//        while(key_user.hasNext()){
//            String ch = key_user.next();
//            JSONObject user = list.getJSONObject(ch);
//            User usr = new User();
//            usr.setUid(ch);
//            usr.setEmail(user.getString("email"));
//            usr.setFullname(user.getString("fullname"));
//            usr.setUsername(user.getString("username"));
//            usr.setPassword(user.getString("password"));
//            usr.setRole(user.getString("role"));
//            list_user.add(usr);
//        }
//        
//        return list_user;
//    }
    

    @WebMethod(operationName = "deleteUser")
    public String deleteUser(@WebParam(name = "id")String id){
        Firebase User=new Firebase("https://simpleblogjsf.firebaseio.com/user/");
        Firebase refUser=User.child(id);
        refUser.removeValue();
        return "success";
    }
    
    @WebMethod(operationName = "addComment")
    public String addComment(@WebParam(name = "nama")String nama, @WebParam(name = "email") String email, @WebParam(name = "komen") String komen, @WebParam(name = "id") String id){
        Firebase comment=new Firebase("https://simpleblogjsf.firebaseio.com/blogpost/");
        Firebase refcomment=comment.child(id+"/komentar");
        Map<String, Object> kom=new HashMap <String, Object>();
        kom.put("nama" ,nama);
        kom.put("email" ,email);
        kom.put("komen" ,komen);
        refcomment.push().setValue(kom);
        return "success";
    }

    /**
     *
     * @param id
     * @return
     */
    @WebMethod (operationName="listComment")
    public ArrayList<JSONObject> listCommet(@WebParam(name = "id")String id) throws JSONException{
        String json=readURL("https://simpleblogjsf.firebaseio.com/blogpost/"+id+"/komentar.json");
        JSONObject obj =new JSONObject(json);
        ArrayList<JSONObject> Komentar=new ArrayList<>();
        Iterator<String> ids=obj.keys();
        //String allKomen="";
        while(ids.hasNext()){
            String id_Comment=ids.next();
            JSONObject getcom=obj.getJSONObject(id_Comment);
            Komentar.add(getcom);
            //allKomen+="Nama:    "+getcom.getString("nama")+"\nKomen: "+getcom.getString("komen")+"\nTanggal:    "+getcom.getString("tanggal")+"\n";
        }
        return Komentar;
    }
    
    public ArrayList<JSONObject> search(String query) throws JSONException{
        query=query.toUpperCase();
        String json=readURL("https://simpleblogjsf.firebaseio.com/blogpost.json");
        JSONObject obj =new JSONObject(json);
        ArrayList<JSONObject> Post=new ArrayList<>();
        Iterator<String> ids=obj.keys();
        while(ids.hasNext()){
            String id_Comment=ids.next();
            JSONObject getcom=obj.getJSONObject(id_Comment);
            if(getcom.getString("judul").toUpperCase().contains(query) ||getcom.getString("konten").toUpperCase().contains(query)){
                Post.add(getcom);
            }
        }
        return Post;
    }
    
    public static String readURL(String urlString) {
        BufferedReader reader = null;
        try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder buffer = new StringBuilder();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1) {
                        buffer.append(chars, 0, read); 
                }
                return buffer.toString();
        } catch (IOException ex) {
                Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (reader != null) {
                try {
                        reader.close();
                } catch (IOException ex) {
                        Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "fullname") String fullname, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/user" + id);
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("fullname", fullname);
        user.put("username", username);
        user.put("password", password);
        user.put("email", email);
        user.put("role", role);
        ref.updateChildren(user);
        return true;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "uid") String uid, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
        Firebase postRef = ref.child("blogpost");
        Map<String, Object> post = new HashMap<String, Object>();
        post.put("delete", false);
        post.put("judul", judul);
        post.put("konten", konten);
        post.put("publish", false);
        post.put("tanggal", tanggal);
        post.put("uid", uid);
        postRef.push().setValue(post);
        Firebase lastId = postRef.child("lastId");
        lastId.setValue(1);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public String listPost() {
        try {
            //Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/blogpost");
            String postJson = readURL("https://simpleblogjsf.firebaseio.com/blogpost.json");
            JSONObject obj = new JSONObject(postJson);
            ArrayList<JSONObject> Posts = new ArrayList<>();
            Iterator<String> jsonIterator = obj.keys();
            String retval = "";
            while(jsonIterator.hasNext()){
                String postID = jsonIterator.next();
                JSONObject postAtom = obj.getJSONObject(postID);
                Posts.add(postAtom);
                retval += "Judul : "+postAtom.getString("judul")+"\n";
                retval += "Konten : "+postAtom.getString("konten")+"\n";
                retval += "tanggal :"+postAtom.getString("tanggal")+"\n";
            }
            return retval;
        } catch (JSONException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        try {
            //mengambil data dari json
            String jsonString = readURL("https://simpleblogjsf.firebaseio.com/blogpost/"+id+".json");
            JSONObject postJson = new JSONObject(jsonString);
            Boolean delete = postJson.getBoolean("delete");
            Boolean publish = postJson.getBoolean("publish");
            String uid = postJson.getString("uid");
               
            //menuliskan update ke firebase
            Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/blogpost/"+id);
            Map<String, Object> post = new HashMap<String, Object>();
            post.put("judul", judul);
            post.put("konten", konten);
            post.put("tanggal", tanggal);
            post.put("delete", delete);
            post.put("publish", publish);
            post.put("uid", uid);
            ref.updateChildren(post);
            return true;
        } catch (JSONException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") String id) {
        Firebase post = new Firebase("https://simpleblogjsf.firebaseio.com/blogpost/"+id);
        post.removeValue();
        return true;
    }
}
