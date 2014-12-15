package controller;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import entities.Post;

@ManagedBean
@RequestScoped
public class Search {
	
	public String keywords;
	
	public String getKeywords(){
		return keywords;
	}
	
	public void setKeywords(String katakunci){
		this.keywords=katakunci;
	}
	
	void searchwithFirebase(){		
		FirebaseService FBServiceProxy=new FirebaseServiceProxy();
		try {
			List<org.wbd.heroku.service.Post> FindedPost;
			//TODO: FBServiceProxy.search(this.keywords) bisa null, tolong diperbaiki
			//FindedPost = new ArrayList<org.wbd.heroku.service.Post>(Arrays.asList(FBServiceProxy.search(this.keywords)));
			throw new RemoteException();
		} catch (RemoteException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
