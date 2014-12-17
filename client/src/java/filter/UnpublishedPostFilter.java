/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import controller.UserController;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.User;

/**
 *
 * @author Eldwin
 */
@WebFilter(filterName = "UnpublishedPostFilter", urlPatterns = {"/faces/unpublished_post.xhtml"})
public class UnpublishedPostFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        UserController userController = (UserController) req.getSession().getAttribute("userController");
        User user = userController == null ? null : userController.getUser();

        /*
         * Unpublished Post hanya dapat dilihat oleh user dengan role = admin atau editor
        */
        if (user != null && (user.getRole().equals("admin") || user.getRole().equals("edtor"))) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("index.xhtml");
        }
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        

    }

    
}
