<%-- 
    Document   : Addpost2.jsp
    Created on : 18-Dec-2014, 15:16:21
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.github.fawwaz.heroku.service.*" %>
<%
    Api api = new ApiImplService().getApiImplPort();
    String judul = request.getParameter("Judul");
    String tanggal = request.getParameter("Tanggal");
    String konten = request.getParameter("Konten");
    
    if(api.addPost(judul, konten, tanggal, "geraldi")){
        out.print("BErhasil hore...");
    }else{
        out.print("YAH ... CUPS");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
