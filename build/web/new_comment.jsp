<%@page import="com.test.WSDLConnector"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<%@ page import="java.sql.Connection, javax.sql.*, java.io.*, javax.naming.*" 
%>
<%@ page import="com.mysql.jdbc.Driver, java.sql.PreparedStatement, java.sql.DriverManager, java.util.Random" %><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>

<% 
	Connection conn;
	PreparedStatement pState;
	Random random = new Random();
	 
		String nama = request.getParameter("Nama");
		String post_id = request.getParameter("post_id");
		String comment_date = request.getParameter("comment_date");
		String komentar = request.getParameter("Komentar");
		String email = request.getParameter("Email");
		
		
	WSDLConnector.addComment(nama, email, komentar, post_id);
	
	out.print("<li class=\"art-list-item\">\n"+
    "<div class=\"art-list-item-title-and-time\">\n"+
    "<h2 class=\"art-list-title\"><a href=\"post.html\">"+ nama +"</a></h2>\n"+
    "<div class=\"art-list-time\">"+ comment_date +"</div>\n"+
    "</div>\n"+
    "<p>" + komentar + "</p>\n"+
	"</li>");
	%>

</f:view>
</body>
</html>