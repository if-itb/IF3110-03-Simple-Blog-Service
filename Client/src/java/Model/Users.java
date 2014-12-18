/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.List;
import org.penguasadunia.PenguasaDuniaService;
import org.penguasadunia.PenguasaDuniaService_Service;
import org.penguasadunia.ServiceUser;

/**
 *
 * @author kevinyu
 */
public class Users {
    private static Users instance;
    PenguasaDuniaService serviceEndpoint;
    
    private Users() {
        serviceEndpoint = new PenguasaDuniaService_Service().getPenguasaDuniaServicePort();
    }
    
    public static Users getInstance() {
        if (instance==null){
            instance = new Users();
            
        }
        return instance;
    }
    
    public ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<User>();
        List<ServiceUser> serviceUsers = serviceEndpoint.listServiceUser();
        for (ServiceUser serviceUser : serviceUsers) {
            User user = new User();
            user.setEmail(serviceUser.getEmail());
            user.setId(serviceUser.getKey());
            user.setPassword(serviceUser.getPassword());
            user.setRole(serviceUser.getRole());
            user.setUsername(serviceUser.getUsername());
            users.add(user);
        }
        return users;
    }
    
    public User findUser(String userId) {
        ArrayList<User> users = getAllUser();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
    
    public User validateUser(String username,String password) {
        ArrayList<User> users = getAllUser();
        for (User user : users) {
            if ((user.getUsername().equals(username)) && (user.getPassword().equals(password))) {
                return user;
            }
        }
        return null;
    }
    
    public void addUser(User user) {
       serviceEndpoint.addServiceUser(user.getUsername(), user.getEmail(), user.getRole(), user.getPassword());
    }
    
    public void updateUser(User user) {
        serviceEndpoint.editServiceUser(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
    
    public void deleteUserByUserId(User user) {
       serviceEndpoint.deleteServiceUser(user.getId());
    }
}
