<%-- 
    Document   : post
    Created on : Nov 25, 2014, 1:51:36 PM
    Author     : adwisatya
--%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import= "classes.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "classes.Post" %>
<%@page import= "classes.User" %>
<%@page import= "classes.Comment" %>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.Date" %>
<%@page import= "java.sql.*" %>
<%@page import= "java.util.ArrayList" %>
<%@page import= "javax.faces.bean.ManagedBean" %>
<%@page import= "javax.faces.bean.RequestScoped" %>
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
<jsp:include page="header.jsp"/>
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
        String res = arrS[1]+" "+month+" "+arrS[2];
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
                            String id = request.getParameter("id");
                            int i = Integer.parseInt(id);
                            Client cli = new Client();
                            Post q = new Post();
                            String s = cli.getPost(i);
                            Post p = new Post();
                            p = q.JSONtoPost(s);
                            
                            Date date = new Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            long l = p.Tanggal;
			%>
					<center>
					<table border=1 style="align:center" >
						<tr>
							<td colspan="2" align="center">
								<h4><% out.println(p.Judul); %></h4>
							</td>
						</tr>
						<tr>
							<td>
								<% out.println(DtoS(p.Tanggal)); %>
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<p><% out.println(p.Konten); %></p>
							</td>
						</tr>
						<tr>
							<% if (typeC!=4){ %>
							<td colspan="2">
							  <a href="edit.jsp?id=<% out.println(p.id); %>">Edit</a> | <a href="handler/delPost.jsp?id=<% out.println(p.id); %>">Hapus</a>
							</td>
							<% } %>
						</tr>
						<tr>

							<td colspan="2">
								<hr/>
								<div id="Komentar">
								</div>
								<hr/>
								<div id="formKomentar">
									<form method="post" action="#">
										Nama <input type="text" id="pNama" name="nama"><br/>
										Email <input type="text" id="pEmail" name="email" ><br/>
										Pesan<br/>
											<textarea id="pPesan" name="pesan" cols="84" rows="5"></textarea><br/>
											<input type="hidden" id="pTanggal" name="tanggal" value="<% out.println(sdf.format(date)); %>">
										<input type="hidden" id="pId" name="id" value="<% out.print(p.id); %>">
										<input type="button" name="postKomentar" value="Post Komentar" onclick="return cekEmail();">
									</form>
								</div>
							</td>
						</tr>
					</table>

				</center>
				<div id="terbaru" align="center">
					
				</div>
				<hr/>
				<!-- bagian komentar -->
					<div id="unit-komentar" align="center">
						<br/>
						<br/>
						</br>
						<hr/>
					</div>
			<% 
                                        Client Cli = new Client();
                                        Comment ce = new Comment();
                                        List<String> ls = Cli.getAllComment(p.id);
                                        List<Comment> lc = new ArrayList<Comment>();
                                        for(int j=0; j<ls.size(); j++) {
                                            Comment c = new Comment();
                                            c = Comment.JSONtoComment(ls.get(j));
                                            lc.add(c);
                                        }
                                        Collections.sort(lc);
                                        for(Comment C:lc) {
                                            out.println("<div id=\"unit-komentar\" align=\"center\">");
                                            out.println(C.Nama+"<br>");
                                            out.println(DtoS(C.Tanggal)+"<br>");
                                            out.println(C.Komentar+"<br>");
                                            out.println("<hr>");
                                            out.println("</div>");			
                                        }
					/*String Driver = "com.mysql.jdbc.Driver";
					String DbUser = "root";
					String DbPass = "";
					String DbName = "Tubes2WBD";
					String DbLoc1 = "jdbc:mysql://localhost:3306/";
					String DbLoc2 = DbLoc1+DbName;
					Connection conn = null;
					Statement st = null;
					ResultSet rs = null;

					try {
						Class.forName(Driver).newInstance();
						conn = DriverManager.getConnection(DbLoc2,DbUser,DbPass);
						st=conn.createStatement();
						rs=st.executeQuery("SELECT * FROM comment WHERE Parent ='"+request.getParameter("id")+"';");
						while(rs.next()){
							out.println("<div id=\"unit-komentar\" align=\"center\">");
							out.println(rs.getString("Name")+"<br>");
							out.println(rs.getString("Time")+"<br>");
							out.println(rs.getString("Content")+"<br>");
							out.println("<hr>");
							out.println("</div>");			
						}
					} catch(Exception e){
						throw e;
					} finally{
						try {
							rs.close();
							st.close();
							conn.close();
						} catch (SQLException e) {
							throw e;
						}
					}*/
				%>
          </ul>
        </nav>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</div>
<script>
function cekEmail() {
	var x = document.getElementById("pEmail").value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Email address salah");
        return false;
    }else{
		PostKomentar();
	}
}
function PostKomentar(){
	var isinama = document.getElementById("pNama").value;
	var isiemail = document.getElementById("pEmail").value;
	var isipesan = document.getElementById("pPesan").value;
	var isiid = document.getElementById("pId").value;
	var isitanggal	= document.getElementById("pTanggal").value;
	var xmlhttp=GetXmlHttpObject();
	if(xmlhttp==null){
		alert("Silahkan gunakan browser yang mendukung AJAX");
		return;
	}	
	var url	=	"post_komentar.jsp";
    var param="ID="+isiid+"&Name="+isinama+"&Email="+isiemail+"&Content="+isipesan;
	document.getElementById("terbaru").innerHTML = "Sedang memproses komentar";
	var message = "<div id=unit-komentar align=center><br>" + isinama + "<br>" + isitanggal + "<br>" + isipesan + "<hr></div>";
	document.getElementById("terbaru").innerHTML = message;
    xmlhttp.open("POST",url,true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length", param.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(param);
}

function GetXmlHttpObject() {
    var xmlhttp=null;
    try {
        // Firefox, Opera 8.0+, Safari
        xmlhttp=new XMLHttpRequest();
    }
    catch (e) {
        // Internet Explorer
        try {
            xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e) {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlhttp;
}
</script>
<script type="text/javascript" src="assets/js/fittext.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/respond.min.js"></script>
<script type="text/javascript">
  var ga_ua = '{{! TODO: ADD GOOGLE ANALYTICS UA HERE }}';

  (function(g,h,o,s,t,z){g.GoogleAnalyticsObject=s;g[s]||(g[s]=
      function(){(g[s].q=g[s].q||[]).push(arguments)});g[s].s=+new Date;
      t=h.createElement(o);z=h.getElementsByTagName(o)[0];
      t.src='//www.google-analytics.com/analytics.js';
      z.parentNode.insertBefore(t,z)}(window,document,'script','ga'));
      ga('create',ga_ua);ga('send','pageview');
</script>

</body>
</html>