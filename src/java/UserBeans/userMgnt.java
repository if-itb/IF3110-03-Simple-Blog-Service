package UserBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@ManagedBean(name = "beans", eager = true)
@SessionScoped
public class userMgnt implements Serializable {

    /**
     * Creates a new instance of userMgnt
     */
    private String Message;
    private Cookie cookie;
    private org.chamerling.heroku.service.User user;
    private org.chamerling.heroku.service.User newUser;
    private BlogPost post;
    private org.chamerling.heroku.service.BlogPost lihatpost;
    private ArrayList<org.chamerling.heroku.service.BlogPost> allPosts;
    private ArrayList<org.chamerling.heroku.service.BlogPost> unpublishedPosts;
    private ArrayList<org.chamerling.heroku.service.Komentar> comments;
    private Komentar komen;
    private String pid;
    private ArrayList<org.chamerling.heroku.service.User> users;
    private ArrayList<org.chamerling.heroku.service.BlogPost> deletedPosts;

    public userMgnt() {
        user = new org.chamerling.heroku.service.User();
        post = new BlogPost();
        Message = "tidak ada";
        cookie = new Cookie("Username", null);
        cookie.setMaxAge(120);
        post = new BlogPost();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String passedParam = (String) facesContext.getExternalContext().getRequestParameterMap().get("pid");
        if(passedParam != null)
            pid = passedParam;
        
        komen = new Komentar();
        newUser = new org.chamerling.heroku.service.User();
    }
    
