import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;
import service.Post;

@Named(value = "viewPost")
@SessionScoped
public class ViewPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;
    
    // attribute
    private String id;
    private String judul;
    private String tanggal;
    private String konten;
    
    /**
     * Creates a new instance of ViewPost
     */
    public ViewPost() {
    }
    
    // getter
    public String getId() {
        return id;
    }
    public String getJudul() {
        return judul;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getKonten() {
        return konten;
    }
    
    // setter
    public void setId(String id) {
        this.id = id;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void setKonten(String konten) {
        this.konten = konten;
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

    public java.util.List<service.Comment> loadComment(java.lang.String postid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadComment(postid);
    }

    private Boolean addComment(java.lang.String postid, java.lang.String nama, java.lang.String email, java.lang.String komentar) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.addComment(postid, nama, email, komentar);
    }
    public void add(String nama, String email, String komentar) {
        boolean b;
        b = this.addComment(this.id, nama, email, komentar);
        nama = null;
        email = null;
        komentar = null;
    }
}
