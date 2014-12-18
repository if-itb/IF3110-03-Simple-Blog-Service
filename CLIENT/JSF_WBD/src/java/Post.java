

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.sql.Date;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;

/**
 *
 * @author ASUS
 */
//@ManagedBean
//@RequestScoped
public class Post {


    
    String Pid = "-1";
    String Judul = "";
    String Tanggal = null;
    String Konten = "";
    Boolean Published = false;
    /**
     * Creates a new instance of Post
     */
    public Post() {
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

    public Boolean isPublished() {
        return Published;
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

    public void setPublished(Boolean Published) {
        this.Published = Published;
    }
    
    
}
