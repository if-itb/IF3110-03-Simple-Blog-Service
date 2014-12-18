<%-- 
    Document   : edit
    Created on : Nov 25, 2014, 12:18:41 AM
    Author     : adwisatya
--%>

<%@page import= "classes.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "classes.Post" %>
<%@page import= "classes.User" %>
<%@page import= "classes.Comment" %>
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

<title>Simple Blog of Bangsatya | Edit Post</title>


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

<article class="art simple post" style="margin-top:120px;">
        <div class="art-body" style="margin-top:70px">
        <div class="art-body-inner">
        	<%
        	if (typeC==4) {
        	%>
			You can't edit post
        	<% } else { %>
            <h2>Edit Post</h2>
			<%
				//PostBean pBean =  new PostBean();
                                Client cli = new Client();
				String id   = request.getParameter("id");
                                int i = Integer.parseInt(id);
                                Post q = new Post();
                                String s  = cli.getPost(i);
                                Post p = q.JSONtoPost(s);
			%>
            <div id="contact-area">
                <form method="post" action="handler/updatePost.jsp" onsubmit="return cekInputan()">
                    <label for="Judul">Judul</label>
                    <input type="text" name="judul" id="Judul" value="<% out.println(p.Judul); %>">
		
                    <label for="Tanggal">Tanggal:</label>
                    <input type="text" name="tanggal" id="Tanggal" placeholder="2015-12-29">
                    
                    <label for="Konten">Konten:</label><br>
                    <textarea name="konten" rows="20" cols="20" id="Konten"><% out.println(p.Konten); %></textarea>
					<input type="hidden" name="ID" id="ID" value=<% out.print(p.id); %>>
                    <input type="submit" name="submit" value="Simpan" class="submit-button">
                </form>
            </div>
			 <% } %>
        </div>
    </div>

</article>

<jsp:include page="footer.jsp"/>
</div>
<script>
function cekInputan(){    
    var judul = document.getElementById('Judul').value;
    var tanggal = document.getElementById('Tanggal').value;
    var konten = document.getElementById('Konten').value;
    
    if(judul=='' || tanggal =='' || konten =='')
    {
        alert('Silahkan lengkapi form yang tersedia');
	return false;
    }
    else
    {
        var date_arr = tanggal.split("-");
        var res = date_arr[2]+"/"+date_arr[1]+"/"+date_arr[0];
        var regex = /(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))/;
        if(!res.match(regex))
        {
            alert("Input tanggal tidak valid. Silakan input kembali!");
            return false;
        }
        else
        {
            var s_date = date_arr[1]+" "+date_arr[2]+" "+date_arr[0];
            var in_date = new Date(s_date);
            var now_date = new Date();
            if(in_date<=now_date)
            {
                alert("Input tanggal tidak valid. Silakan input kembali!");
                return false;
            }
        }
        return true;
    }
}
</script>

</body>
</html>