/*;;


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yusuf
 */
public class UserData {

    public UserData(){
    }
    
    public org.chamerling.heroku.service.User getUser(String username) {
        return Client.getUser(username);
    }
    
    public List<org.chamerling.heroku.service.User> getListUser(){
        return Client.getListUser();
    }

    public void writeKomentar(Komentar komentar) {
        Client.addComment(komentar.getKomentator(), komentar.getEmail(), komentar.getKomen(), komentar.getPid());
    }

    public List<org.chamerling.heroku.service.Komentar> getListKomentar(String pid) {
        return Client.listComment(pid);
    }

    public void writeBlogPost(BlogPost blogPost) {
        Client.addPost(blogPost.getUid(), blogPost.getPosttitle(), blogPost.getPostcontent(), blogPost.getPostdate());
    }

    public org.chamerling.heroku.service.BlogPost getBlogPost(String pid) {
        return Client.getPost(pid);
    }

    public List<org.chamerling.heroku.service.BlogPost> getAllBlogPost() {
        return Client.listPost();
    }
    
    public List<org.chamerling.heroku.service.BlogPost> getAllUnpublishedBlogPost(){
        return Client.listUnpublishedPost();
    }
    
    public List<org.chamerling.heroku.service.BlogPost> getDeletedPosts(){
        return Client.listDeletedPost();
    }
    
    public void publishPost(String pid){
        Client.publishPost(pid);
    }
    
    public void deletePost(String pid){
        Client.deletePostPermanent(pid);
    }
    
    public void softDeletePost(String pid){
        Client.deletePost(pid);
    }
    
    public void updateUserDB(User updUser){
        Client.editUser(updUser.getUid(), updUser.getFullname(), updUser.getUsername(), updUser.getPassword(), updUser.getRole(), updUser.getEmail());
    }
    
    public void createUserDB(User newUser){
        Client.addUser(newUser.getFullname(), newUser.getUsername(), newUser.getPassword(), newUser.getEmail(), newUser.getRole());
    }
    
    public void restorePost(String pid){
        Client.restorePost(pid);
    }

}
