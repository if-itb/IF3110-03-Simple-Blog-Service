/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Database.DatabaseAccess;
import Model.Post;
import Model.Posts;
import Test.UsersTest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevinyu
 */
@ManagedBean
@RequestScoped
public class EditPostBean {
    
    @ManagedProperty(value="#{param.postId}")
    private String postId;
    
    private Post post;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Post getPost() {
        if (post==null) {
            if (postId!=null){
                getPostFromPostId();
            }
            else {
                post = new Post();
            }
        }
        return post;
    }
    
    private void getPostFromPostId() {
        post = Posts.getInstance().findPost(postId);
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
    public String editPost() {
        post.setId(postId);
        Posts.getInstance().updatePostDB(post);

        return "user_management.jsf";
        
    }
    
}
