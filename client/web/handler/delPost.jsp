<%-- 
    Document   : delPost
    Created on : Nov 25, 2014, 9:50:13 PM
    Author     : adwisatya
--%>

<%@page import= "classes.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "classes.Post" %>
<%@page import= "classes.User" %>
<%@page import= "classes.Comment" %>

<%
	String ID	=	request.getParameter("id");

	//PostBean pBean	=	 new PostBean();
	//pBean.EditPost(ID, Judul, Tanggal, Konten);
        int i = Integer.parseInt(ID);
        Client cli = new Client();
        cli.deletePost(i);
	//Post.DeletePost(ID);
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "../index.jsp");

%>
