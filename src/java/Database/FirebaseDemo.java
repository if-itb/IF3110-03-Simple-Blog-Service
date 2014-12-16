/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.User;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jdk.nashorn.internal.parser.JSONParser;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author upix
 */
public class FirebaseDemo {
    public static void main (String args[]) throws FirebaseException, JacksonUtilityException, JSONException
    {
            String firebase_baseUrl = "https://demoluthfi.firebaseio.com/";
            Firebase firebase = new Firebase( firebase_baseUrl );
          
            
            //firebase.put(dataMap);
            
            FirebaseResponse response = firebase.get("Users");
            
            JSONArray arr = new JSONArray(response.getRawBody());
            List<User> LS = new LinkedList();
            for (int i=0;i<arr.length();i++)
            {
                
                User user = new User(arr.getJSONObject(i));
                LS.add(user);
            }
            
            System.out.println(LS.get(0).getName());
    }
}
