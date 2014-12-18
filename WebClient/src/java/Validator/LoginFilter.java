package Validator;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Database.UserData;
import Helper.CookieHelper;
import Model.User;
import javax.servlet.http.Cookie;
 
/**
 * Filter checks if user is logged in by any role.
 * If it is not set then request is being redirected to the login.xhml page.
 *
 * @author Riva Syafri Rachmatullah
 *
 */
public class LoginFilter implements Filter {
 
    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserData loginBean = new UserData();
        String contextPath = ((HttpServletRequest)request).getContextPath();
        String path = ((HttpServletRequest) request).getRequestURI().substring(contextPath.length());
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        boolean logged_in = false;
        boolean isAdmin = false;
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("user_blog"))
                {
                    logged_in = true;
                    User user = loginBean.getUser(cookie.getValue());
                    if (user != null)
                    {
                        if (user.getRole().equals("admin"))
                        {
                            isAdmin = true;
                        }
                    }
                }
            }
        }
        if (!logged_in) {
            ((HttpServletResponse)response).sendRedirect(contextPath + "/faces/login.xhtml");
        }else if (!isAdmin)
        {
            if (path.startsWith("/faces/admin.xhtml") || path.startsWith("/faces/edit_user.xhtml")){
                ((HttpServletResponse)response).sendRedirect(contextPath + "/faces/index.xhtml");
            }
            
        }
        chain.doFilter(request, response);    
    }
 
    public void init(FilterConfig config) throws ServletException {}
 
    public void destroy() {}    
}