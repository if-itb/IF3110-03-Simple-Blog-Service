/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

/**
 *
 * @author Kevin Huang
 */
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.Exception_Exception;
 
/**
 *
 * @author Kevin Huang
 */
@ManagedBean(name="UserBean",eager = true)
@SessionScoped
public class UserBean implements Serializable{
        public PostingDatabase a = new PostingDatabase();
        private List<User> ListUser;

        public UserBean() throws ClassNotFoundException, Exception_Exception{
        }

        public List<service.User> getOrderList() throws ClassNotFoundException, SQLException, Exception_Exception {
                return a.getUsers();
        }
        public void setOrderList(List<User> temp){
            ListUser = temp;
        }
//        public String saveAction() throws ClassNotFoundException, SQLException, Exception_Exception {
//
//                //get all existing value but set "editable" to false 
//                for (service.User user : a.getUsers()){
//                        user.setEditable(false);
//                }
//                //return to current page
//                return null;
//
//        }

//        public String editAction(User user) {
//                user.setEditable(true);
//                return null;
//        }
}