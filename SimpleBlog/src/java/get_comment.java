import SimpleBlog.Komentar;
import java.io.IOException;
import java.io.PrintWriter;
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
            String idPost = request.getParameter("idPost");
            List<Object> templistKomentar=listComment(idPost);
            List<Komentar> listKomentar = null;
            for (Object templistKomentar1 : templistKomentar) {
                Komentar k = Komentar.class.cast(templistKomentar1);
                boolean add = listKomentar.add(k);
            }
            String a=request.getParameter("idPost");
            System.out.println("idPost:"+a+".");
            String komentar="";
            int i=0;
            
            while(i<listKomentar.size())
            {
                komentar=komentar+ "<li class=\"art-list-item\">"+
                                        "<div class=\"art-list-item-title-and-time\">"+
                                            "<h2 id =\"Nama_Komentar\" class=\"art-list-title\">" + listKomentar.get(i).nama  + "</h2>"+
                                            " <div id =\"Tanggal_Komentar\" class=\"art-list-time\">"+listKomentar.get(i).tanggal + " </div>" +
                                        "</div>"+
                                        "<p id =\"Komentar_Komentar\"> "+ listKomentar.get(i).komentar + "</p>"+
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

    private static java.util.List<java.lang.Object> listComment(java.lang.String postid) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloServiceImpl port = service.getHelloServiceImplPort();
        return port.listComment(postid);
    }

    
}
