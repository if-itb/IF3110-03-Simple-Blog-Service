/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.shaded.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import source.KoneksiDatabase;
import source.dataUser;

/**
 *
 * @author akhfa
 */
@WebService(serviceName = "blogService")
@Stateless()
public class blogService {
    boolean status;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
        URL url = new URL(urlString);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read); 

        return buffer.toString();
    } finally {
        if (reader != null)
            reader.close();
    }
}

    /**
     * Web service operation
     * @param username
     * @param nama
     * @param password
     * @param email
     * @param role
     * @return 
     * @throws java.lang.InterruptedException 
     */
    @WebMethod(operationName = "addUser")
    public boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "nama") String nama, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) throws InterruptedException {
        //TODO write your implementation code here:
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("user");
        Map <String, String> users = new HashMap<>();
        users.put("username", username);
        users.put("password", password);
        users.put("nama", nama);
        users.put("email", email);
        users.put("role",role);
        final CountDownLatch done = new CountDownLatch(1);
        userRef.push().setValue(users,new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    /**
     * Web service operation
     * @return 
     * @throws java.lang.Exception 
     */
    @WebMethod(operationName = "getAllUser")
    public ArrayList <dataUser> getAllUser() throws Exception {
        ArrayList<dataUser> daftarUser = new ArrayList<>();
        
        String stringJson = readUrl("https://if3110-4.firebaseio.com/user.json");

        HashMap<String, Map<String, String>> hasil = new ObjectMapper().readValue(stringJson, HashMap.class);

        for(String key : hasil.keySet())
        {
            dataUser user = new dataUser();
            user.idFirebase = key;
            user.username = (hasil.get(key).get("username"));
            user.nama = (hasil.get(key).get("nama"));
            user.password = (hasil.get(key).get("password"));
            user.email = (hasil.get(key).get("email"));
            user.role = (hasil.get(key).get("role"));
            System.out.println("idFirebase = " + user.idFirebase);
            System.out.println("username = "+user.username);
            System.out.println(user.nama);
            System.out.println(user.password);
            System.out.println(user.email);
            System.out.println(user.role);
            daftarUser.add(user);
        }

        return daftarUser;
    }

    /**
     * Web service operation
     * @param _idFirebase
     * @param _username
     * @param _password
     * @param _nama
     * @param _email
     * @param _role
     * @return 
     * @throws java.lang.InterruptedException
     */
    @WebMethod(operationName = "updateUser")
    public Boolean updateUser(@WebParam(name = "_idFirebase") String _idFirebase, @WebParam(name = "_username") String _username, @WebParam(name = "_password") String _password, @WebParam(name = "_nama") String _nama, @WebParam(name = "_email") String _email, @WebParam(name = "_role") String _role) throws InterruptedException {
        //TODO write your implementation code here:
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("user").child(_idFirebase);
        Map <String, Object> users = new HashMap<>();
        users.put("username", _username);
        users.put("password", _password);
        users.put("nama", _nama);
        users.put("email", _email);
        users.put("role",_role);
        
        final CountDownLatch done = new CountDownLatch(1);
        userRef.updateChildren(users,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    /**
     * Web service operation
     * @param _judulPost
     * @param _tanggalPost
     * @param _kontenPost
     * @return 
     * @throws java.lang.InterruptedException
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "_judulPost") String _judulPost, @WebParam(name = "_tanggalPost") String _tanggalPost, @WebParam(name = "_kontenPost") String _kontenPost) throws InterruptedException {
        //TODO write your implementation code here:
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase postRef = ref.child("post");
        Map <String, String> post = new HashMap<>();
        post.put("judul", _judulPost);
        post.put("konten", _kontenPost);
        post.put("tanggal", _tanggalPost);
        post.put("publishStatus", "0");
        final CountDownLatch done = new CountDownLatch(1);
        postRef.push().setValue(post,new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "_idFirebase") String _idFirebase, @WebParam(name = "_judulPost") String _judulPost, @WebParam(name = "_tanggalPost") String _tanggalPost, @WebParam(name = "_kontenPost") String _kontenPost, @WebParam(name = "_publishStatus") String _publishStatus) throws InterruptedException {
        //TODO write your implementation code here:
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("post").child(_idFirebase);
        Map <String, Object> users = new HashMap<>();
        users.put("judul", _judulPost);
        users.put("tanggal", _tanggalPost);
        users.put("konten", _kontenPost);
        users.put("publishStatus",_publishStatus);
        
        final CountDownLatch done = new CountDownLatch(1);
        userRef.updateChildren(users,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

}
