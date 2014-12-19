package SimpleBlog;

public class user {
    public String username;
    public String password;
    public String email;
    public String role;
    
    public user()
    {
        username=null;
        password=null;
        email=null;
        role=null;
    }
    
    public user(String _username, String _password, String _email, String _role)
    {
        username=_username;
        password=_password;
        email=_email;
        role=_role;
    }
    
    
    public void setUser(String _username, String _password, String _email, String _role)
    {
        username=_username;
        password=_password;
        email=_email;
        role=_role;
    }
}
