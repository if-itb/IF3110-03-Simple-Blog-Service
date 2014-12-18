/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Database.DatabaseAccess;
import Model.User;
import Model.Users;
import Test.UsersTest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevinyu
 */
@ManagedBean
@RequestScoped
public class DeleteUserBean {
    
    private User user;
    
    @ManagedProperty(value="#{param.userId}")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public DeleteUserBean() {
        this.user = new User();
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
    
    public String deleteUser() {
        user.setId(userId);
        Users.getInstance().deleteUserByUserId(user);
        return "read_user?faces-redirect=true";
    }
    
}
