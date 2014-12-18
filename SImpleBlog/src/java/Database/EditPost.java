/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.IOException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;
import service.Exception_Exception;
import service.Service_Service;

/**
 *
 * @author Sakurai
 */
@ManagedBean(name = "Editpost", eager = true)
@SessionScoped
public class EditPost {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/intense-shore-8980.herokuapp.com/HelloService.wsdl")
    private Service_Service service;
    private String PostID;
    
    public EditPost(){
        
    }
    
    public void setPostId(String PostID){
        this.PostID = PostID;
    }
    
    public void Redirect(String PostID) throws IOException{
        setPostId(PostID);
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/EditPost.xhtml");
    }

    public service.Post getPost() throws ClassNotFoundException, SQLException, IllegalAccessException, Exception_Exception{
        return getPost_1(PostID);
    }
    
    public void editPostToDatabase() throws ClassNotFoundException, IllegalAccessException, IOException{
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Judul = request.getParameter("Judul");
        String Konten = request.getParameter("Konten");
        editPost(PostID, Judul, Konten);
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/Home.xhtml");
    }    

    private boolean editPost(java.lang.String postId, java.lang.String judul, java.lang.String konten) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.editPost(postId, judul, konten);
    }

    private service.Post getPost_1(java.lang.String postid) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.getPost(postid);
    }
}
