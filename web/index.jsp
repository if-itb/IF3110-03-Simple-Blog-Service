<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*,myServlet.TimeConverter;" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
    String action = (request.getParameter("action")==null ? "" : request.getParameter("action"));
    if(action.equals("logout")){
        
        session.setAttribute("username", "");
        session.setAttribute( "role", "guest" );
        session.setAttribute( "id_user", "-999");
        session.setAttribute( "email", "");
        session.setAttribute("firsttimer", "yes");
        
        Cookie[] cookies = request.getCookies();
        boolean c1=false,c2=false,c3=false,c4=false;
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("id_user")){
                   cookie.setValue("");
                   cookie.setMaxAge(-1);
                   response.addCookie(cookie);
                }

                if(cookie.getName().equals("username")){
                    cookie.setValue("");
                   cookie.setMaxAge(-1);
                   response.addCookie(cookie);
                }

                if(cookie.getName().equals("role")){
                    cookie.setValue("");
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                }
                

                if(cookie.getName().equals("email")){
                    cookie.setValue("");
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                }

                if(cookie.getName().equals("firsttimer")){
                    cookie.setValue("");
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                }
            }
        }
        session.setAttribute("firsttimer", "yes");
                
       // out.print("Logout");
    }else{
        
        Cookie[] cookies = request.getCookies();
        boolean c1=false,c2=false,c3=false,c4=false;
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("id_user") && !cookie.getValue().isEmpty()){
                    session.setAttribute( "id_user", cookie.getValue());
                    response.addCookie(cookie);
                    c1 = true;
                }

                if(cookie.getName().equals("username") && !cookie.getValue().isEmpty()){
                    session.setAttribute( "username", cookie.getValue());
                    response.addCookie(cookie);
                    c2 = true;
                }
                
                if(cookie.getName().equals("role") && !cookie.getValue().isEmpty()){
                    session.setAttribute( "role", cookie.getValue());
                    response.addCookie(cookie);
                    c3 = true;
                }

                if(cookie.getName().equals("email") && !cookie.getValue().isEmpty()){
                    session.setAttribute( "email", cookie.getValue());
                    response.addCookie(cookie);
                    session.setAttribute("firsttimer", "no");
                    c4 = true;
                }

                if(cookie.getName().equals("firsttimer") && !cookie.getValue().isEmpty()){
                    session.setAttribute("firsttimer", "no");
                    response.addCookie(cookie);
                }
                
                if(c1&&c2&&c3&&c4){
                    response.sendRedirect("mainpage.jspx");
                }
            }
        }
     //   out.print("halo");
    }
   session.setAttribute("firsttimer", "yes");
   response.sendRedirect("mainpage.jsp");
%>