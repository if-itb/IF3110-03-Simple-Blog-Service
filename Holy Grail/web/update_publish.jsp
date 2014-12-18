<%
try {
    ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
    ClientService.DatabaseService port = service.getDatabaseServicePort();
    java.lang.String id = request.getParameter("id");
    java.lang.Boolean result = port.publishPost(id);
} catch (Exception ex) {
}
%>
<%
try {
	ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
	ClientService.DatabaseService port = service.getDatabaseServicePort();
	 // TODO initialize WS operation arguments here
	// TODO process result here
	java.util.List<ClientService.Post> result = port.listPost("unpublished");
        for(ClientService.Post p : result)
        {
            %>
            <div class="post">
                <a href="post.xhtml?id=<%out.print(p.getId());%>" class="title">
                    <% out.println(p.getJudul()); %>
                </a>
                <div class="date-unpublished">
                    <% out.println(p.getTanggal()); %>
                </div>
                <div class="unpublished">
                    [unpublished]
                </div>
                <div class="content">
                    <% out.print(p.getKonten()); %>
                </div>
                    <a onclick="updatePost(<% out.print("'"+p.getId()+"'"); %>)">
                    [publish]
                </a>
            </div>
                    <%
        }
    } catch (Exception ex) {
    }
    %>
    