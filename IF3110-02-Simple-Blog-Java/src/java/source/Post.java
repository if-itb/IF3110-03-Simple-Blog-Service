/* Kelas: Post.java
 */
package source;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.chamerling.heroku.service.BlogService;
import org.chamerling.heroku.service.BlogServiceImplService;
import org.chamerling.heroku.service.Exception_Exception;
import org.chamerling.heroku.service.InterruptedException_Exception;

/**
 * @author Try Ajitiono + Rakhmatullah Yoga Sutrisna
 */
public class Post {
    /**
     * Atribut-atribut
     */
    private String idPost;
    private String judulPost;
    private String tanggalPost;
    private String kontenPost;
    private String publishStatus;
    private boolean cookieOn;
    private User user;
    
    /**
     * Konstruktor Post, gunanya untuk membuat objek user
     */
    public Post() {
        user = new User();
    }
    
    /**
     * melakukan set username berdasarkan cookie
     * @param c
     */
    public void cookieHeaderCheck(CookieHelper c) {
        //prekondisi: cookie sudah pasti ada
        user.setUsername(c.getUsername());
        cookieOn = true;
    }
    /**
     * Menambahkan komentar ke dalam basis data
     * @param ID 
     * @return  HTML script untuk memuat komentar yang akan digunakan oleh AJAX
     * @throws java.sql.SQLException 
     */
    public String LoadComment(String ID) {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        
        //login database
        String HTMLcode = "";
        java.util.List<org.chamerling.heroku.service.Komentar> L = blog.getAllCommentar(ID);
        for (org.chamerling.heroku.service.Komentar K : L) {
            String Nama = K.getNama();
            String Email = K.getEmail();
            String Comment = K.getComment();
            //String Time = K.getTanggal();
            HTMLcode +=
                        "    <li class=\"art-list-item\">\n" +
                        "        <div class=\"art-list-item-title-and-time\">\n" +
                        "            <h2 class=\"art-list-title\">" + Nama + "</h2>\n" +
                        //"            <div class=\"art-list-time\">" + Time.toString() + "</div>\n" +
                        "        </div>\n" +
                        "        <p>" + Comment + "</p>\n" +
                        "    </li>";
        }
        return HTMLcode;
    }
    /**
     * @param PostID
     * @param nama
     * @param email
     * @param comment
     * @throws SQLException 
     */
    public void AddComment(String PostID, String nama, String email, String comment) throws InterruptedException_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            blog.addComment(PostID, nama, email, comment);
        } catch (InterruptedException_Exception e) {
            
        }
    }
    /**
     * Menambahkan header message pada halaman utama blog
     * @return header tulisan yang dikembalikan ke halaman utama
     * @throws SQLException
     */
    public String showMessageHeader() throws Exception_Exception {
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
    public String showManagementHeader() throws Exception_Exception {
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
    public boolean isAdmin() throws Exception_Exception {
        try {
            return (user.getRole().compareTo("admin") == 0);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Mengecek apakah pengguna adalah editor
     * @return 1 apabila admin, 0 bila bukan
     */
    public boolean isEditor() throws Exception_Exception {
        try {
            return (user.getRole().compareTo("editor") == 0);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Mengecek apakah pengguna adalah owner
     * @return 1 apabila admin, 0 bila bukan
     */
    public boolean isOwner() throws Exception_Exception {
        try {
            return (user.getRole().compareTo("owner") == 0);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Melakukan set atribut post
     * @param post_ID id post
     * @throws java.sql.SQLException
     */
    public void setAtribut(String post_ID) {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        java.util.List<org.chamerling.heroku.service.Post> L = blog.getAllPost();
        for (org.chamerling.heroku.service.Post P : L) {
            //looping
            if (P.getIdFirebasePost().compareTo(post_ID) == 0) {
                idPost = post_ID;
                judulPost = P.getJudulPost();
                tanggalPost = P.getTanggalPost();
                kontenPost = P.getKontenPost();
                publishStatus = P.getPublishStatus() + "";
                break;
            }
        }
    }
    
    /**
     * Mereturn id post
     * @return idPost
     */
    public String getID() {
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
    public String listPublishedPosts() throws Exception_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        //inisialisasi string
        String toHTML = "";
        boolean shortened;
        try {
            java.util.List<org.chamerling.heroku.service.Post> L = blog.getAllPost();
            if (L.isEmpty()) {
                //kosong
                toHTML = "No posts yet.";
            }
            else {
                for (org.chamerling.heroku.service.Post P : L) { //apabila result masih ada
                    if (P.getPublishStatus() == 1) {
                        shortened = false;
                        //inisialisasi variabel
                        idPost = P.getIdFirebasePost();
                        judulPost = P.getJudulPost();
                        kontenPost = P.getKontenPost();
                        publishStatus = P.getPublishStatus() + "";
                        if (kontenPost.length() > 100) {
                            kontenPost = kontenPost.substring(0, 100); //pemotongan teks
                            shortened = true;
                        }
                        tanggalPost = P.getTanggalPost();
                        toHTML +=    
                                "<li class=\"art-list-item\">\n" +
                                "<div class=\"art-list-item-title-and-time\">\n" +
                                "<h2 class=\"art-list-title\"><a href=\"posts/post.jsp?id=" + idPost + "\"> " + judulPost + " </a>\n" +
                                "<div class=\"art-list-time\">" + tanggalPost + "</div>\n" +
                                "<div class=\"art-list-time\"><span style=\"color:#F40034;\">&#10029;</span> Featured</div>\n" +
                                "</div>\n" +
                                "<p> " + kontenPost + "\n" + "</p>\n";                            
                        if (shortened) //dipotong
                            toHTML += "... <a href=\"posts/post.jsp?id=" + idPost + "\">Read More</a><br/>\n";
                        //edit post: untuk semua kecuali guest
                        if (cookieOn) {
                            if (isAdmin() || isEditor() || isOwner()) {
                                toHTML +=  "<p>\n" +
                                "<a href=\"posts/edit_post.jsp?id=" + idPost + 
                                "\">Edit</a>";
                            }
                            //delete post: untuk admin dan owner
                            if (isAdmin() || isOwner()) {    
                                toHTML += " | <a href=\"posts/delete_post.jsp?id=" + idPost + 
                                "\" onclick='return confirmDelete()'>Hapus</a>\n" +
                                "</p>\n" +
                                "</li>";
                            }
                        }
                    }
                }
            }
        }
        catch (Exception_Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return string
        return toHTML;
    }
    
    /**
     *
     * @return
     */
    public String listManagementPosts() throws Exception_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        //inisialisasi string
        String toHTML = "";
        boolean shortened;
        try {
            java.util.List<org.chamerling.heroku.service.Post> L = blog.getAllPost();
            //header tabel
            toHTML += "<table id=\"t01\"> <tr>" +
                      "<th <tr style=\"vertical-align:center\" rowspan=\"2\" id=\"column1\">Judul Post</th>\n" +
                      "<th <tr style=\"vertical-align:center\" rowspan=\"2\" id=\"column2\">Tanggal Post</th>\n" +
                      "<th <tr style=\"vertical-align:center\" rowspan=\"2\" id=\"column3\">Konten Post</th>\n" +
                      "<th <tr style=\"vertical-align:center\" rowspan=\"2\" id=\"column4\">Status</th>\n" +
                      "<th id=\"column5\" colspan=\"5\">Aksi</th>\n" +
                      "</tr>\n" +
                      "<th id=\"columnx\">Publish</th>\n" +
                      "<th id=\"columnx\">Trash</th>\n" +
                      "<th id=\"columnx\">Restore</th>\n" +  
                      "<th id=\"columnx\">Delete</th>\n" +
                      "<th id=\"columnx\">Edit</th>\n" +
                      "</tr>\n";
            for (org.chamerling.heroku.service.Post P : L) { //apabila result masih ada
                shortened = false;
                //inisialisasi variabel
                idPost = P.getIdFirebasePost();
                judulPost = P.getJudulPost();
                kontenPost = P.getKontenPost();
                publishStatus = P.getPublishStatus() + "";
                if (kontenPost.length() > 50) {
                    kontenPost = kontenPost.substring(0, 50); //pemotongan teks
                    shortened = true;
                }
                tanggalPost = P.getTanggalPost();
                //judul, tanggal, konten post
                toHTML += "<tr>\n" + "<th>" + judulPost + "</th>"
                                   + "<th>" + tanggalPost + "</th>"
                                   + "<th>" + kontenPost;
                if (shortened) //dipotong
                    toHTML += "... <a href=../posts/post.jsp?id=" + idPost + ">Read More</a></th>";
                else //tidak dipotong
                    toHTML += "</th>";
                //status post
                switch (Integer.parseInt(publishStatus)) {
                    case 0: toHTML += "<th> Unpublished </th>"; break;
                    case 1: toHTML += "<th> Published </th>"; break;
                    case 2: toHTML += "<th> Trashed </th>"; break;
                }
                //aksi berdasarkan role, lalu berdasarkan post
                if (isAdmin()) {
                    if (Integer.parseInt(publishStatus) == 0) { //status unpublished
                        toHTML += "<th><a href='../posts/publish_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th><a href='../posts/trash_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th></th>\n";
                    }
                    else if (Integer.parseInt(publishStatus) == 1) { //status published
                        toHTML += "<th></th>\n" +
                                  "<th><a href='../posts/trash_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th></th>\n";
                    }
                    else if (Integer.parseInt(publishStatus) == 2) { //status trash
                        toHTML += "<th></th>\n" +
                                  "<th></th>\n" +
                                  "<th><a href='../posts/restore_post.jsp?id=" + idPost + "'> X </a></th>\n";
                    }
                    toHTML += "<th><a href='../posts/delete_post.jsp?id=" + idPost + "' onclick='return confirmDelete()'> X </a></th>\n" +
                              "<th><a href='../posts/edit_post.jsp?id=" + idPost + "'> X </a></th></tr>\n";
                }
                else if (isEditor()) {
                    if (Integer.parseInt(publishStatus) == 0) { //status unpublished
                        toHTML += "<th><a href='../posts/publish_post.jsp?id=" + idPost + "'> X </a></th>\n";
                    }
                    else if (Integer.parseInt(publishStatus) == 1) { //status published
                        toHTML += "<th></th>\n";
                    }
                    toHTML +=  "<th></th>\n" +
                               "<th></th>\n" +
                               "<th></th>\n<th><a href='../posts/edit_post.jsp?id=" + idPost + "'> X </a></tr>\n" +
                               "<th></th>\n";
                }
                else if (isOwner()) {
                    if (Integer.parseInt(publishStatus) == 0) { //status unpublished
                        toHTML += "<th><a href='../posts/publish_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th><a href='../posts/trash_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th></th>\n";
                    }
                    else if (Integer.parseInt(publishStatus) == 1) { //status published
                        toHTML += "<th></th>\n" +
                                  "<th><a href='../posts/trash_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                                  "<th></th>\n";
                    }
                    else if (Integer.parseInt(publishStatus) == 2) { //status trash
                        toHTML += "<th></th>\n" +
                                  "<th></th>\n" +
                                  "<th></th>\n";
                    }
                    toHTML += "<th><a href='../posts/delete_post.jsp?id=" + idPost + "'> X </a></th>\n" +
                              "<th><a href='../posts/edit_post.jsp?id=" + idPost + "'> X </a></tr>\n";
                }
            }
            toHTML += "</table>\n<br>\n";
        }
        catch (Exception_Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return string
        return toHTML;
    }
    
    /**
     * Menambahkan suatu post ke dalam database
     * @param judul judul post
     * @param tanggal tanggal post
     * @param konten konten post
     */
    public void addPost(String judul, String tanggal, String konten) throws InterruptedException_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            blog.addPost(judul, tanggal, konten);
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    /**
     * Mengubah status post di database dari unpublished menjadi published
     * @param post_ID post id di database
     * @throws java.sql.SQLException
     */
    public void publishPost(String post_ID) throws InterruptedException_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            List<org.chamerling.heroku.service.Post> allPost = blog.getAllPost();
            for(org.chamerling.heroku.service.Post post : allPost)
            {
                if(post.getIdFirebasePost().equals(post_ID))
                {
                    this.judulPost = post.getJudulPost();
                    this.kontenPost = post.getKonten();
                    this.tanggalPost = post.getTanggal();
                }
            }
            blog.editPost(post_ID, judulPost, tanggalPost, kontenPost, "1");
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    /**
     * Mengubah aspek dari post di database
     * @param post_ID post id di database
     * @param judul judul post
     * @param tanggal tanggal post
     * @param konten konten post
     * @throws java.sql.SQLException
     */
    public void editPost(String post_ID, String judul, String tanggal, String konten) {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            List<org.chamerling.heroku.service.Post> allPost = blog.getAllPost();
            for(org.chamerling.heroku.service.Post post : allPost)
            {
                if(post.getIdFirebasePost().equals(post_ID))
                {
                    this.judulPost = post.getJudulPost();
                    this.kontenPost = post.getKonten();
                    this.tanggalPost = post.getTanggal();
                }
            }
            blog.editPost(post_ID, judulPost, tanggalPost, kontenPost, publishStatus);
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    /**
     * Menghapus post dari database
     * @param post_ID post id di database
     * @throws java.sql.SQLException
     */
    public void deletePost(String post_ID) throws InterruptedException_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            blog.deletePost(post_ID);
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    /**
     * Membuang post secara soft (soft delete)
     * @param post_ID id post
     * @throws SQLException
     */
    public void trashPost(String post_ID) {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            blog.editPost(post_ID, judulPost, tanggalPost, kontenPost, "2");
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    /**
     * Mengembalikan post dari trash ke unpublished
     * @param post_ID id post
     * @throws SQLException
     */
    public void restorePost(String post_ID) {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        try {
            blog.editPost(post_ID, judulPost, tanggalPost, kontenPost, "0");
        } catch (InterruptedException_Exception e) {
            
        }
    }
    
    public String searchPost(String keyword) throws Exception_Exception {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        //inisialisasi string
        String toHTML = "";
        boolean shortened;
        try {
            java.util.List<org.chamerling.heroku.service.Post> L = blog.getAllPost();
            if (L.isEmpty()) {
                //kosong
                toHTML = "No posts yet.";
            }
            else {
                for (org.chamerling.heroku.service.Post P : L) { //apabila result masih ada
                    if (P.getJudulPost().contains(keyword) || P.getKontenPost().contains(keyword)) {
                        shortened = false;
                        //inisialisasi variabel
                        idPost = P.getIdFirebasePost();
                        judulPost = P.getJudulPost();
                        kontenPost = P.getKontenPost();
                        publishStatus = P.getPublishStatus() + "";
                        if (kontenPost.length() > 100) {
                            kontenPost = kontenPost.substring(0, 100); //pemotongan teks
                            shortened = true;
                        }
                        tanggalPost = P.getTanggalPost();
                        toHTML +=    
                                "<li class=\"art-list-item\">\n" +
                                "<div class=\"art-list-item-title-and-time\">\n" +
                                "<h2 class=\"art-list-title\"><a href=\"posts/post.jsp?id=" + idPost + "\"> " + judulPost + " </a>\n" +
                                "<div class=\"art-list-time\">" + tanggalPost + "</div>\n" +
                                "<div class=\"art-list-time\"><span style=\"color:#F40034;\">&#10029;</span> Featured</div>\n" +
                                "</div>\n" +
                                "<p> " + kontenPost + "\n" + "</p>\n";                            
                        if (shortened) //dipotong
                            toHTML += "... <a href=\"posts/post.jsp?id=" + idPost + "\">Read More</a><br/>\n";
                        //edit post: untuk semua kecuali guest
                        if (cookieOn) {
                            if (isAdmin() || isEditor() || isOwner()) {
                                toHTML +=  "<p>\n" +
                                "<a href=\"posts/edit_post.jsp?id=" + idPost + 
                                "\">Edit</a>";
                            }
                            //delete post: untuk admin dan owner
                            if (isAdmin() || isOwner()) {    
                                toHTML += " | <a href=\"posts/delete_post.jsp?id=" + idPost + 
                                "\" onclick='return confirmDelete()'>Hapus</a>\n" +
                                "</p>\n" +
                                "</li>";
                            }
                        }
                    }
                }
            }
        }
        catch (Exception_Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return string
        return toHTML;
    }
}
