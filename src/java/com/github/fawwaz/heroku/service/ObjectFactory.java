
package com.github.fawwaz.heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.github.fawwaz.heroku.service package. 
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

    private final static QName _PublishPost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "publishPost");
    private final static QName _GetAllPostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getAllPostResponse");
    private final static QName _PublishPostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "publishPostResponse");
    private final static QName _UpdatePost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "updatePost");
    private final static QName _AddComment_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "addComment");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "updateUserResponse");
    private final static QName _ListComment_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "listComment");
    private final static QName _DeleteComment_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deleteComment");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deletePostResponse");
    private final static QName _GetUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getUser");
    private final static QName _GetAllPost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getAllPost");
    private final static QName _GetSemuaUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getSemuaUserResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getUserResponse");
    private final static QName _DeletePost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deletePost");
    private final static QName _SearchPost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "searchPost");
    private final static QName _InterruptedException_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "InterruptedException");
    private final static QName _SearchPostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "searchPostResponse");
    private final static QName _ListUnpublishedPostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "listUnpublishedPostResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "addPostResponse");
    private final static QName _GetSemuaUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getSemuaUser");
    private final static QName _ListCommentResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "listCommentResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deleteUserResponse");
    private final static QName _GetAllUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getAllUser");
    private final static QName _DeleteUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deleteUser");
    private final static QName _CreateUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "createUser");
    private final static QName _DeleteCommentResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "deleteCommentResponse");
    private final static QName _ListUnpublishedPost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "listUnpublishedPost");
    private final static QName _CreateUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "createUserResponse");
    private final static QName _UpdatePostResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "updatePostResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "addCommentResponse");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "getAllUserResponse");
    private final static QName _AddPost_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "addPost");
    private final static QName _UpdateUser_QNAME = new QName("http://service.heroku.fawwaz.github.com/", "updateUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.fawwaz.heroku.service
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
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link DeleteComment }
     * 
     */
    public DeleteComment createDeleteComment() {
        return new DeleteComment();
    }

    /**
     * Create an instance of {@link GetAllPost }
     * 
     */
    public GetAllPost createGetAllPost() {
        return new GetAllPost();
    }

    /**
     * Create an instance of {@link GetSemuaUserResponse }
     * 
     */
    public GetSemuaUserResponse createGetSemuaUserResponse() {
        return new GetSemuaUserResponse();
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
     * Create an instance of {@link ListUnpublishedPostResponse }
     * 
     */
    public ListUnpublishedPostResponse createListUnpublishedPostResponse() {
        return new ListUnpublishedPostResponse();
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
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
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
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link ListUnpublishedPost }
     * 
     */
    public ListUnpublishedPost createListUnpublishedPost() {
        return new ListUnpublishedPost();
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
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link AddPostResponse }
     * 
     */
    public AddPostResponse createAddPostResponse() {
        return new AddPostResponse();
    }

    /**
     * Create an instance of {@link GetSemuaUser }
     * 
     */
    public GetSemuaUser createGetSemuaUser() {
        return new GetSemuaUser();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link DeleteCommentResponse }
     * 
     */
    public DeleteCommentResponse createDeleteCommentResponse() {
        return new DeleteCommentResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "publishPost")
    public JAXBElement<PublishPost> createPublishPost(PublishPost value) {
        return new JAXBElement<PublishPost>(_PublishPost_QNAME, PublishPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getAllPostResponse")
    public JAXBElement<GetAllPostResponse> createGetAllPostResponse(GetAllPostResponse value) {
        return new JAXBElement<GetAllPostResponse>(_GetAllPostResponse_QNAME, GetAllPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "publishPostResponse")
    public JAXBElement<PublishPostResponse> createPublishPostResponse(PublishPostResponse value) {
        return new JAXBElement<PublishPostResponse>(_PublishPostResponse_QNAME, PublishPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "updatePost")
    public JAXBElement<UpdatePost> createUpdatePost(UpdatePost value) {
        return new JAXBElement<UpdatePost>(_UpdatePost_QNAME, UpdatePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deleteComment")
    public JAXBElement<DeleteComment> createDeleteComment(DeleteComment value) {
        return new JAXBElement<DeleteComment>(_DeleteComment_QNAME, DeleteComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getAllPost")
    public JAXBElement<GetAllPost> createGetAllPost(GetAllPost value) {
        return new JAXBElement<GetAllPost>(_GetAllPost_QNAME, GetAllPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSemuaUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getSemuaUserResponse")
    public JAXBElement<GetSemuaUserResponse> createGetSemuaUserResponse(GetSemuaUserResponse value) {
        return new JAXBElement<GetSemuaUserResponse>(_GetSemuaUserResponse_QNAME, GetSemuaUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "searchPost")
    public JAXBElement<SearchPost> createSearchPost(SearchPost value) {
        return new JAXBElement<SearchPost>(_SearchPost_QNAME, SearchPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterruptedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "InterruptedException")
    public JAXBElement<InterruptedException> createInterruptedException(InterruptedException value) {
        return new JAXBElement<InterruptedException>(_InterruptedException_QNAME, InterruptedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "searchPostResponse")
    public JAXBElement<SearchPostResponse> createSearchPostResponse(SearchPostResponse value) {
        return new JAXBElement<SearchPostResponse>(_SearchPostResponse_QNAME, SearchPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUnpublishedPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "listUnpublishedPostResponse")
    public JAXBElement<ListUnpublishedPostResponse> createListUnpublishedPostResponse(ListUnpublishedPostResponse value) {
        return new JAXBElement<ListUnpublishedPostResponse>(_ListUnpublishedPostResponse_QNAME, ListUnpublishedPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSemuaUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getSemuaUser")
    public JAXBElement<GetSemuaUser> createGetSemuaUser(GetSemuaUser value) {
        return new JAXBElement<GetSemuaUser>(_GetSemuaUser_QNAME, GetSemuaUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getAllUser")
    public JAXBElement<GetAllUser> createGetAllUser(GetAllUser value) {
        return new JAXBElement<GetAllUser>(_GetAllUser_QNAME, GetAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "deleteCommentResponse")
    public JAXBElement<DeleteCommentResponse> createDeleteCommentResponse(DeleteCommentResponse value) {
        return new JAXBElement<DeleteCommentResponse>(_DeleteCommentResponse_QNAME, DeleteCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUnpublishedPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "listUnpublishedPost")
    public JAXBElement<ListUnpublishedPost> createListUnpublishedPost(ListUnpublishedPost value) {
        return new JAXBElement<ListUnpublishedPost>(_ListUnpublishedPost_QNAME, ListUnpublishedPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "updatePostResponse")
    public JAXBElement<UpdatePostResponse> createUpdatePostResponse(UpdatePostResponse value) {
        return new JAXBElement<UpdatePostResponse>(_UpdatePostResponse_QNAME, UpdatePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "getAllUserResponse")
    public JAXBElement<GetAllUserResponse> createGetAllUserResponse(GetAllUserResponse value) {
        return new JAXBElement<GetAllUserResponse>(_GetAllUserResponse_QNAME, GetAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.fawwaz.github.com/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

}
