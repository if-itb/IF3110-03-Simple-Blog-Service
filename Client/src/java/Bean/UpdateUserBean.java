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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kevinyu
 */
@ManagedBean
@RequestScoped
public class UpdateUserBean {
    
    @ManagedProperty(value="#{param.userId}")
    private String userId;

    private User user;

    public User getUser() {
        if (user==null){
            if (userId!=null) {
                getUserFromUserId();
            }
            else{
                user = new User();
            }
        }
        return user;
    }
    
    private void getUserFromUserId(){

        user = Users.getInstance().findUser(userId);
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String updateUser() {

        Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	user.setId(params.get("userId"));
        Users.getInstance().updateUser(this.user);

         
        return "read_user?faces-redirect=true";
    }
}
