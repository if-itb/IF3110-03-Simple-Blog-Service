/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firebasews;

/**
 *
 * @author Asus
 */
public class Post {
    String id;
    String judul;
    String tanggal;
    String konten;
    String author;
    String status;

    public Post(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getKonten() {
        return konten;
    }

    public String getkontenPreview(){
        if(konten.length() > 300)
            return konten.substring(0, 300);
        else
            return konten;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
