/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Indam Muhammad
 */

package com.corejsf;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

@ManagedBean(name = "postedit")
@ViewScoped

public class PostEdit implements Serializable {
    private String id;
    
    private Post pos;
    public PostEdit(){
        pos = new Post();
    }
    public String getId(){
        return id;
    }
    public Post getPos(){
        return pos;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setPos(Post pos){
        this.pos = new Post();
        this.pos.setId(pos.getId());
        this.pos.setJudul(pos.getJudul());
        this.pos.setKonten(pos.getKonten());
        this.pos.setStatus(pos.getStatus());
        this.pos.setTanggal(pos.getTanggal());
    }
    
    public void edit(){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.editPost(id, pos.getJudul(), pos.getTanggal(), pos.getKonten(), pos.getStatus(), pos.getDeleted());
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public void execute(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Post p = hello.getPostById(id);
        this.id = id;
        pos.setId(id);
        pos.setJudul(p.getJudul());
        pos.setKonten(p.getKonten());
        pos.setStatus(p.getStatus());
        pos.setTanggal(p.getTanggal());
        pos.setDeleted(p.getDeleted());
    }
}
