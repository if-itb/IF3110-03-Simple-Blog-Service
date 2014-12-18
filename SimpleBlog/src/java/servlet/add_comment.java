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
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.SimpleBlogService_Service;

/**
 *
 * @author A46CB
 */
public class add_comment extends HttpServlet {
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
        String id_post = request.getParameter("id_post");
        String nama = request.getParameter("nama");
        String email = request.getParameter("email");
        String komentar = request.getParameter("komentar");
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String tanggal = format.format(date);
        
         PrintWriter out = response.getWriter();
         addComment(nama,email,komentar,tanggal,id_post);
        String comment = "";
                comment = comment + "<li class=\"art-list-item\"><div class=\"art-list-item-title-and-time\"><h2 class=\"art-list-title\">";
                comment = comment + "<a href=\"#\">"+nama+"</a></h2>";
                comment = comment + "<div class=\"art-list-time\">"+tanggal+"</div></div><p>"+komentar+"</p></li>";
            
      
            out.print(comment);
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

    private Boolean addComment(java.lang.String nama, java.lang.String email, java.lang.String komentar, java.lang.String tanggal, java.lang.String idPost) {
        service.SimpleBlogService port = service.getSimpleBlogServicePort();
        return port.addComment(nama, email, komentar, tanggal, idPost);
    }

    
}
