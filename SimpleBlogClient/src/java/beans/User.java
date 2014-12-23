/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;

/**
 *
 * @author asus
 */
@ManagedBean(name="User")
@SessionScoped
public class User {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/frozen-badlands-5271.herokuapp.com/HelloService.wsdl")
    private HelloServiceImplService service;

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
    
     public String setDB(String id) throws ClassNotFoundException, IOException_Exception, MalformedURLException_Exception {
        java.util.List<org.chamerling.heroku.service.User> list = listUser();
        for (org.chamerling.heroku.service.User user : list){
            if (user.getId().equals(id)){
                this.id = user.getId();
                username = user.getUsername();
                password = user.getPassword();
                email = user.getEmail();
                role = user.getRole();
                break;
            }
        }
        return "edit user";
    }
    
    public String insertUser() throws ClassNotFoundException {
        addUser(username, email, role, password);
        return "insert";
    }
    
    public String editUser(String id) throws ClassNotFoundException{
        editUser_1(id, username, role, email, password);
        return "edit";
    }
    
    public String hapusUser(String id) throws ClassNotFoundException {
        deleteUser(id);
        return "hapus";
    }
    
    public String goToInsertPage() {
        return "insert user";
    }
    
    public void initUser () {
        username = "";
        password = "";
        email = "";
        role = "";
    }

    private java.util.List<org.chamerling.heroku.service.User> listUser() throws MalformedURLException_Exception, IOException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listUser();
    }

    private boolean deleteUser(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deleteUser(arg0);
    }

    private boolean editUser_1(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editUser(arg0, arg1, arg2, arg3, arg4);
    }

    private boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addUser(arg0, arg1, arg2, arg3);
    }

    
}
