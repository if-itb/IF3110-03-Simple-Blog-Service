
<%@page import="org.wbd.heroku.service.Post"%>
<%@page import="org.SimpleBlogServiceHandler.SimpleBlogServiceHandler"%>
<%@page import="java.util.List"%>
<%@page import="org.wbd.client.*"%>


<%-- 
    Document   : index.jsp
    Created on : Dec 18, 2014, 12:59:43 AM
    Author     : toshibapc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="index.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="login.jsp">Log In</a></li>
    </ul>
</nav>

<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
            <!--Showing post from database-->
            <% 
                   out.println("<form onclick=\"SearchHandler.jsp\" method=\"post\"><input type=\"text\" name=\"search\"><input type=\"submit\" value=\"Search\"></form>");                    
                    String d=request.getParameter("query");
                    SimpleBlogServiceHandler.addPost(d, d, d, d);
                    List<Post> LP = SimpleBlogServiceHandler.search(d);
                    if (LP.isEmpty()){
                   out.println("No Result Yuhuu");
                }
               for (int i = 0; i < LP.size(); i++){
                   Post haha = LP.get(i);
                   String judul = haha.getJudul();
                   String tanggal = haha.getTanggal();
                   String konten = haha.getKonten();
                   String id = haha.getId();
                   
                   out.println(" <li class=\"art-list-item\"> <div class=\"art-list-item-title-and-time\"> <h2 class=\"art-list-title\"><a href=\"PostGuest.jsp?post_id="
                                + id
                                + "\">"
                                + judul+ "</a></h2> "
                                + "<div class=\"art-list-time\">"+ tanggal +"</div></div><p>");
                        String[] words = konten.split(" ");
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < Math.min(30, words.length); j++)
                        {
                            sb.append(words[j] + " ");  
                        }   
                        String First30WordPost = sb.toString();
                        out.println(First30WordPost);
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
    </body>
</html>
