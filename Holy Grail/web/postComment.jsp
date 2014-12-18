    <%
    try {
	ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
	ClientService.DatabaseService port = service.getDatabaseServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String idPost = request.getParameter("id");
	java.lang.String nama = request.getParameter("Nama");
	java.lang.String email = request.getParameter("Email");
	java.lang.String komentar = request.getParameter("Komentar");
	// TODO process result here
	java.lang.Boolean result = port.addComment(idPost, nama, email, komentar);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>