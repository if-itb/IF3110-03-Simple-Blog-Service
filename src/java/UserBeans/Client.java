/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import org.chamerling.heroku.service.BlogPost;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.User;

/**
 *
 * @author Yusuf
 */
public class Client {

    public static String addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addComment(arg0, arg1, arg2, arg3);
    }

    public static Boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addPost(arg0, arg1, arg2, arg3);
    }

    public static boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addUser(arg0, arg1, arg2, arg3, arg4);
    }

    public static Boolean deletePost(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePost(arg0);
    }

    public static boolean deletePostPermanent(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePostPermanent(arg0);
    }

    public static String deleteUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deleteUser(arg0);
    }

    public static Boolean editPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editPost(arg0, arg1, arg2, arg3);
    }

    public static boolean editUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editUser(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static java.util.List<org.chamerling.heroku.service.User> getListUser() {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getListUser();
    }

    public static BlogPost getPost(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getPost(arg0);
    }

    public static User getUser(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.getUser(arg0);
    }

    public static java.util.List<org.chamerling.heroku.service.Komentar> listComment(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listComment(arg0);
    }

    public static java.util.List<org.chamerling.heroku.service.BlogPost> listDeletedPost() {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listDeletedPost();
    }

    public static java.util.List<org.chamerling.heroku.service.BlogPost> listPost() {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listPost();
    }

    public static java.util.List<org.chamerling.heroku.service.BlogPost> listUnpublishedPost() {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listUnpublishedPost();
    }

    public static boolean publishPost(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.publishPost(arg0);
    }
    
    public static boolean restorePost(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.restorePost(arg0);
    }

    public static java.util.List<org.chamerling.heroku.service.JsonObject> search(java.lang.String arg0) throws JSONException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.search(arg0);
    }
    
}
