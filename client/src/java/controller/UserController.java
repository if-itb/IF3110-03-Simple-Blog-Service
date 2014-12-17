package controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import service.User;

/**
 *
 * @author Ahmad Zaky
 * Kelas User Controller, mengatur login user, dan hal yang terkait dengan
 * user dan basis data
 */
@ManagedBean(name = "userController", eager = true)
@SessionScoped
public class UserController implements Serializable {

    // current active user
    private User user = null;
    
    // dummy user to store the login data
    private User dummy;
    
    private boolean rememberMe;
    private boolean invalidLogin;
    private boolean invalidEdit;

    public UserController() throws SQLException, ClassNotFoundException {
        dummy = new User();
        dummy.setRole("guest");
        // retrieve user from cookie
        Cookie cookie = CookieController.getCookie();
        if (cookie == null) {
            if (user == null) {
                user = new User();
                user.setRole("guest");
                user.setUsername("Guest");
            }
        } else {
            user = getUserByUsername(CookieController.decrypt(cookie));
        }
        invalidLogin = invalidEdit = false;
    }

    // Change the current active user
    // Show message if the process failed
    public void login() throws IOException {
        login(dummy.getUsername(), dummy.getPassword(), rememberMe);
    }

    public void login(String username, String password, boolean rememberMe) 
            throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (username.length() == 0 || password.length() == 0) {
            // field is empty
            context.addMessage("_login-form:_password", 
                    new FacesMessage("Username dan Password tidak boleh kosong!"));
            setInvalidLogin(true);
        } else {
            User _dummy = getUserByUsername(username);
            if (_dummy == null) {
                // user is not exist
                context.addMessage("_login-form:_password", 
                        new FacesMessage("Username atau Password salah!"));
                setInvalidLogin(true);
            } else if (!password.equals(_dummy.getPassword())) {
                // password mismatch
                context.addMessage("_login-form:_password", 
                        new FacesMessage("Username atau Password salah!"));
                setInvalidLogin(true);
            } else {
                this.user = _dummy;
                // set cookie if the user wants to be remembered
                if (rememberMe) {
                    CookieController.setCookie(user);
                }
                setInvalidLogin(false);
                context.getExternalContext().redirect("index.xhtml");
            }
        }
    }

    public void logout() throws IOException {
        user = new User();
        user.setId(0);
        user.setRole("guest");
        user.setUsername("Guest");
        CookieController.removeCookie();
        // refresh page
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    // Add a new user to the database
    public void addUser(String username, String password, String email, String role) {
        addUser_1(username, password, email, role);
    }

    public void addUser(User user) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (getUserByUsername(user.getUsername()) != null) {
            context.addMessage("_add-user-form:_username",
                    new FacesMessage("Username telah dipakai!"));
        } // else, execute update
        else {
            addUser_1(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        }
    }

    // Remove an existing user from the database
    public void removeUser(int id) throws SQLException {
        removeUser_1(id);
    }

    // modify an existing user from the database
    public void modifyUser(int id, String username, String password, 
            String email, String role) throws IOException {
        User _dummy = new User();
        _dummy.setUsername(username);
        _dummy.setPassword(password);
        _dummy.setEmail(email);
        _dummy.setId(id);
        _dummy.setRole(role);
        User old = getUserById(id);
        if (password.isEmpty()) {
            _dummy.setPassword(old.getPassword());
        }
        modifyUser(_dummy);
    }

    public void modifyUser(User user) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        User other = getUserByUsername_1(user.getUsername());
        if (other != null) {
            context.addMessage("_edit-user-form:_username",
                    new FacesMessage("Username telah dipakai!"));
            setInvalidEdit(true);
        } // else, execute update
        else {
            //modifyUser_1(java.lang.Integer id, java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role)
            modifyUser(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.getRole());
            setInvalidEdit(false);
        }
    }

    /* Kelompok basis data */
    // Get user by the id
    public User getUserById(int id) {
        return getUserById_1(id);
    }

    // Get user by the username
    private User getUserByUsername(String username) {
       return getUserByUsername_1(username);
    }

    // Get user list
    public List<User> getUserList() throws SQLException {
        return listUser();
    }

    /* Kelompok Getter-Setter */
    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the dummy
     */
    public User getDummy() {
        return dummy;
    }

    /**
     * @param dummy the dummy to set
     */
    public void setDummy(User dummy) {
        this.dummy = dummy;
    }

    /**
     * @return the rememberMe
     */
    public boolean isRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe the rememberMe to set
     */
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    /**
     * @return the invalidLogin
     */
    public boolean isInvalidLogin() {
        return invalidLogin;
    }

    /**
     * @param invalidLogin the invalidLogin to set
     */
    public void setInvalidLogin(boolean invalidLogin) {
        this.invalidLogin = invalidLogin;
    }

    /**
     * @return the invalidEdit
     */
    public boolean isInvalidEdit() {
        return invalidEdit;
    }

    /**
     * @param invalidEdit the invalidEdit to set
     */
    public void setInvalidEdit(boolean invalidEdit) {
        this.invalidEdit = invalidEdit;
    }

    private static boolean addUser_1(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.addUser(username, password, email, role);
    }

    private static service.User getUserById_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.getUserById(id);
    }

    private static service.User getUserByUsername_1(java.lang.String username) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.getUserByUsername(username);
    }

    private static java.util.List<service.User> listUser() {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.listUser();
    }

    private static boolean modifyUser_1(java.lang.Integer id, java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.modifyUser(id, username, password, email, role);
    }

    private static boolean removeUser_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.removeUser(id);
    }
    
}
