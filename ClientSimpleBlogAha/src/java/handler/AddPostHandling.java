/*3
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.println;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.SimpleBlogServiceHandler.SimpleBlogServiceHandler;

/**
 *
 * @author tegar
 */
@WebServlet(name = "AddPostHandling", urlPatterns = {"/AddPostHandling"})
public class AddPostHandling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
//        InputStream inputStream = null; // input stream of the upload file         
//        Part filePart = request.getPart("file");
//        inputStream = filePart.getInputStream();
//        byte[] buffer = new byte[inputStream.available()];
//        inputStream.read(buffer);
//        String Filename = request.getParameter("Judul")+" "+request.getParameter("User_Id");
//        String PicturePath = "C:\\Users\\toshibapc\\Documents\\NetBeansProjects\\IF3110-02-Simple-Blog-Java\\web\\picture"+Filename+".jpg";
//        File targetFile = new File(PicturePath);
//        OutputStream outStream = new FileOutputStream(targetFile);
//        outStream.write(buffer);
//        outStream.close();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String judul = request.getParameter("Judul");
        String tanggal = request.getParameter("Tanggal");
        String konten = request.getParameter("Konten");
        String author = request.getParameter("User_Id");
        SimpleBlogServiceHandler.addPost(judul, konten, tanggal, author, "Vanya");
        
        String site = new String("http://localhost:8080/ClientSimpleBlogAha/home.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddPostHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddPostHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
