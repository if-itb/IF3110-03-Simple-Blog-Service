<%-- 
    Document   : process_manage_user
    Created on : 24-Nov-2014, 06:12:23
    Author     : Asus
--%>

<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.github.fawwaz.heroku.service.*" %>

<%! 
    Api api = new ApiImplService().getApiImplPort();
%>
<%
    String action = StringUtils.isNullOrEmpty(request.getParameter("action")) ? "" : request.getParameter("action");
    
    if(action.equals("create")){
        // SQL syntax creating
        // Redirect to manage user pages with message successfull
        // or display error when happens
        int new_id=0;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost/tucildb_13511097";
//        Connection con = DriverManager.getConnection(url,"root", "");
//        Statement st = con.createStatement();
//        
//        while ( true){   
//                try {
//                String sql = "SELECT * FROM `tucildb_13511097`.`user` WHERE `id`="+new_id;
//                ResultSet rs = st.executeQuery(sql);
//                
//                if (!rs.isBeforeFirst()){ //kosong
//                    break;
//		}
//		else{
//                    new_id++;
//		}
//                } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//            } // end of while
        
//        boolean result = st.execute("insert into user (`id`,`username`,`password`,`email`,`role`) value("+new_id+",'" + username + "','" + password + "','" + email + "','" + role + "')");
        api.createUser(role, email, password, username);
        
    }else if(action.equals("update")){
        String id = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        
        boolean result = st.execute("update user set `username`='" + username + "',`password`='" + password + "',`email`='" + email +"',`role`='" + role + "' where `id`='" + id + "'");
        

    }else if(action.equals("delete")){
        String id = request.getParameter("userid");

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        out.print("ngakak");
        boolean result = st.execute("delete from user where `id`='" + id + "'");
        
    }else{
        // redirect ke manage user
        out.println("salah request harus ada paramter action TODO: Redirect ke halaman ");
    }

    response.sendRedirect("manage_user.jsp");
%>

