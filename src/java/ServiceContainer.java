
import service.Post;
import service.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class ServiceContainer {

    public static Boolean addComment(java.lang.String postid, java.lang.String nama, java.lang.String email, java.lang.String konten) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.addComment(postid, nama, email, konten);
    }

    public static Boolean addPost(java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.addPost(judul, tanggal, konten);
    }

    
    
    public static Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String role) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.addUser(username, password, nama, email, role);
    }

    public static Boolean deleteUser(java.lang.String id) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.deleteUser(id);
    }

    public static Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String konten, java.lang.String tanggal) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.editPost(id, judul, konten, tanggal);
    }

    public static Boolean editUser(java.lang.String id, java.lang.String nama, java.lang.String email, java.lang.String role) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.editUser(id, nama, email, role);
    }

    public static java.util.List<service.Comment> listComment(java.lang.String postid) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.listComment(postid);
    }

    public static java.util.List<service.Post> listPost() {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.listPost();
    }

    public static java.util.List<service.User> listUser() {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.listUser();
    }

    public static Boolean login(java.lang.String username, java.lang.String password) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.login(username, password);
    }

    public static java.util.List<service.Post> searchPost(java.lang.String keyword) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.searchPost(keyword);
    }

    public static Boolean deletePost(java.lang.String id) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.deletePost(id);
    }

    public static Post getPost(java.lang.String arg0) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.getPost(arg0);
    }

    public static User getUser(java.lang.String arg0) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.getUser(arg0);
    }

    public static Boolean softDeletePost(java.lang.String id) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.softDeletePost(id);
    }

    public static Boolean publishPost(java.lang.String id) {
        service.SABService_Service service = new service.SABService_Service();
        service.SABService port = service.getSABServicePort();
        return port.publishPost(id);
    }

}
