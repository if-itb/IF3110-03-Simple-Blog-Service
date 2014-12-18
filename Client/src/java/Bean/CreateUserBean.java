/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Database.DatabaseAccess;
import Model.User;
import Model.Users;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevinyu
 */
@ManagedBean
@RequestScoped
public class CreateUserBean {
    private User user;

    public CreateUserBean() {
        user = new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String createUser() {
        Users.getInstance().addUser(user);        
        return "new_user?faces-redirect=true";
    }
    
}
