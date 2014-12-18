
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

    private final static QName _AddComment_QNAME = new QName("http://service.heroku.chamerling.org/", "AddComment");
    private final static QName _Login_QNAME = new QName("http://service.heroku.chamerling.org/", "Login");
    private final static QName _IOException_QNAME = new QName("http://service.heroku.chamerling.org/", "IOException");
    private final static QName _PublishPost_QNAME = new QName("http://service.heroku.chamerling.org/", "PublishPost");
    private final static QName _GetPublishedPost_QNAME = new QName("http://service.heroku.chamerling.org/", "GetPublishedPost");
    private final static QName _RecoverPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "RecoverPostResponse");
    private final static QName _AddPost_QNAME = new QName("http://service.heroku.chamerling.org/", "addPost");
    private final static QName _UpdateUser_QNAME = new QName("http://service.heroku.chamerling.org/", "updateUser");
    private final static QName _JSONException_QNAME = new QName("http://service.heroku.chamerling.org/", "JSONException");
    private final static QName _GetPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetPostResponse");
    private final static QName _SearchResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "SearchResponse");
    private final static QName _DelUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "delUserResponse");
    private final static QName _GetAllCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetAllCommentResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "LoginResponse");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "DeletePostResponse");
    private final static QName _GetUnpublishedPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetUnpublishedPostResponse");
    private final static QName _AddNewPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "AddNewPostResponse");
    private final static QName _GetAllComment_QNAME = new QName("http://service.heroku.chamerling.org/", "GetAllComment");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "AddCommentResponse");
    private final static QName _RecoverPost_QNAME = new QName("http://service.heroku.chamerling.org/", "RecoverPost");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addPostResponse");
    private final static QName _GetAllUser_QNAME = new QName("http://service.heroku.chamerling.org/", "GetAllUser");
    private final static QName _DeletePost_QNAME = new QName("http://service.heroku.chamerling.org/", "DeletePost");
    private final static QName _GetDeletedPost_QNAME = new QName("http://service.heroku.chamerling.org/", "GetDeletedPost");
    private final static QName _ReadUser_QNAME = new QName("http://service.heroku.chamerling.org/", "readUser");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetAllUserResponse");
    private final static QName _GetPost_QNAME = new QName("http://service.heroku.chamerling.org/", "GetPost");
    private final static QName _MalformedURLException_QNAME = new QName("http://service.heroku.chamerling.org/", "MalformedURLException");
    private final static QName _GetDeletedPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetDeletedPostResponse");
    private final static QName _AddUser_QNAME = new QName("http://service.heroku.chamerling.org/", "addUser");
    private final static QName _PublishPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "PublishPostResponse");
    private final static QName _UpdatePost_QNAME = new QName("http://service.heroku.chamerling.org/", "UpdatePost");
    private final static QName _UpdatePostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "UpdatePostResponse");
    private final static QName _GetUnpublishedPost_QNAME = new QName("http://service.heroku.chamerling.org/", "GetUnpublishedPost");
    private final static QName _ReadUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "readUserResponse");
    private final static QName _GetPublishedPostResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "GetPublishedPostResponse");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "addUserResponse");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "updateUserResponse");
    private final static QName _Search_QNAME = new QName("http://service.heroku.chamerling.org/", "Search");
    private final static QName _AddNewPost_QNAME = new QName("http://service.heroku.chamerling.org/", "AddNewPost");
    private final static QName _DelUser_QNAME = new QName("http://service.heroku.chamerling.org/", "delUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.chamerling.heroku.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDeletedPostResponse }
     * 
     */
    public GetDeletedPostResponse createGetDeletedPostResponse() {
        return new GetDeletedPostResponse();
    }

    /**
     * Create an instance of {@link MalformedURLException }
     * 
     */
    public MalformedURLException createMalformedURLException() {
        return new MalformedURLException();
    }

    /**
     * Create an instance of {@link UpdatePostResponse }
     * 
     */
    public UpdatePostResponse createUpdatePostResponse() {
        return new UpdatePostResponse();
    }

    /**
     * Create an instance of {@link PublishPostResponse }
     * 
     */
    public PublishPostResponse createPublishPostResponse() {
        return new PublishPostResponse();
    }

    /**
     * Create an instance of {@link UpdatePost }
     * 
     */
    public UpdatePost createUpdatePost() {
        return new UpdatePost();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link GetPost }
     * 
     */
    public GetPost createGetPost() {
        return new GetPost();
    }

    /**
     * Create an instance of {@link ReadUser }
     * 
     */
    public ReadUser createReadUser() {
        return new ReadUser();
    }

    /**
     * Create an instance of {@link DelUser }
     * 
     */
    public DelUser createDelUser() {
        return new DelUser();
    }

    /**
     * Create an instance of {@link AddNewPost }
     * 
     */
    public AddNewPost createAddNewPost() {
        return new AddNewPost();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link ReadUserResponse }
     * 
     */
    public ReadUserResponse createReadUserResponse() {
        return new ReadUserResponse();
    }

    /**
     * Create an instance of {@link GetUnpublishedPost }
     * 
     */
    public GetUnpublishedPost createGetUnpublishedPost() {
        return new GetUnpublishedPost();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link GetPublishedPostResponse }
     * 
     */
    public GetPublishedPostResponse createGetPublishedPostResponse() {
        return new GetPublishedPostResponse();
    }

    /**
     * Create an instance of {@link AddNewPostResponse }
     * 
     */
    public AddNewPostResponse createAddNewPostResponse() {
        return new AddNewPostResponse();
    }

    /**
     * Create an instance of {@link DeletePostResponse }
     * 
     */
    public DeletePostResponse createDeletePostResponse() {
        return new DeletePostResponse();
    }

    /**
     * Create an instance of {@link GetUnpublishedPostResponse }
     * 
     */
    public GetUnpublishedPostResponse createGetUnpublishedPostResponse() {
        return new GetUnpublishedPostResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetAllComment }
     * 
     */
    public GetAllComment createGetAllComment() {
        return new GetAllComment();
    }

    /**
     * Create an instance of {@link GetPublishedPost }
     * 
     */
    public GetPublishedPost createGetPublishedPost() {
        return new GetPublishedPost();
    }

    /**
     * Create an instance of {@link RecoverPostResponse }
     * 
     */
    public RecoverPostResponse createRecoverPostResponse() {
        return new RecoverPostResponse();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link JSONException }
     * 
     */
    public JSONException createJSONException() {
        return new JSONException();
    }

    /**
     * Create an instance of {@link PublishPost }
     * 
     */
    public PublishPost createPublishPost() {
        return new PublishPost();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetAllCommentResponse }
     * 
     */
    public GetAllCommentResponse createGetAllCommentResponse() {
        return new GetAllCommentResponse();
    }

    /**
     * Create an instance of {@link DelUserResponse }
     * 
     */
    public DelUserResponse createDelUserResponse() {
        return new DelUserResponse();
    }

    /**
     * Create an instance of {@link GetPostResponse }
     * 
     */
    public GetPostResponse createGetPostResponse() {
        return new GetPostResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link DeletePost }
     * 
     */
    public DeletePost createDeletePost() {
        return new DeletePost();
    }

    /**
     * Create an instance of {@link GetDeletedPost }
     * 
     */
    public GetDeletedPost createGetDeletedPost() {
        return new GetDeletedPost();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link RecoverPost }
     * 
     */
    public RecoverPost createRecoverPost() {
        return new RecoverPost();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "AddComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "Login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "PublishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetPublishedPost")
    public JAXBElement<GetPublishedPost> createGetPublishedPost(GetPublishedPost value) {
        return new JAXBElement<GetPublishedPost>(_GetPublishedPost_QNAME, GetPublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecoverPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "RecoverPostResponse")
    public JAXBElement<RecoverPostResponse> createRecoverPostResponse(RecoverPostResponse value) {
        return new JAXBElement<RecoverPostResponse>(_RecoverPostResponse_QNAME, RecoverPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link JSONException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "JSONException")
    public JAXBElement<JSONException> createJSONException(JSONException value) {
        return new JAXBElement<JSONException>(_JSONException_QNAME, JSONException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "SearchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetAllCommentResponse")
    public JAXBElement<GetAllCommentResponse> createGetAllCommentResponse(GetAllCommentResponse value) {
        return new JAXBElement<GetAllCommentResponse>(_GetAllCommentResponse_QNAME, GetAllCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "LoginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "DeletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetUnpublishedPostResponse")
    public JAXBElement<GetUnpublishedPostResponse> createGetUnpublishedPostResponse(GetUnpublishedPostResponse value) {
        return new JAXBElement<GetUnpublishedPostResponse>(_GetUnpublishedPostResponse_QNAME, GetUnpublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "AddNewPostResponse")
    public JAXBElement<AddNewPostResponse> createAddNewPostResponse(AddNewPostResponse value) {
        return new JAXBElement<AddNewPostResponse>(_AddNewPostResponse_QNAME, AddNewPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetAllComment")
    public JAXBElement<GetAllComment> createGetAllComment(GetAllComment value) {
        return new JAXBElement<GetAllComment>(_GetAllComment_QNAME, GetAllComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "AddCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecoverPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "RecoverPost")
    public JAXBElement<RecoverPost> createRecoverPost(RecoverPost value) {
        return new JAXBElement<RecoverPost>(_RecoverPost_QNAME, RecoverPost.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetAllUser")
    public JAXBElement<GetAllUser> createGetAllUser(GetAllUser value) {
        return new JAXBElement<GetAllUser>(_GetAllUser_QNAME, GetAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "DeletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetDeletedPost")
    public JAXBElement<GetDeletedPost> createGetDeletedPost(GetDeletedPost value) {
        return new JAXBElement<GetDeletedPost>(_GetDeletedPost_QNAME, GetDeletedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "readUser")
    public JAXBElement<ReadUser> createReadUser(ReadUser value) {
        return new JAXBElement<ReadUser>(_ReadUser_QNAME, ReadUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetAllUserResponse")
    public JAXBElement<GetAllUserResponse> createGetAllUserResponse(GetAllUserResponse value) {
        return new JAXBElement<GetAllUserResponse>(_GetAllUserResponse_QNAME, GetAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MalformedURLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "MalformedURLException")
    public JAXBElement<MalformedURLException> createMalformedURLException(MalformedURLException value) {
        return new JAXBElement<MalformedURLException>(_MalformedURLException_QNAME, MalformedURLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetDeletedPostResponse")
    public JAXBElement<GetDeletedPostResponse> createGetDeletedPostResponse(GetDeletedPostResponse value) {
        return new JAXBElement<GetDeletedPostResponse>(_GetDeletedPostResponse_QNAME, GetDeletedPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "PublishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "UpdatePost")
    public JAXBElement<UpdatePost> createUpdatePost(UpdatePost value) {
        return new JAXBElement<UpdatePost>(_UpdatePost_QNAME, UpdatePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "UpdatePostResponse")
    public JAXBElement<UpdatePostResponse> createUpdatePostResponse(UpdatePostResponse value) {
        return new JAXBElement<UpdatePostResponse>(_UpdatePostResponse_QNAME, UpdatePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnpublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetUnpublishedPost")
    public JAXBElement<GetUnpublishedPost> createGetUnpublishedPost(GetUnpublishedPost value) {
        return new JAXBElement<GetUnpublishedPost>(_GetUnpublishedPost_QNAME, GetUnpublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "readUserResponse")
    public JAXBElement<ReadUserResponse> createReadUserResponse(ReadUserResponse value) {
        return new JAXBElement<ReadUserResponse>(_ReadUserResponse_QNAME, ReadUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "GetPublishedPostResponse")
    public JAXBElement<GetPublishedPostResponse> createGetPublishedPostResponse(GetPublishedPostResponse value) {
        return new JAXBElement<GetPublishedPostResponse>(_GetPublishedPostResponse_QNAME, GetPublishedPostResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "Search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "AddNewPost")
    public JAXBElement<AddNewPost> createAddNewPost(AddNewPost value) {
        return new JAXBElement<AddNewPost>(_AddNewPost_QNAME, AddNewPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "delUser")
    public JAXBElement<DelUser> createDelUser(DelUser value) {
        return new JAXBElement<DelUser>(_DelUser_QNAME, DelUser.class, null, value);
    }

}
