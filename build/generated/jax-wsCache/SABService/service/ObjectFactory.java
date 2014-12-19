
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

    private final static QName _EditPostResponse_QNAME = new QName("http://Service/", "editPostResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://Service/", "deleteUser");
    private final static QName _AddCommentResponse_QNAME = new QName("http://Service/", "addCommentResponse");
    private final static QName _ListUserResponse_QNAME = new QName("http://Service/", "listUserResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://Service/", "loginResponse");
    private final static QName _GetUser_QNAME = new QName("http://Service/", "getUser");
    private final static QName _SearchPost_QNAME = new QName("http://Service/", "searchPost");
    private final static QName _SoftDeletePost_QNAME = new QName("http://Service/", "softDeletePost");
    private final static QName _AddPostResponse_QNAME = new QName("http://Service/", "addPostResponse");
    private final static QName _EditUser_QNAME = new QName("http://Service/", "editUser");
    private final static QName _GetPost_QNAME = new QName("http://Service/", "getPost");
    private final static QName _ListCommentResponse_QNAME = new QName("http://Service/", "listCommentResponse");
    private final static QName _DeletePost_QNAME = new QName("http://Service/", "deletePost");
    private final static QName _SoftDeletePostResponse_QNAME = new QName("http://Service/", "softDeletePostResponse");
    private final static QName _GetPostResponse_QNAME = new QName("http://Service/", "getPostResponse");
    private final static QName _AddComment_QNAME = new QName("http://Service/", "addComment");
    private final static QName _EditUserResponse_QNAME = new QName("http://Service/", "editUserResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://Service/", "publishPostResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://Service/", "deleteUserResponse");
    private final static QName _AddPost_QNAME = new QName("http://Service/", "addPost");
    private final static QName _EditPost_QNAME = new QName("http://Service/", "editPost");
    private final static QName _GetUserResponse_QNAME = new QName("http://Service/", "getUserResponse");
    private final static QName _Login_QNAME = new QName("http://Service/", "login");
    private final static QName _ListPost_QNAME = new QName("http://Service/", "listPost");
    private final static QName _AddUserResponse_QNAME = new QName("http://Service/", "addUserResponse");
    private final static QName _PublishPost_QNAME = new QName("http://Service/", "publishPost");
    private final static QName _ListUser_QNAME = new QName("http://Service/", "listUser");
    private final static QName _ListComment_QNAME = new QName("http://Service/", "listComment");
    private final static QName _DeletePostResponse_QNAME = new QName("http://Service/", "deletePostResponse");
    private final static QName _SearchPostResponse_QNAME = new QName("http://Service/", "searchPostResponse");
    private final static QName _ListPostResponse_QNAME = new QName("http://Service/", "listPostResponse");
    private final static QName _AddUser_QNAME = new QName("http://Service/", "addUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListComment }
     * 
     */
    public ListComment createListComment() {
        return new ListComment();
    }

    /**
     * Create an instance of {@link ListUser }
     * 
     */
    public ListUser createListUser() {
        return new ListUser();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
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
     * Create an instance of {@link ListPostResponse }
     * 
     */
    public ListPostResponse createListPostResponse() {
        return new ListPostResponse();
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
     * Create an instance of {@link GetPostResponse }
     * 
     */
    public GetPostResponse createGetPostResponse() {
        return new GetPostResponse();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link ListPost }
     * 
     */
    public ListPost createListPost() {
        return new ListPost();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link EditPost }
     * 
     */
    public EditPost createEditPost() {
        return new EditPost();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link SoftDeletePost }
     * 
     */
    public SoftDeletePost createSoftDeletePost() {
        return new SoftDeletePost();
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
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link SearchPost }
     * 
     */
    public SearchPost createSearchPost() {
        return new SearchPost();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link SoftDeletePostResponse }
     * 
     */
    public SoftDeletePostResponse createSoftDeletePostResponse() {
        return new SoftDeletePostResponse();
    }

    /**
     * Create an instance of {@link ListCommentResponse }
     * 
     */
    public ListCommentResponse createListCommentResponse() {
        return new ListCommentResponse();
    }

    /**
     * Create an instance of {@link GetPost }
     * 
     */
    public GetPost createGetPost() {
        return new GetPost();
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
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "searchPost")
    public JAXBElement<SearchPost> createSearchPost(SearchPost value) {
        return new JAXBElement<SearchPost>(_SearchPost_QNAME, SearchPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftDeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "softDeletePost")
    public JAXBElement<SoftDeletePost> createSoftDeletePost(SoftDeletePost value) {
        return new JAXBElement<SoftDeletePost>(_SoftDeletePost_QNAME, SoftDeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftDeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "softDeletePostResponse")
    public JAXBElement<SoftDeletePostResponse> createSoftDeletePostResponse(SoftDeletePostResponse value) {
        return new JAXBElement<SoftDeletePostResponse>(_SoftDeletePostResponse_QNAME, SoftDeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listPost")
    public JAXBElement<ListPost> createListPost(ListPost value) {
        return new JAXBElement<ListPost>(_ListPost_QNAME, ListPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "searchPostResponse")
    public JAXBElement<SearchPostResponse> createSearchPostResponse(SearchPostResponse value) {
        return new JAXBElement<SearchPostResponse>(_SearchPostResponse_QNAME, SearchPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listPostResponse")
    public JAXBElement<ListPostResponse> createListPostResponse(ListPostResponse value) {
        return new JAXBElement<ListPostResponse>(_ListPostResponse_QNAME, ListPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

}
