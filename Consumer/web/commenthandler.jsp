<%-- 
    Document   : commenthandler
    Created on : Dec 2, 2014, 4:41:02 PM
    Author     : rocky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, java.sql.*"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*"%>
<%@ page import="javax.sql.*"%>

<%!
	String title;
	String content;
	String description;
	String date;
%>

<%
	
	ResultSet rs = null;
	ResultSet rs2 = null;
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleblog","simpleblog","simpleblog");
	
	if (request.getParameter("name") != null && request.getParameter("email") != null && request.getParameter("id") != null && request.getParameter("content") != null ) {
		Statement st= con.createStatement();
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String curdate = sdf.format(dt);
		st.executeUpdate("INSERT INTO `simpleblog`.`comments` (`ID`, `PID`, `name`, `email`, `date`, `content`) VALUES (NULL, '"+ request.getParameter("id") +"','"+ request.getParameter("name") +"','"+request.getParameter("email")+"','"+curdate+"','"+request.getParameter("content")+"');");
		
		Statement st2= con.createStatement();
		rs2=st2.executeQuery("SELECT * FROM comments WHERE PID='"+request.getParameter("id")+"';"); 
	} else if (request.getParameter("id") != null) {
		Statement st= con.createStatement();
		rs2=st.executeQuery("SELECT * FROM comments WHERE PID='"+request.getParameter("id")+"';"); 
	}
	
	
%>

<div class='portocontainer' style="clear:both;">
	
	<%

		while(rs2.next()) { %>
	
	<div class="item">
		<div class='detail'>
			<p>
				<% out.print(rs2.getString("email") + "<br />" + rs2.getString("date")); %>
			</p>
		</div>
		<div class='desc'>
			<div class='title'><h1 class='left'><% out.print("Comment by " + rs2.getString("name")); %></h1></div>
			<p><%= rs2.getString("content") %></p>
		</div>
	</div>
		
	<% } %>
	
</div>
