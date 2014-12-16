/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
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
        blogService service = new blogService();
        try {
            System.out.println(service.readUrl("https://resplendent-heat-7949.firebaseio.com/user.json"));
        } catch (Exception ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "peran") String peran) {
        //TODO write your implementation code here:
        
        return null;
    }
}
