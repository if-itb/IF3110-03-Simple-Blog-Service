<%-- 
    Document   : view_post
    Created on : Nov 25, 2014, 1:03:30 PM
    Author     : M. Reza Irvanda
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,blogutil.*,blog.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>

    <head>
        <link rel="stylesheet" type="text/css" href="assets/css/screen.css">
        <title>View Post</title>
    </head>

    <body class="default">
        <div class="wrapper">

            <nav class="nav">
                <a style="border:none;" id="logo" href="view_post.jsp"><h1>Simple<span>-</span>Blog</h1></a>
                <ul class="nav-primary">
                    <li><a href="new_post.jsp">+ Tambah Post</a></li>
                </ul>
            </nav>
            <div id="home">
                <div class="posts">
                    <nav class="art-list">
                        <ul class="art-list-body">
                            <%
                                Cookie cookie = null;
                                Cookie[] cookies = request.getCookies();

                                if (cookies != null) {

                                    for (Cookie tmp : cookies) {
                                        if (tmp.getName().equalsIgnoreCase("role")) {
                                            if (tmp.getValue().equalsIgnoreCase("admin")) {
                                                break;
                                            } else {
                                                out.println("Harus login sebagai admin dulu");
                                            }
                                        }
                                    }
                                    ArrayList<Post> list = (ArrayList) SimpleBlogService.listDeletedPost();
                                    for (Post post : list) {
                            %>
                            <li class="art-list-item">
                                <div class="art-list-item-title-and-time">
                                    <h2 class="art-list-title"><a href="view_singular_post.jsp?posts=<% out.print(post.getId()); %>"> <% out.print(post.getJudul());%></a></h2>
                                    <div class="art-list-time"> <% out.print(post.getTanggal());%> </div>
                                    <div class="art-list-time"> <% out.print(post.getAuthor());%> </div>
                                </div>
                                <p style="max-height: 150pt"><% out.print(post.getKonten());%></p>
                                <p>
                                    <a href="restore.jsp?post=<% out.print(post.getId());%>">Restore</a> | <a href="delete.jsp?post=<% out.print(post.getId());%>">Hapus</a>
                                </p>
                            </li>
                            <%
                                    }
                                } else {
                                    out.println("Anda harus login sebagai admin terlebih dahulu");
                                }

                            %>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </body>
</html>