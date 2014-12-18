import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;

@Named(value = "addPost")
@SessionScoped
public class AddPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;

    /**
     * Creates a new instance of AddPost
     */
    public AddPost() {
    }

    private Boolean addPost(java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.addPost(judul, tanggal, konten);
    }
    public String add(String judul, String tanggal, String konten) {
        boolean b;
        b = this.addPost(judul, tanggal, konten);
        if(b) {
            return "index";
        }
        else {
            return null;
        }
    }
}
