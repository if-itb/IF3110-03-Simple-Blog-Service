/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class AuthenticationFilter implements Filter {
  private FilterConfig config;

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws IOException, ServletException {
    if (((HttpServletRequest) req).getSession().getAttribute(
        login_bean.AUTH_KEY) == null) {
      ((HttpServletResponse) resp).sendRedirect("/SimpleBlog/faces/AccessDenied.xhtml");
    } else {
      chain.doFilter(req, resp);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
  }

  @Override
  public void destroy() {
    config = null;
  }
}
