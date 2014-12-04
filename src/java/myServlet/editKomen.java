/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "editKomen", urlPatterns = {"/editKomen"})
public class editKomen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     Statement statement = null;
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                String DB_URL = "jdbc:mysql://localhost/tucildb_13511097";
                String USER = "root";
                String PASS = "";
                Connection conn = null;
                
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String id = request.getParameter("id");
         
        try {
                    conn = DriverManager.getConnection(DB_URL,USER, PASS);
                    statement = conn.createStatement();
                    String sql = "DELETE FROM `tucildb_1351097`.`post-komen` WHERE `myID`= "+id;
                    statement.executeUpdate(sql);
                
             
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                 
                 response.sendRedirect("mainpage.jsp");
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
        
                
                String nama = request.getParameter("nama");
                String email = request.getParameter("email");
                String komen = request.getParameter("Konten");
                String id = request.getParameter("id");
                
                 try {
                    conn = DriverManager.getConnection(DB_URL,USER, PASS);
                    statement = conn.createStatement();
                    String sql = "UPDATE `tucildb_13511097`.`post-komen` SET `nama`='"+nama+"',`email`='"+email+"',`isi`='"+komen+"' WHERE `myID`= "+id;
                    statement.executeUpdate(sql);
                
             
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                 
                 response.sendRedirect("mainpage.jsp");
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
