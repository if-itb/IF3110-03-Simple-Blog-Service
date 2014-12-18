package com.blog.simple.bean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import simpleblog.service.endpoint.Comment;
import simpleblog.service.endpoint.Post;
import simpleblog.service.endpoint.SimpleblogProxy;

import com.blog.simple.model.Posting;

/**
*
* @author ramandika
*/
@ManagedBean
@RequestScoped
public class RequestBean{
   private Connection con;  
   private Statement stmt;  
   private ResultSet result;
   private String judulToBeShow;
   private String tanggalToBeShow;
   private String commentator;
   private String comment_content;
   private String email;
   private String ID;

   public String getID() {
       return ID;
   }

   public void setID(String ID) {
       this.ID = ID;
   }

   public String getCommentator() {
       return commentator;
   }

   public void setCommentator(String commentator) {
       this.commentator = commentator;
   }

   public String getComment_content() {
       return comment_content;
   }

   public void setComment_content(String comment_content) {
       this.comment_content = comment_content;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getJudulToBeShow() {
       return judulToBeShow;
   }
   
   public void RedirectPage(String page)
   {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try 
       {
           context.redirect(context.getRequestContextPath() + "/" + page + ".xhtml");
       } 
       catch (IOException ex) 
       {
           System.out.println(ex.getMessage());
       }
   }
   
   public void setJudulToBeShow(String judulToBeShow) {
       this.judulToBeShow = judulToBeShow;
   }

   public String getTanggalToBeShow() {
       return tanggalToBeShow;
   }

   public void setTanggalToBeShow(String tanggalToBeShow) {
       this.tanggalToBeShow = tanggalToBeShow;
   }

   public String getKontenToBeShow() {
       return kontenToBeShow;
   }

   public void setKontenToBeShow(String kontenToBeShow) {
       this.kontenToBeShow = kontenToBeShow;
   }
   private String kontenToBeShow;
   
   public void addcomment() throws RemoteException{
       Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String ID = params.get("id");
            String username = params.get("username");
            String useremail = params.get("useremail");
            	    System.out.println(username);
            if(username!=null) commentator=username;
            if(useremail!=null) email=useremail;
            SimpleblogProxy s = new SimpleblogProxy();
            s.addComment(ID, commentator, email, comment_content);
    }
   
   public void ShowDetailPost() throws RemoteException{
       Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
       String id = params.get("id");
       Post post=null;
       while(getJudulToBeShow()==null) {
	       post = new SimpleblogProxy().getPost(id);
	       setID(id);
	       setJudulToBeShow(post.getJudul());
	       setKontenToBeShow(post.getKonten());
	       setTanggalToBeShow(post.getTanggal());
       }
   }
   
   public List<Comment> retrieveListKomen() throws RemoteException, InterruptedException {
       Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
       String ID = params.get("id");
       
           List<Comment> kumpulankomen = new ArrayList<Comment>();
           SimpleblogProxy s = new SimpleblogProxy();
           System.out.println("23623");
           Comment[] comment= s.listComment(ID);
           System.out.println("asdasd");
           for(int i=0;i<comment.length;++i) {
        		   kumpulankomen.add(comment[i]);   
           }
           
           return kumpulankomen;
   }

}