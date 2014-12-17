/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import com.corejsf.ListMember;
import com.corejsf.ListPost;
import com.corejsf.Member1;
import com.corejsf.Post;
import com.firebase.client.Firebase;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONObject;
import org.json.JSONTokener;


/**
 *
 * @author TOSHIBA
 */
@WebService(serviceName = "ws")
public class ws {
    private final String fburl = "https://makan.firebaseio.com/";
    private final Firebase root = new Firebase(fburl);
    private final Firebase rootpost = new Firebase(fburl + "post/");
    /** 
     * This is a sample web service operation
     */
    @WebMethod(operationName = "AddPost")
    public boolean AddPost(@WebParam(name = "Judul") String Judul,@WebParam(name = "Tanggal") String Tanggal,@WebParam(name = "Konten") String Konten,@WebParam(name = "Status") String Status,@WebParam(name = "Deleted") String Deleted) {
        Firebase temp = root.child("post");
        Map<String,String> post = new HashMap<>();
        post.put("Judul", Judul);
        post.put("Tanggal", Tanggal);
        post.put("Status", Status);
        post.put("Konten", Konten);
        post.put("Deleted", Deleted);
        temp.push().setValue(post);
        
        return true;
    }
 
    @WebMethod(operationName = "AddMember")
    public boolean AddMember(@WebParam(name = "Email") String Email,@WebParam(name = "Name") String Name,@WebParam(name = "Password") String Password,@WebParam(name = "Role") String Role) {
        
        Firebase temp = root.child("member");
        Map<String,String> member = new HashMap<>();
        member.put("Email", Email);
        member.put("Name", Name);
        member.put("Password", Password);
        member.put("Role", Role);
        temp.push().setValue(member);
        
        return true;
    }
    @WebMethod(operationName = "GetPost")
    public ListPost GetPost(@WebParam(name = "Email") String Email){
        try {
            URL url = new URL(fburl + "post/.json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Iterator<String> datapost = obj.keys();
            ListPost list = new ListPost();
            ArrayList<Post> published_posts = new ArrayList<>();
            ArrayList<Post> unpublished_posts = new ArrayList<>();
            ArrayList<Post> deleted_posts = new ArrayList<>();

            while(datapost.hasNext()){
                String id_post = datapost.next();
                JSONObject getpost = obj.getJSONObject(id_post);

                Post p = new Post();
                p.setDeleted(getpost.getString("Deleted"));
                p.setId(id_post);
                p.setJudul(getpost.getString("Judul"));
                p.setKonten(getpost.getString("Konten"));
                p.setStatus(getpost.getString("Status"));
                p.setTanggal(getpost.getString("Tanggal"));
                if(p.getDeleted().equals("1")){
                    deleted_posts.add(p);
                }
                else{
                    if(p.getStatus().equals("Unpublished")){
                        unpublished_posts.add(p);
                    }
                    else if(p.getStatus().equals("Published")){
                        published_posts.add(p);
                    }
                }
            }
            list.setDeleted_posts(deleted_posts);
            list.setPublished_posts(published_posts);
            list.setUnpublished_posts(unpublished_posts);

            for(Post p:list.getPublished_posts()){
                System.out.println(p.getId() + " " + p.getJudul() + " " + p.getKonten() + " " + p.getTanggal()+ " " + p.getStatus() + " " + p.getDeleted());
            }

            for(Post p:list.getUnpublished_posts()){
                System.out.println(p.getId() + " " + p.getJudul() + " " + p.getKonten() + " " + p.getTanggal()+ " " + p.getStatus() + " " + p.getDeleted());
            }

            for(Post p:list.getDeleted_posts()){
                System.out.println(p.getId() + " " + p.getJudul() + " " + p.getKonten() + " " + p.getTanggal()+ " " + p.getStatus() + " " + p.getDeleted());
            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "GetMember")
    public ListMember GetMember(){
        try {
            URL url = new URL(fburl + "member/.json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Iterator<String> datamember = obj.keys();
            ListMember list = new ListMember();
            ArrayList<Member1> members = new ArrayList<>();

            while(datamember.hasNext()){
                String id_member = datamember.next();
                JSONObject getmember = obj.getJSONObject(id_member);

                Member1 m = new Member1();
                m.setEmail(getmember.getString("Email"));
                m.setId(id_member);
                m.setName(getmember.getString("Name"));
                m.setPassword(getmember.getString("Password"));
                m.setRole(getmember.getString("Role"));
                members.add(m);
            }
            
            list.setMembers(members);

            for(Member1 m:list.getMembers()){
                System.out.println(m.getEmail() + " " + m.getId() + " " + m.getName() + " " + m.getPassword() + " " + m.getRole());
            }
            return list;
            
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "AddComment")
    public Boolean AddComment(@WebParam(name = "Key") String Key, @WebParam(name = "Nama") String Nama, @WebParam(name = "Email") String Email, @WebParam(name = "Komentar") String Komentar, @WebParam(name = "Tanggal") String Tanggal){
        Firebase temp = rootpost.child(Key + "/comment");
        Map<String,String> comment = new HashMap<>();
        comment.put("Nama", Nama);
        comment.put("Email", Email);
        comment.put("Komentar", Komentar);
        comment.put("Tanggal", Tanggal);
        temp.push().setValue(comment);
        
        return true;
    }
    
    @WebMethod(operationName = "GetMemberById")
    public Member1 GetMemberById(@WebParam(name = "Key") String Key){
        try {
            URL url = new URL(fburl + "member/" + Key + "/.json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Member1 m = new Member1();

            m.setEmail(obj.getString("Email"));
            m.setId(Key);
            m.setName(obj.getString("Name"));
            m.setPassword(obj.getString("Password"));
            m.setRole(obj.getString("Role"));

            System.out.println(m.getEmail() + " " + m.getId() + " " + m.getName() + " " + m.getPassword() + " " + m.getRole());
            return m;
            
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "GetPostById")
    public Post GetPostById(@WebParam(name = "Key") String Key){
        try {
            URL url = new URL(fburl + "post/" + Key + "/.json");
            URLConnection con = url.openConnection();
            JSONTokener json = new JSONTokener(con.getInputStream());
            JSONObject obj = new JSONObject(json);
            Post p = new Post();
            
            p.setDeleted(obj.getString("Deleted"));
            p.setId(Key);
            p.setJudul(obj.getString("Judul"));
            p.setKonten(obj.getString("Konten"));
            p.setStatus(obj.getString("Status"));
            p.setTanggal(obj.getString("Tanggal"));
        
            System.out.println(p.getId() + " " + p.getJudul() + " " + p.getKonten() + " " + p.getTanggal()+ " " + p.getStatus() + " " + p.getDeleted());
            return p;
            
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}