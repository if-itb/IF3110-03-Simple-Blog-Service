<%@page import="SimpleBlog.User"%>
<%@page import="SimpleBlog.CookieController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" src="javascript/date_validation.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="javascript/modernizr-1.5.min.js"></script>
        <title>Simple Blog - New Post</title>
    </head>
    <body>
    <div id="main">		
    <header>
        <div id="strapline">
            <div id="welcome_slogan">
                <a href="index.jsp"><h3>-- Simple Blog --</h3></a>
            </div><!--close welcome_slogan-->
        </div><!--close strapline-->
        <nav>
            <div id="menubar">
          
          <ul id="nav">
            <li><a href="index.jsp">Home</a></li>
 
          </ul>
        </div><!--close menubar-->	
        </nav>
    </header>
    
    <div id="site_content">
        <article class="art simple post">  
            <h2 class="art-title" style="margin-bottom:40px">-</h2>

            <div class="art-body">
                <div class="art-body-inner">
                    <h2>Post Bergambar</h2>

                    <div id="contact-area">
                        <form name="frm" action="saveimage.jsp" enctype="multipart/form-data" method="post" onsubmit="add_image">
         
                            <label for="Gambar">Image:  </label> <br> <input type="file" name="uProperty" >

                            <input type="submit" name="submit" value="Simpan" class="submit-button">
                        </form>
                    </div>
                </div>
            </div>
        </article>
            
        <footer>
            <a href="twitter.com/djstephendj">Stephen / 13512025</a> | <a href="twitter.com/ivanaclairine"> Ivana / 13512041</a> | <a href="twitter.com/susantigojali"> Susanti / 13512057</a> 
        </footer>
    </div>	
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="javascript/jquery.min.js"></script>
  <script type="text/javascript" src="javascript/image_slide.js"></script>
    </body>
</html>
