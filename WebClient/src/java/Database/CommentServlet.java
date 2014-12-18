package Database;

import Model.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.chamerling.heroku.service.InterruptedException_Exception;
import org.chamerling.heroku.service.SimpleBlog;
import org.chamerling.heroku.service.SimpleBlogImplService;
import org.json.JSONArray;

/**
 *
 * @author Riva Syafri Rachmatullah
 */
@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

    private MySQL db = new MySQL();
    private SimpleBlog SB = new SimpleBlogImplService().getSimpleBlogImplPort();
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
            out.println("INI KEMBALIANNYA, 5000");
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
        String pid = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        try {
            if (SB.addComment(pid, name, email, content))
            {
                response.getOutputStream().print("true");
            }
            else
            {
                response.getOutputStream().print("false");
            }
        } catch (InterruptedException_Exception ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        List<Comment> ListComment = new LinkedList();
        for (org.chamerling.heroku.service.Comment c : SB.getComment(request.getParameter("id")))
        {
            Comment comment = new Comment(c);
            ListComment.add(comment); 
        }
        JSONArray array = new JSONArray(ListComment);
        response.getOutputStream().print(array.toString());
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
