package Database;

import Model.User;
import Helper.MD5;
import Helper.CookieHelper;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import org.chamerling.heroku.service.InterruptedException_Exception;
import org.chamerling.heroku.service.SimpleBlog;
import org.chamerling.heroku.service.SimpleBlogImplService;

/**
 * Representation of data user
 * @author Luthfi Hamid Masykuri
 * @modified Riva Syafri Rachmatullah
 */
@ManagedBean(name="UserData")
@RequestScoped
public class UserData implements Serializable {
    private String CookieData;
    private CookieHelper cook;
    private String username;
    
    /**
     * Create an instance of UserData
     */
    public UserData() {
        CookieData = "user_blog";
        cook = new CookieHelper();
    }
    
    /**
     * Get user by its username from database
     * @param user the username
     * @return an instance of user from database
     */
    public User getUser(String username) {
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        org.chamerling.heroku.service.User user = SB.getUser(username);
        User user_r = new User(user);
        return user_r;
    }
    
    /**
     * Validate user and pass
     * @param user username input
     * @param pass password input
     * @return String status to pass
     */
    public String validate(String user,String pass) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        if (SB.validate(user, pass))
        {
            cook.setCookie(CookieData,user, 24*3600);
            return "valid";
        }
        else
        {
            facesContext.addMessage("loginForm", new FacesMessage("Username or password is incorrect"));
            return null;
        }
    }
    
    /**
     * Add new user to database
     * @param user an instance of user that want to be added to database
     * @return String status to pass
     */
    public String addUser(User user) throws InterruptedException_Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();
        String name = user.getName();
        String email = user.getEmail();
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        boolean query = SB.addUser(username, password, role, name, email);
        if (query) {
            return "success";
        } else {
            return "failed";
        }
    }
    
    /**
     * Update a tuple of user in database with an instance of user
     * @param username the username in database that want to be found
     * @param user new instance of user that will change the tuple of data selected
     * @return String status to pass
     */
    public String updateUser(User user) throws InterruptedException_Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();
        String name = user.getName();
        String email = user.getEmail();
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        boolean query = SB.editUser(username,username, password, role, name, email);
        if (query) {
            return "success";
        } else {
            return "failed";
        }
    }
    
    /**
     * Get all user from database
     * @return list of user
     */
    public List<User> getAllUser() {
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        List<User> LS = new LinkedList();
        for (org.chamerling.heroku.service.User usr : SB.getAllUser())
        {
            User user = new User(usr);
            LS.add(user);
        }
        
        return LS;
    }
    
    /**
     * Delete user from database
     * @param username the deleted username
     * @return String status to pass
     */
    public String delUser(String username) throws InterruptedException_Exception {
        SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
        boolean deleted = SB.delUser(username);
        return "deleted";
    }
    
    /**
     * Get which user is logged in
     * @return the user which is logged in
     */
    public User userLoggedIn() {
        Cookie cookie = cook.getCookie(CookieData);
        if (cookie != null) {
            String username = cookie.getValue();
            User user = this.getUser(username);
            return user;
        } else {
            return null;
        }
    }
    
    /**
     * Check whether any user is logged in web
     * @return boolean status
     */
    public boolean is_logged_in() {
        Cookie cookie = cook.getCookie(CookieData);
        return (cookie != null);
    }
    
    /**
     * Log out from web
     * @return boolean status
     */
    public boolean logout() {
        cook.setCookie(CookieData, "", 0);
        return true;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public static void main (String args[])
    {
        UserData user_data = new UserData();
        System.out.println(user_data.validate("admin", "admin"));
    }
}
