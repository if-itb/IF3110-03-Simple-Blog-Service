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
 * @author asus
 */
public class post_bean implements Serializable{
    private List<Post> items;
    
    public List<Post> dbData() throws ClassNotFoundException, MalformedURLException_Exception, IOException_Exception {
        List<Post> list = new ArrayList<>();
        java.util.List<org.chamerling.heroku.service.Post> list2 = listPost();
        for (org.chamerling.heroku.service.Post apost : list2 ){
            Post p = new Post();
            p.setId_post(apost.getIdPost());
            p.setJudul(apost.getJudul());
            p.setTanggal(apost.getTanggal());
            p.setKonten(apost.getKonten());
            p.setStatus(apost.isStatus());
            list.add(p);
        }
        System.out.println("post_bean dbData");
        return list;
    }

    private static java.util.List<org.chamerling.heroku.service.Post> listPost() throws IOException_Exception, MalformedURLException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listPost();
    }

    
}
