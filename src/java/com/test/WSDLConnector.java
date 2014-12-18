package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yanfa
 */
public class WSDLConnector {

	public static Boolean addComment(java.lang.String nama, java.lang.String email, java.lang.String konten, java.lang.String idPost) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.addComment(nama, email, konten, idPost);
	}

	public static Boolean addPost(java.lang.String judul, java.lang.String konten, java.lang.String tanggal) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.addPost(judul, konten, tanggal);
	}

	public static Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String role) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.addUser(username, password, nama, email, role);
	}

	public static Boolean createPost(java.lang.String judulPost, java.lang.String konten, java.lang.String date) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.createPost(judulPost, konten, date);
	}

	public static Boolean deleteComment(java.lang.String idPost, java.lang.String id) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.deleteComment(idPost, id);
	}

	public static Boolean deletePost(java.lang.String id) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.deletePost(id);
	}

	public static Boolean deleteUser(java.lang.String id) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.deleteUser(id);
	}

	public static Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String ikonten, java.lang.String tanggal) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.editPost(id, judul, ikonten, tanggal);
	}

	public static Boolean editUser(java.lang.String username, java.lang.String password, java.lang.String id, java.lang.String nama, java.lang.String role, java.lang.String email) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.editUser(username, password, id, nama, role, email);
	}

	public static String getData(java.lang.String arg0) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.getData(arg0);
	}

	public static java.util.List<org.chamerling.heroku.service.CommentModel> listComment(java.lang.String arg0) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.listComment(arg0);
	}

	public static java.util.List<org.chamerling.heroku.service.PostModel> listPost() {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.listPost();
	}

	public static Boolean publishPost(java.lang.String id) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.publishPost(id);
	}

	public static java.util.List<org.chamerling.heroku.service.PostModel> search(java.lang.String query) {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.search(query);
	}

	public static java.util.List<org.chamerling.heroku.service.UserModel> listUser() {
		org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
		org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
		return port.listUser();
	}
	
	
	
}
