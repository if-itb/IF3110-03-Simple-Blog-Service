
package simpleblog.heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the simpleblog.heroku.service package. 
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

    private final static QName _GetPost_QNAME = new QName("http://service.heroku.simpleblog/", "getPost");
    private final static QName _GetCommentList_QNAME = new QName("http://service.heroku.simpleblog/", "getCommentList");
    private final static QName _GetPostList_QNAME = new QName("http://service.heroku.simpleblog/", "getPostList");
    private final static QName _GetPostResponse_QNAME = new QName("http://service.heroku.simpleblog/", "getPostResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.heroku.simpleblog/", "getUserResponse");
    private final static QName _GetUser_QNAME = new QName("http://service.heroku.simpleblog/", "getUser");
    private final static QName _GetCommentListResponse_QNAME = new QName("http://service.heroku.simpleblog/", "getCommentListResponse");
    private final static QName _IOException_QNAME = new QName("http://service.heroku.simpleblog/", "IOException");
    private final static QName _GetPostListResponse_QNAME = new QName("http://service.heroku.simpleblog/", "getPostListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: simpleblog.heroku.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPostList }
     * 
     */
    public GetPostList createGetPostList() {
        return new GetPostList();
    }

    /**
     * Create an instance of {@link GetPostResponse }
     * 
     */
    public GetPostResponse createGetPostResponse() {
        return new GetPostResponse();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetPost }
     * 
     */
    public GetPost createGetPost() {
        return new GetPost();
    }

    /**
     * Create an instance of {@link GetCommentList }
     * 
     */
    public GetCommentList createGetCommentList() {
        return new GetCommentList();
    }

    /**
     * Create an instance of {@link GetCommentListResponse }
     * 
     */
    public GetCommentListResponse createGetCommentListResponse() {
        return new GetCommentListResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetPostListResponse }
     * 
     */
    public GetPostListResponse createGetPostListResponse() {
        return new GetPostListResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getPost")
    public JAXBElement<GetPost> createGetPost(GetPost value) {
        return new JAXBElement<GetPost>(_GetPost_QNAME, GetPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getCommentList")
    public JAXBElement<GetCommentList> createGetCommentList(GetCommentList value) {
        return new JAXBElement<GetCommentList>(_GetCommentList_QNAME, GetCommentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getPostList")
    public JAXBElement<GetPostList> createGetPostList(GetPostList value) {
        return new JAXBElement<GetPostList>(_GetPostList_QNAME, GetPostList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getPostResponse")
    public JAXBElement<GetPostResponse> createGetPostResponse(GetPostResponse value) {
        return new JAXBElement<GetPostResponse>(_GetPostResponse_QNAME, GetPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getCommentListResponse")
    public JAXBElement<GetCommentListResponse> createGetCommentListResponse(GetCommentListResponse value) {
        return new JAXBElement<GetCommentListResponse>(_GetCommentListResponse_QNAME, GetCommentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPostListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.simpleblog/", name = "getPostListResponse")
    public JAXBElement<GetPostListResponse> createGetPostListResponse(GetPostListResponse value) {
        return new JAXBElement<GetPostListResponse>(_GetPostListResponse_QNAME, GetPostListResponse.class, null, value);
    }

}
