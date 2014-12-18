
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

    private final static QName _AddPost_QNAME = new QName("http://Service/", "addPost");
    private final static QName _GetemailResponse_QNAME = new QName("http://Service/", "getemailResponse");
    private final static QName _ListPost_QNAME = new QName("http://Service/", "listPost");
    private final static QName _ListUserResponse_QNAME = new QName("http://Service/", "listUserResponse");
    private final static QName _Exception_QNAME = new QName("http://Service/", "Exception");
    private final static QName _GetAuthorPostResponse_QNAME = new QName("http://Service/", "getAuthorPostResponse");
    private final static QName _GetUserRole_QNAME = new QName("http://Service/", "getUserRole");
    private final static QName _LoginResponse_QNAME = new QName("http://Service/", "loginResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://Service/", "addCommentResponse");
    private final static QName _Getemail_QNAME = new QName("http://Service/", "getemail");
    private final static QName _PostResults_QNAME = new QName("http://Service/", "postResults");
    private final static QName _DeleteUser_QNAME = new QName("http://Service/", "deleteUser");
    private final static QName _ListPostResponse_QNAME = new QName("http://Service/", "listPostResponse");
    private final static QName _ListCommentResponse_QNAME = new QName("http://Service/", "listCommentResponse");
    private final static QName _EditPostResponse_QNAME = new QName("http://Service/", "editPostResponse");
    private final static QName _ListUser_QNAME = new QName("http://Service/", "listUser");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://Service/", "deleteUserResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://Service/", "addPostResponse");
    private final static QName _EditPost_QNAME = new QName("http://Service/", "editPost");
    private final static QName _DeleteRealPost_QNAME = new QName("http://Service/", "deleteRealPost");
    private final static QName _GetUserRoleResponse_QNAME = new QName("http://Service/", "getUserRoleResponse");
    private final static QName _ChangeStatusPostResponse_QNAME = new QName("http://Service/", "ChangeStatusPostResponse");
    private final static QName _SearchResponse_QNAME = new QName("http://Service/", "searchResponse");
    private final static QName _Checkuserexist_QNAME = new QName("http://Service/", "checkuserexist");
    private final static QName _EditUser_QNAME = new QName("http://Service/", "editUser");
    private final static QName _PostResultsResponse_QNAME = new QName("http://Service/", "postResultsResponse");
    private final static QName _Getnama_QNAME = new QName("http://Service/", "getnama");
    private final static QName _Login_QNAME = new QName("http://Service/", "login");
    private final static QName _CheckuserexistResponse_QNAME = new QName("http://Service/", "checkuserexistResponse");
    private final static QName _DeletePost_QNAME = new QName("http://Service/", "deletePost");
    private final static QName _EditUserResponse_QNAME = new QName("http://Service/", "editUserResponse");
    private final static QName _GetAuthorPost_QNAME = new QName("http://Service/", "getAuthorPost");
    private final static QName _DeletePostResponse_QNAME = new QName("http://Service/", "deletePostResponse");
    private final static QName _AddUser_QNAME = new QName("http://Service/", "addUser");
    private final static QName _DeleteRealPostResponse_QNAME = new QName("http://Service/", "deleteRealPostResponse");
    private final static QName _AddComment_QNAME = new QName("http://Service/", "addComment");
    private final static QName _AddUserResponse_QNAME = new QName("http://Service/", "addUserResponse");
    private final static QName _ListComment_QNAME = new QName("http://Service/", "listComment");
    private final static QName _GetPostResponse_QNAME = new QName("http://Service/", "getPostResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://Service/", "publishPostResponse");
    private final static QName _ChangeStatusPost_QNAME = new QName("http://Service/", "ChangeStatusPost");
    private final static QName _GetPost_QNAME = new QName("http://Service/", "getPost");
    private final static QName _Search_QNAME = new QName("http://Service/", "search");
    private final static QName _PublishPost_QNAME = new QName("http://Service/", "publishPost");
    private final static QName _GetnamaResponse_QNAME = new QName("http://Service/", "getnamaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckuserexistResponse }
     * 
     */
    public CheckuserexistResponse createCheckuserexistResponse() {
        return new CheckuserexistResponse();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link EditUserResponse }
     * 
     */
    public EditUserResponse createEditUserResponse() {
        return new EditUserResponse();
    }

    /**
     * Create an instance of {@link GetAuthorPost }
     * 
     */
    public GetAuthorPost createGetAuthorPost() {
        return new GetAuthorPost();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link DeleteRealPostResponse }
     * 
     */
    public DeleteRealPostResponse createDeleteRealPostResponse() {
        return new DeleteRealPostResponse();
    }

    /**
     * Create an instance of {@link DeletePostResponse }
     * 
     */
    public DeletePostResponse createDeletePostResponse() {
        return new DeletePostResponse();
    }

    /**
     * Create an instance of {@link Checkuserexist }
     * 
     */
    public Checkuserexist createCheckuserexist() {
        return new Checkuserexist();
    }

    /**
     * Create an instance of {@link EditUser }
     * 
     */
    public EditUser createEditUser() {
        return new EditUser();
    }

    /**
     * Create an instance of {@link Getnama }
     * 
     */
    public Getnama createGetnama() {
        return new Getnama();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link PostResultsResponse }
     * 
     */
    public PostResultsResponse createPostResultsResponse() {
        return new PostResultsResponse();
    }

    /**
     * Create an instance of {@link ChangeStatusPost }
     * 
     */
    public ChangeStatusPost createChangeStatusPost() {
        return new ChangeStatusPost();
    }

    /**
     * Create an instance of {@link GetPostResponse }
     * 
     */
    public GetPostResponse createGetPostResponse() {
        return new GetPostResponse();
    }

    /**
     * Create an instance of {@link PublishPostResponse }
     * 
     */
    public PublishPostResponse createPublishPostResponse() {
        return new PublishPostResponse();
    }

    /**
     * Create an instance of {@link GetPost }
     * 
     */
    public GetPost createGetPost() {
        return new GetPost();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
    }

    /**
     * Create an instance of {@link GetnamaResponse }
     * 
     */
    public GetnamaResponse createGetnamaResponse() {
        return new GetnamaResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link ListComment }
     * 
     */
    public ListComment createListComment() {
        return new ListComment();
    }

    /**
     * Create an instance of {@link GetUserRole }
     * 
     */
    public GetUserRole createGetUserRole() {
        return new GetUserRole();
    }

    /**
     * Create an instance of {@link GetAuthorPostResponse }
     * 
     */
    public GetAuthorPostResponse createGetAuthorPostResponse() {
        return new GetAuthorPostResponse();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Getemail }
     * 
     */
    public Getemail createGetemail() {
        return new Getemail();
    }

    /**
     * Create an instance of {@link PostResults }
     * 
     */
    public PostResults createPostResults() {
        return new PostResults();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link GetemailResponse }
     * 
     */
    public GetemailResponse createGetemailResponse() {
        return new GetemailResponse();
    }

    /**
     * Create an instance of {@link ListPost }
     * 
     */
    public ListPost createListPost() {
        return new ListPost();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link EditPost }
     * 
     */
    public EditPost createEditPost() {
        return new EditPost();
    }

    /**
     * Create an instance of {@link DeleteRealPost }
     * 
     */
    public DeleteRealPost createDeleteRealPost() {
        return new DeleteRealPost();
    }

    /**
     * Create an instance of {@link GetUserRoleResponse }
     * 
     */
    public GetUserRoleResponse createGetUserRoleResponse() {
        return new GetUserRoleResponse();
    }

    /**
     * Create an instance of {@link ChangeStatusPostResponse }
     * 
     */
    public ChangeStatusPostResponse createChangeStatusPostResponse() {
        return new ChangeStatusPostResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link ListPostResponse }
     * 
     */
    public ListPostResponse createListPostResponse() {
        return new ListPostResponse();
    }

    /**
     * Create an instance of {@link EditPostResponse }
     * 
     */
    public EditPostResponse createEditPostResponse() {
        return new EditPostResponse();
    }

    /**
     * Create an instance of {@link ListUser }
     * 
     */
    public ListUser createListUser() {
        return new ListUser();
    }

    /**
     * Create an instance of {@link ListCommentResponse }
     * 
     */
    public ListCommentResponse createListCommentResponse() {
        return new ListCommentResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
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
    @XmlElementDecl(namespace = "http://Service/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetemailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getemailResponse")
    public JAXBElement<GetemailResponse> createGetemailResponse(GetemailResponse value) {
        return new JAXBElement<GetemailResponse>(_GetemailResponse_QNAME, GetemailResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getAuthorPostResponse")
    public JAXBElement<GetAuthorPostResponse> createGetAuthorPostResponse(GetAuthorPostResponse value) {
        return new JAXBElement<GetAuthorPostResponse>(_GetAuthorPostResponse_QNAME, GetAuthorPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getUserRole")
    public JAXBElement<GetUserRole> createGetUserRole(GetUserRole value) {
        return new JAXBElement<GetUserRole>(_GetUserRole_QNAME, GetUserRole.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getemail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getemail")
    public JAXBElement<Getemail> createGetemail(Getemail value) {
        return new JAXBElement<Getemail>(_Getemail_QNAME, Getemail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "postResults")
    public JAXBElement<PostResults> createPostResults(PostResults value) {
        return new JAXBElement<PostResults>(_PostResults_QNAME, PostResults.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "listPostResponse")
    public JAXBElement<ListPostResponse> createListPostResponse(ListPostResponse value) {
        return new JAXBElement<ListPostResponse>(_ListPostResponse_QNAME, ListPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRealPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deleteRealPost")
    public JAXBElement<DeleteRealPost> createDeleteRealPost(DeleteRealPost value) {
        return new JAXBElement<DeleteRealPost>(_DeleteRealPost_QNAME, DeleteRealPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRoleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getUserRoleResponse")
    public JAXBElement<GetUserRoleResponse> createGetUserRoleResponse(GetUserRoleResponse value) {
        return new JAXBElement<GetUserRoleResponse>(_GetUserRoleResponse_QNAME, GetUserRoleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStatusPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "ChangeStatusPostResponse")
    public JAXBElement<ChangeStatusPostResponse> createChangeStatusPostResponse(ChangeStatusPostResponse value) {
        return new JAXBElement<ChangeStatusPostResponse>(_ChangeStatusPostResponse_QNAME, ChangeStatusPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Checkuserexist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "checkuserexist")
    public JAXBElement<Checkuserexist> createCheckuserexist(Checkuserexist value) {
        return new JAXBElement<Checkuserexist>(_Checkuserexist_QNAME, Checkuserexist.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PostResultsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "postResultsResponse")
    public JAXBElement<PostResultsResponse> createPostResultsResponse(PostResultsResponse value) {
        return new JAXBElement<PostResultsResponse>(_PostResultsResponse_QNAME, PostResultsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getnama }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getnama")
    public JAXBElement<Getnama> createGetnama(Getnama value) {
        return new JAXBElement<Getnama>(_Getnama_QNAME, Getnama.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckuserexistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "checkuserexistResponse")
    public JAXBElement<CheckuserexistResponse> createCheckuserexistResponse(CheckuserexistResponse value) {
        return new JAXBElement<CheckuserexistResponse>(_CheckuserexistResponse_QNAME, CheckuserexistResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getAuthorPost")
    public JAXBElement<GetAuthorPost> createGetAuthorPost(GetAuthorPost value) {
        return new JAXBElement<GetAuthorPost>(_GetAuthorPost_QNAME, GetAuthorPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRealPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "deleteRealPostResponse")
    public JAXBElement<DeleteRealPostResponse> createDeleteRealPostResponse(DeleteRealPostResponse value) {
        return new JAXBElement<DeleteRealPostResponse>(_DeleteRealPostResponse_QNAME, DeleteRealPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStatusPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "ChangeStatusPost")
    public JAXBElement<ChangeStatusPost> createChangeStatusPost(ChangeStatusPost value) {
        return new JAXBElement<ChangeStatusPost>(_ChangeStatusPost_QNAME, ChangeStatusPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetnamaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "getnamaResponse")
    public JAXBElement<GetnamaResponse> createGetnamaResponse(GetnamaResponse value) {
        return new JAXBElement<GetnamaResponse>(_GetnamaResponse_QNAME, GetnamaResponse.class, null, value);
    }

}
