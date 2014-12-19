<%@ page import="java.sql.*" %>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%
   Connection conn=null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpleblog", "root","");

   PreparedStatement psImageInsertDatabase=null;

   byte[] b=null;
   try{
      String sqlImageInsertDatabase="insert into imagepost (image) values(?)";
      psImageInsertDatabase=conn.prepareStatement(sqlImageInsertDatabase);

      DiskFileItemFactory factory = new DiskFileItemFactory();

      ServletFileUpload sfu = new ServletFileUpload(factory);
      List items = sfu.parseRequest(request);

      Iterator iter = items.iterator();

      while (iter.hasNext()) {
         FileItem item = (FileItem) iter.next();
         if (!item.isFormField()) {
              b = item.get();
          }
      }

      psImageInsertDatabase.setBytes(1,b);
      psImageInsertDatabase.executeUpdate();
   }
   catch(Exception e)
   {
     e.printStackTrace();
     response.sendRedirect("addimage.jsp");
   }

%>