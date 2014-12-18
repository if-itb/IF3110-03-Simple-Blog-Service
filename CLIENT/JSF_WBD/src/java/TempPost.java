/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 
 * @author ASUS
 */
@ManagedBean(name="tempPost", eager = true)
@RequestScoped
public class TempPost {
    HelloService api = null;
    public String Id;
    public String Judul = "";
    public String Tanggal = "";
    public String Konten = "";
    /**
     * Creates a new instance of TempPost
     */
    public TempPost() {        
        api = new HelloServiceImplService().getHelloServiceImplPort();
    }
    public void reset(){
            Id = "";
            Judul = "";
            Tanggal = "";
            Konten = "";
    }
    public void submitPost() throws ClassNotFoundException, SQLException, IOException{
            api.addPost(Judul, Konten, Tanggal);
            

            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("home.xhtml");    
    
    
    }
    public String getJudul(){
        return Judul;
    }
    public String getTanggal(){
        return Tanggal;
    }
    public String getKonten(){
        return Konten;
    }
    public String getId(){
        return Id;
    }
    public void setJudul(String s){
        Judul = s;
    }
    public void setTanggal(String d){
        Tanggal = d;
    }
    public void setKonten(String s){
        Konten = s;
    }
    public void setId(String i){
        Id = i;
    }
}
