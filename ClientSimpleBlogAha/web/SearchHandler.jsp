<%-- 
    Document   : SearchHandler
    Created on : Nov 24, 2014, 2:10:26 PM
    Author     : Teofebano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.Connection"%>
<%@ page language="java" import="java.sql.PreparedStatement"%>
<%@ page language="java" import="java.sql.ResultSet"%>
<%@ page language="java" import="java.sql.SQLException"%>
<%@ page language="java" import="java.sql.DriverManager"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.lang.String"%>
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Login Check</title> 
    </head> 
    <body> 
        <% 
            String query=request.getParameter("search"); 
            session.setAttribute("query",query);
            response.sendRedirect("home.jsp");    
        %> 
    </body> 
</html>

