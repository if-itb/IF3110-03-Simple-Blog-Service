import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;

@Named(value = "listUser")
@SessionScoped
public class ListUser implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;

    /**
     * Creates a new instance of ListUser
     */
    public ListUser() {
    }

    public java.util.List<service.User> loadUser() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadUser();
    }

    private Boolean deleteUser(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.deleteUser(id);
    }
    public String delete(String id) {
        boolean b;
        b = this.deleteUser(id);
        if(b) {
            return "user";
        }
        else {
            return null;
        }
    }
}
