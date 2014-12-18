<%-- 
    Document   : load_comment
    Created on : Nov 26, 2014, 1:50:44 PM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="undeclared.mavenproject1.Comment"%>
<%@page import="undeclared.service.Service" %>
<jsp:useBean id="sql" scope="session" class="com.gilang.sql.DBAdapter" />

<ul class="art-list-body">
	<% for(Comment k : Service.listComment(Integer.valueOf(request.getParameter("post_id")))){ %>
		<li class="art-list-item">
			<div class="art-list-item-title-and-time">
				<h2 class="art-list-title"><a href="post.html"><%= k.getName() %></a></h2>
				<%= k.getEmail() %>
				<div class="art-list-time"><%= k.getDate()%></div>
			</div>
			<p> <%= k.getContent()%></p>
		</li>
	<%	} %>
</ul>
