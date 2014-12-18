<%-- 
    Document   : updatePost.jsp
    Created on : Nov 25, 2014, 9:13:09 PM
    Author     : adwisatya
--%>

<%@page import= "classes.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "classes.Post" %>
<%@page import= "classes.User" %>
<%@page import= "classes.Comment" %>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.Date" %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String ID	=	request.getParameter("ID");
	String Judul = request.getParameter("judul");
	String Konten = request.getParameter("konten");
        String Tanggal = request.getParameter("tanggal");
        Date date = sdf.parse(Tanggal);
	//PostBean pBean	=	 new PostBean();
	//pBean.EditPost(ID, Judul, Tanggal, Konten);
	Post.EditPost(ID, Judul, date, Konten);
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "../show_post.jsp?id="+ID);

%>
