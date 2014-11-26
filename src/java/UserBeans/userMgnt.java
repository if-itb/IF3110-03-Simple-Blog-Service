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
    private String passedParam;
    private User user;
    private BlogPost post;
    private ArrayList<BlogPost> allPosts;

    public userMgnt() {
        user = new User();
        post = new BlogPost();
        Message = "tidak ada";
        cookie = new Cookie("Username", null);
        cookie.setMaxAge(120);
    }
    
    public void login() {
        UserData ud = new UserData();
        User userValidator = ud.getUser(user.getUsername());
        if (userValidator != null) {
            if (user.getPassword().compareTo(userValidator.getPassword()) == 0) {
                user.setFullname(userValidator.getFullname());
                user.setRole(userValidator.getRole());
                user.setEmail(userValidator.getEmail());
                cookie.setValue(user.getUsername());
                FacesContext facesContex = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) facesContex.getExternalContext().getResponse();
                response.addCookie(cookie);
            } else {
                Message = "Password is wrong";
            }
        } else {
            Message = "Username not found";
        }
    }

    public void Logout() {
        reset();
        Message = "tidak ada";
        cookie.setValue(null);
        cookie.setMaxAge(0);
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContex.getExternalContext().getResponse();
        response.addCookie(cookie);
    }

    public void reset() {
        user.setFullname("guest");
        user.setUsername("guest");
        user.setPassword("pass");
    }

    public boolean isLogin() {
        return user.getUsername().compareTo("guest") != 0 && cookie.getValue() != null;
    }

    public boolean activeMessage() {
        return !Message.equals("tidak ada") && !isLogin();
    }
    
    public void submitPost(){
        UserData ud = new UserData();
        ud.writeBlogPost(post);
    }
    
    
    public User getUser() {
        return this.user;
    }

    public void setUser(User newUser) {
        user.setEmail(newUser.getEmail());
        user.setFullname(newUser.getFullname());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        user.setUid(newUser.getUid());
        user.setUsername(newUser.getUsername());
    }

    public ArrayList<BlogPost> getAllPosts() {
        UserData ud = new UserData();
        return ud.getAllBlogPost();
    }

    public void setAllPosts(ArrayList<BlogPost> postSet) {
        allPosts.clear();
        for (int i = 0; i < postSet.size(); i++) {
            allPosts.add(postSet.get(i));
        }
    }

    public String getPassedParam() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParam = (String) facesContext.getExternalContext().getRequestParameterMap().get("pid");
        return passedParam;
    }

    public void setPassedParam(String newPassedParam) {
        passedParam = newPassedParam;
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

    //setter
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
}
