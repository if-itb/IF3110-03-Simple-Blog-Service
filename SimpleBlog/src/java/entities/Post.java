/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author A46CB
 */
public class Post {
    private String id, judul, tanggal, konten, status, is_deleted;

    public Post() {
        id ="";
        judul ="";
        tanggal = "";
        konten = "";
        status = "";
        is_deleted = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getIsDeleted() {
        return is_deleted;
    }

    public void setIsDeleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Post(String id, String judul, String tanggal, String konten, String status, String is_deleted) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.konten = konten;
        this.status = status;
        this.is_deleted = is_deleted;
    }
    
    public Post(String id, String judul, String tanggal, String konten, String status) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.konten = konten;
        this.status = status;
    }
    
    
}
