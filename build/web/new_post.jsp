<%@page import="com.test.WSDLConnector"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<%@ page import="java.sql.Connection, javax.sql.*, java.io.*, javax.naming.*, com.test.*" 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Load new post</title>
</head>
<body>
<% 
	String tittle = request.getParameter("Judul");
	String postDate = request.getParameter("Tanggal");
	String konten = request.getParameter("Konten");

	WSDLConnector.addPost(tittle, konten, postDate);
	response.sendRedirect("faces/index.jsp"); 
%>

<f:view>

</f:view>
</body>
</html>