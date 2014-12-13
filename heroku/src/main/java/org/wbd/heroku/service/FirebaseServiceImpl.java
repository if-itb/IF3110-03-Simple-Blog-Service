package org.wbd.heroku.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.*;
import org.wbd.heroku.helper.Comment;
import org.wbd.heroku.helper.Post;
import org.wbd.heroku.helper.User;

import com.firebase.client.*;

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
		try {
			URL inferno = new URL(FIREBASE_URL + POST_PATH + ".json");
			URLConnection fire = inferno.openConnection();
			JSONTokener fira = new JSONTokener(fire.getInputStream());

			JSONObject firaga = new JSONObject(fira);
			Iterator<String> firaja = firaga.keys();
			List<Post> result = new ArrayList<Post>();
			while (firaja.hasNext()) {
				String chainz = firaja.next();
				JSONObject post = firaga.getJSONObject(chainz);
				Post the_post = new Post(post.getString("judul"),
						post.getString("tanggal"), post.getString("konten"),
						post.getString("id_author"));
				result.add(the_post);
			}

			return result;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editPost(String id, String judul, String konten, String tanggal) {
		Post newPost = new Post();
		newPost.setJudul(judul);
		newPost.setKonten(konten);
		newPost.setTanggal(tanggal);
		newPost.setDeleted(false);
		newPost.setPublished(false);

		Firebase fire = myFirebase.child(POST_PATH).child(id);
		fire.child("judul").setValue(judul);
		fire.child("konten").setValue(konten);
		fire.child("tanggal").setValue(tanggal);
		fire.child("published").setValue(false);

		return true;
	}

	@Override
	public boolean deletePost(String id) {
		myFirebase.child(POST_PATH).child(id).child("deleted").setValue(true);
		return true;
	}
	
	@Override
	/**
	 * Hard delete a post
	 * @param id post
	 * @return true
	 */
	public boolean pulverizePost(String id) {
		myFirebase.child(POST_PATH).child(id).removeValue();
		return true;
	}

	@Override
	public boolean publishPost(String id) {
		myFirebase.child(POST_PATH).child(id).child("published").setValue(true);
		return true;
	}

	@Override
	public boolean addUser(String username, String password, String name,
			String email, String role) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setNama(name);
		newUser.setEmail(email);
		newUser.setRole(role);

		Firebase firebaseUser = myFirebase.child(USER_PATH);
		firebaseUser.push().setValue(newUser);

		return true;
	}

	@Override
	public List<User> listUser() {
		try {
			URL inferno = new URL(FIREBASE_URL + USER_PATH + ".json");
			URLConnection fire = inferno.openConnection();
			JSONTokener fira = new JSONTokener(fire.getInputStream());

			JSONArray firaga = new JSONArray(fira);
			int num_user = firaga.length();
			List<User> result = new ArrayList<User>();
			for (int i = 0; i < num_user; ++i) {
				JSONObject user = firaga.getJSONObject(i);
				User the_user = new User();
				
				the_user.setEmail(user.getString("email"));
				the_user.setUsername(user.getString("username"));
				the_user.setPassword(user.getString("password"));
				the_user.setNama(user.getString("nama"));
				the_user.setRole(user.getString("role"));
				
				result.add(the_user);
			}

			return result;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
