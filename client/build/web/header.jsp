<%-- 
    Document   : header.jsp
    Created on : Nov 25, 2014, 9:50:13 PM
    Author     : muntahailmi
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%!
    public String DtoS(Long l) {
        Date d = new Date(l);
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        String ConvD = ft.format(d);
        String[] arrS = ConvD.split("/");
        String month="";
        if(arrS[0]=="1" || arrS[0]=="01") month = "Januari";
        else if (arrS[0]=="2" || arrS[0]=="02") month = "Februari";
        else if (arrS[0]=="3" || arrS[0]=="03") month = "Maret";
        else if (arrS[0]=="4" || arrS[0]=="04") month = "April";
        else if (arrS[0]=="5" || arrS[0]=="05") month = "Mei";
        else if (arrS[0]=="6" || arrS[0]=="06") month = "Juni";
        else if (arrS[0]=="7" || arrS[0]=="07") month = "Juli";
        else if (arrS[0]=="8" || arrS[0]=="08") month = "Agustus";
        else if (arrS[0]=="9" || arrS[0]=="09") month = "September";
        else if (arrS[0]=="10") month = "Oktober";
        else if (arrS[0]=="11") month = "November";
        else if (arrS[0]=="12") month = "Desember";
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

<nav class="nav">
    <a style="border:none;" id="logo" href="index.jsp"><h1>Simple-Blog<span>-of-</span>Bang-Satya-Ilmi-Ojan</h1></a>
    <ul class="nav-primary">
    <%
    	if (typeC==4){
			out.println("Halo, Guest");
			if (request.getParameter("errormessage")!=null) {
		        out.println("<br/>Username/password anda salah");
		    }
			%>
			<form method="post" action="login_handler.jsp">
		        <div>
		        <input type="text" name="username" id="username" value="" placeholder="username">
		        </div>
		        <div>
		        <input type="password" name="password" id="password" value="" placeholder="password">
		        <input type="submit" name="submit" value="Login" class="submit-button">
		    	</div>
		    </form>
			<%
    	} else {
    		if (typeC==1){
    			out.println("Halo, Owner "+usrC);
        		%>
	            <li></li><li><a href="handler/logout.jsp">Logout</a></li>
		        <br/>
		        <li><a href="new_post.jsp">+ Tambah Post</a></li>
	        	<%
    		} else if (typeC==2){
    			out.println("Halo, Editor "+usrC);
        		%>
                <li></li><li><a href="handler/logout.jsp">Logout</a></li>
		        <br/>
		        <li><a href="postAdm.jsp">+ Unpublished Post</a></li>
            	<%
    		} else if (typeC==3){
    			out.println("Halo, Admin "+usrC);
        		%>
                <li></li><li><a href="handler/logout.jsp">Logout</a></li>
		        <br/>
		        <li><a href="add_user.jsp">+ Tambah User</a></li>
		        <li><a href="userAdm.jsp">+ Manage User</a></li>
		        <br/>
		        <li><a href="new_post.jsp">+ Tambah Post</a></li>
		        <li><a href="postAdm.jsp">+ Unpublished Post</a></li>
            	<%
    		}
    	}
    %>
        <%--<br/>
        <li><a href="new_post.jsp">+ Tambah Post</a></li>
        <li><a href="admin.jsp">+ Unpublished Post</a></li> --%>
    </ul>
    <a name="top"></a>
</nav>