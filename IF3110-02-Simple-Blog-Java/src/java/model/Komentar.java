/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Afik
 */
@ManagedBean
@ViewScoped
public class Komentar {

    /**
     * Creates a new instance of Komentar
     */
    
    private UserBean user;
    private String PID;
    private String KID;
    private String Nama;
    private String Email;
    private String Tanggal;
    private String Komentar;
    
    public Komentar() {
        PID = new String();
        KID = new String();
        if (user == null || user.getRole()==UserBean.getGuest()) {
            Nama = new String();
            Email = new String();
        }
        else {
            Nama = user.getUsername();
            Email = user.getEmail();
        }
        Tanggal = new String();
        Komentar = new String();
    }

    /**
     * @return the PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(String PID) {
        this.PID = PID;
    }

    /**
     * @return the KID
     */
    public String getKID() {
        return KID;
    }

    /**
     * @param KID the KID to set
     */
    public void setKID(String KID) {
        this.KID = KID;
    }

    /**
     * @return the Nama
     */
    public String getNama() {
        return Nama;
    }

    /**
     * @param Nama the Nama to set
     */
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Tanggal
     */
    public String getTanggal() {
        return Tanggal;
    }

    /**
     * @param Tanggal the Tanggal to set
     */
    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    /**
     * @return the Komentar
     */
    public String getKomentar() {
        return Komentar;
    }

    /**
     * @param Komentar the Komentar to set
     */
    public void setKomentar(String Komentar) {
        this.Komentar = Komentar;
    }

    /**
     * @return the user
     */
    public UserBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserBean user) {
        this.user = user;
    }
}