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
  <title>Simple Blog - Search Post</title>
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
                MySQLAccess sql = new MySQLAccess();
                
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
                int idx = CC.FindUserCookie(cookies);
                String username = cookies[idx].getValue();
                
                User user = null;
                if(idx<cookies.length && !username.equalsIgnoreCase("guest"))
                {
                    user=new User(username, " ", " ", sql.getRolebyUsername(username));
                }
                else
                {
                    user = new User("guest"," "," ","guest");
                }
                if(!user.role.equalsIgnoreCase("guest") && !user.role.equalsIgnoreCase("editor"))
                {
                    out.println("<li><a href=\"add_post.jsp\">Add Post</a></li>");
                }
                if(user.role.equalsIgnoreCase("admin"))
                {
                    out.println("<li><a href=\"user_list.jsp\">User List</a></li>");
                }
                if(user.username.equalsIgnoreCase("guest"))
                {
                    out.println(CC.LoginForm());
                }
                else
                {
                    out.println(CC.Welcome(user.username));
                }
                out.println(CC.SearchForm());
                
            %>
          </ul>
        </div><!--close menubar-->	
        </nav>
    </header>
    
    <div id="site_content">
        <%
            String query = request.getParameter("query");
            java.util.List<org.chamerling.heroku.service.Post> listpost = null;
            try {
                org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
                org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
                
                listpost = port.searchPost(query);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
    
            if(listpost!=null)
            {
                for (org.chamerling.heroku.service.Post p:listpost)
                {

                    if(user.username.compareTo("guest")==0)
                    {
                        if(p.getPublish().equalsIgnoreCase("1"))
                        {
                            out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+"<br><a href=\"view_post.jsp?idPost="+p.getIDPost()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                            out.println("<br><br><hr>");
                        }

                    }
                    else if(user.role.compareTo("owner")==0)
                    {
                        if(p.getPublish().equalsIgnoreCase("1"))
                        {
                            out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+"<br><a href=\"view_post.jsp?idPost="+p.getIDPost()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                            out.println("<div class=\"button_small\"> <a href=\"edit_post.jsp?idPost="+p.getIDPost()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"soft_delete?idPost="+p.getIDPost()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                            out.println("<br><br><hr>");
                        }

                    }
                    else if(user.role.compareTo("editor")==0)
                    {
                        if(!p.getPublish().equalsIgnoreCase("3"))
                        {
                            out.println("<div class = \"content_item\">");
                            out.println("<p><br>"+ p.getTanggal()+"<br></p>");
                            out.println("<p><a href=\"view_post.jsp?idPost="+p.getIDPost()+"\"><h1>"+p.getJudul()+ "</h1></a></p>");
                            out.println("<p>"+p.getKonten() + "</p></div>");
                            out.println("<div class=\"button_small\"> <a href=\"edit_post.jsp?idPost="+p.getIDPost()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"soft_delete?idPost="+p.getIDPost()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                            if(p.getPublish().equalsIgnoreCase("1"))
                            {
                                out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getIDPost()+"\">UnPublish</a> </div>");
                            }
                            else if(p.getPublish().equalsIgnoreCase("0"))
                            {
                                out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getIDPost()+"\">Publish</a> </div>");
                            }
                            out.println("<br><br><hr>");                                            
                        }
                    }
                    else if(user.role.compareTo("admin")==0)
                    {
                        out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+"<br><a href=\"view_post.jsp?idPost="+p.getIDPost()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                        out.println("<div class=\"button_small\"><a href=\"edit_post.jsp?idPost="+p.getIDPost()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"delete_post?idPost="+p.getIDPost()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                        if(p.getPublish().equalsIgnoreCase("3"))
                        {
                            out.println("<div class=\"button_small\"> <a href=\"restore?idPost="+p.getIDPost()+"\">Restore</a> </div>");
                        }
                        else
                        {
                            out.println("<div class=\"button_small\"> <a href=\"soft_delete?idPost="+p.getIDPost()+"\">Soft Delete</a> </div>");
                        }
                        if(p.getPublish().equalsIgnoreCase("1"))
                        {
                            out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getIDPost()+"\">UnPublish</a> </div>");
                        }
                        else if(p.getPublish().equalsIgnoreCase("0"))
                        {
                            out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getIDPost()+"\">Publish</a> </div>");
                        }

                         out.println("<br><br><hr>");
                    }
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