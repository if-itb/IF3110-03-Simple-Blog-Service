<%-- 
    Document   : edit_user
    Created on : Nov 25, 2014, 9:16:41 PM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sql" scope="session" class="com.gilang.sql.DBAdapter" />
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />
<%@page import="com.gilang.beans.UserData" %>

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

		<title>Simple Blog | Edit User</title>


		</head>

		<body class="default">
			
		<% UserData userData = sql.getUser(request.getParameter("user_id")); %>
		<div class="wrapper">

		<nav class="nav">
			<a style="border:none;" id="logo" href="home.jsp"><h1>Simple<span>-</span>Blog</h1></a>
			<ul class="nav-primary">
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</nav>

		<article class="art simple post">


			<h2 class="art-title" style="margin-bottom:40px">-</h2>

			<div class="art-body">
				<div class="art-body-inner">
					<h2>Edit User</h2>

					<div id="contact-area">
						<form method="post" action="update_user.jsp">
							<label for="user">User ID:</label>
							<input type="text" name="user_id" id="user" value="<%= userData.getUser_id() %>" readonly="true"/>

							<label for="role">Role:</label>
							<input type="text" name="role" id="role" value="<%= userData.getRole() %>"/>

                                                        
                                                        <label for="role">Email:</label>
							<input type="text" name="email" id="email" value="<%= userData.getEmail() %>"/>

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

