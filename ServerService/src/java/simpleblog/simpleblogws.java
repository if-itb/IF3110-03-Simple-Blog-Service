/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simpleblog;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 *
 * @author Andre
 */
@WebService(serviceName = "simpleblogws")
public class simpleblogws {
    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") Date tanggal) {
        //TODO write your implementation code here:
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/");
        
        final boolean[] res = new boolean[1];
        
        res[0] = false;
        
        
        Posting post = new Posting();
        post.id = "";
        post.judul = judul;
        post.konten = konten;
        post.tanggal = tanggal;
        post.published = 0;
        
        
        
        ref.push().setValue(post, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public List<Posting> listPost() {
        //TODO write your implementation code here:
        final List<Posting> asem = new LinkedList<>();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/");
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot dc : ds.getChildren()){
                    Posting tmp = new Posting();
                    tmp.id = dc.getKey();
                    tmp.judul = (String)dc.child("judul").getValue();
                    tmp.konten = (String)dc.child("konten").getValue();
                    tmp.tanggal = new Date((Long)dc.child("tanggal").getValue());
                    tmp.published = Integer.parseInt(dc.child("published").getValue().toString());
                    asem.add(tmp);

                }
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return asem;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") Date tanggal, @WebParam(name = "published") int published) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/" + id);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        Posting post = new Posting();
        post.id = "";
        post.judul = judul;
        post.konten = konten;
        post.published = published;
        post.tanggal = tanggal;
        
        
        
        ref.setValue(post, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/" + id);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        
        ref.removeValue(new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") String id, @WebParam(name = "published") int published) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/" + id);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        
        ref.child("published").setValue(published, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "role") int role) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/" + nama);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        Akun akun = new Akun();
        akun.username = nama;
        akun.email = email;
        akun.password = password;
        akun.role = role;
        
        
        
        ref.setValue(akun, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public List<Akun> listUser() {
        //TODO write your implementation code here:
        final List<Akun> asem = new LinkedList<>();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/");
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot dc : ds.getChildren()){
                    Akun tmp = new Akun();
                    
                    tmp.username = dc.getKey();
                    tmp.email = (String)dc.child("email").getValue();
                    tmp.password = (String)dc.child("password").getValue();
                    tmp.role = Integer.parseInt(dc.child("role").getValue().toString());
                    
                    asem.add(tmp);

                }
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return asem;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "id") int id, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "role") int role) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/" + nama);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        Akun akun = new Akun();
        akun.username = nama;
        akun.email = email;
        akun.password = password;
        akun.role = role;
        
        
        
        ref.setValue(akun, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String nama) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/" + nama);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        
        ref.removeValue(new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "id_post") String id_post, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
        //TODO write your implementation code here:
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/comment/" + id_post + "/");
        
        final boolean[] res = new boolean[1];
        
        res[0] = false;
        
        
        Komentar komen = new Komentar();
        komen.id = "";
        komen.nama = nama;
        komen.email = email;
        komen.komen = konten;
        komen.time = new Date();
        
        
        
        ref.push().setValue(komen, new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public List<Komentar> listComment(@WebParam(name = "id_post") String id_post) {
        //TODO write your implementation code here:
        final List<Komentar> asem = new LinkedList<>();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/comment/" + id_post + "/");
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot dc : ds.getChildren()){
                    Komentar tmp = new Komentar();
                    
                    tmp.id = dc.getKey();
                    tmp.email = (String)dc.child("email").getValue();
                    tmp.komen = (String)dc.child("komen").getValue();
                    tmp.nama = (String)dc.child("nama").getValue();
                    tmp.time = new Date((Long)dc.child("time").getValue());
                    
                    asem.add(tmp);

                }
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return asem;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteComment")
    public Boolean deleteComment(@WebParam(name = "id_komen") String id_komen, @WebParam(name = "id_post") String id_post) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/comment/" + id_post + "/" + id_komen);
        
        final boolean[] res = new boolean[1];
        
        res[0] = true;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (!ds.exists())
                    res[0] = false;
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        if (res[0]){
            res[0] = false;
            
        }else{
            return false;
        }
        
        
        ref.removeValue(new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                //if (fe.getCode() == 0)
                if (fe == null)
                    res[0] =  true;
                done2.countDown();
                
            }
        });
        
        try {
            done2.await();
        } catch (InterruptedException ex) {
            
        }
        return res[0];
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public List<Posting> search(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        final String keyword = query.toLowerCase();
        final List<Posting> asem = new LinkedList<>();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/");
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot dc : ds.getChildren()){
                    Posting tmp = new Posting();
                    tmp.id = dc.getKey();
                    tmp.judul = (String)dc.child("judul").getValue();
                    tmp.konten = (String)dc.child("konten").getValue();
                    tmp.tanggal = new Date((Long)dc.child("tanggal").getValue());
                    tmp.published = Integer.parseInt(dc.child("published").getValue().toString());
                    
                    if (tmp.judul.toLowerCase().contains(keyword) || tmp.konten.toLowerCase().contains(keyword))
                        asem.add(tmp);

                }
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return asem;
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPost")
    public Posting getPost( @WebParam(name = "post_id") String id_post) {
         //TODO write your implementation code here:
        final Posting tmp = new Posting();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/post/" + id_post);
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                
                System.out.println("https://blistering-fire-8149.firebaseio.com/post/" + ds.getKey() + "    " + ds.getChildrenCount());
                
                if (ds.getChildrenCount() > 1) {
                
                    tmp.id = ds.getKey();
                    tmp.judul = (String)ds.child("judul").getValue();
                    tmp.konten = (String)ds.child("konten").getValue();
                    tmp.tanggal = new Date((Long)ds.child("tanggal").getValue());
                    tmp.published = Integer.parseInt(ds.child("published").getValue().toString());
                
                }
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return tmp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public int login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        final CountDownLatch done = new CountDownLatch(1);
        final CountDownLatch done2 = new CountDownLatch(1);
        final String fPass = password;
        
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/" + user);
        
        final int[] res = new int[1];
        
        res[0] = 0;
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                if (ds.exists()){
                    if (fPass.equals(ds.child("password").getValue()))
                        res[0] = Integer.parseInt(ds.child("role").getValue().toString());
                    else
                        res[0] = 0;
                    done.countDown();
                }else{
                    res[0] = 0;
                    done.countDown();
                }
                //done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return res[0];
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public Akun getUser(@WebParam(name = "username") String username) {
         //TODO write your implementation code here:
        final Akun tmp = new Akun();
        final CountDownLatch done = new CountDownLatch(1);
        Firebase ref = new Firebase("https://blistering-fire-8149.firebaseio.com/user/" + username);
        
        ref.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot ds) {
                
                
                if (ds.getChildrenCount() > 1) {
                
                    tmp.username = ds.getKey();
                    tmp.email = (String)ds.child("email").getValue();
                    tmp.password = (String)ds.child("password").getValue();
                    tmp.role = Integer.parseInt(ds.child("role").getValue().toString());
                
                }
                
                done.countDown();
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                done.countDown();
            }
        
        });
        
        try {
            done.await();
        } catch (InterruptedException ex) {
            
        }
        
        return tmp;
    }


   
}
