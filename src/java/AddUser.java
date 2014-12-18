import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;

@Named(value = "addUser")
@SessionScoped
public class AddUser implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;

    /**
     * Creates a new instance of AddUser
     */
    public AddUser() {
    }

    private Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.addUser(username, password, email, role);
    }
    public String add(String username, String password, String email, String role) {
        boolean b;
        b = this.addUser(username, password, email, role);
        if(b) {
            return "user";
        }
        else {
            return null;
        }
    }
}
