<%-- 
    Document   : manage_user
    Created on : 22-Nov-2014, 22:08:23
    Author     : Asus
--%>

<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
    String action = StringUtils.isNullOrEmpty(request.getParameter("action")) ? "" : request.getParameter("action");
        
    if(action.equals("create")){
%>
<!DOCTYPE html>
<html>
    <head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">

<!-- Twitter Card -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="omfgitsasalmon">
<meta name="twitter:title" content="Simple Blog">
<meta name="twitter:description" content="Deskripsi Blog">
<meta name="twitter:creator" content="Simple Blog">
<meta name="twitter:image:src" content="{{! TODO: ADD GRAVATAR URL HERE }}">

<meta property="og:type" content="article">
<meta property="og:title" content="Simple Blog">
<meta property="og:description" content="Deskripsi Blog">
<meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}">
<meta property="og:site_name" content="Simple Blog">

<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Simple Blog | Sign Up</title>


</head>

<body class="default" onload="showKomen(${param.id_post})" onscroll="OnScrollDiv(this)">
<div class="wrapper">
  
<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="mainpage.jsp">Home</a></li>
    </ul>
</nav>
    <h4 class="art-title" style="margin-bottom:40px">-</h4>

    <div class="art-body">
        <div class="art-body-inner">
        <h4>REgistrasi pengguna baru</h4>
        <form action="process_manage_user.jsp" method="POST">
            <p>Username :<input type="text" name="username"/></p>
            <p>Password : <input type="password" id="password" name = "password"/></p>
             <p>Pass(re-entry) : <input type="password" id="re-password" onkeyup ="cekPass()"/></p>
             <p>Email : <input type="text" id="email" name ="email" onkeyup ="checkEmail()"/></p>
             <div id="err"></div>
            <p>Role: <select name="role">
                <option value="owner" >owner</option>
                <option value="admin">admin</option>
                <option value="editor">editor</option>
                </select></p>
                <p><input type="submit" value="Buat" id = "submit" disabled="true"></p>
                <input type="hidden" name="action" value="create">
        </form>
        </div>
    </div>
    </body>
