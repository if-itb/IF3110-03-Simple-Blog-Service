/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructure;

/**
 *
 * @author wira gotama
 */
public class Comment {
    private String key, email, guest, id_post, id_user, komentar, tanggal, username;
    
    public Comment(String key, String email, String guest, String id_post, String id_user, String komentar, String tanggal, String username) {
        this.key = key;
        this.email = email;
        this.guest = guest;
        this.id_post = id_post;
        this.id_user = id_user;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.username = username;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getGuest() {
        return guest;
    }
    
    public String getIdPost() {
        return id_post;
    }
    
    public String getIdUser() {
        return id_user;
    }
    
    public String getKomentar() {
        return komentar;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setGuest(String guest) {
        this.guest = guest;
    }
    
    public void setIdPost(String id_post) {
        this.id_post = id_post;
    }
    
    public void setIdUser(String id_user) {
        this.id_user = id_user;
    }
    
    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}
