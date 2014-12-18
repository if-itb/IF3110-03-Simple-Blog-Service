<%-- 
    Document   : AddNewPost
    Created on : Nov 23, 2014, 7:41:49 PM
    Author     : Asep Saepudin
--%>

<%@page import="WBD.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <title>Simple Blog | Add New Post</title>
    </head>    
    <%                
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        if (currentUser == null) {            
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "PublishedPosts"); 
        }        
        if (currentUser.getRole().equals("Editor")) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "PublishedPosts"); 
        }
    %>
    <body class="default">
        <div class="wrapper">

            <nav class="nav">
                <a style="border:none;" id="logo" href="PublishedPosts"><h1>Simple<span>-</span>Blog</h1></a>
                <ul class="nav-primary">
                    
                </ul>
            </nav>

            <article class="art simple post">        
                <h2 class="art-title" style="margin-bottom:40px">-</h2>

                <div class="art-body">
                    <div class="art-body-inner">
                        <h2>Add New Post</h2>

                        <div id="contact-area">
                            <form method="POST" action="AddNewPost">
                                <label for="judul">Judul:</label>
                                <input type="text" name="judul" id="judul">

                                <label for="tanggal">Tanggal:</label>
                                <input type="text" name="tanggal" id="tanggal" placeholder="MM/dd/yyyy">                    

                                <label for="konten">Konten:</label><br>
                                <textarea name="konten" rows="20" cols="20" id="konten"></textarea>

                                <input type="submit" name="submit" value="Save" class="submit-button" onclick="return validate()">
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
</body>
<script type="text/javascript" src="assets/js/myjs.js" ></script>
</html>
