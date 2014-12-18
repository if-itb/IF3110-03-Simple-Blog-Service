
package org.wbd.heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wbd.heroku.service package. 
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

    private final static QName _EditPostResponse_QNAME = new QName("http://service.heroku.wbd.org/", "editPostResponse");
    private final static QName _AddCommentResponse_QNAME = new QName("http://service.heroku.wbd.org/", "addCommentResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://service.heroku.wbd.org/", "deleteUser");
    private final static QName _SetPostPublishResponse_QNAME = new QName("http://service.heroku.wbd.org/", "setPostPublishResponse");
    private final static QName _ListPostCommentResponse_QNAME = new QName("http://service.heroku.wbd.org/", "listPostCommentResponse");
    private final static QName _AddPostResponse_QNAME = new QName("http://service.heroku.wbd.org/", "addPostResponse");
    private final static QName _EditUser_QNAME = new QName("http://service.heroku.wbd.org/", "editUser");
    private final static QName _SetPostDelete_QNAME = new QName("http://service.heroku.wbd.org/", "setPostDelete");
    private final static QName _SearchResponse_QNAME = new QName("http://service.heroku.wbd.org/", "searchResponse");
    private final static QName _ListUserResponse_QNAME = new QName("http://service.heroku.wbd.org/", "listUserResponse");
    private final static QName _DeleteComment_QNAME = new QName("http://service.heroku.wbd.org/", "deleteComment");
    private final static QName _DeletePost_QNAME = new QName("http://service.heroku.wbd.org/", "deletePost");
    private final static QName _ListCommentResponse_QNAME = new QName("http://service.heroku.wbd.org/", "listCommentResponse");
    private final static QName _GetPost_QNAME = new QName("http://service.heroku.wbd.org/", "getPost");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.heroku.wbd.org/", "deleteUserResponse");
    private final static QName _EditUserResponse_QNAME = new QName("http://service.heroku.wbd.org/", "editUserResponse");
    private final static QName _Search_QNAME = new QName("http://service.heroku.wbd.org/", "search");
    private final static QName _DeleteCommentResponse_QNAME = new QName("http://service.heroku.wbd.org/", "deleteCommentResponse");
    private final static QName _AddComment_QNAME = new QName("http://service.heroku.wbd.org/", "addComment");
    private final static QName _GetPostResponse_QNAME = new QName("http://service.heroku.wbd.org/", "getPostResponse");
    private final static QName _ListPost_QNAME = new QName("http://service.heroku.wbd.org/", "listPost");
    private final static QName _EditPost_QNAME = new QName("http://service.heroku.wbd.org/", "editPost");
    private final static QName _SetPostPublish_QNAME = new QName("http://service.heroku.wbd.org/", "setPostPublish");
    private final static QName _AddPost_QNAME = new QName("http://service.heroku.wbd.org/", "addPost");
    private final static QName _SetPostDeleteResponse_QNAME = new QName("http://service.heroku.wbd.org/", "setPostDeleteResponse");
    private final static QName _ListComment_QNAME = new QName("http://service.heroku.wbd.org/", "listComment");
    private final static QName _ListUser_QNAME = new QName("http://service.heroku.wbd.org/", "listUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.heroku.wbd.org/", "addUserResponse");
    private final static QName _AddUser_QNAME = new QName("http://service.heroku.wbd.org/", "addUser");
    private final static QName _ListPostResponse_QNAME = new QName("http://service.heroku.wbd.org/", "listPostResponse");
    private final static QName _ListPostComment_QNAME = new QName("http://service.heroku.wbd.org/", "listPostComment");
    private final static QName _DeletePostResponse_QNAME = new QName("http://service.heroku.wbd.org/", "deletePostResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wbd.heroku.service
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
     * Create an instance of {@link ListPostComment }
     * 
     */
    public ListPostComment createListPostComment() {
        return new ListPostComment();
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
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link GetPostResponse }
     * 
     */
    public GetPostResponse createGetPostResponse() {
        return new GetPostResponse();
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
     * Create an instance of {@link SetPostDeleteResponse }
     * 
     */
    public SetPostDeleteResponse createSetPostDeleteResponse() {
        return new SetPostDeleteResponse();
    }

    /**
     * Create an instance of {@link SetPostPublish }
     * 
     */
    public SetPostPublish createSetPostPublish() {
        return new SetPostPublish();
    }

    /**
     * Create an instance of {@link AddPost }
     * 
     */
    public AddPost createAddPost() {
        return new AddPost();
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
     * Create an instance of {@link SetPostDelete }
     * 
     */
    public SetPostDelete createSetPostDelete() {
        return new SetPostDelete();
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
     * Create an instance of {@link SetPostPublishResponse }
     * 
     */
    public SetPostPublishResponse createSetPostPublishResponse() {
        return new SetPostPublishResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link ListPostCommentResponse }
     * 
     */
    public ListPostCommentResponse createListPostCommentResponse() {
        return new ListPostCommentResponse();
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
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "editPostResponse")
    public JAXBElement<EditPostResponse> createEditPostResponse(EditPostResponse value) {
        return new JAXBElement<EditPostResponse>(_EditPostResponse_QNAME, EditPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPostPublishResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "setPostPublishResponse")
    public JAXBElement<SetPostPublishResponse> createSetPostPublishResponse(SetPostPublishResponse value) {
        return new JAXBElement<SetPostPublishResponse>(_SetPostPublishResponse_QNAME, SetPostPublishResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listPostCommentResponse")
    public JAXBElement<ListPostCommentResponse> createListPostCommentResponse(ListPostCommentResponse value) {
        return new JAXBElement<ListPostCommentResponse>(_ListPostCommentResponse_QNAME, ListPostCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addPostResponse")
    public JAXBElement<AddPostResponse> createAddPostResponse(AddPostResponse value) {
        return new JAXBElement<AddPostResponse>(_AddPostResponse_QNAME, AddPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPostDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "setPostDelete")
    public JAXBElement<SetPostDelete> createSetPostDelete(SetPostDelete value) {
        return new JAXBElement<SetPostDelete>(_SetPostDelete_QNAME, SetPostDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deleteComment")
    public JAXBElement<DeleteComment> createDeleteComment(DeleteComment value) {
        return new JAXBElement<DeleteComment>(_DeleteComment_QNAME, DeleteComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deletePost")
    public JAXBElement<DeletePost> createDeletePost(DeletePost value) {
        return new JAXBElement<DeletePost>(_DeletePost_QNAME, DeletePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listCommentResponse")
    public JAXBElement<ListCommentResponse> createListCommentResponse(ListCommentResponse value) {
        return new JAXBElement<ListCommentResponse>(_ListCommentResponse_QNAME, ListCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "getPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCommentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deleteCommentResponse")
    public JAXBElement<DeleteCommentResponse> createDeleteCommentResponse(DeleteCommentResponse value) {
        return new JAXBElement<DeleteCommentResponse>(_DeleteCommentResponse_QNAME, DeleteCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listPost")
    public JAXBElement<ListPost> createListPost(ListPost value) {
        return new JAXBElement<ListPost>(_ListPost_QNAME, ListPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "editPost")
    public JAXBElement<EditPost> createEditPost(EditPost value) {
        return new JAXBElement<EditPost>(_EditPost_QNAME, EditPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPostPublish }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "setPostPublish")
    public JAXBElement<SetPostPublish> createSetPostPublish(SetPostPublish value) {
        return new JAXBElement<SetPostPublish>(_SetPostPublish_QNAME, SetPostPublish.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addPost")
    public JAXBElement<AddPost> createAddPost(AddPost value) {
        return new JAXBElement<AddPost>(_AddPost_QNAME, AddPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPostDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "setPostDeleteResponse")
    public JAXBElement<SetPostDeleteResponse> createSetPostDeleteResponse(SetPostDeleteResponse value) {
        return new JAXBElement<SetPostDeleteResponse>(_SetPostDeleteResponse_QNAME, SetPostDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listComment")
    public JAXBElement<ListComment> createListComment(ListComment value) {
        return new JAXBElement<ListComment>(_ListComment_QNAME, ListComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listPostResponse")
    public JAXBElement<ListPostResponse> createListPostResponse(ListPostResponse value) {
        return new JAXBElement<ListPostResponse>(_ListPostResponse_QNAME, ListPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "listPostComment")
    public JAXBElement<ListPostComment> createListPostComment(ListPostComment value) {
        return new JAXBElement<ListPostComment>(_ListPostComment_QNAME, ListPostComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.wbd.org/", name = "deletePostResponse")
    public JAXBElement<DeletePostResponse> createDeletePostResponse(DeletePostResponse value) {
        return new JAXBElement<DeletePostResponse>(_DeletePostResponse_QNAME, DeletePostResponse.class, null, value);
    }

}
