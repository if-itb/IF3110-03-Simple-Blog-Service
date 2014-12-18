import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;
import service.User;

@Named(value = "editUser")
@SessionScoped
public class EditUser implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;
    
    // attribute
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;
    
    /**
     * Creates a new instance of EditUser
     */
    public EditUser() {
    }
    
    // getter
    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getRole() {    
        return role;
    }
    
    // setter
    public void setId(String id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(String role) {    
        this.role = role;
    }
    
    private java.util.List<service.User> loadUser() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadUser();
    }
    public void load(String id) {
        List<User> user = this.loadUser();
        int i = 0;
        boolean found = false;
        while(i < user.size() && !found) {
            if(user.get(i).getId().equals(id)) {
                this.id = user.get(i).getId();
                this.username = user.get(i).getUsername();
                this.password = user.get(i).getPassword();
                this.email = user.get(i).getEmail();
                this.role = user.get(i).getRole();
                found = true;
            }
            else {
                i++;
            }
        }
    }

    private Boolean editUser(java.lang.String id, java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.editUser(id, username, password, email, role);
    }
    public String edit() {
        boolean b;
        b = this.editUser(this.id, this.username, this.password, this.email, this.role);
        if(b) {
            return "user";
        }
        else {
            return null;
        }
    }
}
