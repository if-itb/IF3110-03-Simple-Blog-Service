<%
try {
    ClientService.DatabaseService_Service service = new ClientService.DatabaseService_Service();
    ClientService.DatabaseService port = service.getDatabaseServicePort();
    java.lang.String id = request.getParameter("id");
    port.deleteUser(id);
    java.util.List<ClientService.User> result = port.listUser();
    for(ClientService.User u : result)
    {
        %>
        <tr>
            <td><% out.print(u.getUsername());%></td>
            <td><% out.print(u.getPassword());%></td>
            <td><% out.print(u.getEmail());%></td>
            <td><% out.print(u.getRole());%></td>
            <td>
                <a href="edit_user.xhtml?username=<% out.print(u.getUsername());%>" class="edit" id="edit"> edit </a> | <a onclick="deleteUser('<% out.print(u.getUsername());%>','<% out.print(u.getId()); %>')" class="delete"> delete </a>
            </td>
        </tr>
        <%
    }
} catch (Exception ex) {
}
%>
        