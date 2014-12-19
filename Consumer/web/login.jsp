<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html>
<!--
Copyright (C) 2014 Arieza Dictatorship
-->

<%
	int selectedID = 4;
	String currentURL = "blog.localhost/index.jsp";
	
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleblog","simpleblog","simpleblog");
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
		
		<% 
		if (request.getParameter("logout") != null) {
			session.removeValue("userid");
			session.removeValue("usertype");
			session.removeValue("usermail");
			out.println("<script>alert('You are logged out.');</script>");
		}  else if (request.getParameter("email") != null && request.getParameter("userid") != null && request.getParameter("pwd") != null) {
			String user=request.getParameter("userid");
			String pwd=request.getParameter("pwd");
			String email=request.getParameter("email");
			session.putValue("userid",user);
			session.putValue("usertype","1");
			session.putValue("usermail",email);
			Statement st = con.createStatement();
			int type = 3;
			int i=st.executeUpdate("INSERT INTO `simpleblog`.`users` (`userid`, `name`, `password`, `type`, `email`) VALUES (NULL, '"+user+"', '"+pwd+"', '"+type+"', '"+email+"');");
		} else if (request.getParameter("usr") != null && request.getParameter("pwd") != null) {
			String userid = request.getParameter("usr");
			String pwd = request.getParameter("pwd");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where name='" + userid + "'");
			if (rs.next()) {
				if (rs.getString("password").equals(pwd)) {
					session.putValue("userid", userid);
					session.putValue("usertype",rs.getString("type"));
					session.putValue("usermail",rs.getString("email"));
					out.println("<script>alert('welcome " + userid + "');</script>");
				} else {
					out.println("<script>alert('Invalid username or password');</script>");
				}
			} else {
				out.println("<script>alert('Invalid username or password');</script>");
			}
		} 
		
		if (request.getParameter("makeadmin") != null) {
			String id=request.getParameter("makeadmin");
			Statement st= con.createStatement();
			st.executeUpdate("UPDATE `simpleblog`.`users` SET `type` = '3' WHERE `users`.`name` = '"+id+"';"); 
		}
		if (request.getParameter("makeeditor") != null) {
			String id=request.getParameter("makeeditor");
			Statement st= con.createStatement();
			st.executeUpdate("UPDATE `simpleblog`.`users` SET `type` = '2' WHERE `users`.`name` = '"+id+"';"); 
		}
		if (request.getParameter("makeowner") != null) {
			String id=request.getParameter("makeowner");
			Statement st= con.createStatement();
			st.executeUpdate("UPDATE `simpleblog`.`users` SET `type` = '1' WHERE `users`.`name` = '"+id+"';"); 
		}
		if (request.getParameter("nuke") != null) {
			String id=request.getParameter("nuke");
			Statement st= con.createStatement();
			st.executeUpdate("DELETE FROM `simpleblog`.`users` WHERE `users`.`name` = '"+id+"';"); 
		}
		%>
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
					<% try { if (session.getValue("userid").toString() != "none" ) { %>
					<form action="login.jsp" method="post">
						Press to Logout:
						<input id="ID" name="logout" type="hidden" value="logout"/>
						<input type="submit" value="Logout"/>	
				</form>
					<% } } catch(Exception x) { %>
					<div class='title'><h1 class='left'>REGISTER</h1></div>
					<form action="login.jsp" method="post">
						Email :<input type="text" name="email" /><br/>
						User name :<input type="text" name="userid" /><br/>
						password :<input type="password" name="pwd" /><br/>
						<input type="submit" value="Register"/>
					</form>
					<div class='title'><h1 class='left'>LOGIN</h1></div>
					<form action="login.jsp" method="post">
						User name :<input type="text" name="usr" /><br/>
						password :<input type="password" name="pwd" /><br/>
						<input type="submit" value="Login"/>

					</form>
					<% } %>
				</div>
				
					<% try { if (session.getValue("usertype").toString().equalsIgnoreCase("3")) { %>
				<div class='content'><h1 class="left">ADMIN SCREEN</h1><table style="width: 100%"><thead><td>Username</td><td>Set...</td></thead>
					<% Statement st= con.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM users");
					while(rs.next()) { %>
						<tr>
							<td><%= rs.getString("name") %></td>
							<td>
								<a href="#" onclick="document.getElementById('makeadmin<%= rs.getString("name") %>').submit();">Admin</a>
								<a href="#" onclick="document.getElementById('makeeditor<%= rs.getString("name") %>').submit();">Editor</a>
								<a href="#" onclick="document.getElementById('makeowner<%= rs.getString("name") %>').submit();">Owner</a>
								<a href="#" onclick="document.getElementById('nuke<%= rs.getString("name") %>').submit();">Nuke</a>
							</td> 
						</tr>
						<form style="display:none" class='hidden' action="login.jsp" method="post" id='makeadmin<%= rs.getString("name") %>'>
							  <input class=hidden style="display:none" name='makeadmin' value='<%= rs.getString("name") %>'>
						</form>
						<form style="display:none" class='hidden' action="login.jsp" method="post" id='makeowner<%= rs.getString("name") %>'>
							  <input class=hidden style="display: none" name='makeowner' value='<%= rs.getString("name") %>'>
						</form>
						<form style="display:none" class='hidden' action="login.jsp" method="post" id='makeeditor<%= rs.getString("name") %>'>
							  <input class=hidden style="display:none" name='makeeditor' value='<%= rs.getString("name") %>'>
						</form>
						<form style="display:none" class='hidden' action="login.jsp" method="post" id='nuke<%= rs.getString("name") %>'>
							  <input class=hidden style="display:none" name='nuke' value='<%= rs.getString("name") %>'>
						</form>
					<% } %>
				</table></div>
				<% } } catch(Exception x) {} %>
				<footer>
					Site Design and Code &copy; Darieza Alliance 2014. All rights reserved. This site are simplified and is using dalva24's template from <a href='http://dalva24.com'>Dalva24.com</a>
				</footer>
			</main>
		</div>
		<div id="pagefader"></div>
		<script src="res/dalva.js"></script>
	</body>
</html>

