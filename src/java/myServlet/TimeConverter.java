package myServlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/TimeConverter"})
public class TimeConverter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeConverter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeConverter at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public String ConvertDate(String t2){
        String[] mm = t2.split("-");
        String[] ss = mm[2].split(" ");
        
        switch (mm[1]) {
				case "01": {
				return ss[0]+" Januari "+mm[0];
				
				}
				case "02": {
				return ss[0]+" Februari "+mm[0];
				
				}
				case "03": {
				return ss[0]+" Maret "+mm[0];
				}
				case "04": {
				return ss[0]+" April "+mm[0];
				}
				case "05": {
				return ss[0]+" Mei "+mm[0];
				}
				case "06": {
				return ss[0]+" Juni "+mm[0];
				}
				case "07": {
				return ss[0]+" Juli "+mm[0];
				
				}
				case "08": {
				return ss[0]+" Agustus "+mm[0];
				
				}
				case "09": {
				return ss[0]+" September "+mm[0];
				}
				case "10": {
				return ss[0]+" Oktober "+mm[0];
				}
				case "11": {
				return ss[0]+" November "+mm[0];
				}
				case "12": {
				return ss[0]+" Desember "+mm[0];
				}
                                default : {return "undefined";}
				}
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
        processRequest(request, response);
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
        processRequest(request, response);
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
