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
public class Komentar {
    private String email, komentar, nama, tanggal;

    public Komentar() {
        email="";
        komentar = "";
        nama = "";
        tanggal = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Komentar(String email, String komentar, String nama, String tanggal) {
        this.email = email;
        this.komentar = komentar;
        this.nama = nama;
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Komentar{" + "email=" + email + ", komentar=" + komentar + ", nama=" + nama + ", tanggal=" + tanggal + '}';
    }
    
}
