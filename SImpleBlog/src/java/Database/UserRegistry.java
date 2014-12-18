/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ManagedBean(name = "UserRegistry", eager = true)
@ViewScoped
public class UserRegistry {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/intense-shore-8980.herokuapp.com/HelloService.wsdl")
    private Service_Service service;
    
    public UserRegistry(){

    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException, IllegalAccessException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/blog";
            String user = "root";
            String password = "";
            conn =  DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | InstantiationException e){
            e.printStackTrace();
        }
        return conn;
    }
    
    public boolean isUserExist(String username) throws ClassNotFoundException, IllegalAccessException{
        boolean userExist = false;
        ResultSet result;
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String query = "Select * From user where Username = \"" + username + "\";";
            result = stmt.executeQuery(query);
            if(!result.next()){
                userExist = false;
            }else{
                userExist = true;
            }
            conn.close();
            
        } catch(SQLException e){
            System.err.println(e);
        }
        return userExist;
    }
    
    public void addUserOwner() throws ClassNotFoundException, SQLException, IllegalAccessException, IOException, Exception_Exception{
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Username = request.getParameter("Form:Username");
        String Password = request.getParameter("Form:Password");
        String Email = request.getParameter("Form:Email");
        String Name = request.getParameter("Form:Name");
        addUser(Username, Password, Name, Email, "owner");
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/Home.xhtml");
    }

    private boolean addUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String role) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.addUser(username, password, nama, email, role);
    }
    
}
