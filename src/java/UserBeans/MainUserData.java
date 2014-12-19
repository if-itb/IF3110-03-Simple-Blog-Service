/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;


import java.util.ArrayList;
import java.util.List;
import org.chamerling.heroku.service.JsonObject;

/**
 *
 * @author Yusuf
 */
public class MainUserData {
    public static void main(String[] args){
        //List<JsonObject> listComment = Client.listComment("-JdQ_qQjymLpnDOXIsDg");
        System.out.println(Client.listPost());
    }
}
