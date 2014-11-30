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
        List<User> listuser=new ArrayList();
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT * FROM user;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                listuser.add(new User(resultSet.getString("username"),resultSet.getString("password"), 
                        resultSet.getString("email"), resultSet.getString("role")));
            }
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
        return listuser;
    }
    
    public User getSpesificUser(String username) {
        User user = new User();
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE username='"+username+"';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUser(resultSet.getString("username"), resultSet.getString("password"),
                        resultSet.getString("email"), resultSet.getString("role"));
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public List getPost(){
        List<Post> listpost=new ArrayList();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM post ORDER BY `id post` DESC;");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    listpost.add(new Post(resultSet.getInt("id post"),resultSet.getInt("id"), 
                            resultSet.getString("judul"),resultSet.getDate("tanggal"),resultSet.getTime("tanggal"), 
                            resultSet.getString("konten"),resultSet.getInt("publish")));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return listpost;
    }
    
    public Post getPostId(int idPost)
    {
        Post postId=new Post();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM post WHERE `id post`="+ idPost + ";");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    postId.setPost(resultSet.getInt("id post"),resultSet.getInt("id"), 
                            resultSet.getString("judul"),resultSet.getDate("tanggal"),resultSet.getTime("tanggal"), 
                            resultSet.getString("konten"),resultSet.getInt("publish"));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        return postId;
    }
    
    public List getKomentar(int id)
    {
        List<Komentar> listkomentar=new ArrayList();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM komentar WHERE `id post`="+ id +";");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    listkomentar.add(new Komentar(resultSet.getInt("id post"),resultSet.getInt("id komentar"), 
                            resultSet.getString("nama"),resultSet.getString("email"),resultSet.getTimestamp("tanggal"), 
                            resultSet.getString("komentar")));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return listkomentar;
    }
    
    public void addPost(int id, String judul, String konten, String tanggal, boolean publish)
    {
        open();
        try {
            int i;
            if(publish){i=1;}
            else{i=0;}
            String S = "INSERT INTO `simpleblog`.`post` (`id post`, `id`, `judul`, `konten`, `tanggal`, `publish`) VALUES (NULL, '"+id+"', '"+judul+"', '"+konten+"', '"+tanggal+" 00:00:00', '"+i+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
      public void addImagePost(int id, String pesan, String tanggal, Object gambar)
    {
        open();
        try {
           
            String S = "INSERT INTO `simpleblog`.`imagepost` ( `story`, `tanggal`) VALUES ("+pesan+"', '"+tanggal+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void updatePost(int id, String judul, String tanggal, String konten)
    {
        open();
        try {
            String S = "UPDATE `simpleblog`.`post` SET `judul` = '"+judul+"', `konten` = '"+konten+"', `tanggal` = '"+tanggal+"' WHERE `post`.`id post` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void deletePost(int id)
    {
        open();
        try {
            String S = "DELETE FROM `simpleblog`.`post` WHERE `post`.`id post` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public int getMaxId()
    {
        int id = 0;
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT `id post` FROM `simpleblog`.`post` ORDER BY `id post` DESC LIMIT 1;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                id = resultSet.getInt("id post");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return id;
    }
    
    public int getUserID(String username)
    {
        int id = 0;
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT `id` FROM `simpleblog`.`user` WHERE username=\""+username+"\";");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                id = resultSet.getInt("id");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return id;
    }
    
    public void publishPost(int idPost)
    {
        Post post = getPostId(idPost);
        int published = post.publish;
        open();
        try {
            String S = null;
            if(published==1)
            {
                S = "UPDATE `simpleblog`.`post` SET `publish`=0 WHERE `post`.`id post` ="+idPost+";";
            }
            else
            {
                S = "UPDATE `simpleblog`.`post` SET `publish`=1 WHERE `post`.`id post` ="+idPost+";";
            }
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void addKomentar(int idPost, String Nama, String Email, String Komentar)
    {
        open();
        try {
            String S="INSERT INTO `simpleblog`.`komentar` (`id post`, `id komentar`, `nama`, `email`, `tanggal`, `komentar`) VALUES ('" 
                                                        + idPost + "', NULL, '"+ Nama +"', '"+ Email +"', CURRENT_TIMESTAMP, '"+Komentar+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);

            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
    public void addUser(String username, String password, String email, String role)
    {
        open();
        try {
            
            String S = "INSERT INTO `simpleblog`.`user` (`username`,`password`,`email`,`role`) VALUES ('" + username + "', '"+ password +"', '"+email+"', '"+ role+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
     public void updateUser(int id, String username, String password, String email, String role)
    {
        open();
        try {
            String S = "UPDATE `simpleblog`.`user` SET `username` = '"+username+"', `password` = '"+password+"', `email` = '"+email+"', `role` = '"+role+"' WHERE `id` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int id)
    {
        open();
        try {
            String S = "DELETE FROM `simpleblog`.`user` WHERE `user`.`id` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }

    com.mysql.jdbc.Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void softDelete(int idPost) {
       Post post = getPostId(idPost);
       open();
        try {
            String S = "UPDATE `simpleblog`.`post` SET `publish`=3 WHERE `post`.`id post` ="+idPost+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }

    public void restore(int idPost) {
        Post post = getPostId(idPost);
       open();
        try {
            String S = "UPDATE `simpleblog`.`post` SET `publish`=1 WHERE `post`.`id post` ="+idPost+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public String getRolebyUsername(String username) {
        open();
        String role = "";
        try{
            preparedStatement = connect.prepareStatement("SELECT `role` FROM `simpleblog`.`user` WHERE username=\""+username+"\";");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                role = resultSet.getString("role");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return role;
        
    }
    
}
