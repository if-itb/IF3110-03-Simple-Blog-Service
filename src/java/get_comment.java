import SimpleBlog.Komentar;
import SimpleBlog.MySQLAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "get_comment", urlPatterns = {"/get_comment"})
public class get_comment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            MySQLAccess SQL = new MySQLAccess();
            List<org.chamerling.heroku.service.Comment> listKomentar=new ArrayList();
            String a=request.getParameter("idPost");
            String idPost = request.getParameter("idPost");
            listKomentar=SQL.getKomentar(idPost);
            String komentar="";
            int i=0;
            System.out.println(listKomentar.size());
            while(i<listKomentar.size())
            {
                komentar=komentar+ "<li class=\"art-list-item\">"+
                                        "<div class=\"art-list-item-title-and-time\">"+
                                            "<h2 id =\"Nama_Komentar\" class=\"art-list-title\">" + listKomentar.get(i).getNama()  + "</h2>"+
                                            " <div id =\"Tanggal_Komentar\" class=\"art-list-time\">"+listKomentar.get(i).getTanggal() + " </div>" +
                                        "</div>"+
                                        "<p id =\"Komentar_Komentar\"> "+ listKomentar.get(i).getKonten() + "</p>"+
                                   "</li> ";
   
                i++;
            }
            out.write(komentar);
        } finally {            
            out.close();
        }
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
        processRequest(request, response);
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