    public void login() {
        UserData ud = new UserData();
        org.chamerling.heroku.service.User userValidator = ud.getUser(user.getUsername());
        if (userValidator != null) {
            if (user.password.compareTo(userValidator.getPassword()) == 0) {
                user.uid=(userValidator.getUid());
                user.fullname=(userValidator.getFullname());
                user.Role=(userValidator.getRole());
                user.Email=(userValidator.getEmail());
                cookie.setValue(user.getUsername());
                FacesContext facesContex = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) facesContex.getExternalContext().getResponse();
                response.addCookie(cookie);
                
                komen.setEmail(userValidator.getEmail());
                komen.setKomentator(userValidator.getFullname());
            } else {
                Message = "Password is wrong";
            }
        } else {
            Message = "Username not found";
        }
    }

    public String Logout() {
        reset();
        Message = "tidak ada";
        cookie.setValue(null);
        cookie.setMaxAge(0);
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContex.getExternalContext().getResponse();
        response.addCookie(cookie);
        return "faces/index.xhtml";
    }

    public void reset() {
        user.fullname=("guest");
        user.username=("guest");
        user.password=("pass");
        user.email=("");
        user.role=("guest");
        user.uid=("");
    }

    public boolean isLogin() {
        return !user.username().equals("guest") && cookie.getValue() != null;
    }

    public boolean isAdmin(){
        return user.role.equals("admin");
    }
    
    public boolean isOwner(){
        return user.role.equals("owner");
    }
    
    public boolean isEditor(){
        return user.role.equals("editor");
    }
    
    public boolean activeMessage() {
        return !Message.equals("tidak ada") && !isLogin();
    }
    
    public void submitPost(){
        UserData ud = new UserData();
        post.setUid(user.getUid());
        post.setUsername(user.getFullname());
        ud.writeBlogPost(post);
        post.reset();
    }
    
    public void publishPost(String pid){
        UserData ud = new UserData();
        ud.publishPost(pid);
    }
    
    public void softDeletePost(String ppid){
        UserData ud = new UserData();
        ud.softDeletePost(ppid);
    }
    
    public void deletedPost(String ppid){
        UserData ud = new UserData();
        ud.deletePost(ppid);
    }
    
    public void writeComment(){
        UserData ud = new UserData();
        komen.setPid(lihatpost.getPid());
        ud.writeKomentar(komen);
    }
        
    public ArrayList<org.chamerling.heroku.service.Komentar> getComments(){
        UserData ud = new UserData();
        comments = (ArrayList<org.chamerling.heroku.service.Komentar>) ud.getListKomentar(lihatpost.getPid());
        return comments;
    }
    
    public Komentar getKomen(){
        return komen;
    }
    
    public void setKomen(Komentar komen){
        this.komen.setCid(komen.getCid());
        this.komen.setCommentDate(komen.getCommentDate());
        this.komen.setEmail(komen.getEmail());
        this.komen.setKomen(komen.getKomen());
        this.komen.setKomentator(komen.getKomentator());
        this.komen.setPid(komen.getPid());
    }
    
    public ArrayList<org.chamerling.heroku.service.BlogPost> getUnpublishedPosts(){
        UserData ud = new UserData();
        return (ArrayList<org.chamerling.heroku.service.BlogPost>) ud.getAllUnpublishedBlogPost();
    }
    
    public void setUnpublishedPosts(ArrayList<org.chamerling.heroku.service.BlogPost> unpublishedPostSet){
        unpublishedPosts.clear();
        for (org.chamerling.heroku.service.BlogPost unpublishedPostSet1 : unpublishedPostSet) {
            unpublishedPosts.add(unpublishedPostSet1);
        }
    }
    
    public org.chamerling.heroku.service.User getUser() {
        return this.user;
    }

    public void setUser(User newUser) {
        user.email=(newUser.getEmail());
        user.fullname=(newUser.getFullname());
        user.password=(newUser.getPassword());
        user.role=(newUser.getRole());
        user.uid=(newUser.getUid());
        user.username=(newUser.getUsername());
    }

    public ArrayList<org.chamerling.heroku.service.BlogPost> getAllPosts() {
        UserData ud = new UserData();
        return (ArrayList<org.chamerling.heroku.service.BlogPost>) ud.getAllBlogPost();
    }

    public void setAllPosts(ArrayList<org.chamerling.heroku.service.BlogPost> postSet) {
        allPosts.clear();
        for (org.chamerling.heroku.service.BlogPost postSet1 : postSet) {
            allPosts.add(postSet1);
        }
    }

    public BlogPost getPost(){
        return post;
    }
    
    public void setPost(BlogPost post){
        this.post.setPid(post.getPid());
        this.post.setUid(post.getUid());
        this.post.setUsername(post.getUsername());
        this.post.setPosttitle(post.getPosttitle());
        this.post.setPostcontent(post.getPostcontent());
        this.post.setPostdate(post.getPostdate());
        this.post.setPublished(post.getPublished());
        this.post.setDeleted(post.getDeleted());
    }

    public String getMessage() {
        return Message;
    }
    
    public ArrayList<org.chamerling.heroku.service.User> getUsers(){
        UserData ud = new UserData();
        users =  (ArrayList<org.chamerling.heroku.service.User>) ud.getListUser();
        return users;
    }
    
    public void setMessage(String S) {
        Message = S;
    }

    public Cookie getCookie() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cook = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("Username")) {
                    cook = userCookies[i];
                    return cook;
                }
            }
        }
        return null;
    }
    
    public String genEditLink(int editPid){
        return "faces/edit_post.xhtml?pid="+editPid;
    }
    
    public String genPostLink(String ppid){
        UserData ud = new UserData();
        lihatpost = ud.getBlogPost(ppid);
        return "faces/post.xhtml";
    }
            
    public String updateUserOption(int usersIndex){
        if(users.size() >= usersIndex){
            UserData ud = new UserData();
            User user = new User();
            user.setEmail(users.get(usersIndex).getEmail());
            user.setFullname(users.get(usersIndex).getFullname());
            user.setPassword(users.get(usersIndex).getPassword());
            user.setRole(users.get(usersIndex).getRole());
            user.setUid(users.get(usersIndex).getUid());
            user.setUsername(users.get(usersIndex).getUsername());
            ud.updateUserDB(user);
            return "alert('update berhasil');";
        }
        return "alert('update gagal');";
    }
    
    public ArrayList<org.chamerling.heroku.service.BlogPost> getDeletedPosts(){
        UserData ud = new UserData();
        return (ArrayList<org.chamerling.heroku.service.BlogPost>) ud.getDeletedPosts();
    }
    
    public void restoreDeletedPost(String delPid){
        UserData ud = new UserData();
        ud.restorePost(delPid);
    }
    
    public String genAddPostLink(){
        post.reset();
        return "faces/add_post.xhtml";
    }
    
    public org.chamerling.heroku.service.User getNewUser(){
        return newUser;
    }
    
    public void createNewUser(){
        UserData ud = new UserData();
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setFullname(newUser.getFullname());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        user.setUid(newUser.getUid());
        user.setUsername(newUser.getUsername());
        ud.createUserDB(user);
    }
    
    public org.chamerling.heroku.service.BlogPost getLihatpost(){
        return lihatpost;
    }
}
