<%-- 
    Document   : index
    Created on : Nov 25, 2014, 6:05:21 AM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="undeclared.service.Service" %>
<%@page import="undeclared.mavenproject1.Post" %>
<%@page import="java.util.List" %>

<jsp:useBean id="sql" class="com.gilang.sql.DBAdapter" scope="session"/>
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
       <head>

	<link rel="stylesheet" type="text/css" href="resources/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="resources/screen.css" />
	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico"/>

	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<title>Simple Blog</title>

	<%	if(user.getUsername() == null){
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "home.jsp");
		}
	%>
	Hello <%= user.getUsername() %>
	</head>
	
	<body class="default">
		
	<img src="resources/img/bg.png" class="background">
	<img src="resources/img/navbackground.png" class="navbackground">
	
	<div class="wrapper">

	<nav class="nav">
		<div class="logologo">
				<img src="resources/img/navicon.png" class="navicon">
				<a id="logo" href="home.jsp"><img src="resources/img/icontext.png" class="icontext"></a>
		</div>
		<form action="index.jsp" class="form-inline" style="margin-left: 200px; float: left;">
			<div class="form-group">
				<input type="text" name="query" class="form-control"/>
				<input type="submit" class="btn btn-default" value="search"/>
			</div>
		</form>	
		<ul class="nav-primary">
			<% if(user.getRole() == 1 || user.getRole() == 3){ %>
			<li><a href="new_post.jsp"><img src="resources/img/add.png" style="width: auto; height: 80px; size: auto;"> </a></li>
			<% } %>
			<li><a href="logout.jsp"><img src="resources/img/logout.png" style="width: auto; height: 80px; size: auto;"></a></li>
		</ul>
	</nav>

	<div id="home">
		<div class="posts">
			<nav class="art-list">
				<% if(user.getRole() == 2){ %>
					<a href="unpublished.jsp" style="text-align: right; display: block; width: 100%;" class="art-list-title">Publish Posts</a>
				<% } else if(user.getRole() == 3){ %>
				<div style="text-align: right; display: block; width: 100%;">
					<a href="deleted.jsp" class="art-list-time">Restore Post</a>
					|
					<a href="unpublished.jsp" class="art-list-time">Publish Post</a>
					|
					<a href="manage_user.jsp" class="art-list-time">Manage User</a>
				</div>
				<% } %>
			  <ul class="art-list-body">
			<%	List<Post> ps;
				if(request.getParameter("query") != null)
					ps = Service.search(request.getParameter("query"));
				else
					ps = Service.listPublishPost(true);
				for(Post p : ps/*sql.getPosts(false)*/){	  %>
				<li class="art-list-item">
					<div class="art-list-item-title-and-time">
						<h2 class="art-list-title"><a href="post.jsp?post_id=<%= p.getId() %>"><%= p.getTitle() %></a></h2>
						<div class="art-list-time"><%= p.getDate() %></div>
						<div class="art-list-time"><span style="color:#F40034;">&#10029;</span> Featured</div>
					</div>
					<p><%= p.getContent() %></p>
					<p>
					
					<% if(user.getRole() == 1 || user.getRole() == 2 || user.getRole() == 3){ %>
					<a href="edit_post.jsp?post_id=<%= p.getId() %>">Edit</a>
					   | 
					   <a onclick="return Konfirmasi()" href="delete_post.jsp?post_id=<%= p.getId() %>">Hapus</a>
					<% } %>
					</p>
				</li>
			<%	} %>
				  
			  </ul>
			</nav>
		</div>
	</div>

	<footer class="footer">
		<div class="back-to-top"><a href="">Back to top</a></div>
		<!-- <div class="footer-nav"><p></p></div> -->
		<div class="psi">&Psi;</div>
		<aside class="offsite-links">
			Gilang Julian Suherik | 13512045
			<br/>
			Daniar Heri Kurniawan | 13512064
			<br/>
			Muhammad Husain Jakfari | 13512067
		</aside>
	</footer>

	</div>
	</body>
	<script>
		function Konfirmasi(x) {
			if (confirm("Yakin mau delete?") == true) 
				return true;
			return false;
		}
</script>
    </html>
</f:view>
