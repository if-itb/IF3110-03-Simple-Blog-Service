<%-- 
    Document   : deleteKomen
    Created on : Nov 26, 2014, 11:35:53 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, java.text.SimpleDateFormat, java.sql.Connection,  java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException, java.sql.Statement "%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>

<%
    String id = request.getParameter("id");
    Statement statement = null;
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                String DB_URL = "jdbc:mysql://localhost/tucildb_13511097";
                String USER = "root";
                String PASS = "";
                String output = "";
                Connection conn = null;
                ResultSet rs;
                
                 conn = DriverManager.getConnection(DB_URL,USER, PASS);
                statement = conn.createStatement();
            try {
                  String sql = "DELETE FROM `tucildb_13511097`.`post-komen` WHERE `myID`= "+id;
                    statement.executeUpdate(sql);
                
                
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           response.sendRedirect("post.jsp?id_post= "+request.getParameter("id_post"));
%>

