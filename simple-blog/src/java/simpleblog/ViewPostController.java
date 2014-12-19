/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simpleblog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import simpleblog.heroku.service.IOException_Exception;
import simpleblog.heroku.service.SimpleblogService;
import simpleblog.heroku.service.SimpleblogServiceImplService;
import simpleblog.heroku.service.Comment;
import simpleblog.heroku.service.Post;
import simpleblog.model.ViewPost;

/**
 *
 * @author Luqman
 */
@ManagedBean(eager=true)
@ViewScoped
public class ViewPostController {
    private int postId;
    private Post viewPost;

    public void getPost() throws IOException_Exception
    {
        SimpleblogService service = new SimpleblogServiceImplService().getSimpleblogServiceImplPort();
        Post post = service.getPost(postId);
        viewPost = post;
        System.out.println("<><> "+post.getId());
        System.out.println("<><> "+post.getTitle());
        System.out.println("<><> "+post.getDate());
        System.out.println("<><> "+post.getContent());
    }
    
    private String inputName;
    private String inputEmail;
    private String inputComment;
       
    public List<Comment> getComment() throws IOException_Exception
    {
        List<Comment> list = new ArrayList<Comment>();
        try {
            System.out.println("Bakemono "+inputName);
            System.out.println("Bakemono "+inputEmail);
            System.out.println("Bakemono "+inputComment);
            DataSource ds;
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/simpleBlogDb");
            
            Connection con = ds.getConnection();
            
            PreparedStatement ps;
            ResultSet result;
            if(getInputName() != null && getInputName() != "")
            {
                System.out.println("Bakemono : "+"INSERT INTO comment (post_id,name,email,content) VALUES ('"+postId+"','"+getInputName()+"','"+getInputEmail()+"','"+getInputComment()+"')");
                ps = con.prepareStatement("INSERT INTO comment (post_id,name,email,content) VALUES ('"+postId+"','"+getInputName()+"','"+getInputEmail()+"','"+getInputComment()+"')");
                ps.executeUpdate();
                setInputName(null);
                setInputEmail(null);
                setInputComment(null);
            }
            SimpleblogService service = new SimpleblogServiceImplService().getSimpleblogServiceImplPort();
            list = service.getCommentList(postId);
        } catch (NamingException ex) {
            Logger.getLogger(ViewPostController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * @return the postId
     */
    public int getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * @return the viewPost
     */
    public Post getViewPost() {
        return viewPost;
    }

    /**
     * @param viewPost the viewPost to set
     */
    public void setViewPost(Post viewPost) {
        this.viewPost = viewPost;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputComment() {
        return inputComment;
    }

    public void setInputComment(String inputComment) {
        this.inputComment = inputComment;
    }
    
}
