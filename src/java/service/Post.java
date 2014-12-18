/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author A 46 CB i3
 */
public class Post {
    
    // attribute
    private String id;
    private String judul;
    private String tanggal;
    private String konten;
    private String status;
    
    // constructor
    public Post() {}
    
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
    public String getStatus() {
        return status;
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
    public void setStatus(String status) {
        this.status = status;
    }
}
