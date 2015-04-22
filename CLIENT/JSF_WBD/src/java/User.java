

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author kanya
 */
//@ManagedBean(name="user", eager = true)
//@SessionScoped
public class User {
    
    // Constants: roles
    private static String ROLEGUEST = "guest";
    private static String ROLEEDITOR = "editor";
    private static String ROLEOWNER = "owner";
    private static String ROLEADMIN = "admin";

    /**
     * @return the ROLEGUEST
     */
    public static String getROLEGUEST() {
        return ROLEGUEST;
    }

    /**
     * @param aROLEGUEST the ROLEGUEST to set
     */
    public static void setROLEGUEST(String aROLEGUEST) {
        ROLEGUEST = aROLEGUEST;
    }

    /**
     * @return the ROLEEDITOR
     */
    public static String getROLEEDITOR() {
        return ROLEEDITOR;
    }

    /**
     * @param aROLEEDITOR the ROLEEDITOR to set
     */
    public static void setROLEEDITOR(String aROLEEDITOR) {
        ROLEEDITOR = aROLEEDITOR;
    }

    /**
     * @return the ROLEOWNER
     */
    public static String getROLEOWNER() {
        return ROLEOWNER;
    }

    /**
     * @param aROLEOWNER the ROLEOWNER to set
     */
    public static void setROLEOWNER(String aROLEOWNER) {
        ROLEOWNER = aROLEOWNER;
    }

    /**
     * @return the ROLEADMIN
     */
    public static String getROLEADMIN() {
        return ROLEADMIN;
    }

    /**
     * @param aROLEADMIN the ROLEADMIN to set
     */
    public static void setROLEADMIN(String aROLEADMIN) {
        ROLEADMIN = aROLEADMIN;
    }
    
    // Attrbutes
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;
    
    // Methods
    
    public User() {
        id = "";
        username = "Guest";
        password = "";
        email = "";
        role = User.ROLEGUEST;
    }
    
    
    public User(String u_id, String u_username, String u_passw, String u_email, String u_role) {
        id = u_id;
        username = u_username;
        password = u_passw;
        email = u_email;
        role = u_role;
    }

    public User(ResultSet result) {
        try {
            id = result.getString("id");
            username = result.getString("username");
            password = result.getString("password");
            email = result.getString("email");
            role = result.getString("role");
        }
        catch (SQLException e) {
            id = "";
            role = User.ROLEGUEST;
            username = "Guest";
            email = password = "";
        }
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    
}
