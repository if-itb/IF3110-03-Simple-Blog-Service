import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;
import service.Post;

@Named(value = "editPost")
@SessionScoped
public class EditPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;
    
    // attribute
    private String id;
    private String judul;
    private String tanggal;
    private String konten;
    
    /**
     * Creates a new instance of EditPost
     */
    public EditPost() {
    }
    
    // getter
    public String getJudul() {
        return judul;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getKonten() {
        return konten;
    }
    public String getId() {
        return id;
    }
    
    // setter
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void setKonten(String konten) {
        this.konten = konten;
    }
    public void setId(String id) {
        this.id = id;
    }

    private Post loadPost(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadPost(id);
    }
    public void load(String id) {
        Post p = this.loadPost(id);
        this.id = p.getId();
        this.judul = p.getJudul();
        this.tanggal = p.getTanggal();
        this.konten = p.getKonten();
    }

    private Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.editPost(id, judul, tanggal, konten);
    }
    public String edit() {
        boolean b;
        b = this.editPost(this.id, this.judul, this.tanggal, this.konten);
        if(b) {
            return "index";
        }
        else {
            return null;
        }
    }
}
