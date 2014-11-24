/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@ManagedBean(name = "User",eager = true)
@RequestScoped
public class userMgnt{

    /**
     * Creates a new instance of userMgnt
     */
    private String NameUser;
    private String Username;
    private String Password;
    private String Messege;
    //nanti ditambah-tambah informasi user yang mau ditampilin
    public userMgnt() {
        NameUser="guest";
        Username="guest";
        Password="pass";
        Messege="tidak ada";
    }
    public void login() throws IOException{
        String user="nisa"; //from database
        String pass="nisadian"; //from database
        if(Username.equals(user))/*Username ada*/{
            if(pass.equals(Password))/*Password bener*/{
                NameUser=Username;//ambil nama dari databse
            }
            else{
                Messege="Password salah.";
                NameUser="guest";
                Username="guest";
                Password="pass";
            }
        }else{
            Messege="Username tidak ditemukan.";
            NameUser="guest";
            Username="guest";
            Password="pass";
        }
    }
    public String getMessege(){
        return Messege;
    }
    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return Password;
    }
    public String getName(){
        return NameUser;
    }
    public void setUsername(String s){
        Username=s;
    }
    public void setPassword(String s){
        Password=s;
    }
    public void setName(String s){
        NameUser=s;
    }
    public boolean isLogin(){
        return !NameUser.equals("guest");
    }
    public boolean activeMessege(){
        return !Messege.equals("tidak ada") && !isLogin();
    }
    public void logout(){
        NameUser="guest";
        Username="guest";
        Password="pass";
        Messege="tidak ada";
    }
}
    