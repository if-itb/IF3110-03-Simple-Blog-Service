/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import ClientService.DatabaseService_Service;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.bean. ManagedProperty ;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Andarias Silvanus
 */
@ManagedBean(name="editpost")
@SessionScoped
public class editpost implements Serializable
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;
    @ManagedProperty(value="#{user}")
    private User user;
    private String judul;
    private String author;
    private Date tanggal;
    private String tanggalString;
    private String konten;
    private String status;
    private String postID;

    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public String getAuthor() {
        return author;
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

    public Date getTanggal() {
        return tanggal;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setTanggalString(String tanggalString) {
        this.tanggalString = tanggalString;
    }

    public String getTanggalString() {
        return tanggalString;
    }

    public String getAutoFill()
    {
        System.out.println("getAutoFill");
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        postID = params.get("id");
        System.out.println("id get auto fill = " + postID);
        List<Post> posts = getPosts();
        for(Post p : posts)
        {
            if(p.getPost_id().equals(postID))
            {
                judul = p.getJudul();
                status = p.getStatus();
                konten = p.getKonten();
                author = user.getUsername();
                tanggalString = p.getTanggal();
                System.out.println("judul = " + judul);
                System.out.println("status = " + status);
                System.out.println("konten = " + konten);
                System.out.println("author = " + author);
                System.out.println("tanggal = " + tanggalString);
            }
        }
        return null;
    }
    
    public String changepost()
    {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(tanggalString);
            tanggalString = formatter.format(tanggal);
            editPost(postID, judul, author, konten, tanggalString);
        } catch (ParseException ex) {
            Logger.getLogger(editpost.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        return user.getRole()+".xhtml";
    }

    private Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String author, java.lang.String konten, java.lang.String tanggal) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.editPost(id, judul, author, konten, tanggal);
    }

    private java.util.List<ClientService.Post> listPost(java.lang.String postStatus) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.listPost(postStatus);
    }
    
    private List<Post>getPosts()
    {
        List<Post>list = new ArrayList<>();
        List<ClientService.Post> listPost = listPost("published");
        for(ClientService.Post p : listPost)
        {
            String author1 = p.getAuthor();
            String id = p.getId();
            String status1 = p.getStatus();
            String judul1 = p.getJudul();
            String konten1 = p.getKonten();
            String tanggal1 = p.getTanggal();
            Post temp = new Post(judul1, author1, tanggal1, konten1, status1, id);
            list.add(temp);
        }
        return list;
    }
    
}
