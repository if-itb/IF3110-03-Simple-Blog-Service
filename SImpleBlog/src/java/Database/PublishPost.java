/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.WebServiceRef;
import service.Exception_Exception;
import service.Service_Service;

/**
 *
 * @author Sakurai
 */
@ManagedBean(name = "Publishpost", eager = true)
@ViewScoped
public class PublishPost {          
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/intense-shore-8980.herokuapp.com/HelloService.wsdl")
    private Service_Service service;
    public PublishPost(){
        
    }
        
    private Connection getConnection() throws ClassNotFoundException, SQLException, IllegalAccessException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/blog";
            String user = "root";
            String password = "";
            conn =  DriverManager.getConnection(url, user, password);
        }catch(InstantiationException e){
            System.err.println(e);
        }
        return conn;
    }
    
    public List<service.Post> getUnpublishedPost() throws ClassNotFoundException, IllegalAccessException, SQLException, Exception_Exception{
        List<service.Post> UnpublishedPost = new ArrayList<>();
        UnpublishedPost = listPost("unpublished");
        return UnpublishedPost;
    }
    
    public List<service.Post> getpublishedPost() throws ClassNotFoundException, IllegalAccessException, Exception_Exception{
        List<service.Post> publishedPost = new ArrayList<>();
        publishedPost = listPost("published");
        return publishedPost;
    }
    
    public void publishPost(String postID) throws ClassNotFoundException, IllegalAccessException{
        changeStatusPost(postID, "published");
    }

    private java.util.List<service.Post> listPost(java.lang.String status) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.listPost(status);
    }

    private boolean changeStatusPost(java.lang.String postId, java.lang.String status) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.changeStatusPost(postId, status);
    }
    
}
