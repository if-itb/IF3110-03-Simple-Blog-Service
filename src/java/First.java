import SimpleBlog.MySQLAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class First extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        MySQLAccess sql = new MySQLAccess();
        List<org.chamerling.heroku.service.User> listuser = sql.getUser();
        
        boolean match = false;
        int i = 0;
        while(i<listuser.size() && !match)
        {
            if(listuser.get(i).getUsername().equalsIgnoreCase(username))
            {
                if(listuser.get(i).getPassword().equalsIgnoreCase(password))
                {
                    match = true;
                }
            }
            else
            {
                i++;
            }
        }
        
        if(match)
        {
           String msg = "login Successful";
           HttpSession session=request.getSession();
           session.setAttribute("user",username);

           i = 0;
           Cookie[] cookies = request.getCookies();
           boolean found = false;
           while(i<cookies.length && !found)  
           {
               if(cookies[i].getName().equalsIgnoreCase("user"))
               {
                    found = true;
               }
               else
               {
                    i++;
               }
           }
           if(found)
           {
               cookies[i].setMaxAge(0);
               // Menciptakan cookies untuk guest      
               Cookie guest = new Cookie("user",username); 
               // Meng - set agar cookie hilang setelah 24 jam
               guest.setMaxAge(60*60*2); 
               // Menambahkan cookie ke header response
               response.addCookie(guest);
           }

           String site = new String("index.jsp");
           response.setStatus(response.SC_MOVED_TEMPORARILY);
           response.setHeader("Location", site);
        }
        else
        {
            String msg = "login unsuccessful";
            String site = new String("index.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
        
}

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
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
