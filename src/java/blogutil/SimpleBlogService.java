/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blogutil;

/**
 *
 * @author M. Reza Irvanda
 */
public class SimpleBlogService {

    public static Boolean addComment(java.lang.String nama, java.lang.String email, java.lang.String konten, java.lang.String date, java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.addComment(nama, email, konten, date, idPost);
    }

    public static Boolean addPost(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.String author) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.addPost(judul, konten, tanggal, author);
    }

    public static Boolean addUser(java.lang.String nama, java.lang.String email, java.lang.String role, java.lang.String password) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.addUser(nama, email, role, password);
    }

    public static Boolean deleteComment(java.lang.String id, java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.deleteComment(id, idPost);
    }

    public static Boolean deletePost(java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.deletePost(idPost);
    }

    public static Boolean deleteUser(java.lang.String idUser) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.deleteUser(idUser);
    }

    public static Boolean editPost(java.lang.String idPost, java.lang.String judul, java.lang.String konten, javax.xml.datatype.XMLGregorianCalendar tanggal) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.editPost(idPost, judul, konten, tanggal);
    }

    public static Boolean editUser(java.lang.String idUser, java.lang.String nama, java.lang.String role, java.lang.String email, java.lang.String password) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.editUser(idUser, nama, role, email, password);
    }

    public static java.util.List<blog.Komentar> listComment(java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listComment(idPost);
    }

    public static java.util.List<blog.Post> listDeletedPost() {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listDeletedPost();
    }

    public static java.util.List<blog.Post> listPost() {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listPost();
    }

    public static java.util.List<blog.Post> listUnpublishedPost() {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listUnpublishedPost();
    }

    public static java.util.List<blog.Pengguna> listUser() {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listUser();
    }

    public static Boolean publishPost(java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.publishPost(idPost);
    }

    public static java.util.List<blog.Post> search(java.lang.String query) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.search(query);
    }

    public static Boolean softDelete(java.lang.String idPost) {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.softDelete(idPost);
    }
    
}
