package bean;

import ClientService.DatabaseService_Service;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;

@ManagedBean(name = "post", eager=true)
@RequestScoped
public class Post implements Serializable
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;
    @ManagedProperty(value = "#{param.id}")
    private int id;
    
    @ManagedProperty(value = "#{user}")
    private User user;
    
    private String judul;
    private String author;
    private String tanggal;
    private String konten;
    private String status;
    private String post_id;
    private String query_status;
    private String keyword;
    List<Post> daftar_post;
    
    public Post() 
    {
        judul = "";
        author = "";
        tanggal = "";
        konten = "";
        status = "";
        post_id = "";
        query_status ="";
        keyword = "";
        daftar_post = new ArrayList<>();
    }

    public Post(String judul, String author, String tanggal, String konten, String status, String post_id) {
        this.judul = judul;
        this.author = author;
        this.tanggal = tanggal;
        this.konten = konten;
        this.status = status;
        this.post_id = post_id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getKonten() {
        return konten;
    }

    public String getStatus() {
        return status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getQuery_status() {
        return query_status;
    }

    public User getUser() {
        return user;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setDaftar_post(List<Post> daftar_post) {
        this.daftar_post = daftar_post;
    }

    public void setQuery_status(String query_status) {
        this.query_status = query_status;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    /* Versi Web Service */
    public List<Post> getSearchPost()
    {
        List<ClientService.Post> search = search(keyword);
        List<Post> list = new ArrayList<>();
        for(ClientService.Post p : search)
        {
            String author = p.getAuthor();
            String post_id = p.getId();
            String status = p.getStatus();
            String konten = p.getKonten();
            String tanggal = p.getTanggal();
            String judul = p.getJudul();
            Post temp = new Post(judul, author, tanggal, konten, status, post_id);
            System.out.println("Status get post = " + status);     
            if("published".equals(status))
            {
                System.out.println("Info :: Add to Search List");
                list.add(temp);
            }
        }
        return list;
    }
    
    public String getPublishedPost()
    {
        getPost("published");
        return null;
    }
    
    public String getDeletedPost()
    {
        getPost("deleted");
        return null;
    }
    
    public String getUnpublishedPost()
    {
        getPost("unpublished");
        return null;
    }
    
    private void getPost(String post_status)
    {
        daftar_post = new ArrayList<>();
        List<ClientService.Post> listPost = listPost(post_status);
        for(ClientService.Post p : listPost)
        {
            String author = p.getAuthor();
            String post_id = p.getId();
            String status = p.getStatus();
            String konten = p.getKonten();
            String tanggal = p.getTanggal();
            String judul = p.getJudul();
            Post temp = new Post(judul, author, tanggal, konten, status, post_id);
            daftar_post.add(temp);
        }
    }
    /* Versi Web Service */
    
    /* harus di set dulu mau ambil yang statusnya apa */
    public List<Post> getDaftar_post() {
        return daftar_post;
    }
    
    public List<Post> getEditablePost()
    {
        daftar_post = new ArrayList<>();
        List<ClientService.Post> listPost = listPost("published");
        for(ClientService.Post p : listPost)
        {
            String author1 = p.getAuthor();
            String id1 = p.getId();
            String judul1 = p.getJudul();
            String konten1 = p.getKonten();
            String status1 = p.getStatus();
            String tanggal1 = p.getTanggal();
            if(author1 == user.getUsername())
            {
                Post temp = new Post(judul1, author1, tanggal1, konten1, status1, id1);
                daftar_post.add(temp);
            }
        }
        return null;
    }
    /* Ambil semua post dari database */
    public List<Post> getPosts()
    {
        System.out.println("=====masuk getPost?=====");
        List<Post>post = new ArrayList<>();
        List<ClientService.Post> postt = listPost("published");
        System.out.println("=====bisa query?=====");
        for(ClientService.Post p : postt)
        {
            String author1 = p.getAuthor();
            String id1 = p.getId();
            String konten1 = p.getKonten();
            String judul1 = p.getJudul();
            String status1 = p.getStatus();
            String tanggal1 = p.getTanggal();
            Post temp = new Post(judul1, author1, tanggal1, konten1, status1, id1);
            post.add(temp);
        }
        return post;
    }
    
    public void fetchPostsFromDB()
    {
        try {
            System.out.println("Fetch Posts from DB");
            daftar_post = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/simple_blog_java","root","");
            System.out.println("Connection Created!");
            String query = "SELECT * FROM `post` WHERE status = " + "'" + query_status + "' ORDER BY tanggal DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Post temp = new Post();
                temp.id = result.getInt("id");
                temp.judul = result.getString("judul");
                temp.author = result.getString("author");
                temp.tanggal = result.getString("tanggal");
                temp.konten = result.getString("konten");
                temp.status = result.getString("status");
                daftar_post.add(temp);
            }
            System.out.println("Posts sucessfully fetched");
            con.close();
            System.out.println("connection closed");
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println(ex.toString());
        } 
    }
    public void printDB()
    {
        fetchPostsFromDB();
        for(Post post : daftar_post)
        {
            System.out.println(post.judul);
            System.out.println(post.tanggal);
            System.out.println(post.konten);
        }
    }
    public void publish()
    {
        try {
            System.out.println("publish");
            System.out.println("ID = " + id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/simple_blog_java","root","");
            System.out.println("connection created");
            String query = "update post set `status` = 'published' where `id` = " + id;
            System.out.println("query : " + query);
            PreparedStatement ps = con.prepareStatement(query);
            int retval = ps.executeUpdate();
            if(retval < 0)
            {
                System.out.println("Query unsuccessful");
            }
            else
            {
                System.out.println("Query Succesfu  l");
            }
            con.close();
            System.out.println("connection close");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        } 
    }

    private java.util.List<ClientService.Post> listPost(java.lang.String postStatus) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.listPost(postStatus);
    }

    private java.util.List<ClientService.Post> search(java.lang.String query) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.search(query);
    }
    
}
