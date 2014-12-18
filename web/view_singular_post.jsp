<%-- 
    Document   : view_singular_post
    Created on : Nov 25, 2014, 4:28:40 PM
    Author     : M. Reza Irvanda
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blog.*,blogutil.*" %>

<!DOCTYPE html>
<html>


    <head>
        <link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Singular Post</title>
    </head>

    <body class="default">
        <div class="wrapper">
            <nav class="nav">
                <a style="border:none;" id="logo" href="view_post.jsp"><h1>Simple<span>-</span>Blog</h1></a>
                <ul class="nav-primary">
                    <li><a href="new_post.php">+ Tambah Post</a></li>
                </ul>
            </nav>
        </div>
        <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            String nilaiNama = "";
            String nilaiEmail = "";

            cookies = request.getCookies();
            if (cookies.length == 0) {
                //do nothing
            } else {
//             cookie = cookies[0];
//             nilaiNama = cookie.getValue().toString();
                for (Cookie tmp : cookies) {
                    if (tmp.getName().equalsIgnoreCase("username")) {
                        nilaiNama = tmp.getValue().toString();
                    }
                    if (tmp.getName().equalsIgnoreCase("email")) {
                        nilaiEmail = tmp.getValue().toString();
                    }
                }
            }

            ArrayList<Post> list = (ArrayList) SimpleBlogService.listPost();
            String idPost = request.getParameter("post");
            Post post = null;
            for (Post tmp : list) {
                if (tmp.getId().equals(idPost)) {
                    post = tmp;
                    break;
                }
            }
            
            ArrayList<Komentar> listKomentar = SimpleBlogService.listComment(idPost);

        %>


        <article class="art simple post">
            <header class="art-header" style="margin : auto auto auto auto;">
                <time class="art-time"><% out.print(post.getTanggal());%> </time>
                <time class="art-time"><% out.print(post.getAuthor());%> </time>
                <h2 class="art-title"> <% out.print(post.getJudul());%> </h2>   
            </header>

            <div class="art-body">
                <div class="art-body-inner">
                    <hr class="featured-article" />
                        <% out.print(post.getKonten());%>
                    <hr />
                    <h2>Komentar</h2>

                    <div id="contact-area">
                        <font id="error" color='white' >Ada kesalahan! </font> 
                        <form>
                            <label for="Nama">Nama:</label>
                            <input type="text" name="nama" id="Nama" value="<%= nilaiNama%>">
                            <label for="Email">Email:</label>
                            <input type="text" name="email" id="Email" value="<%= nilaiEmail%>">   
                            <label for="Komentar">Komentar:</label><br>
                            <textarea name="konten" rows="20" cols="20" id="Komentar"></textarea>
                        </form>
                        <button onclick="validate()"> Submit</button>

                    </div>


                    <ul class="art-list-body"> 
                        <li class="art-list-item">
                            <div id="komentar-baru" class="art-list-item-title-and-time">
                                <h2 id="nama-komentar-baru" class="art-list-title"> </h2>
                                <div id="tanggal-komentar-baru" class="art-list-time"> </div>
                            </div>
                            <p id="konten-komentar-baru"></p>
                        </li>

                        <%
                            for(Komentar com : listKomentar){
                        %>
                        <li class="art-list-item">
                            <div class="art-list-item-title-and-time">
                                <h2 class="art-list-title"> <% out.print(com.getName());%> </h2>
                                <div class="art-list-time"> <% out.print(com.getTanggal());%></div>
                            </div>
                            <p> <% out.print(com.getKonten());%> </p>
                        </li>
                        <%
                            }       
                        %>

                    </ul>
                </div>
            </div>

            <footer class="footer">
                <div class="back-to-top"><a href="">Back to top</a></div>
                <!-- <div class="footer-nav"><p></p></div> -->
                <div class="psi">&Psi;</div>
            </footer>


            <script type="text/javascript" src="assets/js/jquery.min.js"></script>
            <script type="text/javascript" src="assets/js/fittext.js"></script>
            <script type="text/javascript" src="assets/js/app.js"></script>
            <script type="text/javascript" src="assets/js/respond.min.js"></script>
            <script type="text/javascript">
                                var xmlhttp;
                                function validate() {

                                    if (window.XMLHttpRequest)
                                    {// code for IE7+, Firefox, Chrome, Opera, Safari
                                        xmlhttp = new XMLHttpRequest();
                                    }
                                    else
                                    {// code for IE6, IE5
                                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                                    }
                                    xmlhttp.onreadystatechange = myfunction;
                                    if (testRegex(document.getElementById("Email").value) && document.getElementById("Nama").value != null && document.getElementById("Komentar").value != null) {
                                        xmlhttp.open("POST", "insert_comment.jsp?post=<%= request.getParameter("post")%>", true);
                                        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                        var sendString = "nama=" + document.getElementById('Nama').value + "&" + "konten=" + document.getElementById('Komentar').value + "&" + "email=" + document.getElementById('Email').value;
                                        xmlhttp.send(sendString);
                                        console.log("udah dikirim");


                                        return true;
                                    }
                                    else {
                                        console.log("salah");
                                        document.getElementById("error").setAttribute("color", "red");
                                        return false;
                                    }
                                }

                                function myfunction()
                                {

                                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                                        document.getElementById("tanggal-komentar-baru").innerHTML = "<%= new String((new java.util.Date().getYear() + 1900) + "-" + (new java.util.Date().getMonth() + 1) + "-" + (new java.util.Date()).getDate())%>";
                                        console.log("harusnya udah diganti");
                                        document.getElementById("konten-komentar-baru").innerHTML = document.getElementById("Komentar").value;
                                        console.log("harusnya udah diganti");
                                        document.getElementById("nama-komentar-baru").innerHTML = document.getElementById("Nama").value;
                                        console.log("harusnya udah diganti");
                                        document.getElementById("Nama").value = "";
                                        console.log("harusnya udah diganti");
                                        document.getElementById("Email").value = "";
                                        console.log("harusnya udah diganti");
                                        document.getElementById("Komentar").value = "";
                                        console.log("harusnya udah diganti");
                                        document.getElementById("error").setAttribute("color", "white");
                                        console.log("harusnya udah diganti");

                                    }

                                }


                                function testRegex(contohString) {
                                    var re = new RegExp("[a-z_0-9\\-]+@[a-z_0-9\-]+\\.[a-z]+");
                                    return re.test(contohString);
                                }
            </script>       

        </article>
</html>



