/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.SimpleBlogServiceHandler;

import org.wbd.heroku.service.*;

/**
 *
 * @author toshibapc
 */
public class SimpleBlogServiceHandler {

    public static boolean addComment(java.lang.String name, java.lang.String email, java.lang.String kontent, java.lang.String tanggal, java.lang.String idPost) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.addComment(name, email, kontent, tanggal, idPost);
    }


    public static boolean addUser(java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.addUser(username, password, name, email, role);
    }

    public static boolean deleteComment(java.lang.String id) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.deleteComment(id);
    }

    public static boolean deletePost(java.lang.String id) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.deletePost(id);
    }

    public static boolean deleteUser(java.lang.String id) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.deleteUser(id);
    }

    public static boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String konten, java.lang.String tanggal) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.editPost(id, judul, konten, tanggal);
    }

    public static boolean editUser(java.lang.String id, java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.editUser(id, username, password, name, email, role);
    }

    public static Post getPost(java.lang.String id) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.getPost(id);
    }

    public static java.util.List<org.wbd.heroku.service.Comment> listComment() {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.listComment();
    }

    public static java.util.List<org.wbd.heroku.service.Post> listPost(int code) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.listPost(code);
    }

    public static java.util.List<org.wbd.heroku.service.Comment> listPostComment(java.lang.String postId) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.listPostComment(postId);
    }

    public static java.util.List<org.wbd.heroku.service.User> listUser() {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.listUser();
    }

    public static java.util.List<org.wbd.heroku.service.Post> search(java.lang.String query) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.search(query);
    }

    public static boolean setPostDelete(java.lang.String id, boolean status) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.setPostDelete(id, status);
    }

    public static boolean setPostPublish(java.lang.String id, boolean status) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.setPostPublish(id, status);
    }

    public static boolean addPost(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.String idAuthor, java.lang.String pictureFilename) {
        org.wbd.heroku.service.FirebaseServiceImplService service = new org.wbd.heroku.service.FirebaseServiceImplService();
        org.wbd.heroku.service.FirebaseService port = service.getFirebaseServiceImplPort();
        return port.addPost(judul, konten, tanggal, idAuthor, pictureFilename);
    }

}




