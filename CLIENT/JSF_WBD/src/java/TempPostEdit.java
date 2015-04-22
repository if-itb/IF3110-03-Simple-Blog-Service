/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 
 * @author ASUS
 */
@ManagedBean(name="tempPostEdit", eager = true)
@SessionScoped
public class TempPostEdit {
    public String Pid;
    public String Judul = "";
    public String Tanggal = "";
    public String Konten = "";
    HelloService api = null;

    public TempPostEdit() {  
        api = new HelloServiceImplService().getHelloServiceImplPort();
    }
    public void editPost(String pid) throws ClassNotFoundException, SQLException, IOException{
        List<org.chamerling.heroku.service.Post> tempL = api.listPublishedPost();
        for(int i = 0; i< tempL.size(); ++i){
            if(tempL.get(i).getPid().equals(pid)){
                Pid = tempL.get(i).getPid();
                Judul = tempL.get(i).getJudul();
                Tanggal = tempL.get(i).getTanggal();
                Konten = tempL.get(i).getKonten();
            }
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("edit_post.xhtml");
    
    }
    public void submitEdit() throws ClassNotFoundException, SQLException, IOException{
            api.editPost(Pid, Judul, Konten, Tanggal, Boolean.TRUE);
            
            

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
    public String getPid(){
        return Pid;
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
    public void setPid(String i){
        Pid = i;
    }
}
