/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tubes2.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author adwisatya
 */
public class Post implements Comparable{
	public String Judul;
	public String Owner;
	public String Konten;
	public int Status;
	public Long Tanggal;
	public int id;
	public ArrayList<Comment> Komentar;
	public Post(){
		Judul=new String("404 POST NOT FOUND");
		Owner=new String("System Error");
		Konten=new String(""
			+ "The Post you're looking for is <b>NOT</b> found in our database.<br>"
			+ "<br>"
			+ "<br>"
			+ "Do you perhaps follow an expired link?<br>"
			+ "Maybe you input the wrong post id?<br>"
			+ "Either way, this is not the page you are looking for.<br>"
			+ "<h:link outcome=\"index.xhtml\" value=\"Click here to go back to homepage.\"/>");
		Status=0;
		try {
			Tanggal=new SimpleDateFormat("dd-MM-yyyy").parse("4-0-4").getTime();
		} catch (ParseException ex) {
			Tanggal=0L;
		}
		id=-1;
		Komentar=new ArrayList<Comment>();
	}
	public Post(Paket in){
		Judul=in.Judul;
		Owner=in.Owner;
		Konten=in.Konten;
		Status=in.Status;
		Tanggal=in.Tanggal;
		id=0;
		Komentar=new ArrayList<Comment>();
	}
	public String getJudul(){return Judul;}
	public String getOwner(){return Owner;}
	public String getKonten(){return Konten;}
	public int getStatus(){return Status;}
	public Long getTanggal(){return Tanggal;}
	public int getid(){return id;}
	public ArrayList<Comment> getKomentar(){return Komentar;}
	@Override
	public int compareTo(Object comparestu) {
		Long compareage=((Post)comparestu).Tanggal;
		/* For Ascending order*/
		//return this.Tanggal-compareage;
		/* For Descending order do like this */
		return (int) (compareage-this.Tanggal);
	}
	@Override
	public String toString(){
		return "[Post ID #"+id+"]";
	}
	public static Post JSONtoPost(String in){
		if (in.equals("null")){
			return new Post();
		}
		JSONObject obj;
		Post tp=new Post();
		try {
			obj = new JSONObject(in);
			tp.Judul=obj.getString("Judul");
			tp.Owner=obj.getString("Owner");
			tp.Konten=obj.getString("Konten");
			tp.Status=obj.getInt("Status");
			tp.Tanggal=obj.getLong("Tanggal");
			tp.id=obj.getInt("id");
			try{
				JSONArray obji = (JSONArray) obj.get("Komentar");
				for (int i=0;i<obji.length();i++){
					tp.Komentar.add(Comment.JSONtoComment(obji.getJSONObject(i).toString()));
				}
				//tp.Komentar=(ArrayList<Comment>)obj.get("Komentar");
			} catch(JSONException ex){
				tp.Komentar=new ArrayList<Comment>();
			}
		} catch (JSONException ex) {
			
		}
		return tp;
	}
}