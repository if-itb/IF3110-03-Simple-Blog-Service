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
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;

/**
 *
 * @author asus
 */
@ManagedBean(name="user")
@SessionScoped
public class user_bean implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/frozen-badlands-5271.herokuapp.com/HelloService.wsdl")
    private HelloServiceImplService service;
    /**
     * Creates a new instance of user_bean
     */
    private List<User> items;
    
    public user_bean() {
    }
    
    public List<User> dbData() throws ClassNotFoundException, IOException_Exception, MalformedURLException_Exception{
        List<User> list = new ArrayList<>();
        java.util.List<org.chamerling.heroku.service.User> list2 = listUser();
        for (org.chamerling.heroku.service.User user : list2) {
            User u = new User();
            u.setId(user.getId());
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setRole(user.getRole());
            list.add(u);
        }
        return list;
    }
    
    public String saveAction() {
	    
		//get all existing value but set "editable" to false 
		for (User user : items){
			user.setEditable(false);
		}
		
		//return to current page
		return null;
		
	}
	
	public String editAction(User user) {
	    
		user.setEditable(true);
		return null;
	}

    private java.util.List<org.chamerling.heroku.service.User> listUser() throws MalformedURLException_Exception, IOException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listUser();
    }

    
}
