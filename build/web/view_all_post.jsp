<%-- 
    Document   : view_all_post
    Created on : Dec 18, 2014, 9:33:12 PM
    Author     : M. Reza Irvanda
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         ArrayList<blog.Post> list = (ArrayList)SimpleBlogService.listPost();
         for(blog.Post post : list){
             out.println(post.getId());
             out.println(post.getJudul());
             out.println(post.getKonten());
         }
         %>
    </body>
</html>
