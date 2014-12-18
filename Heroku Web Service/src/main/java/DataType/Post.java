/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.Date;

/**
 *
 * @author timothy.pratama
 */
public class Post {
    private String author, judul, konten, status, tanggal, id;

    public Post() {
        author ="";
        judul ="";
        konten = "";
        status = "";
        tanggal = "";
        id = "";
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Post(String author, String judul, String konten, String status, String tanggal, String id) {
        this.author = author;
        this.judul = judul;
        this.konten = konten;
        this.status = status;
        this.tanggal = tanggal;
        this.id = id;
    }
    
    
}
