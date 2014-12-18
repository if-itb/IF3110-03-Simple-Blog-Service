/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;
import service.ControllerImplement_Service;

/**
 *
 * @author A 46 CB i3
 */
@Named(value = "listPost")
@SessionScoped
public class ListPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;
    
    private String query;
    /**
     * Creates a new instance of ListPost
     */
    public ListPost() {}
    
    // getter
    public String getQuery() {
        return query;
    }
    
    // setter
    public void setQuery(String query) {
        this.query = query;
    }
    
    public java.util.List<service.Post> loadPublishedPost() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadPublishedPost();
    }

    private Boolean deletePost(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.deletePost(id);
    }
    public String delete(String id) {
        boolean b;
        b = this.deletePost(id);
        if(b) {
            return "index";
        }
        else {
            return null;
        }
    }
}
