import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Ahmad Zaky
 */
@WebService(serviceName = "simpleblog")
public interface SimpleBlogService {
    /* ===================== */
    /* KELOMPOK SERVICE POST */
    
    @WebMethod(operationName = "addPost")
    public boolean addPost(
            @WebParam(name = "judul") String judul,
            @WebParam(name = "konten") String konten,
            @WebParam(name = "tanggal") String tanggal,
            @WebParam(name = "statusPublikasi") Integer status);
    
    @WebMethod(operationName = "getPostById")
    public model.Post getPostById(
            @WebParam(name = "id") Integer id);
    
    @WebMethod(operationName = "listPost")
    public List<model.Post> listPost();
    
    @WebMethod(operationName = "updatePost")
    boolean updatePost(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "judul") String judul,
            @WebParam(name = "tanggal") String tanggal,
            @WebParam(name = "konten") String konten,
            @WebParam(name = "statusPublikasi") Integer status);
    
    @WebMethod(operationName = "deletePost")
    boolean deletePost(
            @WebParam(name = "id") Integer id );
    
    @WebMethod(operationName = "restorePost")
    boolean restorePost(
            @WebParam(name = "id") Integer id );
    
    @WebMethod(operationName = "permanentDeletePost")
    boolean permanentDeletePost(
            @WebParam(name = "id") Integer id );
    
    @WebMethod(operationName = "publishPost")
    boolean publishPost(
            @WebParam(name = "id") Integer id );
    
    @WebMethod(operationName = "unpublishPost")
    boolean unpublishPost(
            @WebParam(name = "id") Integer id );
    
    /* END OF KELOMPOK SERVICE POST */
    
    /* ===================== */
    /* KELOMPOK SERVICE USER */
    
    @WebMethod(operationName = "addUser")
    boolean addUser(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "email") String email,
            @WebParam(name = "role") String role);
    
    @WebMethod(operationName = "listUser")
    List<model.User> listUser();
    
    @WebMethod(operationName = "getUserById")
    model.User getUserById(
            @WebParam(name = "id") Integer id);
    
    @WebMethod(operationName = "getUserByUsername")
    model.User getUserByUsername(
            @WebParam(name = "username") String username);
    
    @WebMethod(operationName = "modifyUser")
    boolean modifyUser(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "email") String email,
            @WebParam(name = "role") String role);
    
    @WebMethod(operationName = "removeUser")
    boolean removeUser(
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
    List<model.Comment> listComment(
            @WebParam(name = "postid") Integer postId);
    
    /* END OF KELOMPOK SERVICE COMMENT */
    
    /* ======================= */
    /* KELOMPOK SERVICE SEARCH */
    
    @WebMethod(operationName = "search")
    List<model.Post> search(
            @WebParam(name = "query") String query);
    
    /* END OF KELOMPOK SERVICE SEARCH */
}
