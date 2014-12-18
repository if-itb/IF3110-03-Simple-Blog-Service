/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.PenguasaDunia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.datastructure.ServiceComment;
import org.datastructure.ServicePost;
import org.datastructure.ServiceUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.firebase.client.Firebase;

/**
 *
 * @author wira gotama
 */
@WebService(serviceName = "PenguasaDuniaService")
public class PenguasaDuniaService {
	private final String firebaseURl;
	private final Firebase ServicePostsRef;
	private final Firebase ServiceUsersRef;
	private final Firebase ServiceCommentsRef;

	public PenguasaDuniaService() {
		this.firebaseURl = "https://luminous-inferno-4376.firebaseio.com/";
		this.ServicePostsRef = new Firebase(
				"https://luminous-inferno-4376.firebaseio.com/posts/");
		this.ServiceUsersRef = new Firebase(
				"https://luminous-inferno-4376.firebaseio.com/users/");
		this.ServiceCommentsRef = new Firebase(
				"https://luminous-inferno-4376.firebaseio.com/comments/");
	}

	@WebMethod(operationName = "addServicePost")
	public boolean addServicePost(@WebParam(name = "judul") String judul,
			@WebParam(name = "konten") String konten,
			@WebParam(name = "tanggal") String tanggal,
			@WebParam(name = "id_user") String id_user) {
		Map<String, String> ServicePost = new HashMap<String, String>();
		ServicePost.put("deleted", "false");
		ServicePost.put("published", "false");
		ServicePost.put("id_user", id_user);
		ServicePost.put("judul", judul);
		ServicePost.put("konten", konten);
		ServicePost.put("tanggal", tanggal);
		this.ServicePostsRef.push().setValue(ServicePost);
		return true;
	}

