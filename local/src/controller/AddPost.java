package controller;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import entities.Post;
import entities.UserData;

@ManagedBean
@RequestScoped
public class AddPost {
	@ManagedProperty(value = "#{userData}")
	private UserData alpha;

	public void setAlpha(UserData z) {
		alpha = z;
	}

	private Post post;

	public AddPost() {
		post = new Post();
	}

	public String getTitle() {
		return post.getTitle();
	}

	public void setTitle(String str) {
		post.setTitle(str);
	}

	public String getContent() {
		return post.getContent();
	}

	public void setContent(String str) {
		post.setContent(str);
	}

	public Date getDate() {
		return post.getDate();
	}

	public void setDate(Date date) {
		System.out.println("Set Date Called");
		post.setDate(date);
		System.out.println(post.getDate().toString());
	}

	public String execute() {
		if (alpha != null) {
			
			@SuppressWarnings("deprecation")
			String date = "" + (1900 + post.getDate().getYear()) + "-"
					+ (post.getDate().getMonth() + 1) + "-"
					+ post.getDate().getDate();

			FirebaseService fire = new FirebaseServiceProxy();
			try {
				fire.addPost(getTitle(), getContent(), date, alpha.getUserID());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "index?faces-redirect=true";
	}
}
