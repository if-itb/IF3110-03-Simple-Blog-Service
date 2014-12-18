package filter;

import controller.PostController;
import controller.UserController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Post;
import service.User;

/**
 * 
 * @author Ahmad Zaky
 * Filter untuk halaman View Post (post.xhtml)
 */
public class PostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        PostController postController = (PostController) req.getSession().getAttribute("postController");
        Post post = postController == null ? null : postController.getPost();
        UserController userController = (UserController) req.getSession().getAttribute("userController");
        User user = userController == null ? null : userController.getUser();
        
        /*
         * Post hanya bisa dilihat jika:
         * * post tidak null, dan
         * * post telah dipublish, atau post unpublished tetapi role = admin atau editor
        */
        if (post != null && user != null && !(post.getPublished()==0 && (user.getRole().equals("guest") || user.getRole().equals("owner")))) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("index.xhtml");
        }        
    }

    @Override
    public void destroy() {
        
    }
}
