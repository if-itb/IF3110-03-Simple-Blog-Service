/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class Comment implements Comparable{
	public String Nama;
	public String Email;
	public String Komentar;
	public Long Tanggal;
	public Comment(){
		Nama=new String();
		Email=new String();
		Komentar=new String();
		Tanggal=0L;
	}
	public String getNama(){return Nama;}
	public String getEmail(){return Email;}
	public String getKomentar(){return Komentar;}
	public Long getTanggal(){return Tanggal;}
        @Override
        public int compareTo(Object comparestu) {
		Long compareage=((Comment)comparestu).getTanggal();
		/* For Ascending order*/
		//return this.Tanggal-compareage;
		/* For Descending order do like this */
		return (int) (compareage-this.Tanggal);
	}
	@Override
	public String toString(){
		return "[Comment, From "+Nama+"]";
	}
	public static Comment JSONtoComment(String in) throws JSONException{
		if (in.equals("null")){
			return new Comment();
		}
                JSONObject obj = new JSONObject(in);   
		Comment ctp=new Comment();
		ctp.Nama=obj.getString("Nama");
		ctp.Email=obj.getString("Email");
		ctp.Komentar=obj.getString("Komentar");
		ctp.Tanggal=obj.getLong("Tanggal");
		return ctp;
	}

}

