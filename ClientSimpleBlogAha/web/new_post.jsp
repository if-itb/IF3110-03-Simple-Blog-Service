<%-- 
    Document   : new_post
    Created on : Nov 24, 2014, 2:10:26 PM
    Author     : tegar
--%>




<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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

<title>Simple Blog | Tambah Post</title>


</head>

<body class="default">
<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="home.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        
    </ul>
</nav>

<article class="art simple post">
    
    
    <h2 class="art-title" style="margin-bottom:40px">-</h2>

    <div class="art-body">
        <div class="art-body-inner">
            <h2>Tambah Post</h2>

            <div id="contact-area">
                <form name="PostForm" method="post" onSubmit="return validateDate()" action="AddPostHandling">
                    <label for="Judul">Judul:</label>
                    <input type="text" name="Judul" id="Judul">

                    <label for="Tanggal">Tanggal:</label>
                    <input type="date" name="Tanggal" id="Tanggal">
                    <%
                        System.out.println(request.getParameter("User_Id"));
                        //Ada user id
                        out.println("<input type=hidden name=User_Id value=\""+session.getAttribute("userid")+"\">");
                        

                    %>
                    
                    <label for="Konten">Konten:</label><br>
                    <textarea name="Konten" rows="20" cols="20" id="Konten"></textarea>
                                            
                    <center> <input type="submit" name="submit" value="Simpan" class="submit-button"> </center>
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

<script type="text/javascript" src="assets/js/fittext.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/respond.min.js"></script>

<!-- Date Validation using JS -->
<script>
    function validateDate()
    {
        var inputdate = document.forms["PostForm"]["Tanggal"].value;
        var currentdate = new Date();
        var nowdd = currentdate.getDate();
        var nowmm = currentdate.getMonth()+1;
        var nowyyyy = currentdate.getFullYear();
        var partdate = inputdate.split('-');
        var inputyyyy = partdate[0];
        var inputmm = partdate[1];
        var inputdd = partdate[2];
        if (nowyyyy<inputyyyy)
        {
            return true;
        }        
        else if (nowyyyy>inputyyyy)
        {
            alert("Tanggal tidak valid");
            return false;
        }
        else
        {
            if (nowmm<inputmm)
            {
                return true;
            }
            else if (nowmm>inputmm)
            {
                alert("Tanggal tidak valid");
                return false;
            }
            else
            {
                if (nowdd<=inputdd)
                {
                    return true;
                }
                else  if (nowdd>inputdd)
                {
                    alert("Tanggal tidak valid");
                    return false;
                }
            }
        }
    }  
</script>


</body>
</html>