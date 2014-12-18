/**
 * 
 */
package org.chamerling.heroku.service;

import java.util.ArrayList;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface BlogService {
    public void SayHi(String name);
    String readUrl(String urlString) throws Exception;
    public Boolean addUser(String username, String nama, String password, String email, String role) throws InterruptedException;
    public ArrayList <DataUser> getAllUser() throws Exception;
    public Boolean updateUser(String _idFirebase, String _username, String _password, String _nama, String _email, String _role) throws InterruptedException;
    public Boolean addPost(String _judulPost, String _tanggalPost, String _kontenPost) throws InterruptedException;
    public Boolean editPost(String _idFirebase, String _judulPost, String _tanggalPost, String _kontenPost, String _publishStatus) throws InterruptedException;
    public Boolean addComment(String _idFirebasePost, String _nama, String _email, String _comment) throws InterruptedException;
    public Boolean deleteUser(String _idFirebaseUser) throws InterruptedException;
    public Boolean deletePost(String _idFirebasePost) throws InterruptedException;
    public ArrayList<Post> getAllPost();
    public ArrayList<Komentar> getAllCommentar(String _idFirebasePost);
}
