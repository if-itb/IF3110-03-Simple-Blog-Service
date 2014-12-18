/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;

/**
 *
 * @author USER
 */
public class Client {
    
    public Client() {}
    
    /*public static boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addPost(arg0, arg1, arg2, arg3);
    }

    public static boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        System.out.println(arg0+" "+arg1+" "+arg2+" "+arg3+" "+arg4); return false;
        /*org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addUser(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean delUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.delUser(arg0);
    }

    public static java.util.List<java.lang.String> readUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.readUser(arg0);
    }

    public static boolean updateUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.updateUser(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean addComment(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addComment(arg0, arg1, arg2, arg3);
    }

    public static boolean addNewPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3) throws IOException_Exception, JSONException_Exception, MalformedURLException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addNewPost(arg0, arg1, arg2, arg3);
    }

    public static boolean deletePost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePost(arg0);
    }

    public static java.util.List<java.lang.String> getAllComment(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getAllComment(arg0);
    }

    public static java.util.List<java.lang.String> getDeletedPost() throws MalformedURLException_Exception, IOException_Exception, JSONException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getDeletedPost();
    }

    public static String getPost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getPost(arg0);
    }

    public static java.util.List<java.lang.String> getPublishedPost() throws IOException_Exception, MalformedURLException_Exception, JSONException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getPublishedPost();
    }

    public static java.util.List<java.lang.String> getUnpublishedPost() throws IOException_Exception, MalformedURLException_Exception, JSONException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getUnpublishedPost();
    }

    public static boolean publishPost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.publishPost(arg0);
    }

    public static boolean updatePost(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4, java.lang.Long arg5) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.updatePost(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static java.util.List<java.lang.String> login(java.lang.String arg0, java.lang.String arg1) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.login(arg0, arg1);
    }*/

    public static boolean addComment(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addComment(arg0, arg1, arg2, arg3);
    }

    public static boolean addNewPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3) throws MalformedURLException_Exception, JSONException_Exception, IOException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addNewPost(arg0, arg1, arg2, arg3);
    }

    public static boolean deletePost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePost(arg0);
    }

    public static java.util.List<java.lang.String> getAllComment(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getAllComment(arg0);
    }

    public static java.util.List<java.lang.String> getDeletedPost() throws MalformedURLException_Exception, JSONException_Exception, IOException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getDeletedPost();
    }

    public static String getPost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getPost(arg0);
    }

    public static java.util.List<java.lang.String> getPublishedPost() throws IOException_Exception, JSONException_Exception, MalformedURLException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getPublishedPost();
    }

    public static java.util.List<java.lang.String> getUnpublishedPost() throws IOException_Exception, MalformedURLException_Exception, JSONException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getUnpublishedPost();
    }

    public static java.util.List<java.lang.String> login(java.lang.String arg0, java.lang.String arg1) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.login(arg0, arg1);
    }

    public static boolean publishPost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.publishPost(arg0);
    }

    public static boolean recoverPost(int arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.recoverPost(arg0);
    }

    public static boolean updatePost(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.Long arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.updatePost(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addPost(arg0, arg1, arg2, arg3);
    }

    public static boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addUser(arg0, arg1, arg2, arg3, arg4);
    }

    public static java.util.List<java.lang.String> readUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.readUser(arg0);
    }

    public static boolean updateUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.updateUser(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean delUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.delUser(arg0);
    }

    public static java.util.List<java.lang.String> getAllUser() throws MalformedURLException_Exception, JSONException_Exception, IOException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getAllUser();
    }

   
}
