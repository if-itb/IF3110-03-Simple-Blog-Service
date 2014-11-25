<%-- 
    Document   : process_manage_user
    Created on : 24-Nov-2014, 06:12:23
    Author     : Asus
--%>

<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%
    String action = StringUtils.isNullOrEmpty(request.getParameter("action")) ? "" : request.getParameter("action");
    
    if(action.equals("create")){
        // SQL syntax creating
        // Redirect to manage user pages with message successfull
        // or display error when happens
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        
        boolean result = st.execute("insert into user (`username`,`password`,`role`) value('" + username + "','" + password + "','" + role + "')");
        
        out.println("Dalam skenario normal,saat ini seharusnya database sudah di INSERT, silahkan cek database");
        out.println("Hal yang belum dilakukan adalah (Todolist):");
        out.println("- Lakkan handling kalau eksekusi sqlnya menghasilkan error (misal karena duplicate data)");
        out.println("- Redirect back ke halaman manage user dengan menampilkan pesan bahwa operasi berhasil dilakukan ");
        out.println("Tambahkan baris kode ini : response.sendRedirect(\"manage_user.jsp?message=user created\");");
    }else if(action.equals("update")){
        String id = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        
        boolean result = st.execute("update user set `username`='" + username + "',`password`='" + password + "',`role`='" + role + "' where `id`='" + id + "'");
        out.println("Dalam skenario normal,saat ini seharusnya database sudah di UPDATE, silahkan cek database");
        out.println("Hal yang belum dilakukan adalah (Todolist):");
        out.println("- Lakkan handling kalau eksekusi sqlnya menghasilkan error (misal karena duplicate data)");
        out.println("- Redirect back ke halaman manage user dengan menampilkan pesan bahwa operasi berhasil dilakukan");

    }else if(action.equals("delete")){
        String id = request.getParameter("userid");

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        out.print("ngakak");
        boolean result = st.execute("delete from user where `id`='" + id + "'");
        out.println("Dalam skenario normal,saat ini seharusnya database sudah diDELETE, silahkan cek database");
        out.println("Hal yang belum dilakukan adalah (Todolist):");
        out.println("- Lakkan handling kalau eksekusi sqlnya menghasilkan error (misal karena duplicate data)");
        out.println("- Redirect back ke halaman manage user dengan menampilkan pesan bahwa operasi berhasil dilakukan");
    }else{
        // redirect ke manage user
        out.println("salah request harus ada paramter action TODO: Redirect ke halaman ");
    }

%>

