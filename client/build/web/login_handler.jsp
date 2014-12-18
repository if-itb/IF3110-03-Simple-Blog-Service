<%-- 
    Document   : login_handler
    Created on : Nov 25, 2014, 10:07:57 PM
    Author     : USER
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="classes.Client"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%--
   	//Cookie Cusr = new Cookie(request.getParameter("username"),request.getParameter("password"));
	Cookie Cusr=new Cookie("LogName",request.getParameter("username"));
	Cookie CType=new Cookie("LogType",request.getParameter("username"));

	//Cookie Cpass = new Cookie("pass",request.getParameter("password"));
   
   Cusr.setMaxAge(60);
   //Cpass.setMaxAge(30000000);
   
   response.addCookie(Cusr);
   response.addCookie(CType);
   //response.addCookie(Cpass);
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
      
        <% String usr = request.getParameter("username");
           String pass = request.getParameter("password");
           Client Cli=new Client();
           List<String> ls = new ArrayList<String>();
           ls = Cli.login(usr,pass);
           int isvalid=1;
           if(ls.get(1).equalsIgnoreCase("0")) 
           {    
               isvalid=0;
           }
           /*else
           {
                Cookie Cusr=new Cookie("LogName",request.getParameter("username"));
                Cookie CType=new Cookie("LogType",request.getParameter("type"));
                Cusr.setMaxAge(60*60*24);
                CType.setMaxAge(60*60*24);
                Cusr.setPath("/");
                CType.setPath("/");
                response.addCookie(Cusr);
                response.addCookie(CType);
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "../index.jsp");
           }*/
           //String Query = "SELECT * FROM Tubes2WBD.users WHERE username=\""+usr+"\" AND password=\""+pass+"\""; 
           /*<sql:query dataSource="${Tubes2WBD}" var="result">
            </sql:query>*/
        %>
          <c:choose>
              <c:when test="<%= isvalid==1 %>">
                    <form method="post" action="handler/addCookie.jsp" id="successform">
                        <input type="hidden" name="username" id="username" value="<%= ls.get(0) %>">
                        <input type="hidden" name="type" id="type" value="<%= ls.get(1) %>">
                    </form>
                    <script>
                        document.getElementById("successform").submit();
                    </script>
                    <%--<c:redirect url="index.jsp"/> --%>
                </c:when>
                <c:otherwise>
                    <form method="post" action="index.jsp" id="errorform">
                        <input type="text" name="test" id="test" value="<%= isvalid %>">
                        <input type="hidden" name="errormessage" id="errormessage" value="errormessage">
                    </form>
                    <script>
                        document.getElementById("errorform").submit();
                    </script>
                </c:otherwise>
        </c:choose>
   	</body>
</html>
