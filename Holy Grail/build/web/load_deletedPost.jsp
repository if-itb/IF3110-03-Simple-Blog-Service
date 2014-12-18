<%
try {
	ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
	ClientService.DatabaseService port = service.getDatabaseServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String postStatus = "";
	// TODO process result here
	java.util.List<ClientService.Post> result = port.listPost("deleted");
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
                    [deleted]
                </div>
                <div class="content">
                    <% out.print(p.getKonten()); %>
                </div>
                    <a onclick="updatePost(<% out.print("'"+p.getId()+"'"); %>)">
                    [Restore]
                </a>
            </div>
                    <%
        }
    } catch (Exception ex) {
    }
    %>
