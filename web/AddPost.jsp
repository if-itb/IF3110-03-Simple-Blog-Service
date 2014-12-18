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



    <%! String id_user; %>
    <%  id_user =  session.getAttribute("id_user").toString(); %>
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
    
<c:choose>
       <c:when test="${param.mode=='0'}"> <!--  insert new post-->
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
            INSERT INTO `tucildb_13511097`.`listpost` (`id`,`id_user`,`title`,`date`,`post`,`published`) 
					VALUES ( <%= new_id %>,
                                                        <%= id_user %>,
							'<%= request.getParameter("Judul")%>',
							'<%= request.getParameter("Tanggal")%>',
							'<%= request.getParameter("Konten")%>',
                                                        'f');
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
              <% 
              try {
                String sql = "DELETE FROM `tucildb_13511097`.`listpost` WHERE `id`= "+old_id;
                String sql2 = "SELECT * FROM `tucildb_13511097`.`post-komen` WHERE `id_post`= "+old_id;
                
                rs = statement.executeQuery(sql2);
                if (rs.isBeforeFirst()){
                    sql2 = "DELETE FROM `tucildb_13511097`.`post-komen` WHERE `id_post`= "+old_id;
                    statement.executeUpdate(sql2);
                }
                statement.executeUpdate(sql);
                
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
              %>
              
          </c:otherwise>
          </c:choose>
          
      </c:otherwise>
</c:choose>
     
          
          <% response.sendRedirect("mainpage.jsp"); %>
