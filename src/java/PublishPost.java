import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;

@Named(value = "publishPost")
@SessionScoped
public class PublishPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;

    /**
     * Creates a new instance of PublishPost
     */
    public PublishPost() {
    }

    public java.util.List<service.Post> loadUnpublishedPost() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadUnpublishedPost();
    }

    private Boolean publishPost(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.publishPost(id);
    }
    public String publish(String id) {
        boolean b;
        b = this.publishPost(id);
        if(b) {
            return "publish";
        }
        else {
            return null;
        }
    }
}
