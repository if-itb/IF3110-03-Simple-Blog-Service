/**
 * 
 */
package org.chamerling.heroku.service;

import beans.Komentar;
import beans.Post;
import beans.User;
import com.firebase.client.Firebase;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.cxf.helpers.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {

        @Override
        public boolean deletePost(String key) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postRef = ref.child("post").child(key);
            postRef.removeValue();
            final boolean success = true;

            return success;
        }

        @Override
        public boolean editPost(String key, String judul, String tanggal, String konten) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postRef = ref.child("post").child(key);
        
            Map<String, Object> post = new HashMap<String, Object>();
            boolean status = false;

            post.put("judul", judul);
            post.put("konten", konten);
            post.put("tanggal", tanggal);
            post.put("status", status);

            postRef.updateChildren(post);
            return true;
        }

        @Override
        public boolean publishPost(String key) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postRef = ref.child("post").child(key).child("status");
            boolean status = true;
            postRef.setValue(status);
            return true;
        }

        @Override
        public boolean editUser(String key, String nama, String role, String email, String password) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase userRef = ref.child("user").child(key);
        
            Map<String, Object> user = new HashMap<String, Object>();

            user.put("nama", nama);
            user.put("password", password);
            user.put("role", role);
            user.put("email", email);
            userRef.updateChildren(user);
            return true;
        }

        @Override
        public boolean deleteUser(String key) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase userRef = ref.child("user").child(key);
            userRef.removeValue();
            return true;
        }

        @Override
        public boolean deleteComment(String keypost, String keycomment) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase userRef = ref.child("post").child(keypost).child("komentar").child(keycomment);
            userRef.removeValue();
            return true;
        }

        @Override
        public boolean addPost(String judul, String tanggal, String konten) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postReference = ref.child("post");
            Map<String, Object> post = new HashMap<String, Object>();
            boolean status = false;

            post.put("judul", judul);
            post.put("konten", konten);
            post.put("tanggal", tanggal);
            post.put("status", status);

            postReference.push().setValue(post);
            return true;
        }

        @Override
        public boolean addUser(String nama, String email, String role, String password) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postReference = ref.child("user");
            Map<String, Object> user = new HashMap<String, Object>();

            user.put("nama", nama);
            user.put("password", password);
            user.put("email", email);
            user.put("role", role);

            postReference.push().setValue(user);
            return true;
        }

        @Override
        public boolean addComment(String id_post, String nama, String email, String waktu, String kontent) {
            Firebase ref = new Firebase("https://tugaswbdiii32.firebaseio.com/");
            Firebase postReference = ref.child("/post/"+id_post+"/komentar");
            Map<String, Object> komen = new HashMap<String, Object>();

            komen.put("nama", nama);
            komen.put("email", email);
            komen.put("waktu", waktu);
            komen.put("kontent", kontent);

            postReference.push().setValue(komen);

            return true;
        }

        @Override
        public List<Post> listPost() throws MalformedURLException, IOException {
                List<Post> list = new ArrayList();
            try {
                URL path = new URL("https://tugaswbdiii32.firebaseio.com/post.json");
                URLConnection connect = path.openConnection();
                JSONTokener json = new JSONTokener(connect.getInputStream());
                
                JSONObject json_obj = new JSONObject(json);
                Iterator<String> posts = json_obj.keys();
                
                while(posts.hasNext()) {
                    String chain = posts.next();
                    JSONObject post = json_obj.getJSONObject(chain);
                    Post p = new Post();
                    p.setId_post(chain);
                    p.setJudul(post.getString("judul"));
                    p.setTanggal(post.getString("tanggal"));
                    p.setKonten(post.getString("konten"));
                    p.setStatus(post.getBoolean("status"));
                    
                    list.add(p);
                }
            } catch (JSONException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
           
            } 
                return list;
        }

        @Override
        public List<User> listUser() throws MalformedURLException, IOException{
            List<User> list = new ArrayList();
            try {
                URL path = new URL("https://tugaswbdiii32.firebaseio.com/user.json");
                URLConnection connect = path.openConnection();
                JSONTokener json = new JSONTokener(IOUtils.toString(connect.getInputStream()));
                
                JSONObject json_obj = new JSONObject(json);
                Iterator<String> users = json_obj.keys();
                
                while(users.hasNext()) {
                    String chain = users.next();
                    JSONObject post = json_obj.getJSONObject(chain);
                    User p = new User();
                    p.setId(chain);
                    p.setUsername(post.getString("nama"));
                    p.setPassword(post.getString("password"));
                    p.setEmail(post.getString("email"));
                    p.setRole(post.getString("role"));
                    
                    list.add(p);
                }
            } catch (JSONException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }

        @Override
        public List<Post> search(String query) {
            List<Post> list = new ArrayList();
            try {
                URL path = new URL("https://tugaswbdiii32.firebaseio.com/post.json");
                URLConnection connect = path.openConnection();
                JSONTokener json = new JSONTokener(connect.getInputStream());
                
                JSONObject json_obj = new JSONObject(json);
                Iterator<String> posts = json_obj.keys();
                
                while(posts.hasNext()) {
                    String chain = posts.next();
                    JSONObject post = json_obj.getJSONObject(chain);
                    if(post.getString("judul").toLowerCase().contains(query.toLowerCase()) || post.getString("konten").toLowerCase().contains(query.toLowerCase())) {
                        Post p = new Post();
                        p.setId_post(chain);
                        p.setJudul(post.getString("judul"));
                        p.setTanggal(post.getString("tanggal"));
                        p.setKonten(post.getString("konten"));
                        p.setStatus(post.getBoolean("status"));
                        
                        list.add(p);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
       
        @Override
        public List<Komentar> listComment(String id_post) throws MalformedURLException, IOException{
            List<Komentar> list = new ArrayList();
            try {
                URL path = new URL("https://tugaswbdiii32.firebaseio.com/post/"+id_post+"/komentar.json");
                URLConnection connect = path.openConnection();
                JSONTokener json = new JSONTokener(connect.getInputStream());
                
                JSONObject json_obj = new JSONObject(json);
                Iterator<String> komens = json_obj.keys();
                
                while(komens.hasNext()) {
                    String chain = komens.next();
                    JSONObject komen = json_obj.getJSONObject(chain);
                    Komentar p = new Komentar();
                    p.setId_kom(chain);
                    p.setUsername(komen.getString("nama"));
                    p.setEmail(komen.getString("email"));
                    p.setWaktu(komen.getString("waktu"));
                    p.setKomentar(komen.getString("kontent"));
                    
                    list.add(p);
                }
            } catch (JSONException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }

}
