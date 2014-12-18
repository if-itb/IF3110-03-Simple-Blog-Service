
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _AddPost_QNAME = new QName("http://service/", "addPost");
    private final static QName _LoadDeletedPost_QNAME = new QName("http://service/", "loadDeletedPost");
    private final static QName _RestorePostResponse_QNAME = new QName("http://service/", "restorePostResponse");
    private final static QName _EditPost_QNAME = new QName("http://service/", "editPost");
    private final static QName _LoadUserResponse_QNAME = new QName("http://service/", "loadUserResponse");
    private final static QName _AddComment_QNAME = new QName("http://service/", "addComment");
    private final static QName _LoadPublishedPostResponse_QNAME = new QName("http://service/", "loadPublishedPostResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://service/", "publishPostResponse");
    private final static QName _EditUserResponse_QNAME = new QName("http://service/", "editUserResponse");
    private final static QName _LoadPost_QNAME = new QName("http://service/", "loadPost");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service/", "deleteUserResponse");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service/", "deletePostResponse");
    private final static QName _SearchPostResponse_QNAME = new QName("http://service/", "searchPostResponse");
    private final static QName _LoadCommentResponse_QNAME = new QName("http://service/", "loadCommentResponse");
    private final static QName _LoadUnpublishedPostResponse_QNAME = new QName("http://service/", "loadUnpublishedPostResponse");
    private final static QName _AddUser_QNAME = new QName("http://service/", "addUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://service/", "addUserResponse");
    private final static QName _LoadPostResponse_QNAME = new QName("http://service/", "loadPostResponse");
    private final static QName _LoadUnpublishedPost_QNAME = new QName("http://service/", "loadUnpublishedPost");
    private final static QName _PublishPost_QNAME = new QName("http://service/", "publishPost");
    private final static QName _LoadDeletedPostResponse_QNAME = new QName("http://service/", "loadDeletedPostResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://service/", "deleteUser");
    private final static QName _Load_QNAME = new QName("http://service/", "load");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service/", "addCommentResponse");
    private final static QName _EditPostResponse_QNAME = new QName("http://service/", "editPostResponse");
    private final static QName _LoadUser_QNAME = new QName("http://service/", "loadUser");
    private final static QName _LoadPublishedPost_QNAME = new QName("http://service/", "loadPublishedPost");
    private final static QName _DeletePost_QNAME = new QName("http://service/", "deletePost");
    private final static QName _LoadComment_QNAME = new QName("http://service/", "loadComment");
    private final static QName _SearchPost_QNAME = new QName("http://service/", "searchPost");
    private final static QName _LoadResponse_QNAME = new QName("http://service/", "loadResponse");
    private final static QName _RestorePost_QNAME = new QName("http://service/", "restorePost");
    private final static QName _AddPostResponse_QNAME = new QName("http://service/", "addPostResponse");
    private final static QName _EditUser_QNAME = new QName("http://service/", "editUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadDeletedPostResponse }
     * 
     */
    public LoadDeletedPostResponse createLoadDeletedPostResponse() {
        return new LoadDeletedPostResponse();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
    }

    /**
     * Create an instance of {@link LoadUnpublishedPost }
     * 
     */
    public LoadUnpublishedPost createLoadUnpublishedPost() {
        return new LoadUnpublishedPost();
    }

    /**
     * Create an instance of {@link LoadPostResponse }
     * 
     */
    public LoadPostResponse createLoadPostResponse() {
        return new LoadPostResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link LoadUnpublishedPostResponse }
     * 
     */
    public LoadUnpublishedPostResponse createLoadUnpublishedPostResponse() {
        return new LoadUnpublishedPostResponse();
    }

    /**
     * Create an instance of {@link LoadCommentResponse }
     * 
     */
    public LoadCommentResponse createLoadCommentResponse() {
        return new LoadCommentResponse();
    }

    /**
     * Create an instance of {@link SearchPostResponse }
     * 
     */
    public SearchPostResponse createSearchPostResponse() {
        return new SearchPostResponse();
    }

    /**
     * Create an instance of {@link DeletePostResponse }
     * 
     */
    public DeletePostResponse createDeletePostResponse() {
        return new DeletePostResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link LoadPost }
     * 
     */
    public LoadPost createLoadPost() {
        return new LoadPost();
    }

    /**
     * Create an instance of {@link EditUserResponse }
     * 
     */
    public EditUserResponse createEditUserResponse() {
        return new EditUserResponse();
    }

    /**
     * Create an instance of {@link PublishPostResponse }
     * 
     */
    public PublishPostResponse createPublishPostResponse() {
        return new PublishPostResponse();
    }

    /**
     * Create an instance of {@link LoadPublishedPostResponse }
     * 
     */
    public LoadPublishedPostResponse createLoadPublishedPostResponse() {
        return new LoadPublishedPostResponse();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link LoadUserResponse }
     * 
     */
    public LoadUserResponse createLoadUserResponse() {
        return new LoadUserResponse();
    }

    /**
     * Create an instance of {@link EditPost }
     * 
     */
    public EditPost createEditPost() {
        return new EditPost();
    }

    /**
     * Create an instance of {@link RestorePostResponse }
     * 
     */
    public RestorePostResponse createRestorePostResponse() {
        return new RestorePostResponse();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link LoadDeletedPost }
     * 
     */
    public LoadDeletedPost createLoadDeletedPost() {
        return new LoadDeletedPost();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link EditUser }
     * 
     */
    public EditUser createEditUser() {
        return new EditUser();
    }

    /**
     * Create an instance of {@link RestorePost }
     * 
     */
    public RestorePost createRestorePost() {
        return new RestorePost();
    }

    /**
     * Create an instance of {@link LoadResponse }
     * 
     */
    public LoadResponse createLoadResponse() {
        return new LoadResponse();
    }

    /**
     * Create an instance of {@link SearchPost }
     * 
     */
    public SearchPost createSearchPost() {
        return new SearchPost();
    }

    /**
     * Create an instance of {@link LoadComment }
     * 
     */
    public LoadComment createLoadComment() {
        return new LoadComment();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link LoadPublishedPost }
     * 
     */
    public LoadPublishedPost createLoadPublishedPost() {
        return new LoadPublishedPost();
    }

    /**
     * Create an instance of {@link LoadUser }
     * 
     */
    public LoadUser createLoadUser() {
        return new LoadUser();
    }

    /**
     * Create an instance of {@link EditPostResponse }
     * 
     */
    public EditPostResponse createEditPostResponse() {
        return new EditPostResponse();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link Load }
     * 
     */
    public Load createLoad() {
        return new Load();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link Post }
     * 
     */
    public Post createPost() {
        return new Post();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDeletedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadDeletedPost")
    public JAXBElement<LoadDeletedPost> createLoadDeletedPost(LoadDeletedPost value) {
        return new JAXBElement<LoadDeletedPost>(_LoadDeletedPost_QNAME, LoadDeletedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "restorePostResponse")
    public JAXBElement<RestorePostResponse> createRestorePostResponse(RestorePostResponse value) {
        return new JAXBElement<RestorePostResponse>(_RestorePostResponse_QNAME, RestorePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadUserResponse")
    public JAXBElement<LoadUserResponse> createLoadUserResponse(LoadUserResponse value) {
        return new JAXBElement<LoadUserResponse>(_LoadUserResponse_QNAME, LoadUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadPublishedPostResponse")
    public JAXBElement<LoadPublishedPostResponse> createLoadPublishedPostResponse(LoadPublishedPostResponse value) {
        return new JAXBElement<LoadPublishedPostResponse>(_LoadPublishedPostResponse_QNAME, LoadPublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadPost")
    public JAXBElement<LoadPost> createLoadPost(LoadPost value) {
        return new JAXBElement<LoadPost>(_LoadPost_QNAME, LoadPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchPostResponse")
    public JAXBElement<SearchPostResponse> createSearchPostResponse(SearchPostResponse value) {
        return new JAXBElement<SearchPostResponse>(_SearchPostResponse_QNAME, SearchPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadCommentResponse")
    public JAXBElement<LoadCommentResponse> createLoadCommentResponse(LoadCommentResponse value) {
        return new JAXBElement<LoadCommentResponse>(_LoadCommentResponse_QNAME, LoadCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUnpublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadUnpublishedPostResponse")
    public JAXBElement<LoadUnpublishedPostResponse> createLoadUnpublishedPostResponse(LoadUnpublishedPostResponse value) {
        return new JAXBElement<LoadUnpublishedPostResponse>(_LoadUnpublishedPostResponse_QNAME, LoadUnpublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadPostResponse")
    public JAXBElement<LoadPostResponse> createLoadPostResponse(LoadPostResponse value) {
        return new JAXBElement<LoadPostResponse>(_LoadPostResponse_QNAME, LoadPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUnpublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadUnpublishedPost")
    public JAXBElement<LoadUnpublishedPost> createLoadUnpublishedPost(LoadUnpublishedPost value) {
        return new JAXBElement<LoadUnpublishedPost>(_LoadUnpublishedPost_QNAME, LoadUnpublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDeletedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadDeletedPostResponse")
    public JAXBElement<LoadDeletedPostResponse> createLoadDeletedPostResponse(LoadDeletedPostResponse value) {
        return new JAXBElement<LoadDeletedPostResponse>(_LoadDeletedPostResponse_QNAME, LoadDeletedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Load }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "load")
    public JAXBElement<Load> createLoad(Load value) {
        return new JAXBElement<Load>(_Load_QNAME, Load.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadUser")
    public JAXBElement<LoadUser> createLoadUser(LoadUser value) {
        return new JAXBElement<LoadUser>(_LoadUser_QNAME, LoadUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadPublishedPost")
    public JAXBElement<LoadPublishedPost> createLoadPublishedPost(LoadPublishedPost value) {
        return new JAXBElement<LoadPublishedPost>(_LoadPublishedPost_QNAME, LoadPublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadComment")
    public JAXBElement<LoadComment> createLoadComment(LoadComment value) {
        return new JAXBElement<LoadComment>(_LoadComment_QNAME, LoadComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchPost")
    public JAXBElement<SearchPost> createSearchPost(SearchPost value) {
        return new JAXBElement<SearchPost>(_SearchPost_QNAME, SearchPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loadResponse")
    public JAXBElement<LoadResponse> createLoadResponse(LoadResponse value) {
        return new JAXBElement<LoadResponse>(_LoadResponse_QNAME, LoadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "restorePost")
    public JAXBElement<RestorePost> createRestorePost(RestorePost value) {
        return new JAXBElement<RestorePost>(_RestorePost_QNAME, RestorePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

}
