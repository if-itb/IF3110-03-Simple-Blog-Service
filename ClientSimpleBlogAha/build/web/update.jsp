<%-- 
    Document   : update
    Created on : Nov 25, 2014, 4:58:58 PM
    Author     : Teofebano
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
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
            int c= Integer.parseInt(request.getParameter("role").toString());
            String d=request.getParameter("email").toString();
            String name=request.getParameter("name").toString();
            String user_id= request.getParameter("user_id");
            System.out.println(user_id);
            SimpleBlogServiceHandler.editUser(user_id,a,b,name,d,c);
            
            %>
        <%
            response.sendRedirect("ManagementUser.jsp");
        %>
    </body>
</html>
