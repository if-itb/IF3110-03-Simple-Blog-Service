package org.wbd.heroku.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	/**
	 * Code adalah suatu cara untuk menyaring post apa saja yang diinginkan
	 * code adalah sebuah int yang berukuran 4 bit, dengan struktur
	 * 3210
	 * abcd
	 * a - mengambil post yang deleted 
	 * b - mengambil post yang not deleted
	 * c - mengambil post yang published
	 * d - mengambil post yang not published
	 * code terdiri dari beberapa kemungkinan yaitu, 
	 * 1111 (15) - seluruh post yang ada
	 * 1011 (11) - post yang deleted
	 * 0111 (7)  - post yang belum dihapus, 
	 * 1110 (14) - post yang sudah di publish, etc.
	 * @param code
	 */
	public List<Post> listPost(int code) {
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
				the_post.setId(chainz);
				the_post.setDeleted(post.getBoolean("deleted"));
				the_post.setPublished(post.getBoolean("published"));
				if ((the_post.getMask() & code) > 0)
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
	public boolean editPost(String id, String judul, String konten,
			String tanggal) {
		Firebase fire = myFirebase.child(POST_PATH).child(id);
		fire.child("judul").setValue(judul);
		fire.child("konten").setValue(konten);
		fire.child("tanggal").setValue(tanggal);
		fire.child("published").setValue(false);

		return true;
	}

	@Override
	public boolean setPostDelete(String id, boolean status) {
		myFirebase.child(POST_PATH).child(id).child("deleted").setValue(status);
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
	public boolean setPostPublish(String id, boolean status) {
		myFirebase.child(POST_PATH).child(id).child("published")
				.setValue(status);
		return true;
	}

	@Override
	public boolean addUser(String username, String password, String name,
			String email, int role) {
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

			JSONObject firaga = new JSONObject(fira);
			Iterator<String> firaja = firaga.keys();
			List<User> result = new ArrayList<User>();
			while (firaja.hasNext()) {
				String chainz = firaja.next();
				JSONObject user = firaga.getJSONObject(chainz);
				User the_user = new User();
				the_user.setId(chainz);
				the_user.setEmail(user.getString("email"));
				the_user.setUsername(user.getString("username"));
				the_user.setPassword(user.getString("password"));
				the_user.setNama(user.getString("nama"));
				the_user.setRole(user.getInt("role"));

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
	public boolean editUser(String id, String username, String password,
			String name, String email, int role) {
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
		try {
			URL inferno = new URL(FIREBASE_URL + COMMENT_PATH + ".json");
			URLConnection fire = inferno.openConnection();
			JSONTokener fira = new JSONTokener(fire.getInputStream());

			JSONObject firaga = new JSONObject(fira);
			Iterator<String> firaja = firaga.keys();
			List<Comment> result = new ArrayList<Comment>();
			while (firaja.hasNext()) {
				String chainz = firaja.next();
				JSONObject comment = firaga.getJSONObject(chainz);
				Comment the_comment = new Comment();
				the_comment.setId(chainz);
				the_comment.setNama(comment.getString("nama"));
				the_comment.setEmail(comment.getString("email"));
				the_comment.setKonten(comment.getString("konten"));
				the_comment.setTanggal(comment.getString("tanggal"));
				the_comment.setId_post(comment.getString("id_post"));

				result.add(the_comment);
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
	public boolean deleteComment(String id) {
		Firebase firebaseSpecificComment = myFirebase.child(COMMENT_PATH)
				.child(id);
		firebaseSpecificComment.removeValue();

		return true;
	}

	@Override
	public List<Post> search(String query) {
		List<Post> inferno = listPost(6);
		List<Post> result = new ArrayList<Post>();
		for (Post p : inferno) {
			if (p.getJudul().contains(query) || p.getKonten().contains(query))
				result.add(p);
		}
		// TODO Auto-generated method stub
		return result;
	}

}
