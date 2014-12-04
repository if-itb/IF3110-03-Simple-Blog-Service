<%-- 
    Document   : manage_user
    Created on : 22-Nov-2014, 22:08:23
    Author     : Asus
--%>

<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
    String action = StringUtils.isNullOrEmpty(request.getParameter("action")) ? "" : request.getParameter("action");
        
    if(action.equals("create")){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Process manage user</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="process_manage_user.jsp" method="POST">
            <p>Username :<input type="text" name="username"/></p>
            <p>Password : <input type="text" name="password"/></p>
            <p>Role: <select name="role">
                <option value="owner" >owner</option>
                <option value="admin">admin</option>
                <option value="editor">editor</option>
                </select></p>
                <p><input type="submit" value="Buat"></p>
                <input type="hidden" name="action" value="create">
        </form>
    </body>
</html>
<%
    }else if(action.equals("update")){
        String userid = request.getParameter("userid");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("select * from user where id='" + userid + "'");
        
        if(rs.next()){
            
            
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Process manage user</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="process_manage_user.jsp">
            <p>Username :<input type="text" name="username" value="<%out.print(rs.getString("username"));%>"/></p>
            <p>Password : <input type="text" name="password" value="<%out.print(rs.getString("password"));%>"/></p>
            
            <p>Role: 
                <select name="role">    
                    <option value="owner" <% out.print((rs.getString("role").equals("owner") ? "Selected" : ""));%>>owner</option>
                    <option value="admin" <% out.print((rs.getString("role").equals("admin") ? "Selected" : ""));%>>admin</option>
                    <option value="editor" <% out.print((rs.getString("role").equals("editor") ? "Selected" : ""));%>>editor</option>
                </select></p>
            <input type="hidden" name="userid" value="<%out.print(rs.getString("id"));%>">
            <input type="hidden" name="action" value="update">
            <p><input type="submit" value="Update !"></p>
            
        </form>
    </body>
</html>
<%    
        }else{
            out.print("Parameter id tidak Id Tidak Ditemukan....");
        }
    }else{
        %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User Pages</title>
    </head>
    <body>
        
        <sql:setDataSource 
            var="snapshot" 
            driver="com.mysql.jdbc.Driver"             
            url="jdbc:mysql://localhost/tucildb_13511097"
            user="root"  
            password=""/>
        
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from user;
        </sql:query>
            
        <h1>Manage User Pages!</h1>
        <% out.print(StringUtils.isEmptyOrWhitespaceOnly(request.getParameter("message")) ? "<h4>"+request.getParameter("message")+"</h4>" : "" ); %>
        <h4><a href="manage_user.jsp?action=create">Create New User</a></h4>
        <table border="1px">
            <tr>
                <td>User id</td>
                <td>Username</td>
                <td>Password</td>
                <td>Role</td>
                <td colspan="2">Action</td>
            </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.id}"/></td>
                <td><c:out value="${row.username}"/></td>
                <td><c:out value="${row.password}"/></td>
                <td><c:out value="${row.role}"/></td>
                <td><a href="manage_user.jsp?action=update&userid=<c:out value="${row.id}"/>">Edit</a></td>
                <td><a href="process_manage_user.jsp?action=delete&userid=<c:out value="${row.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </table>    
    </body>
</html>
<%
        
    }
    
%>



