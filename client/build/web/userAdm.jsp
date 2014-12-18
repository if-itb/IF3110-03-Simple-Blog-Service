<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!-- 
    Document   : index
    Created on : Nov 24, 2014, 4:14:48 PM
    Author     : adwisatya
-->
<%@include file= "/WEB-INF/jspf/koneksi.jspf" %>

<%@page import= "classes.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "classes.Post" %>
<%@page import= "classes.User" %>
<%@page import= "classes.Comment" %>
<%@page import = "java.io.*" %>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Simple Blog">
<meta name="author" content="Bangsatya">

<!-- Twitter Card -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="omfgitsasalmon">
<meta name="twitter:title" content="Simple Blog">
<meta name="twitter:description" content="Simple Blog">
<meta name="twitter:creator" content="Bangsatya Blog">
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

<title>Simple Blog of Bangsatya</title>
</head>

<body class="default">
<div class="wrapper">

<jsp:include page="header.jsp"/>
<%
	String usrC=" ";
	int typeC=4;
	Cookie[] cookies = null;
	cookies = request.getCookies();
	if (cookies!=null){
		for (Cookie c:cookies){
			if (c.getName().equals("LogName")){
				usrC=c.getValue();
				for (Cookie c2:cookies){
				    if (c2.getName().equals("LogType")){
							typeC=Integer.parseInt(c2.getValue());
						}
				}
			}
		}
	}
%>

<div id="home">
    <div class="posts">
        <nav class="art-list">
          <ul class="art-list-body">
			<%
			/*try{
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			Class.forName(xDRIVER);
			connection = DriverManager.getConnection(xSTRING,xUSERNAME,xPASSWORD);
			statement = connection.createStatement();
			String Data = "select * from users";
			rs = statement.executeQuery(Data);
			while(rs.next()){*/
                        Client cli = new Client();
                        List<String> ls = new ArrayList<String>();
                        ls = cli.getAllUser();
                        List<User> lu = new ArrayList<User>();
                        for(String S:ls) {
                            List<String> l = User.JSONtoUser(S);
			%>	
			<li class="art-list-item">
				<div class="art-list-item-title-and-time">
					<tr>
						<td><%=l.get(0)%></td>
						<td><%=l.get(1)%></td>
						<td><%=l.get(3)%></td>
					</tr>	
				</div>

				<p>
				<% if (typeC!=4){
				%>
					<a href="update_user.jsp?id=<%=l.get(0)%>">Edit</a> | <a href="#" onclick="return ConfirmDelete(<%=l.get(0)%>);">Hapus</a>
				<% } %>
				</p>
				
			</li>	
			<%
			}
			/*rs.close();
			statement.close();
			connection.close();
			}catch(Exception ex){
				out.println("Gagal tersambung. Terdaapat kesalahan.");
			}*/
			%>
          </ul>
        </nav>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</div>
<script>
    function ConfirmDelete(username)
    {
      var x = confirm("Apakah Anda yakin menghapus post ini?");
      if (x)
          return window.location.assign('handler/delete_user.jsp?user_username='+username);
      else
        return false;
    }
</script>

</body>
</html>
