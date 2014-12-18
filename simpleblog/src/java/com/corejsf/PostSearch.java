/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

@ManagedBean(name = "postSearch")
@RequestScoped

/**
 *
 * @author Indam Muhammad
 */
public class PostSearch {
    ArrayList<Post> psearch;
    String query;
    public PostSearch(){
        psearch = new ArrayList<>();
    }
    public void execute(String query){
        this.query = query;
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        List<org.chamerling.heroku.service.Post> pp = hello.getSearchPost(query);
        for(org.chamerling.heroku.service.Post p : pp){            
            Post _p = new Post();
            _p.setId(p.getId());
            _p.setJudul(p.getJudul());
            _p.setKonten(p.getKonten());
            _p.setStatus(p.getStatus());
            _p.setTanggal(p.getTanggal());
            _p.setDeleted(p.getDeleted());
            psearch.add(_p);
        }
    }

    public ArrayList<Post> getPsearch() {
        return psearch;
    }

    public void setPsearch(ArrayList<Post> psearch) {
        this.psearch = psearch;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    
}
