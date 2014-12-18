package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import classes.Client;
import classes.Post;
import classes.User;
import classes.Comment;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("<!-- \n");
      out.write("    Document   : index\n");
      out.write("    Created on : Nov 24, 2014, 4:14:48 PM\n");
      out.write("    Author     : adwisatya\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("<meta name=\"description\" content=\"Simple Blog\">\n");
      out.write("<meta name=\"author\" content=\"Bangsatya\">\n");
      out.write("\n");
      out.write("<!-- Twitter Card -->\n");
      out.write("<meta name=\"twitter:card\" content=\"summary\">\n");
      out.write("<meta name=\"twitter:site\" content=\"omfgitsasalmon\">\n");
      out.write("<meta name=\"twitter:title\" content=\"Simple Blog\">\n");
      out.write("<meta name=\"twitter:description\" content=\"Simple Blog\">\n");
      out.write("<meta name=\"twitter:creator\" content=\"Bangsatya Blog\">\n");
      out.write("<meta name=\"twitter:image:src\" content=\"{{! TODO: ADD GRAVATAR URL HERE }}\">\n");
      out.write("\n");
      out.write("<meta property=\"og:type\" content=\"article\">\n");
      out.write("<meta property=\"og:title\" content=\"Simple Blog\">\n");
      out.write("<meta property=\"og:description\" content=\"Deskripsi Blog\">\n");
      out.write("<meta property=\"og:image\" content=\"{{! TODO: ADD GRAVATAR URL HERE }}\">\n");
      out.write("<meta property=\"og:site_name\" content=\"Simple Blog\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/screen.css\" />\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/favicon.ico\">\n");
      out.write("\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("<![endif]-->\n");
      out.write("\n");
      out.write("<title>Simple Blog of Bangsatya</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"default\">\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("\n");
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
      out.write("\n");
      out.write("<div id=\"home\">\n");
      out.write("    <div class=\"posts\">\n");
      out.write("        <nav class=\"art-list\">\n");
      out.write("          <ul class=\"art-list-body\">\n");
      out.write("\t\t\t");

				Client Cli = new Client();
				for(int i=0;i<Cli.GetPublishedPost().size();i++){
					if(Cli.GetPublishedPost().get(i).Status == 1){
			
      out.write("\t\n");
      out.write("\t\t\t<li class=\"art-list-item\">\n");
      out.write("\t\t\t\t<div class=\"art-list-item-title-and-time\">\n");
      out.write("\t\t\t\t\t<h2 class=\"art-list-title\"><a href=\"show_post.jsp?id=");
 out.println(Cli.GetPublishedPost().get(i).id); 
      out.write('"');
      out.write('>');
 out.println(Cli.GetPublishedPost().get(i).Judul); 
      out.write("</a></h2>\n");
      out.write("\t\t\t\t\t<div class=\"art-list-time\">");
 out.println(Cli.GetPublishedPost().get(i).tanggal); 
      out.write("</div>\n");
      out.write("\t\t\t\t\t<div class=\"art-list-owner\">Owner:&nbsp;");
 out.println(Cli.GetPublishedPost().get(i).Owner); 
      out.write("</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<p>");
 out.println(Cli.GetPublishedPost().get(i).Konten); 
      out.write("</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t");
 if (typeC!=4){
				
      out.write("\n");
      out.write("\t\t\t\t\t<a href=\"edit.jsp?id=");
 out.println(Cli.GetPublishedPost().get(i).id); 
      out.write("\">Edit</a> | <a href=\"#\" onclick=\"return ConfirmDelete(");
 out.println(Cli.GetPublishedPost().get(i).id); 
      out.write(");\">Hapus</a>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</li>\t\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\n");
      out.write("          </ul>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    function ConfirmDelete(nomor)\n");
      out.write("    {\n");
      out.write("      var x = confirm(\"Apakah Anda yakin menghapus post ini?\");\n");
      out.write("      if (x)\n");
      out.write("          return window.location.assign('trashPost.jsp?id='+nomor);\n");
      out.write("      else\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
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
