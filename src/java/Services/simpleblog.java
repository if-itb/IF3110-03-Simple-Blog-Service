/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Database.*;
import Model.*;
import java.util.LinkedList;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author upix
 */
@WebService(serviceName = "simpleblog")
public class simpleblog {

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public List<User> listUser() throws FirebaseException, JSONException {
        String firebase_baseUrl = "https://demoluthfi.firebaseio.com/";
        Firebase firebase = new Firebase( firebase_baseUrl );

        FirebaseResponse response = firebase.get("Users");

        JSONArray arr = new JSONArray(response.getRawBody());
        List<User> LS = new LinkedList();
        for (int i=0;i<arr.length();i++)
        {

            User user = new User(arr.getJSONObject(i));
            LS.add(user);
        }
        return LS;
    }
}
