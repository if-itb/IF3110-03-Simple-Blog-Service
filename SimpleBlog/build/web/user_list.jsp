<%@page import="SimpleBlog.user"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SimpleBlog.CookieController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="javascript/komentar.js"></script> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="javascript/modernizr-1.5.min.js"></script>
        <title>Simple Blog - User List</title>
        
        <style>
          
           
        </style>
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
                
                user user = null;
                if(idx<cookies.length)
                {
                    //user=new User(username, " ", " ", sql.getRolebyUsername(username));
                }
                else
                {
                    user = new user("guest"," "," ","guest");
                }
                if(user.username.equalsIgnoreCase("guest"))
                {
                    out.println(CC.LoginForm());
                }
                else
                {
                    out.println(CC.Welcome(user.username));
                }
                if(!user.role.equalsIgnoreCase("admin"))
                {
                    response.sendRedirect("home.jsp");
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
                            <h2>Tambah User</h2>

                        <div id="contact-area">
                            <form method="POST" action="add_user" onSubmit="return checkemail()">
                                <label for="username">Username: </label>
                                <input type="text" name="username" id="username"><br>

                                <label for="pass">Password: </label>
                                <input type="text" name="pass" id="pass"><br>

                                <label for="Email">Email: </label>
                                <input type="text" name="Email" id="Email"><br>

                                <label for="role">Role: </label>
                                
                                <input type="radio" name="role" id="role1" value="owner" checked>
                                <h8>Owner</h8><br>
                               
                                <input type="radio" name="role" id="role2" value="editor">
                                <h8>Editor</h8><br>
                                
                                <input type="radio" name="role" id="role3" value="admin">
                                <h8>Admin</h8><br><br>
                                
                                
                              <center>  <input type="submit" name="submit" value="Simpan" class="submit-button"></center>
                            </form>
                        </div>
                    </div>
                </div>
            </article>
            
                <center><h7>LIST USER</h7></center>
            
            <%-- start web service invocation --%><hr/>
    <%
                java.util.List<org.chamerling.heroku.service.User> result = null;
    try {
	org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
	org.chamerling.heroku.service.HelloServiceImpl port = service.getHelloServiceImplPort();
	// TODO process result here
	result = port.listUser();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
                

                for (org.chamerling.heroku.service.User p:result)
                {

                        out.println("<div class = \"content_item\">");
                        out.println("<p>Password: "+p.getPW()+"</p>");
                        out.println("<div class=\"button_small\"> <a href=\"edit_user.jsp?username=" +"\">Edit</a> </div> <div class=\"button_small\"><a href=\"delete_user?idUser="+ 1 +"\">Delete</a></div>");
                        out.println("<br><br><br><hr>");
                        

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
