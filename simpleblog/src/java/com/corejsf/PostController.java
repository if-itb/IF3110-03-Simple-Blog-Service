/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Arina Listyarini DA
 */
@ManagedBean(name = "postController", eager = true)
@RequestScoped
public class PostController {

    /**
     * Creates a new instance of PostController
     */
    private int id;
    
    public PostController() {}
    
    public void addPost(String judul, String tanggal, String konten){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.addPost(judul, tanggal, konten, "Unpublished", "0");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public String deletePost(String id, int hlm){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Post p = hello.getPostById(id);
        hello.editPost(id, p.getJudul(), p.getTanggal(), p.getKonten(), p.getStatus(), "1");
        if(hlm == 1)
            return "index?faces-redirect=true";
        else
            return "unpublished?faces-redirect=true";
    }
    
    public String restorePost(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Post p = hello.getPostById(id);
        hello.editPost(id, p.getJudul(), p.getTanggal(), p.getKonten(), p.getStatus(), "0");
        return "soft_deleted?faces-redirect=true";
    }
    
    public String deletePostPermanent(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.deletePost(id);
        return "soft_deleted?faces-redirect=true";
    }
    
    public String publishPost(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Post p = hello.getPostById(id);
        hello.editPost(id, p.getJudul(), p.getTanggal(), p.getKonten(), "Published", p.getDeleted());
        return "unpublished?faces-redirect=true";
    }

}
