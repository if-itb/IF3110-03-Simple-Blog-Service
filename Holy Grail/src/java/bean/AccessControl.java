package bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "accesscontrol",eager = true)
public class AccessControl {
    //Attribute kelas
    @ManagedProperty(value = "#{user}")
    private User user;

    //Method kelas
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public AccessControl() {
        
    }
    
    public void checkLogin()
    {
        System.out.printf("CheckLogin. Role : %s\n",user.getRole());
        if("".equals(user.getRole()))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    public void checkAdmin()
    {
        System.out.printf("CheckAdmin. Role : %s\n",user.getRole());
        if(!user.getRole().equals("admin"))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(user.getRole()+".xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    public void checkEditor()
    {
        System.out.printf("CheckEditor. Role : %s\n",user.getRole());
        if(!user.getRole().equals("editor"))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(user.getRole()+".xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    public void checkOwner()
    {
        System.out.printf("CheckOwner. Role : %s\n",user.getRole());
        if(!user.getRole().equals("owner"))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(user.getRole()+".xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    public void checkOwnerOrAdmin()
    {
        System.out.printf("CheckOwnerOrAdmin. Role : %s\n",user.getRole());
        if(!(user.getRole().equals("owner") || user.getRole().equals("admin")))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(user.getRole()+".xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    public void checkEditorOrAdmin()
    {
        System.out.printf("CheckEditorOrAdmin. Role : %s\n",user.getRole());
        if(!(user.getRole().equals("editor") || user.getRole().equals("admin")))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(user.getRole()+".xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AccessControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
}
