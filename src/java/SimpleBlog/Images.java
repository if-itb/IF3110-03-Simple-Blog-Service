/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBlog;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivana Clairine
 */
public class Images {
    /*-------------------------
   *   Get the Blob image
   *------------------------*/
  public static byte[] getPhoto (int iNumPhoto)
       throws Exception, SQLException
  {
    String req = "" ;
    Blob img ;
    byte[] imgData = null ;
    Connection conn=null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpleblog", "root","");
    Statement stmt = (Statement) conn.createStatement();
    
    // Query
    req = "Select image From imagepost Where id = " + iNumPhoto ;
    
    ResultSet rset  = stmt.executeQuery ( req ); 
    
    while (rset.next ())
    {    
      img = (Blob) rset.getBlob(1);
      imgData = img.getBytes(1,(int)img.length());
    }    
    
    rset.close();
    stmt.close();
    
    return imgData ;
  }
    
}
