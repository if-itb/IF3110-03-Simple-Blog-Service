<%-- 
    Document   : edit_post
    Created on : Nov 25, 2014, 10:23:38 AM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sql" scope="session" class="com.gilang.sql.DBAdapter" />
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />
<%@page import="com.gilang.beans.Post" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>

		<link rel="stylesheet" type="text/css" href="resources/screen.css" />
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico"/>

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

		<title>Simple Blog | Tambah Post</title>


		</head>

		<body class="default">
			
		<% Post post = sql.getPost(Integer.valueOf(request.getParameter("post_id"))); %>
		<div class="wrapper">

		<nav class="nav">
			<a style="border:none;" id="logo" href="home.jsp"><h1>Simple<span>-</span>Blog</h1></a>
			<ul class="nav-primary">
				<li><a href="new_post.jsp">+ Tambah Post</a></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</nav>

		<article class="art simple post">


			<h2 class="art-title" style="margin-bottom:40px">-</h2>

			<div class="art-body">
				<div class="art-body-inner">
					<h2>Tambah Post</h2>

					<div id="contact-area">
						<form method="post" action="update.jsp">
							<input type="hidden" name="post_id" value="<%= post.getPost_id() %>"/>
							<label for="Judul">Judul:</label>
							<input type="text" name="title" id="Judul" value="<%= post.getTitle() %>"/>

							<label for="Tanggal">Tanggal:</label>
							<input type="text" name="date" id="Tanggal" value="<%= post.getDate() %>"/>

							<label for="Konten">Konten:</label><br/>
							<textarea name="content" rows="20" cols="20" id="Konten"><%= post.getContent() %></textarea>

							<input type="submit" name="submit" value="Simpan" class="submit-button"/>
						</form>
					</div>
				</div>
			</div>

		</article>

		<footer class="footer">
			<div class="back-to-top"><a href="">Back to top</a></div>
			<!-- <div class="footer-nav"><p></p></div> -->
			<div class="psi">&Psi;</div>
			<aside class="offsite-links">
				Asisten IF3110 /
				<a class="rss-link" href="#rss">RSS</a> /
				<br/>
				<a class="twitter-link" href="http://twitter.com/YoGiiSinaga">Yogi</a> /
				<a class="twitter-link" href="http://twitter.com/sonnylazuardi">Sonny</a> /
				<a class="twitter-link" href="http://twitter.com/fathanpranaya">Fathan</a> /
				<br/>
				<a class="twitter-link" href="#">Renusa</a> /
				<a class="twitter-link" href="#">Kelvin</a> /
				<a class="twitter-link" href="#">Yanuar</a> /

			</aside>
		</footer>

		</div>

</body>
    </html>
</f:view>
