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
@Named(value = "deletedPost")
@SessionScoped
public class DeletedPost implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/calm-chamber-9995.herokuapp.com/HelloService.wsdl")
    private ControllerImplement_Service service;

    /**
     * Creates a new instance of DeletedPost
     */
    public DeletedPost() {
    }

    public java.util.List<service.Post> loadDeletedPost() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.loadDeletedPost();
    }

    private Boolean restorePost(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.ControllerImplement port = service.getControllerImplementPort();
        return port.restorePost(id);
    }
    public String restore(String id) {
        boolean b;
        b = this.restorePost(id);
        if(b) {
            return "deleted";
        }
        else {
            return null;
        }
    }
}
