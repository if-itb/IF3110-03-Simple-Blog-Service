<%-- 
    Document   : LoginCheck
    Created on : Nov 24, 2014, 2:10:26 PM
    Author     : Teofebano
--%>

<%@page import="org.wbd.heroku.service.Post"%>
<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
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
    <a style="border:none;" id="logo" href="index.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><h6>
            <%
            String a=session.getAttribute("username").toString();
            String b=session.getAttribute("role").toString();
            String c=session.getAttribute("userid").toString();
            
            out.println("Hello  "+a);
            out.print("Welcome as  ");
            if (b.compareTo("1") == 0){
                out.println("Owner");
            }
            else if (b.compareTo("2") == 0){
                out.println("Editor");
            }
            else if (b.compareTo("3") == 0){
                out.println("Admin");
            }
            
            %>
            
        </h6> </li>
        
        <% 
            if (b.compareTo("1") == 0){
                out.println("<li><a href=\"new_post.jsp\">+ Tambah Post</a></li>");
            }
            else if (b.compareTo("2") == 0){
                out.println("<li><a href=\"showunpublishedposts.jsp\">Publish Or Edit</a></li>");
            }
            else if (b.compareTo("3") == 0){
                out.println("<li><a href=\"new_post.jsp\">+ TambahPost |</a></li>");
                out.println("<li><a href=\"showunpublishedposts.jsp\"> Publish Or Edit |</a></li>");
                out.println("<li><a href=\"ManagementUser.jsp\"> ManagementUser |</a></li>");
            }
        %>
        <li><a href="logout.jsp"> Logout</a></li>
    </ul>
</nav>


        
<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
            <!--Showing post from database-->
            
                <% 
                    String d = session.getAttribute("query").toString();
                    List<Post> LP = new ArrayList();
                    if (b.compareTo("1")==0){
                        LP = SimpleBlogServiceHandler.listPost(2); // masih masalah di sini gar
                    }    
                    else if (b.compareTo("2")==0){
                        LP = SimpleBlogServiceHandler.listPost(2); // masih masalah di sini gar
                    }
                    else if (b.compareTo("3")==0){
                        LP = SimpleBlogServiceHandler.listPost(14); // masih masalah di sini gar
                    }
                    String judul = "";
                    String tanggal = "";
                    String konten = "";
                    String id = "";
                    
                    if (LP.isEmpty()){
                         out.println("No Result");
                     }
                    for (int i = 0; i < LP.size(); i++){
                        Post haha = LP.get(i);
                        judul = haha.getJudul();
                        tanggal = haha.getTanggal();
                        konten = haha.getKonten();
                        id = haha.getId();
                        
                        
                        if (b.compareTo("1") == 0){
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
//                                + "&"
                                //+ "user_id="
                                //+ c
                                + "\""
                                + ">Edit</a> | <a href=\"DeletePostHandling?post_id="+ id +"\" onclick=\"validatedelete()\" >Hapus</a></p> </li>"); 
                            /*if (rs.getString("picture_filename").isEmpty())
                            {
                                out.println(" <p> "
                                + "<a href=\""
                                + "edit_post.jsp??role=2&"
                                + "post_id="
                                + rs.getString("post_id")
                                + "&"
                                + "user_id="
                                + request.getParameter("user_id")
                                + "\">Edit</a> | <a onclick=\"validatedelete(" + rs.getString("post_id") + ")\" href=\"javascript:void(0)\">Hapus</a></p> </li>");                            
                            }
                            else
                            {
                                out.println(" <p> "
                                + "<img src=\"picture\\"+rs.getString("picture_filename")+".jpg\" width=50>"
                                        + "<br>"
                                + "<a href=\""
                                + "edit_post.jsp??role=2&"
                                + "post_id="
                                + rs.getString("post_id")
                                + "&"
                                + "user_id="
                                + request.getParameter("user_id")
                                + "\">Edit</a> | <a onclick=\"validatedelete(" + rs.getString("post_id") + ")\" href=\"javascript:void(0)\">Hapus</a></p> </li>");
                            }*/
                            }
                            else if (b.compareTo("2") == 0){
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
//                                    + "&"
//                                    + "user_id="
//                                    + c
                                    + "\""
                                    + ">Edit</a> | <a onclick=\"validatedelete()\" href=\"DeletePostHandling?post_id="+ id +"\">Hapus</a></p> </li>");
                            }
                            else if (b.compareTo("3") == 0){
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
                                if (haha.isDeleted()){
                                    out.println(" <p> "
                                    + "<a href=\""
                                    + "edit_post.jsp?post_id="
                                    + id
//                                    + "&"
//                                    + "user_id="
//                                    + c
                                    + "\""
                                    
                                    + ">Edit</a> | <a onclick=\"validatedelete("+id+")\" href=\"javascript:void(0)\")>Hapus</a></p> | <a href=\"RestorePostHandling?post_id="+ id + "\">Restore</a></p></li>");
                                }
                                else{
                                    out.println(" <p> "
                                    + "<a href=\""
                                    + "edit_post.jsp?post_id="
                                    + id
//                                    + "&"
//                                    + "user_id="
//                                    + c
                                    + "\""
                                    
                                    + ">Edit</a> | <a onclick=\"validatedelete("+id+")\" href=\"javascript:void(0)\")>Hapus</a></p> </li>");
                                }
                               
                            }
                        }
                    
                
