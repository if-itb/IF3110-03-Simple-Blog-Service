<%@page import="SimpleBlog.user"%>
<%@page import="SimpleBlog.post"%>
<%@page import="SimpleBlog.CookieController"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
                
                if(cookies!=null)
                {
                    int idx = CC.FindUserCookie(cookies);
                    if(idx<cookies.length)
                    {
                        if(!cookies[idx].getValue().equalsIgnoreCase("guest"))
                        {
                            out.println("<li><a href=\"add_post.jsp\">Add Post</a></li>");
                        }
                        /*if(sql.getRolebyUsername(
                            cookies[CC.FindUserCookie(cookies)].getValue()).equalsIgnoreCase("admin"))
                        {
                            out.println("<li><a href=\"user_list.jsp\">User List</a></li>");
                        }*/
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
                
                org.chamerling.heroku.service.User user = null;
                if(idx<cookies.length)
                {
                    //user=new User(username, " ", " ", sql.getRolebyUsername(username));
                }
                else
                {
                    user = new org.chamerling.heroku.service.User();
                    user.setPW("");
                    
                }
                /*if(user.username.equalsIgnoreCase("guest"))
                {
                    out.println(CC.LoginForm());
                }
                else
                {
                    out.println(CC.Welcome(user.username));
                }   */ 
            %>
          </ul>
        </div><!--close menubar-->	
        </nav>
    </header>
    
    <div id="site_content">
        
                  <%-- start web service invocation --%><hr/>
    <%
                java.util.List<org.chamerling.heroku.service.Post> result = null;
    try {
	org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
	org.chamerling.heroku.service.HelloServiceImpl port = service.getHelloServiceImplPort();
	// TODO process result here
	result = port.listPost();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }


            
            
            for (org.chamerling.heroku.service.Post p:result)
            {
              
                
                if(user.getusername.compareTo("guest")==0)
                {
                    if(p.getPublish()==1)
                    {
                        out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+ " " + "<br><a href=\"view_post.jsp?idPost="+p.getId()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                        out.println("<br><br><hr>");
                    }
                     
                }
                else if(user.role.compareTo("owner")==0)
                {
                    if(p.getPublish()==1)
                    {
                        out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+ " " +"<br><a href=\"view_post.jsp?idPost="+p.getId()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                        out.println("<div class=\"button_small\"> <a href=\"edit_post.jsp?idPost="+p.getId()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"soft_delete?idPost="+p.getId()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                        out.println("<br><br><hr>");
                    }
                     
                }
                else if(user.role.compareTo("editor")==0)
                {
                    if(p.getPublish()!=3)
                    {
                        out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+ " " +"<br><a href=\"view_post.jsp?idPost="+p.getId()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                        out.println("<div class=\"button_small\"> <a href=\"edit_post.jsp?idPost="+p.getId()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"soft_delete?idPost="+p.getId()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                        if(p.getPublish()==1)
                        {
                            out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getId()+"\">UnPublish</a> </div>");
                        }
                        else if(p.getPublish()==0)
                        {
                            out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getId()+"\">Publish</a> </div>");
                        }
                        out.println("<br><br><hr>");                                            
                    }
                }
                else if(user.role.compareTo("admin")==0)
                {
                    out.println("<div class = \"content_item\"><p><br>"+ p.getTanggal()+ " " +"<br><a href=\"view_post.jsp?idPost="+p.getId()+"\"></p><h1>"+p.getJudul()+ "</h1></a> <br><p>"+p.getKonten() + "</div></p>");
                    out.println("<div class=\"button_small\"><a href=\"edit_post.jsp?idPost="+p.getId()+"\">Edit</a> </div> <div class=\"button_small\"><a href=\"delete_post?idPost="+p.getId()+"\" onclick=\"return window.confirm('Apakah Anda yakin menghapus post ini?')\">Delete</a></div>");
                    if(p.getPublish()==3)
                    {
                        out.println("<div class=\"button_small\"> <a href=\"restore?idPost="+p.getId()+"\">Restore</a> </div>");
                    }
                    else
                    {
                        out.println("<div class=\"button_small\"> <a href=\"soft_delete?idPost="+p.getId()+"\">Soft Delete</a> </div>");
                    }
                    if(p.getPublish()==1)
                    {
                        out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getId()+"\">UnPublish</a> </div>");
                    }
                    else if(p.getPublish()==0)
                    {
                        out.println("<div class=\"button_small\"> <a href=\"publish?idPost="+p.getId()+"\">Publish</a> </div>");
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