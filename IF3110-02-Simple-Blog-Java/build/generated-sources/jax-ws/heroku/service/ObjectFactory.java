
package heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the heroku.service package. 
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

    private final static QName _GetPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getPostResponse");
    private final static QName _AddComment_QNAME = new QName("http://service.heroku.chamerling.org/", "addComment");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "deleteUserResponse");
    private final static QName _EditUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "editUserResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "publishPostResponse");
    private final static QName _EditPost_QNAME = new QName("http://service.heroku.chamerling.org/", "editPost");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getUserResponse");
    private final static QName _IsExistUser_QNAME = new QName("http://service.heroku.chamerling.org/", "isExistUser");
    private final static QName _AddPost_QNAME = new QName("http://service.heroku.chamerling.org/", "addPost");
    private final static QName _GetPublishedPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getPublishedPostResponse");
    private final static QName _GetKomentarResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getKomentarResponse");
    private final static QName _GetUnpublishedPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getUnpublishedPostResponse");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addUserResponse");
    private final static QName _ListComment_QNAME = new QName("http://service.heroku.chamerling.org/", "listComment");
    private final static QName _ListUser_QNAME = new QName("http://service.heroku.chamerling.org/", "listUser");
    private final static QName _PublishPost_QNAME = new QName("http://service.heroku.chamerling.org/", "publishPost");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "deletePostResponse");
    private final static QName _SearchPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "searchPostResponse");
    private final static QName _GetKomentar_QNAME = new QName("http://service.heroku.chamerling.org/", "getKomentar");
    private final static QName _AddUser_QNAME = new QName("http://service.heroku.chamerling.org/", "addUser");
    private final static QName _IsExistUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "isExistUserResponse");
    private final static QName _GetUnpublishedPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getUnpublishedPost");
    private final static QName _EditPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "editPostResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addCommentResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://service.heroku.chamerling.org/", "deleteUser");
    private final static QName _ListUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "listUserResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addPostResponse");
    private final static QName _EditUser_QNAME = new QName("http://service.heroku.chamerling.org/", "editUser");
    private final static QName _GetUser_QNAME = new QName("http://service.heroku.chamerling.org/", "getUser");
    private final static QName _SearchPost_QNAME = new QName("http://service.heroku.chamerling.org/", "searchPost");
    private final static QName _GetPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getPost");
    private final static QName _GetPublishedPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getPublishedPost");
    private final static QName _DeletePost_QNAME = new QName("http://service.heroku.chamerling.org/", "deletePost");
    private final static QName _ListCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "listCommentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: heroku.service
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
     * Create an instance of {@link GetUnpublishedPostResponse }
     * 
     */
    public GetUnpublishedPostResponse createGetUnpublishedPostResponse() {
        return new GetUnpublishedPostResponse();
    }

    /**
     * Create an instance of {@link GetKomentar }
     * 
     */
    public GetKomentar createGetKomentar() {
        return new GetKomentar();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
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
     * Create an instance of {@link GetKomentarResponse }
     * 
     */
    public GetKomentarResponse createGetKomentarResponse() {
        return new GetKomentarResponse();
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
     * Create an instance of {@link IsExistUser }
     * 
     */
    public IsExistUser createIsExistUser() {
        return new IsExistUser();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link GetPublishedPostResponse }
     * 
     */
    public GetPublishedPostResponse createGetPublishedPostResponse() {
        return new GetPublishedPostResponse();
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
     * Create an instance of {@link GetPublishedPost }
     * 
     */
    public GetPublishedPost createGetPublishedPost() {
        return new GetPublishedPost();
    }

    /**
     * Create an instance of {@link IsExistUserResponse }
     * 
     */
    public IsExistUserResponse createIsExistUserResponse() {
        return new IsExistUserResponse();
    }

    /**
     * Create an instance of {@link GetUnpublishedPost }
     * 
     */
    public GetUnpublishedPost createGetUnpublishedPost() {
        return new GetUnpublishedPost();
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
     * Create an instance of {@link UserBean }
     * 
     */
    public UserBean createUserBean() {
        return new UserBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExistUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "isExistUser")
    public JAXBElement<IsExistUser> createIsExistUser(IsExistUser value) {
        return new JAXBElement<IsExistUser>(_IsExistUser_QNAME, IsExistUser.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPublishedPostResponse")
    public JAXBElement<GetPublishedPostResponse> createGetPublishedPostResponse(GetPublishedPostResponse value) {
        return new JAXBElement<GetPublishedPostResponse>(_GetPublishedPostResponse_QNAME, GetPublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKomentarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getKomentarResponse")
    public JAXBElement<GetKomentarResponse> createGetKomentarResponse(GetKomentarResponse value) {
        return new JAXBElement<GetKomentarResponse>(_GetKomentarResponse_QNAME, GetKomentarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getUnpublishedPostResponse")
    public JAXBElement<GetUnpublishedPostResponse> createGetUnpublishedPostResponse(GetUnpublishedPostResponse value) {
        return new JAXBElement<GetUnpublishedPostResponse>(_GetUnpublishedPostResponse_QNAME, GetUnpublishedPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "searchPostResponse")
    public JAXBElement<SearchPostResponse> createSearchPostResponse(SearchPostResponse value) {
        return new JAXBElement<SearchPostResponse>(_SearchPostResponse_QNAME, SearchPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKomentar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getKomentar")
    public JAXBElement<GetKomentar> createGetKomentar(GetKomentar value) {
        return new JAXBElement<GetKomentar>(_GetKomentar_QNAME, GetKomentar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExistUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "isExistUserResponse")
    public JAXBElement<IsExistUserResponse> createIsExistUserResponse(IsExistUserResponse value) {
        return new JAXBElement<IsExistUserResponse>(_IsExistUserResponse_QNAME, IsExistUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getUnpublishedPost")
    public JAXBElement<GetUnpublishedPost> createGetUnpublishedPost(GetUnpublishedPost value) {
        return new JAXBElement<GetUnpublishedPost>(_GetUnpublishedPost_QNAME, GetUnpublishedPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "searchPost")
    public JAXBElement<SearchPost> createSearchPost(SearchPost value) {
        return new JAXBElement<SearchPost>(_SearchPost_QNAME, SearchPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPublishedPost")
    public JAXBElement<GetPublishedPost> createGetPublishedPost(GetPublishedPost value) {
        return new JAXBElement<GetPublishedPost>(_GetPublishedPost_QNAME, GetPublishedPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

}
