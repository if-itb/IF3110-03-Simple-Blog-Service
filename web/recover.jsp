<%-- 
    Document   : dashboard
    Created on : 22-Nov-2014, 20:58:12
    Author     : Asus
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>

 <sql:update dataSource="${snapshot}" var="count">
    UPDATE `tucildb_13511097`.`listpost` SET `published`='t' WHERE `id`=<%= request.getParameter("id_post")%>;
 </sql:update>
    
    
<% response.sendRedirect("mainpage.jsp"); %>

