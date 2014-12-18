/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Afik
 */
@ManagedBean
@RequestScoped
public class ListPost {
    
    ArrayList<Post> listPost= new ArrayList<Post>();
    ArrayList<Post> unpublishedPost = new ArrayList<Post>();
    /**
     * Creates a new instance of ListPost
     * @return Post
     * @throws java.sql.SQLException
     */
    
    public ArrayList<Post> fetchPublishedPost(){
        listPost.clear();
        List<heroku.service.Post> soapListPost = service.BlogService.getInstance().getPublishedPost();
        for (heroku.service.Post post : soapListPost) {
            listPost.add(service.Utility.soapToLocal(post));
        }
        
        return listPost;
    }
    
    public ArrayList<Post> fetchUnpublishPost(){
        listPost.clear();
        List<heroku.service.Post> soapListPost = service.BlogService.getInstance().getUnpublishedPost();
        for (heroku.service.Post post : soapListPost) {
            listPost.add(service.Utility.soapToLocal(post));
        }
        
        return listPost;
    }
}
