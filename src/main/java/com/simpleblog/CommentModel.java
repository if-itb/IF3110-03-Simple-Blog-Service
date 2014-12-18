/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simpleblog;

/**
 *
 * @author user
 */
public class CommentModel {

    private String tanggal;
    private String konten;
    private String id;
    private String email;
    private String nama;
    
    public String getEmail(){
        return email;
    }
    
    public String getTanggal(){
        return this.tanggal;
    }
    
    public String getKonten(){
        return this.konten;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setKonten(String id){
        this.konten = id;
    }
    
    public void setTanggal(String id){
        this.tanggal = id;
    }
    
    public void setNama(String id){
        this.nama=id;
    }
    
    public void setEmail(String name){
        email = name;
    }
}


