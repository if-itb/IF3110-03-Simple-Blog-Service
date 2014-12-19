/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datatype;

/**
 *
 * @author SPM
 */
public class Komentar {
    public String komencontent;
    public String komendate;
    public String komenname;
    public Komentar(){}
    public void setKomentar(String content, String date, String name){
	komencontent = content;
	komendate = date;
	komenname = name;
    }
}
