<%-- 
    Document   : dashboard
    Created on : 21-Nov-2014, 14:40:05
    Author     : Asus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%
    String userid = request.getParameter("username");   
    String pwd = request.getParameter("password");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/tucildb_13511097";
    Connection con = DriverManager.getConnection(url,"root", "");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from user where username='" + userid + "' and password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("username", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        Cookie c = new Cookie("username",userid);
        c.setMaxAge(24*60*60);
        response.addCookie(c);
        response.sendRedirect("dashboard.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logged in!</h1>
    </body>
</html>