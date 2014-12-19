/**
 * 
 */
package org.chamerling.heroku.service;

import javax.jws.WebService;
import com.firebase.client.*;
import java.io.InputStream;
import java.util.*;
import java.lang.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.net.URL;
import org.apache.commons.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import datatype.*;

/**
 * @author chamerling
 * 
 */
public interface HelloService {

    /**
     * This is a sample web service operation
     */    
    public void updateJSONString();
    
    /**
     * Web service operation
     */
    public boolean addPost(@WebParam(name = "title") String title, @WebParam(name = "content") String content, @WebParam(name = "date") String date, @WebParam(name = "authorid") String authorid);
    

    /**
     * Web service operation
     */
    public boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal);

    /**
     * Web service operation
     */
    public boolean publishPost(@WebParam(name = "id") String id);

    /**
     * Web service operation
     */
    public List listPost();

    public boolean deletePost(@WebParam(name = "id") String id);

    /**
     * Web service operation
     */
    public boolean addUser(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "role") String role);
    
    public List<User> listUser();

    /**
     * Web service operation
     */
    public boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email);

    /**
     * Web service operation
     */
    public boolean deleteUser(@WebParam(name = "id") String id);

    /**
     * Web service operation
     */
    public boolean addComment(@WebParam(name = "idPost") String idPost, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal);

    /**
     * Web service operation
     */
    public boolean deleteComment(@WebParam(name = "id") String id, @WebParam(name = "commid") String commid);

    /**
     * Web service operation
     */
    public ArrayList search(@WebParam(name = "query") String query);

    /**
     * Web service operation
     */
    public ArrayList listComment(@WebParam(name = "postid") String postid);
    
}
