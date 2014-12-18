/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Gifari Kautsar
 */
@ManagedBean(name = "listComment", eager=true)
@ViewScoped
public class ListComment {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Comment> comments;
    
    public ListComment(){        
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    
    public ArrayList<Comment> execute(String id_post){
        comments = new ArrayList<Comment>();
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        if(!hello.getCommentPost(id_post).isEmpty()){
            for(org.chamerling.heroku.service.Comment c : hello.getCommentPost(id_post)){
                Comment _c = new Comment();
                _c.setId(c.getId());
                _c.setIdPost(id_post);
                _c.setKomentar(c.getKomentar());
                _c.setNama(c.getNama());
                _c.setTanggal(c.getTanggal());
                _c.setEmail(c.getEmail());
                comments.add(_c);
            }
        }
        return comments;
    }
}
