package WBD;

import java.util.ArrayList;
import WBD.SimpleBlog_Service;
import WBD.SimpleBlog;
import WBD.User;
import WBD.Post;
import WBD.Comment;

public class SimpleBlogService {
    
    public static boolean addUser(String email, String password, String name, String role) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.addUser(email, password, name, role);
    }
    
    public static boolean editUser(String email, String password, String name, String role) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.editUser(email, password, name, role);
    }
    
    public static ArrayList<User> listUser() {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.listUser();
    }
    
    public static User getUser(String email) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.getUser(email);
    }
    
    public static User login(String email, String password) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.login(email, password);
    }
    
    public static boolean deleteUser(String email) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.deleteUser(email);
    }
    
    public static boolean addPost(String judul, String tanggal, String konten) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.addPost(judul, tanggal, konten);
    }
    
    public static boolean editPost(int id, String judul, String tanggal, String konten) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.editPost(id, judul, tanggal, konten);
    }
    
    public static boolean deletePost(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.deletePost(id);
    }
    
    public static boolean literallyDeletePost(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.literallyDeletePost(id);
    }
    
    public static boolean undeletePost(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.undeletePost(id);
    }
    
    public static ArrayList<Post> publishedPost() {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.publishedPost("Published");
    }
    
    public static ArrayList<Post> unpublishedPost() {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.publishedPost("Unublished");
    }
    
    public static ArrayList<Post> deletedPost() {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.publishedPost("Deleted");
    }
    
    public static boolean publishPost(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.publishPost(id);
    }
    
    public static Post getPost(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.getPost(id);
    }
    
    public static boolean addImage(int id, String filename) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.addImage(id, filename);
    }
    
    public static boolean removeImage(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.removeImage(id);
    }
    
    public static boolean addComment(int id, String nama, String email, String komentar) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.addComment(id, nama, email, komentar);
    }
    
    public static ArrayList<Comment> listComment(int postId) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.listComment(postId);
    }
    
    public static Comment getComment(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.getComment(id);
    }
    
    public static boolean deleteComment(int id) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.deleteComment(id);
    }
    
    public static ArrayList<Post> search(String query) {
        SimpleBlog_Service service = new SimpleBlog_Service();
        SimpleBlog port = service.getSimpleBlogPort();
        return port.search(query);
    }
}
