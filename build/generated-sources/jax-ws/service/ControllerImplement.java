
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
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ControllerImplement", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControllerImplement {


    /**
     * 
     * @param username
     * @param email
     * @param role
     * @param password
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://service/", className = "service.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://service/", className = "service.AddUserResponse")
    public Boolean addUser(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "role", targetNamespace = "")
        String role);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "restorePost", targetNamespace = "http://service/", className = "service.RestorePost")
    @ResponseWrapper(localName = "restorePostResponse", targetNamespace = "http://service/", className = "service.RestorePostResponse")
    public Boolean restorePost(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadUnpublishedPost", targetNamespace = "http://service/", className = "service.LoadUnpublishedPost")
    @ResponseWrapper(localName = "loadUnpublishedPostResponse", targetNamespace = "http://service/", className = "service.LoadUnpublishedPostResponse")
    public List<Post> loadUnpublishedPost();

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePost", targetNamespace = "http://service/", className = "service.DeletePost")
    @ResponseWrapper(localName = "deletePostResponse", targetNamespace = "http://service/", className = "service.DeletePostResponse")
    public Boolean deletePost(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param key
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchPost", targetNamespace = "http://service/", className = "service.SearchPost")
    @ResponseWrapper(localName = "searchPostResponse", targetNamespace = "http://service/", className = "service.SearchPostResponse")
    public List<Post> searchPost(
        @WebParam(name = "key", targetNamespace = "")
        String key);

    /**
     * 
     * @param postid
     * @return
     *     returns java.util.List<service.Comment>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadComment", targetNamespace = "http://service/", className = "service.LoadComment")
    @ResponseWrapper(localName = "loadCommentResponse", targetNamespace = "http://service/", className = "service.LoadCommentResponse")
    public List<Comment> loadComment(
        @WebParam(name = "postid", targetNamespace = "")
        String postid);

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
    @RequestWrapper(localName = "addPost", targetNamespace = "http://service/", className = "service.AddPost")
    @ResponseWrapper(localName = "addPostResponse", targetNamespace = "http://service/", className = "service.AddPostResponse")
    public Boolean addPost(
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal,
        @WebParam(name = "konten", targetNamespace = "")
        String konten);

    /**
     * 
     * @param id
     * @param username
     * @param email
     * @param role
     * @param password
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editUser", targetNamespace = "http://service/", className = "service.EditUser")
    @ResponseWrapper(localName = "editUserResponse", targetNamespace = "http://service/", className = "service.EditUserResponse")
    public Boolean editUser(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "role", targetNamespace = "")
        String role);

    /**
     * 
     * @param urlstring
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "load", targetNamespace = "http://service/", className = "service.Load")
    @ResponseWrapper(localName = "loadResponse", targetNamespace = "http://service/", className = "service.LoadResponse")
    public String load(
        @WebParam(name = "urlstring", targetNamespace = "")
        String urlstring);

    /**
     * 
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadDeletedPost", targetNamespace = "http://service/", className = "service.LoadDeletedPost")
    @ResponseWrapper(localName = "loadDeletedPostResponse", targetNamespace = "http://service/", className = "service.LoadDeletedPostResponse")
    public List<Post> loadDeletedPost();

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "publishPost", targetNamespace = "http://service/", className = "service.PublishPost")
    @ResponseWrapper(localName = "publishPostResponse", targetNamespace = "http://service/", className = "service.PublishPostResponse")
    public Boolean publishPost(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadPublishedPost", targetNamespace = "http://service/", className = "service.LoadPublishedPost")
    @ResponseWrapper(localName = "loadPublishedPostResponse", targetNamespace = "http://service/", className = "service.LoadPublishedPostResponse")
    public List<Post> loadPublishedPost();

    /**
     * 
     * @return
     *     returns java.util.List<service.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadUser", targetNamespace = "http://service/", className = "service.LoadUser")
    @ResponseWrapper(localName = "loadUserResponse", targetNamespace = "http://service/", className = "service.LoadUserResponse")
    public List<User> loadUser();

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
    @RequestWrapper(localName = "editPost", targetNamespace = "http://service/", className = "service.EditPost")
    @ResponseWrapper(localName = "editPostResponse", targetNamespace = "http://service/", className = "service.EditPostResponse")
    public Boolean editPost(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal,
        @WebParam(name = "konten", targetNamespace = "")
        String konten);

    /**
     * 
     * @param postid
     * @param email
     * @param komentar
     * @param nama
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addComment", targetNamespace = "http://service/", className = "service.AddComment")
    @ResponseWrapper(localName = "addCommentResponse", targetNamespace = "http://service/", className = "service.AddCommentResponse")
    public Boolean addComment(
        @WebParam(name = "postid", targetNamespace = "")
        String postid,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "komentar", targetNamespace = "")
        String komentar);

    /**
     * 
     * @param id
     * @return
     *     returns service.Post
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadPost", targetNamespace = "http://service/", className = "service.LoadPost")
    @ResponseWrapper(localName = "loadPostResponse", targetNamespace = "http://service/", className = "service.LoadPostResponse")
    public Post loadPost(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://service/", className = "service.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://service/", className = "service.DeleteUserResponse")
    public Boolean deleteUser(
        @WebParam(name = "id", targetNamespace = "")
        String id);

}
