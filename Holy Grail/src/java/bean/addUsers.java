package bean;

import ClientService.DatabaseService_Service;
import ClientService.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

@ManagedBean(name = "addUser", eager=true)
@ViewScoped
public class addUsers {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/hatsunemiku.herokuapp.com/HatsuneMikuService.wsdl")
    private DatabaseService_Service service;

    private String id;
    private String username;
    private String email;
    private String role;
    private String password;
    private String param;
    private String oldid;
    private String oldusername;
    private String oldemail;
    private String oldrole;
    private String oldpassword;

    public List<addUsers> fetchFromDB()
    {
        List<addUsers> records = new ArrayList<>();
        List<User> listUser = listUser();
        for(User u : listUser)
        {
            String id1 = u.getId();
            String email1 = u.getEmail();
            String username1 = u.getUsername();
            String password1 = u.getPassword();
            String role1 = u.getRole();
            addUsers temp = new addUsers(id1, username1, email1, role1, password1);
            records.add(temp);
        }
        return records;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    public String getOldusername() {
        return oldusername;
    }

    public void setOldusername(String oldusername) {
        this.oldusername = oldusername;
    }

    public String getOldemail() {
        return oldemail;
    }

    public void setOldemail(String oldemail) {
        this.oldemail = oldemail;
    }

    public String getOldrole() {
        return oldrole;
    }

    public void setOldrole(String oldrole) {
        this.oldrole = oldrole;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }
    
    public addUsers() {
        username="";
        role="";
        email="";
        password="";
        param="";
        id = "";
    }

    public addUsers(String id, String username, String email, String role, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    @Override
    public String toString() {
        return "addUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + ", password=" + password + '}';
    }
    
    public String getCheckAvail()
    {
        delete();
        List<addUsers> records = fetchFromDB();
        boolean avail = true;
        for(addUsers u : records)
        {
            if(u.getUsername().equals(username))
            {
                avail = false;
                break;
            }
        }
        System.out.println("INFO : avail = " + avail);
        if(avail)
        {
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("email = " + email);
            System.out.println("role = " + role);
            insert();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("userManagement.xhtml");
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        else
        {
            addUser(oldusername, oldpassword, oldemail, oldrole);
            return "Users already exist";
        }
        return null;
    }
    
    public String getAddNewUser()
    {
        List<addUsers> records = fetchFromDB();
        boolean avail = true;
        for(addUsers u : records)
        {
            if(u.getUsername().equals(username))
            {
                avail = false;
                break;
            }
        }
        System.out.println("INFO : avail = " + avail);
        if(avail)
        {
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("email = " + email);
            System.out.println("role = " + role);
            addUser(username, password, email, role);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("userManagement.xhtml");
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        else
        {
            return "User already exist";
        }
        return null;
    }
    
    public String getAutoFill()
    {
        if("".equals(username) && "".equals(email) && "".equals(id) && "".equals(role) && "".equals(password))
        {
            System.out.println("AUTO FILL");
            Map<String, String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            if(params.get("username")!=null)
            {
                param = params.get("username");
            }
            System.out.println("param:"+param);
            List<addUsers>records = fetchFromDB();
            for(addUsers u : records)
            {
                System.out.println(u.toString());
                if(u.getUsername().equals(param))
                {
                    username = u.getUsername();
                    password=u.getPassword();
                    role=u.getRole();
                    email=u.getEmail();
                    id = u.getId();
                    oldid = id;
                    oldemail = email;
                    oldrole = role;
                    oldpassword = password;
                    oldusername = username;
                    break;
                }
            }
            //delete
            System.out.println("finish");
        }
        return null;
    }
    
    public void insert()
    {
        addUser(username, password, email, role);
        delete();
    }
    
    public void delete()
    {
        deleteUser(id);
    }

    private Boolean deleteUser(java.lang.String id) {
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.deleteUser(id);
    }

    private java.util.List<ClientService.User> listUser() {
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.listUser();
    }

    private Boolean addUser(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String role) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ClientService.DatabaseService port = service.getDatabaseServicePort();
        return port.addUser(username, password, email, role);
    }
}
