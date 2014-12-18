<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleSimpleblogProxyid" scope="session" class="simpleblog.service.endpoint.SimpleblogProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleSimpleblogProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleSimpleblogProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleSimpleblogProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        simpleblog.service.endpoint.Simpleblog_PortType getSimpleblog_PortType10mtemp = sampleSimpleblogProxyid.getSimpleblog_PortType();
if(getSimpleblog_PortType10mtemp == null){
%>
<%=getSimpleblog_PortType10mtemp %>
<%
}else{
        if(getSimpleblog_PortType10mtemp!= null){
        String tempreturnp11 = getSimpleblog_PortType10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        boolean publishPost13mtemp = sampleSimpleblogProxyid.publishPost(arg0_1idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(publishPost13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 18:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg031");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        simpleblog.service.endpoint.Post getPost18mtemp = sampleSimpleblogProxyid.getPost(arg0_2idTemp);
if(getPost18mtemp == null){
%>
<%=getPost18mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(getPost18mtemp != null){
java.lang.String typestatus21 = getPost18mtemp.getStatus();
        String tempResultstatus21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatus21));
        %>
        <%= tempResultstatus21 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">konten:</TD>
<TD>
<%
if(getPost18mtemp != null){
java.lang.String typekonten23 = getPost18mtemp.getKonten();
        String tempResultkonten23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typekonten23));
        %>
        <%= tempResultkonten23 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">tanggal:</TD>
<TD>
<%
if(getPost18mtemp != null){
java.lang.String typetanggal25 = getPost18mtemp.getTanggal();
        String tempResulttanggal25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetanggal25));
        %>
        <%= tempResulttanggal25 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">judul:</TD>
<TD>
<%
if(getPost18mtemp != null){
java.lang.String typejudul27 = getPost18mtemp.getJudul();
        String tempResultjudul27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typejudul27));
        %>
        <%= tempResultjudul27 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getPost18mtemp != null){
java.lang.String typeid29 = getPost18mtemp.getId();
        String tempResultid29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeid29));
        %>
        <%= tempResultid29 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 33:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg036");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        simpleblog.service.endpoint.Post[] search33mtemp = sampleSimpleblogProxyid.search(arg0_3idTemp);
if(search33mtemp == null){
%>
<%=search33mtemp %>
<%
}else{
        String tempreturnp34 = null;
        if(search33mtemp != null){
        java.util.List listreturnp34= java.util.Arrays.asList(search33mtemp);
        tempreturnp34 = listreturnp34.toString();
        }
        %>
        <%=tempreturnp34%>
        <%
}
break;
case 38:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg041");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        String arg1_5id=  request.getParameter("arg143");
            java.lang.String arg1_5idTemp = null;
        if(!arg1_5id.equals("")){
         arg1_5idTemp  = arg1_5id;
        }
        String arg2_6id=  request.getParameter("arg245");
            java.lang.String arg2_6idTemp = null;
        if(!arg2_6id.equals("")){
         arg2_6idTemp  = arg2_6id;
        }
        String arg3_7id=  request.getParameter("arg347");
            java.lang.String arg3_7idTemp = null;
        if(!arg3_7id.equals("")){
         arg3_7idTemp  = arg3_7id;
        }
        boolean editPost38mtemp = sampleSimpleblogProxyid.editPost(arg0_4idTemp,arg1_5idTemp,arg2_6idTemp,arg3_7idTemp);
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(editPost38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
break;
case 49:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg052");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        String arg1_9id=  request.getParameter("arg154");
            java.lang.String arg1_9idTemp = null;
        if(!arg1_9id.equals("")){
         arg1_9idTemp  = arg1_9id;
        }
        String arg2_10id=  request.getParameter("arg256");
            java.lang.String arg2_10idTemp = null;
        if(!arg2_10id.equals("")){
         arg2_10idTemp  = arg2_10id;
        }
        String arg3_11id=  request.getParameter("arg358");
            java.lang.String arg3_11idTemp = null;
        if(!arg3_11id.equals("")){
         arg3_11idTemp  = arg3_11id;
        }
        boolean addComment49mtemp = sampleSimpleblogProxyid.addComment(arg0_8idTemp,arg1_9idTemp,arg2_10idTemp,arg3_11idTemp);
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addComment49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
break;
case 60:
        gotMethod = true;
        simpleblog.service.endpoint.User[] listUser60mtemp = sampleSimpleblogProxyid.listUser();
if(listUser60mtemp == null){
%>
<%=listUser60mtemp %>
<%
}else{
        String tempreturnp61 = null;
        if(listUser60mtemp != null){
        java.util.List listreturnp61= java.util.Arrays.asList(listUser60mtemp);
        tempreturnp61 = listreturnp61.toString();
        }
        %>
        <%=tempreturnp61%>
        <%
}
break;
case 63:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg066");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        boolean deleteUser63mtemp = sampleSimpleblogProxyid.deleteUser(arg0_12idTemp);
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteUser63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
break;
case 68:
        gotMethod = true;
        String arg0_13id=  request.getParameter("arg071");
            java.lang.String arg0_13idTemp = null;
        if(!arg0_13id.equals("")){
         arg0_13idTemp  = arg0_13id;
        }
        String arg1_14id=  request.getParameter("arg173");
            java.lang.String arg1_14idTemp = null;
        if(!arg1_14id.equals("")){
         arg1_14idTemp  = arg1_14id;
        }
        String arg2_15id=  request.getParameter("arg275");
            java.lang.String arg2_15idTemp = null;
        if(!arg2_15id.equals("")){
         arg2_15idTemp  = arg2_15id;
        }
        String arg3_16id=  request.getParameter("arg377");
            java.lang.String arg3_16idTemp = null;
        if(!arg3_16id.equals("")){
         arg3_16idTemp  = arg3_16id;
        }
        boolean addUser68mtemp = sampleSimpleblogProxyid.addUser(arg0_13idTemp,arg1_14idTemp,arg2_15idTemp,arg3_16idTemp);
        String tempResultreturnp69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser68mtemp));
        %>
        <%= tempResultreturnp69 %>
        <%
