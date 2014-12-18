
package WBD;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WBD package. 
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

    private final static QName _GetComment_QNAME = new QName("http://WBD/", "getComment");
    private final static QName _UnpublishedPostResponse_QNAME = new QName("http://WBD/", "unpublishedPostResponse");
    private final static QName _AddComment_QNAME = new QName("http://WBD/", "addComment");
    private final static QName _UndeletePostResponse_QNAME = new QName("http://WBD/", "undeletePostResponse");
    private final static QName _AddUserResponse_QNAME = new QName("http://WBD/", "addUserResponse");
    private final static QName _ReadUrl_QNAME = new QName("http://WBD/", "readUrl");
    private final static QName _ListComment_QNAME = new QName("http://WBD/", "listComment");
    private final static QName _GetPostResponse_QNAME = new QName("http://WBD/", "getPostResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://WBD/", "publishPostResponse");
    private final static QName _GetPost_QNAME = new QName("http://WBD/", "getPost");
    private final static QName _Search_QNAME = new QName("http://WBD/", "search");
    private final static QName _LiterallyDeletePostResponse_QNAME = new QName("http://WBD/", "literallyDeletePostResponse");
    private final static QName _PublishPost_QNAME = new QName("http://WBD/", "publishPost");
    private final static QName _UnpublishedPost_QNAME = new QName("http://WBD/", "unpublishedPost");
    private final static QName _DeletedPostResponse_QNAME = new QName("http://WBD/", "deletedPostResponse");
    private final static QName _ReadUrlResponse_QNAME = new QName("http://WBD/", "readUrlResponse");
    private final static QName _EditUser_QNAME = new QName("http://WBD/", "editUser");
    private final static QName _Login_QNAME = new QName("http://WBD/", "login");
    private final static QName _LiterallyDeletePost_QNAME = new QName("http://WBD/", "literallyDeletePost");
    private final static QName _DeletedPost_QNAME = new QName("http://WBD/", "deletedPost");
    private final static QName _GetUserResponse_QNAME = new QName("http://WBD/", "getUserResponse");
    private final static QName _DeletePost_QNAME = new QName("http://WBD/", "deletePost");
    private final static QName _EditUserResponse_QNAME = new QName("http://WBD/", "editUserResponse");
    private final static QName _DeleteComment_QNAME = new QName("http://WBD/", "deleteComment");
    private final static QName _DeletePostResponse_QNAME = new QName("http://WBD/", "deletePostResponse");
    private final static QName _GetUser_QNAME = new QName("http://WBD/", "getUser");
    private final static QName _AddUser_QNAME = new QName("http://WBD/", "addUser");
    private final static QName _AddImageResponse_QNAME = new QName("http://WBD/", "addImageResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://WBD/", "deleteUser");
    private final static QName _DeleteCommentResponse_QNAME = new QName("http://WBD/", "deleteCommentResponse");
    private final static QName _GetCommentResponse_QNAME = new QName("http://WBD/", "getCommentResponse");
    private final static QName _ListCommentResponse_QNAME = new QName("http://WBD/", "listCommentResponse");
    private final static QName _EditPostResponse_QNAME = new QName("http://WBD/", "editPostResponse");
    private final static QName _ListUser_QNAME = new QName("http://WBD/", "listUser");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://WBD/", "deleteUserResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://WBD/", "addPostResponse");
    private final static QName _EditPost_QNAME = new QName("http://WBD/", "editPost");
    private final static QName _RemoveImageResponse_QNAME = new QName("http://WBD/", "removeImageResponse");
    private final static QName _RemoveImage_QNAME = new QName("http://WBD/", "removeImage");
    private final static QName _SearchResponse_QNAME = new QName("http://WBD/", "searchResponse");
    private final static QName _AddPost_QNAME = new QName("http://WBD/", "addPost");
    private final static QName _ListUserResponse_QNAME = new QName("http://WBD/", "listUserResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://WBD/", "loginResponse");
    private final static QName _PublishedPost_QNAME = new QName("http://WBD/", "publishedPost");
    private final static QName _AddCommentResponse_QNAME = new QName("http://WBD/", "addCommentResponse");
    private final static QName _PublishedPostResponse_QNAME = new QName("http://WBD/", "publishedPostResponse");
    private final static QName _UndeletePost_QNAME = new QName("http://WBD/", "undeletePost");
    private final static QName _AddImage_QNAME = new QName("http://WBD/", "addImage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WBD
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link DeletedPost }
     * 
     */
    public DeletedPost createDeletedPost() {
        return new DeletedPost();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link EditUserResponse }
     * 
     */
    public EditUserResponse createEditUserResponse() {
        return new EditUserResponse();
    }

    /**
     * Create an instance of {@link DeleteComment }
     * 
     */
    public DeleteComment createDeleteComment() {
        return new DeleteComment();
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
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link EditUser }
     * 
     */
    public EditUser createEditUser() {
        return new EditUser();
    }

    /**
     * Create an instance of {@link ReadUrlResponse }
     * 
     */
    public ReadUrlResponse createReadUrlResponse() {
        return new ReadUrlResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LiterallyDeletePost }
     * 
     */
    public LiterallyDeletePost createLiterallyDeletePost() {
        return new LiterallyDeletePost();
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
     * Create an instance of {@link UnpublishedPost }
     * 
     */
    public UnpublishedPost createUnpublishedPost() {
        return new UnpublishedPost();
    }

    /**
     * Create an instance of {@link LiterallyDeletePostResponse }
     * 
     */
    public LiterallyDeletePostResponse createLiterallyDeletePostResponse() {
        return new LiterallyDeletePostResponse();
    }

    /**
     * Create an instance of {@link DeletedPostResponse }
     * 
     */
    public DeletedPostResponse createDeletedPostResponse() {
        return new DeletedPostResponse();
    }

    /**
     * Create an instance of {@link GetComment }
     * 
     */
    public GetComment createGetComment() {
        return new GetComment();
    }

    /**
     * Create an instance of {@link UnpublishedPostResponse }
     * 
     */
    public UnpublishedPostResponse createUnpublishedPostResponse() {
        return new UnpublishedPostResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link ReadUrl }
     * 
     */
    public ReadUrl createReadUrl() {
        return new ReadUrl();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link UndeletePostResponse }
     * 
     */
    public UndeletePostResponse createUndeletePostResponse() {
        return new UndeletePostResponse();
    }

    /**
     * Create an instance of {@link ListComment }
     * 
     */
    public ListComment createListComment() {
        return new ListComment();
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
     * Create an instance of {@link PublishedPost }
     * 
     */
    public PublishedPost createPublishedPost() {
        return new PublishedPost();
    }

    /**
     * Create an instance of {@link PublishedPostResponse }
     * 
     */
    public PublishedPostResponse createPublishedPostResponse() {
        return new PublishedPostResponse();
    }

    /**
     * Create an instance of {@link UndeletePost }
     * 
     */
    public UndeletePost createUndeletePost() {
        return new UndeletePost();
    }

    /**
     * Create an instance of {@link AddImage }
     * 
     */
    public AddImage createAddImage() {
        return new AddImage();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link RemoveImage }
     * 
     */
    public RemoveImage createRemoveImage() {
        return new RemoveImage();
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
     * Create an instance of {@link RemoveImageResponse }
     * 
     */
    public RemoveImageResponse createRemoveImageResponse() {
        return new RemoveImageResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link AddImageResponse }
     * 
     */
    public AddImageResponse createAddImageResponse() {
        return new AddImageResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link DeleteCommentResponse }
     * 
     */
    public DeleteCommentResponse createDeleteCommentResponse() {
        return new DeleteCommentResponse();
    }

    /**
     * Create an instance of {@link GetCommentResponse }
     * 
     */
    public GetCommentResponse createGetCommentResponse() {
        return new GetCommentResponse();
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
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getComment")
    public JAXBElement<GetComment> createGetComment(GetComment value) {
        return new JAXBElement<GetComment>(_GetComment_QNAME, GetComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnpublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "unpublishedPostResponse")
    public JAXBElement<UnpublishedPostResponse> createUnpublishedPostResponse(UnpublishedPostResponse value) {
        return new JAXBElement<UnpublishedPostResponse>(_UnpublishedPostResponse_QNAME, UnpublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "undeletePostResponse")
    public JAXBElement<UndeletePostResponse> createUndeletePostResponse(UndeletePostResponse value) {
        return new JAXBElement<UndeletePostResponse>(_UndeletePostResponse_QNAME, UndeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "readUrl")
    public JAXBElement<ReadUrl> createReadUrl(ReadUrl value) {
        return new JAXBElement<ReadUrl>(_ReadUrl_QNAME, ReadUrl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiterallyDeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "literallyDeletePostResponse")
    public JAXBElement<LiterallyDeletePostResponse> createLiterallyDeletePostResponse(LiterallyDeletePostResponse value) {
        return new JAXBElement<LiterallyDeletePostResponse>(_LiterallyDeletePostResponse_QNAME, LiterallyDeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnpublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "unpublishedPost")
    public JAXBElement<UnpublishedPost> createUnpublishedPost(UnpublishedPost value) {
        return new JAXBElement<UnpublishedPost>(_UnpublishedPost_QNAME, UnpublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deletedPostResponse")
    public JAXBElement<DeletedPostResponse> createDeletedPostResponse(DeletedPostResponse value) {
        return new JAXBElement<DeletedPostResponse>(_DeletedPostResponse_QNAME, DeletedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "readUrlResponse")
    public JAXBElement<ReadUrlResponse> createReadUrlResponse(ReadUrlResponse value) {
        return new JAXBElement<ReadUrlResponse>(_ReadUrlResponse_QNAME, ReadUrlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiterallyDeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "literallyDeletePost")
    public JAXBElement<LiterallyDeletePost> createLiterallyDeletePost(LiterallyDeletePost value) {
        return new JAXBElement<LiterallyDeletePost>(_LiterallyDeletePost_QNAME, LiterallyDeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deletedPost")
    public JAXBElement<DeletedPost> createDeletedPost(DeletedPost value) {
        return new JAXBElement<DeletedPost>(_DeletedPost_QNAME, DeletedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deleteComment")
    public JAXBElement<DeleteComment> createDeleteComment(DeleteComment value) {
        return new JAXBElement<DeleteComment>(_DeleteComment_QNAME, DeleteComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addImageResponse")
    public JAXBElement<AddImageResponse> createAddImageResponse(AddImageResponse value) {
        return new JAXBElement<AddImageResponse>(_AddImageResponse_QNAME, AddImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deleteCommentResponse")
    public JAXBElement<DeleteCommentResponse> createDeleteCommentResponse(DeleteCommentResponse value) {
        return new JAXBElement<DeleteCommentResponse>(_DeleteCommentResponse_QNAME, DeleteCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "getCommentResponse")
    public JAXBElement<GetCommentResponse> createGetCommentResponse(GetCommentResponse value) {
        return new JAXBElement<GetCommentResponse>(_GetCommentResponse_QNAME, GetCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "removeImageResponse")
    public JAXBElement<RemoveImageResponse> createRemoveImageResponse(RemoveImageResponse value) {
        return new JAXBElement<RemoveImageResponse>(_RemoveImageResponse_QNAME, RemoveImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "removeImage")
    public JAXBElement<RemoveImage> createRemoveImage(RemoveImage value) {
        return new JAXBElement<RemoveImage>(_RemoveImage_QNAME, RemoveImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "publishedPost")
    public JAXBElement<PublishedPost> createPublishedPost(PublishedPost value) {
        return new JAXBElement<PublishedPost>(_PublishedPost_QNAME, PublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "publishedPostResponse")
    public JAXBElement<PublishedPostResponse> createPublishedPostResponse(PublishedPostResponse value) {
        return new JAXBElement<PublishedPostResponse>(_PublishedPostResponse_QNAME, PublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "undeletePost")
    public JAXBElement<UndeletePost> createUndeletePost(UndeletePost value) {
        return new JAXBElement<UndeletePost>(_UndeletePost_QNAME, UndeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WBD/", name = "addImage")
    public JAXBElement<AddImage> createAddImage(AddImage value) {
        return new JAXBElement<AddImage>(_AddImage_QNAME, AddImage.class, null, value);
    }

}
