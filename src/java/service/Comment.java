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
public class Comment {
    
    // attribute
    private String id;
    private String postid;
    private String nama;
    private String email;
    private String komentar;
    
    // constructor
    public Comment() {}
    
    // getter
    public String getId() {
        return id;
    }
    public String getPostid() {
        return postid;
    }
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }
    public String getKomentar() {
        return komentar;
    }
    
    // setter
    public void setId(String id) {
        this.id = id;
    }
    public void setPostid(String postid) {
        this.postid = postid;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
