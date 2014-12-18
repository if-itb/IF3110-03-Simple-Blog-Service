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
      String konten = request.getParameter("konten");
      String date = request.getParameter("Tanggal");
      String idPost = request.getParameter("posts");
      if(SimpleBlogService.addComment(nama, email, konten, date, idPost)){
             String site = new String("view_post.jsp?post="+idPost);
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site); 
      }
  %>
</html>