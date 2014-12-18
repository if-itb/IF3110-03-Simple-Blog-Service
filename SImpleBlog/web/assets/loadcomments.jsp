<%-- 
    Document   : loadcomments
    Created on : Nov 24, 2014, 9:39:46 PM
    Author     : Sakurai
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%
    if (request.getParameter("ID") != null) {
        Connection connection = null; 
        Statement stmt = null;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/blog";
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection(connectionURL, "root", "");
            stmt = connection.createStatement();
            String query = "Select * From comment where PostID = " + Integer.parseInt(request.getParameter("ID")) + ";";
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                String name = result.getString("Nama");
                
                String comment = result.getString("Komentar");
                String date = result.getString("Tanggal");
                out.println("<li class=\"art-list-item\">");
		out.println("<div class=\"art-list-item-title-and-time\">");
		out.println("<h2 class=\"art-list-title\">" + name +"</h2>");
		out.println("<div class=\"art-list-time\">" + date + "</div>");
		out.println("</div>");
		out.println("<p>");
		out.println(comment);
		out.println("</p>");
		out.println("</li>");
            }
            connection.close();
        }catch(Exception ex){
            System.out.println("cannot connect to database");
        }
   
//    try {
//	service.Service_Service service = new service.Service_Service();
//	service.Service port = service.getServicePort();
//	 // TODO initialize WS operation arguments here
//	java.lang.String id = request.getParameter("ID");
//	java.lang.String nama = "";
//	java.lang.String email = "";
//	java.lang.String komentar = "";
//                out.println("<li class=\"art-list-item\">");
//		out.println("<div class=\"art-list-item-title-and-time\">");
//		out.println("<h2 class=\"art-list-title\">" + nama +"</h2>");
////		out.println("<div class=\"art-list-time\">" + date + "</div>");
//		out.println("</div>");
//		out.println("<p>");
//		out.println(komentar);
//		out.println("</p>");
//		out.println("</li>");
//	java.lang.String result = port.addComment(id, nama, email, komentar);
//	out.println("Result = "+result);
//    } catch (Exception ex) {
//	// TODO handle custom exceptions here
//        }
    }
%>
