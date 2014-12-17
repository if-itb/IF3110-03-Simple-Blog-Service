/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import model.Comment;
import model.Post;
import model.User;

/**
 *
 * @author Ahmad Zaky
 */
public class SimpleBlogServiceImplementation implements SimpleBlogService {
    /* Konstanta terkait Firebase */
    private final String FIREBASE_URL = "https://intense-heat-3835.firebaseio.com/";
    private final String FIREBASE_POST = "post";
    private final String FIREBASE_USER = "user";
    private final String FIREBASE_COMMENT = "comment";
    private final Firebase firebaseRoot = new Firebase(FIREBASE_URL);
    private final Firebase firebasePost = firebaseRoot.child(FIREBASE_POST);
    private final Firebase firebaseUser = firebaseRoot.child(FIREBASE_USER);
    private final Firebase firebaseComment = firebaseRoot.child(FIREBASE_COMMENT);
    
    public class TransactionResult implements Firebase.CompletionListener {
        
        private AtomicBoolean _done = new AtomicBoolean(false);
        private boolean _success;
        
        @Override
        public void onComplete(FirebaseError error, Firebase frbs) {
            _done.set(true);
            if (error != null) {
                _success = true;
            }
            else {
                _success = false;
            }
        }
        
        public boolean done() {
            return _done.get();
        }
        
        public boolean success() {
            return _success;
        }
    }
    
    @Override
    public boolean addPost(String judul, String konten, String tanggal) {
        // masukkan konten ke HashMap
        Map<String, String> map = new HashMap<String, String>();
        map.put("judul", judul);
        map.put("konten", konten);
        map.put("tanggal", tanggal);
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.push().setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public List<Post> listPost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listPost(Integer id, String judul, String konten, String tanggal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePost(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean publishPost(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(String nama, String email, String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> listUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editUser(Integer id, String nama, String email, String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addComment(Integer postId, String nama, String email, String konten) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> listComment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteComment(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> search(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
