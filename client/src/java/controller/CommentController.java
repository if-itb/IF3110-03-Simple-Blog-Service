package controller;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.Comment;

/**
 *
 * @author Eldwin Christian
 * Kelas Comment Controller, menambah komentar serta mengambil list
 * komentar dari basis data
 */
@ManagedBean(name="commentController")
@SessionScoped
public class CommentController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    // the comment attributes
    private String content;
    private String title;
    private String time;
    
    public CommentController() throws SQLException, ClassNotFoundException{
    }
    
    public void addComment(Integer postId, String name, String email, String content) throws SQLException{
        addComment_1(postId, name, email, content);
    }
    
    // get all comments for specific post
    public List<Comment> getListComment(Integer postId) throws SQLException{
        return listComment(postId);
    }
    
    /* Kelompok Getter-Setter */
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    private static boolean addComment_1(java.lang.Integer postid, java.lang.String nama, java.lang.String email, java.lang.String konten) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.addComment(postid, nama, email, konten);
    }

    private static java.util.List<service.Comment> listComment(java.lang.Integer postid) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.listComment(postid);
    }
    
}
