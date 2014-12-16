package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.Comment;
import model.Post;
import model.User;

/**
 *
 * @author Ahmad Zaky
 */
@WebService(serviceName = "simpleblog")
public interface SimpleBlogService {
    /* ===================== */
    /* KELOMPOK SERVICE POST */
    
    @WebMethod(operationName = "addPost")
    boolean addPost(
            @WebParam(name = "judul") String judul,
            @WebParam(name = "konten") String konten,
            @WebParam(name = "tanggal") String tanggal);
    
    @WebMethod(operationName = "listPost")
    List<Post> listPost();
    
    @WebMethod(operationName = "editPost")
    boolean listPost(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "judul") String judul,
            @WebParam(name = "konten") String konten,
            @WebParam(name = "tanggal") String tanggal);
    
    @WebMethod(operationName = "deletePost")
    boolean deletePost(
            @WebParam(name = "id") Integer id );
    
    @WebMethod(operationName = "publishPost")
    boolean publishPost(
            @WebParam(name = "id") Integer id );
    
    /* END OF KELOMPOK SERVICE POST */
    
    /* ===================== */
    /* KELOMPOK SERVICE USER */
    
    @WebMethod(operationName = "addUser")
    boolean addUser(
            @WebParam(name = "nama") String nama,
            @WebParam(name = "email") String email,
            @WebParam(name = "role") String role);
    
    @WebMethod(operationName = "listUser")
    List<User> listUser();
    
    @WebMethod(operationName = "editUser")
    boolean editUser(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "nama") String nama,
            @WebParam(name = "email") String email,
            @WebParam(name = "role") String role);
    
    @WebMethod(operationName = "deleteUser")
    boolean deleteUser(
            @WebParam(name = "id") Integer id);
    
    /* END OF KELOMPOK SERVICE USER */

    /* ======================== */
    /* KELOMPOK SERVICE COMMENT */
    
    @WebMethod(operationName = "addComment")
    boolean addComment(
            @WebParam(name = "postid") Integer postId,
            @WebParam(name = "nama") String nama,
            @WebParam(name = "email") String email,
            @WebParam(name = "konten") String konten);
    
    @WebMethod(operationName = "listComment")
    List<Comment> listComment();
    
    @WebMethod(operationName = "deleteComment")
    boolean deleteComment(
            @WebParam(name = "id") Integer id);
    
    /* END OF KELOMPOK SERVICE COMMENT */
    
    /* ======================= */
    /* KELOMPOK SERVICE SEARCH */
    
    @WebMethod(operationName = "search")
    List<Post> search(
            @WebParam(name = "query") String query);
    
    /* END OF KELOMPOK SERVICE SEARCH */
}
