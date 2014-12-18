/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;
/**
 *
 * @author asus
 */
public class Post implements Serializable{
    String id_post;
    String judul;
    String tanggal;
    String konten;
    boolean status;

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }
    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String setDBP(String id) throws ClassNotFoundException, IOException_Exception, MalformedURLException_Exception{
        java.util.List<org.chamerling.heroku.service.Post> list = listPost();
        for (org.chamerling.heroku.service.Post apost: list){
            if(apost.getIdPost().equals(id)){
                id_post = apost.getIdPost();
                judul = apost.getJudul();
                tanggal = apost.getTanggal();
                konten = apost.getKonten();
                status = apost.isStatus();
            }
        }
        System.out.println("konten : " + konten);
        return "post";
    }
    
    public String setDBE(String id) throws ClassNotFoundException, IOException_Exception, MalformedURLException_Exception {
        java.util.List<org.chamerling.heroku.service.Post> list = listPost();
        for (org.chamerling.heroku.service.Post apost: list){
            if(apost.getIdPost().equals(id)){
                id_post = apost.getIdPost();
                judul = apost.getJudul();
                tanggal = apost.getTanggal();
                konten = apost.getKonten();
                status = apost.isStatus();
            }
        }
        return "edit";
    }
    
    public void initPost () {
        judul = "";
        tanggal = "";
        konten = "";
    }
    
    public String insertPost() throws ClassNotFoundException{
        addPost(judul, tanggal, konten);
        return "insert";
    }
    
    public String editPost() throws ClassNotFoundException{
        editPost_1(id_post, judul, tanggal, konten);
        return "edit";
    }
    
    public void hapusPost(String id) throws ClassNotFoundException {
        deletePost(id);
    }

    private static boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.addPost(arg0, arg1, arg2);
    }

    private static boolean deletePost(java.lang.String arg0) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.deletePost(arg0);
    }

    private static boolean editPost_1(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.editPost(arg0, arg1, arg2, arg3);
    }

    private static java.util.List<org.chamerling.heroku.service.Post> listPost() throws IOException_Exception, MalformedURLException_Exception {
        org.chamerling.heroku.service.HelloServiceImplService service = new org.chamerling.heroku.service.HelloServiceImplService();
        org.chamerling.heroku.service.HelloService port = service.getHelloServiceImplPort();
        return port.listPost();
    }

   
}
