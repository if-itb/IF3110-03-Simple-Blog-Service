/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tubes2.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author adwisatya
 */

public class Paket{
	public String Judul;
	public Long Tanggal;
	public String Konten;
	public String Owner;
	//public String id;
	//public boolean valid;
	public int Status;

	public void setJudul(String Judul) {
		this.Judul = Judul;
	}



	public void setKonten(String Konten) {
		this.Konten = Konten;
	}

	public void setOwner(String Owner) {
		this.Owner = Owner;
	}
	/*(
	public void setId(String id) {
		this.id = id;
	}
	public void setTanggal(Date Tanggal) {
		this.Tanggal = Tanggal;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getId(){
		return id;
	}
	public String getTanggal(){
		return new SimpleDateFormat("d MMMM y").format(Tanggal);
	}
	public String isReadMore(){
		if (Konten.length()>250){
			return "&hellip;<a href=\"post.xhtml?id="+id+"\">Read More</a>";
		} else {
			return "";
		}
	}
	*/
	public void setStatus(int Status) {
		this.Status = Status;
	}
	
	
	public String getJudul(){
		return Judul;
	}

	public String getKonten(){
		if (Konten.length()>265){
			return Konten.substring(0, 250);
		} else {
			return Konten;
		}
	}

	public String getOwner(){
		return Owner;
	}
	public int getStatus(){
		return Status;
	}

}
