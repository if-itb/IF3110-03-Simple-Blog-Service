/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Database.DatabaseAccess;
import Model.Comments;
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
public class DeletePostBean {
    
    @ManagedProperty(value="#{param.postId}")
    private String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
    
    public String softDeletePost() {
        Posts.getInstance().softDeletePost(postId);
        return "user_management.jsf?faces-redirect=true";
    }
    
    public String deletePost() {
        

        Posts.getInstance().removePost(postId);
        Comments.getInstance().deleteCommentByPostId(postId);
    
        
        return "deleted_post.jsf?faces-redirect=true";
    }
    
    public String undeletePost() {
        Posts.getInstance().unsoftDeletePost(postId);
        return "deleted_post.jsf?faces-redirect=true";
    }
    
}
