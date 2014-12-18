/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Komentar implements Serializable {
    String id_kom;
    String id_post;
    String username;
    String email;
    String waktu;
    String komentar;

    public String getId_kom() {
        return id_kom;
    }

    public void setId_kom(String id_kom) {
        this.id_kom = id_kom;
    }

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
    
     public void insertKomen() throws ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        waktu = dateFormat.format(date);
        addComment(id_post, username, email, waktu, komentar);
    }

    private static boolean addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addComment(arg0, arg1, arg2, arg3, arg4);
    }
}
