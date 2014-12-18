/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc asus
 */
public class PostPublishBean {
    private UserBean user;
    // TODO semua, sambungin ke List-User.xhtml, dao, dan teman - teman
    private Post post;
    /**
     * Creates a new instance of AddUserBean
     */
    public PostPublishBean() {
        post = new Post();
    }

    /**
     * @return the user
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param user the user to set
     */
    public void setPost(Post post) {
        this.post = post;
    }
    public String publish(String PID) {
        NavigationController nb = new NavigationController();
        if (service.BlogService.getInstance().getPost(PID) == null) {
            // TODO sambungin dengan error message
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Username doesn't exists!"));
        }
        else {
            Post published = service.Utility.soapToLocal(service.BlogService.getInstance().getPost(PID));
            published.setPublished(true);
            service.BlogService.getInstance().publishPost(PID);
        }
        return nb.gotoListPost()+ "?faces-redirect=true";
        }
}
