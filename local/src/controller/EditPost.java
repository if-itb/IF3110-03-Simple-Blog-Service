package controller;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import entities.Post;

@ManagedBean
public class EditPost {

	@ManagedProperty(value = "#{viewPost}")
	private ViewPost view;

	private Post post;

	public EditPost() {
		post = new Post();
	}

	public String getContent() {
		return post.getContent();
	}

	public String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String tempDate = df.format(post.getDate());
		return tempDate;
	}

	public String getId() {
		return post.getId();
	}

	public String getTitle() {
		return post.getTitle();
	}

	public void HardDelete(String id) {
		FirebaseService fire = new FirebaseServiceProxy();
		try {
			fire.pulverizePost(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize() {
		view = new ViewPost();
		view.setId(this.post.getId());
		view.execute();
		this.setContent(view.getContent());
		post.setDate(view.getDate());
		this.setTitle(view.getTitle());
	}

	public void setContent(String str) {
		post.setContent(str);
	}

	public void setDate(String dateStr) {
		System.out.println("Set date Called");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
		try {
			date = formatter.parse(dateStr);
			post.setDate(date);
			System.out.println(getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to set Date!");
			e.printStackTrace();
		}
	}

	public void setId(String id) {
		post.setId(id);
	}

	public void setTitle(String str) {
		post.setTitle(str);
	}

	public void setView(ViewPost vp) {
		view = vp;
	}
}
