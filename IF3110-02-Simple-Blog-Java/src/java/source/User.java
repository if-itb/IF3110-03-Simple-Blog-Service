/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.chamerling.heroku.service.BlogService;
import org.chamerling.heroku.service.BlogServiceImplService;
import org.chamerling.heroku.service.DataUser;
import org.chamerling.heroku.service.Exception_Exception;
import org.chamerling.heroku.service.InterruptedException_Exception;

/**
 *
 * @author akhfa
 */
public class User {
    private String idFirebase;
    private String username;
    private String password;
    private String nama;
    private String email;
    private String role;
    
    /**
     * Konstruktor ini digunakan jika ingin menggunakan fungsi fungsi yang ada
     * tanpa menginisialisasi usernya
     */
    public User()
    {
        
    }
    /**
     * Membuat user baru untuk keperluan login
     * @param _username Username dari user
     * @param _password Password dari user
     */
    public User(String _username, String _password)
    {
        username = _username;
        password = _password;
    }
    
    /**
     * Untuk membuat user baru, maka attribute dari user diisi semua terlebih dulu
     * @param _username Username dari user
     * @param _password Password dari user
     * @param _nama Nama user
     * @param _email Email user
     * @param _role Role dari user
     */
    public User(String _username, String _password, String _nama, String _email, String _role){
        username = _username;
        password = _password;
        nama = _nama;
        email = _email;
        role = _role;
    }
    
    public void setIdFirebase(String _idFirebase)
    {
        idFirebase = _idFirebase;
    }
    
    public String getIdFirebase()
    {
        return idFirebase;
    }
    
    public void setUsername(String _username)
    {
        username = _username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPassword(String _password)
    {
        password = _password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setNama(String _nama)
    {
        nama = _nama;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public void setEmail(String _email)
    {
        email = _email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setRole(String _role)
    {
        role = _role;
    }
    
    public String getRole() throws SQLException, Exception_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        List<DataUser> userlist = blog.getAllUser();
        if(role == null)
        {
            for(DataUser user : userlist) {
                if(user.username.equals(this.username)) {
                    this.role = user.role;
                    break;
                }
            }
            /*
            //Load role dari database
            KoneksiDatabase.setUser(userSQL);
            KoneksiDatabase.setPassword(passSQL);
            KoneksiDatabase.setDatabase(urlSQL,databaseName);

            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String query = "SELECT username, role FROM user WHERE username = '" + username +"'";
            System.out.println(query);
            
            ResultSet result = statement.executeQuery(query);
            if(result.next())
            {
                role = result.getString("role");
            }
            System.out.println("role = " + role);*/
        }
        return this.role;
    }
    
    /**
     * Method untuk me-list semua user yang terdaftar di database
     * @return
     * @throws org.chamerling.heroku.service.Exception_Exception 
     */
    public List<DataUser> getAllUser() throws Exception_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        return blog.getAllUser();
    }
    
     /**
     * Prosedur untuk mendapatkan 1 user untuk di load ke form update user.
     * username harus diset terlebih dahulu dengan prosedure user.setUsername("username").
     * Mengcopy nama, password, email, role dari database ke attribute berdasarkan username yang di set.
     * @throws org.chamerling.heroku.service.Exception_Exception 
     */
    public void getOneUser() throws Exception_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        List<DataUser> userlist = blog.getAllUser();
        for(DataUser user : userlist) {
            if(user.username.equals(this.username)) {
                this.nama = user.nama;
                this.password = user.password;
                this.email = user.email;
                this.role = user.role;
                break;
            }
        }
        /*
        KoneksiDatabase.setUser(userSQL);
        KoneksiDatabase.setPassword(passSQL);
        KoneksiDatabase.setDatabase(urlSQL,databaseName);
        
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = koneksi.createStatement();
        String query = "SELECT password, nama, email, role FROM user WHERE username = '" + username +"'";
        System.out.println(query);
        
        ResultSet result = statement.executeQuery(query);
        if(result.next())
        {
            this.nama = result.getString("nama");
            this.password = result.getString("password");
            this.email = result.getString("email");
            this.role = result.getString("role");
        }
        result.close();
        statement.close();*/
    }
    
    /**
     * Fungsi untuk mengupdate user berdasarkan username
     * Semua attribut yang akan di update harus diset terlebih dahulu menggunakan setter. 
     * @throws org.chamerling.heroku.service.InterruptedException_Exception 
     * @throws org.chamerling.heroku.service.Exception_Exception 
     */
    public void updateUser() throws Exception_Exception, InterruptedException_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        List<DataUser> daftarUser = blog.getAllUser();
        String idFirebaseLocal = "";
        
        for(DataUser user: daftarUser)
        {
            if(username.equals(user.getUsername()))
            {
                idFirebaseLocal = user.getIdFirebase();
            }
        }
        if(!idFirebaseLocal.equals(""))
            blog.updateUser(idFirebaseLocal, username, password, nama, email, role);
        /*
        KoneksiDatabase.setUser(userSQL);
        KoneksiDatabase.setPassword(passSQL);
        KoneksiDatabase.setDatabase(urlSQL,databaseName);
        
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = koneksi.createStatement();
        String query = "UPDATE user SET password = ?, "
                                        + "nama = ?,"
                                        + "email = ?,"
                                        + "role = ?"
                        + "WHERE username = ?";
        try (PreparedStatement preStat = koneksi.prepareStatement(query)) {
            preStat.setString(1, password);
            preStat.setString(2, nama);
            preStat.setString(3, email);
            preStat.setString(4, role);
            preStat.setString(5, username);
            preStat.executeUpdate();
        } */
    }
    
