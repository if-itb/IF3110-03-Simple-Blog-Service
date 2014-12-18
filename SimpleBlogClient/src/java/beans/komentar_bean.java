/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;

/**
 *
 * @author asus
 */
@ManagedBean
@RequestScoped
public class komentar_bean implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/frozen-badlands-5271.herokuapp.com/HelloService.wsdl")
    private HelloServiceImplService service;

    /**
     * Creates a new instance of komentar_bean
     */
    private List<Komentar> items;
    
    
    public komentar_bean() {
    }
    public List<Komentar> dbData(String id_post) throws ClassNotFoundException, IOException_Exception, MalformedURLException_Exception{
        List<Komentar> list = new ArrayList<>();
        java.util.List<org.chamerling.heroku.service.Komentar> list2 = listComment(id_post); 
        for (org.chamerling.heroku.service.Komentar com : list2) {
            Komentar p = new Komentar();
            p.setId_kom(com.getIdKom());
            p.setId_post(com.getIdPost());
            p.setUsername(com.getUsername());
            p.setEmail(com.getEmail());
            p.setWaktu(com.getWaktu());
            p.setKomentar(com.getKomentar());
            list.add(p);
        }
        return list;
    }

    private java.util.List<org.chamerling.heroku.service.Komentar> listComment(java.lang.String arg0) throws IOException_Exception, MalformedURLException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listComment(arg0);
    }
}
