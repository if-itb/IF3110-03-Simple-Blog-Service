package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.Post;
import model.User;
import org.apache.cxf.helpers.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
    private final String FIREBASE_POST_ID_COUNTER = "post_id_counter";
    private final String FIREBASE_USER_ID_COUNTER = "user_id_counter";
    private final String FIREBASE_COMMENT_ID_COUNTER = "comment_id_counter";
    private final Firebase firebaseRoot = new Firebase(FIREBASE_URL);
    private final Firebase firebasePost = firebaseRoot.child(FIREBASE_POST);
    private final Firebase firebaseUser = firebaseRoot.child(FIREBASE_USER);
    private final Firebase firebaseComment = firebaseRoot.child(FIREBASE_COMMENT);

    /* Kelas yang menangani hasil transaksi dengan Firebase */
    public class TransactionResult implements Firebase.CompletionListener {
        
        private AtomicBoolean _done = new AtomicBoolean(false);
        private boolean _success = true;
        
        @Override
        public void onComplete(FirebaseError error, Firebase frbs) {
            _done.set(true);
            if (error != null) {
                _success = false;
            }
            else {
                _success = true;
            }
        }
        
        public boolean done() {
            return _done.get();
        }
        
        public boolean success() {
            return _success;
        }
    }
    
    /* Mengembalikan post id baru */
    private Integer getNewPostId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(FIREBASE_URL + FIREBASE_POST_ID_COUNTER + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            firebaseRoot.child(FIREBASE_POST_ID_COUNTER).setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }
    
    /* Mengembalikan user id baru */
    private Integer getNewUserId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(FIREBASE_URL + FIREBASE_USER_ID_COUNTER + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            firebaseRoot.child(FIREBASE_USER_ID_COUNTER).setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }
    
    /* Mengembalikan user id baru */
    private Integer getNewCommentId() {
        Integer id = 0;
        try {
            // retrieve value from firebase
            URL url = new URL(FIREBASE_URL + FIREBASE_COMMENT_ID_COUNTER + ".json");
            URLConnection connection = url.openConnection();
            id = Integer.parseInt(IOUtils.toString(connection.getInputStream()));
            
            // update id and update the value in firebase
            id++;
            firebaseRoot.child(FIREBASE_COMMENT_ID_COUNTER).setValue(id);
        }
        catch (IOException e) {
            // do nothing
            e.printStackTrace();
        }
        return id;
    }

    /* Mengembalikan key dari post dengan id tertentu */
    private String getPostKey(Integer id) {
        String key = null;
        try {
            URL url = new URL(FIREBASE_URL + FIREBASE_POST + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String currentKey = keys.next();
                if (json.getJSONObject(currentKey).getInt("id") == id) {
                    key = currentKey;
                    break;
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    
    /* Mengembalikan key dari post dengan id tertentu */
    private String getUserKey(Integer id) {
        String key = null;
        try {
            URL url = new URL(FIREBASE_URL + FIREBASE_USER + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String currentKey = keys.next();
                if (json.getJSONObject(currentKey).getInt("id") == id) {
                    key = currentKey;
                    break;
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    @Override
    public boolean addPost(String judul, String konten, String tanggal, Integer status) {
        // masukkan konten ke HashMap
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", getNewPostId().toString());
        map.put("title", judul);
        map.put("content", konten);
        map.put("date", tanggal);
        map.put("published", status.toString());
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.push().setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public Post getPostById(Integer id) {
        List<Post> list = listPost();
        for (Post post : list) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> listPost() {
        List<Post> list = new ArrayList<Post>();
        try {
            URL url = new URL(FIREBASE_URL + FIREBASE_POST + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                JSONObject jsonPost = json.getJSONObject(keys.next());
                Post post = new Post();
                post.setId(jsonPost.getInt("id"));
                post.setTitle(jsonPost.getString("title"));
                post.setContent(jsonPost.getString("content"));
                post.setDate(jsonPost.getString("date"));
                post.setPublished(jsonPost.getInt("published"));
                list.add(post);
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean updatePost(Integer id, String judul, String tanggal, String konten, Integer status) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("title", judul);
        map.put("content", konten);
        map.put("date", tanggal);
        map.put("published", status);
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean deletePost(Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).child("published").setValue(-1, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean restorePost(Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).child("published").setValue(0, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean permanentDeletePost(Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).removeValue(result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean publishPost(Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).child("published").setValue(1, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean unpublishPost(Integer id) {
        String key = getPostKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebasePost.child(key).child("published").setValue(0, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean addUser(String username, String password, String email, String role) {
        // masukkan konten ke HashMap
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", getNewUserId());
        map.put("username", username);
        map.put("password", password);
        map.put("email", email);
        map.put("role", role);
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebaseUser.push().setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public List<User> listUser() {
        List<User> list = new ArrayList<User>();
        try {
            URL url = new URL(FIREBASE_URL + FIREBASE_USER + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                JSONObject jsonUser = json.getJSONObject(keys.next());
                User user = new User();
                user.setId(jsonUser.getInt("id"));
                user.setUsername(jsonUser.getString("username"));
                user.setPassword(jsonUser.getString("password"));
                user.setEmail(jsonUser.getString("email"));
                user.setRole(jsonUser.getString("role"));
                list.add(user);
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User getUserById(Integer id) {
        List<User> list = listUser();
        for (User user : list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> list = listUser();
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean modifyUser(Integer id, String username, String password, String email, String role) {
        String key = getUserKey(id);
        if (key == null) return false;
        
        // masukkan konten ke HashMap
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("username", username);
        map.put("password", password);
        map.put("email", email);
        map.put("role", role);
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebaseUser.push().setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean removeUser(Integer id) {
        String key = getUserKey(id);
        if (key == null) return false;
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebaseUser.child(key).removeValue(result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public boolean addComment(Integer postId, String nama, String email, String konten) {
        // masukkan konten ke HashMap
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", getNewCommentId());
        map.put("postId", postId);
        map.put("name", nama);
        map.put("email", email);
        map.put("content", konten);
        map.put("time", (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(Calendar.getInstance().getTime()) + " UTC");
        
        // push ke firebase
        TransactionResult result = new TransactionResult();
        firebaseComment.push().setValue(map, result);
        
        // tunggu hingga transaksi nya selesai
        while (!result.done());
        return result.success();
    }

    @Override
    public List<Comment> listComment(Integer postId) {
        List<Comment> list = new ArrayList<Comment>();
        try {
            URL url = new URL(FIREBASE_URL + FIREBASE_COMMENT + ".json");
            URLConnection connection = url.openConnection();
            JSONObject json = new JSONObject(IOUtils.toString(connection.getInputStream()));
            
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                JSONObject jsonComment = json.getJSONObject(keys.next());
                Comment comment = new Comment();
                comment.setId(jsonComment.getInt("id"));
                comment.setPost_id(jsonComment.getInt("postId"));
                comment.setName(jsonComment.getString("name"));
                comment.setEmail(jsonComment.getString("email"));
                comment.setContent(jsonComment.getString("content"));
                comment.setTime(jsonComment.getString("time"));
                
                if (comment.getPost_id() == postId) {
                    list.add(comment);
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleBlogServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Post> search(String query) {
        List<Post> allPost = listPost();
        List<Post> list = new ArrayList<Post>();
        
        String[] token = query.toLowerCase().split(" \t\n\r");
        for (Post post : allPost) {
            String text = post.getTitle().toLowerCase() + " " + post.getContent().toLowerCase();
            boolean match = true;
            for (String word : token) {
                if (!text.contains(word)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(post);
            }
        }
        return list;
    }
    
}
