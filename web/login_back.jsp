<%-- 
    Document   : insert_comment
    Created on : Nov 25, 2014, 9:44:42 PM
    Author     : M. Reza Irvanda
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blogutil.*,blog.*" %>
<html>
  <%
      String nama = request.getParameter("nama");
      String password = request.getParameter("password");
      ArrayList<Pengguna> list = (ArrayList)SimpleBlogService.listUser();
      for(Pengguna temp : list){
          if(temp.getNama().equals(nama) && temp.getPassword().equals(password)){
              Cookie cook = new Cookie("nama", temp.getNama());
              Cookie cook1 = new Cookie("email", temp.getEmail());
              Cookie cook2 = new Cookie("role", temp.getRole());
              Cookie cook3 = new Cookie("username", temp.getUsername());
              
              response.addCookie(cook);
              response.addCookie(cook1);
              response.addCookie(cook2);
              response.addCookie(cook3);
              
             String site = new String("view_post.jsp");
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site); 
          }
      }
      
      String site = new String("login.jsp?error=1");
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site);
  %>
</html>