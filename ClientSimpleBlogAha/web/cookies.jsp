<%-- 
    Document   : cookies
    Created on : Nov 24, 2014, 4:06:44 PM
    Author     : Teofebano
--%>


<html>
<head>
<title>Setting Cookies</title>
</head>
<body>
<%
   // Create cookies for username and pass.      
   Cookie username = new Cookie("username",session.getAttribute("username").toString());
   Cookie password = new Cookie("password",session.getAttribute("password").toString());
   String user=session.getAttribute("username").toString();
   String role=session.getAttribute("role").toString();
   

   // Set expiry date after 24 Hrs for both the cookies.
   username.setMaxAge(60*3); 
   password.setMaxAge(60*3); 

   // Add both the cookies in the response header.
   response.addCookie( username );
   response.addCookie( password );
   session.setAttribute("username",user);
   session.setAttribute("role",role);
   session.setAttribute("query","lalala");
   
   response.sendRedirect("home.jsp");
   
%>
</body>
</html>