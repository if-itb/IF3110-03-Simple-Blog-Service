<%-- 
    Document   : insert_comment
    Created on : Nov 25, 2014, 9:44:42 PM
    Author     : M. Reza Irvanda
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blogutil.*" %>
<html>
  <%
      String nama = request.getParameter("nama");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String role = request.getParameter("role").toLowerCase();
      if(SimpleBlogService.addUser(nama, email, role, password)){
             String site = new String("user.jsp");
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site); 
      }
  %>
</html>