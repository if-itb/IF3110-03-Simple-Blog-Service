/**
 * 
 */
package org.chamerling.heroku.service;

import Model.Comment;
import Model.Post;
import Model.User;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface SimpleBlog {
        
        boolean addUser (String username,String password,String role,String name,String email) throws InterruptedException ;
        
        boolean validate(String username,String password);
        
        User getUser(String username);
        
        List<User> getAllUser();
        
        boolean editUser(String user,String username,String password,String role,String name,String email) throws InterruptedException ;
        
        boolean delUser(String username) throws InterruptedException ;
        
        boolean addPost (String title,String image, String date, String content, String author, boolean published) throws InterruptedException ;
        
        Post getPost(String pid) ;
        
        List<Post> getAllPost () ;
        
        List<Post> getPostbyAuthor(String username) ;
        
        List<Post> getAllDraft () ; 
        
        List<Post> getDraftbyAuthor(String username) ;
        
        List<Post> getAllDeleted () ; 
        
        List<Post> getDeletedbyAuthor(String username) ;
        
        List<Post> searchPost(String query) ;
        
        boolean editPost(String pid,String title,String image, String date, String content, String author, boolean published) throws InterruptedException;
        
        boolean hardDelPost(String pid) throws InterruptedException ;
        
        boolean softDelPost(String pid) throws InterruptedException ;
        
        boolean restorePost(String pid) throws InterruptedException ;
        
        boolean publishPost(String pid) throws InterruptedException ;
        
        boolean addComment (String pid,String name,String email,String content) throws InterruptedException ;
        
        List<Comment> getComment (String pid) ;
}
