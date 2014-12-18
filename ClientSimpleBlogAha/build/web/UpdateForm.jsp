<%-- 
    Document   : UpdateForm
    Created on : Nov 25, 2014, 4:55:12 PM
    Author     : Teofebano
--%>

<%@page import="org.wbd.heroku.service.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         Connection con = null;
         String user_id= request.getParameter("user_id");
         
         List<User> LU = new ArrayList();
         LU = SimpleBlogServiceHandler.listUser();
         
         String username = "";
         String password = "";
         String name = "";
         int role = 0;
         String email = "";
         for (int i = 0; i<LU.size(); i++){
             User Vanya = LU.get(i);
             if (Vanya.getId().compareTo(user_id) == 0){
                 username = Vanya.getUsername();
                 password = Vanya.getPassword();
                 name = Vanya.getNama();
                 role = Vanya.getRole();
                 email = Vanya.getEmail();
             }
         }
        %>
        
        <h2>Update Details</h2> 
                    <form action="update.jsp" method="post">
                    <br/>Username   :<input type="text" name="username" value="<%=username%>"> 
                    <br/>Password   :<input type="text" name="password" value="<%=password%>">
                    <br/>Name   :<input type="text" name="name" value="<%=name%>">
                    <br/>Role   :<input type="number" name="role" value=<%=role%>>
                    <br/>Email   :<input type="text" name="email" value="<%=email%>">
                    <br/><br><input type="submit" value="Submit"> 
                    <input type="hidden" name="user_id" value="<%=user_id%>"> 
                    </form>
        
        <%       
                
        %>
                    
    </body>
</html>
