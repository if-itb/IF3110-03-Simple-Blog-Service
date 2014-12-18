<%-- 
    Document   : LoginCheck
    Created on : Nov 24, 2014, 2:10:26 PM
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
        <title>Login Check</title> 
    </head> 
    <body> 
        <% 
            
            String username=request.getParameter("username"); 
            String password=request.getParameter("password");
            
            
            List<User> LU = SimpleBlogServiceHandler.listUser(); // masih masalah di sini gar
            if (LU.isEmpty()){
                 out.println("gar, masih belum bisa nampilin user :(");
                 response.sendRedirect("index.jsp");
            }
            boolean found = false;
            int i;
            for (i = 0; i < LU.size() && !found; i++){
                User vanya = LU.get(i);
                String namauser = vanya.getUsername();
                String passworduser = vanya.getPassword();
                
                if (username.compareTo(namauser) == 0 && password.compareTo(passworduser) == 0){
                    found = true;
                }
            }
            
            if (found){
                User vanya = LU.get(i-1);
                int roleuser = vanya.getRole();
                String iduser = vanya.getId();
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                session.setAttribute("role",roleuser);
                session.setAttribute("userid",iduser);
                response.sendRedirect("cookies.jsp");
            }
            
                    
                
        %> 
    </body> 
</html>

