
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kanya
 */
@ManagedBean( name = "userController", eager = true)
@SessionScoped
public class UserController {
    
    
    HelloService api = null;
    Connection con = null;
    Statement stmt = null;
   
    private User currentUser = new User();
    public UserController(){
       api = new HelloServiceImplService().getHelloServiceImplPort();
    }
    
    //Cookie
    
     // set cookie according to current user
  
    
  public User getUserByUsername(String username) {
      
        try {
            String q = "SELECT * FROM `user` WHERE `username` = ?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(q);
            String[] uname = new String[]{username};
            for (int i = 0; i < uname.length; i++) {
                ps.setString(i+1, uname[i]);
            }
            ResultSet result = stmt.executeQuery(q);
            while (result.next()) {
                return new User(result);
            }
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    public void addUser(String usern, String passw, String mail, String rol) throws SQLException, IOException {
        
        api.addUser(usern, mail, rol, passw);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("manageuser.xhtml");
        
    }
    
    public void deleteUser(String id) throws SQLException, IOException {
        
        api.deleteUser(id);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("manageuser.xhtml");
        
        
    }
    
    public void editUser(String id, String usern, String passw, String mail, String rol) throws SQLException, IOException{
        
        
        if(true){
            
            currentUser.setId(id);
            currentUser.setEmail(mail);
            currentUser.setPassword(passw);
            currentUser.setRole(rol);
            currentUser.setUsername(usern);
            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("edit_user.xhtml");
        }
        
        
        
        
    }
    
    public void updateUser(String id, String usern, String passw, String mail, String rol){
        
        
        try {
            api.editUser(id, usern, rol, mail, passw);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("manageuser.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<org.chamerling.heroku.service.User> getListUser() throws SQLException {

        return api.listUser();
    }

    /**
     * @return the currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

   
}

