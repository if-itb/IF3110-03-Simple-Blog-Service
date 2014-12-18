/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;

/**
 *
 * @author User
 */
public class search implements Serializable{
    private String query;
    
    public String getQuery(){
        return query;
    }
    
    public void setQuery(String query){
        this.query = query;
    }
    
    public String doSearch(){
        
        return "search";
    }
    
    public List<Post> getResult(){
        List<Post> list = new ArrayList<>();
        java.util.List<org.chamerling.heroku.service.Post> list2 = search(query);
        for (org.chamerling.heroku.service.Post apost : list2 ){
            Post p = new Post();
            p.setId_post(apost.getIdPost());
            p.setJudul(apost.getJudul());
            p.setTanggal(apost.getTanggal());
            p.setKonten(apost.getKonten());
            p.setStatus(apost.isStatus());
            list.add(p);
        }
        System.out.println("search " + query);
        return list;
    }

    private static java.util.List<org.chamerling.heroku.service.Post> search(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.search(arg0);
    }

}
