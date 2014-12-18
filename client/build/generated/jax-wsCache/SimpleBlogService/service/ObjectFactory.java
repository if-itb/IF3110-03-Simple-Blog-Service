
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

    private final static QName _GetPostByIdResponse_QNAME = new QName("http://services/", "getPostByIdResponse");
    private final static QName _ListComment_QNAME = new QName("http://services/", "listComment");
    private final static QName _AddUserResponse_QNAME = new QName("http://services/", "addUserResponse");
    private final static QName _AddComment_QNAME = new QName("http://services/", "addComment");
    private final static QName _PermanentDeletePostResponse_QNAME = new QName("http://services/", "permanentDeletePostResponse");
    private final static QName _Search_QNAME = new QName("http://services/", "search");
    private final static QName _UpdatePost_QNAME = new QName("http://services/", "updatePost");
    private final static QName _ModifyUser_QNAME = new QName("http://services/", "modifyUser");
    private final static QName _PublishPostResponse_QNAME = new QName("http://services/", "publishPostResponse");
    private final static QName _PermanentDeletePost_QNAME = new QName("http://services/", "permanentDeletePost");
    private final static QName _PublishPost_QNAME = new QName("http://services/", "publishPost");
    private final static QName _RemoveUser_QNAME = new QName("http://services/", "removeUser");
    private final static QName _GetUserById_QNAME = new QName("http://services/", "getUserById");
    private final static QName _RestorePostResponse_QNAME = new QName("http://services/", "restorePostResponse");
    private final static QName _DeletePost_QNAME = new QName("http://services/", "deletePost");
    private final static QName _ModifyUserResponse_QNAME = new QName("http://services/", "modifyUserResponse");
    private final static QName _AddUser_QNAME = new QName("http://services/", "addUser");
    private final static QName _DeletePostResponse_QNAME = new QName("http://services/", "deletePostResponse");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://services/", "getUserByIdResponse");
    private final static QName _UnpublishPost_QNAME = new QName("http://services/", "unpublishPost");
    private final static QName _ListPostResponse_QNAME = new QName("http://services/", "listPostResponse");
    private final static QName _GetPostById_QNAME = new QName("http://services/", "getPostById");
    private final static QName _ListUser_QNAME = new QName("http://services/", "listUser");
    private final static QName _ListCommentResponse_QNAME = new QName("http://services/", "listCommentResponse");
    private final static QName _RemoveUserResponse_QNAME = new QName("http://services/", "removeUserResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://services/", "addPostResponse");
    private final static QName _SearchResponse_QNAME = new QName("http://services/", "searchResponse");
    private final static QName _AddPost_QNAME = new QName("http://services/", "addPost");
    private final static QName _ListUserResponse_QNAME = new QName("http://services/", "listUserResponse");
    private final static QName _ListPost_QNAME = new QName("http://services/", "listPost");
    private final static QName _AddCommentResponse_QNAME = new QName("http://services/", "addCommentResponse");
    private final static QName _GetUserByUsernameResponse_QNAME = new QName("http://services/", "getUserByUsernameResponse");
    private final static QName _UpdatePostResponse_QNAME = new QName("http://services/", "updatePostResponse");
    private final static QName _RestorePost_QNAME = new QName("http://services/", "restorePost");
    private final static QName _GetUserByUsername_QNAME = new QName("http://services/", "getUserByUsername");
    private final static QName _UnpublishPostResponse_QNAME = new QName("http://services/", "unpublishPostResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
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
     * Create an instance of {@link ModifyUserResponse }
     * 
     */
    public ModifyUserResponse createModifyUserResponse() {
        return new ModifyUserResponse();
    }

    /**
     * Create an instance of {@link GetUserById }
     * 
     */
    public GetUserById createGetUserById() {
        return new GetUserById();
    }

    /**
     * Create an instance of {@link RestorePostResponse }
     * 
     */
    public RestorePostResponse createRestorePostResponse() {
        return new RestorePostResponse();
    }

    /**
     * Create an instance of {@link GetUserByIdResponse }
     * 
     */
    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    /**
     * Create an instance of {@link UnpublishPost }
     * 
     */
    public UnpublishPost createUnpublishPost() {
        return new UnpublishPost();
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
     * Create an instance of {@link ModifyUser }
     * 
     */
    public ModifyUser createModifyUser() {
        return new ModifyUser();
    }

    /**
     * Create an instance of {@link PublishPostResponse }
     * 
     */
    public PublishPostResponse createPublishPostResponse() {
        return new PublishPostResponse();
    }

    /**
     * Create an instance of {@link PermanentDeletePostResponse }
     * 
     */
    public PermanentDeletePostResponse createPermanentDeletePostResponse() {
        return new PermanentDeletePostResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link UpdatePost }
     * 
     */
    public UpdatePost createUpdatePost() {
        return new UpdatePost();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
    }

    /**
     * Create an instance of {@link RemoveUser }
     * 
     */
    public RemoveUser createRemoveUser() {
        return new RemoveUser();
    }

    /**
     * Create an instance of {@link PermanentDeletePost }
     * 
     */
    public PermanentDeletePost createPermanentDeletePost() {
        return new PermanentDeletePost();
    }

    /**
     * Create an instance of {@link GetPostByIdResponse }
     * 
     */
    public GetPostByIdResponse createGetPostByIdResponse() {
        return new GetPostByIdResponse();
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
     * Create an instance of {@link GetUserByUsernameResponse }
     * 
     */
    public GetUserByUsernameResponse createGetUserByUsernameResponse() {
        return new GetUserByUsernameResponse();
    }

    /**
     * Create an instance of {@link UpdatePostResponse }
     * 
     */
    public UpdatePostResponse createUpdatePostResponse() {
        return new UpdatePostResponse();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link GetUserByUsername }
     * 
     */
    public GetUserByUsername createGetUserByUsername() {
        return new GetUserByUsername();
    }

    /**
     * Create an instance of {@link UnpublishPostResponse }
     * 
     */
    public UnpublishPostResponse createUnpublishPostResponse() {
        return new UnpublishPostResponse();
    }

    /**
     * Create an instance of {@link RestorePost }
     * 
     */
    public RestorePost createRestorePost() {
        return new RestorePost();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link ListPost }
     * 
     */
    public ListPost createListPost() {
        return new ListPost();
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
     * Create an instance of {@link RemoveUserResponse }
     * 
     */
    public RemoveUserResponse createRemoveUserResponse() {
        return new RemoveUserResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link ListPostResponse }
     * 
     */
    public ListPostResponse createListPostResponse() {
        return new ListPostResponse();
    }

    /**
     * Create an instance of {@link GetPostById }
     * 
     */
    public GetPostById createGetPostById() {
        return new GetPostById();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPostByIdResponse")
    public JAXBElement<GetPostByIdResponse> createGetPostByIdResponse(GetPostByIdResponse value) {
        return new JAXBElement<GetPostByIdResponse>(_GetPostByIdResponse_QNAME, GetPostByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PermanentDeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "permanentDeletePostResponse")
    public JAXBElement<PermanentDeletePostResponse> createPermanentDeletePostResponse(PermanentDeletePostResponse value) {
        return new JAXBElement<PermanentDeletePostResponse>(_PermanentDeletePostResponse_QNAME, PermanentDeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "updatePost")
    public JAXBElement<UpdatePost> createUpdatePost(UpdatePost value) {
        return new JAXBElement<UpdatePost>(_UpdatePost_QNAME, UpdatePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "modifyUser")
    public JAXBElement<ModifyUser> createModifyUser(ModifyUser value) {
        return new JAXBElement<ModifyUser>(_ModifyUser_QNAME, ModifyUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PermanentDeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "permanentDeletePost")
    public JAXBElement<PermanentDeletePost> createPermanentDeletePost(PermanentDeletePost value) {
        return new JAXBElement<PermanentDeletePost>(_PermanentDeletePost_QNAME, PermanentDeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "removeUser")
    public JAXBElement<RemoveUser> createRemoveUser(RemoveUser value) {
        return new JAXBElement<RemoveUser>(_RemoveUser_QNAME, RemoveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getUserById")
    public JAXBElement<GetUserById> createGetUserById(GetUserById value) {
        return new JAXBElement<GetUserById>(_GetUserById_QNAME, GetUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "restorePostResponse")
    public JAXBElement<RestorePostResponse> createRestorePostResponse(RestorePostResponse value) {
        return new JAXBElement<RestorePostResponse>(_RestorePostResponse_QNAME, RestorePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "modifyUserResponse")
    public JAXBElement<ModifyUserResponse> createModifyUserResponse(ModifyUserResponse value) {
        return new JAXBElement<ModifyUserResponse>(_ModifyUserResponse_QNAME, ModifyUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getUserByIdResponse")
    public JAXBElement<GetUserByIdResponse> createGetUserByIdResponse(GetUserByIdResponse value) {
        return new JAXBElement<GetUserByIdResponse>(_GetUserByIdResponse_QNAME, GetUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnpublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "unpublishPost")
    public JAXBElement<UnpublishPost> createUnpublishPost(UnpublishPost value) {
        return new JAXBElement<UnpublishPost>(_UnpublishPost_QNAME, UnpublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listPostResponse")
    public JAXBElement<ListPostResponse> createListPostResponse(ListPostResponse value) {
        return new JAXBElement<ListPostResponse>(_ListPostResponse_QNAME, ListPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPostById")
    public JAXBElement<GetPostById> createGetPostById(GetPostById value) {
        return new JAXBElement<GetPostById>(_GetPostById_QNAME, GetPostById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "removeUserResponse")
    public JAXBElement<RemoveUserResponse> createRemoveUserResponse(RemoveUserResponse value) {
        return new JAXBElement<RemoveUserResponse>(_RemoveUserResponse_QNAME, RemoveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listPost")
    public JAXBElement<ListPost> createListPost(ListPost value) {
        return new JAXBElement<ListPost>(_ListPost_QNAME, ListPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getUserByUsernameResponse")
    public JAXBElement<GetUserByUsernameResponse> createGetUserByUsernameResponse(GetUserByUsernameResponse value) {
        return new JAXBElement<GetUserByUsernameResponse>(_GetUserByUsernameResponse_QNAME, GetUserByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "updatePostResponse")
    public JAXBElement<UpdatePostResponse> createUpdatePostResponse(UpdatePostResponse value) {
        return new JAXBElement<UpdatePostResponse>(_UpdatePostResponse_QNAME, UpdatePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "restorePost")
    public JAXBElement<RestorePost> createRestorePost(RestorePost value) {
        return new JAXBElement<RestorePost>(_RestorePost_QNAME, RestorePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getUserByUsername")
    public JAXBElement<GetUserByUsername> createGetUserByUsername(GetUserByUsername value) {
        return new JAXBElement<GetUserByUsername>(_GetUserByUsername_QNAME, GetUserByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnpublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "unpublishPostResponse")
    public JAXBElement<UnpublishPostResponse> createUnpublishPostResponse(UnpublishPostResponse value) {
        return new JAXBElement<UnpublishPostResponse>(_UnpublishPostResponse_QNAME, UnpublishPostResponse.class, null, value);
    }

}
