package WBD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//import WBD.test.Comment;
//import WBD.test.Post;
//import WBD.test.User;

import com.firebase.client.Firebase;

import org.json.JSONObject;

@WebService(serviceName = "SimpleBlog")
public class SimpleBlog {
		
	@WebMethod(operationName = "addUser")
	public boolean addUser(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name="role") String role) {
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			int counter = json.getInt("counter") + 1;
			Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/user/");
			User user = new User(counter, email, password, name, role);
			firebase.push().setValue(user);
			firebase.child("counter").setValue(counter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod(operationName = "editUser")
	public boolean editUser(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name="role") String role) {
		boolean flag = false;
		try {							
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()) {
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getString("email").equals(email)){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/user/");						
						base.child(key).child("email").setValue(email);
						base.child(key).child("password").setValue(password);
						base.child(key).child("name").setValue(name);
						base.child(key).child("role").setValue(role);
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
        
        @WebMethod(operationName = "getUser")
	public User getUser(@WebParam(name = "email") String email) {
		User user = null;
		try {					
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getString("email").equals(email)){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/user/");
						user = new User(child.getInt("id"), child.getString("email"), child.getString("password"), child.getString("name"), child.getString("role"));
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return user;
	}
        
        @WebMethod(operationName = "login")
	public User login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
		User user = null;
		try {					
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getString("email").equals(email) && child.getString("password").equals(password)){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/user/");                                                
						user = new User(child.getInt("id"), child.getString("email"), child.getString("password"), child.getString("name"), child.getString("role"));
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return user;
	}
	
	@WebMethod(operationName = "deleteUser")
	public boolean deleteUser(@WebParam(name = "email") String email) {
		boolean flag = false;
		try {					
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getString("email").equals(email)){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/user/");
						base.child(key).removeValue();
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "listUser")
	public ArrayList<User> listUser() {
		ArrayList<User> users = new ArrayList<User>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/user/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counterId")){
					JSONObject child = json.getJSONObject(key);
					User user = new User(child.getInt("id"), child.getString("email"), child.getString("password"), child.getString("name"), child.getString("role"));
					users.add(user);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return users;
	}
	
	@WebMethod(operationName = "addPost")
	public boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			int counter = json.getInt("counter") + 1;
			Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
			Post post = new Post(counter, judul, tanggal, konten, "Unpublished", "");
			firebase.push().setValue(post);
			firebase.child("counter").setValue(counter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
        
        @WebMethod(operationName = "editPost")
	public boolean editPost(@WebParam(name = "id") int id, @WebParam(name = "judul") String judul, @WebParam(name = "tanggal") String tanggal, @WebParam(name = "konten") String konten) {
                boolean flag = false;			
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
						base.child(key).child("judul").setValue(judul);
						base.child(key).child("tanggal").setValue(tanggal);
						base.child(key).child("konten").setValue(konten);
						flag = true;
                                                break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}

        @WebMethod(operationName = "getPost")
	public Post getPost(@WebParam(name = "id") int id) {
		Post post = null;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");						
                                                post = new Post(child.getInt("id"), child.getString("judul"), child.getString("tanggal"), child.getString("konten"), child.getString("status"));
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return post;
	}                
        
	@WebMethod(operationName = "deletePost")
	public boolean deletePost(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
						firebase.child(key).child("status").setValue("Deleted");
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "literallyDeletePost")
	public boolean literallyDeletePost(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
						firebase.child(key).child("status").setValue("SECRETPOST");
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "undeletePost")
	public boolean undeletePost(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
						base.child(key).child("status").setValue("Unpublished");
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "publishedPost")
	public ArrayList<Post> publishedPost(@WebParam(name = "status") String status) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);					
					if(child.getString("status").equals("Published")) {
						Post post = new Post(child.getInt("id"), child.getString("judul"), child.getString("tanggal"), child.getString("konten"), child.getString("status"));
						posts.add(post);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "unpublishedPost")
	public ArrayList<Post> unpublishedPost(@WebParam(name = "status") String status) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);					
					if(child.getString("status").equals("Unpublished")) {
						Post post = new Post(child.getInt("id"), child.getString("judul"), child.getString("tanggal"), child.getString("konten"), child.getString("status"));
						posts.add(post);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "deletedPost")
	public ArrayList<Post> deletedPost(@WebParam(name = "status") String status) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);					
					if(child.getString("status").equals("Deleted")) {
						Post post = new Post(child.getInt("id"), child.getString("judul"), child.getString("tanggal"), child.getString("konten"), child.getString("status"));
						posts.add(post);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
	}
	
	@WebMethod(operationName = "publishPost")
	public boolean publishPost(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {				
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
						firebase.child(key).child("status").setValue("Published");
						flag = true;
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;	
	}
        
        @WebMethod(operationName = "addImage")
	public boolean addImage(@WebParam(name = "id") int id, @WebParam(name = "filename") String filename) {
		boolean flag = false;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
                                                firebase.child(key).child("image").setValue(filename);                                                
                                                flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
        
        @WebMethod(operationName = "removeImage")
	public boolean removeImage(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {						
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase firebase = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/post/");
                                                firebase.child(key).child("image").removeValue();
                                                flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "addComment")
	public boolean addComment(@WebParam(name = "id") int postId, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String content) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/komentar/.json"));
			int counter = json.getInt("counter") + 1;
			Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/komentar/");
			Comment comment = new Comment(counter, postId, nama, dateFormat.format(date), email, content);
			base.push().setValue(comment);
			base.child("counter").setValue(counter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod(operationName = "listComment")
	public ArrayList<Comment> listComment(@WebParam(name = "postId") int postId) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/komentar/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					Comment comment = new Comment(child.getInt("id"), postId, child.getString("nama"), child.getString("email"), child.getString("tanggal"), child.getString("komentar"));
					comments.add(comment);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return comments;
	}
        
        @WebMethod(operationName = "getComment")
	public Comment getComment(@WebParam(name = "id") int id) {
		Comment comment = null;
		try {					
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/komentar/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/komentar/");
						comment = new Comment(child.getInt("id"), child.getInt("post_id"), child.getString("nama"), child.getString("email"), child.getString("tanggal"), child.getString("komentar"));
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return comment;
	}

	@WebMethod(operationName = "deleteComment")
	public boolean deleteComment(@WebParam(name = "id") int id) {
		boolean flag = false;
		try {					
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/komentar/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);
					if(child.getInt("id") == id){
						Firebase base = new Firebase("https://ei8pwwxygzz.firebaseio-demo.com/komentar/");
						base.child(key).removeValue();
						flag = true;
						break;
					}
				}
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}
	
	@WebMethod(operationName = "search")
	public ArrayList<Post> search(@WebParam(name = "query") String query) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {			
			JSONObject json = new JSONObject(readUrl("https://ei8pwwxygzz.firebaseio-demo.com/post/.json"));
			Iterator<?> keys = json.keys();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(!key.equals("counter")){
					JSONObject child = json.getJSONObject(key);					
					Post post = new Post(child.getInt("id"), child.getString("judul"), child.getString("tanggal"), child.getString("konten"), child.getString("status"));
					if(child.getString("status").equals("Published")){
						if(post.getKonten().contains(query) || post.getJudul().contains(query))							
							posts.add(post);
					}					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return posts;
		
	}
	
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
}