break;
case 79:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg082");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        boolean deleteComment79mtemp = sampleSimpleblogProxyid.deleteComment(arg0_17idTemp);
        String tempResultreturnp80 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteComment79mtemp));
        %>
        <%= tempResultreturnp80 %>
        <%
break;
case 84:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg087");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        boolean deletePost84mtemp = sampleSimpleblogProxyid.deletePost(arg0_18idTemp);
        String tempResultreturnp85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deletePost84mtemp));
        %>
        <%= tempResultreturnp85 %>
        <%
break;
case 89:
        gotMethod = true;
        simpleblog.service.endpoint.Post[] listPost89mtemp = sampleSimpleblogProxyid.listPost();
if(listPost89mtemp == null){
%>
<%=listPost89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(listPost89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(listPost89mtemp);
        tempreturnp90 = listreturnp90.toString();
        }
        %>
        <%=tempreturnp90%>
        <%
}
break;
case 92:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg095");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        String arg1_20id=  request.getParameter("arg197");
            java.lang.String arg1_20idTemp = null;
        if(!arg1_20id.equals("")){
         arg1_20idTemp  = arg1_20id;
        }
        String arg2_21id=  request.getParameter("arg299");
            java.lang.String arg2_21idTemp = null;
        if(!arg2_21id.equals("")){
         arg2_21idTemp  = arg2_21id;
        }
        boolean addPost92mtemp = sampleSimpleblogProxyid.addPost(arg0_19idTemp,arg1_20idTemp,arg2_21idTemp);
        String tempResultreturnp93 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addPost92mtemp));
        %>
        <%= tempResultreturnp93 %>
        <%
break;
case 101:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0104");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        String arg1_23id=  request.getParameter("arg1106");
            java.lang.String arg1_23idTemp = null;
        if(!arg1_23id.equals("")){
         arg1_23idTemp  = arg1_23id;
        }
        String arg2_24id=  request.getParameter("arg2108");
            java.lang.String arg2_24idTemp = null;
        if(!arg2_24id.equals("")){
         arg2_24idTemp  = arg2_24id;
        }
        String arg3_25id=  request.getParameter("arg3110");
            java.lang.String arg3_25idTemp = null;
        if(!arg3_25id.equals("")){
         arg3_25idTemp  = arg3_25id;
        }
        String arg4_26id=  request.getParameter("arg4112");
            java.lang.String arg4_26idTemp = null;
        if(!arg4_26id.equals("")){
         arg4_26idTemp  = arg4_26id;
        }
        boolean editUser101mtemp = sampleSimpleblogProxyid.editUser(arg0_22idTemp,arg1_23idTemp,arg2_24idTemp,arg3_25idTemp,arg4_26idTemp);
        String tempResultreturnp102 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(editUser101mtemp));
        %>
        <%= tempResultreturnp102 %>
        <%
break;
case 114:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0117");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        simpleblog.service.endpoint.Comment[] listComment114mtemp = sampleSimpleblogProxyid.listComment(arg0_27idTemp);
if(listComment114mtemp == null){
%>
<%=listComment114mtemp %>
<%
}else{
        String tempreturnp115 = null;
        if(listComment114mtemp != null){
        java.util.List listreturnp115= java.util.Arrays.asList(listComment114mtemp);
        tempreturnp115 = listreturnp115.toString();
        }
        %>
        <%=tempreturnp115%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>