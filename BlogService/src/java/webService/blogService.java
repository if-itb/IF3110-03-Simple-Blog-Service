/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author akhfa
 */
@WebService(serviceName = "blogService")
@Stateless()
public class blogService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
        URL url = new URL(urlString);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read); 

        return buffer.toString();
    } finally {
        if (reader != null)
            reader.close();
    }
}
    
    public static void main(String [] args)
    {
        
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public String addUser(@WebParam(name = "username") String username, @WebParam(name = "nama") String nama, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        //TODO write your implementation code here:
        blogService service = new blogService();
        try {
            //System.out.println(service.readUrl("https://resplendent-heat-7949.firebaseio.com/user.json"));
            //System.out.println(service.readUrl("https://simpleblog5.firebaseio.com/post.json"));
            //User user = new User("usernameAkhfa", "passwordAkhfa", "namaAkhfa", "emailAkhfa", "roleAkhfa");
            //User user2 = new User("username2Akhfa", "password2Akhfa", "nama2Akhfa", "email2Akhfa", "role2Akhfa");
            
            Firebase ref = new Firebase("https://if3110-4.firebaseio.com/");
            Firebase userRef = ref.child("user");
            Map <String, String> users = new HashMap<>();
            users.put("username", username);
            users.put("password", password);
            users.put("nama", nama);
            users.put("email", email);
            users.put("role",role);
            userRef.push().setValue(users);
            
            //ObjectMapper mapper = new ObjectMapper();
            //User user1 = mapper.readValue(service.readUrl("https://resplendent-heat-7949.firebaseio.com/user.json"), User.class);
        } catch (Exception ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }


}
