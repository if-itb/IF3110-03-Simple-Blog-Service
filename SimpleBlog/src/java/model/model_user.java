/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities_old.Post;
import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A46CB
 */
public class model_user {    
    public model_user() {
    }
    
    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<User>();
        List<service.User> listUser = listUser();
        for(service.User user : listUser)
        {
            User temp = new User(user.getId(),user.getEmail(),user.getPassword(),user.getName(),user.getRole());
            listUsers.add(temp);
        }
        return listUsers;
    }
    
    
    public User getUser(String id) {
        User user = new User();
        service.User tempUser = getUserFromDB(id);
        user.setId(id);
        user.setEmail(tempUser.getEmail());
        user.setPassword(tempUser.getPassword());
        user.setName(tempUser.getName());
        user.setRole(tempUser.getRole()); 
        return user;
    }
    
    
    
    public String addUser(User user) {
        addUserToDB(user.getEmail(),user.getPassword(),user.getName(),user.getRole());
        
        return user.getId();
    }
    
    public String updateUser(User user) {
        editUser(user.getId(),user.getEmail(),user.getPassword(),user.getName(),user.getRole());
        
        return user.getId();
    }

    private static service.User getUserFromDB(java.lang.String id) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.getUser(id);
    }

    private static Boolean editUser(java.lang.String id, java.lang.String email, java.lang.String password, java.lang.String name, java.lang.String role) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.editUser(id, email, password, name, role);
    }

    private static Boolean addUserToDB(java.lang.String email, java.lang.String password, java.lang.String name, java.lang.String role) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.addUser(email, password, name, role);
    }

    private static java.util.List<service.User> listUser() {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.listUser();
    }
}
