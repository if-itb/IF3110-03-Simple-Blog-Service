
package undeclared.mavenproject1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the undeclared.mavenproject1 package. 
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

    private final static QName _DeleteCommentResponse_QNAME = new QName("http://mavenproject1.undeclared/", "deleteCommentResponse");
    private final static QName _AddComment_QNAME = new QName("http://mavenproject1.undeclared/", "addComment");
    private final static QName _Search_QNAME = new QName("http://mavenproject1.undeclared/", "search");
    private final static QName _PublishPostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "publishPostResponse");
    private final static QName _EditUserResponse_QNAME = new QName("http://mavenproject1.undeclared/", "editUserResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://mavenproject1.undeclared/", "deleteUserResponse");
    private final static QName _AddPost_QNAME = new QName("http://mavenproject1.undeclared/", "addPost");
    private final static QName _ListDeletePostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "listDeletePostResponse");
    private final static QName _RestorePostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "restorePostResponse");
    private final static QName _EditPost_QNAME = new QName("http://mavenproject1.undeclared/", "editPost");
    private final static QName _ListPublishPostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "listPublishPostResponse");
    private final static QName _ListPost_QNAME = new QName("http://mavenproject1.undeclared/", "listPost");
    private final static QName _ListPublishPost_QNAME = new QName("http://mavenproject1.undeclared/", "listPublishPost");
    private final static QName _AddUserResponse_QNAME = new QName("http://mavenproject1.undeclared/", "addUserResponse");
    private final static QName _PublishPost_QNAME = new QName("http://mavenproject1.undeclared/", "publishPost");
    private final static QName _ListComment_QNAME = new QName("http://mavenproject1.undeclared/", "listComment");
    private final static QName _ListUser_QNAME = new QName("http://mavenproject1.undeclared/", "listUser");
    private final static QName _DeletePostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "deletePostResponse");
    private final static QName _ListPostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "listPostResponse");
    private final static QName _AddUser_QNAME = new QName("http://mavenproject1.undeclared/", "addUser");
    private final static QName _EditPostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "editPostResponse");
    private final static QName _ReadUrl_QNAME = new QName("http://mavenproject1.undeclared/", "readUrl");
    private final static QName _DeleteUser_QNAME = new QName("http://mavenproject1.undeclared/", "deleteUser");
    private final static QName _ReadUrlResponse_QNAME = new QName("http://mavenproject1.undeclared/", "readUrlResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://mavenproject1.undeclared/", "addCommentResponse");
    private final static QName _DeleteComment_QNAME = new QName("http://mavenproject1.undeclared/", "deleteComment");
    private final static QName _ListUserResponse_QNAME = new QName("http://mavenproject1.undeclared/", "listUserResponse");
    private final static QName _SearchResponse_QNAME = new QName("http://mavenproject1.undeclared/", "searchResponse");
    private final static QName _RestorePost_QNAME = new QName("http://mavenproject1.undeclared/", "restorePost");
    private final static QName _AddPostResponse_QNAME = new QName("http://mavenproject1.undeclared/", "addPostResponse");
    private final static QName _EditUser_QNAME = new QName("http://mavenproject1.undeclared/", "editUser");
    private final static QName _ListDeletePost_QNAME = new QName("http://mavenproject1.undeclared/", "listDeletePost");
    private final static QName _ListCommentResponse_QNAME = new QName("http://mavenproject1.undeclared/", "listCommentResponse");
    private final static QName _DeletePost_QNAME = new QName("http://mavenproject1.undeclared/", "deletePost");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: undeclared.mavenproject1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListUser }
     * 
     */
    public ListUser createListUser() {
        return new ListUser();
    }

    /**
     * Create an instance of {@link ListComment }
     * 
     */
    public ListComment createListComment() {
        return new ListComment();
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
     * Create an instance of {@link ListPublishPost }
     * 
     */
    public ListPublishPost createListPublishPost() {
        return new ListPublishPost();
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
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link DeleteCommentResponse }
     * 
     */
    public DeleteCommentResponse createDeleteCommentResponse() {
        return new DeleteCommentResponse();
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
     * Create an instance of {@link EditPost }
     * 
     */
    public EditPost createEditPost() {
        return new EditPost();
    }

    /**
     * Create an instance of {@link ListPublishPostResponse }
     * 
     */
    public ListPublishPostResponse createListPublishPostResponse() {
        return new ListPublishPostResponse();
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
     * Create an instance of {@link ListDeletePostResponse }
     * 
     */
    public ListDeletePostResponse createListDeletePostResponse() {
        return new ListDeletePostResponse();
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
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link DeleteComment }
     * 
     */
    public DeleteComment createDeleteComment() {
        return new DeleteComment();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link ListCommentResponse }
     * 
     */
    public ListCommentResponse createListCommentResponse() {
        return new ListCommentResponse();
    }

    /**
     * Create an instance of {@link ListDeletePost }
     * 
     */
    public ListDeletePost createListDeletePost() {
        return new ListDeletePost();
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
     * Create an instance of {@link ReadUrl }
     * 
     */
    public ReadUrl createReadUrl() {
        return new ReadUrl();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deleteCommentResponse")
    public JAXBElement<DeleteCommentResponse> createDeleteCommentResponse(DeleteCommentResponse value) {
        return new JAXBElement<DeleteCommentResponse>(_DeleteCommentResponse_QNAME, DeleteCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listDeletePostResponse")
    public JAXBElement<ListDeletePostResponse> createListDeletePostResponse(ListDeletePostResponse value) {
        return new JAXBElement<ListDeletePostResponse>(_ListDeletePostResponse_QNAME, ListDeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "restorePostResponse")
    public JAXBElement<RestorePostResponse> createRestorePostResponse(RestorePostResponse value) {
        return new JAXBElement<RestorePostResponse>(_RestorePostResponse_QNAME, RestorePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listPublishPostResponse")
    public JAXBElement<ListPublishPostResponse> createListPublishPostResponse(ListPublishPostResponse value) {
        return new JAXBElement<ListPublishPostResponse>(_ListPublishPostResponse_QNAME, ListPublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listPost")
    public JAXBElement<ListPost> createListPost(ListPost value) {
        return new JAXBElement<ListPost>(_ListPost_QNAME, ListPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listPublishPost")
    public JAXBElement<ListPublishPost> createListPublishPost(ListPublishPost value) {
        return new JAXBElement<ListPublishPost>(_ListPublishPost_QNAME, ListPublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listPostResponse")
    public JAXBElement<ListPostResponse> createListPostResponse(ListPostResponse value) {
        return new JAXBElement<ListPostResponse>(_ListPostResponse_QNAME, ListPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "readUrl")
    public JAXBElement<ReadUrl> createReadUrl(ReadUrl value) {
        return new JAXBElement<ReadUrl>(_ReadUrl_QNAME, ReadUrl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUrlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "readUrlResponse")
    public JAXBElement<ReadUrlResponse> createReadUrlResponse(ReadUrlResponse value) {
        return new JAXBElement<ReadUrlResponse>(_ReadUrlResponse_QNAME, ReadUrlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deleteComment")
    public JAXBElement<DeleteComment> createDeleteComment(DeleteComment value) {
        return new JAXBElement<DeleteComment>(_DeleteComment_QNAME, DeleteComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "restorePost")
    public JAXBElement<RestorePost> createRestorePost(RestorePost value) {
        return new JAXBElement<RestorePost>(_RestorePost_QNAME, RestorePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listDeletePost")
    public JAXBElement<ListDeletePost> createListDeletePost(ListDeletePost value) {
        return new JAXBElement<ListDeletePost>(_ListDeletePost_QNAME, ListDeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mavenproject1.undeclared/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

}
