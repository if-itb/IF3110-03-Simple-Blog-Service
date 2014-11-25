<%-- 
    Document   : unpublised
    Created on : Nov 24, 2014, 12:19:58 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter;" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Simple Blog | Unpublished Post</title>


</head>

<body class="default">
    
    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>
    
<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="index.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
         <li><a href="index.jsp">Home</a></li>
    </ul>
</nav>
    
<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM `tucilDB_13511097`.`listpost` WHERE `published`='f' ORDER BY `date` DESC;
</sql:query> 
<% TimeConverter tc = new TimeConverter(); %>

<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
              <c:forEach var="row" items="${result.rows}">
                  <c:set var="myTest" value="${row.date}"/>
                    <%! String d; %>
                    <%  d =  pageContext.getAttribute("myTest").toString(); %>
                <li class="art-list-item">
                <div class="art-list-item-title-and-time">
                    <h2 class="art-list-title"><a href="post.jsp?id_post=<c:out value='${row.id}'/>"><c:out value="${row.title}"/></a></h2>
                    <div class="art-list-time"><%= tc.ConvertDate(d) %></div>

                </div>
               
                <p>
                    <a href="new_post.jsp?mode=1&id_post=<c:out value='${row.id}'/>">Edit</a> | <a href="javascript:ConfirmDelete(<c:out value='${row.id}'/>)">Hapus</a> | <a href="updatePublish.jsp?id_post=<c:out value='${row.id}'/>">Publish</a>
                  
                </p>
                </li>
               
             </c:forEach>
             </ul>
        </nav>
    </div>
</div>
    </body>
    
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

<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/fittext.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/respond.min.js"></script>
</html>
