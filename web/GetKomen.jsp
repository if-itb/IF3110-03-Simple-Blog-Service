<%-- 
    Document   : GetKomen
    Created on : Nov 19, 2014, 5:12:50 PM
    Author     : Asus
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.lang.Math "%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%!
    public String DeltaTimeConvert(String t2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
<<<<<<< HEAD
=======
        SimpleDateFormat show = new SimpleDateFormat("yyyy-MM-dd");
>>>>>>> fd6bdb627c77f7c6ee4f5d3db1b35d4c62737913
        Date d1 = new Date();
        Date d2 = new Date();
        try{
            d2 = format.parse(t2);
        }catch (ParseException e){
            
        }
        
        
        long t = d1.getTime() - d2.getTime();
        
<<<<<<< HEAD
        if(t<60){
			return (t+" detik yang lalu");
		}else if(t<3600){
			long newt = Math.round(t/60);
			return  (newt+" menit yang lalu");
		}else if(t<=86400){
			long newt = Math.round(t/3600);
			return (newt+" jam yang lalu");
		}else{
			return t2;
=======
        if(t<60000){
			return (t+" detik yang lalu");
		}else if(t<3600000){
			long newt = Math.round(t/60000);
			return  (newt+" menit yang lalu");
		}else if(t<=86400000){
			long newt = Math.round(t/3600000);
			return (newt+" jam yang lalu");
		}else{
			return show.format(d2);
>>>>>>> fd6bdb627c77f7c6ee4f5d3db1b35d4c62737913
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
<<<<<<< HEAD
    <%! String d; %>
    <%  d = pageContext.getAttribute("row.tanggal").toString(); %>
=======
    <c:set var="myTest" value="${row.tanggal}"/>
    <%! String d; %>
    <%  d =  pageContext.getAttribute("myTest").toString(); %>
>>>>>>> fd6bdb627c77f7c6ee4f5d3db1b35d4c62737913
    <%= d %>
    
    <li class="art-list-item">
                    <div class="art-list-item-title-and-time">
                        <h2 class="art-list-title"><a href="post.jsp"><c:out value='${row.nama}'/></a></h2>
<<<<<<< HEAD
                        <div class="art-list-time"><c:out value='${row.tanggal}'/></div>
=======
                        <div class="art-list-time"><%= DeltaTimeConvert(d)%></div>
>>>>>>> fd6bdb627c77f7c6ee4f5d3db1b35d4c62737913
                    </div>
                    <p><c:out value='${row.isi}'/></p>
    </li>
</c:forEach>
   
</body>

