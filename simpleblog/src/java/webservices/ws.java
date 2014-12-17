/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author TOSHIBA
 */
@WebService(serviceName = "ws")
public class ws {
    private Firebase root = new Firebase("https://makan.firebaseio.com/");

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        Firebase temp = root.child("post");
        Map<String,String> post = new HashMap<String,String>();
        post.put("Judul", txt);
        temp.push().setValue(post);
        
        return "Hello " + txt + " !";
    }
}
