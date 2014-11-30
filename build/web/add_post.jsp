<%@page import="SimpleBlog.MySQLAccess"%>
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
            <%
                CookieController CC = new CookieController();
                Cookie[] cookies = request.getCookies();
                MySQLAccess sql = new MySQLAccess();
                
                if(cookies!=null)
                {
                    int idx = CC.FindUserCookie(cookies);
                    if(idx<cookies.length)
                    {
                        if(!cookies[idx].getValue().equalsIgnoreCase("guest"))
                        {
                            out.println("<li><a href=\"add_post.jsp\">Add Post</a></li>");
                        }
                        if(sql.getRolebyUsername(
                            cookies[CC.FindUserCookie(cookies)].getValue()).equalsIgnoreCase("admin"))
                        {
                            out.println("<li><a href=\"user_list.jsp\">User List</a></li>");
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
                int idx = CC.FindUserCookie(cookies);
                String username = cookies[idx].getValue();
                
                User user = null;
                if(idx<cookies.length)
                {
                    user=new User(username, " ", " ", sql.getRolebyUsername(username));
                }
                else
                {
                    user = new User("guest"," "," ","guest");
                }
                if(user.role.equalsIgnoreCase("guest"))
                {
                    out.println(CC.LoginForm());
                }
                else
                {
                    out.println(CC.Welcome(user.username));
                }    
            %>
          </ul>
        </div><!--close menubar-->	
        </nav>
    </header>
    
    <div id="site_content">
        <article class="art simple post">  
            <h2 class="art-title" style="margin-bottom:40px">-</h2>

            <div class="art-body">
                <div class="art-body-inner">
                    <h2>Tambah Post</h2>

                    <div id="contact-area">
                        <form method="post" action="add_post" onSubmit="return cekTanggal()">
                            <label for="Judul">Judul:</label>
                            <input type="text" name="Judul" id="Judul">

                            <label for="Tanggal">Tanggal:</label>
                            <input type="text" name="Tanggal" id="Tanggal" placeholder="cth : 1994-11-29">

                            <label for="Konten">Konten:</label><br>
                            <textarea name="Konten" rows="20" cols="20" id="Konten"></textarea>

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
