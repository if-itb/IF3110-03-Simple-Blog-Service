<%-- 
    Document   : AddPost
    Created on : Nov 18, 2014, 10:09:54 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/tucildb_13511097"
     user="root"  password=""/>
<c:choose>
       <c:when test="${param.mode=='0'}"> <!--  insert new post-->
            <%! int new_id = 0; 
                ResultSet rs;
            %>
            <%
                String old_id = request.getParameter("id_post");
                Statement statement = null;
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                String DB_URL = "jdbc:mysql://localhost/tucildb_13511097";
                String USER = "root";
                String PASS = "";
                Connection conn = null;
                
                conn = DriverManager.getConnection(DB_URL,USER, PASS);
                statement = conn.createStatement();
            %>
          
            <%while ( true){   
                try {
                String sql = "SELECT * FROM `tucildb_13511097`.`listpost` WHERE `id`="+new_id;
                rs = statement.executeQuery(sql);
                
                if (!rs.isBeforeFirst()){ //kosong
                    break;
		}
		else{
                    new_id++;
		}
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }%>   
          
         <sql:update dataSource="${snapshot}" var="result">
            INSERT INTO `tucildb_13511097`.`listpost` (`id`,`title`,`date`,`post`) 
					VALUES ( <%= new_id %>,
							'<%= request.getParameter("Judul")%>',
							'<%= request.getParameter("Tanggal")%>',
							'<%= request.getParameter("Konten")%>');
         </sql:update>
      </c:when>

      <c:otherwise>
          <c:choose>
              <c:when test="${param.mode=='1'}"> <!-- edit post-->
              <sql:update dataSource="${snapshot}" var="count">
                UPDATE `tucildb_13511097`.`listpost` SET `title`='<%= request.getParameter("Judul")%>',`date`='<%= request.getParameter("Tanggal")%>',`post`='<%= request.getParameter("Konten")%>' WHERE `id`=<%= request.getParameter("id_post")%>;
              </sql:update>
          </c:when>

          <c:otherwise> <!-- berarti mode=2 , delete-->
              <sql:update dataSource="${snapshot}" var="result">
                    DELETE FROM `tucildb_13511097`.`listpost` WHERE `id`= <%= request.getParameter("id_post")%>;
              </sql:update>
              <sql:update dataSource="${snapshot}" var="result">
                    DELETE FROM `tucildb_13511097`.`post-komen` WHERE `id_post`= <%= request.getParameter("id_post")%>;
              </sql:update>
          </c:otherwise>
          </c:choose>
          
      </c:otherwise>
</c:choose>
     
          
          <% response.sendRedirect("index.jsp"); %>
