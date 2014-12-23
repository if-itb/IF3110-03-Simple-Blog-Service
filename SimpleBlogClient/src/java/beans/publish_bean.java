/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author asus
 */
@ManagedBean
@SessionScoped
public class publish_bean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/frozen-badlands-5271.herokuapp.com/HelloService.wsdl")
    private HelloServiceImplService service;
    String id;
    /**
     * Creates a new instance of publish_bean
     */
    public publish_bean() {
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
    public String changeStatus(String id) throws ClassNotFoundException {
        publishPost(id);
        return "/index";
    }

    private boolean publishPost(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.publishPost(arg0);
    }

}
