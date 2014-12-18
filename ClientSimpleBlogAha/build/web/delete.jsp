<%-- 
    Document   : delete
    Created on : Nov 25, 2014, 3:58:23 PM
    Author     : Teofebano
--%>

<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         
         String user_id= request.getParameter("user_id");
         SimpleBlogServiceHandler.deleteUser(user_id);
         response.sendRedirect("ManagementUser.jsp");
         
        %>
    </body>
</html>
