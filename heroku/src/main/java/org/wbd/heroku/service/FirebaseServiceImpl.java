package org.wbd.heroku.service;

import java.util.List;

import org.wbd.heroku.helper.Comment;
import org.wbd.heroku.helper.Post;
import org.wbd.heroku.helper.User;

public class FirebaseServiceImpl implements FirebaseService {

	@Override
	public boolean addPost(String judul, String konten, String tanggal) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean addUser(String name, String email, String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editUser(int id, String name, String email, String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addComment(String name, String email, String kontent) {
		// TODO Auto-generated method stub
		return false;
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
