
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

    private final static QName _AddPost_QNAME = new QName("http://service.heroku.chamerling.org/", "addPost");
    private final static QName _DelUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "delUserResponse");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllUserResponse");
    private final static QName _HardDelPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "hardDelPostResponse");
    private final static QName _GetAllDeletedResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllDeletedResponse");
    private final static QName _GetDeletedbyAuthorResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getDeletedbyAuthorResponse");
    private final static QName _GetDraftbyAuthorResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getDraftbyAuthorResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addCommentResponse");
    private final static QName _RestorePost_QNAME = new QName("http://service.heroku.chamerling.org/", "restorePost");
    private final static QName _HardDelPost_QNAME = new QName("http://service.heroku.chamerling.org/", "hardDelPost");
    private final static QName _ValidateResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "validateResponse");
    private final static QName _GetAllDeleted_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllDeleted");
    private final static QName _SoftDelPost_QNAME = new QName("http://service.heroku.chamerling.org/", "softDelPost");
    private final static QName _GetAllDraft_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllDraft");
    private final static QName _GetCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getCommentResponse");
    private final static QName _GetPostbyAuthorResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getPostbyAuthorResponse");
    private final static QName _GetAllUser_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllUser");
    private final static QName _EditPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "editPostResponse");
    private final static QName _GetPostbyAuthor_QNAME = new QName("http://service.heroku.chamerling.org/", "getPostbyAuthor");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addPostResponse");
    private final static QName _EditPost_QNAME = new QName("http://service.heroku.chamerling.org/", "editPost");
    private final static QName _GetAllDraftResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllDraftResponse");
    private final static QName _EditUser_QNAME = new QName("http://service.heroku.chamerling.org/", "editUser");
    private final static QName _SearchPost_QNAME = new QName("http://service.heroku.chamerling.org/", "searchPost");
    private final static QName _InterruptedException_QNAME = new QName("http://service.heroku.chamerling.org/", "InterruptedException");
    private final static QName _SearchPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "searchPostResponse");
    private final static QName _EditUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "editUserResponse");
    private final static QName _GetDraftbyAuthor_QNAME = new QName("http://service.heroku.chamerling.org/", "getDraftbyAuthor");
    private final static QName _RestorePostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "restorePostResponse");
    private final static QName _SoftDelPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "softDelPostResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getUserResponse");
    private final static QName _GetDeletedbyAuthor_QNAME = new QName("http://service.heroku.chamerling.org/", "getDeletedbyAuthor");
    private final static QName _GetUser_QNAME = new QName("http://service.heroku.chamerling.org/", "getUser");
    private final static QName _AddUser_QNAME = new QName("http://service.heroku.chamerling.org/", "addUser");
    private final static QName _GetAllPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllPost");
    private final static QName _GetComment_QNAME = new QName("http://service.heroku.chamerling.org/", "getComment");
    private final static QName _Validate_QNAME = new QName("http://service.heroku.chamerling.org/", "validate");
    private final static QName _AddComment_QNAME = new QName("http://service.heroku.chamerling.org/", "addComment");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addUserResponse");
    private final static QName _GetPost_QNAME = new QName("http://service.heroku.chamerling.org/", "getPost");
    private final static QName _GetPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getPostResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "publishPostResponse");
    private final static QName _GetAllPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "getAllPostResponse");
    private final static QName _DelUser_QNAME = new QName("http://service.heroku.chamerling.org/", "delUser");
    private final static QName _PublishPost_QNAME = new QName("http://service.heroku.chamerling.org/", "publishPost");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.chamerling.heroku.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link SoftDelPostResponse }
     * 
     */
    public SoftDelPostResponse createSoftDelPostResponse() {
        return new SoftDelPostResponse();
    }

    /**
     * Create an instance of {@link EditUserResponse }
     * 
     */
    public EditUserResponse createEditUserResponse() {
        return new EditUserResponse();
    }

    /**
     * Create an instance of {@link GetDraftbyAuthor }
     * 
     */
    public GetDraftbyAuthor createGetDraftbyAuthor() {
        return new GetDraftbyAuthor();
    }

    /**
     * Create an instance of {@link RestorePostResponse }
     * 
     */
    public RestorePostResponse createRestorePostResponse() {
        return new RestorePostResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetAllPost }
     * 
     */
    public GetAllPost createGetAllPost() {
        return new GetAllPost();
    }

    /**
     * Create an instance of {@link GetDeletedbyAuthor }
     * 
     */
    public GetDeletedbyAuthor createGetDeletedbyAuthor() {
        return new GetDeletedbyAuthor();
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
     * Create an instance of {@link SearchPostResponse }
     * 
     */
    public SearchPostResponse createSearchPostResponse() {
        return new SearchPostResponse();
    }

    /**
     * Create an instance of {@link SearchPost }
     * 
     */
    public SearchPost createSearchPost() {
        return new SearchPost();
    }

    /**
     * Create an instance of {@link InterruptedException }
     * 
     */
    public InterruptedException createInterruptedException() {
        return new InterruptedException();
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
     * Create an instance of {@link DelUser }
     * 
     */
    public DelUser createDelUser() {
        return new DelUser();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
    }

    /**
     * Create an instance of {@link GetAllPostResponse }
     * 
     */
    public GetAllPostResponse createGetAllPostResponse() {
        return new GetAllPostResponse();
    }

    /**
     * Create an instance of {@link GetComment }
     * 
     */
    public GetComment createGetComment() {
        return new GetComment();
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
     * Create an instance of {@link Validate }
     * 
     */
    public Validate createValidate() {
        return new Validate();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link GetDraftbyAuthorResponse }
     * 
     */
    public GetDraftbyAuthorResponse createGetDraftbyAuthorResponse() {
        return new GetDraftbyAuthorResponse();
    }

    /**
     * Create an instance of {@link HardDelPost }
     * 
     */
    public HardDelPost createHardDelPost() {
        return new HardDelPost();
    }

    /**
     * Create an instance of {@link ValidateResponse }
     * 
     */
    public ValidateResponse createValidateResponse() {
        return new ValidateResponse();
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
     * Create an instance of {@link GetAllDeletedResponse }
     * 
     */
    public GetAllDeletedResponse createGetAllDeletedResponse() {
        return new GetAllDeletedResponse();
    }

    /**
     * Create an instance of {@link GetDeletedbyAuthorResponse }
     * 
     */
    public GetDeletedbyAuthorResponse createGetDeletedbyAuthorResponse() {
        return new GetDeletedbyAuthorResponse();
    }

    /**
     * Create an instance of {@link HardDelPostResponse }
     * 
     */
    public HardDelPostResponse createHardDelPostResponse() {
        return new HardDelPostResponse();
    }

    /**
     * Create an instance of {@link DelUserResponse }
     * 
     */
    public DelUserResponse createDelUserResponse() {
        return new DelUserResponse();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link GetAllDraftResponse }
     * 
     */
    public GetAllDraftResponse createGetAllDraftResponse() {
        return new GetAllDraftResponse();
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
     * Create an instance of {@link GetPostbyAuthor }
     * 
     */
    public GetPostbyAuthor createGetPostbyAuthor() {
        return new GetPostbyAuthor();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link GetAllDraft }
     * 
     */
    public GetAllDraft createGetAllDraft() {
        return new GetAllDraft();
    }

    /**
     * Create an instance of {@link GetCommentResponse }
     * 
     */
    public GetCommentResponse createGetCommentResponse() {
        return new GetCommentResponse();
    }

    /**
     * Create an instance of {@link GetPostbyAuthorResponse }
     * 
     */
    public GetPostbyAuthorResponse createGetPostbyAuthorResponse() {
        return new GetPostbyAuthorResponse();
    }

    /**
     * Create an instance of {@link GetAllDeleted }
     * 
     */
    public GetAllDeleted createGetAllDeleted() {
        return new GetAllDeleted();
    }

    /**
     * Create an instance of {@link SoftDelPost }
     * 
     */
    public SoftDelPost createSoftDelPost() {
        return new SoftDelPost();
    }

    /**
     * Create an instance of {@link EditPostResponse }
     * 
     */
    public EditPostResponse createEditPostResponse() {
        return new EditPostResponse();
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
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "delUserResponse")
    public JAXBElement<DelUserResponse> createDelUserResponse(DelUserResponse value) {
        return new JAXBElement<DelUserResponse>(_DelUserResponse_QNAME, DelUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link HardDelPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "hardDelPostResponse")
    public JAXBElement<HardDelPostResponse> createHardDelPostResponse(HardDelPostResponse value) {
        return new JAXBElement<HardDelPostResponse>(_HardDelPostResponse_QNAME, HardDelPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDeletedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllDeletedResponse")
    public JAXBElement<GetAllDeletedResponse> createGetAllDeletedResponse(GetAllDeletedResponse value) {
        return new JAXBElement<GetAllDeletedResponse>(_GetAllDeletedResponse_QNAME, GetAllDeletedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletedbyAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getDeletedbyAuthorResponse")
    public JAXBElement<GetDeletedbyAuthorResponse> createGetDeletedbyAuthorResponse(GetDeletedbyAuthorResponse value) {
        return new JAXBElement<GetDeletedbyAuthorResponse>(_GetDeletedbyAuthorResponse_QNAME, GetDeletedbyAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDraftbyAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getDraftbyAuthorResponse")
    public JAXBElement<GetDraftbyAuthorResponse> createGetDraftbyAuthorResponse(GetDraftbyAuthorResponse value) {
        return new JAXBElement<GetDraftbyAuthorResponse>(_GetDraftbyAuthorResponse_QNAME, GetDraftbyAuthorResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "restorePost")
    public JAXBElement<RestorePost> createRestorePost(RestorePost value) {
        return new JAXBElement<RestorePost>(_RestorePost_QNAME, RestorePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HardDelPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "hardDelPost")
    public JAXBElement<HardDelPost> createHardDelPost(HardDelPost value) {
        return new JAXBElement<HardDelPost>(_HardDelPost_QNAME, HardDelPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "validateResponse")
    public JAXBElement<ValidateResponse> createValidateResponse(ValidateResponse value) {
        return new JAXBElement<ValidateResponse>(_ValidateResponse_QNAME, ValidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDeleted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllDeleted")
    public JAXBElement<GetAllDeleted> createGetAllDeleted(GetAllDeleted value) {
        return new JAXBElement<GetAllDeleted>(_GetAllDeleted_QNAME, GetAllDeleted.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftDelPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "softDelPost")
    public JAXBElement<SoftDelPost> createSoftDelPost(SoftDelPost value) {
        return new JAXBElement<SoftDelPost>(_SoftDelPost_QNAME, SoftDelPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDraft }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllDraft")
    public JAXBElement<GetAllDraft> createGetAllDraft(GetAllDraft value) {
        return new JAXBElement<GetAllDraft>(_GetAllDraft_QNAME, GetAllDraft.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getCommentResponse")
    public JAXBElement<GetCommentResponse> createGetCommentResponse(GetCommentResponse value) {
        return new JAXBElement<GetCommentResponse>(_GetCommentResponse_QNAME, GetCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostbyAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPostbyAuthorResponse")
    public JAXBElement<GetPostbyAuthorResponse> createGetPostbyAuthorResponse(GetPostbyAuthorResponse value) {
        return new JAXBElement<GetPostbyAuthorResponse>(_GetPostbyAuthorResponse_QNAME, GetPostbyAuthorResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostbyAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPostbyAuthor")
    public JAXBElement<GetPostbyAuthor> createGetPostbyAuthor(GetPostbyAuthor value) {
        return new JAXBElement<GetPostbyAuthor>(_GetPostbyAuthor_QNAME, GetPostbyAuthor.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDraftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllDraftResponse")
    public JAXBElement<GetAllDraftResponse> createGetAllDraftResponse(GetAllDraftResponse value) {
        return new JAXBElement<GetAllDraftResponse>(_GetAllDraftResponse_QNAME, GetAllDraftResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "searchPost")
    public JAXBElement<SearchPost> createSearchPost(SearchPost value) {
        return new JAXBElement<SearchPost>(_SearchPost_QNAME, SearchPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "searchPostResponse")
    public JAXBElement<SearchPostResponse> createSearchPostResponse(SearchPostResponse value) {
        return new JAXBElement<SearchPostResponse>(_SearchPostResponse_QNAME, SearchPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDraftbyAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getDraftbyAuthor")
    public JAXBElement<GetDraftbyAuthor> createGetDraftbyAuthor(GetDraftbyAuthor value) {
        return new JAXBElement<GetDraftbyAuthor>(_GetDraftbyAuthor_QNAME, GetDraftbyAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestorePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "restorePostResponse")
    public JAXBElement<RestorePostResponse> createRestorePostResponse(RestorePostResponse value) {
        return new JAXBElement<RestorePostResponse>(_RestorePostResponse_QNAME, RestorePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftDelPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "softDelPostResponse")
    public JAXBElement<SoftDelPostResponse> createSoftDelPostResponse(SoftDelPostResponse value) {
        return new JAXBElement<SoftDelPostResponse>(_SoftDelPostResponse_QNAME, SoftDelPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletedbyAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getDeletedbyAuthor")
    public JAXBElement<GetDeletedbyAuthor> createGetDeletedbyAuthor(GetDeletedbyAuthor value) {
        return new JAXBElement<GetDeletedbyAuthor>(_GetDeletedbyAuthor_QNAME, GetDeletedbyAuthor.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getComment")
    public JAXBElement<GetComment> createGetComment(GetComment value) {
        return new JAXBElement<GetComment>(_GetComment_QNAME, GetComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Validate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "validate")
    public JAXBElement<Validate> createValidate(Validate value) {
        return new JAXBElement<Validate>(_Validate_QNAME, Validate.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "getAllPostResponse")
    public JAXBElement<GetAllPostResponse> createGetAllPostResponse(GetAllPostResponse value) {
        return new JAXBElement<GetAllPostResponse>(_GetAllPostResponse_QNAME, GetAllPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "delUser")
    public JAXBElement<DelUser> createDelUser(DelUser value) {
        return new JAXBElement<DelUser>(_DelUser_QNAME, DelUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

}
