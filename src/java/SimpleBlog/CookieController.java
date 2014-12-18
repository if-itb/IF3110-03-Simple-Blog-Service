package SimpleBlog;

import javax.servlet.http.Cookie;

public class CookieController {
    public int FindUserCookie(Cookie[] cookies)
    {
        int i = 0;
        boolean found = false;
        if(cookies!=null)
        {
            while(i<cookies.length && !found)  
            {
                if(cookies[i].getName().equalsIgnoreCase("user"))
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
        }
        return i;
    }
    
    public String Welcome(String username)
    {
        return "<div id=\"login\">Selamat datang, "+username+" | <a href=\"logout\">Logout</a><div id=\"login\">";
    }
    
    public String LoginForm()
    {
        String line2 = "<div id=\"login\"><form name=\"loginform\" action=\"First\" method=\"post\">";
        String line3 = "<p> Username : <input type=\"text\" name=\"username\">";
        String line4 = " Password: <input name=\"password\" type=\"password\">";
        String line5 = "<input type=\"submit\" value=\"Submit\">";
        String line6 = "</form></div>";
        return line2 + line3 + line4 + line5 + line6;
    }
    
    public String SearchForm()
    {
        String line2 = "<div id=\"login\"><form name=\"searchform\" action=\"search_post.jsp\" method=\"get\">";
        String line3 = "<p> Search : <input type=\"text\" name=\"query\">";
        String line5 = "<input type=\"submit\" value=\"Search\">";
        String line6 = "</form></div>";
        return line2 + line3 + line5 + line6;
    }
}
