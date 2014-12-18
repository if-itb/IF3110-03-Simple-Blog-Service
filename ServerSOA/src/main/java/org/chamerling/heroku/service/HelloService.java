/**
 * 
 */
package org.chamerling.heroku.service;

import com.tubes2.User.userPaket;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import org.json.JSONException;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	boolean addUser(String nama, String username, String password, String email, String status);
	boolean addPost(String judul, String konten, String Owner, int Status);
	boolean delUser(String username);
	boolean updateUser(String Username,String Nama, String Password, String Email, String Status);
	ArrayList<String> readUser(String Username);
	public ArrayList<String> GetPublishedPost() throws MalformedURLException, IOException, JSONException;
	public ArrayList<String> GetUnpublishedPost() throws MalformedURLException, IOException, JSONException;
	public ArrayList<String> GetDeletedPost() throws MalformedURLException, IOException, JSONException;
	public boolean AddNewPost(String Judul, String Owner, String Konten, Long tanggal) throws MalformedURLException, IOException, JSONException;
	public String GetPost(int id);
	public boolean UpdatePost(int id, String Judul, String Owner, String Konten, Long tanggal);
	public boolean DeletePost(int id);
	public boolean RecoverPost(int id);
	public boolean PublishPost(int id);
	public ArrayList<String> GetAllComment(int post_id);
	public boolean AddComment(int post_id, String nama, String email, String komentar);
	public ArrayList<String> Login(String username, String pass);
	public ArrayList<String> GetAllUser() throws MalformedURLException, IOException, JSONException;
	public ArrayList<String> Search(String input) throws MalformedURLException, IOException, JSONException;

}
