<!DOCTYPE html>
<html>
    <head>
        <%@ page import="java.io.*,java.util.*,java.sql.*"%>
        <%@ page import="javax.servlet.http.*,javax.servlet.*,blogutil.*,blog.*" %>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="Deskripsi Blog" />
        <meta name="author" content="Judul Blog" />

        <!-- Twitter Card -->

        <meta property="og:type" content="article" />
        <meta property="og:title" content="Simple Blog" />
        <meta property="og:description" content="Deskripsi Blog" />
        <meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}" />
        <meta property="og:site_name" content="Simple Blog" />

        <link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />

        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <title>Edit User - Simple Blog</title>


    </head>

    <body class="default">
        <div class="wrapper">

            <nav class="nav">
                <a style="border:none;" id="logo" href="view_post.jsp"><h1>Simple<span>-</span>Blog</h1></a>
                <ul class="nav-primary">
                    <li><a href="new_post.jsp">+ Tambah Post</a></li>
                </ul>
            </nav>

            <div style="position:relative;top:180px;left:300px;">
                <div id="contact-area">
                    <%
                        Cookie[] listCookie = request.getCookies();
                        String role = "";
                        for (Cookie cook : listCookie) {
                            if (cook.getName().equals("role")) {
                                if (cook.getValue().equals("admin")) {
                                    role = "admin";
                                } else {
                                    out.println("You are not login");
                                }
                            }
                        }

                        if (role.equals("")) {
                            out.println("You are not login");
                        } else {
                            
                        String name = request.getParameter("name");
                        ArrayList<Pengguna> list = (ArrayList)SimpleBlogService.listUser();
                        Pengguna pengguna = null;
                        for(Pengguna peng : list){
                            if(peng.getNama().equals(name)){
                                pengguna = peng; 
                            }
                        }
                        
                    %>
                    <form action="edit_user_back.jsp" method="post">
                        <input type="hidden" name="namaLama" value="<% out.print(pengguna.getNama());%>" >
                        <label for="Nama">Nama:</label>
                        <input type="text" name="nama" id="Nama" value="<% out.print(pengguna.getNama());%>">
                        <label for="Email">Email:</label>
                        <input type="text" name="email" id="Email" value="<% out.print(pengguna.getEmail());%>">   
                        <label for="Email">Password:</label>
                        <input type="text" name="password" id="Password" value="<% out.print(pengguna.getPassword());%>">   
                        <label for="Komentar">Role:</label><br>
                        <input type="text" name="role" id="role" value="<% out.print(pengguna.getRole());%>">   
                        <input type="submit" value="Submit">
                    </form>



                                    </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <footer class="footer" style="top:230px;">
                                        <div class="back-to-top"><a href="">Back to top</a></div>
                                        <!-- <div class="footer-nav"><p></p></div> -->
                                        <div class="psi">&#x3A8;</div>
                                        <aside class="offsite-links">
                                            Asisten IF3110 /
                                            <a class="rss-link" href="#rss">RSS</a> /
                                            <br />
                                            <a class="twitter-link" href="http://twitter.com/YoGiiSinaga">Yogi</a> /
                                            <a class="twitter-link" href="http://twitter.com/sonnylazuardi">Sonny</a> /
                                            <a class="twitter-link" href="http://twitter.com/fathanpranaya">Fathan</a> /
                                            <br />
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

                                        (function(g, h, o, s, t, z) {
                                            g.GoogleAnalyticsObject = s;
                                            g[s] || (g[s] =
                                                    function() {
                                                        (g[s].q = g[s].q || []).push(arguments)
                                                    });
                                            g[s].s = +new Date;
                                            t = h.createElement(o);
                                            z = h.getElementsByTagName(o)[0];
                                            t.src = '//www.google-analytics.com/analytics.js';
                                            z.parentNode.insertBefore(t, z)
                                        }(window, document, 'script', 'ga'));
                                        ga('create', ga_ua);
                                        ga('send', 'pageview');
                                    </script>

                                    </body>
                                    </html>