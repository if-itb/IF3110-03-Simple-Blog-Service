
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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SimpleBlogService", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SimpleBlogService {


    /**
     * 
     * @param id
     * @return
     *     returns service.Post
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPostById", targetNamespace = "http://services/", className = "service.GetPostById")
    @ResponseWrapper(localName = "getPostByIdResponse", targetNamespace = "http://services/", className = "service.GetPostByIdResponse")
    public Post getPostById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param postid
     * @return
     *     returns java.util.List<service.Comment>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listComment", targetNamespace = "http://services/", className = "service.ListComment")
    @ResponseWrapper(localName = "listCommentResponse", targetNamespace = "http://services/", className = "service.ListCommentResponse")
    public List<Comment> listComment(
        @WebParam(name = "postid", targetNamespace = "")
        Integer postid);

    /**
     * 
     * @return
     *     returns java.util.List<service.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listUser", targetNamespace = "http://services/", className = "service.ListUser")
    @ResponseWrapper(localName = "listUserResponse", targetNamespace = "http://services/", className = "service.ListUserResponse")
    public List<User> listUser();

    /**
     * 
     * @param nama
     * @param konten
     * @param postid
     * @param email
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addComment", targetNamespace = "http://services/", className = "service.AddComment")
    @ResponseWrapper(localName = "addCommentResponse", targetNamespace = "http://services/", className = "service.AddCommentResponse")
    public boolean addComment(
        @WebParam(name = "postid", targetNamespace = "")
        Integer postid,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "konten", targetNamespace = "")
        String konten);

    /**
     * 
     * @param query
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "search", targetNamespace = "http://services/", className = "service.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://services/", className = "service.SearchResponse")
    public List<Post> search(
        @WebParam(name = "query", targetNamespace = "")
        String query);

    /**
     * 
     * @param konten
     * @param statusPublikasi
     * @param id
     * @param tanggal
     * @param judul
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatePost", targetNamespace = "http://services/", className = "service.UpdatePost")
    @ResponseWrapper(localName = "updatePostResponse", targetNamespace = "http://services/", className = "service.UpdatePostResponse")
    public boolean updatePost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal,
        @WebParam(name = "konten", targetNamespace = "")
        String konten,
        @WebParam(name = "statusPublikasi", targetNamespace = "")
        Integer statusPublikasi);

    /**
     * 
     * @param password
     * @param role
     * @param id
     * @param email
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modifyUser", targetNamespace = "http://services/", className = "service.ModifyUser")
    @ResponseWrapper(localName = "modifyUserResponse", targetNamespace = "http://services/", className = "service.ModifyUserResponse")
    public boolean modifyUser(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
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
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "permanentDeletePost", targetNamespace = "http://services/", className = "service.PermanentDeletePost")
    @ResponseWrapper(localName = "permanentDeletePostResponse", targetNamespace = "http://services/", className = "service.PermanentDeletePostResponse")
    public boolean permanentDeletePost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "publishPost", targetNamespace = "http://services/", className = "service.PublishPost")
    @ResponseWrapper(localName = "publishPostResponse", targetNamespace = "http://services/", className = "service.PublishPostResponse")
    public boolean publishPost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeUser", targetNamespace = "http://services/", className = "service.RemoveUser")
    @ResponseWrapper(localName = "removeUserResponse", targetNamespace = "http://services/", className = "service.RemoveUserResponse")
    public boolean removeUser(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param konten
     * @param statusPublikasi
     * @param tanggal
     * @param judul
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPost", targetNamespace = "http://services/", className = "service.AddPost")
    @ResponseWrapper(localName = "addPostResponse", targetNamespace = "http://services/", className = "service.AddPostResponse")
    public boolean addPost(
        @WebParam(name = "judul", targetNamespace = "")
        String judul,
        @WebParam(name = "konten", targetNamespace = "")
        String konten,
        @WebParam(name = "tanggal", targetNamespace = "")
        String tanggal,
        @WebParam(name = "statusPublikasi", targetNamespace = "")
        Integer statusPublikasi);

    /**
     * 
     * @return
     *     returns java.util.List<service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listPost", targetNamespace = "http://services/", className = "service.ListPost")
    @ResponseWrapper(localName = "listPostResponse", targetNamespace = "http://services/", className = "service.ListPostResponse")
    public List<Post> listPost();

    /**
     * 
     * @param id
     * @return
     *     returns service.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://services/", className = "service.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://services/", className = "service.GetUserByIdResponse")
    public User getUserById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePost", targetNamespace = "http://services/", className = "service.DeletePost")
    @ResponseWrapper(localName = "deletePostResponse", targetNamespace = "http://services/", className = "service.DeletePostResponse")
    public boolean deletePost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param password
     * @param role
     * @param email
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://services/", className = "service.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://services/", className = "service.AddUserResponse")
    public boolean addUser(
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
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "restorePost", targetNamespace = "http://services/", className = "service.RestorePost")
    @ResponseWrapper(localName = "restorePostResponse", targetNamespace = "http://services/", className = "service.RestorePostResponse")
    public boolean restorePost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param username
     * @return
     *     returns service.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserByUsername", targetNamespace = "http://services/", className = "service.GetUserByUsername")
    @ResponseWrapper(localName = "getUserByUsernameResponse", targetNamespace = "http://services/", className = "service.GetUserByUsernameResponse")
    public User getUserByUsername(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "unpublishPost", targetNamespace = "http://services/", className = "service.UnpublishPost")
    @ResponseWrapper(localName = "unpublishPostResponse", targetNamespace = "http://services/", className = "service.UnpublishPostResponse")
    public boolean unpublishPost(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

}
