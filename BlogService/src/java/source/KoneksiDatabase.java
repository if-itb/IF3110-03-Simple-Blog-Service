package source;
import com.firebase.client.Firebase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    /**
     * Fungsi untuk memasukkan nama database
     * @param _databaseName 
     */
    public static void setDatabase(String _databaseName)
    {
        url = "jdbc:mysql://localhost:3306/" + _databaseName;
    }
    
    /**
     * Fungsi untuk mengeset database jika domain bukan di localhost, namun port masih 3306
     * @param _domain
     * @param _databaseName 
     */
    public static void setDatabase(String _domain, String _databaseName)
    {
        url = "jdbc:mysql://"+ _domain +":3306/" + _databaseName;
    }
    
    /**
     * Fungsi untuk mengeset database jika domain bukan localhost dan port bukan 3306
     * @param _domain
     * @param _port
     * @param _databaseName 
     */
    public static void setDatabase(String _domain, String _port, String _databaseName)
    {
        url = "jdbc:mysql://"+ _domain +":"+ _port +"/" + _databaseName;
    }
    
    /**
     * Fungsi untuk mendapatkan koneksi ke database. User dan password dari database harus diset terlebih dahulu.
     * @return Mengembalikan koneksi ke database.
     * @throws java.sql.SQLException
     */
    public static Connection getKoneksi() throws SQLException{
        if(koneksi == null && user != null && password != null) {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil terkoneksi");
        }
        return koneksi;
    }
    
    public static Firebase getFirebase()
    {
        Firebase ref = new Firebase(urlFirebase);
        return ref;
    }
    
    public static Firebase getFirebaseForComment(String _idFirebasePost)
    {
        Firebase ref = new Firebase(urlFirebase + _idFirebasePost);
        return ref;
    }
    
    public static void main(String[] args){
        
    }
}
