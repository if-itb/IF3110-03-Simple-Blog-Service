<%-- 
    Document   : ManagementUser
    Created on : Nov 24, 2014, 5:24:10 PM
    Author     : Teofebano
--%>

<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
<%@page import="org.wbd.heroku.service.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.Connection"%>
<%@ page language="java" import="java.sql.PreparedStatement"%>
<%@ page language="java" import="java.sql.ResultSet"%>
<%@ page language="java" import="java.sql.SQLException"%>
<%@ page language="java" import="java.sql.DriverManager"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.lang.String"%>

<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Management User</title> 
    </head> 
    <body> 
       
            <table border="2">
                    <tr>
                        <td>Username</td>
                        <td>Password</td>
                        <td>Name</td>
                        <td>Role</td>
                        <td>Email</td>
                        <td>Update</td>
                        <td>Delete</td>
                    </tr>
        <% 
            List<User> LU = new ArrayList();
            LU = SimpleBlogServiceHandler.listUser();
            for (int i = 0; i < LU.size(); i++){
                User Vanya = LU.get(i);
                String nama = Vanya.getNama();
                String usernama = Vanya.getUsername();
                String password = Vanya.getPassword();
                int role = Vanya.getRole();
                String email = Vanya.getEmail();
                String user_id = Vanya.getId();
         %>
                    
                    <tr>
                        <td><% out.println(usernama); %></td>
                        <td><% out.println(password); %></td>
                        <td><% out.println(nama); %></td>
                        <td><% out.println(role); %></td>
                        <td><% out.println(email); %></td>
                        
                        <td> <form action = "UpdateForm.jsp?user_id=<%out.println(user_id);%>" method ="post"> 
                            <input type="submit" name="submit" value="Update" class="submit-button">
                            </form>
                        </td>
                        <td> <form action = "delete.jsp?user_id=<%out.println(user_id);%>" method ="post"> 
                             <input type="submit" name="submit" value="Delete" class="submit-button">
                             </form>
                        </td>
                    </tr>
                    
                    <%
                   
                    }

                    %>
            </table>
            
                    <%
               
        %>    
        <br>
        <form action = "AddForm.jsp" method ="post"> 
                <input type="submit" name="submit" value="Add User" class="submit-button">
        </form>
        <br>
        <br>
        <a href="home.jsp">Back to main page</a>
        <script>
            function delete(){
                <%
                    
                %>
            }
        </script>
    </body> 
</html>