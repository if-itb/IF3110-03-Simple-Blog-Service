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
        <script type="text/javascript" src="javascript/komentar.js"></script>
        <title>Simple Blog - Edit User</title>
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
                 if(!user.role.equalsIgnoreCase("admin"))
                {
                    response.sendRedirect("home.jsp");
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
        <article class="art simple post">  
            <h2 class="art-title" style="margin-bottom:40px">-</h2>

            <%
            String userparam = request.getParameter("username");
            org.chamerling.heroku.service.User user1 = sql.getSpesificUser(userparam);
            String ID = sql.getUserID(userparam);
        %>
        <div class="art-body">
            <div class="art-body-inner">
                <h2>Edit User</h2>

                <div id="contact-area">
                    <form method="POST" action="edit_user?idUser=<%out.print(ID);%>" onSubmit="return checkemail()">
                        <label for="Username">Username:</label>
                        <input type="text" name="username" id="username" value="<% out.println(user1.getUsername()); %>"><br>

                        <label for="Password">Password:</label>
                        <input type="text" name="password" id="password" value="<% out.println(user1.getPassword()); %>"><br>

                        <label for="Email">Email:</label>
                        <input type="text" name="Email" id="Email" value="<% out.println(user1.getEmail()); %>"><br>

                        <label for="role">Role: </label>
                                
                        <input type="radio" name="role" id="role1" value="owner" checked>
                        <h8>Owner</h8><br>

                        <input type="radio" name="role" id="role2" value="editor">
                        <h8>Editor</h8><br>

                        <input type="radio" name="role" id="role3" value="admin">
                        <h8>Admin</h8><br>
                        
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
