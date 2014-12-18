    <%
    try {
	ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
	ClientService.DatabaseService port = service.getDatabaseServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String idPost = request.getParameter("id");
	// TODO process result here
	java.util.List<ClientService.Komentar> result = port.listComment(idPost);
        for(ClientService.Komentar k : result)
        {
            %>
            <li class="art-list-item">
                <div class="art-list-item-title-and-time">
                    <div class="art-list-title"> <% out.print(k.getNama()); %></div>
                    <div class="art-list-time"> <% out.print(k.getTanggal()); %></div>
                </div>
                <p><% out.print(k.getKomentar()); %></p>
            </li>
            <%
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>