package bean;

import ClientService.DatabaseService_Service;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.xml.ws.WebServiceRef;

@ManagedBean(name ="user",eager = true)
@SessionScoped
public class User implements Serializable
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;
    private String username;
    private String password;
    private String email;
    private String role;
    private String id;
    private List<User> daftar_user;
    private final CookieBean cookie;
    
    public User() 
    {
        username="";
        password="";
        role="";
        email="";
        id="";
        daftar_user = new ArrayList<>();
        cookie = new CookieBean();
    }

    public User(String username, String password, String email, String role, String id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.id = id;
        cookie = new CookieBean();
    }
    
    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getGreeting()
    {
        System.out.println("Get Greetings");
        if("".equals(username))
        {
            System.out.println("NULL");
            return null;
        }
        else
        {
            return "Welcome, "+username+"!";
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getDaftar_user() {
        fetchUsersFromDB();
        return daftar_user;
    }
    
    public String getHome()
    {
        if("".equals(username))
        {
            return "index";
        }
        else
        {
            return role;
        }
    }
    
    public String getUserLogin()
    {
        if("".equals(username))
        {
            return "false";
        }
        else
        {
            return "true";
        }
    }
    
    public void logout()
    {
        System.out.println("logout");
        System.out.println("setting cookie");
        cookie.setCookie("username", username, 0);
        username="";
        email="";
        role="";
        password="";
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try 
        {
            context.redirect(context.getRequestContextPath() + "/index.xhtml");
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void register()
    {
        addUser(username, password, email, role);
    }
    
    public void fetchUsersFromDB()
    {
        daftar_user = new ArrayList<>();
        List<ClientService.User> listUser = listUser();
        for(ClientService.User u : listUser)
        {
            String email = u.getEmail();
            String id = u.getId();
            String password = u.getPassword();
            String username = u.getUsername();
            String role = u.getRole();
            User temp = new User(username, password, email, role, id);
            daftar_user.add(temp);
        }
    }
    
    public List<User> getUserFromDB()
    {
        List<User>list = new ArrayList<>();
        List<ClientService.User> listUser = listUser();
        for(ClientService.User u : listUser)
        {
            String id1 = u.getId();
            String email1 = u.getEmail();
            String password1 = u.getPassword();
            String role1 = u.getRole();
            String username1 = u.getUsername();
            User temp = new User(username1, password1, email1, role1, id1);
            list.add(temp);
        }
        return list;
    }
    
    public void login()
    {
        System.out.println("Login");
        System.out.println("Setting cookie");
        cookie.setCookie("username", username, 86400);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try 
        {            
            context.redirect(context.getRequestContextPath() + "/" + role + ".xhtml");
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }

    public String getAvail()
    {
        System.out.println("check Available");
        Boolean available = true;
        String result = "";
        fetchUsersFromDB();
        for (User daftar_user1 : daftar_user) {
            if (daftar_user1.getUsername().equals(username)) {
                result = "<div class=\"alert alert-danger login-alert\">username already exist</div>\n";
                available = false;
                break;
            }
        }
        if(available)
        {
            register();
            login();
        }
        return result;
    }
    public String getAuth()
    {
        System.out.println("auth");
        String output ="";
        Boolean match = false;
        fetchUsersFromDB();
        for(User user : daftar_user)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                match = true;
                role = user.role;
                email = user.email;
                id = user.id;
                break;
            }
        }
        if(match)
        {
            login();
        }
        else
        {
            output = "<div class=\"alert alert-danger login-alert\">wrong username or password</div>\n";
        }
        return output;
    }
    
    public void checkCookie()
    {
        Cookie temp = cookie.getCookie("username");
        if(temp != null)
        {
            if(temp.getValue().length()>0)
            {
                fetchUsersFromDB();
                for(User user : daftar_user)
                {
                    if(user.getUsername().equals(temp.getValue()))
                    {
                        username = user.getUsername();
                        password = user.getPassword();
                        role = user.getRole();
                        email = user.getEmail();
                        id = user.getId();
                        login();
                    }
                }
            }
        }
    }

    private java.util.List<ClientService.User> listUser() {
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.listUser();
    }

    private Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.addUser(username, password, email, role);
    }
    
}