    /**
     * Fungsi untuk menghapus 1 user dengan username tertentu.
     * username harus diset terlebih dahulu dengan prosedure user.setUsername("username").
     * @throws org.chamerling.heroku.service.InterruptedException_Exception
     * @throws org.chamerling.heroku.service.Exception_Exception 
     */
    public void deleteUser() throws InterruptedException_Exception, Exception_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        List<DataUser> userlist = blog.getAllUser();
        for(DataUser user : userlist) {
            if(user.username.equals(this.username)) {
                blog.deleteUser(user.getIdFirebase());
            }
        }
        /*
        KoneksiDatabase.setUser(userSQL);
        KoneksiDatabase.setPassword(passSQL);
        KoneksiDatabase.setDatabase(urlSQL,databaseName);
        
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = koneksi.createStatement();
        String query = "DELETE FROM user WHERE username = '" + username +"'";
        System.out.println(query);
        
        try (PreparedStatement preStat = koneksi.prepareStatement(query)) {
            preStat.executeUpdate();
            preStat.close();
        }*/
    }
    /**
     * Fungsi untuk user melakukan login dengan menggunakan username dan password 
     * yang telah di set sebelumnya
     * @return True jika login berhasil, dan false jika gagal
     * @throws java.sql.SQLException
     * @throws org.chamerling.heroku.service.Exception_Exception
     * @throws org.chamerling.heroku.service.InterruptedException_Exception
     */
    public boolean successLogin() throws SQLException, Exception_Exception, InterruptedException_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        List<DataUser> userlist = blog.getAllUser();
        for(DataUser user : userlist) {
            if(user.username.equals(this.username)&&user.password.equals(this.password)) {
                return true;
            }
        }
        return false;
        /*
        KoneksiDatabase.setUser(userSQL);
        KoneksiDatabase.setPassword(passSQL);
        KoneksiDatabase.setDatabase(urlSQL,databaseName);
        
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = koneksi.createStatement();
        String query = "SELECT username, password FROM user WHERE username = '" + username +"'";
        System.out.println(query);
        
        ResultSet result = statement.executeQuery(query);
        while(result.next())
        {
            System.out.println("User = " + result.getString(1));
            System.out.println("password = " + result.getString(2));
            if(username.equalsIgnoreCase(result.getString(1)) && password.equals(result.getString(2)))
            {
                result.close();
                statement.close();
//                koneksi.close();
                return true;
            }
        }
        result.close();
        statement.close();
//        koneksi.close();
        return false; */
    }
    
    /**
     * Memasukkan user ke dalam database. 
     * User di create terlebih dahulu dengan constructor dengan parameter (username, password, dan role).
     * @throws SQLException 
     * @throws org.chamerling.heroku.service.InterruptedException_Exception 
     */
    public void masukDatabase() throws SQLException, InterruptedException_Exception
    {
        BlogService blog = new BlogServiceImplService().getBlogServiceImplPort();
        blog.addUser(username, nama, password, email, role);
        /*
        KoneksiDatabase.setUser(userSQL);
        KoneksiDatabase.setPassword(passSQL);
        KoneksiDatabase.setDatabase(urlSQL,databaseName);
        Connection koneksi = KoneksiDatabase.getKoneksi();
        String query = "INSERT INTO user (username,password,nama,email,role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preStat = koneksi.prepareStatement(query)) {
            preStat.setString(1, username);
            preStat.setString(2, password);
            preStat.setString(3, nama);
            preStat.setString(4, email);
            preStat.setString(5, role);
            
            preStat.executeUpdate();
            preStat.close();
        }
//        koneksi.close(); */
    }
    
    /**
     * Testing untuk user
     * @param args 
     * @throws org.chamerling.heroku.service.Exception_Exception 
     * @throws org.chamerling.heroku.service.InterruptedException_Exception 
     */
    public static void main(String[] args) throws Exception_Exception, InterruptedException_Exception {
        try {
            User pertama = new User("akhfa3","akhfa2");
            if(pertama.successLogin())
            {
                System.out.println("sukses login");
            }
            else
            {
                System.out.println("gagal login");
            }
            
//            User kedua = new User("akhfa5", "akhfa", "namaAkhfa","akhmadfakhoni@gmail.com","editor");
//            kedua.masukDatabase();
//            kedua.getAllUser();
            
            //Test delete
//            User usertest = new User();
//            usertest.setUsername("akhfa4");
//            usertest.deleteUser();
            
            //Test getOneUser
            User usertest = new User();
            usertest.setUsername("akhfa2");
            usertest.getOneUser();
            System.out.println("Sebelum update user");
            System.out.println(usertest.getUsername());
            System.out.println(usertest.getNama());
            System.out.println(usertest.getPassword());
            System.out.println(usertest.getEmail());
            System.out.println(usertest.getRole());
            
            //Test updateUser (Test getOneUser harus tetap dijalankan
            usertest.setNama("namaakhfa2");
            usertest.setRole("owner");
            usertest.updateUser();
            System.out.println("\nSetelah updateUser");
            System.out.println(usertest.getUsername());
            System.out.println(usertest.getNama());
            System.out.println(usertest.getPassword());
            System.out.println(usertest.getEmail());
            System.out.println(usertest.getRole());
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
