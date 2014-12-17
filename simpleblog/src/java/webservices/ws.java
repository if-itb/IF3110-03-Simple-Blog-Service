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

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "AddPost")
    public String AddPost(@WebParam(name = "Judul") String Judul,@WebParam(name = "Tanggal") String Tanggal,@WebParam(name = "Konten") String Konten,@WebParam(name = "Status") String Status,@WebParam(name = "Deleted") String Deleted) {
        Firebase root = new Firebase("https://makan.firebaseio.com/");
        Firebase temp = root.child("post");
        Map<String,String> post = new HashMap<String,String>();
        post.put("Judul", Judul);
        post.put("Tanggal", Tanggal);
        post.put("Status", Status);
        post.put("Konten", Konten);
        post.put("Deleted", Deleted);
        temp.push().setValue(post);
        
        return "Add post success!";
    }
 
    @WebMethod(operationName = "AddMember")
    public String AddMember(@WebParam(name = "Email") String Email,@WebParam(name = "Name") String Name,@WebParam(name = "Password") String Password,@WebParam(name = "Role") String Role) {
        Firebase root = new Firebase("https://makan.firebaseio.com/");
        Firebase temp = root.child("member");
        Map<String,String> member = new HashMap<String,String>();
        member.put("Email", Email);
        member.put("Name", Name);
        member.put("Password", Password);
        member.put("Role", Role);
        temp.push().setValue(member);
        
        return "Add member success!";
    }
}
