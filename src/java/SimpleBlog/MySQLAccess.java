package SimpleBlog;

import SimpleBlog.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class MySQLAccess {
    private Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySQLAccess() {}
        
    private void open() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // setup the connection with the DB.
            connect = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1/simpleblog", "root","");

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                    resultSet.close();
            }
            if (statement != null) {
                    statement.close();
            }
            if (preparedStatement != null) {
                    preparedStatement.close();
            }
            if (connect != null) {
                    connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException{
        // resultSet is initialised before the first data set

        while (resultSet.next()){
            // it is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g., resultSet.getSTring(2);
            String barcode = resultSet.getString("barcode");
            String nama = resultSet.getString("nama_produk");
            String tag = resultSet.getString("tag");
            System.out.println("barcode: " + barcode);
            System.out.println("nama " + nama);
            System.out.println("tag " + tag);
        }
    }

    public List getUser(){
        java.util.List<org.chamerling.heroku.service.User> listuser = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listuser = port.listUser();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return listuser;
    }
    
    public org.chamerling.heroku.service.User getSpesificUser(String username) {
        java.util.List<org.chamerling.heroku.service.User> listuser = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listuser = port.listUser();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        org.chamerling.heroku.service.User user = null;
        for(int i =0;i<listuser.size();i++)
        {
            if(listuser.get(i).getUsername().equalsIgnoreCase(username))
            {
                user = listuser.get(i);
                break;
            }
        }
        return user;
    }
    
    public List getPost(){
        java.util.List<org.chamerling.heroku.service.Post> listpost = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listpost = port.listPost();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return listpost;
    }
    
    public org.chamerling.heroku.service.Post getPostId(String idPost)
    {
        java.util.List<org.chamerling.heroku.service.Post> listpost = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listpost = port.listPost();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        org.chamerling.heroku.service.Post postId = null;
        for(int i=0;i<listpost.size();i++)
        {
            if(listpost.get(i).getIDPost().equalsIgnoreCase(idPost))
            {
                postId = listpost.get(i);
            }
        }
        return postId;
    }
    
    public List getKomentar(String id)
    {
        java.util.List<org.chamerling.heroku.service.Comment> listkomentar = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listkomentar = port.listComment();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        java.util.List<org.chamerling.heroku.service.Comment> listkomentarbyID = new ArrayList<org.chamerling.heroku.service.Comment>();
        for(int i=0;i<listkomentar.size();i++)
        {
            System.out.println(i);
            System.out.println(id);
            System.out.println(listkomentar.get(i).getIDPost()+" "+listkomentar.get(i).getNama());
            if(listkomentar.get(i).getIDPost().equalsIgnoreCase(id))
            {
                listkomentarbyID.add(listkomentar.get(i));
            }
        }
        return listkomentarbyID;
    }
    
    public boolean addPost(String judul, String konten, String tanggal, String publish)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addPost(judul, tanggal, konten, publish);
    }
    
    public boolean updatePost(String id, String judul, String tanggal, String konten, String publish)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editPost(id, judul, konten, tanggal, publish);
    }
    
    public boolean deletePost(String id)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePost(id);
    }
    
    public String getUserID(String username)
    {
        String ID = "";
        java.util.List<org.chamerling.heroku.service.User> listuser = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();

            listuser = port.listUser();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        for(int i=0;i<listuser.size();i++)
        {
            if(listuser.get(i).getUsername().equalsIgnoreCase(username))
            {
                ID = listuser.get(i).getID();
                break;
            }
        }
        return ID;
    }
    
    public boolean publishPost(String idPost)
    {
        org.chamerling.heroku.service.Post post = getPostId(idPost);
        if(post.getPublish().equalsIgnoreCase("1"))
        {
            return updatePost(idPost, post.getJudul(), post.getTanggal(), post.getKonten(), "0");
        }
        else
        {
            return updatePost(idPost, post.getJudul(), post.getTanggal(), post.getKonten(), "1");
        }
    }
    
    public boolean addKomentar(String idPost, String Nama, String Email, String Tanggal, String Komentar)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addComment(idPost, Nama, Email, Tanggal, Komentar);
    }
    
    public boolean addUser(String username, String password, String email, String role)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addUser(username, password, email, role);
    }
    
    public boolean updateUser(String id, String username, String password, String email, String role)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editUser(id, username, password, email, role);
    }
    
    public boolean deleteUser(String id)
    {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deleteUser(id);
    }

    public boolean softDelete(String idPost) {
        org.chamerling.heroku.service.Post post = getPostId(idPost);
        return updatePost(idPost, post.getJudul(), post.getTanggal(), post.getKonten(), "3");
    }

    public boolean restore(String idPost) {
        org.chamerling.heroku.service.Post post = getPostId(idPost);
        return updatePost(idPost, post.getJudul(), post.getTanggal(), post.getKonten(), "0");
    }
    
    public String getRolebyUsername(String username) {
        String role = "";
        java.util.List<org.chamerling.heroku.service.User> listuser = null;
        try {
            org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
            org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
            listuser = port.listUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        for(int i=0;i<listuser.size();i++)
        {
            if(listuser.get(i).getUsername().equalsIgnoreCase(username))
            {
                role = listuser.get(i).getRole();
                break;
            }
        }
        return role;
    }
}
