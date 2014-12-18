/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Afik
 */
public class AllPostBean {
    private ArrayList <Post> publishedPost; 
    private ArrayList<Post> unPublishedPost;
    /**
     * Creates a new instance of AllPostBean
     */
    public AllPostBean() {
    }

    /**
     * @return the allPost
     */
    public ArrayList <Post> getPublishedPost() {
        List<heroku.service.Post> X = service.BlogService.getInstance().getPublishedPost();
        
        if (publishedPost != null) {publishedPost.clear();}
        else {publishedPost = new ArrayList<Post>();}
        for (int i =0; i < X.size() ; i++) {
            publishedPost.add(service.Utility.soapToLocal(X.get(i)));
        }
        
        System.out.println(publishedPost.size() + "SIE");
        
        return publishedPost;
        /*
        publishedPost = new ArrayList<Post> (DAO.DAOFactory.getInstance("javabase.jdbc").getPostDAO().listPublish());
        return publishedPost;*/
    }

    /**
     * @param publishedPost the publishedPost to set
     */
    public void setPublishedPost(ArrayList <Post> publishedPost) {
        this.publishedPost = publishedPost;
    }

    /**
     * @return the unPublishedPost
     */
    public ArrayList<Post> getUnPublishedPost() {
        List<heroku.service.Post> X = service.BlogService.getInstance().getUnpublishedPost();
        
        if (unPublishedPost != null) unPublishedPost.clear();
        else unPublishedPost = new ArrayList<Post>();
        for (int i =0; i < X.size() ; i++) {
            unPublishedPost.add(service.Utility.soapToLocal(X.get(i)));
        }
        
        return unPublishedPost;
        
        
        /*
        unPublishedPost = new ArrayList<Post> (DAO.DAOFactory.getInstance("javabase.jdbc").getPostDAO().listUnPublish());
        return unPublishedPost;*/
    }

    /**
     * @param unPublishedPost the unPublishedPost to set
     */
    public void setUnPublishedPost(ArrayList<Post> unPublishedPost) {
        this.unPublishedPost = unPublishedPost;
    }
}
