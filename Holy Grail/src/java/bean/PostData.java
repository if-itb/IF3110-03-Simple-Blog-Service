package bean;

import ClientService.DatabaseService_Service;
import ClientService.Post;
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
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

@ManagedBean(name = "postdata", eager=true)
@RequestScoped
public class PostData implements Serializable
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;
    @ManagedProperty(value = "#{param['id']}")
    private String id;    
    private String judul;
    private String author;
    private String tanggal;
    private String konten;
    private String status;
    
    public PostData() 
    {
        System.out.println("PostData created");
        judul = "";
        author = "";
        tanggal = "";
        konten = "";
        status = "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getKonten() {
        return konten;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
        fetchPostsFromDB();
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public void fetchPostsFromDB()
    {
        List<Post> listPost = listPost("published");
        System.out.println("list post = " + listPost.toString());
        List<bean.Post> post = new ArrayList<>();
        for(Post p : listPost)
        {
            System.out.println("p = " + p.toString());
            if(p.getId().equals(id))
            {
                author = p.getAuthor();
                status = p.getStatus();
                judul = p.getJudul();
                konten = p.getKonten();
                tanggal = p.getTanggal();
                break;
            }
        }
    }

    private java.util.List<ClientService.Post> listPost(java.lang.String postStatus) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.listPost(postStatus);
    }

}
