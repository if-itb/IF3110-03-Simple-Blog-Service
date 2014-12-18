package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import classes.Client;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.io.*;

public final class add_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jspf/koneksi.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

String xDRIVER = "com.mysql.jdbc.Driver";
String xUSERNAME = "root";
String xPASSWORD = "";
String xSTRING = "jdbc:mysql://localhost:3306/tubes2wbd";
Class.forName(xDRIVER);


      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\t<meta name=\"description\" content=\"Simple Blog\">\n");
      out.write("\t<meta name=\"author\" content=\"Bangsatya\">\n");
      out.write("\t\n");
      out.write("\t<!-- Twitter Card -->\n");
      out.write("\t<meta name=\"twitter:card\" content=\"summary\">\n");
      out.write("\t<meta name=\"twitter:site\" content=\"omfgitsasalmon\">\n");
      out.write("\t<meta name=\"twitter:title\" content=\"Simple Blog\">\n");
      out.write("\t<meta name=\"twitter:description\" content=\"Simple Blog\">\n");
      out.write("\t<meta name=\"twitter:creator\" content=\"Bangsatya Blog\">\n");
      out.write("\t<meta name=\"twitter:image:src\" content=\"{{! TODO: ADD GRAVATAR URL HERE }}\">\n");
      out.write("\t\n");
      out.write("\t<meta property=\"og:type\" content=\"article\">\n");
      out.write("\t<meta property=\"og:title\" content=\"Simple Blog\">\n");
      out.write("\t<meta property=\"og:description\" content=\"Deskripsi Blog\">\n");
      out.write("\t<meta property=\"og:image\" content=\"{{! TODO: ADD GRAVATAR URL HERE }}\">\n");
      out.write("\t<meta property=\"og:site_name\" content=\"Simple Blog\">\n");
      out.write("\t\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/screen.css\" />\n");
      out.write("\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/favicon.ico\">\n");
      out.write("\t\n");
      out.write("\t<!--[if lt IE 9]>\n");
      out.write("\t    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("\t<![endif]-->\n");
      out.write("\t<title>Simple Blog of Bangsatya | Add User</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"wrapper\">\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\n');

	String usrC=" ";
	int typeC=4;
	Cookie[] cookies = null;
	cookies = request.getCookies();
	if (cookies!=null){
		for (Cookie c:cookies){
			if (c.getName().equals("LogName")){
				usrC=c.getValue();
				for (Cookie c2:cookies){
				    if (c2.getName().equals("LogType")){
							typeC=Integer.parseInt(c2.getValue());
						}
				}
			}
		}
	}

      out.write("\n");
      out.write("<article class=\"art simple post\" style=\"margin-top:120px;\">\n");
      out.write("\t<div class=\"art-body\" style=\"margin-top:70px\">\n");
      out.write("        <div class=\"art-body-inner\">\n");
      out.write("       \t");

       	if (typeC==1) {
       	
      out.write("\n");
      out.write("\t\tYou can't add new user\n");
      out.write("       \t");
 } else { 
      out.write("\n");
      out.write("        <h2>Add New User</h2>\n");
      out.write("        <div id=\"contact-area\">\n");
      out.write("        <form method=\"post\">\n");
      out.write("\t\t\t<label>Nama: </label><input type=\"text\" id=\"user_name\" name=\"user_name\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<label>Username: </label><input type=\"text\" id=\"user_username\" name=\"user_username\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<label>Password: </label><input type=\"text\" id=\"user_password\" name=\"user_password\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<label>Email: </label><input type=\"text\" id=\"user_email\" name=\"user_email\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<label>Status</label>\n");
      out.write("\t\t\t\t<select id=\"user_status\" name=\"user_status\">\n");
      out.write("\t\t\t\t\t<option value=\"1\"> Admin </option>\n");
      out.write("\t\t\t\t\t<option value=\"2\"> Owner </option>\n");
      out.write("\t\t\t\t\t<option value=\"3\"> Editor </option>\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"submit\" class=\"submit-button\" value=\"Tambah\">\n");
      out.write("\t\t</form>\n");
      out.write("\t\t");

			String user_name	=	 request.getParameter("user_name");
			String user_username = request.getParameter("user_username");
			String user_password = request.getParameter("user_password");
			String user_status = request.getParameter("user_status");
			String user_email	=	 request.getParameter("user_email");


			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			int updateQuery= 0 ;
			if(user_name != null && user_username != null && user_password != null  && user_email != null && user_status != null ){
                            Client Cli = new Client();
                            Cli.addUser(user_name,user_email,user_username,user_password,user_status);
				/*try{
					Connection connection = null;
					Statement statement = null;
					ResultSet rs = null;
					Class.forName(xDRIVER);
					connection = DriverManager.getConnection(xSTRING,xUSERNAME,xPASSWORD);
					statement = connection.createStatement();
					
					String query = "insert into users(username,password,nama,email,status,created) VALUES(\'"+user_username+"\',\'"+user_password+"\',\'"+user_name+"\',\'"+user_email+"\',\'"+user_status+"\',\'"+sdf.format(date)+"\')";
					updateQuery = statement.executeUpdate(query);
					
					if(updateQuery != 0){
						out.print("Penambahan user sukses");
						statement.close();
						connection.close();
					}

				}catch(SQLException ex){
					out.println(ex);
					out.println("Koneksi Bermasalah");
				}finally{

				}*/
			}			
		
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t");
 } 
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</article>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