//               List<Post> LP = SimpleBlogServiceHandler.listPost(15); // masih masalah di sini gar
//               if (LP.isEmpty()){
//                    out.println("gar, masih belum bisa nampilin post :(");
//                }
//               for (int i = 0; i < LP.size(); i++){
//                   Post haha = LP.get(i);
//                   String judul = haha.getJudul();
//                   String tanggal = haha.getTanggal();
//                   String konten = haha.getKonten();
//                   String id = haha.getId();
//                   
//                   out.println(" <li class=\"art-list-item\"> <div class=\"art-list-item-title-and-time\"> <h2 class=\"art-list-title\"><a href=\"PostGuest.jsp?post_id="
//                                + id
//                                + "\">"
//                                + judul+ "</a></h2> "
//                                + "<div class=\"art-list-time\">"+ tanggal +"</div></div><p>");
//                        String[] words = konten.split(" ");
//                        StringBuilder sb = new StringBuilder();
//                        for (int j = 0; j < Math.min(30, words.length); j++)
//                        {
//                            sb.append(words[j] + " ");  
//                        }   
//                        String First30WordPost = sb.toString();
//                        out.println(First30WordPost);
//               } 
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
<script type="text/javascript">
  var ga_ua = '{{! TODO: ADD GOOGLE ANALYTICS UA HERE }}';

  (function(g,h,o,s,t,z){g.GoogleAnalyticsObject=s;g[s]||(g[s]=
      function(){(g[s].q=g[s].q||[]).push(arguments)});g[s].s=+new Date;
      t=h.createElement(o);z=h.getElementsByTagName(o)[0];
      t.src='//www.google-analytics.com/analytics.js';
      z.parentNode.insertBefore(t,z)}(window,document,'script','ga'));
      ga('create',ga_ua);ga('send','pageview');
</script>

<!-- Vaildate Delete -->
<!--<script>
  function validatedelete(post_id)
  {
      var answer = confirm("Apakah Anda yakin menghapus post ini?")
        if (answer){      
//          document.location= "DeletePostHandling?role=3&post_id="+post_id;
            x = window.location.href = "DeletePostHandling?role=3&post_id="+post_id;
        alert("Post berhasil dihapus");
        }else{
            x="Cancel";
          alert("Post tidak dihapus. Terima kasih.");
        }
  } 
 </script>-->

 <!-- Vaildate Delete -->
<script>
  function validatedelete(post_id)
  {
      console.log("validatedelete");
      var answer = confirm("Apakah Anda yakin menghapus post ini?")
        if (answer){      
          document.location= "DeletePostHandling?role=3&post_id="+post_id;
          alert("Post berhasil dihapus");
        }else{
          alert("Post tidak dihapus. Terima kasih.");
        }
  } 
 </script>

</body>
</html>