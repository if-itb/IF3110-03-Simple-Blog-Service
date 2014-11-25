<%-- 
    Document   : dashboard
    Created on : 22-Nov-2014, 20:58:12
    Author     : Asus
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("username")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alvailable Menu</h1>
        <ul>
            <li><a href="manage_user.jsp">Manage User</a></li>
            <li><a href="manage_post.jsp">List Post (unpublished)</a></li>
            <li><a href="view_all_post.jsp">List Post (All)</a></li>
            <li><a href="view_all_post.jsp">Create Post (All)</a></li>
            <p>
                Todolist
            </p>
            <ol>
                <li>Validasi dulu apkaah current user boleh memanage user ? mempublish post ? atau melihat list post ? atau bahkan hanya bisa membuat post</li>
                <li>Dihias !</li>
            </ol>
            
        </ul>
    </body>
</html>
