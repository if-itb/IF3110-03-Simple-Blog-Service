/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import ClientService.DatabaseService_Service;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean. ManagedProperty ;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Andarias Silvanus
 */
@ManagedBean(name = "newpost", eager=true)
@RequestScoped
public class newpost implements Serializable
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;
    /**
     * Creates a new instance of newpost
     */
    private String judul;
    @ManagedProperty(value="#{user.username}")
    private String author;
    private Date tanggal;
    private String konten;
    private String status;
    private String id;
   
    /*
    @ManagedProperty(value="#{user}")
    private User user; */
    
    public newpost() 
    {
        id = "";
        judul = "";
        tanggal = null;
        konten = "";
        status = "unpublished";
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void add_post()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Date = " + tanggal.toString());
        String date = formatter.format(tanggal);
        System.out.println("String = " + date);
        addPost(judul, author, konten, date);
        judul = "";
        tanggal = null;
        konten = "";
    }

    private Boolean addPost(java.lang.String judul, java.lang.String author, java.lang.String konten, java.lang.String tanggal) {
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.addPost(judul, author, konten, tanggal);
    }
    
}
