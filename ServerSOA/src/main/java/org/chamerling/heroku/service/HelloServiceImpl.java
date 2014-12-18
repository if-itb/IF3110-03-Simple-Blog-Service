/**
 * 
 */
package org.chamerling.heroku.service;

import com.firebase.client.Firebase;
import com.tubes2.Komentar.*;
import com.tubes2.Post.*;
import com.tubes2.User.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {
	private String FirebaseAddr="https://popping-fire-1228.firebaseio.com/";
	private String PostNode="post";
	private String UserNode="users";
	@Override
	public boolean addUser(String nama, String username, String password, String email, String status){
		return com.tubes2.User.userPaket.addUser(nama, username, password, email, status);
	}
	public boolean delUser(String Username){
		return com.tubes2.User.userPaket.delUser(Username);
	}
	public boolean addPost(String judul, String konten, String Owner, int Status){
		boolean statusOp = false;
		Paket newPost = new Paket();
		Firebase ref = new Firebase("https://popping-fire-1228.firebaseio.com/");
		/* masukkan input ke atribut user baru */
		newPost.setJudul(judul);
		newPost.setKonten(konten);
		newPost.setOwner(Owner);
		newPost.setStatus(Status);
		
		Firebase postRef = ref.child("posts");
		//Firebase newPostRef = postRef.push();

		postRef.setValue(newPost);

		/* input ke firebase */
		//Map<String, Paket> post1 = new HashMap<String, Paket>();
		//user1.put("nama", newUser);
		//newPostRef.setValue(newPost);
		return statusOp;
	}
	public boolean updateUser(String Nama, String Username,String Password, String Email, String Status){
		return com.tubes2.User.userPaket.updateUser(Username, Nama, Password, Email, Status);
	}
	
	public ArrayList<String> readUser(String Username){
		ArrayList<String> dummy = new ArrayList<String>();
		try {
			return com.tubes2.User.userPaket.readUser(Username);
		} catch (IOException ex) {
			Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return dummy;
	}
	public ArrayList<String> GetPublishedPost() throws MalformedURLException, IOException, JSONException{
		//ArrayList<Post> list=new ArrayList<Post>();
		ArrayList<String> list=new ArrayList<String>();
		int Status_Cond=1;
		// retrieve value from firebase
		URL url = new URL(FirebaseAddr+PostNode+".json");
		URLConnection connection = url.openConnection();
		String in=IOUtils.toString(connection.getInputStream());
		if (!in.equals("null")){
			JSONArray obj=new JSONArray(in);
			for (int i=0;i<obj.length();i++){
				if (obj.getString(i).equals("null"))continue;
				JSONObject obji = obj.getJSONObject(i);
			//JSONObject obj = new JSONObject(in);
			//Iterator<String> yourKeys = obj.keys();
			//while(yourKeys.hasNext()){
				//String s=yourKeys.next();
				//JSONObject obji = obj.getJSONObject(s);
				if (obji.getInt("Status")==Status_Cond){
					//Post tp=Post.JSONtoPost(obji.toString());
					String tp=obji.toString();
					list.add(tp);
				}
			}
			//Collections.sort(list);
		}
		return list;
	}
	//public ArrayList<Post> GetUnpublishedPost(){
	public ArrayList<String> GetUnpublishedPost() throws MalformedURLException, IOException, JSONException{
		//ArrayList<Post> list=new ArrayList<Post>();
		ArrayList<String> list=new ArrayList<String>();
		int Status_Cond=2;
		// retrieve value from firebase
		URL url = new URL(FirebaseAddr+PostNode+".json");
		URLConnection connection = url.openConnection();
		String in=IOUtils.toString(connection.getInputStream());
		if (!in.equals("null")){
			JSONArray obj=new JSONArray(in);
			for (int i=0;i<obj.length();i++){
				if (obj.getString(i).equals("null"))continue;
				JSONObject obji = obj.getJSONObject(i);
			//JSONObject obj = new JSONObject(in);
			//Iterator<String> yourKeys = obj.keys();
			//while(yourKeys.hasNext()){
				//String s=yourKeys.next();
				//JSONObject obji = obj.getJSONObject(s);
				if (obji.getInt("Status")==Status_Cond){
					//Post tp=Post.JSONtoPost(obji.toString());
					String tp=obji.toString();
					list.add(tp);
				}
			}
			//Collections.sort(list);
		}
		return list;
	}
	//public ArrayList<Post> GetDeletedPost(){
	public ArrayList<String> GetDeletedPost() throws MalformedURLException, IOException, JSONException{
		//ArrayList<Post> list=new ArrayList<Post>();
		ArrayList<String> list=new ArrayList<String>();
		int Status_Cond=3;
		// retrieve value from firebase
		URL url = new URL(FirebaseAddr+PostNode+".json");
		URLConnection connection = url.openConnection();
		String in=IOUtils.toString(connection.getInputStream());
		if (!in.equals("null")){
			JSONArray obj=new JSONArray(in);
			for (int i=0;i<obj.length();i++){
				if (obj.getString(i).equals("null"))continue;
				JSONObject obji = obj.getJSONObject(i);
			//JSONObject obj = new JSONObject(in);
			//Iterator<String> yourKeys = obj.keys();
			//while(yourKeys.hasNext()){
				//String s=yourKeys.next();
				//JSONObject obji = obj.getJSONObject(s);
				if (obji.getInt("Status")==Status_Cond){
					//Post tp=Post.JSONtoPost(obji.toString());
					String tp=obji.toString();
					list.add(tp);
				}
			}
			//Collections.sort(list);
		}
		return list;
	}
	public boolean AddNewPost(String Judul, String Owner, String Konten, Long tanggal) throws MalformedURLException, IOException, JSONException{
		boolean statusOp = true;
		Firebase ref = new Firebase(FirebaseAddr);
		Firebase postRef = ref.child(PostNode);
		int id_new=0;
		// retrieve value from firebase
		URL url;
			url = new URL(FirebaseAddr+PostNode+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			//in.replace("[null,", "");
			//in.replace("]", "");
			if (!in.equals("null")){
				JSONArray obj=new JSONArray(in);
				//JSONObject obj = new JSONObject(in);
				for (int i=0;i<obj.length();i++){
					if (obj.getString(i).equals("null"))continue;
					JSONObject obji = obj.getJSONObject(i);
				//Iterator<String> yourKeys = obj.keys();
				//while(yourKeys.hasNext()){
					//String s=yourKeys.next();
					//JSONObject obji = obj.getJSONObject(s);
					if (obji.getString("Judul").equals(Judul)){
						statusOp=false;
					}
					int x=obji.getInt("id");
					if (x>id_new)id_new=x;
				}
			}
			if (statusOp){
				Post tp = new Post();
				/* masukkan input ke atribut user baru */
				tp.Judul=Judul;
				tp.Owner=Owner;
				tp.Konten=Konten;
				tp.Status=2;
				tp.Tanggal=tanggal;
				tp.Komentar=new ArrayList<Comment>();
				//tp.Komentar.add(new Comment());
				tp.id=id_new+1;
				postRef.child(Integer.toString(tp.id)).setValue(tp);
				//postRef.child(Integer.toString(tp.id)).child("Komentar").setValue(tp.Komentar);
			}
		return statusOp;
	}
	//public Post GetPost(int id){
	public String GetPost(int id){
		// retrieve value from firebase
		URL url;
		try {
			url = new URL(FirebaseAddr+PostNode+"/"+id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			//Post tp=new Post();
			String tp=new String("null");
			if (!in.equals("null")){
				//tp=Post.JSONtoPost(in);
				tp=in;
			}
			return tp;
		} catch (Exception ex) {
			return new String("null");
		}
	}
	public boolean UpdatePost(int id, String Judul, String Owner, String Konten, Long tanggal){
		// retrieve value from firebase
		URL url;
		try {
			url = new URL(FirebaseAddr+PostNode+"/"+id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			Post tp=new Post();
			if (!in.equals("null")){
				JSONObject obj = new JSONObject(in);
				Firebase ref = new Firebase(FirebaseAddr);
				Firebase postRef = ref.child(PostNode).child(Integer.toString(id));
				tp.Judul=Judul;
				tp.Owner=Owner;
				tp.Konten=Konten;
				tp.Status=obj.getInt("id");
				tp.Tanggal=tanggal;
				tp.id=id;
				tp.Komentar=new ArrayList<Comment>();
				JSONArray arr=(JSONArray)obj.get("Komentar");
				for (int i=0;i<arr.length();i++){
					tp.Komentar.add(Comment.JSONtoComment(arr.getJSONObject(i).toString()));
				}
				//tp.Komentar=(ArrayList<Comment>)obj.get("Komentar");
				postRef.setValue(tp);
				return true;
			} else {
				return false;
			}
			////////
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean DeletePost(int id){
		boolean statusOp=true;
		// retrieve value from firebase
		URL url;
		try {
			url = new URL(FirebaseAddr+PostNode+"/"+id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			Post tp=new Post();
			if (!in.equals("null")){
				tp=Post.JSONtoPost(in);
				Firebase ref = new Firebase(FirebaseAddr);
				Firebase postRef = ref.child(PostNode).child(Integer.toString(id));
				if ((tp.Status==1)||(tp.Status==2)){
					//soft delete
					tp.Status=3;
					postRef.setValue(tp);
				} else if (tp.Status==3){
					//hard delete
					postRef.removeValue();
				} else {
					statusOp=false;
				}
			} else {
				statusOp=false;
			}
		} catch (Exception ex) {
			statusOp=false;
		}
		return statusOp;
	}
	public boolean RecoverPost(int id){
		try {
			boolean statusOp=true;
			// retrieve value from firebase
			URL url;
			
			url = new URL(FirebaseAddr+PostNode+"/"+id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			Post tp=new Post();
			if (!in.equals("null")){
				tp=Post.JSONtoPost(in);
				Firebase ref = new Firebase(FirebaseAddr);
				Firebase postRef = ref.child(PostNode).child(Integer.toString(id));
				if (tp.Status==3){
					tp.Status=2;
					postRef.setValue(tp);
				} else {
					statusOp=false;
				}
			} else {
				statusOp=false;
			}
			return statusOp;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean PublishPost(int id) {
		try {
			boolean statusOp=true;
			// retrieve value from firebase
			URL url;
			
			url = new URL(FirebaseAddr+PostNode+"/"+id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			Post tp=new Post();
			if (!in.equals("null")){
				tp=Post.JSONtoPost(in);
				Firebase ref = new Firebase(FirebaseAddr);
				Firebase postRef = ref.child(PostNode).child(Integer.toString(id));
				if (tp.Status==2){
					tp.Status=1;
					postRef.setValue(tp);
				} else {
					statusOp=false;
				}
			} else {
				statusOp=false;
			}
			return statusOp;
		} catch (Exception ex) {
			return false;
		}
	}
	//public ArrayList<Comment> GetAllComment(int post_id){
	public ArrayList<String> GetAllComment(int post_id){
		//deprecated, use Post.Komentar
		// retrieve value from firebase
		URL url;
		try {
			url = new URL(FirebaseAddr+PostNode+"/"+post_id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			if (!in.equals("null")){
				JSONObject obj = new JSONObject(in);
				JSONArray arr = obj.getJSONArray("Komentar");
				//ArrayList<Comment> list=new ArrayList<Comment>();
				ArrayList<String> list=new ArrayList<String>();
				for (int i = 0; i < arr.length(); i++){
					//Comment tp=Comment.JSONtoComment(arr.getJSONObject(i).toString());
					String tp=arr.getJSONObject(i).toString();
					list.add(tp);
				}
				return list;
			} else {
				//return new ArrayList<Comment>();
				return new ArrayList<String>();
			}
		} catch (Exception ex) {
			return new ArrayList<String>();
		}
	}
	public boolean AddComment(int post_id, String nama, String email, String komentar){
		boolean statusOp=true;
		// retrieve value from firebase
		URL url;
		try {
			url = new URL(FirebaseAddr+PostNode+"/"+post_id+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			Post tp=new Post();
			if (!in.equals("null")){
				tp=Post.JSONtoPost(in);
				Firebase ref = new Firebase(FirebaseAddr);
				Firebase postRef = ref.child(PostNode).child(Integer.toString(post_id));
				Comment ctp=new Comment();
				ctp.Nama=nama;
				ctp.Email=email;
				ctp.Komentar=komentar;
				ctp.Tanggal=new Date().getTime();
				tp.Komentar.add(ctp);
				postRef.setValue(tp);
			} else {
				statusOp=false;
			}
		} catch (Exception ex) {
			statusOp=false;
		}
		return statusOp;
	}

	public ArrayList<String> Login(String username, String pass){
		// retrieve value from firebase
		URL url;
		ArrayList<String> hsl=new ArrayList<String>();
		try {
			url = new URL(FirebaseAddr+UserNode+"/"+username+".json");
			URLConnection connection = url.openConnection();
			String in=IOUtils.toString(connection.getInputStream());
			if (!in.equals("null")){
				JSONObject obj = new JSONObject(in);
				hsl.add(obj.getString("nama"));
				hsl.add(obj.getString("status"));
			} else {
				hsl.add("Guest");
				hsl.add("4");
			}
		} catch (Exception ex) {
			hsl.add("Guest");
			hsl.add("4");
		}
		return hsl;
	}
	
	public ArrayList<String> GetAllUser() throws MalformedURLException, IOException, JSONException{
		//ArrayList<Post> list=new ArrayList<Post>();
		ArrayList<String> list=new ArrayList<String>();
		// retrieve value from firebase
		URL url = new URL(FirebaseAddr+UserNode+".json");
		URLConnection connection = url.openConnection();
		String in=IOUtils.toString(connection.getInputStream());
		if (!in.equals("null")){
			JSONObject obj = new JSONObject(in);
			Iterator<String> yourKeys = obj.keys();
			while(yourKeys.hasNext()){
				String s=yourKeys.next();
				JSONObject obji = obj.getJSONObject(s);
					//Post tp=Post.JSONtoPost(obji.toString());
				String tp=obji.toString();
				list.add(tp);
			}
			//Collections.sort(list);
		}
		return list;
	}
	public ArrayList<String> Search(String input) throws MalformedURLException, IOException, JSONException{
		//ArrayList<Post> list=new ArrayList<Post>();
		ArrayList<String> list=new ArrayList<String>();
		int Status_Cond=1;
		// retrieve value from firebase
		URL url = new URL(FirebaseAddr+PostNode+".json");
		URLConnection connection = url.openConnection();
		String in=IOUtils.toString(connection.getInputStream());
		if (!in.equals("null")){
			JSONArray obj=new JSONArray(in);
			for (int i=0;i<obj.length();i++){
				if (obj.getString(i).equals("null"))continue;
				JSONObject obji = obj.getJSONObject(i);
				//JSONObject obj = new JSONObject(in);
				//Iterator<String> yourKeys = obj.keys();
				//while(yourKeys.hasNext()){
				//String s=yourKeys.next();
				//JSONObject obji = obj.getJSONObject(s);
				if (obji.getString("Judul").contains(input) || obji.getString("Konten").contains(input)){
					//Post tp=Post.JSONtoPost(obji.toString());
					String tp=obji.toString();
					list.add(tp);
				}
			}
			//Collections.sort(list);
		}
		return list;
	}
}
