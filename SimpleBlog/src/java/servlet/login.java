/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import service.SimpleBlogService_Service;

/**
 *
 * @author A46CB
 */
public class login extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SimpleBlogService/SimpleBlogService.wsdl")
    private SimpleBlogService_Service service;


    @Override
    public void init(ServletConfig config) throws ServletException {
        // Retrieve the database-URL, username, password from webapp init parameters
        super.init(config);
        ServletContext context = config.getServletContext();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String userpassword = request.getParameter("password");
        String role = "";
        String nama = "";
	
        PrintWriter out = response.getWriter();
        boolean isUserExist = false;
        
        List<service.User> listuser = listUser();
        
        for (service.User user : listuser) {
            if ((email.equals(user.getEmail())) && (userpassword.equals(user.getPassword()))) {
                role = user.getRole();
                nama = user.getName();
                isUserExist = true;
            }
        }
        
        if (isUserExist) {                
            // Step 4: Set cookie and session
            HttpSession session = request.getSession();
             session.setAttribute("email", email);
             session.setAttribute("nama", nama);
             session.setAttribute("role", role);
             //setting session to expiry in 30 mins
             //session.setMaxInactiveInterval(30 * 60);
             Cookie cookie_email = new Cookie("email", email);
             cookie_email.setMaxAge(2592000);
             response.addCookie(cookie_email);
             Cookie cookie_nama = new Cookie("nama", nama);
             cookie_nama.setMaxAge(2592000);
             response.addCookie(cookie_nama);
             Cookie cookie_role = new Cookie("role", role);
             cookie_role.setMaxAge(2592000);
             response.addCookie(cookie_role);

             response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    private java.util.List<service.User> listUser() {
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.listUser();
    }
}