	@WebMethod(operationName = "listServicePost")
	public Vector<ServicePost> listServicePost() { // outputnya
		// Vector<ServicePost>
		Vector<ServicePost> list = new Vector<ServicePost>();
		JSONObject json = getJSON(this.firebaseURl + "/posts.json");
		Map<String, Object> map = json;
		if (json != null) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println("Key:" + m.getKey());
				if (m.getKey().charAt(0) == '-') {
					Map<String, String> ServicePost = (Map<String, String>) m
							.getValue();
					String deleted, published, id_ServiceUser, judul, konten, tanggal;
					deleted = ServicePost.get("deleted");
					published = ServicePost.get("published");
					id_ServiceUser = ServicePost.get("id_user");
					judul = ServicePost.get("judul");
					konten = ServicePost.get("konten");
					tanggal = ServicePost.get("tanggal");
					ServicePost temp = new ServicePost(m.getKey(), deleted,
							published, id_ServiceUser, judul, konten, tanggal);
					System.out.println(m.getKey() + " " + deleted + " "
							+ published + " " + id_ServiceUser + " " + judul
							+ " " + konten + " " + tanggal);
					list.add(temp);
				}
			}
		}
		return list;
	}

	@WebMethod(operationName = "editServicePost")
	public boolean editServicePost(
			@WebParam(name = "id_post") String id_ServicePost,
			@WebParam(name = "judul") String judul,
			@WebParam(name = "konten") String konten,
			@WebParam(name = "tanggal") String tanggal) {
		Firebase ServicePost = this.ServicePostsRef.child(id_ServicePost);
		ServicePost.child("judul").setValue(judul);
		ServicePost.child("konten").setValue(konten);
		ServicePost.child("tanggal").setValue(tanggal);
		return true;
	}

	@WebMethod(operationName = "softDeleteServicePost")
	public boolean softDeleteServicePost(String id_ServicePost) {
		this.ServicePostsRef.child(id_ServicePost).child("deleted")
		.setValue("true");
		return true;
	}

	public boolean unsoftDeleteServicePost(String id_ServicePost) {
		this.ServicePostsRef.child(id_ServicePost).child("deleted")
				.setValue("false");
		return true;
	}

	@WebMethod(operationName = "deleteServicePost")
	public boolean deleteServicePost(
			@WebParam(name = "id") String id_ServicePost) {
		this.ServicePostsRef.child(id_ServicePost).removeValue();
		return true;
	}

	@WebMethod(operationName = "publishServicePost")
	public boolean publishServicePost(
			@WebParam(name = "id") String id_ServicePost) {
		this.ServicePostsRef.child(id_ServicePost).child("published")
				.setValue("true");
		return true;
	}

	@WebMethod(operationName = "addServiceUser")
	public boolean addServiceUser(
			@WebParam(name = "username") String ServiceUsername,
			@WebParam(name = "email") String email,
			@WebParam(name = "role") String role,
			@WebParam(name = "password") String password) {
		Map<String, String> ServiceUser = new HashMap<String, String>();
		ServiceUser.put("username", ServiceUsername);
		ServiceUser.put("email", email);
		ServiceUser.put("role", role);
		ServiceUser.put("password", password);
		this.ServiceUsersRef.push().setValue(ServiceUser);
		return true;
	}

	@WebMethod(operationName = "listServiceUser")
	public Vector<ServiceUser> listServiceUser() {
		Vector<ServiceUser> list = new Vector<ServiceUser>();
		JSONObject json = getJSON(this.firebaseURl + "/users.json");
		Map<String, Object> map = json;
		if (json != null) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println("Key:" + m.getKey());
				if (m.getKey().charAt(0) == '-')// berarti elemen
				{
					Map<String, String> ServiceUser = (Map<String, String>) m
							.getValue();
					String key, ServiceUsername, email, role, password;
					ServiceUsername = ServiceUser.get("username");
					email = ServiceUser.get("email");
					role = ServiceUser.get("role");
					password = ServiceUser.get("password");
					ServiceUser temp = new ServiceUser(m.getKey(),
							ServiceUsername, email, role, password);
					list.add(temp);
				}
			}
		}
		return list;
	}

	@WebMethod(operationName = "editServiceUser")
	public boolean editServiceUser(@WebParam(name = "id") String id,
			@WebParam(name = "username") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "role") String role) {
		Firebase ServiceUser = this.ServiceUsersRef.child(id);
		ServiceUser.child("username").setValue(name);
		ServiceUser.child("email").setValue(email);
		ServiceUser.child("role").setValue(role);
		return true;
	}

	@WebMethod(operationName = "deleteServiceUser")
	public boolean deleteServiceUser(@WebParam(name = "id") String id) {
		this.ServiceUsersRef.child(id).removeValue();
		return true;
	}

	@WebMethod(operationName = "addServiceComment")
	public boolean addServiceComment(@WebParam(name = "username") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "komentar") String komentar,
			@WebParam(name = "tanggal") String tanggal,
			@WebParam(name = "id_post") String id_ServicePost,
			@WebParam(name = "id_user") String id_ServiceUser,
			@WebParam(name = "guest") String guest) {
		Map<String, String> ServiceComment = new HashMap<String, String>();
		ServiceComment.put("username", name);
		ServiceComment.put("email", email);
		ServiceComment.put("komentar", komentar);
		ServiceComment.put("tanggal", tanggal);
		ServiceComment.put("id_post", id_ServicePost);
		ServiceComment.put("id_user", id_ServiceUser);
		ServiceComment.put("guest", guest);
		this.ServiceCommentsRef.push().setValue(ServiceComment);
		return true;
	}

	@WebMethod(operationName = "listServiceComment")
	public Vector<ServiceComment> listServiceComment() {
		Vector<ServiceComment> list = new Vector<ServiceComment>();
		JSONObject json = getJSON(this.firebaseURl + "/comments.json");
		Map<String, Object> map = json;
		if (json != null) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println("Key:" + m.getKey());
				if (m.getKey().charAt(0) == '-')// berarti id
				{
					Map<String, String> ServiceComment = (Map<String, String>) m
							.getValue();
					String email, guest, id_ServicePost, id_ServiceUser, komentar, tanggal, ServiceUsername;
					email = ServiceComment.get("email");
					guest = ServiceComment.get("guest");
					id_ServicePost = ServiceComment.get("id_post");
					id_ServiceUser = ServiceComment.get("id_user");
					komentar = ServiceComment.get("komentar");
					tanggal = ServiceComment.get("tanggal");
					ServiceUsername = ServiceComment.get("username");
					ServiceComment temp = new ServiceComment(m.getKey(), email,
							guest, id_ServicePost, id_ServiceUser, komentar,
							tanggal, ServiceUsername);
					list.add(temp);
				}
			}
		}
		return list;
	}

	@WebMethod(operationName = "deleteServiceComment")
	public boolean deleteServiceComment(@WebParam(name = "id") String id) {
		this.ServiceCommentsRef.child(id).removeValue();
		return true;
	}

	@WebMethod(operationName = "search")
	public Vector<ServicePost> search(
			@WebParam(name = "query") final String query) { // result
		// arrayServicePost
		Vector<ServicePost> list = new Vector<ServicePost>();
		JSONObject json = getJSON(this.firebaseURl + "/posts.json");
		Map<String, Object> map = json;
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println("Key:" + m.getKey());
			if (m.getKey().charAt(0) == '-')// berarti elemen
			{
				Map<String, String> ServicePost = (Map<String, String>) m
						.getValue();
				String deleted, published, id_ServiceUser, judul, konten, tanggal;
				deleted = ServicePost.get("deleted");
				published = ServicePost.get("published");
				id_ServiceUser = ServicePost.get("id_user");
				judul = ServicePost.get("judul");
				konten = ServicePost.get("konten");
				tanggal = ServicePost.get("tanggal");
				if (judul.toLowerCase().contains(query.toLowerCase())
						|| konten.toLowerCase().contains(query.toLowerCase())
						|| judul.equalsIgnoreCase(query)
						|| konten.equalsIgnoreCase(query)) {
					ServicePost temp = new ServicePost(m.getKey(), deleted,
							published, id_ServiceUser, judul, konten, tanggal);
					System.out.println(m.getKey() + " " + deleted + " "
							+ published + " " + id_ServiceUser + " " + judul
							+ " " + konten + " " + tanggal);
					if (temp.getStatusDeleted().equals("false")
							&& temp.getStatusPublished().equals("true")) {
						list.add(temp);
					}
				}
			}
		}
		return list;
	}

	private JSONObject getJSON(String path) {
		URL url;
		InputStream is = null;
		BufferedReader br;
		String JSON = "";
		String line = "";
		JSONArray array = new JSONArray();

		try {
			url = new URL(path + "?orderBy=\"$key\"");
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				JSON += line;
			}
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(JSON);
			array.add(obj);
		} catch (MalformedURLException ex) {
			System.out.println(ex.toString());
		} catch (IOException ex) {
			System.out.println(ex.toString());
		} catch (ParseException ex) {
			System.out.println(ex.toString());
		}
		JSONObject obj = (JSONObject) array.get(0);
		return obj;
	}
}
