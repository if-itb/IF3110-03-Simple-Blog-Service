<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!-- 
    Document   : index
    Created on : Nov 24, 2014, 4:14:48 PM
    Author     : adwisatya
-->

<%@page import = "classes.Client" %>
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

<title>Simple Blog of Bangsatya</title>
</head>

<body class="default">
<div class="wrapper">

<jsp:include page="../header.jsp"/>
<%!
    public String DtoS(Long l) {
        Date d = new Date(l);
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        String ConvD = ft.format(d);
        String[] arrS = ConvD.split("/");
        //out.println(arrS[0]+" "+arrS[1]+" "+arrS[2]);
        String month="";
        if(arrS[1].equals("1") || arrS[1].equals("01")) month = "Januari";
        else if (arrS[0].equals("2") || arrS[0].equals("02")) month = "Februari";
        else if (arrS[0].equals("3") || arrS[0].equals("03")) month = "Maret";
        else if (arrS[0].equals("4") || arrS[0].equals("04")) month = "April";
        else if (arrS[0].equals("5") || arrS[0].equals("05")) month = "Mei";
        else if (arrS[0].equals("6") || arrS[0].equals("06")) month = "Juni";
        else if (arrS[0].equals("7") || arrS[0].equals("07")) month = "Juli";
        else if (arrS[0].equals("8") || arrS[0].equals("08")) month = "Agustus";
        else if (arrS[0].equals("9") || arrS[0].equals("09")) month = "September";
        else if (arrS[0].equals("10")) month = "Oktober";
        else if (arrS[0].equals("11")) month = "November";
        else if (arrS[0].equals("12")) month = "Desember";
        String res = arrS[0]+" "+month+" "+arrS[2];
        return res;
    }
%>
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
	String keyword = request.getParameter("keyword");

	Client newCli = new Client();
	ArrayList<String> hasilGet = new ArrayList<String>();
	List<Post> lp = new ArrayList<Post>();
	hasilGet = (ArrayList<String>) newCli.search(keyword);
	for(int i=0; i<hasilGet.size(); i++) {
		Post p = Post.JSONtoPost(hasilGet.get(i));
		lp.add(p);
	}
	for(int i=0;i<lp.size();i++){
		//out.println(Cli.getPublishedPost().get(i));
		//Post p = Pot.JSONtoPost(Cli.getPublishedPost().get(i));
		Post p = lp.get(i);
%>

			<li class="art-list-item">
				<div class="art-list-item-title-and-time">
					<h2 class="art-list-title"><a href="../show_post.jsp?id=<% out.println(/*Cli.GetPublishedPost().get(i).id*/p.id); %>"><% out.println(/*Cli.GetPublishedPost().get(i).*/p.Judul); %></a></h2>
					<div class="art-list-time"><% out.println(/*Cli.GetPublishedPost().get(i)*/DtoS(p.Tanggal)); %></div>
					<div class="art-list-owner">Owner:&nbsp;<% out.println(/*Cli.GetPublishedPost().get(i)*/p.Owner); %></div>
				</div>
				<p><% out.println(/*Cli.getPublishedPost().get(i)*/p.Konten); %></p>
			</li>
<%
	}
%>
</ul>
        </nav>
    </div>
</div>

<jsp:include page="../footer.jsp"/>

</div>
<script>
    function ConfirmDelete(nomor)
    {
      var x = confirm("Apakah Anda yakin menghapus post ini?");
      if (x)
          return window.location.assign('../trashPost.jsp?id='+nomor);
      else
        return false;
    }
</script>

</body>
</html>