</html>
<%
    }else if(action.equals("update")){
        String userid = request.getParameter("userid");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/tucildb_13511097";
        Connection con = DriverManager.getConnection(url,"root", "");
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("select * from user where id='" + userid + "'");
        
        if(rs.next()){
            
            
        %>
<!DOCTYPE html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">

<!-- Twitter Card -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="omfgitsasalmon">
<meta name="twitter:title" content="Simple Blog">
<meta name="twitter:description" content="Deskripsi Blog">
<meta name="twitter:creator" content="Simple Blog">
<meta name="twitter:image:src" content="{{! TODO: ADD GRAVATAR URL HERE }}">

<meta property="og:type" content="article">
<meta property="og:title" content="Simple Blog">
<meta property="og:description" content="Deskripsi Blog">
<meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}">
<meta property="og:site_name" content="Simple Blog">

<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Simple Blog | Edit Profile</title>


</head>

<body class="default" onload="showKomen(${param.id_post})" onscroll="OnScrollDiv(this)">
<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="mainpage.jsp">Home</a></li>
    </ul>
</nav>
    
    <h4 class="art-title" style="margin-bottom:40px">-</h4>

    <div class="art-body">
        <div class="art-body-inner">
        <h4>Edit USer</h4>
        <form action="process_manage_user.jsp">
            <p>Username :<input type="text" name="username" value="<%out.print(rs.getString("username"));%>"/></p>
            <p>Password : <input type="password" id="password" name = "password" value="<%out.print(rs.getString("password"));%>"/></p>
             <p>Pass(re-entry) : <input type="password" id="re-password" onkeyup ="cekPass()"/></p>
             <p>Email : <input type="text" id="email" name="email" onkeyup ="checkEmail()" value="<%out.print(rs.getString("email"));%>"/></p>
             <div id="err"></div>
            
            <p>Role: 
                <select name="role">    
                    <option value="owner" <% out.print((rs.getString("role").equals("owner") ? "Selected" : ""));%>>owner</option>
                    <option value="admin" <% out.print((rs.getString("role").equals("admin") ? "Selected" : ""));%>>admin</option>
                    <option value="editor" <% out.print((rs.getString("role").equals("editor") ? "Selected" : ""));%>>editor</option>
                </select></p>
            <input type="hidden" name="userid" value="<%out.print(rs.getString("id"));%>">
            <input type="hidden" name="action" value="update">
            <p><input type="submit" id = "submit" disabled="true" value="Update !"></p>
            
        </form>
        </div>
    </div>
    </body>
</html>
<%    
        }else{
            out.print("Parameter id tidak Id Tidak Ditemukan....");
        }
    }else{
        %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Deskripsi Blog">
<meta name="author" content="Judul Blog">

<!-- Twitter Card -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="omfgitsasalmon">
<meta name="twitter:title" content="Simple Blog">
<meta name="twitter:description" content="Deskripsi Blog">
<meta name="twitter:creator" content="Simple Blog">
<meta name="twitter:image:src" content="{{! TODO: ADD GRAVATAR URL HERE }}">

<meta property="og:type" content="article">
<meta property="og:title" content="Simple Blog">
<meta property="og:description" content="Deskripsi Blog">
<meta property="og:image" content="{{! TODO: ADD GRAVATAR URL HERE }}">
<meta property="og:site_name" content="Simple Blog">

<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Simple Blog | User List</title>


</head>

<body class="default" onload="showKomen(${param.id_post})" onscroll="OnScrollDiv(this)">
<div class="wrapper">

<nav class="nav">
    <a style="border:none;" id="logo" href="mainpage.jsp"><h1>Simple<span>-</span>Blog</h1></a>
    <ul class="nav-primary">
        <li><a href="mainpage.jsp">Home</a></li>
    </ul>
</nav>
        
        <sql:setDataSource 
            var="snapshot" 
            driver="com.mysql.jdbc.Driver"             
            url="jdbc:mysql://localhost/tucildb_13511097"
            user="root"  
            password=""/>
        
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from user;
        </sql:query>
            
 <article class="art simple post">
    
    
    <h4 class="art-title" style="margin-bottom:40px">-</h4>

    <div class="art-body">
        <div class="art-body-inner">
            
        <h4>Manage User Pages</h4>
        <p><a href="manage_user.jsp?action=create">Create New User</a></p>
        <table border="1px">
            <tr>
                <td>User id</td>
                <td>Username</td>
                <td>Password</td>
                <td>Role</td>
                <td colspan="2">Action</td>
            </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.id}"/></td>
                <td><c:out value="${row.username}"/></td>
                <td><c:out value="${row.password}"/></td>
                <td><c:out value="${row.role}"/></td>
                <td><a href="manage_user.jsp?action=update&userid=<c:out value="${row.id}"/>">Edit</a></td>
                <td><a href="process_manage_user.jsp?action=delete&userid=<c:out value="${row.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </table>    
        </div>
    </div>
    </body>
</html>
<%
        
    }
    
%>

<footer class="footer">
    <div class="back-to-top"><a href="">Back to top</a></div>
    <!-- <div class="footer-nav"><p></p></div> -->
    <div class="psi">&Psi;</div>
    <aside class="offsite-links">
        Asisten IF3110 /
        <a class="rss-link" href="#rss">RSS</a> /
        <br>
        <a class="twitter-link" href="http://twitter.com/YoGiiSinaga">Yogi</a> /
        <a class="twitter-link" href="http://twitter.com/sonnylazuardi">Sonny</a> /
        <a class="twitter-link" href="http://twitter.com/fathanpranaya">Fathan</a> /
        <br>
        <a class="twitter-link" href="#">Renusa</a> /
        <a class="twitter-link" href="#">Kelvin</a> /
        <a class="twitter-link" href="#">Yanuar</a> /
        
    </aside>
</footer>

</div>

<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/fittext.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/respond.min.js"></script>

<script>
    function cekPass(){
        var pass1 = document.getElementById("password").value;
        var pass2 = document.getElementById("re-password").value;
        
        if (pass1!=pass2){
            document.getElementById("submit").disabled = true;
            document.getElementById("err").innerHTML = "input ulang password salah!";
        }else {
            document.getElementById("submit").disabled = false;
             document.getElementById("err").innerHTML = "ok";
        }
        
    }
    
    function checkEmail(){
				var err_email = document.getElementById("err");
				var emailStr = document.getElementById("email").value;
				var emailRegexStr = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
				var isValid = emailRegexStr.test(emailStr);
				if(!isValid){
					err_email.innerHTML = "alamat email tidak valid";
					document.getElementById("submit").disabled = true;
				}
				else{
					err_email.innerHTML = "";
					document.getElementById("submit").disabled = false;
				}
}
    
</script>
   
    


