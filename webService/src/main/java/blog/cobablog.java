/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author M. Reza Irvanda
 */
@WebService(serviceName = "cobablog")
public class cobablog {

    public static final String AUTH_TOKEN = "Jeqg6K2cgLB509zZQ2EMxr07qezh2CfActE23SoA";
    public static Boolean selesaiRetrieve = false;
    public static DataSnapshot data = null;
    public static final String LINK_FIREBASE= "https://luminous-heat-1349.firebaseio.com/";
    public static Firebase fb = new Firebase(LINK_FIREBASE);
    /**
     * Web service operation
     * @param judul
     * @param konten
     * @param tanggal
     * @param author
     * @return 
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        
        mp.put("judul", judul);
        mp.put("konten", konten);
        mp.put("tanggal", tanggal);
        mp.put("author", author);
        mp.put("published","0");
        mp.put("deleted","0");
        mp.put("komentar","-");
        fb.child("posts").push().setValue(mp);
        return true;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listPost")
    public List<Post> listPost() {
        List<Post> out = new ArrayList<Post>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"posts.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
                        
            int i;
            for (i=0; i<o.size(); i++)
            {
                Post p = new Post();
                p.setId(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(p.getId()).toString());
                p.setAuthor((String) postEntry.get("author"));
                p.setJudul((String) postEntry.get("judul"));
                p.setKonten((String) postEntry.get("konten"));
                p.setTanggal((String) postEntry.get("tanggal"));
                p.setDeleted((String) postEntry.get("deleted"));
                p.setPublished((String) postEntry.get("published"));
                
                if ((!p.isDeleted()) && p.isPublished())
                {
                    out.add(p);
                }
            }
            
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    @WebMethod(operationName = "listUnpublishedPost")
    public List<Post> listUnpublishedPost() {
        List<Post> out = new ArrayList<Post>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"posts.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
                        
            int i;
            for (i=0; i<o.size(); i++)
            {
                Post p = new Post();
                p.setId(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(p.getId()).toString());
                p.setAuthor((String) postEntry.get("author"));
                p.setJudul((String) postEntry.get("judul"));
                p.setKonten((String) postEntry.get("konten"));
                p.setTanggal((String) postEntry.get("tanggal"));
                p.setDeleted((String) postEntry.get("deleted"));
                p.setPublished((String) postEntry.get("published"));
                
                if ((!p.isDeleted()) && (!p.isPublished()))
                {
                    out.add(p);
                }
            }
            
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    @WebMethod(operationName = "listDeletedPost")
    public List<Post> listDeletedPost() {
        List<Post> out = new ArrayList<Post>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"posts.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
            
            
            int i;
            for (i=0; i<o.size(); i++)
            {
                Post p = new Post();
                p.setId(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(p.getId()).toString());
                p.setAuthor((String) postEntry.get("author"));
                p.setJudul((String) postEntry.get("judul"));
                p.setKonten((String) postEntry.get("konten"));
                p.setTanggal((String) postEntry.get("tanggal"));
                p.setDeleted((String) postEntry.get("deleted"));
                p.setPublished((String) postEntry.get("published"));
                
                if ((p.isDeleted()))
                {
                    out.add(p);
                }
            }
            
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    /**
     * Web service operation
     * @param idPost
     * @param judul
     * @param konten
     * @param tanggal
     * @return 
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "idPost") String idPost, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") Date tanggal) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        
        mp.put("judul", judul);
        mp.put("konten", konten);
        mp.put("tanggal", tanggal);
        fb.child("posts").child(idPost).updateChildren(mp);
        return true;
    }

    /**
     * Web service operation
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "idPost") String idPost) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        fb.child("posts").child(idPost).setValue(mp);
        return true;
    }

    /**
     * Web service operation
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "idPost") String idPost) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        mp.put("published","1");
        fb.child("posts").child(idPost).updateChildren(mp);
        return true;
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
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        Map<String,Object> mp2 = new HashMap<>();
        mp2.put(nama, "yeah");
        mp.put("nama", nama);
        mp.put("email", email);
        mp.put("role",role);
        mp.put("password", password);
        fb.child("users").child(nama).setValue(mp);
        return true;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listUser")
    public List <Pengguna> listUser() {
        //TODO write your implementation code here:
        ArrayList <Pengguna> out = new ArrayList<>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"/users.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
                        
            int i;
            for (i=0; i<o.size(); i++)
            {
                Pengguna p = new Pengguna();
                p.setUsername(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(p.getUsername()).toString());
                p.setEmail((String) postEntry.get("email"));
                p.setNama((String) postEntry.get("nama"));
                p.setPassword((String) postEntry.get("password"));
                p.setRole((String) postEntry.get("role"));
                out.add(p);
            }           
            
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    /**
     * Web service operation
     * @param idUser
     * @param nama
     * @param role
     * @param email
     * @param password
     * @return 
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "idUser") String idUser, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();
        
        mp.put("nama", nama);
        mp.put("email", email);
        mp.put("role", role);
        mp.put("password",password);
        fb.child("users").child(idUser).updateChildren(mp);
        return true;
    }

    /**
     * Web service operation
     * @param idUser
     * @return 
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "idUser") String idUser) {
        //TODO write your implementation code here:
        fb.child("users").child(idUser).setValue(null);
        return true;
    }

    /**
     * Web service operation
     * @param nama
     * @param email
     * @param konten
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten, @WebParam(name = "date") String date, @WebParam(name = "idPost") String idPost) {
        //TODO write your implementation code here:
        Map<String,Object> mp = new HashMap<>();  
        mp.put("nama", nama);
        mp.put("email", email);
        mp.put("tanggal",date);
        mp.put("konten", konten);
        fb.child("posts").child(idPost).child("komentar").push().setValue(mp);
        return true;
    }

    /**
     * Web service operation
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "listComment")
    public List <Komentar> listComment(@WebParam(name = "idPost") String idPost) {
        ArrayList <Komentar> out = new ArrayList<>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"posts/"+idPost+"/komentar.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
                        
            int i;
            for (i=0; i<o.size(); i++)
            {
                Komentar k = new Komentar();
                k.setId(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(k.getId()).toString());
                k.setEmail((String) postEntry.get("email"));
                k.setKonten((String) postEntry.get("konten"));
                k.setNama((String) postEntry.get("nama"));
                k.setTanggal((String) postEntry.get("tanggal"));
                                
                out.add(k);
                
            }
                       
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    /**
     * Web service operation
     * @param id
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "deleteComment")
    public Boolean deleteComment(@WebParam(name = "id") String id,@WebParam(name = "idPost") String idPost) {
        //TODO write your implementation code here:
        fb.child(idPost).child("komentar").child(id).setValue(null);
        return true;
    }

    /**
     * Web service operation
     * @param query
     * @return 
     */
    @WebMethod(operationName = "search")
    public List <Post> search(@WebParam(name = "query") String query) {
        List<Post> out = new ArrayList<Post>();
        try {
            //TODO write your implementation code here:
            String linkString = LINK_FIREBASE+"posts.json";
            URL link = new URL(linkString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            
            String s ="";
            String tmp;
            while((tmp=reader.readLine())!=null){
                s+=tmp;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(s);
            
            
            int i;
            for (i=0; i<o.size(); i++)
            {
                Post p = new Post();
                p.setId(o.keySet().toArray()[i].toString());
                JSONObject postEntry = (JSONObject) parser.parse(o.get(p.getId()).toString());
                p.setAuthor((String) postEntry.get("author"));
                p.setJudul((String) postEntry.get("judul"));
                p.setKonten((String) postEntry.get("konten"));
                p.setTanggal((String) postEntry.get("tanggal"));
                p.setDeleted((String) postEntry.get("deleted"));
                p.setPublished((String) postEntry.get("published"));
                
                boolean kontenFound = p.getKonten().toLowerCase().contains(query.toLowerCase());
                boolean judulFound = p.getJudul().toLowerCase().contains(query.toLowerCase());
                if ((!p.isDeleted()) && (p.isPublished()) && (judulFound || kontenFound))
                {
                    out.add(p);
                }
            }
            
            return out;
            //System.out.println(array.get(0));
        } catch (MalformedURLException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cobablog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    /**
     * Web service operation
     * @param idPost
     * @return 
     */
    @WebMethod(operationName = "softDelete")
    public Boolean softDelete(@WebParam(name = "idPost") String idPost) {
        //TODO write your implementation code here:
        Map<String, Object> mp = new HashMap<>();
        mp.put("deleted","1");
        fb.child("posts").child(idPost).updateChildren(mp);
        return true;
    }   
}
