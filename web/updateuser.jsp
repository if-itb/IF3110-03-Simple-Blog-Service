<%@page import="com.test.WSDLConnector"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.*" 
%>
<%@ page import="java.sql.Connection, javax.sql.*, java.io.*, javax.naming.*" 
%>
<%@ page import="com.mysql.jdbc.Driver, java.sql.PreparedStatement, java.sql.DriverManager, java.util.Random" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<%
	String username = request.getParameter("Username");
	String nama = request.getParameter("Nama");
	String email = request.getParameter("Email");
	String role = request.getParameter("Role");
	String password = request.getParameter("Password");
	String id = request.getParameter("user_id");
	WSDLConnector.editUser(username, password, id, nama, role, email);
	response.sendRedirect("man_user.jsp"); 
%>

<f:view>

</f:view>
</body>
</html>