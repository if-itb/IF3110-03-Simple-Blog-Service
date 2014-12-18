/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author ASUS
 */
@ManagedBean(name = "komentar", eager = true)
@ViewScoped
public class Komentar {

    @ManagedProperty(value="#{listKomentar.postid}")
    String pid; 
    String commentid;
    String nama;
    String email;
    String komentar;
    String tanggal;
	
    public String getPid(){
        return pid;
    }
	
    public String getCommentid(){
        return commentid;}
    
    public String getNama(){
        return nama;}
    
    public String getEmail(){
        return email;}
    
    public String getKomentar(){
        return komentar;}
    
    public String getTanggal(){
        return tanggal;}
    
    public void setCommentid(String x){
        this.commentid=x;}
    
    public void setPid(String p){
        this.pid = p;}
    
    public void setNama(String n){
    this.nama=n;}
    
    public void setEmail(String e){
    this.email=e;}
    
    public void setKomentar(String k){
    this.komentar=k;}
    
    public void setTanggal(String d){
    this.tanggal=d;}

    public void addComment(){
//       String url = "jdbc:mysql://localhost:3306/datapost";
//       String driver = "com.mysql.jdbc.Driver";
//       String userName = "root"; 
//       String password = "";
//       try {
//            Class.forName(driver).newInstance();
//            Connection conn = DriverManager.getConnection(url,userName,password);
//
//            Date today = new Date();
//            Timestamp date = new Timestamp(today.getTime());
//            String insertToDB = "insert into komentar (`Nama`,`Email`,`Komentar`,`postid`,`tanggal`) value (?,?,?,?,?)";
//            PreparedStatement preparedStatement = conn.prepareStatement(insertToDB);
//            preparedStatement.setString(1, this.nama);
//            preparedStatement.setString(2, this.email);
//            preparedStatement.setString(3, this.komentar);
//            preparedStatement.setString(4,pid);
//            preparedStatement.setTimestamp(5, date);
//            preparedStatement.executeUpdate();
//            conn.close();
//       } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//       }
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        Calendar currentDate = Calendar.getInstance(); //Get the current date
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd"); //format it as per your requirement
            String dateNow = formatter.format(currentDate.getTime());
        hello.addKomentar(this.nama,this.email,this.komentar,dateNow,this.pid);
    }

}
