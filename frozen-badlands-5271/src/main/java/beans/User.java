/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


/**
 *
 * @author asus
 */
public class User {

    /**
     * Creates a new instance of User
     */
    private String id;
    private String username;
    private String password;
    private String role;
    private String email;
    
    public User() {
    }
    
    boolean editable;
 
    public boolean isEditable() {
            return editable;
    }
    public void setEditable(boolean editable) {
            this.editable = editable;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     
}
