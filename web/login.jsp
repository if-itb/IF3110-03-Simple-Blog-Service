<%-- 
    Document   : login

    Created on : 21-Nov-2014, 14:21:57
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
       /*
    Cookie[] cookies = request.getCookies();
    boolean c1=false,c2=false,c3=false,c4=false;
    if(cookies!=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("id_user")){
                session.setAttribute( "id_user", cookie.getValue());
                c1 = true;
            }
            
            if(cookie.getName().equals("username")){
                session.setAttribute( "username", cookie.getValue());
                c2 = true;
            }
            
            if(cookie.getName().equals("role")){
                session.setAttribute( "role", cookie.getValue());
                c3 = true;
            }
            
            if(cookie.getName().equals("email")){
                session.setAttribute( "email", cookie.getValue());
                session.setAttribute("firsttimer", "no");
                c4 = true;
            }
            
            if(c1&&c2&&c3&&c4){
                response.sendRedirect("mainpage.jspx");
            }
        }
    }*/
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">

<!-- Twitter Card -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="omfgitsasalmon">
<meta name="twitter:title" content="Simple Blog">
<meta name="twitter:description" content="Deskripsi Blog">
<meta name="twitter:creator" content="Simple Blog">
<meta name="twitter:image:src" content="{{! TODO: ADD GRAVATAR URL HERE }}">

<meta property="og:type" content="article">
<meta property="og:title" content="Simple Blog">
<meta property="og:description" content="Deskripsi Blog">
<meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}">
<meta property="og:site_name" content="Simple Blog">

<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <title>Login Page</title>
    </head>
    <body>

<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="mainpage.jsp">Home</a></li>
    </ul>
</nav>
        
<article class="art simple post">
    
    
    <h2 class="art-title" style="margin-bottom:40px">-</h2>
         <div class="art-body">
        <div class="art-body-inner">
      <h2>Login Page!</h2>
        <form action="process_login.jsp" method="POST">    
         <div id="contact-area">
        <p>Username : <input type="text" name="username"> </p>
        <p>Password : <input type="password" name="password"> </p>
        <p><input type="submit" value="Login" > </p>
         </div>
            
        </div>
         </div>
    
</article>
    </body>
</html>
