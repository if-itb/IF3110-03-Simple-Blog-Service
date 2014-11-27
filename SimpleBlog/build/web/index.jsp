<%@page import="SimpleBlog.CookieController"%>
<%@page import="java.util.List"%>
<%@page import="SimpleBlog.Post"%>
<%@page import="SimpleBlog.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SimpleBlog.MySQLAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html> 
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
                User user = new User();
                
                
                if(cookies!=null)
                {
                    int idx = CC.FindUserCookie(cookies);
                    if(idx<cookies.length)
                    {
                        if(!cookies[idx].getValue().equalsIgnoreCase("guest"))
                        {
                            out.println("<li><a href=\"add_post.jsp\">Add Post</a></li>");
                            user.setUser(cookies[idx].getValue(), " ", " ", cookies[idx].getValue());
                        }
                        else
                        {
                            user.setUser("guest"," "," ","guest");
                        }
                        if(cookies[CC.FindUserCookie(cookies)].getValue().equalsIgnoreCase("admin"))
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
                user.setUser("guest"," "," ","guest");
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
        <%
            MySQLAccess sql=new MySQLAccess();
            List<Post> listpost=new ArrayList();
            listpost=sql.getPost();
            
            
            for (Post p:listpost)
            {
                if(user.role.compareTo("guest")==0)
                {
                    if(p.publish)
                    {
                        out.println("<div class = \"content_item\"><p><br>"+ p.tanggal+ " "+p.waktu +"<br><a href=\"view_post.jsp?idPost="+p.idPost+"\"></p><h1>"+p.judul+ "</h1></a> <br><p>"+p.konten + "</div></p>");
                        out.println("<br><br><hr>");
                    }
                }
                else
                {
                    out.println("<div class = \"content_item\"><p><br>"+ p.tanggal+ " "+p.waktu +"<br><a href=\"view_post.jsp?idPost="+p.idPost+"\"></p><h1>"+p.judul+ "</h1></a> <br><p>"+p.konten + "</div></p>");
                    out.println("<div class=\"button_small\"> <a href=\"edit_post.jsp?idPost="+p.idPost+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"delete_post?idPost="+p.idPost+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                    if((user.role.compareTo("admin")==0 || user.role.compareTo("editor")==0) && p.publish)
                    {
                        out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.idPost+"\">UnPublish</a> </div>");
                    }
                    if((user.role.compareTo("admin")==0 || user.role.compareTo("editor")==0) && !p.publish)
                    {
                        out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.idPost+"\">Publish</a> </div>");
                    }
                    out.println("<br><br><hr>");
                }
            }
        %>
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