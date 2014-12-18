<%-- 
    Document   : newPost
    Created on : Nov 25, 2014, 1:01:57 AM
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
        
	String Judul = request.getParameter("judul");
	String Tanggal = request.getParameter("tanggal");
	String Konten = request.getParameter("konten");
	String Owner = request.getParameter("owner");
        Date date = sdf.parse(Tanggal);
        Long l = date.getTime();
        
        Client cli = new Client();
        cli.addNewPost(Judul,Owner,Konten,l);
        //Post.NewPost(Judul,date,Konten,Owner);
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "../index.jsp");
%>
