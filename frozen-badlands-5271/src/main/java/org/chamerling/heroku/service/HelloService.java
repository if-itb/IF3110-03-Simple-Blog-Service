/**
 * 
 */
package org.chamerling.heroku.service;

import beans.Komentar;
import beans.Post;
import beans.User;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.jws.WebService;
import org.codehaus.jettison.json.JSONException;

/**
 * @author 
 * 
 */
@WebService
public interface HelloService {
        
        boolean deletePost(String key);
        boolean editPost(String key, String judul, String tanggal, String konten);
        boolean publishPost(String key);
        boolean editUser(String key, String nama, String role, String email, String password);
        boolean deleteUser(String key);
        boolean deleteComment(String keypost, String keycomment);
        boolean addPost( String judul, String tanggal, String konten);
        boolean addUser(String nama, String email, String role, String password);
        boolean addComment( String id_post, String nama, String email, String waktu, String kontent);
        List<Post> listPost() throws MalformedURLException, IOException;
        List<User> listUser() throws MalformedURLException, IOException;
        List<beans.Post> search(String query);
        List<Komentar> listComment(String id_post) throws MalformedURLException, IOException;
}
