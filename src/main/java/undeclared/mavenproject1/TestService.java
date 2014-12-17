/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package undeclared.mavenproject1;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Gilang
 */
@WebService(serviceName = "TestService")
public class TestService {

	public String readUrl(String address){
		BufferedReader reader = null;
		try{
			URL url = new URL(address);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer builder = new StringBuffer();
			String line;
			while((line = reader.readLine()) != null){
				builder.append(line);
			}
			reader.close();
			return builder.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
//	-------------------- Post Method ------------------------------------------------------------
	
	@WebMethod(operationName = "addPost")
	public boolean addPost(@WebParam(name = "judul") String title, @WebParam(name = "konten") String content, @WebParam(name = "tanggal") String date) {
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			int autoId = obj.getInt("autoId") + 1;
			Firebase base = new Firebase("https://tubeswbd.firebaseio.com/post/");
			Post post = new Post(autoId, title, content, date, false, false);
			base.push().setValue(post);
			base.child("autoId").setValue(autoId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod(operationName = "listPost")
	public List<Post> listPost() {
		List<Post> posts = new ArrayList<Post>();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					Post post = new Post(child.getInt("id"), child.getString("title"),
										child.getString("content"), child.getString("date"), child.getBoolean("published"), child.getBoolean("deleted"));
					posts.add(post);
				}
			}
		} catch (JSONException ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "listPublishPost")
	public List<Post> listPublishPost(@WebParam(name="published") boolean published) {
		List<Post> posts = new ArrayList<Post>();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					Post post = new Post(child.getInt("id"), child.getString("title"),
										child.getString("content"), child.getString("date"), child.getBoolean("published"), child.getBoolean("deleted"));
					if(child.getBoolean("published") == published)
						posts.add(post);
				}
			}
		} catch (JSONException ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "listDeletePost")
	public List<Post> listDeletePost(@WebParam(name="deleted") boolean deleted) {
		List<Post> posts = new ArrayList<Post>();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					Post post = new Post(child.getInt("id"), child.getString("title"),
										child.getString("content"), child.getString("date"), child.getBoolean("published"), child.getBoolean("deleted"));
					if(child.getBoolean("deleted") == deleted)
						posts.add(post);
				}
			}
		} catch (JSONException ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "editPost")
	public boolean editPost(@WebParam(name = "id") int postId, @WebParam(name = "judul") String title, @WebParam(name = "konten") String content, @WebParam(name = "tanggal") String date) {
		try {
			boolean finish = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !finish){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == postId){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/post/");
						base.child(key).child("title").setValue(title);
						base.child(key).child("content").setValue(content);
						base.child(key).child("date").setValue(date);
						finish = true;
					}
				}
			}
			if(finish)	
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	@WebMethod(operationName = "deletePost")
	public boolean deletePost(@WebParam(name = "id") int postId) {
		try {
			boolean found = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !found){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == postId){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/post/");
						base.child(key).child("deleted").setValue(true);
						found = true;
					}
				}
			}
			if(found)
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	@WebMethod(operationName = "restorePost")
	public boolean restorePost(@WebParam(name = "id") int postId) {
		try {
			boolean found = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !found){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == postId){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/post/");
						base.child(key).child("deleted").setValue(false);
						found = true;
					}
				}
			}
			if(found)
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	@WebMethod(operationName = "publishPost")
	public boolean publishPost(@WebParam(name = "id") int postId) {
		try {
			boolean found = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/post/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !found){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == postId){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/post/");
						base.child(key).child("published").setValue(true);
						found = true;
					}
				}
			}
			if(found)
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	
//	-------------- User Method -------------------------------------------------------------------------------------------
	
	@WebMethod(operationName = "addUser")
	public boolean addUser(@WebParam(name = "nama") String name, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/user/.json");
			JSONObject obj = new JSONObject(json);
			int autoId = obj.getInt("autoId") + 1;
			Firebase base = new Firebase("https://tubeswbd.firebaseio.com/user/");
			User user = new User(autoId, name, email, role);
			base.push().setValue(user);
			base.child("autoId").setValue(autoId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod(operationName = "listUser")
	public List<User> listUser() {
		List<User> users = new ArrayList<User>();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/user/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					User user = new User(child.getInt("id"), child.getString("name"),
										child.getString("email"), child.getString("role"));
					users.add(user);
				}
			}
		} catch (JSONException ex) {
			ex.printStackTrace();
			return null;
		}
		return users;
	}
	
	@WebMethod(operationName = "editUser")
	public boolean editUser(@WebParam(name = "id") int id, @WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
		try {
			boolean finish = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/user/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !finish){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/user/");
						base.child(key).child("name").setValue(nama);
						base.child(key).child("email").setValue(email);
						base.child(key).child("role").setValue(role);
						finish = true;
					}
				}
			}
			if(finish)	
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}

	@WebMethod(operationName = "deleteUser")
	public boolean deleteUser(@WebParam(name = "id") int id) {
		try {
			boolean found = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/user/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !found){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/user/");
						base.child(key).removeValue();
						found = true;
					}
				}
			}
			if(found)
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
//	----------------- Comment Method --------------------------------------------------------------

	@WebMethod(operationName = "addComment")
	public boolean addComment(@WebParam(name="post_id") int postId, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "content") String content) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/comment/.json");
			JSONObject obj = new JSONObject(json);
			int autoId = obj.getInt("autoId") + 1;
			Firebase base = new Firebase("https://tubeswbd.firebaseio.com/comment/");
			Comment comment = new Comment(postId, autoId, nama, date.toString(), email, content);
			base.push().setValue(comment);
			base.child("autoId").setValue(autoId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod(operationName = "listComment")
	public List<Comment> listComment(@WebParam(name = "postId") int postId) {
		List<Comment> comments = new ArrayList<Comment>();
		try {
			String json = readUrl("https://tubeswbd.firebaseio.com/comment/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					Comment comment = new Comment(postId, child.getInt("id"), child.getString("name"), child.getString("date"),
													child.getString("email"), child.getString("content"));
					comments.add(comment);
				}
			}
		} catch (JSONException ex) {
			ex.printStackTrace();
			return null;
		}
		return comments;
	}

	@WebMethod(operationName = "deleteComment")
	public boolean deleteComment(@WebParam(name = "id") int id) {
		try {
			boolean found = false;
			String json = readUrl("https://tubeswbd.firebaseio.com/comment/.json");
			JSONObject obj = new JSONObject(json);
			Iterator<?> keys = obj.keys();
			while(keys.hasNext() && !found){
				String key = (String)keys.next();
				if(!key.equals("autoId")){
					JSONObject child = obj.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://tubeswbd.firebaseio.com/comment/");
						base.child(key).removeValue();
						found = true;
					}
				}
			}
			if(found)
				return true;
		} catch (JSONException ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	
	
}
