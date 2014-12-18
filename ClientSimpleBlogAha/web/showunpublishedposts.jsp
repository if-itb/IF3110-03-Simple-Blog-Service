<%-- 
    Document   : showunpublishedposts
    Created on : Nov 24, 2014, 2:10:26 PM
    Author     : tegar
--%>




<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
<%@page import="org.wbd.heroku.service.Post"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.Connection"%>
<%@ page language="java" import="java.sql.PreparedStatement"%>
<%@ page language="java" import="java.sql.ResultSet"%>
<%@ page language="java" import="java.sql.SQLException"%>
<%@ page language="java" import="java.sql.DriverManager"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.lang.String"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">

<!-- Twitter Card -->

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

<title>Simple Blog</title>


</head>

<body class="default">


<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="home.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="logout.jsp"> Logout</a></li>
    </ul>
</nav>

<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
            <!--Showing post from database-->
                <%
                    List<Post> LP = SimpleBlogServiceHandler.listPost(1);
                    String judul = "";
                    String tanggal = "";
                    String konten = "";
                    String id = "";
                    for (int i = 0; i < LP.size(); i++){
                        Post haha = LP.get(i);
                        judul = haha.getJudul();
                        tanggal = haha.getTanggal();
                        konten = haha.getKonten();
                        id = haha.getId();
                        
                        out.println(" <li class=\"art-list-item\"> <div class=\"art-list-item-title-and-time\"> <h2 class=\"art-list-title\"><a href=\"post.jsp?post_id="                                
                                    + id
                                    + "\">"
                                    + judul 
                                    + "</a></h2>"
                                    + "<div class=\"art-list-time\">"
                                    + tanggal
                                    + "</div></div><p>");


                            if (konten.length() > 30){
                                String[] words = konten.split(" ");
                                StringBuilder sb = new StringBuilder();
                                for (int j = 0; j < Math.min(30, words.length); j++)
                                {
                                    sb.append(words[j] + " ");  
                                }
                                String First30WordPost = sb.toString();
                                out.println(First30WordPost);
                            }
                            else
                                out.println(konten);

                            out.println("<br>");
                            out.println("<br>");
                            out.println(" <p> "
                                + "<a href=\""
                                + "edit_post.jsp?post_id="
                                + id
                                + "\""
                                + ">Edit</a> | <a onclick=\"validatedelete(" + id + ")\" href=\"DeletePostHandling?post_id="+ id +"\">Hapus</a> | <a onclick=\"validatepublish(" + id + ")\" href=\"PublishPostHandling?post_id="+ id +"\">Publish</a> </p> </li>"); 
                    }
                %>
          </ul>
        </nav>
    </div>
</div>

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

<!-- Vaildate Delete -->
<script>
  function validatedelete()
  {
      console.log("validatedelete");
      var x;
      if (confirm("Apakah Anda yakin menghapus post ini?") === true) {
          
      } else {
        x = "Cancel";
      }
  } 
 </script>
 <script>
  function validatepublish()
  {
      console.log("validatepublish");
      var x;
      if (confirm("Apakah Anda yakin mempublish post ini?") === true) {
          
      } else {
        x = "Cancel";
      }
  } 
 </script>
</body>
</html>