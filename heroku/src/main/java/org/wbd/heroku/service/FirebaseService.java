package org.wbd.heroku.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.wbd.heroku.helper.Comment;
import org.wbd.heroku.helper.Post;
import org.wbd.heroku.helper.User;


@WebService(serviceName = "DatabaseSimpleBlogService")
public interface FirebaseService {
	@WebMethod(operationName = "addPost")
	boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "idAuthor")String idAuthor);
	@WebMethod(operationName = "listPost")
	List<Post> listPost(@WebParam(name = "code") int code);
	@WebMethod(operationName = "editPost")
	boolean editPost(@WebParam(name = "id") String id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal);
	@WebMethod(operationName = "setPostDelete")
	boolean setPostDelete(@WebParam(name = "id") String id, @WebParam(name = "status") boolean status);
	@WebMethod(operationName = "pulverizePost")
	boolean pulverizePost(@WebParam(name = "id") String id);
	@WebMethod(operationName = "setPostPublish")
	boolean setPostPublish(@WebParam(name = "id") String id, @WebParam(name = "status") boolean status);
	@WebMethod(operationName = "getPost")
	Post getPost(@WebParam(name = "id") String id);
    
	@WebMethod(operationName = "addUser")
	boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "role") int role);
	@WebMethod(operationName = "listUser")
	List<User> listUser();
	@WebMethod(operationName = "editUser")
	boolean editUser(@WebParam(name = "id") String id, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "role") int role);
	@WebMethod(operationName = "deleteUser")
	boolean deleteUser(@WebParam(name = "id") String id);
	
	@WebMethod(operationName = "addComment")
	boolean addComment(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "kontent") String kontent, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "idPost") String idPost);
	@WebMethod(operationName = "listComment")
	List<Comment> listComment();
	@WebMethod(operationName = "deleteComment")
	boolean deleteComment(@WebParam(name = "id") String id);
	
	@WebMethod(operationName = "search")
	List<Post> search(@WebParam(name = "query") String query);
}
