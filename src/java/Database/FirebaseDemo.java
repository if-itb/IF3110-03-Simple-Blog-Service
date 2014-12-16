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
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;


/**
 *
 * @author upix
 */
public class FirebaseDemo {
    public static void main (String args[]) throws FirebaseException, JacksonUtilityException
    {
            String firebase_baseUrl = "https://demoluthfi.firebaseio.com/";
            Firebase firebase = new Firebase( firebase_baseUrl );
            //FirebaseResponse response = firebase.delete();
            User user1 = new User("admin","admin","admin","admin","admin");
            User user2 = new User("admin","admin","admin","admin","admin");
            List<User> LS = new LinkedList();
            LS.add(user1);
            LS.add(user2);
            Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
            dataMap.put( "Users", LS );
            
            //firebase.put(dataMap);
            
            FirebaseResponse response = firebase.get();
            
            dataMap = response.getBody();
            
            
            
            response = firebase.delete();
            
            firebase.put(dataMap);

            System.out.println();
    }
}
