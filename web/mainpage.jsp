<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter;" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.github.fawwaz.heroku.service.*" %>

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

<title>Simple Blog</title>


</head>

<body class="default">
    
    <%! String role;
        String id_user;
        String username;
        Api api = new ApiImplService().getApiImplPort();
    %>
<% TimeConverter tc = new TimeConverter(); 
    
    if(session.getAttribute("firsttimer").toString().equals("yes")){
        role = "guest";
        username = "guest";
        id_user = "-999";
    }else{
        role = session.getAttribute("role").toString();
   username = session.getAttribute("username").toString();
    //id_user = session.getAttribute("id_user").toString();
    
    //out.print(role);
    }
        
   /*Cookie cookie = null;
    Cookie[] cookies = null;
    
    cookies = request.getCookies();

    if (cookies==null){
        role = "guest";
        username = "guest";
        id_user = "-999";
    }else{
        for (int i = 0; i < cookies.length; i++){
            switch(i) {
                case 0:{
                    role = cookies[i].getValue();
                    break;
                }
                case 1:{
                    username = cookies[i].getValue();
                    break;
                }
                case 2:{
                    id_user = cookies[i].getValue();
                    break;
                }
            }
      }
    }*/
    
   /*role = session.getAttribute("role").toString();
   username = session.getAttribute("username").toString();
    id_user = session.getAttribute("id_user").toString();*/
    
    //ngambil data
    List<Post> posts = api.getAllPost();
%>


<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li>haloooo,  <%= username %></li> <br>
        <% if (!role.equals("guest")){%>
        <% if (role.equals("editor") || role.equals("admin")){%>
        <li><a href="unpublished.jsp">unpublished post    </a></li>
        <%} %>
        <% if (role.equals("owner") || role.equals("admin")){%>
        <li><a href="new_post.jsp?mode=0">+ Tambah Post</a></li>
        <%} %>   
        <% if (role.equals("admin")){%>
        <li><a href="manage_user.jsp">manage user</a></li>
        <%} %> 
         <li><a href="index.jsp?action=logout">Log Out</a></li>
        <%}else{//berarti guest%>
        <li><a href="login.jsp">Login</a></li>
        <%} %> 
         
    </ul>
</nav>
    
<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
           
                  <%! String vi; %>
                  <%  
                    for(Post post: posts){
                        String mi = post.getUsername();
                        String d = post.getDate();
                        String id = post.getIdPost();
                    
                    //vi =  pageContext.getAttribute("visible").toString(); 
                  %>

                 
                    <a href="mainpage.jsp"></a>
                  
                <li class="art-list-item">
                <div class="art-list-item-title-and-time">
                    <h2 class="art-list-title"><a href="post.jsp?id_post=<%= id %>"><%= post.getTitle()%></a></h2>
                    <div class="art-list-time"><%= tc.ConvertDate(d) %></div>

                </div>
                <p><%= post.getContent() %></p>
                <p>
                   <%if(role.equals("owner")) {%>
                         <% if (mi.equals(username)) {%>
                            <a href="new_post.jsp?mode=1&id_post=<%= id %>">Edit</a> | <a href="javascript:ConfirmDelete(<%= id %>)">Hapus</a>
                         <%} %>
                    <%}else if(role.equals("editor")||role.equals("admin")) { %>
                        <a href="new_post.jsp?mode=1&id_post=<%= id %>">Edit</a> | <a href="javascript:ConfirmDelete(<%= id %>)">Hapus</a>
                    <%}%>
                  
                </p>
                </li>
                <% } //end of if for %>
        
            
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
      
      function ConfirmDelete(id){
	var conf = confirm("Apakah Anda yakin menghapus post ini?");
	
	if(conf==true){
		location.href = 'AddPost.jsp?mode=2&id_post='+id;
	}
}
      
</script>

</body>
</html>