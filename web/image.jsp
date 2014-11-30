<%@page import="SimpleBlog.Images"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>

<%@ page import = "java.io.*" %>


<%
 
  int iNumPhoto ;
  Connection conn=null;
    
    Statement stmt = (Statement) conn.createStatement();
  
  if ( request.getParameter("imgID") != null )
  {
   
    iNumPhoto = Integer.parseInt(request.getParameter("imgID")) ;   
  
    try
    {  
       Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpleblog", "root",""); 
  
       // get the image from the database
       byte[] imgData = Images.getPhoto( iNumPhoto  ) ;   
       // display the image
       response.setContentType("image/gif");
       OutputStream o = response.getOutputStream();
       o.write(imgData);
       o.flush(); 
       o.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {
      conn.close();
    }  
  }
%>