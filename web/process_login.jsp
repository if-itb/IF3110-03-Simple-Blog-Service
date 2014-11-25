<%-- 
    Document   : dashboard
    Created on : 21-Nov-2014, 14:40:05
    Author     : Asus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%! Cookie c1,c2,c3;
    String role, id;
%>

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
        role = rs.getString("role");
        id = rs.getString("id");
        session.setAttribute("username", userid);
        session.setAttribute( "role", role );
        session.setAttribute( "id_user", id );
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        c2 = new Cookie("username",userid);
        c1 = new Cookie("role",rs.getString("role"));
        c3 = new Cookie("id_user",rs.getString("id"));
        c3.setMaxAge(60);
        c1.setMaxAge(60);
        c2.setMaxAge(60);
        c1.setPath("/");
        c2.setPath("/");
        c3.setPath("/");
        
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.sendRedirect("index.jsp");
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