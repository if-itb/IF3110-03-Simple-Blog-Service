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
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import simpleblog.heroku.service.IOException_Exception;
import simpleblog.heroku.service.SimpleblogService;
import simpleblog.heroku.service.SimpleblogServiceImplService;
import simpleblog.heroku.service.Post;

/**
 *
 * @author Luqman
 */
@ManagedBean
@ViewScoped
public class PublishPostController {

    public List<Post> getPostList() throws SQLException, NamingException, IOException_Exception
    {
        SimpleblogService service = new SimpleblogServiceImplService().getSimpleblogServiceImplPort();
        return service.getPostList(0);
    }
    public String publishPost(int post_id)
    {
        DataSource ds;
        try {
            Date dates = new Date();
            System.out.println("UPDATE post SET status=1 WHERE id = '"+ post_id +"'");
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/simpleBlogDb");
            
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE post SET status=1 WHERE id = '"+ post_id +"'");
            ps.executeUpdate();
            con.close();
            ps.close();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } 
    }
}
