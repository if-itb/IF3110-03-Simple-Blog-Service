/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author user
 */
@WebService(serviceName = "Service")
public class Service {
//    public Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
   
    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "addComment")
//    public String addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
//        Firebase komenRef = ref.child("komentar");
//        Map<String, Object> komentar = new HashMap<String, Object>();
////        Komentar komenParam = new Komentar();
////        komenParam.setKomentator("hayyu");
////        komenParam.setKomen(konten);
////        
//        komentar.put("komentator", nama);
//        komentar.put("email", email);
//        komentar.put("komen", konten);
//        
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
    @WebMethod(operationName = "listUser")
    public List<User> listUser() throws MalformedURLException, IOException, JSONException {
        //TODO write your implementation code here:
//        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/user");
        URL linkJson = new URL("https://simpleblogjsf.firebaseio.com/user.json");
        URLConnection con = linkJson.openConnection();
        List<User> list_user = new ArrayList<>();
        JSONTokener tokenListUser = new JSONTokener(con.getInputStream());
        JSONObject list = new JSONObject(tokenListUser);
        Iterator<String> key_user = list.keys();
        while(key_user.hasNext()){
            String ch = key_user.next();
            JSONObject user = list.getJSONObject(ch);
            User usr = new User();
            usr.setUid(ch);
            usr.setEmail(user.getString("email"));
            usr.setFullname(user.getString("fullname"));
            usr.setUsername(user.getString("username"));
            usr.setPassword(user.getString("password"));
            usr.setRole(user.getString("role"));
            list_user.add(usr);
        }
        
        return list_user;
        
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
}
