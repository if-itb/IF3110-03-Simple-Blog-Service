package org.wbd.heroku.service;

import java.util.List;

import org.wbd.heroku.helper.Comment;
import org.wbd.heroku.helper.Post;
import org.wbd.heroku.helper.User;

import com.firebase.client.Firebase;

public class FirebaseServiceImpl implements FirebaseService {
	private static final String FIREBASE_URL = "https://flickering-inferno-5419.firebaseio.com/";
	private static final String USER_PATH = "user";
	private static final String COMMENT_PATH = "comment";
	private static final String POST_PATH = "post";

	private Firebase myFirebase;

	public FirebaseServiceImpl() {
		myFirebase = new Firebase(FIREBASE_URL);
	}

	@Override
	public boolean addPost(String judul, String konten, String tanggal,
			String idAuthor) {
		Post newPost = new Post();
		newPost.setJudul(judul);
		newPost.setKonten(konten);
		newPost.setTanggal(tanggal);
		newPost.setId_author(idAuthor);
		newPost.setDeleted(false);
		newPost.setPublished(false);

		Firebase firebasePost = myFirebase.child(POST_PATH);
		firebasePost.push().setValue(newPost);
		
		return true;
	}

	@Override
	public List<Post> listPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editPost(int id, String judul, String konten, String tanggal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean publishPost(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String username, String password, String name, String email, String role) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setNama(name);
		newUser.setNama(email);
		newUser.setRole(role);
		
		Firebase firebaseUser = myFirebase.child(USER_PATH);
		firebaseUser.push().setValue(newUser);
		
		return true;
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editUser(String id, String username, String password, String name, String email, String role) {
		User editedUser = new User();
		editedUser.setUsername(username);
		editedUser.setPassword(password);
		editedUser.setNama(name);
		editedUser.setNama(email);
		editedUser.setRole(role);

		Firebase firebaseSpecificUser = myFirebase.child(USER_PATH).child(id);
		firebaseSpecificUser.setValue(editedUser);
		
		return true;
	}

	@Override
	public boolean deleteUser(String id) {
		Firebase firebaseSpecificUser = myFirebase.child(USER_PATH).child(id);
		firebaseSpecificUser.removeValue();
		
		return true;
	}

	@Override
	public boolean addComment(String name, String email, String kontent,
			String tanggal, String idPost) {
		Comment newComment = new Comment();
		newComment.setNama(name);
		newComment.setEmail(email);
		newComment.setKonten(kontent);
		newComment.setTanggal(tanggal);
		newComment.setId_post(idPost);

		Firebase firebaseComment = myFirebase.child(COMMENT_PATH);
		firebaseComment.push().setValue(newComment);
		
		return true;
	}

	@Override
	public List<Comment> listComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
