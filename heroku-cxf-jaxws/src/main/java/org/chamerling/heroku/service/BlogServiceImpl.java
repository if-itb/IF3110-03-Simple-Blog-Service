/**
 * 
 */
package org.chamerling.heroku.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chamerling
 * 
 */
public class BlogServiceImpl implements BlogService {
    boolean status;
    
    /**
     *
     * @param urlString
     * @return
     * @throws Exception
     */
    @Override
    public String readUrl(String urlString) throws Exception {
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

    @Override
    public Boolean addUser(String username, String nama, String password, String email, String role) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("user");
        Map <String, String> users = new HashMap<String, String>();
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

    @Override
    public ArrayList<DataUser> getAllUser() throws Exception {
        ArrayList<DataUser> daftarUser = new ArrayList<DataUser>();
        
        String stringJson = readUrl("https://if3110-4.firebaseio.com/user.json");

        HashMap<String, Map<String, String>> hasil = new ObjectMapper().readValue(stringJson, HashMap.class);

        for(String key : hasil.keySet())
        {
            DataUser user = new DataUser();
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

    @Override
    public Boolean updateUser(String _idFirebase, String _username, String _password, String _nama, String _email, String _role) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("user").child(_idFirebase);
        Map <String, Object> users = new HashMap<String, Object>();
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

    @Override
    public Boolean addPost(String _judulPost, String _tanggalPost, String _kontenPost) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase postRef = ref.child("post");
        Map <String, String> post = new HashMap<String, String>();
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

    @Override
    public Boolean editPost(String _idFirebase, String _judulPost, String _tanggalPost, String _kontenPost, String _publishStatus) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase postRef = ref.child("post").child(_idFirebase);
        Map <String, Object> users = new HashMap<String, Object>();
        users.put("judul", _judulPost);
        users.put("tanggal", _tanggalPost);
        users.put("konten", _kontenPost);
        users.put("publishStatus",_publishStatus);
        
        final CountDownLatch done = new CountDownLatch(1);
        postRef.updateChildren(users,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    @Override
    public Boolean addComment(String _idFirebasePost, String _nama, String _email, String _comment) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebaseForComment(_idFirebasePost);
        
        Firebase postRef = ref.child("komentar");
        Map <String, String> post = new HashMap<String, String>();
        post.put("nama", _nama);
        post.put("email", _email);
        post.put("comment", _comment);
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

    @Override
    public Boolean deleteUser(String _idFirebaseUser) {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("user").child(_idFirebaseUser);
        
        userRef.removeValue();
        
        return true;
    }

    @Override
    public Boolean deletePost(String _idFirebasePost) throws InterruptedException {
        status = false;
        
        Firebase ref = KoneksiDatabase.getFirebase();
        Firebase userRef = ref.child("post").child(_idFirebasePost);
        
        final CountDownLatch done = new CountDownLatch(1);
        userRef.removeValue(new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        
        done.await();
        
        return status;
    }

    @Override
    public ArrayList<Post> getAllPost() {
        ArrayList<Post> daftarPost = new ArrayList<Post>();
        try {
            
            String stringJson = readUrl("https://if3110-4.firebaseio.com/post.json");
            
            HashMap<String, Map<String, String>> hasil = new ObjectMapper().readValue(stringJson, HashMap.class);
            
            for(String key : hasil.keySet())
            {
//            DataUser user = new DataUser();
                Post post = new Post();
                post.idFirebasePost = key;
                post.judulPost = (hasil.get(key).get("judul"));
                post.kontenPost = (hasil.get(key).get("konten"));
                post.tanggalPost = (hasil.get(key).get("tanggal"));
                post.publishStatus = Integer.parseInt(hasil.get(key).get("publishStatus"));
                
                System.out.println("idFirebase = " + post.idFirebasePost);
                System.out.println("judul = "+post.judulPost);
                System.out.println(post.kontenPost);
                System.out.println(post.publishStatus);
                System.out.println(post.tanggalPost);
                
                daftarPost.add(post);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(BlogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarPost;
    }
    
    @Override
    public ArrayList<Komentar> getAllCommentar(String _idFirebasePost)
    {
        ArrayList<Komentar> daftarKomentar = new ArrayList<Komentar>();
        try {
            
            String stringJson = readUrl("https://if3110-4.firebaseio.com/post/" + _idFirebasePost + "/komentar.json");
            
            HashMap<String, Map<String, String>> hasil = new ObjectMapper().readValue(stringJson, HashMap.class);
            
            for(String key : hasil.keySet())
            {
                Komentar komentar = new Komentar();
                komentar.idFirebase = key;
                komentar.nama = (hasil.get(key).get("nama"));
                komentar.email = (hasil.get(key).get("email"));
                komentar.comment = (hasil.get(key).get("comment"));
                
                daftarKomentar.add(komentar);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(BlogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarKomentar;
    }

    @Override
    public void SayHi(String name) {
        System.out.println("Hai " + name);
    }
}
