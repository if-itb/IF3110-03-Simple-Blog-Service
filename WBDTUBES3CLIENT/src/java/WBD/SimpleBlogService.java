package WBD;

import java.util.ArrayList;
import WBD.SimpleBlog_Service;
import WBD.SimpleBlog;
import WBD.User;
import WBD.Post;
import WBD.Comment;
import java.util.List;

public class SimpleBlogService {

    public static boolean addComment(int id, java.lang.String nama, java.lang.String email, java.lang.String komentar) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.addComment(id, nama, email, komentar);
    }
    
    
//    public static boolean addUser(String email, String password, String name, String role) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.addUser(email, password, name, role);
//    }
//    
//    public static boolean editUser(String email, String password, String name, String role) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.editUser(email, password, name, role);
//    }
//    
//    public static List<User> listUser() {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.listUser();
//    }
//    
//    public static User getUser(String email) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.getUser(email);
//    }
//    
//    public static User login(String email, String password) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.login(email, password);
//    }
//    
//    public static boolean deleteUser(String email) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.deleteUser(email);
//    }
//    
//    public static boolean addPost(String judul, String tanggal, String konten) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.addPost(judul, tanggal, konten);
//    }
//    
//    public static boolean editPost(int id, String judul, String tanggal, String konten) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.editPost(id, judul, tanggal, konten);
//    }
//    
//    public static boolean deletePost(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.deletePost(id);
//    }
//    
//    public static boolean literallyDeletePost(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.literallyDeletePost(id);
//    }
//    
//    public static boolean undeletePost(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.undeletePost(id);
//    }
//    
//    public static List<Post> publishedPost() {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.publishedPost("Published");
//    }
//    
//    public static List<Post> unpublishedPost() {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.unpublishedPost("Unpublished");
//    }
//    
//    public static List<Post> deletedPost() {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.publishedPost("Deleted");
//    }
//    
//    public static boolean publishPost(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.publishPost(id);
//    }
//    
//    public static Post getPost(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.getPost(id);
//    }
//    
//    public static boolean addImage(int id, String filename) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.addImage(id, filename);
//    }
//    
//    public static boolean removeImage(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.removeImage(id);
//    }
//    
//    public static boolean addComment(int id, String nama, String email, String komentar) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.addComment(id, nama, email, komentar);
//    }
//    
//    public static List<Comment> listComment(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.listComment(id);
//    }
//    
//    public static Comment getComment(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.getComment(id);
//    }
//    
//    public static boolean deleteComment(int id) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.deleteComment(id);
//    }
//    
//    public static List<Post> search(String query) {
//        SimpleBlog_Service service = new SimpleBlog_Service();
//        SimpleBlog port = service.getSimpleBlogPort();
//        return port.search(query);
//    }    

    public static boolean addImage(int id, java.lang.String filename) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.addImage(id, filename);
    }

    public static boolean addPost(java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.addPost(judul, tanggal, konten);
    }

    public static boolean addUser(java.lang.String email, java.lang.String password, java.lang.String name, java.lang.String role) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.addUser(email, password, name, role);
    }

    public static boolean deleteComment(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.deleteComment(id);
    }

    public static boolean deletePost(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.deletePost(id);
    }

    public static boolean deleteUser(java.lang.String email) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.deleteUser(email);
    }

    public static java.util.List<WBD.Post> deletedPost(java.lang.String status) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.deletedPost(status);
    }

    public static boolean editPost(int id, java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.editPost(id, judul, tanggal, konten);
    }

    public static boolean editUser(java.lang.String email, java.lang.String password, java.lang.String name, java.lang.String role) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.editUser(email, password, name, role);
    }

    public static Comment getComment(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.getComment(id);
    }

    public static Post getPost(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.getPost(id);
    }

    public static User getUser(java.lang.String email) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.getUser(email);
    }

    public static java.util.List<WBD.Comment> listComment(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.listComment(id);
    }

    public static java.util.List<WBD.User> listUser() {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.listUser();
    }

    public static boolean literallyDeletePost(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.literallyDeletePost(id);
    }

    public static User login(java.lang.String email, java.lang.String password) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.login(email, password);
    }

    public static boolean publishPost(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.publishPost(id);
    }

    public static java.util.List<WBD.Post> publishedPost(java.lang.String status) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.publishedPost(status);
    }

    public static boolean removeImage(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.removeImage(id);
    }

    public static java.util.List<WBD.Post> search(java.lang.String query) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.search(query);
    }

    public static boolean undeletePost(int id) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.undeletePost(id);
    }

    public static java.util.List<WBD.Post> unpublishedPost(java.lang.String status) {
        WBD.SimpleBlog_Service service = new WBD.SimpleBlog_Service();
        WBD.SimpleBlog port = service.getSimpleBlogPort();
        return port.unpublishedPost(status);
    }        
}
