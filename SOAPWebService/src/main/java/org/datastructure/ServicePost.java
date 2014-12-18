/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.datastructure;

/**
 *
 * @author wira gotama
 */
public class ServicePost {
    private String deleted, published, id_user, judul, konten, tanggal, key;

    public ServicePost() {
    	
    }
    
    public ServicePost(String key, String deleted, String published, String id_user, String judul, String konten, String tanggal) {
        this.deleted = deleted;
        this.published = published;
        this.id_user = id_user;
        this.judul = judul;
        this.konten = konten;
        this.tanggal = tanggal;
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getIdAuthor() {
        return id_user;
    }
    
    public String getStatusDeleted() {
        return deleted;
    }

    public String getStatusPublished() {
        return published;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public String getKonten() {
        return konten;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public void setIdAuthor(String id_user) {
        this.id_user = id_user;
    }
    
    public void setStatusDeleted(String deleted) {
        this.deleted = deleted;
    }
    
    public void setStatusPublished(String published) {
        this.published = published;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public void setKonten(String konten) {
        this.konten = konten;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
