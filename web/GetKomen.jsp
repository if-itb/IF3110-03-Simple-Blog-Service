<%-- 
    Document   : GetKomen
    Created on : Nov 19, 2014, 5:12:50 PM
    Author     : Asus
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.lang.Math,myServlet.TimeConverter "%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%!
    public String DeltaTimeConvert(String t2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat show = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date();
        Date d2 = new Date();
        try{
            d2 = format.parse(t2);
        }catch (ParseException e){
            
        }
        
        
        long t = d1.getTime() - d2.getTime();
        
        if(t<60000){
                        long newt = Math.round(t/1000);
			return (newt+" detik yang lalu");
		}else if(t<3600000){
			long newt = Math.round(t/60000);
			return  (newt+" menit yang lalu");
		}else if(t<=86400000){
			long newt = Math.round(t/3600000);
			return (newt+" jam yang lalu");
		}else{
                    TimeConverter tc = new TimeConverter();
			return tc.ConvertDate(show.format(d2));
		}
    }
%>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM `tucildb_13511097`.`post-komen` WHERE `id_post`=<%= request.getParameter("id")%> ORDER BY `tanggal` DESC;
</sql:query> 


<body>
<ul class="art-list-body">
<c:forEach var="row" items="${result.rows}">
    <c:set var="myTest" value="${row.tanggal}"/>
    <%! String d; %>
    <%  d =  pageContext.getAttribute("myTest").toString(); %>
    
    <li class="art-list-item">
                    <div class="art-list-item-title-and-time">
                        <h2 class="art-list-title"><a href="post.jsp"><c:out value='${row.nama}'/></a></h2>
                        <div class="art-list-time"><%= DeltaTimeConvert(d)%></div>
                    </div>
                    <p><c:out value='${row.isi}'/></p>
                    <%if (request.getParameter("role").toString().equals("admin")) { %>
                    <p> <a href="editKomen.jsp?id= <c:out value='${row.myID}'/>">Edit Komen</a> | <a href="javascript:ConfirmDelete(<c:out value='${row.myID}'/>)">Hapus</a> </p>
                    <%}%>
    </li>
</c:forEach>
   
</body>


