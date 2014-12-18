<%-- 
    Document   : add
    Created on : Nov 25, 2014, 6:32:38 PM
    Author     : Teofebano
--%>

<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
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
            String a=request.getParameter("username").toString();
            String b=request.getParameter("password").toString();
            String nama=request.getParameter("nama").toString();
            int c= Integer.parseInt(request.getParameter("role"));
            String d=request.getParameter("email").toString();
           
            SimpleBlogServiceHandler.addUser(a, b, nama, d, c);
            %>
        <%
                
            response.sendRedirect("ManagementUser.jsp");
        %>
    </body>
</html>
