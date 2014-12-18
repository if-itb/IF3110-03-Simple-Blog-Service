/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Login.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;
import service.Exception_Exception;
import service.Post;
import service.Service_Service;

/**
 *
 * @author Rikysamuel
 */
@ManagedBean(name="Posting", eager = true)
@RequestScoped
public class PostingDatabase {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/intense-shore-8980.herokuapp.com/HelloService.wsdl")
    private Service_Service service;
    
    Login login;
    String SelectedItem;
    List<service.Post> SearchContent;
    
    @ManagedProperty(value="#{param.throwedauthor}")
    private String author;
    
    @ManagedProperty(value ="#{param.throwedid}")
    private String id;
    
    @ManagedProperty(value="#{param.throwediduser}")
    private String username;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getSelectedItem() {
        return SelectedItem;
    }

    public void setSelectedItem(String SelectedItem) {
        this.SelectedItem = SelectedItem;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public void setSearchContent(List<Post> SearchContent) {
        this.SearchContent = SearchContent;
    }

    public List<Post> getSearchContent() {
        return SearchContent;
    }
    
    public PostingDatabase(){
        login = new Login();
        SearchContent = new ArrayList<>();
    }
    
    public void toHome() throws IOException{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        extCont.redirect("/SImpleBlog/Home.xhtml");
    }
    
    public Connection makeConnection() throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/blog";
        String user = "root";
        String password = "";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    
    public List<service.Post> getPost() throws ClassNotFoundException, Exception_Exception{
        List<service.Post> records = new ArrayList<>();
        records = listPost("published");
        return records;
   }
    
    public List<service.Post> getAuthorPost() throws ClassNotFoundException, Exception_Exception{
        List<service.Post> records = new ArrayList<>();
        records = getAuthorPost_1(login.getUserCookie().getValue());
        return records;
   }
   
    public void addPost() throws ClassNotFoundException, SQLException, IOException, ParseException{
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Judul = request.getParameter("Judul");
        String Tanggal = request.getParameter("Tanggal");
        String Konten = request.getParameter("Konten");
        addPost_1(Judul, Konten, Tanggal, login.getUserCookie().getValue());
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/Home.xhtml");
    }

    public void deletePost() throws ClassNotFoundException, SQLException, IOException, ParseException{
        changeStatusPost(id, "deleted");
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/Home.xhtml");
    }
    
    public void PublishPost() throws ClassNotFoundException, IOException, ParseException, SQLException{
        changeStatusPost(id, "published");
        ExternalContext extcon = FacesContext.getCurrentInstance().getExternalContext();
        extcon.redirect("/SImpleBlog/Home.xhtml");
    }

    public void setLoginOnLoad() throws ClassNotFoundException, SQLException, IOException, Exception_Exception{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        Cookie cUsername = login.getUserCookie();
        Cookie cPassword = login.getPassCookie();
        if (cUsername!=null && cPassword!=null){
            int existUser=0;
            existUser = checkuserexist(cUsername.getValue(), cPassword.getValue());
            System.out.println("ROLE yang didapat: " + getUserRole());
            if (existUser>0){
                if(getUserRole().equals("Editor"))
                {
                    extCont.redirect("/SImpleBlog/Role/Editor.xhtml");
                }
                if(getUserRole().equals("Owner"))
                {
                    System.out.println("printttttttttttt");
                    extCont.redirect("/SImpleBlog/Role/Owner.xhtml");
                }
                if(getUserRole().equals("Admin"))
                {
                    extCont.redirect("/SImpleBlog/Role/Admin.xhtml");
                }
            }
            else{
                extCont.redirect("/SImpleBlog/Home.xhtml");
            }
        }
    }
    
    public void Login() throws ClassNotFoundException, SQLException, IOException, Exception_Exception{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Username = request.getParameter("login_username");
        String Password = request.getParameter("login_password");
        String UserRole = null;
        int existUser;
        existUser = checkuserexist(Username, Password);
        if(existUser>0){
            login.setCookie(Username,Password);
            UserRole = getUserRole_1(Username);
            if(UserRole.equals("Editor"))
            {
                extCont.redirect("/SImpleBlog/Role/Editor.xhtml");
            }
            if(UserRole.equals("Owner"))
            {
                extCont.redirect("/SImpleBlog/Role/Owner.xhtml");
            }
            if(UserRole.equals("Admin"))
            {
                extCont.redirect("/SImpleBlog/Role/Admin.xhtml");
            } 
        }
        else{
            extCont.redirect("/SImpleBlog/Home.xhtml");
        }
    }
    
    public String getActiveUser() throws ClassNotFoundException, SQLException, Exception_Exception{
        Cookie cUsername = login.getUserCookie();
        String activeUser = null;
        activeUser = getnama(cUsername.getValue());
        return activeUser;
    }
    
    public String getActiveUsername() throws ClassNotFoundException, SQLException{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        Cookie cUsername = login.getUserCookie();
        String activeUsername = cUsername.getValue();
        return activeUsername;
    }
    
    public String getUserRole() throws ClassNotFoundException, SQLException, Exception_Exception{
        Cookie cUsername = login.getUserCookie();
        String UserRole = getUserRole_1(cUsername.getValue());
        return UserRole;
    }
    
    public void setLogout() throws ClassNotFoundException, SQLException, IOException{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        login.delUserCookie();
        login.delPassCookie();
        extCont.redirect("/SImpleBlog/Home.xhtml");
    }
    
    public boolean getLoginState(){
        return(login.getUserCookie() != null);
    } 
    
    public String getActiveUserEmail() throws ClassNotFoundException, SQLException, Exception_Exception{
        Cookie cUsername = login.getUserCookie();
        String activeUserEmail = null;
        activeUserEmail = getemail(cUsername.getValue());
        return activeUserEmail;
    }
    
    public void checkAdminRole() throws ClassNotFoundException, SQLException, IOException, Exception_Exception{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        if(getLoginState())
        {
            Cookie cUsername = login.getUserCookie();
            Cookie cPassword = login.getPassCookie();
            if (cUsername!=null && cPassword!=null){
                int existUser=0;
                String UserRole = null;
                existUser = checkuserexist(cUsername.getValue(), cPassword.getValue());
                if (existUser>0){
                    if(!getUserRole().equals("Admin"))
                    {
                        extCont.redirect("/SImpleBlog/Home.xhtml");
                    }
                }
                else{
                    extCont.redirect("/SImpleBlog/Home.xhtml");
                }
            }
            else
            {
                extCont.redirect("/SImpleBlog/Home.xhtml");
            }
        }
        else
        {
            extCont.redirect("/SImpleBlog/Home.xhtml");
        }
    }
    
    public void CheckEditorRole() throws ClassNotFoundException, SQLException, IOException, Exception_Exception{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        if(getLoginState())
        {
            Cookie cUsername = login.getUserCookie();
            Cookie cPassword = login.getPassCookie();
            if (cUsername!=null && cPassword!=null){
                int existUser=0;
                existUser = checkuserexist(cUsername.getValue(), cPassword.getValue());
                    if (existUser>0){
                        if(!getUserRole().equals("Editor"))
                        {
                            extCont.redirect("/SImpleBlog/Home.xhtml");
                        }
                    }
                    else{
                        extCont.redirect("/SImpleBlog/Home.xhtml");
                    }
            }
            else
            {
                extCont.redirect("/SImpleBlog/Home.xhtml");
            }
        }
        else
        {
            extCont.redirect("/SImpleBlog/Home.xhtml");
        }
        
    }
    
    public void CheckOwnerRole() throws Exception_Exception, ClassNotFoundException, SQLException, IOException{
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        if(getLoginState())
        {
            Cookie cUsername = login.getUserCookie();
            Cookie cPassword = login.getPassCookie();
            if (cUsername!=null && cPassword!=null){
                int existUser=0;
                existUser = checkuserexist(cUsername.getValue(), cPassword.getValue());
                System.out.println("Masuk sampe sini, existUser: " + existUser);
                    if (existUser>0){
                        System.out.println("adaaaaaaaaaaaaaaaaaaaaaaaa");
                        if(!getUserRole().equals("Owner"))
                        {
                            extCont.redirect("/SImpleBlog/Home.xhtml");
                        }
                    }
                    else{
                        extCont.redirect("/SImpleBlog/Home.xhtml");
                    }
            }
            else
            {
                extCont.redirect("/SImpleBlog/Home.xhtml");
            }
        }
        else
        {
            extCont.redirect("/SImpleBlog/Home.xhtml");
        }
    }   
    
    public List<service.User> getUsers() throws ClassNotFoundException, SQLException, Exception_Exception{
        List<service.User> records = new ArrayList<>();
        records = listUser();
        return records;
    }
    
    public void setInsertNewUser() throws ClassNotFoundException, SQLException, Exception_Exception{
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Name = request.getParameter("Name");
        String Username = request.getParameter("Username");
        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");
        String Role = SelectedItem;
        addUser(Username, Password, Name, Email, Role);
    }
    
    public void setDeleteUser() throws ClassNotFoundException, SQLException, Exception_Exception{
        deleteUser(username);
    }
    
    public List<service.Post> getDeletedPosts() throws ClassNotFoundException, Exception_Exception{
      List<service.Post> records = new ArrayList<>();
      records = listPost("deleted");
      return records;
  }
    
    public void setRestorePost(String id) throws ClassNotFoundException, SQLException, IOException{
        changeStatusPost(id, "unpublished");
    }
    
    public void setRealDeletePost(String id) throws ClassNotFoundException, SQLException, IOException{
        deletePost_1(id);
    }
    
    public void updateUser() throws ClassNotFoundException, SQLException, IOException, Exception_Exception
    {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String Name = request.getParameter("EditName");
        String Username = request.getParameter("EditUsername");
        String Email = request.getParameter("EditEmail");
        String Password = request.getParameter("EditPassword");
        String Role = SelectedItem;
        editUser(Username, Password, Name, Email, Role);
    }
    
    public void find() throws Exception_Exception, IOException{
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        SearchContent = search(request.getParameter("search"));
        System.out.println(SearchContent.get(0).getAuthor());
        System.out.println(SearchContent.get(0).getJudul());
        ExternalContext extCont = FacesContext.getCurrentInstance().getExternalContext();
        extCont.redirect("/SImpleBlog/Search.xhtml");
    }

    private boolean addPost_1(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.String author) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.addPost(judul, konten, tanggal, author);
    }

    private java.util.List<service.Post> listPost(java.lang.String status) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.listPost(status);
    }

    private java.util.List<service.User> listUser() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.listUser();
    }

    private java.util.List<service.Post> getAuthorPost_1(java.lang.String author) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.getAuthorPost(author);
    }

    private boolean deletePost_1(java.lang.String postId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.deletePost(postId);
    }

    private boolean changeStatusPost(java.lang.String postId, java.lang.String status) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.changeStatusPost(postId, status);
    }

    private boolean addUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String role) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.addUser(username, password, nama, email, role);
    }

    private boolean deleteUser(java.lang.String username) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.deleteUser(username);
    }

    private int checkuserexist(java.lang.String username, java.lang.String password) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.checkuserexist(username, password);
    }

    private String getnama(java.lang.String username) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.getnama(username);
    }

    private String getemail(java.lang.String username) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.getemail(username);
    }

    private String getUserRole_1(java.lang.String username) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.getUserRole(username);
    }

    private java.util.List<service.Post> search(java.lang.String katakunci) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.search(katakunci);
    }

    private boolean editUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String role) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Service port = service.getServicePort();
        return port.editUser(username, password, nama, email, role);
    }
    
}
