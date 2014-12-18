/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import heroku.service.UserBean;

/**
 *
 * @author calvin-pc
 */
public class Utility {
    public static heroku.service.UserBean mapToSoap (model.UserBean user) {
        heroku.service.UserBean soapUser = new heroku.service.UserBean();
        soapUser.setEmail(user.getEmail());
        soapUser.setPassword(user.getPassword());
        soapUser.setRole(user.getRole());
        soapUser.setUsername(user.getUsername());
        
        return soapUser;
    }
    
    public static heroku.service.Komentar mapToSoap (model.Komentar komentar) {
        heroku.service.Komentar soapKomentar = new heroku.service.Komentar();
        
        soapKomentar.setEmail(komentar.getEmail());
        soapKomentar.setKID(komentar.getKID());
        soapKomentar.setKomentar(komentar.getKomentar());
        soapKomentar.setNama(komentar.getNama());
        soapKomentar.setPID(komentar.getPID());
        soapKomentar.setTanggal(komentar.getTanggal());
        
        return soapKomentar;
    }
    
    public static heroku.service.Post mapToSoap (model.Post post) {
        heroku.service.Post soapPost = new heroku.service.Post();
        
        soapPost.setAuthor(post.getAuthor());
        soapPost.setDate(post.getDate());
        soapPost.setJudul(post.getJudul());
        soapPost.setKonten(post.getKonten());
        soapPost.setPID(post.getPID());
        soapPost.setPublished(post.isPublished());
        
        return soapPost;
    }
    
    public static model.UserBean soapToLocal (heroku.service.UserBean user) {
        model.UserBean soapUser = new model.UserBean();
        soapUser.setEmail(user.getEmail());
        soapUser.setPassword(user.getPassword());
        soapUser.setRole(user.getRole());
        soapUser.setUsername(user.getUsername());
        
        return soapUser;
    }
    
    public static model.Komentar soapToLocal (heroku.service.Komentar komentar) {
        model.Komentar soapKomentar = new model.Komentar();
        
        soapKomentar.setEmail(komentar.getEmail());
        soapKomentar.setKID(komentar.getKID());
        soapKomentar.setKomentar(komentar.getKomentar());
        soapKomentar.setNama(komentar.getNama());
        soapKomentar.setPID(komentar.getPID());
        soapKomentar.setTanggal(komentar.getTanggal());
        
        return soapKomentar;
    }
    
    public static model.Post soapToLocal (heroku.service.Post post) {
        model.Post soapPost = new model.Post();
        
        soapPost.setAuthor(post.getAuthor());
        soapPost.setDate(post.getDate());
        soapPost.setJudul(post.getJudul());
        soapPost.setKonten(post.getKonten());
        soapPost.setPID(post.getPID());
        soapPost.setPublished(post.isPublished());
        
        return soapPost;
    }
}
