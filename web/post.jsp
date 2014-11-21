<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter" %>
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

<title>Simple Blog | Apa itu Simple Blog?</title>


</head>

<body class="default" onload="showKomen(${param.id_post})" onscroll="OnScrollDiv(this)">
<div class="wrapper">
    
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>

<sql:query dataSource="${snapshot}" var="result">
SELECT `title`,`date`,`post` FROM `tucildb_13511097`.`listpost` WHERE `id`=${param.id_post};
</sql:query> 

<% TimeConverter tc = new TimeConverter(); %>

<nav class="nav">
    <a style="border:none;" id="logo" href="index.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="new_post.jsp?mode=0">+ Tambah Post</a></li>
    </ul>
</nav>

<article class="art simple post">
    
    <c:forEach var="row" items="${result.rows}">
         <c:set var="myTest" value="${row.date}"/>
                    <%! String d; %>
                    <%  d =  pageContext.getAttribute("myTest").toString(); %>
    <header class="art-header">
        <div class="art-header-inner" style="margin-top: 0px; opacity: 1;">
            <time class="art-time"><%= tc.ConvertDate(d) %></time>
            <h2 class="art-title"><c:out value="${row.title}"/></h2>
            <p class="art-subtitle"></p>
        </div>
    </header>

    <div class="art-body">
        <div class="art-body-inner">
            <hr class="featured-article" />
            <p><c:out value="${row.post}"/></p>
            <hr/>    
    </c:forEach>
    
            
            <h2>Komentar</h2>

            <div id="contact-area">
                <form method="post" action="#">
                    <label for="Nama">Nama:</label>
                    <input type="text" name="Nama" id="Nama" value="">
        
                    <label for="Email">Email:</label>
                    <input type="text" name="Email" id="Email" value="" onkeyup="checkEmail(this)"><div id="err_email"></div><br>
                    
                    <label for="Komentar">Komentar:</label><br>
                    <textarea name="Komentar" rows="20" cols="20" id="Komentar"></textarea>
					<input type="hidden" name="id_post" value="<?php echo $id; ?>">
                    <input type="button" name="button" value="Kirim" onclick="AddKomen(${param.id_post})">
                </form>
           </div>
                <div id="err_mes"></div>
			<div id="komen">
        <!--memunculkan komen-komen yang sudah ada-->
			</div>

            <ul class="art-list-body">
                <li class="art-list-item">
                    <div class="art-list-item-title-and-time">
                        <h2 class="art-list-title"><a href="post.jsp">Jems</a></h2>
                        <div class="art-list-time">2 menit lalu</div>
                    </div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis repudiandae quae natus quos alias eos repellendus a obcaecati cupiditate similique quibusdam, atque omnis illum, minus ex dolorem facilis tempora deserunt! &hellip;</p>
                </li>

                <li class="art-list-item">
                    <div class="art-list-item-title-and-time">
                        <h2 class="art-list-title"><a href="post.jsp">Kave</a></h2>
                        <div class="art-list-time">1 jam lalu</div>
                    </div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis repudiandae quae natus quos alias eos repellendus a obcaecati cupiditate similique quibusdam, atque omnis illum, minus ex dolorem facilis tempora deserunt! &hellip;</p>
                </li>
            </ul>
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

function showKomen(idpost) {
  var xmlhttp= new XMLHttpRequest();;
  
  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      document.getElementById("komen").innerHTML=xmlhttp.responseText;
    }
  }
  xmlhttp.open("GET","GetKomen.jsp?id="+idpost);
  xmlhttp.send();
}

function AddKomen(idpost){
	 var xmlhttp=new XMLHttpRequest();
	 var nama =  document.getElementById("Nama").value;
	 var email =  document.getElementById("Email").value;
	 var komentar = document.getElementById("Komentar").value;
	 var veremail = checkEmail();
     
  if(nama!=""&&email!=""&&komen!=""&& veremail==true){
	xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	  document.getElementById("err_mes").innerHTML= "";
      document.getElementById("Nama").value=xmlhttp.responseText;
	  document.getElementById("Email").value=xmlhttp.responseText;
	  document.getElementById("Komentar").value=xmlhttp.responseText;
	  showKomen(idpost);
	 }
	}
        xmlhttp.open("GET","AddKomen.jsp?id_post="+idpost+"&Nama="+nama+"&Email="+email+"&Komentar="+komentar);
	xmlhttp.send();
  }else{
	 document.getElementById("err_mes").innerHTML= "masukkan belum tepat/lengkap";
  }
}
function checkEmail(){
				var err_email = document.getElementById("err_email");
				var emailStr = document.getElementById("Email").value;
				var emailRegexStr = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
				var isValid = emailRegexStr.test(emailStr);
				if(!isValid){
					err_email.innerHTML = "alamat email tidak valid";
					return false;
				}
				else{
					err_email.innerHTML = "";
					return true;
				}
}
</script>

</body>
</html>