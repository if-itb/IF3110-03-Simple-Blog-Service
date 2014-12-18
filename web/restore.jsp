<%-- 
    Document   : deleteNonAdmin
    Created on : Nov 25, 2014, 11:29:57 PM
    Author     : M. Reza Irvanda
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blog.*,blogutil.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
    String idPost = request.getParameter("post");
    ArrayList<Post> list = (ArrayList) SimpleBlogService.listDeletedPost();
    for (Post post : list) {
        if(post.getId().equalsIgnoreCase(idPost)){
            if (SimpleBlogService.deletePost(idPost)) {
                SimpleBlogService.addPost(post.getJudul(), post.getKonten(), post.getTanggal(), post.getAuthor());
                String site = new String("view_post.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            }   
        }
        else{
            
        }
    }
%>
