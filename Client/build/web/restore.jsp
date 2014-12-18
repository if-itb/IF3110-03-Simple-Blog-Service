<%-- 
    Document   : restore
    Created on : Nov 28, 2014, 5:48:39 PM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="undeclared.service.Service" %>
<jsp:useBean id="sql" class="com.gilang.sql.DBAdapter" scope="session"/>
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
			<%	if(user.getUsername() == null){
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "home.jsp");
				}else{
			%>
            <%	//sql.restorePost(request.getParameter("post_id"));
				Service.restorePost(Integer.valueOf(request.getParameter("post_id")));
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "deleted.jsp");}
			%>
        </body>
    </html>
</f:view>
