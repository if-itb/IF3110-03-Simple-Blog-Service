/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author upix
 */

public class CookieHelper {
    public void setCookie(String name, String value,HttpServletRequest req, HttpServletResponse res){
        setCookie(name, value, 24*60*60,req,res);
    }
    
    public void setCookie(String name, String value,int expiry,HttpServletRequest request, HttpServletResponse response) {

        //FacesContext facesContext = FacesContext.getCurrentInstance();

        //HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        
        Cookie cookie = null;
        

        /*Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }

        if (cookie != null) {
            cookie.setValue(value);
        } else {*/
            cookie = new Cookie(name, value);
            //cookie.setDomain(request.);

        cookie.setMaxAge(expiry);

        response.addCookie(cookie);
    }
    
    public Cookie getCookie(String name, HttpServletRequest req ) {
        
        //FacesContext facesContext = FacesContext.getCurrentInstance();
        
        //HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletRequest request = req;
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    return cookie;
                }
            }
        }
        return null;
    }
}
