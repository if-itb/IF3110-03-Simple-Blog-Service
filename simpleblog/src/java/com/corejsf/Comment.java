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
@ManagedBean(name = "comment")
@RequestScoped
public class Comment {

    private String id;
    private String idPost;
    private String nama;
    private String email;
    private String tanggal;
    private String komentar;
    
    public Comment() {
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getId(){
        return id;
    }
    
    public String getIdPost(){
        return idPost;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTanggal(){
        return tanggal;
    }
    
    public String getKomentar(){
        return komentar;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setIdPost(String idPost){
        this.idPost = idPost;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void getEMail(String email){
        this.email = email;
    }
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public void setKomentar(String komentar){
        this.komentar = komentar;
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
