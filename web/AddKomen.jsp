<%-- 
    Document   : AddKomen
    Created on : Nov 19, 2014, 5:12:28 PM
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

<%! 
    Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dnow = format.format(now);
                 String sql2;
%>
<%
    Statement statement = null;
                int new_id =0;
                String id_post = request.getParameter("id_post");
                String nama = request.getParameter("Nama");
                String email = request.getParameter("Email");
                String komentar = request.getParameter("Komentar");
                
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                String DB_URL = "jdbc:mysql://localhost/tucildb_13511097";
                String USER = "root";
                String PASS = "";
                String output = "";
                Connection conn = null;
                ResultSet rs;
                
                 conn = DriverManager.getConnection(DB_URL,USER, PASS);
                statement = conn.createStatement();
                
                while ( true){   
                try {
                String sql = "SELECT * FROM `tucildb_13511097`.`post-komen` WHERE `myID`="+new_id;
                rs = statement.executeQuery(sql);
                
                if (!rs.isBeforeFirst()){ //kosong
                    break;
		}
		else{
                    new_id++;
		}
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            } // end of while
                
               
            try {
                 sql2 = "INSERT INTO `tucildb_13511097`.`post-komen`(`myID`, `id_post`, `nama`, `email`, `tanggal`, `isi`)VALUES ( "+new_id+","+id_post+",'"+nama+"','"+email+"','"+dnow+"','"+komentar+"')";
                statement.executeUpdate(sql2);
                
                
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
%>


