/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package undeclared.service;

import java.util.List;
import undeclared.mavenproject1.Comment;
import undeclared.mavenproject1.Post;
import undeclared.mavenproject1.TestService;
import undeclared.mavenproject1.TestService_Service;
import undeclared.mavenproject1.User;

/**
 *
 * @author Gilang
 */
public class Service {

	public static boolean addComment(int postId, String nama, String email, String content) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.addComment(postId, nama, email, content);
	}

	public static boolean addPost(String judul, String konten, String tanggal) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.addPost(judul, konten, tanggal);
	}

	public static boolean deleteComment(int id) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.deleteComment(id);
	}

	public static boolean deletePost(int id) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.deletePost(id);
	}

	public static boolean editPost(int id, String judul, String konten, String tanggal) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.editPost(id, judul, konten, tanggal);
	}

	public static List<Comment> listComment(int postId) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.listComment(postId);
	}

	public static List<Post> listDeletePost(boolean deleted) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.listDeletePost(deleted);
	}

	public static List<Post> listPost() {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.listPost();
	}

	public static List<Post> listPublishPost(boolean published) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.listPublishPost(published);
	}

	public static List<User> listUser() {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.listUser();
	}

	public static boolean publishPost(int id) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.publishPost(id);
	}

	public static boolean restorePost(int id) {
		TestService_Service service = new TestService_Service();
		TestService port = service.getTestServicePort();
		return port.restorePost(id);
	}

	public static boolean addUser(String nama, String email, int role, String password) {
		undeclared.mavenproject1.TestService_Service service = new undeclared.mavenproject1.TestService_Service();
		undeclared.mavenproject1.TestService port = service.getTestServicePort();
		return port.addUser(nama, email, role, password);
	}

	public static boolean editUser(String nama, int role, String email) {
		undeclared.mavenproject1.TestService_Service service = new undeclared.mavenproject1.TestService_Service();
		undeclared.mavenproject1.TestService port = service.getTestServicePort();
		return port.editUser(nama, role, email);
	}

	public static boolean deleteUser(java.lang.String nama) {
		undeclared.mavenproject1.TestService_Service service = new undeclared.mavenproject1.TestService_Service();
		undeclared.mavenproject1.TestService port = service.getTestServicePort();
		return port.deleteUser(nama);
	}

	public static List<Post> search(String query) {
		undeclared.mavenproject1.TestService_Service service = new undeclared.mavenproject1.TestService_Service();
		undeclared.mavenproject1.TestService port = service.getTestServicePort();
		return port.search(query);
	}
	
}
