<%-- 
    Document   : home
    Created on : Nov 25, 2014, 9:23:28 AM
    Author     : Gilang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
			<%	if(user.getUsername() == null){ %>
            <form action="login.jsp">
				<input type="text" name="user_id">
				<input type="password" name="password">
				<input type="submit">
			</form>
			<form action="login.jsp">
				<input type="hidden" name="user_id" value="guest">
				<input type="hidden" name="password" value="">
				<input type="submit" value="login as guest">
			</form>
			<%	}
				else{
					response.setStatus(response.SC_MOVED_TEMPORARILY);
					response.setHeader("Location", "index.jsp");
				}
			%>
        </body>
    </html>
</f:view>
