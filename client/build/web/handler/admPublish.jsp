<%-- 
    Document   : admPublish
    Created on : Nov 25, 2014, 10:16:59 PM
    Author     : adwisatya
--%>
<%@page import="classes.Client"%>
<%@page import = "classes.Post" %>
<%
	String id	=	 request.getParameter("id");
	Client cli = new Client();
        int i = Integer.parseInt(id);
        cli.publishPost(i);
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "../index.jsp");
%>

