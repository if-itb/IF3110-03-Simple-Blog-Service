/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket;

/**
 *
 * @author Mario
 */
public class Post {
    
    String judul, tanggal, konten, id;
    Boolean ispublished, del;

//    Post(String id, String judul, String tanggal, String konten, boolean ispublished, boolean del) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//        //To change body of generated methods, choose Tools | Templates.
//        this.id=id;
//        this.judul=judul;
//        this.tanggal=tanggal;
//        this.konten=konten;
//        this.ispublished=ispublished;
//        this.del=del;
//    }
    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIspublished() {
        return ispublished;
    }

    public void setIspublished(Boolean ispublished) {
        this.ispublished = ispublished;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }    
}
