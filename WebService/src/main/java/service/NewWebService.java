/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.Komentar;
import model.Post;
import model.UserBean;

/**
 *
 * @author Afik
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "addKomentar")
    @Oneway
    public void addKomentar(@WebParam(name = "komentar") Komentar komentar) {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllUser")
    public ArrayList<UserBean> getAllUser() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUserBean")
    @Oneway
    public void addUserBean() {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllKomentar")
    public ArrayList<Komentar> getAllKomentar() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPublishedPost")
    public ArrayList<Post> getPublishedPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUnpublishedPost")
    public ArrayList<Post> getUnpublishedPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public String publishPost(@WebParam(name = "PID") int PID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reloadEditPost")
    @Oneway
    public void reloadEditPost() {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public String editPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public String deletePost(@WebParam(name = "PID") int PID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public String addPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    @Oneway
    public void editUser() {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    @Oneway
    public void deleteUser(@WebParam(name = "username") String username) {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPost")
    public Post getPost(@WebParam(name = "PID") int PID) {
        //TODO write your implementation code here:
        return null;
    }




}
