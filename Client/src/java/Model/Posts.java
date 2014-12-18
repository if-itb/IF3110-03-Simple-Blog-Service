/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import org.penguasadunia.PenguasaDuniaService;
import org.penguasadunia.PenguasaDuniaService_Service;
import org.penguasadunia.ServicePost;

/**
 *
 * @author user
 */
public class Posts {
    private Vector<Post> posts;
    
    private static Posts instance;
    PenguasaDuniaService serviceEndpoint;
    
    private Posts() {
        posts = new Vector<Post>();
        serviceEndpoint = new PenguasaDuniaService_Service().getPenguasaDuniaServicePort();
    }
    
    public static Posts getInstance() {
        if (instance==null){
            instance = new Posts();
        }
        return instance;
    }
    
    public void softDeletePost(String post_id) {
        serviceEndpoint.softDeleteServicePost(post_id);
    }
    
    public void unsoftDeletePost(String post_id) {
        serviceEndpoint.unsoftDeleteServicePost(post_id);
    }
    
    public Post findPost(String post_id)
    {
        List<ServicePost> servicePosts = serviceEndpoint.listServicePost();
        for (ServicePost p : servicePosts) {
            if (p.getKey().equals(post_id)){
                Post post = new Post();
                post.setCreatorId(p.getIdAuthor());
                post.setDeleted(p.getStatusDeleted().equals("true"));
                post.setId(p.getKey());
                post.setPublished(p.getStatusPublished().equals("true"));
                post.setText(p.getKonten());
                post.setTimeString(p.getTanggal());
                post.setTitle(p.getJudul());
                return post;
            }
        }
        return null;
    }
    
    public void removePost(String post_id) {
        serviceEndpoint.deleteServicePost(post_id);
    }
    
    public void updatePostDB(Post p) {
       serviceEndpoint.editServicePost(p.getId(), p.getTitle(), p.getText(), p.getTimeString());
    }
     
    public void insertPostDB(Post p) {
        serviceEndpoint.addServicePost(p.getTitle(), p.getText(), p.getTimeString(), p.getCreatorId());
    }
    
    public Vector<Post> filter(int user_id){
        return null;
    }
    
    public ArrayList<Post> getUnpublishedPost() {
        ArrayList<Post> posts = new ArrayList<Post>();
        List<ServicePost> servicePosts = serviceEndpoint.listServicePost();
        for (ServicePost p : servicePosts) {
            if (p.getStatusPublished().equals("false") && p.getStatusDeleted().equals("false")){
                Post post = new Post();
                post.setCreatorId(p.getIdAuthor());
                post.setDeleted(p.getStatusDeleted().equals("true"));
                post.setId(p.getKey());
                post.setPublished(p.getStatusPublished().equals("true"));
                post.setText(p.getKonten());
                post.setTimeString(p.getTanggal());
                post.setTitle(p.getJudul());
                posts.add(post);
            }
        }
        return posts;
    }
    
    public ArrayList<Post> getPublishedPost() {
         ArrayList<Post> posts = new ArrayList<Post>();
        List<ServicePost> servicePosts = serviceEndpoint.listServicePost();
        for (ServicePost p : servicePosts) {
            if (p.getStatusPublished().equals("true") && p.getStatusDeleted().equals("false")){
                Post post = new Post();
                post.setCreatorId(p.getIdAuthor());
                post.setDeleted(p.getStatusDeleted().equals("true"));
                post.setId(p.getKey());
                post.setPublished(p.getStatusPublished().equals("true"));
                post.setText(p.getKonten());
                post.setTimeString(p.getTanggal());
                post.setTitle(p.getJudul());
                posts.add(post);
            }
        }
        return posts;
    }
    
    public ArrayList<Post> getDeletedPost(boolean deleted) {
       ArrayList<Post> posts = new ArrayList<Post>();
        List<ServicePost> servicePosts = serviceEndpoint.listServicePost();
        for (ServicePost p : servicePosts) {
            if (p.getStatusDeleted().equals("true")==deleted){
                Post post = new Post();
                post.setCreatorId(p.getIdAuthor());
                post.setDeleted(p.getStatusDeleted().equals("true"));
                post.setId(p.getKey());
                post.setPublished(p.getStatusPublished().equals("true"));
                post.setText(p.getKonten());
                post.setTimeString(p.getTanggal());
                post.setTitle(p.getJudul());
                posts.add(post);
            }
        }
        return posts;
    }
    
    public ArrayList<Post> getPostBySearchKey(String searchKey) {
        ArrayList<Post> posts = new ArrayList<Post>();
        List<ServicePost> servicePosts = serviceEndpoint.search(searchKey);
        for (ServicePost p : servicePosts) {
                Post post = new Post();
                post.setCreatorId(p.getIdAuthor());
                post.setDeleted(p.getStatusDeleted().equals("true"));
                post.setId(p.getKey());
                post.setPublished(p.getStatusPublished().equals("true"));
                post.setText(p.getKonten());
                post.setTimeString(p.getTanggal());
                post.setTitle(p.getJudul());
                posts.add(post);
        }
        return posts;
    }
    
    public void publishPost(String postId) {
        serviceEndpoint.publishServicePost(postId);
    }
}
