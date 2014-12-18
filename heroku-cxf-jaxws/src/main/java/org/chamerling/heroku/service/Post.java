/* Kelas: Post.java
 */
package org.chamerling.heroku.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Try Ajitiono + Rakhmatullah Yoga Sutrisna
 */
public class Post {
    /**
     * Atribut-atribut
     */
    public String idFirebasePost;
    public int idPost;
    public String judulPost;
    public String tanggalPost;
    public String kontenPost;
    public int publishStatus;
    public boolean cookieOn;
    private User user;
    
    /**
     * Konstruktor Post, gunanya untuk membuat objek user
     */
    public Post() {
        user = new User();
    }
    
    public void setIdFirebase(String _idFirebasePost)
    {
        idFirebasePost = _idFirebasePost;
    }
    
    public void setJudulPost(String _judul)
    {
        judulPost = _judul;
    }
    
    public void setTanggal(String _tanggal)
    {
        tanggalPost = _tanggal;
    }
    public void setKonten(String _konten)
    {
        kontenPost = _konten;
    }
    
    /**
     * Menambahkan komentar ke dalam basis data
     * @param ID 
     * @return  HTML script untuk memuat komentar yang akan digunakan oleh AJAX
     * @throws java.sql.SQLException 
     */
    public String LoadComment(int ID) throws SQLException {
        //login database
        String HTMLcode = "";
        
        return HTMLcode;
    }
    /**
     * @param PostID
     * @param nama
     * @param email
     * @param comment
     * @throws SQLException 
     */
    public void AddComment(int PostID, String nama, String email, String comment) throws SQLException {
        
    }
    /**
     * Menambahkan header message pada halaman utama blog
     * @return header tulisan yang dikembalikan ke halaman utama
     * @throws SQLException
     */
    public String showMessageHeader() throws SQLException {
        String header;
        if (cookieOn) {
            header = "Welcome " + user.getUsername() + ", your role is " + user.getRole() + 
                     "<li> <form action=\"/IF3110-02-Simple-Blog-Java/LogoutServlet\" method=\"post\">\n" +
                     "<input type=\"submit\" value=\"Logout\" >\n" +
                     "</form> </li>" +
                     "<a href=\"/IF3110-02-Simple-Blog-Java/admin/index.jsp\"><div align=\"right\"><li><font color=\"blue\">Dashboard</font></li></div></a>";
        }
        else {
            header = "Welcome guest, please login below.<br>\n" +
        "           <form action=\"LoginServlet\" method=\"POST\">\n" +
        "            <input type=\"text\" name=\"username\" placeholder=\"username\"/>\n" +
        "            <input type=\"password\" name=\"password\" placeholder=\"password\"/>\n" +
        "            <input type=\"submit\" value=\"Login\"/>\n" +
        "           </form>";
        }
        return header;
    }
    
    /**
     * Menambahkan header message pada halaman manajemen blog
     * @return header tulisan yang dikembalikan ke halaman utama
     * @throws SQLException
     */
    public String showManagementHeader() throws SQLException {
        String header;
        if (cookieOn) {
            header = "Welcome " + user.getUsername() + ", your role is " + user.getRole() + 
                     "<li> <form action=\"/IF3110-02-Simple-Blog-Java/LogoutServlet\" method=\"post\">\n" +
                     "<input type=\"submit\" value=\"Logout\" >\n" +
                     "</form></li>" +
                     "<br><a href=\"/IF3110-02-Simple-Blog-Java/admin/index.jsp\"><div align=\"right\"><li><font color=\"blue\">Dashboard</font></li></div></a>";
        }
        else {
            header = "Welcome guest, please login below.<br>\n" +
        "           <form action=\"LoginServlet\" method=\"POST\">\n" +
        "            <input type=\"text\" name=\"username\" placeholder=\"username\"/>\n" +
        "            <input type=\"password\" name=\"password\" placeholder=\"password\"/>\n" +
        "            <input type=\"submit\" value=\"Login\"/>\n" +
        "           </form>";
        }
        return header;
    }
    
    /**
     * Mengecek apakah pengguna adalah admin
     * @return 1 apabila admin, 0 bila bukan
     */    
    public boolean isAdmin() {
        try {
            return (user.getRole().compareTo("admin") == 0);
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Mengecek apakah pengguna adalah editor
     * @return 1 apabila admin, 0 bila bukan
     */
    public boolean isEditor() {
        try {
            return (user.getRole().compareTo("editor") == 0);
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Mengecek apakah pengguna adalah owner
     * @return 1 apabila admin, 0 bila bukan
     */
    public boolean isOwner() {
        try {
            return (user.getRole().compareTo("owner") == 0);
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Melakukan set atribut post
     * @param post_ID id post
     * @throws java.sql.SQLException
     */
    public void setAtribut(int post_ID) throws SQLException {
        
    }
    
    /**
     * Mereturn id post
     * @return idPost
     */
    public int getID() {
        return idPost;
    }
    
    /**
     * Mereturn judul post
     * @return judulPost
     */
    public String getJudul() {
        return judulPost;
    }
    
    /**
     * Mereturn tanggal post
     * @return tanggalPost
     */
    public String getTanggal() {
        return tanggalPost;
    }
    
    /**
     * Mereturn konten post
     * @return kontenPost
     */
    public String getKonten () {
        return kontenPost;
    }
    
    /**
     * Menampilkan semua post yang statusnya published
     * @return toHTML yang akan ditulis di HTML
     * @throws java.sql.SQLException
     */
    public String listPublishedPosts() throws SQLException {
        //inisialisasi string
        String toHTML = "";
        boolean shortened;
        
        //return string
        return toHTML;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public String listManagementPosts() throws SQLException {
        //inisialisasi string
        String toHTML = "";
        
        return toHTML;
    }
    
    /**
     * Menambahkan suatu post ke dalam database
     * @param judul judul post
     * @param tanggal tanggal post
     * @param konten konten post
     * @throws java.sql.SQLException
     */
    public void addPost(String judul, String tanggal, String konten) throws SQLException {
        
        
    }
    
    /**
     * Mengubah status post di database dari unpublished menjadi published
     * @param post_ID post id di database
     * @throws java.sql.SQLException
     */
    public void publishPost(int post_ID) throws SQLException {
        
    }
    
    /**
     * Mengubah aspek dari post di database
     * @param post_ID post id di database
     * @param judul judul post
     * @param tanggal tanggal post
     * @param konten konten post
     * @throws java.sql.SQLException
     */
    public void editPost(int post_ID, String judul, String tanggal, String konten) throws SQLException {
        
    }
    
    /**
     * Menghapus post dari database
     * @param post_ID post id di database
     * @throws java.sql.SQLException
     */
    public void deletePost(int post_ID) throws SQLException {
        
    }
    
    /**
     * Membuang post secara soft (soft delete)
     * @param post_ID id post
     * @throws SQLException
     */
    public void trashPost(int post_ID) throws SQLException {
        
    }
    
    /**
     * Mengembalikan post dari trash ke unpublished
     * @param post_ID id post
     * @throws SQLException
     */
    public void restorePost(int post_ID) throws SQLException {
        
    }
}
