<%-- 
    Document   : insert_comment
    Created on : Nov 25, 2014, 9:44:42 PM
    Author     : M. Reza Irvanda
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blogutil.*" %>
<html>
  <%
      String post = request.getParameter("post");
      String judul = request.getParameter("Judul");
      String tanggal = request.getParameter("Tanggal");
      String konten = request.getParameter("Konten");
      if(SimpleBlogService.editPost(post, judul, konten, tanggal)){
             String site = new String("view_post.jsp");
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site); 
      }
  %>
</html>