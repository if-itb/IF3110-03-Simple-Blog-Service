<%@page import="SimpleBlog.User"%>
<%@page import="SimpleBlog.CookieController"%>
<%@page import="SimpleBlog.Post"%>
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
        <title>Simple Blog - Edit Post</title>
    </head>
    <body>
        <%-- start web service invocation --%>
    <%
        java.util.List<java.lang.Object> result = null;
    try {
	org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
	org.chamerling.heroku.service.HelloServiceImpl port = service.getHelloServiceImplPort();
	// TODO process result here
	result = port.listPost();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
            int idPost = Integer.parseInt(request.getParameter("idPost"));
            Post post = Post.class.cast(result.get(idPost));
        %>
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
                 if(!user.role.equalsIgnoreCase("owner")&&!user.role.equalsIgnoreCase("admin")&&!user.role.equalsIgnoreCase("editor"))
                {
                    response.sendRedirect("home.jsp");
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
                            <h2>Edit Post</h2>

                            <div id="contact-area">
                                <form method="POST" action="edit_post?idPost=<% out.println(post.idPost); %>" onSubmit="return cekTanggal()">
                                    <label for="Judul">Judul:</label>
                                    <input type="text" name="Judul" id="Judul" value="<% out.println(post.judul); %>">

                                    <label for="Tanggal">Tanggal:</label>
                                    <input type="text" name="Tanggal" id="Tanggal" placeholder="cth : 1994-11-29" value="<% out.println(post.tanggal); %>">

                                    <label for="Konten">Konten:</label><br>
                                    <textarea name="Konten" rows="20" cols="20" id="Konten"><% out.println(post.konten); %></textarea>

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
