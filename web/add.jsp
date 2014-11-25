<%-- 
    Document   : add
    Created on : Nov 26, 2014, 12:38:26 AM
    Author     : daniar heri
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.gilang.beans.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sql" scope="session" class="com.gilang.sql.DBAdapter" />
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <% Post post = sql.getPost(Integer.valueOf(request.getParameter("post_id"))); %>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        </head>
        <body>
            <%	
            
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                String dbtime;
                String dbUrl = "jdbc:mysql://localhost:3306/tubes_wbd";
                String dbClass = "com.mysql.jdbc.Driver";
                String query = "insert into comment ( user_id, post_id, "
                        + "content, date) VALUES ('"+request.getParameter("Nama")
                        +"',"+post.getPost_id()+",'"+request.getParameter("Komentar")
                        +"','"+timeStamp+"') ";

                try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection (dbUrl,"root","");
                   PreparedStatement stmt = con.prepareStatement(query);
                   stmt.executeUpdate();
                   System.out.println("DB write");
                   con.close();
               }catch(ClassNotFoundException e) {

               }catch(SQLException e) {
               }
            
            
            /*String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                sql.addKomentar( post.getPost_id(),request.getParameter("Nama"), request.getParameter("content"),
                    date);
		*/		response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "post.jsp?post_id="+post.getPost_id());
			%>
                        
                       
        </body>
    </html>
</f:view>
