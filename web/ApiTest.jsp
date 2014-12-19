<%-- 
    Document   : ApiTest
    Created on : 17-Dec-2014, 17:57:20
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.github.fawwaz.heroku.service.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>
            <% 
            Api api = new ApiImplService().getApiImplPort();
            // INSERT USER
            //out.println(api.createUser("anumu", "anumu@gemail.com", "ppassword", "owner"));
            //out.println(api.createPost("Judul", "Deadline ne opo", "12-12-2014", "admin"));
            
            // LIST USER
            
            /*
            List<User> users = api.getAllUser();
            
            out.print("<ol>");
            for(User user : users){
                out.print("<li>");
                out.print(user.getUsername()+ "<br>");
                out.print(user.getPassword()+ "<br>");
                out.print(user.getEmail()+ "<br>");
                out.print(user.getRole()+ "<br>");
                out.print("</li>");
            }
            out.print("</ol>");
            */
            
            // UPDATE USER
            
            // Delete USER
            //out.println(api.createUser("ngetes", "ngetes@email.com", "Asal Ngetes", "admin"));
            //api.deleteUser("anumu");
            
            
            // CREATE POST
            //out.print(api.addPost("Content post", "20-12-2014", "Title of post", "Username who write the post"));
            //out.print(api.addPost("Another Post Content", "14-12-2014", "Another Title of post", "geraldi"));
            
            // LIST POST
            /*
            List<Post> posts = api.getAllPost();
            
            out.print("<ol>");
            for(Post post : posts){
                out.print("<li>");
                out.print("Title : "+post.getTitle() + "<br/>");
                out.print("Date : "+post.getDate()+ "<br/>");
                out.print("Content : "+post.getContent() + "<br>");
                out.print("IdPost : "+post.getIdPost()+ "<br>");
                out.print("Author : "+post.getUsername()+ "<br>");
                
                out.print("</li>");
            }
            out.print("</ol>");
            */
            
            // UPDATE POST
            //out.print(api.updatePost("-JdQ5G_EN_0pXISOLFx1", "Title Anyar", "Kontene opo", "Adadfasdf", "koji"));
            
            // Delete POST
            //out.print(api.addPost("Post untuk ditambah", "19-12-2014", "Tobe Deleted", "author"));
            //api.deletePost(arg0)
            
            // Add comment
            //api.addComment("-JdQ5G_EN_0pXISOLFx1", "Judul", "Konten komentar", "12-12.2014", "email@email.com");
            
            
            // List comment
            
            
            // Delete Comment
            %>
            
        </h1>
    </body>
</html>
