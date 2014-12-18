
package org.chamerling.heroku.service;

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
@WebService(name = "HelloService", targetNamespace = "http://service.heroku.chamerling.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.chamerling.heroku.service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchPost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.SearchPost")
    @ResponseWrapper(localName = "searchPostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.SearchPostResponse")
    public List<Post> searchPost(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.chamerling.heroku.service.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listUser", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListUser")
    @ResponseWrapper(localName = "listUserResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListUserResponse")
    public List<User> listUser();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addComment", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddComment")
    @ResponseWrapper(localName = "addCommentResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddCommentResponse")
    public boolean addComment(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @return
     *     returns java.util.List<org.chamerling.heroku.service.Post>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listPost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListPost")
    @ResponseWrapper(localName = "listPostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListPostResponse")
    public List<Post> listPost();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddPost")
    @ResponseWrapper(localName = "addPostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddPostResponse")
    public boolean addPost(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeleteUserResponse")
    public boolean deleteUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteComment", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeleteComment")
    @ResponseWrapper(localName = "deleteCommentResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeleteCommentResponse")
    public boolean deleteComment(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editPost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.EditPost")
    @ResponseWrapper(localName = "editPostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.EditPostResponse")
    public boolean editPost(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @return
     *     returns java.util.List<org.chamerling.heroku.service.Comment>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listComment", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListComment")
    @ResponseWrapper(localName = "listCommentResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.ListCommentResponse")
    public List<Comment> listComment();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editUser", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.EditUser")
    @ResponseWrapper(localName = "editUserResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.EditUserResponse")
    public boolean editUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "publishPost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.PublishPost")
    @ResponseWrapper(localName = "publishPostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.PublishPostResponse")
    public boolean publishPost(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.AddUserResponse")
    public boolean addUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePost", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeletePost")
    @ResponseWrapper(localName = "deletePostResponse", targetNamespace = "http://service.heroku.chamerling.org/", className = "org.chamerling.heroku.service.DeletePostResponse")
    public boolean deletePost(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
