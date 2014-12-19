<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html>
<!--
Copyright (C) 2014 Arieza Dictatorship
-->

<%
	int selectedID = 1;
	String currentURL = "blog.localhost/index.jsp";
	
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleblog","simpleblog","simpleblog");
	
	if (request.getParameter("delete") != null) {
		String id=request.getParameter("delete");
		Statement st= con.createStatement();
		st.executeUpdate("DELETE FROM `simpleblog`.`posts` WHERE `posts`.`ID` = '"+id+"';"); 
	}
	if (request.getParameter("publish") != null) {
		String id=request.getParameter("publish");
		Statement st= con.createStatement();
		st.executeUpdate("UPDATE `simpleblog`.`posts` SET `published` = '1' WHERE `posts`.`ID` =  '"+id+"';"); 
	}
%>

<html>
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
				<a class='menu' <% if (selectedID == 1) {out.println("id='selectedMenu'"); } %> href='index.jsp'><div class='menu'>Articles</div><div class='desc'>List em all!</div></a>
				<a class='menu' <% if (selectedID == 2) {out.println("id='selectedMenu'"); } %> href='editor.jsp'><div class='menu'>Editor</div><div class='desc'>Make a new post!</div></a>
				<div class='menuCenter'><div class='ridecon'></div></div>
				<a class='menu' <% if (selectedID == 3) {out.println("id='selectedMenu'"); } %> href='view.jsp'><div class='menu'>View</div><div class='desc'>View a post</div></a>
				<% try { if (session.getValue("userid").toString() != "none" ) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>User</div><div class='desc'>Login</div></a>
				<% } } catch(Exception x) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>Login</div><div class='desc'>Login</div></a>
				<% } %>
			</nav>
			<main>
				<div class='content'>
					<div class='title'><h1 class='left'>A Simple Blog</h1></div>
					<p>
						A simple blog for IF3110 Assignment No. 2
					</p>
				</div>
				<div class='portocontainer'>

				<%
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM posts"); 
					
					while(rs.next()) { %>
					<% try { if (session.getValue("usertype").toString() == "2" || session.getValue("usertype").toString() == "3" || (session.getValue("usertype").toString() != "2" && rs.getInt("published") == 0 ) ||  rs.getInt("published") == 1) { %>
					
					<div class="item">
						<div class='detail'>
							<div class='title'><h1 class="right"><% out.print(rs.getString("author")); %> &rightarrowtail;</h1></div>
							<p>
								<% 
									out.print(rs.getString("date") + "<br/>");
									Statement st2= con.createStatement();
									ResultSet rs2=st2.executeQuery("SELECT count(ID) FROM comments where comments.PID = " + rs.getString("ID")); 
									if (rs2.next()) {
										out.println(rs2.getString(1) + " comments<br/>");
									}
								%>
								<% try { if (session.getValue("usertype").toString() != "2" || session.getValue("usertype").toString() != "3") { %>
								<a href='editor.jsp?id=<% out.print(rs.getString("ID")); %>'>Edit</a>
								<% } } catch(Exception x1) {};%>
								<% try { if (session.getValue("usertype").toString() != "3") { %>
								<a href='#' onclick='delAsk("<% out.print(rs.getString("ID")); %>")'>Delete</a>
								<% } } catch(Exception x2) {};%>
								<% try { if (session.getValue("usertype").toString() != "3" && rs.getInt("published") == 0) { %>
								<a href='#' onclick='pubAsk("<% out.print(rs.getString("ID")); %>")'>Publish</a>
								<% } } catch(Exception x3) {};%>
							</p>
						</div>
						<div class='desc'>
							<div class='title'><a href='view.jsp?id=<% out.print(rs.getString("ID")); %>'><h1 class='left'><% if (rs.getInt("published") == 0 ) { out.print("[unpublished] "); } %><% out.print(rs.getString("title")); %></h1></a></div>
							<p><% out.print(rs.getString("content")); %></p>
						</div>
						<form class='hidden' action="index.jsp" method="post" id='delform<% out.print(rs.getString("ID")); %>'>
							  <input class=hidden name='delete' value='<% out.print(rs.getString("ID")); %>'>
						</form>
						<form class='hidden' action="index.jsp" method="post" id='pubform<% out.print(rs.getString("ID")); %>'>
							  <input class=hidden name='publish' value='<% out.print(rs.getString("ID")); %>'>
						</form>
					</div>
					<% } } catch(Exception x4) { %>
					<% if (rs.getInt("published") == 1 ) { %>
					
					<div class="item">
						<div class='detail'>
							<div class='title'><h1 class="right"><% out.print(rs.getString("author")); %> &rightarrowtail;</h1></div>
							<p>
								<% 
									out.print(rs.getString("date") + "<br/>");
									Statement st2= con.createStatement();
									ResultSet rs2=st2.executeQuery("SELECT count(ID) FROM comments where comments.PID = " + rs.getString("ID")); 
									if (rs2.next()) {
										out.println(rs2.getString(1) + " comments<br/>");
									}
								%>
								<% try { if (session.getValue("usertype").toString() != "2" || session.getValue("usertype").toString() != "3") { %>
								<a href='editor.jsp?id=<% out.print(rs.getString("ID")); %>'>Edit</a>
								<% } } catch(Exception x5) {};%>
								<% try { if (session.getValue("usertype").toString() != "3") { %>
								<a href='#' onclick='delAsk("<% out.print(rs.getString("ID")); %>")'>Delete</a>
								<% } } catch(Exception x6) {};%>
							</p>
						</div>
						<div class='desc'>
							<div class='title'><a href='view.jsp?id=<% out.print(rs.getString("ID")); %>'><h1 class='left'><% out.print(rs.getString("title")); %></h1></a></div>
							<p><% out.print(rs.getString("content")); %></p>
						</div>
						<form class='hidden' action="index.jsp" method="post" id='delform<% out.print(rs.getString("ID")); %>'>
							  <input class=hidden name='delete' value='<% out.print(rs.getString("ID")); %>'>
						</form>
						<form class='hidden' action="index.jsp" method="post" id='pubform<% out.print(rs.getString("ID")); %>'>
							  <input class=hidden name='publish' value='<% out.print(rs.getString("ID")); %>'>
						</form>
					</div>

					<% } };%>
					<% } %>

					<script>
						function delAsk(id) {
							var r = confirm("Are you sure you want to delete this post?");
							if (r === true) {
								document.getElementById("delform" + id).submit();
							}
						}
						function pubAsk(id) {
							var r = confirm("Are you sure you want to publish this post?");
							if (r === true) {
								document.getElementById("pubform" + id).submit();
							}
						}
					</script>

				</div>

				<footer>
					Site Design and Code &copy; Darieza Alliance 2014. All rights reserved. This site are simplified and is using dalva24's template from <a href='http://dalva24.com'>Dalva24.com</a>
				</footer>
			</main>
		</div>
		<div id="pagefader"></div>
		<script src="res/dalva.js"></script>
	</body>
</html>

