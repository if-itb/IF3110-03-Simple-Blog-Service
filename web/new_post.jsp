<%@page import="com.mysql.jdbc.StringUtils"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.github.fawwaz.heroku.service.*" %>

<%! 
    Api api = new ApiImplService().getApiImplPort();
    String judul = ""; 
    String tanggal= "";
    String konten = "";
    String idpost = "";
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


<%
    String role =StringUtils.isNullOrEmpty(session.getAttribute("role").toString()) ? "" : session.getAttribute("role").toString();
    out.print("ROLE" + role);
    if(role.equals("editor") || role.equals("") || role.equals("guest")){
        response.sendRedirect("forbidden.jsp");
    }
%>
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Simple Blog | Tambah Post</title>


</head>

<body class="default">
    
    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>
    
<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
         <% if (session.getAttribute("role").toString().equals("editor") || session.getAttribute("role").toString().equals("admin")){%>
        <li><a href="unpublished.jsp">unpublished post    </a></li>
        <%} %>
        <% if (session.getAttribute("role").toString().equals("owner") || session.getAttribute("role").toString().equals("admin")){%>
        <li><a href="new_post.jsp?mode=0">+ Tambah Post</a></li>
        <%} %>   
        <% if (session.getAttribute("role").toString().equals("admin")){%>
        <li><a href="manage_user.jsp">manage user</a></li>
        <%} %> 
        <% if (session.getAttribute("role").toString().equals("guest")){%>
        <li><a href="login.jsp">Login</a></li>
        <%} %> 
    </ul>
</nav>

<article class="art simple post">
    
    
    <h2 class="art-title" style="margin-bottom:40px">-</h2>

    <div class="art-body">
        <div class="art-body-inner">
      
<c:choose>
      <c:when test="${param.mode=='0'}">
          <h2>Tambah Post</h2>
      </c:when>

      <c:otherwise>
          <h2>Edit Post</h2>
          <%
                List<Post> posts = api.getAllPost();
                
                for (Post post : posts) {
                if (post.getIdPost().equals(request.getParameter("id_post"))){
                   tanggal = post.getDate();
                   judul = post.getTitle();
                   konten = post.getContent();
                   idpost = post.getIdPost();
                }
               }
          %>
      </c:otherwise>
</c:choose>
           

            <div id="contact-area">
                <form method="post" action="AddPost.jsp">
                    <label for="Judul">Judul:</label>
                    <input type="text" name="Judul" id="Judul" value="<%= judul %>" onkeyup ="ValidasiAll()" onmousedown ="ValidasiAll()">

                    <label for="Tanggal">Tanggal:</label>
                    <input type="text" name="Tanggal" id="Tanggal" value="<%= tanggal %>"onkeyup ="ValidasiTanggal()" onmousedown ="ValidasiTanggal()" onkeyup ="ValidasiAll()" onmousedown ="ValidasiAll()">
                    <div id="err_pass" onkeyup ="ValidasiAll()" onmousedown ="ValidasiAll()">format=yyyy-mm-dd</div><br>
                    
                    <label for="Konten">Konten:</label><br>
                    <textarea name="Konten" rows="20" cols="20" id="Konten" onkeyup ="ValidasiAll()" onmousedown ="ValidasiAll()"><%= konten %></textarea>
                    <input type="hidden" name="mode" value="${param.mode}">
                    <input type="hidden" name="id_post"  value="${param.id_post}">
                    <input type="submit" id="submit" value="Simpan" class="submit-button" >
                </form>
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

<script type="text/javascript" src="assets/js/jquery.min.js"></script>
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
      
      function ValidasiTanggal(){
		var tgl = document.getElementById("Tanggal").value;
		var today = new Date();
		var cek = new Date(tgl);
		var err_pass = document.getElementById("err_pass");
		
		if(cek>=today){
			err_pass.innerHTML = "OK";
			document.getElementById("submit").disabled = false;
		}else{
			err_pass.innerHTML = "masukkan tanggal minimal hari ini";
			document.getElementById("submit").disabled = true;
		}
		
	}
	
function ValidasiAll(){
	var judul = document.getElementById("Judul").value;
	var konten = document.getElementById("Konten").value;
	var err_pass = document.getElementById("err_pass");
	
	
	if (judul!=null && konten!=null && err_pass.innerHTML == "OK"){
		document.getElementById("submit").disabled = false;
               
	}else{
		document.getElementById("submit").disabled = true;
                
                
	}
    }
    
</script>

</body>
</html>