/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author ASUS
 */
@ManagedBean
@ApplicationScoped
public class Manager {
    HelloService api = null;
    Connection con = null;
    Statement stmt = null;

    
    /**
     * Creates a new instance of DataManager
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Manager() throws ClassNotFoundException, SQLException {
        api = new HelloServiceImplService().getHelloServiceImplPort();
    }
    
    
    public List<org.chamerling.heroku.service.Post> getPublishedPosts() throws SQLException{
        return api.listPublishedPost();
    }
    public List<org.chamerling.heroku.service.Post> getUnPublishedPosts() throws SQLException{        
        return api.listUnpublishedPost();
    }
    
    public Post getPost(int pid) throws SQLException{
        String q = "SELECT * FROM tb_post WHERE pid="+pid+";";
        ResultSet rs = stmt.executeQuery(q);
        Post mPost = new Post();
        mPost.Judul = rs.getString("ptitle");
        mPost.Konten = rs.getString("pcontent");
        mPost.Pid = rs.getString("pid");
        mPost.Tanggal = rs.getString("pdate");
        return mPost;
    }
    
    public void deletePost(String pid) throws SQLException, IOException{
        api.deletePost(pid);
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("home.xhtml");
    }
    public void publishPost(String pid) throws SQLException, IOException{
        api.publishPost(pid);
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("home.xhtml");
    }
    
}
