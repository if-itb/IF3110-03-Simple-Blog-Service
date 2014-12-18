/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ccw.heroku.service;

import com.firebase.client.Firebase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.ccw.heroku.database.Database;
import org.ccw.heroku.model.CommentModel;
import org.ccw.heroku.model.PostModel;
import org.ccw.heroku.model.UserModel;
import org.json.JSONObject;

/**
 *
 * @author WILLY
 */
@WebService
public class CCWwebservice {
	public CCWwebservice() {
		
	}
	// <editor-fold defaultstate="collapsed" desc="Comment">
	/**
	 * Web service operation
	 * @param post_id
	 * @param name
	 * @param email
	 * @param comments
	 * @return 
	 */
	@WebMethod(operationName = "createComment")
	public boolean createComment(@WebParam(name = "post_id") String post_id, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "comment") String comments) {
		
		long created_at = System.currentTimeMillis();
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("comments");
		
		Map<String, Object> c = new HashMap<String, Object>();
		c.put("post_id", post_id);
		c.put("name", name);
		c.put("email", email);
		c.put("comment", comments);
		c.put("created_at", created_at);
		postRef.push().setValue(c);
		
		return true;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "getAllComments")
	public List<CommentModel> getAllComments(@WebParam(name = "id") String id) {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("comments");

		List<CommentModel> comments = new ArrayList<CommentModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			CommentModel c = new CommentModel();
			c.setId(ids.next());
			JSONObject o = obj.getJSONObject(c.getId());
			
			if (o.getString("post_id").equals(id)) {
				c.setPost_id(o.getString("post_id"));
				c.setName(o.getString("name"));
				c.setEmail(o.getString("email"));
				c.setComment(o.getString("comment"));
				c.setCreated_at(o.getLong("created_at"));

				comments.add(c);
			}
		}
		
		for (int i=0; i<comments.size()-1; ++i) {
			for (int j=i+1; j<comments.size(); ++j) {
				if (comments.get(i).getCreated_at() < comments.get(j).getCreated_at()) { //desc
					CommentModel tempi = comments.get(i);
					CommentModel tempj = comments.get(j);
					comments.remove(i); comments.add(i, tempj);
					comments.remove(j); comments.add(j, tempi);
				}
			}
		}
		
		return comments;
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="Post">
	/**
	 * Web service operation
	 * @param title
	 * @param date
	 * @param content
	 * @return 
	 */
	@WebMethod(operationName = "createPost")
	public String createPost(@WebParam(name = "title") String title, @WebParam(name = "date") long date, @WebParam(name = "content") String content) {

		long created_at = System.currentTimeMillis();
		long updated_at = System.currentTimeMillis();
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts");
		
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("title", title);
		post.put("date", date);
		post.put("content", content);
		post.put("status", false);
		post.put("deleted_at", -1);
		post.put("created_at", created_at);
		post.put("updated_at", updated_at);
		postRef.push().setValue(post);
		
		String post_id = postRef.getKey();
		
		return post_id;
	}

	/**
	 * Web service operation
	 * @param id
	 * @param title
	 * @param status
	 * @param date
	 * @param content
	 * @return 
	 */
	@WebMethod(operationName = "updatePost")
	public boolean updatePost(@WebParam(name = "id") String id, @WebParam(name = "title") String title, @WebParam(name = "date") long date, @WebParam(name = "content") String content, @WebParam(name = "status") boolean status) {

		long updated_at = System.currentTimeMillis();

		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts/" + id);
		
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("title", title);
		post.put("date", date);
		post.put("content", content);
		post.put("status", status);
		post.put("updated_at", updated_at);
		postRef.updateChildren(post);
		
		return true;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "deletePost")
	public boolean deletePost(@WebParam(name = "id") String id) {
		
		long deleted_at = System.currentTimeMillis();
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts/" + id);
		
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("deleted_at", deleted_at);
		postRef.updateChildren(post);
		
		return true;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "restorePost")
	public boolean restorePost(@WebParam(name = "id") String id) {
		
		long updated_at = System.currentTimeMillis();

		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts/" + id);
		
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("deleted_at", -1);
		post.put("updated_at", updated_at);
		postRef.updateChildren(post);
		
		return true;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "getPost")
	public PostModel getPost(@WebParam(name = "id") String id) {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts/" + id);

		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);

		PostModel p = new PostModel();
		p.setId(id);
		p.setTitle(obj.getString("title"));
		p.setDate(obj.getLong("date"));
		p.setContent(obj.getString("content"));
		p.setStatus(obj.getBoolean("status"));
		p.setUpdated_at(obj.getLong("updated_at"));
		
		return p;
	}

	/**
	 * Web service operation
	 * @return 
	 */
	@WebMethod(operationName = "getAllPublishedPosts")
	public List<PostModel> getAllPublishedPosts() {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts");

		List<PostModel> posts = new ArrayList<PostModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		json += "?orderBy=\"updated_at\"";
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			PostModel p = new PostModel();
			p.setId(ids.next());
			JSONObject o = obj.getJSONObject(p.getId());
			if (o.getLong("deleted_at") == -1) {
				if (o.getBoolean("status")) {
					p.setTitle(o.getString("title"));
					p.setDate(o.getLong("date"));
					p.setContent(o.getString("content"));
					p.setStatus(o.getBoolean("status"));
					p.setUpdated_at(o.getLong("updated_at"));
					
					posts.add(p);
				}
			}
		}

		for (int i=0; i<posts.size()-1; i++) {
			for (int j=i+1; j<posts.size(); j++) {
				if (posts.get(i).getDate()< posts.get(j).getDate()) { //desc
					PostModel tempi = posts.get(i);
					PostModel tempj = posts.get(j);
					posts.remove(i); posts.add(i, tempj);
					posts.remove(j); posts.add(j, tempi);
				}
			}
		}
		
		return posts;
	}

	/**
	 * Web service operation
	 * @return 
	 */
	@WebMethod(operationName = "getAllUnpublishedPosts")
	public List<PostModel> getAllUnpublishedPosts() {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts");

		List<PostModel> posts = new ArrayList<PostModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			PostModel p = new PostModel();
			p.setId(ids.next());
			JSONObject o = obj.getJSONObject(p.getId());
			if (o.getLong("deleted_at") == -1) {
				if (!o.getBoolean("status")) {
					p.setTitle(o.getString("title"));
					p.setDate(o.getLong("date"));
					p.setContent(o.getString("content"));
					p.setStatus(o.getBoolean("status"));
					p.setUpdated_at(o.getLong("updated_at"));
					
					posts.add(p);
				}
			}
		}
		
		for (int i=0; i<posts.size()-1; i++) {
			for (int j=i+1; j<posts.size(); j++) {
				if (posts.get(i).getDate()< posts.get(j).getDate()) { //desc
					PostModel tempi = posts.get(i);
					PostModel tempj = posts.get(j);
					posts.remove(i); posts.add(i, tempj);
					posts.remove(j); posts.add(j, tempi);
				}
			}
		}
		
		return posts;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "publishPost")
	public boolean publishPost(@WebParam(name = "id") String id) {
		
		long updated_at = System.currentTimeMillis() % 1000;

		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts/" + id);
		
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("status", true);
		post.put("updated_at", updated_at);
		postRef.updateChildren(post);
		
		return true;
	}

	/**
	 * Web service operation
	 * @return 
	 */
	@WebMethod(operationName = "getAllDeletedPosts")
	public List<PostModel> getAllDeletedPosts() {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts");

		List<PostModel> posts = new ArrayList<PostModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			PostModel p = new PostModel();
			p.setId(ids.next());
			JSONObject o = obj.getJSONObject(p.getId());
			if(o.getLong("deleted_at") > -1) {
				p.setTitle(o.getString("title"));
				p.setDate(o.getLong("date"));
				p.setContent(o.getString("content"));
				p.setStatus(o.getBoolean("status"));
				p.setUpdated_at(o.getLong("updated_at"));
				
				posts.add(p);
			}
		}
		
		for (int i=0; i<posts.size()-1; i++) {
			for (int j=i+1; j<posts.size(); j++) {
				if (posts.get(i).getDate()< posts.get(j).getDate()) { //desc
					PostModel tempi = posts.get(i);
					PostModel tempj = posts.get(j);
					posts.remove(i); posts.add(i, tempj);
					posts.remove(j); posts.add(j, tempi);
				}
			}
		}
		
		return posts;
	}

	@WebMethod(operationName = "searchPost")
	public List<PostModel> searchPost(String key) {
		
		String[] keys = key.split(" ");
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("posts");

		List<PostModel> posts = new ArrayList<PostModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			PostModel p = new PostModel();
			p.setId(ids.next());
			JSONObject o = obj.getJSONObject(p.getId());
			if (o.getLong("deleted_at") == -1) {
				p.setTitle(o.getString("title"));
				p.setDate(o.getLong("date"));
				p.setContent(o.getString("content"));
				p.setStatus(o.getBoolean("status"));
				p.setUpdated_at(o.getLong("updated_at"));
				
				boolean isNotFound = false;
				for (String k : keys) {
					if (!(p.getTitle().contains(k) || p.getContent().contains(k))) {
						isNotFound = true;
						break;
					}
				}
				
				if (!isNotFound) {
					posts.add(p);
				}
			}
		}
		
		for (int i=0; i<posts.size()-1; i++) {
			for (int j=i+1; j<posts.size(); j++) {
				if (posts.get(i).getDate()< posts.get(j).getDate()) { //desc
					PostModel tempi = posts.get(i);
					PostModel tempj = posts.get(j);
					posts.remove(i); posts.add(i, tempj);
					posts.remove(j); posts.add(j, tempi);
				}
			}
		}
		
		return posts;
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="User">
	/**
	 * Web service operation
	 * @param email
	 * @param username
	 * @param password
	 * @param role
	 * @return 
	 */
	@WebMethod(operationName = "createUser")
	public boolean createUser(@WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "role") String role) {
		
		long created_at = System.currentTimeMillis();
		long updated_at = System.currentTimeMillis();
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("users");
		
		Map<String, Object> user = new HashMap<String,Object>();
		user.put("email", email);
		user.put("username", username);
		user.put("password", password);
		user.put("role", role);
		user.put("created_at", created_at);
		user.put("updated_at", updated_at);
		postRef.push().setValue(user);
		
		return true;
	}

	/**
	 * Web service operation
	 * @return 
	 */
	@WebMethod(operationName = "getAllUsers")
	public List<UserModel> getAllUsers() {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("users");

		List<UserModel> users = new ArrayList<UserModel>();
		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);
		
		Iterator<String> ids = obj.keys();
		while(ids.hasNext()) {
			UserModel u = new UserModel();
			u.setId(ids.next());
			JSONObject o = obj.getJSONObject(u.getId());
			u.setEmail(o.getString("email"));
			u.setUsername(o.getString("username"));
			u.setPassword(o.getString("password"));
			u.setRole(o.getString("role"));
			users.add(u);
		}
		
		for (int i=0; i<users.size()-1; ++i) {
			for (int j=i+1; j<users.size(); ++j) {
				if (users.get(i).getUpdated_at() < users.get(j).getUpdated_at()) { //desc
					UserModel tempi = users.get(i);
					UserModel tempj = users.get(j);
					users.remove(i); users.add(i, tempj);
					users.remove(j); users.add(j, tempi);
				}
			}
		}
		
		return users;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "getUser")
	public UserModel getUser(@WebParam(name = "id") String id) {
		
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("users/" + id);

		String json = Database.readURL(postRef.toString() + ".json");
		JSONObject obj = new JSONObject(json);

		UserModel u = new UserModel();
		u.setEmail((String) obj.getString("email"));
		u.setUsername((String) obj.getString("username"));
		u.setPassword((String) obj.getString("password"));
		u.setRole((String) obj.getString("role"));
		u.setUpdated_at(obj.getLong("updated_at"));
		return u;
	}

	/**
	 * Web service operation
	 * @param id
	 * @param email
	 * @param username
	 * @param password
	 * @param role
	 * @return 
	 */
	@WebMethod(operationName = "updateUser")
	public boolean updateUser(@WebParam(name = "id") String id, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "role") String role) {

		long updated_at = System.currentTimeMillis();

		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("users/" + id);
		
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("email", email);
		user.put("username", username);
		user.put("password", password);
		user.put("role", role);
		user.put("updated_at", updated_at);
		postRef.updateChildren(user);
		return true;
	}

	/**
	 * Web service operation
	 * @param id
	 * @return 
	 */
	@WebMethod(operationName = "deleteUser")
	public boolean deleteUser(@WebParam(name = "id") String id) {
		Database ref = Database.getDatabase();
		Firebase postRef = ref.child("users/" + id);
		postRef.removeValue();
		return true;
	}
	
}
