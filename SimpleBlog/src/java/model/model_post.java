/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entities.Post;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A46CB
 */
public class model_post {
    
    public model_post() {
    }
    
    public List<Post> getAllPublishedPosts() {
        List<entities.Post> listPosts = new ArrayList<entities.Post>();
        List<service.Post> listPost = listPost("published");
        for(service.Post post : listPost)
        {
            entities.Post temp = new entities.Post(post.getId(),post.getJudul(),post.getTanggal(),post.getKonten(),post.getStatus());
            listPosts.add(temp);
        }
        return listPosts;
    }
    
    public List<Post> getAllUnpublishedPosts() {
        List<entities.Post> listPosts = new ArrayList<entities.Post>();
        List<service.Post> listPost = listPost("unpublished");
        for(service.Post post : listPost)
        {
            entities.Post temp = new entities.Post(post.getId(),post.getJudul(),post.getTanggal(),post.getKonten(),post.getStatus());
            listPosts.add(temp);
        }
        return listPosts;
    }
    
    public List<Post> getAllDeletedPosts() {
        List<entities.Post> listPosts = new ArrayList<entities.Post>();
        List<service.Post> listPost = listPost("deleted");
        for(service.Post post : listPost)
        {
            entities.Post temp = new entities.Post(post.getId(),post.getJudul(),post.getTanggal(),post.getKonten(),post.getStatus());
            listPosts.add(temp);
        }
        return listPosts;
    }
    
    public Post getPost(String id) {
        Post post = new Post();
        service.Post tempPost = getPostFromDB(id);
        post.setId(id);
        post.setJudul(tempPost.getJudul());
        post.setTanggal(tempPost.getTanggal());
        post.setKonten(tempPost.getKonten());
        return post;
    }
    
    public void addPost(Post post) {
        addPostToDB(post.getJudul(),post.getTanggal(),post.getKonten());
    }
    
    public void updatePost(Post post) {
        editPost(post.getId(),post.getJudul(),post.getTanggal(),post.getKonten());
    }

    private static java.util.List<service.Post> listPost(java.lang.String mode) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.listPost(mode);
    }

    private static Boolean addPostToDB(java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.addPost(judul, tanggal, konten);
    }

    private static Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String tanggal, java.lang.String konten) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.editPost(id, judul, tanggal, konten);
    }

    private static service.Post getPostFromDB(java.lang.String id) {
        service.SimpleBlogService_Service service = new service.SimpleBlogService_Service();
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.getPost(id);
    }
    
}
