/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author A46CB
 */
public class Komentar {
    private String nama, email, tanggal, komentar, id_post;

    public Komentar() {
        nama = "";
        email="";
        tanggal = "";
        komentar = "";
        id_post = "";
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
    
    public String getIdPost() {
        return id_post;
    }
    
    public void setIdPost(String id_post) {
        this.id_post = id_post;
    }

    public Komentar(String nama, String email, String tanggal, String komentar, String id_post) {
        this.nama = nama;
        this.email = email;
        this.tanggal = tanggal;
        this.komentar = komentar;
        this.id_post = id_post;
    }
    
    public Komentar(String nama, String email, String tanggal, String komentar) {
        this.nama = nama;
        this.email = email;
        this.tanggal = tanggal;
        this.komentar = komentar;
    }

}

