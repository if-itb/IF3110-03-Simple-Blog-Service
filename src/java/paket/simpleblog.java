/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket;

import javax.jws.WebService;

/**
 *
 * @author Mario
 */
@WebService(serviceName = "simpleblog", portName = "simpleblogPort", endpointInterface = "service.Simpleblog", targetNamespace = "http://Service/", wsdlLocation = "WEB-INF/wsdl/simpleblog/simpleblog.wsdl")
public class simpleblog {

    public java.lang.Boolean addPost(java.lang.String judul, java.lang.String author, java.lang.String konten, java.lang.String tanggal) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean editUser(java.lang.String id, java.lang.String username, java.lang.String password, java.lang.String role, java.lang.String email) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<service.Post> listPost(java.lang.String postStatus) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean deletePost(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean restorePost(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean deleteUser(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean addComment(java.lang.String idPost, java.lang.String nama, java.lang.String email, java.lang.String komentar) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<service.User> listUser() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<service.Komentar> listComment(java.lang.String idPost) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String author, java.lang.String konten, java.lang.String tanggal) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<service.Post> search(java.lang.String query) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.Boolean publishPost(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
