<%-- 
    Document   : add
    Created on : Nov 26, 2014, 12:38:26 AM
    Author     : daniar heri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="undeclared.mavenproject1.Post" %>
<%@page import="undeclared.mavenproject1.User" %>
<%@page import="undeclared.service.Service" %>
<jsp:useBean id="sql" scope="session" class="com.gilang.sql.DBAdapter" />
<jsp:useBean id="user" scope="session" class="com.gilang.beans.User" />

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        </head>
        <body>
			<%	if(user.getUsername() == null){
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "home.jsp");
				}else{
			%>
            <%	if(user.getUsername().equals("guest"))
					//sql.addComment(Integer.valueOf(request.getParameter("post_id")), request.getParameter("user_id"),
					//			request.getParameter("content"), request.getParameter("email"));
					Service.addComment(Integer.valueOf(request.getParameter("post_id")), request.getParameter("user_id"),
								request.getParameter("email"), request.getParameter("content"));
				else{
					//sql.addComment(Integer.valueOf(request.getParameter("post_id")), request.getParameter("user_id"),
					//			request.getParameter("content"), sql.getUser(user.getUsername()).getEmail());
					User userData = null;
					for(User u : Service.listUser()){
						if(u.getName().equals(user.getUsername()))
							userData = u;
					}
					Service.addComment(Integer.valueOf(request.getParameter("post_id")), request.getParameter("user_id"),
								userData.getEmail(), request.getParameter("content"));
				}
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "post.jsp?post_id="+request.getParameter("post_id"));
				}
			%>
                        
                       
        </body>
    </html>
</f:view>
