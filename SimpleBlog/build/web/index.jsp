<%@page import="SimpleBlog.CookieController"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<root>
<html>    
<head>
  <title>Simple Blog</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="javascript/modernizr-1.5.min.js"></script>
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
            <li class="current"><a href="home.jsp">Home</a></li>
            <%
                CookieController CC = new CookieController();
                Cookie[] cookies = request.getCookies();

                if(cookies!=null)
                {
                    int idx = CC.FindUserCookie(cookies);
                    if(idx<cookies.length)
                    {
                    }
                    else
                    {
                        // Menciptakan cookies untuk guest      
                        Cookie guest = new Cookie("user","guest"); 
                        // Meng - set agar cookie hilang setelah 24 jam
                        guest.setMaxAge(60*60*2); 
                        // Menambahkan cookie ke header response
                        response.addCookie(guest);
                    }
                }
                else
                {
                    // Menciptakan cookies untuk guest      
                    Cookie guest = new Cookie("user","guest"); 
                    // Meng - set agar cookie hilang setelah 24 jam
                    guest.setMaxAge(60*60*2); 
                    // Menambahkan cookie ke header response
                    response.addCookie(guest);
                }
               response.sendRedirect("home.jsp");
            %>
          </ul>
        </div><!--close menubar-->	
        </nav>
    </header>
    
    <div id="site_content">
        
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
</root>