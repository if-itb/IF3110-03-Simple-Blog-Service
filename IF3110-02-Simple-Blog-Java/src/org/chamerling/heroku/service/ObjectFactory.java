
package org.chamerling.heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.chamerling.heroku.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddComment_QNAME = new QName("http://service.heroku.chamerling.org/", "addComment");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "updateUserResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "deleteUserResponse");
    private final static QName _EditPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "editPostResponse");
    private final static QName _GetAllCommentarResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllCommentarResponse");
    private final static QName _EditPost_QNAME = new QName("http://service.heroku.chamerling.org/", "editPost");
    private final static QName _GetAllCommentar_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllCommentar");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllUserResponse");
    private final static QName _ReadUrl_QNAME = new QName("http://service.heroku.chamerling.org/", "readUrl");
    private final static QName _InterruptedException_QNAME = new QName("http://service.heroku.chamerling.org/", "InterruptedException");
    private final static QName _AddPost_QNAME = new QName("http://service.heroku.chamerling.org/", "addPost");
    private final static QName _UpdateUser_QNAME = new QName("http://service.heroku.chamerling.org/", "updateUser");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addCommentResponse");
    private final static QName _ReadUrlResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "readUrlResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://service.heroku.chamerling.org/", "deleteUser");
    private final static QName _GetAllUser_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addUserResponse");
    private final static QName _GetAllPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllPostResponse");
    private final static QName _Exception_QNAME = new QName("http://service.heroku.chamerling.org/", "Exception");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addPostResponse");
    private final static QName _GetAllPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllPost");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "deletePostResponse");
    private final static QName _DeletePost_QNAME = new QName("http://service.heroku.chamerling.org/", "deletePost");
    private final static QName _AddUser_QNAME = new QName("http://service.heroku.chamerling.org/", "addUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.chamerling.heroku.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link GetAllPost }
     * 
     */
    public GetAllPost createGetAllPost() {
        return new GetAllPost();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link GetAllPostResponse }
     * 
     */
    public GetAllPostResponse createGetAllPostResponse() {
        return new GetAllPostResponse();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link DeletePostResponse }
     * 
     */
    public DeletePostResponse createDeletePostResponse() {
        return new DeletePostResponse();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link GetAllCommentarResponse }
     * 
     */
    public GetAllCommentarResponse createGetAllCommentarResponse() {
        return new GetAllCommentarResponse();
    }

    /**
     * Create an instance of {@link EditPostResponse }
     * 
     */
    public EditPostResponse createEditPostResponse() {
        return new EditPostResponse();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link ReadUrlResponse }
     * 
     */
    public ReadUrlResponse createReadUrlResponse() {
        return new ReadUrlResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link EditPost }
     * 
     */
    public EditPost createEditPost() {
        return new EditPost();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link GetAllCommentar }
     * 
     */
    public GetAllCommentar createGetAllCommentar() {
        return new GetAllCommentar();
    }

    /**
     * Create an instance of {@link InterruptedException }
     * 
     */
    public InterruptedException createInterruptedException() {
        return new InterruptedException();
    }

    /**
     * Create an instance of {@link ReadUrl }
     * 
     */
    public ReadUrl createReadUrl() {
        return new ReadUrl();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Komentar }
     * 
     */
    public Komentar createKomentar() {
        return new Komentar();
    }

    /**
     * Create an instance of {@link Post }
     * 
     */
    public Post createPost() {
        return new Post();
    }

    /**
     * Create an instance of {@link DataUser }
     * 
     */
    public DataUser createDataUser() {
        return new DataUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCommentarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllCommentarResponse")
    public JAXBElement<GetAllCommentarResponse> createGetAllCommentarResponse(GetAllCommentarResponse value) {
        return new JAXBElement<GetAllCommentarResponse>(_GetAllCommentarResponse_QNAME, GetAllCommentarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCommentar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllCommentar")
    public JAXBElement<GetAllCommentar> createGetAllCommentar(GetAllCommentar value) {
        return new JAXBElement<GetAllCommentar>(_GetAllCommentar_QNAME, GetAllCommentar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllUserResponse")
    public JAXBElement<GetAllUserResponse> createGetAllUserResponse(GetAllUserResponse value) {
        return new JAXBElement<GetAllUserResponse>(_GetAllUserResponse_QNAME, GetAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "readUrl")
    public JAXBElement<ReadUrl> createReadUrl(ReadUrl value) {
        return new JAXBElement<ReadUrl>(_ReadUrl_QNAME, ReadUrl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterruptedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "InterruptedException")
    public JAXBElement<InterruptedException> createInterruptedException(InterruptedException value) {
        return new JAXBElement<InterruptedException>(_InterruptedException_QNAME, InterruptedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "readUrlResponse")
    public JAXBElement<ReadUrlResponse> createReadUrlResponse(ReadUrlResponse value) {
        return new JAXBElement<ReadUrlResponse>(_ReadUrlResponse_QNAME, ReadUrlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllUser")
    public JAXBElement<GetAllUser> createGetAllUser(GetAllUser value) {
        return new JAXBElement<GetAllUser>(_GetAllUser_QNAME, GetAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllPostResponse")
    public JAXBElement<GetAllPostResponse> createGetAllPostResponse(GetAllPostResponse value) {
        return new JAXBElement<GetAllPostResponse>(_GetAllPostResponse_QNAME, GetAllPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllPost")
    public JAXBElement<GetAllPost> createGetAllPost(GetAllPost value) {
        return new JAXBElement<GetAllPost>(_GetAllPost_QNAME, GetAllPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

}
