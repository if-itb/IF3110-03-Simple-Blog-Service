package org.wbd.heroku.service;

import java.util.List;

import javax.jws.WebService;

import org.wbd.heroku.helper.Comment;
import org.wbd.heroku.helper.Post;
import org.wbd.heroku.helper.User;


@WebService
public interface FirebaseService {

	boolean addPost(String judul, String konten, String tanggal, String idAuthor);
	List<Post> listPost(int code);
	boolean editPost(String id, String judul, String konten, String tanggal);
	boolean setPostDelete(String id, boolean status);
	boolean pulverizePost(String id);
	boolean setPostPublish(String id, boolean status);
    
	boolean addUser(String username, String password, String name, String email, String role);
	List<User> listUser();
	boolean editUser(String id, String username, String password, String name, String email, String role);
	boolean deleteUser(String id);
	
	boolean addComment(String name, String email, String kontent, String tanggal, String idPost);
	List<Comment> listComment();
	boolean deleteComment(int id);
	
	List<Post> search(String query);
}
