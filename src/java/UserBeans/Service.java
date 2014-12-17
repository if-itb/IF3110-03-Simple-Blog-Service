/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author user
 */
@WebService(serviceName = "Service")
public class Service {

    /**
     * This is a sample web service operation
     * @param id
     */
//    @WebMethod(operationName = "addComment")
//    public String addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "konten") String konten) {
//        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
//        
//        Firebase komenRef = ref.child("komentar");
//        Map<String, Object> komentar = new HashMap<String, Object>();
//        komentar.put("konten", konten);
//        komentar.put("nama", nama);
//        komentar.put("email",email);
//        komenRef.push().setValue(komentar);
//        return "success";
//        
//    }
    @WebMethod(operationName = "deleteUser")
    public String deleteUser(@WebParam(name = "id")String id){
        Firebase User=new Firebase("https://simpleblogjsf.firebaseio.com/user/");
        Firebase refUser=User.child(id);
        refUser.removeValue();
        return "success";
    }
    
    @WebMethod(operationName = "addComment")
    public String addComment(@WebParam(name = "nama")String nama, @WebParam(name = "email") String email, @WebParam(name = "komen") String komen, @WebParam(name = "id") String id){
        Firebase comment=new Firebase("https://simpleblogjsf.firebaseio.com/blogpost/");
        Firebase refcomment=comment.child(id+"/komentar");
        Map<String, Object> kom=new HashMap <String, Object>();
        kom.put("nama" ,nama);
        kom.put("email" ,email);
        kom.put("komen" ,komen);
        
        refcomment.push().setValue(kom);
        return "success";
    }

    /**
     *
     * @param id
     * @return
     */
    @WebMethod (operationName="listComment")
    public Object listCommet(@WebParam(name = "id")String id) throws ParseException{
        String url="https://simpleblogjsf.firebaseio.com/blogpost/"+id+"/komentar.json";
        String json=readURL(url);
        ArrayList<String> ArrayKomen = new ArrayList<String>();
        JSONParser Parser = new JSONParser();
        try{
            Object obj = Parser.parse(json);
            JSONArray array = new JSONArray();
            array.add(obj);
            JSONObject obj2= (JSONObject) array.get(1);
//            return array.get(1).toString();
        }catch(ParseException pe){
         System.out.println("position: " + pe.getPosition());
         System.out.println(pe);
      }
        
//        JSONParser parser=new JSONParser();
//        Object ob=new Object();
//        ob =parser.parse(json);
//        JSONArray array = (JSONArray)ob;
//        for(int i=0;i<array.size();i++)
//        {
//            JSONObject obj2 = (JSONObject)array.get(i);
//            Komentar kom=new Komentar();
//            kom.setKomen((String) obj2.get("komen"));
//            kom.setKomentator((String) obj2.get("nama"));
//            ArrayKomen.add((String) obj2.get("nama"));
//        }
        return json;
    }
    
    public ArrayList search(String query){
        return null;
    }
    public static String readURL(String urlString) {
        BufferedReader reader = null;
        try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder buffer = new StringBuilder();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1) {
                        buffer.append(chars, 0, read); 
                }
                return buffer.toString();
        } catch (IOException ex) {
                Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (reader != null) {
                try {
                        reader.close();
                } catch (IOException ex) {
                        Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
