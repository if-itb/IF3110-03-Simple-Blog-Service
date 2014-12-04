<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter;" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<% session.setAttribute("firsttimer", "yes");
   response.sendRedirect("mainpage.jsp");
%>