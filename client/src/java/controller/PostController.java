package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import service.Post;

/**
 *
 * @author Ahmad Shahab
 * Kelas Post Controller, mengatur penambahan, perubahan, dan penghapusan post
 */
@ManagedBean(name="postController", eager=true)
@SessionScoped
public class PostController {
    // current Post
    private Post post;
    private String keyword;
    
    public PostController() throws SQLException, ClassNotFoundException {
        post = null;
    }

    // Getter-Setter untuk post
    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    // mengembalikan post jika diketahui id-nya
    public Post getPostById(Integer postId) throws SQLException, IOException {
        return getPostById_1(postId);
    }
    
    // menampilkan post dengan id postId
    public void viewPost(Integer postId) throws SQLException, IOException{
        setPost(getPostById(postId));
        FacesContext.getCurrentInstance().getExternalContext().redirect("post.xhtml");
    }
    
    //menampilkan post yang belum terpublish
    public void viewUnpublishedPost() throws SQLException, IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("unpublished_post.xhtml");
    }
    
    // Mengembalikan list seluruh post yang ada
    public List<Post> getPostList() throws SQLException {
        List<Post> postList = listPost();
        List<Post> publishedPost = new ArrayList<>();
        for(int i=0;i<postList.size();i++){
           if(postList.get(i).getPublished() == 1){
               publishedPost.add(postList.get(i));
           }
        }
        return publishedPost;
    }
    
    // mengembalikan seluruh unpublished post list
    public List<Post> getUnpublishedPostList() throws SQLException {
        List<Post> postList = listPost();
        List<Post> unpublishedPost = new ArrayList<>();
        for(int i=0;i<postList.size();i++){
           if(postList.get(i).getPublished() == 0){
               unpublishedPost.add(postList.get(i));
           }
        }
        return unpublishedPost;
    }
    
    //menampilkan semua post yang telah didelete tapi belum secara permanen
    public List<Post> getDeletedPostList() throws SQLException {
        List<Post> postList = listPost();
        List<Post> deletedPost = new ArrayList<>();
        for(int i=0;i<postList.size();i++){
           if(postList.get(i).getPublished()==-1){
               deletedPost.add(postList.get(i));
           }
        }
        return deletedPost;
    }
    //menampilkan hasil pencarian post 
    public List<Post> getSearchPostList() throws SQLException {
        return search(keyword);
    }
    
    // menambahkan post dengan atribut sesuai parameter fungsi ini
    public void addPost(String title, String date, String content, Integer publicationStatus) 
            throws SQLException, IOException{
        
        addPost_1(title,content,date,0);
        
        // upload file
        InputBean inputBean = (InputBean) ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().getAttribute("inputBean");
        if (inputBean.getPart() != null) {
            String result = inputBean.uploadFile();
        }
        
        // redirect ke laman utama
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    // mengedit post; redirect ke halaman edit post
    public void editPost(Post _post) throws IOException{
        setPost(_post);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("edit_post.xhtml");
    }
    
    // update post dengan atribut sesuai parameter fungsi
    public void updatePost(Integer id, String title, String date, String content, 
            int publicationStatus) throws SQLException, IOException{
        
        updatePost_1(id, title, date, content, publicationStatus);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    // menghapus post dengan id tertentu
    public void deletePost(Integer id) throws SQLException, IOException{
        deletePost_1(id);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    public void restorePost(Integer id) throws SQLException, IOException{
        restorePost_1(id);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("deleted_post.xhtml");
    }
    public void permanentdeletePost(Integer id) throws SQLException, IOException{
        
        permanentDeletePost(id);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("deleted_post.xhtml");
    }
    
    public void searchPost(String _keyword) throws SQLException, IOException{
        setKeyword(_keyword);
        FacesContext.getCurrentInstance().getExternalContext().redirect("search_post.xhtml");
    }
    // mempublish post dengan id tertentu
    public void publishPost(Integer id) throws SQLException, IOException {
        Post tempPost = getPostById(id);
        tempPost.setPublished(1);
        
        updatePost(tempPost.getId(), tempPost.getTitle(), tempPost.getDate(),
                tempPost.getContent(), tempPost.getPublished());
    }
    
    // menonpublish post dengan id tertentu
    public void unpublishPost(Integer id) throws SQLException, IOException {
        Post tempPost = getPostById(id);
        tempPost.setPublished(0);
        
        updatePost(tempPost.getId(), tempPost.getTitle(), tempPost.getDate(),
                tempPost.getContent(), tempPost.getPublished());
    }

    private static boolean addPost_1(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.Integer statusPublikasi) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.addPost(judul, konten, tanggal, statusPublikasi);
    }

    private static boolean deletePost_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.deletePost(id);
    }

    private static service.Post getPostById_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.getPostById(id);
    }

    private static java.util.List<service.Post> listPost() {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.listPost();
    }

    private static boolean publishPost_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.publishPost(id);
    }

    private static boolean restorePost_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.restorePost(id);
    }

    private static boolean unpublishPost_1(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.unpublishPost(id);
    }

    private static boolean updatePost_1(java.lang.Integer id, java.lang.String judul, java.lang.String tanggal, java.lang.String konten, java.lang.Integer statusPublikasi) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.updatePost(id, judul, tanggal, konten, statusPublikasi);
    }

    private static boolean permanentDeletePost(java.lang.Integer id) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.permanentDeletePost(id);
    }

    private static java.util.List<service.Post> search(java.lang.String query) {
        service.SimpleBlogServiceImplementationService service = new service.SimpleBlogServiceImplementationService();
        service.SimpleBlogService port = service.getSimpleBlogServiceImplementationPort();
        return port.search(query);
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    

}
