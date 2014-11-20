<%-- 
    Document   : GetKomen
    Created on : Nov 19, 2014, 5:12:50 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
                String sql = "SELECT * FROM `tucildb_13511097`.`post-komen` WHERE `id_post`="+id+" ORDER BY `tanggal` DESC";
                rs = statement.executeQuery(sql);
                 
                    while(rs.next()){
                        String name = rs.getString("nama");
                        String tanggal = rs.getString("tanggal");
                        String isi = rs.getString("isi");
                        System.out.println("<li class='art-list-item'>");
                        System.out.println("<div class='art-list-item-title-and-time'>");
                        System.out.println("<h2 class='art-list-title'><a href='post.php?id="+id+"'>"+name+"</a></h2>");
                        System.out.println("<div class='art-list-time'>"+tanggal+" </div>");
                        System.out.println("</div>");
                        System.out.println("<p>"+isi+"</p>");
                        System.out.println("</li>");
                        output += "<li class='art-list-item'>"
                                + "<div class='art-list-item-title-and-time'>"
                                + "<h2 class='art-list-title'><a href='post.php?id="+id+"'>"+name+"</a></h2>"
                                + "<div class='art-list-time'>"+tanggal+" </div>"
                                + "</div>"
                                + "<p>"+isi+"</p>"
                                + "</li>";
                    }
		
		
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 %>