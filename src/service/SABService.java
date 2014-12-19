
package service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SABService", targetNamespace = "http://Service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SABService {


    /**
     * 
     * @param username
     * @param email
     * @param role
     * @param nama
     * @param password
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://Service/", className = "service.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://Service/", className = "service.AddUserResponse")
    public Boolean addUser(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "role", targetNamespace = "")
        String role);

    /**
     * 
     * @return
     *     returns java.util.List<service.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listUser", targetNamespace = "http://Service/", className = "service.ListUser")
    @ResponseWrapper(localName = "listUserResponse", targetNamespace = "http://Service/", className = "service.ListUserResponse")
    public List<User> listUser();

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePost", targetNamespace = "http://Service/", className = "service.DeletePost")
    @ResponseWrapper(localName = "deletePostResponse", targetNamespace = "http://Service/", className = "service.DeletePostResponse")
    public Boolean deletePost(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param judul
     * @param id
     * @param konten
     * @param tanggal
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editPost", targetNamespace = "http://Service/", className = "service.EditPost")
    @ResponseWrapper(localName = "editPostResponse", targetNamespace = "http://Service/", className = "service.EditPostResponse")
    public Boolean editPost(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "konten", targetNamespace = "")
        String konten,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "publishPost", targetNamespace = "http://Service/", className = "service.PublishPost")
    @ResponseWrapper(localName = "publishPostResponse", targetNamespace = "http://Service/", className = "service.PublishPostResponse")
    public Boolean publishPost(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "softDeletePost", targetNamespace = "http://Service/", className = "service.SoftDeletePost")
    @ResponseWrapper(localName = "softDeletePostResponse", targetNamespace = "http://Service/", className = "service.SoftDeletePostResponse")
    public Boolean softDeletePost(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param postid
     * @return
     *     returns java.util.List<service.Comment>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listComment", targetNamespace = "http://Service/", className = "service.ListComment")
    @ResponseWrapper(localName = "listCommentResponse", targetNamespace = "http://Service/", className = "service.ListCommentResponse")
    public List<Comment> listComment(
        @WebParam(name = "postid", targetNamespace = "")
        String postid);

    /**
     * 
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listPost", targetNamespace = "http://Service/", className = "service.ListPost")
    @ResponseWrapper(localName = "listPostResponse", targetNamespace = "http://Service/", className = "service.ListPostResponse")
    public List<Post> listPost();

    /**
     * 
     * @param postid
     * @param email
     * @param konten
     * @param nama
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addComment", targetNamespace = "http://Service/", className = "service.AddComment")
    @ResponseWrapper(localName = "addCommentResponse", targetNamespace = "http://Service/", className = "service.AddCommentResponse")
    public Boolean addComment(
        @WebParam(name = "postid", targetNamespace = "")
        String postid,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "konten", targetNamespace = "")
        String konten);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://Service/", className = "service.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://Service/", className = "service.DeleteUserResponse")
    public Boolean deleteUser(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param id
     * @param email
     * @param role
     * @param nama
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editUser", targetNamespace = "http://Service/", className = "service.EditUser")
    @ResponseWrapper(localName = "editUserResponse", targetNamespace = "http://Service/", className = "service.EditUserResponse")
    public Boolean editUser(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "role", targetNamespace = "")
        String role);

    /**
     * 
     * @param judul
     * @param konten
     * @param tanggal
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPost", targetNamespace = "http://Service/", className = "service.AddPost")
    @ResponseWrapper(localName = "addPostResponse", targetNamespace = "http://Service/", className = "service.AddPostResponse")
    public Boolean addPost(
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal,
        @WebParam(name = "konten", targetNamespace = "")
        String konten);

}
