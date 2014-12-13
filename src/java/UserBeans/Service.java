/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "Service")
public class Service {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "addComment")
    public String addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
        
        Firebase komenRef = ref.child("komentar");
        Map<String, Object> komentar = new HashMap<String, Object>();
//        Komentar komenParam = new Komentar();
//        komenParam.setKomentator("hayyu");
//        komenParam.setKomen(konten);
//        
        komentar.put("konten", konten);
        
        komenRef.push().setValue(komentar);
        return "success";
        
    }
}
