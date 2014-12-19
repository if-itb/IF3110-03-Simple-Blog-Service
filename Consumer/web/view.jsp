<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import ="javax.sql.*" %>

<%!	
	String description = "View a Post";
	int selectedID = 3;
	String current_url = "blog.localhost/index.";
	String title = "Error 404 - No post selected";
	String content = "$_GET['id'] is missing. Go back to post list and select a post there.";
	String date = "null";
	String author = "null";
	int initialID = -1;
%>

<%
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleblog","simpleblog","simpleblog");
	
	if (request.getParameter("id") != null) {
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM posts WHERE ID='"+request.getParameter("id")+"';"); 
		if (rs.next()) {
			title = rs.getString("title");
			content = rs.getString("content");
			description = title;
			date = rs.getString("date");
			author = rs.getString("author");
			initialID = rs.getInt("id");
		}
	}
%>

<html lang="en">
<head>
		<!-- Technical Metadata -->
		<meta charset="UTF-8"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="icon" type="image/png" href="img/ridecon.png?v=1">
		<link rel="stylesheet" type="text/css" href="res/mainStyle.css"/>
		<link rel="stylesheet" type="text/css" href="res/devFont.css"/>

		<!-- SEO and Social Metadata -->
		<title>Simple Blog v2.0</title>
		<meta name="description" content="Simple Blog v2.0"/>
</head>
<body onunload=''>
	<div class='center'>
		<nav>
			<a class='menu' <% if (selectedID == 1) { out.print("id='selectedMenu'"); } %> href='index.jsp'><div class='menu'>Articles</div><div class='desc'>List em all!</div></a>
			<a class='menu' <% if (selectedID == 2) { out.print("id='selectedMenu'"); } %> href='editor.jsp'><div class='menu'>Editor</div><div class='desc'>Make a new post!</div></a>
			<div class='menuCenter'><div class='ridecon'></div></div>
			<a class='menu' <% if (selectedID == 3) { out.print("id='selectedMenu'"); } %> href='view.jsp'><div class='menu'>View</div><div class='desc'>View a post</div></a>
			<% try { if (session.getValue("userid").toString() != "none" ) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>User</div><div class='desc'>Login</div></a>
				<% } } catch(Exception x) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>Login</div><div class='desc'>Login</div></a>
				<% } %>
		</nav>
		<main>
			
<script src="res/dalva.js"></script>
			
			
<div class='content'>
	<div class='title'><h1 class='left'><% out.print(title); %></h1><h1 class='right'><% out.print(date); %></h1></div>
	<p><!--<?php echo nl2br($content); ?>--><%= content %></p>
</div>
			
<%!
String contentheight = "240px";
%>

<div style='height:<% out.print(contentheight); %>' class='content1'>
	<div class='title'><h1 class='left'>Article Detail</h1></div>
	Title: <% out.println(title); %><br/>
	Posted on <% out.println(date); %><br/>
	Posted by <%= author %><br/>
</div>
			
<div style='height:<% out.print(contentheight); %>' class='content3' >
	<div class='title'><h1 class='left'>Add a Comment</h1></div>
	<form id="mainForm" method="post" enctype="multipart/form-data" onsubmit="return postComment(this, 'commenthandler.jsp', 'commentJax');">
		<div class="entry" style="width:320px;"><div class="formtext" id="Name">Name</div><input id="NameIn" name="name" type="text" value="<% try { if (session.getValue("userid").toString() != "null") { out.print(session.getValue("userid").toString());} } catch(Exception x3) {};%>" required/></div>
		<div class="entry" style="width:320px;"><div class="formtext" id="Date">Email</div><input id="EmailIn" name="email" type="text" value="<% try { if (session.getValue("usermail").toString() != "null") { out.print(session.getValue("usermail").toString());} } catch(Exception x3) {};%>" required/></div>
		<div class="entry" style="width:100%"><div class="formtext" id="Message">Message</div><textarea style="height: 50px;" class="msg" name="content" required></textarea></div>
		<input id="ID" name="id" type="hidden" value="<% out.print(initialID); %>"/>
		<div class="button"><input id="submitButton" class="button" name="Submit" value="Submit" type="submit"/></div>
	</form>
</div>
			
			<div id='commentJax'></div>
			
			<footer>
				Site Design and Code &copy; Darieza Alliance 2014. All rights reserved. This site are simplified and is using dalva24's template from <a href='http://dalva24.com'>Dalva24.com</a>
			</footer>
		</main>
	</div>
	<div id="pagefader"></div>
	<script>
		loadPage("commenthandler.jsp?id=<% out.print(initialID); %>", "commentJax");
	</script>
</body>
</html>