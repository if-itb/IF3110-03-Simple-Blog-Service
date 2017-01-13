package org.chamerling.heroku.service;
import com.firebase.client.Firebase;
import java.sql.Connection;

public class KoneksiDatabase {
    private static Connection koneksi;
    private static String user;
    private static String password;
    private static String url;
    private static final String urlFirebase = "https://if3110-4.firebaseio.com/";
    
    
    public static void setUser(String _user)
    {
        user = _user;
    }
    
    public static void setPassword(String _password)
    {
        password = _password;
    }
    
    public static Firebase getFirebase()
    {
        Firebase ref = new Firebase(urlFirebase);
        return ref;
    }
    
    public static Firebase getFirebaseForComment(String _idFirebasePost)
    {
        Firebase ref = new Firebase(urlFirebase +"post/" +_idFirebasePost);
        return ref;
    }
    
    public static void main(String[] args){
        
    }
}
