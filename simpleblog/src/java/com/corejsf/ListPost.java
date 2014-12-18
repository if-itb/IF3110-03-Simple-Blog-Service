/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.sql.*;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

@ManagedBean(name = "listpost")
@RequestScoped

/**
 *
 * @author Indam Muhammad
 */
public class ListPost {
    private ArrayList<Post> published_posts;
    private ArrayList<Post> unpublished_posts;
    private ArrayList<Post> deleted_posts;
    
    public ListPost(){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        published_posts = new ArrayList<Post>();
        unpublished_posts = new ArrayList<Post>();
        deleted_posts = new ArrayList<Post>();
        for(org.chamerling.heroku.service.Post p : hello.getPost()){
            Post pp = new Post();
            pp.setId(p.getId());
            pp.setJudul(p.getJudul());
            pp.setKonten(p.getKonten());
            pp.setStatus(p.getStatus());
            pp.setTanggal(p.getTanggal());
            if(p.getDeleted().equals("1"))
                deleted_posts.add(pp);
            else{
                if(p.getStatus().equalsIgnoreCase("Unpublished"))
                    unpublished_posts.add(pp);
                else
                    published_posts.add(pp);
            }
        }
    }

    public ArrayList<Post> getDeleted_posts() {
        return deleted_posts;
    }

    public void setDeleted_posts(ArrayList<Post> deleted_posts) {
        this.deleted_posts = deleted_posts;
    }
    
    public ArrayList<Post> getPublished_posts(){
        return this.published_posts;
    }
    
    public ArrayList<Post> getUnpublished_posts(){
        return this.unpublished_posts;
    }

    public void setPublished_posts(ArrayList<Post> published_posts) {
        this.published_posts = published_posts;
    }

    public void setUnpublished_posts(ArrayList<Post> unpublished_posts) {
        this.unpublished_posts = unpublished_posts;
    }

}
