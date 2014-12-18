<%-- 
    Document   : edit_post
    Created on : Dec 1, 2014, 11:31:44 PM
    Author     : Denny AH
--%>

<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blog.*,blogutil.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">
<meta property="og:type" content="article">
<meta property="og:title" content="Simple Blog">
<meta property="og:description" content="Deskripsi Blog">
<meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}">
<meta property="og:site_name" content="Simple Blog">

<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Edit Post</title>


    </head>

<body>
<div class="wrapper">


<nav class="nav">
    <a style="border:none;" id="logo" href="index.xhtml"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
    </ul>
</nav>
    
<article class="art simple post">
    
    
    <h2 class="art-title" style="margin-bottom:40px">-</h2>

    <div class="art-body">
        <div class="art-body-inner">
            <h2>Edit Post</h2>
            
            
            <div id="contact-area">
                <%
                        Cookie[] listCookie = request.getCookies();
                        String role = "";
                        for (Cookie cook : listCookie) {
                            if (cook.getName().equals("role")) {
                                if (cook.getValue().equals("admin") || cook.getValue().equals("editor") ) {
                                    role = "admin";
                                } else {
                                    out.println("You are not login");
                                }
                            }
                        }

                        if (role.equals("")) {
                            out.println("You are not login");
                        } else {
                            
                        String postString = request.getParameter("post");
                        ArrayList<Post> list = (ArrayList)SimpleBlogService.listPost();
                        Post post = null;
                        for(Post tmp : list){
                            if(tmp.getId().equals(postString)){
                                post = tmp;
                            }
                        }
                        
                    %>
                <form method="post" action="edit_post_back.jsp">
                    <input type="hidden" name="post" id="Judul" value="<% out.print(post.getId());%>">
                    <label for="Judul">Judul:</label>
                    <input type="text" name="Judul" id="Judul" value="<% out.print(post.getJudul());%>">

                    <label for="Tanggal">Tanggal:</label>
                    <input type="text" name="Tanggal" id="Tanggal" value="<% out.print(post.getTanggal());%>">
                    
                    <label for="Konten">Konten:</label><br>
                    <textarea name="Konten" rows="20" cols="20" id="Konten"><% out.print(post.getKonten());%></textarea>

                    <input type="submit" name="submit" value="Simpan" class="submit-button">
                </form>
                    
                    <%
                        }    
                    %>
            </div>
        </div>
    </div>

</article>

<footer class="footer">
    <div class="back-to-top"><a href="">Back to top</a></div>
    <!-- <div class="footer-nav"><p></p></div> -->
    <div class="psi">&Psi;</div>
    <aside class="offsite-links">
        Asisten IF3110 /
        <a class="rss-link" href="#rss">RSS</a> /
        <br>
        <a class="twitter-link" href="http://twitter.com/YoGiiSinaga">Yogi</a> /
        <a class="twitter-link" href="http://twitter.com/sonnylazuardi">Sonny</a> /
        <a class="twitter-link" href="http://twitter.com/fathanpranaya">Fathan</a> /
        <br>
        <a class="twitter-link" href="#">Renusa</a> /
        <a class="twitter-link" href="#">Kelvin</a> /
        <a class="twitter-link" href="#">Yanuar</a> /
        
    </aside>
</footer>

</div>

<script type="text/javascript" src="assets/js/fittext.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/respond.min.js"></script>
<script type="text/javascript">
  var ga_ua = '{{! TODO: ADD GOOGLE ANALYTICS UA HERE }}';

  (function(g,h,o,s,t,z){g.GoogleAnalyticsObject=s;g[s]||(g[s]=
      function(){(g[s].q=g[s].q||[]).push(arguments)});g[s].s=+new Date;
      t=h.createElement(o);z=h.getElementsByTagName(o)[0];
      t.src='//www.google-analytics.com/analytics.js';
      z.parentNode.insertBefore(t,z)}(window,document,'script','ga'));
      ga('create',ga_ua);ga('send','pageview');
</script>

</body>
</html>