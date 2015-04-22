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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author ASUS
 */
@ManagedBean
@SessionScoped
public class TempPostView {
    HelloService api = null;
    public String Pid="";
    public String Judul = "";
    public String Tanggal = "";
    public String Konten = "";
    
    String cmtNama = "";
    String cmtEmail = "";
    String cmtKonten = "";
    
    /**
     * Creates a new instance of TempPostView
     */
    public TempPostView() {
        api = new HelloServiceImplService().getHelloServiceImplPort();
    }
    public void viewPost(String pid) throws ClassNotFoundException, SQLException, IOException{
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
        response.sendRedirect("view_post.xhtml");
        
    }
    
    
    public String getCmtNama() {
        return cmtNama;
    }

    public String getCmtEmail() {
        return cmtEmail;
    }

    public String getCmtKonten() {
        return cmtKonten;
    }

    public void setCmtNama(String cmtNama) {
        this.cmtNama = cmtNama;
    }

    public void setCmtEmail(String cmtEmail) {
        this.cmtEmail = cmtEmail;
    }

    public void setCmtKonten(String cmtKonten) {
        this.cmtKonten = cmtKonten;
    }

    public String getPid() {
        return Pid;
    }

    public String getJudul() {
        return Judul;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public String getKonten() {
        return Konten;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    public void setKonten(String Konten) {
        this.Konten = Konten;
    }
    
    public List<org.chamerling.heroku.service.Comment> getCmts() {
        return api.listComment(Pid);
        
        
        
    }
    
    public void postCmt() throws ClassNotFoundException, SQLException{
        resetCmt();
        api.addComment(Pid,cmtNama,cmtEmail,cmtKonten);
        
    }
    
    void resetCmt(){
        cmtNama = "";
        cmtKonten = "";
        cmtEmail = "";
    }
}
