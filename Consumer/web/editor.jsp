<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import ="javax.sql.*" %>

<%!
	
	String title = "Edit a Post";
	String description = "Edit a Post";
	int selectedID = 2;
	String current_url = "blog.localhost/editor.jsp";
	
	//$status = "new";
	String initialTitle = "";
	String initialContent = "";
	int initialID = -1;
	
%>

<%
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleblog","simpleblog","simpleblog");
	
	if (request.getParameter("title") != null && request.getParameter("date") != null && request.getParameter("content") != null && request.getParameter("id") != null) {
		out.println("<script>alert('id" + request.getParameter("id") + " ');</script>");
		Statement st2= con.createStatement();
		initialTitle = request.getParameter("title");
		initialContent = request.getParameter("content");
		if (request.getParameter("id").equalsIgnoreCase("-1")) {
			st2.executeUpdate("INSERT INTO `simpleblog`.`posts` (`ID`, `title`, `date`, `content`, `published`, `author`) VALUES (NULL, '"+request.getParameter("title")+"', '"+request.getParameter("date")+"', '"+request.getParameter("content")+"', 0, '" + session.getValue("userid").toString() + "');"); 
		} else {
			st2.executeUpdate("UPDATE `simpleblog`.`posts` SET `title` = '"+request.getParameter("title")+"', `date` = '"+request.getParameter("date")+"', `content` = '"+request.getParameter("content")+"' WHERE `posts`.`ID` =  '"+request.getParameter("id")+"';"); 
		}
	} else if (request.getParameter("id") != null) {
		out.println("<script>alert('a');</script>");
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM posts WHERE ID='"+request.getParameter("id")+"';");
		if (rs.next()) {
			initialTitle = rs.getString("title");
			initialContent = rs.getString("content");
			description = title;
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
			<a class='menu' <% if (selectedID == 1) { out.print("id='selectedMenu'"); } %>href='index.jsp'><div class='menu'>Articles</div><div class='desc'>List em all!</div></a>
			<a class='menu' <% if (selectedID == 2) { out.print("id='selectedMenu'"); } %>href='editor.jsp'><div class='menu'>Editor</div><div class='desc'>Make a new post!</div></a>
			<div class='menuCenter'><div class='ridecon'></div></div>
			<a class='menu' <% if (selectedID == 3) { out.print("id='selectedMenu'"); } %>href='view.jsp'><div class='menu'>View</div><div class='desc'>View a post</div></a>
			<% try { if (session.getValue("userid").toString() != "none" ) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>User</div><div class='desc'>Login</div></a>
				<% } } catch(Exception x) { %>
					<a class='menu' <% if (selectedID == 4) {out.println("id='selectedMenu'"); } %> href='login.jsp'><div class='menu'>Login</div><div class='desc'>Login</div></a>
				<% } %>
		</nav>
		<main>
			
<script>
	//validator
	function checkdate(){
		var input = document.getElementById("DateIn");
		var validformat=/^\d{4}-\d{1,2}-\d{1,2}$/; //Basic check for format validity
		var returnval=false;
		if (!validformat.test(input.value)) {
			alert("Invalid Date Format. Please correct and submit again.");
		} else { //Detailed check for valid date ranges
			var yearfield=input.value.split("-")[1];
			var monthfield=input.value.split("-")[2];
			var dayfield=input.value.split("-")[3];
			var enteredDate = new Date(yearfield, monthfield-1, dayfield);
			var today = new Date();
			if (enteredDate.setHours(0,0,0,0) < today.setHours(0,0,0,0)) {
				alert("Invalid date: the entered date is earlier than today.");
			} else {
				returnval=true;
			}
		}
		return returnval;
	}
</script>
			
<%!
String contentheight = "460px";
%>

<div style='height:<% out.print(contentheight); %>' class='content1'>
<div class='title'><h1 class='left'>Editor</h1></div>
Edit stuff here!
</div>
<div style='height:<% out.print(contentheight); %>' class='content3' >
	<div class='title'></div>
	<% try { if (session.getValue("usertype").toString() != "4") { %>
	<form id="mainForm" action="editor.jsp" method="post" onsubmit="return checkdate()">
		<div class="entry" style="width:320px;"><div class="formtext" id="Name">Title</div><input id="TitleIn" name="title" type="text" required value="<% out.print(initialTitle); %>"/></div>
		<div class="entry" style="width:320px;"><div class="formtext" id="Date">Date</div><input id="DateIn" name="date" required type="text"/></div>
		<div class="entry" style="width:100%;"><div class="formtext" id="Message">Message</div><textarea class="msg" name="content" required><% out.print(initialContent); %></textarea></div>
		<input id="ID" name="id" type="hidden" value="<% out.print(initialID); %>"/>
		<div class="button"><input id="submitButton" class="button" name="submit" value="Submit" type="submit"/></div>
	</form>
	<% } } catch(Exception x2) { out.println("you did not have sufficient privileges.");};%>
</div>
			
<script>
	//Autofill date
	var date = new Date();
	document.getElementById("DateIn").setAttribute("value", date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate());

</script>
			
			<footer>
				Site Design and Code &copy; Darieza Alliance 2014. All rights reserved. This site are simplified and is using dalva24's template from <a href='http://dalva24.com'>Dalva24.com</a>
			</footer>
		</main>
	</div>
	<div id="pagefader"></div>
	<script src="res/dalva.js"></script>
</body>
</html>