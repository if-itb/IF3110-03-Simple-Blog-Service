/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Arina Listyarini DA
 */
@ManagedBean(name = "post")
@RequestScoped
public class Post {
    private String id;
    private String status;
    private String judul;
    private String tanggal;
    private String konten;
    private String deleted;
    
    public Post() {
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
    
    public String getId(){
        return id;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public String getTanggal(){
        return tanggal;
    }
    
    public String getKonten(){
        return konten;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public void setKonten(String konten){
        this.konten = konten;
    }
    
    public String printTanggal(){
        int i=1;
        while(tanggal.charAt(i) != '-'){
            i++;
        }
        int yy = Integer.parseInt(tanggal.substring(0, i));
        int it = i+1;
        do{
            i++;
        } while(tanggal.charAt(i) != '-');
        int mm = Integer.parseInt(tanggal.substring(it, i));
        int dd = Integer.parseInt(tanggal.substring(i+1, tanggal.length()));
        String m;
        switch(mm){
            case 1: m="Januari"; break;
            case 2: m="Februari"; break;
            case 3: m="Maret"; break;
            case 4: m="April"; break;
            case 5: m="Mei"; break;
            case 6: m="Juni"; break;
            case 7: m="Juli"; break;
            case 8: m="Agustus"; break;
            case 9: m="September"; break;
            case 10: m="Oktober"; break;
            case 11: m="November"; break;
            default: m="Desember"; break;
        }
        String s = Integer.toString(dd) + " " + m + " " + Integer.toString(yy);
        
        return s;
    }
}
