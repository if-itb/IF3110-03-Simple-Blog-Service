package controller;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
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

import entities.Comment;
import entities.Post;
import entities.UserData;

@ManagedBean
@RequestScoped
public class ViewPost {
	private String id, name, email, comment;

	private Post post;

	@ManagedProperty(value = "#{userData}")
	UserData userData;

	public void execute() {
		try {
			List<Comment> result = new ArrayList<>();
			
			FirebaseService inferno = new FirebaseServiceProxy();
			org.wbd.heroku.service.Comment[] comms;
			try {
				comms = inferno.listComment();
				for (org.wbd.heroku.service.Comment comm : comms) {
					Comment comment = new Comment();
					comment.setName(comm.getNama());
					comment.setEmail(comm.getEmail());
					comment.setTime(comm.getTanggal());
					comment.setContent(comm.getKonten());
					result.add(comment);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			DatabaseUtility dbUtil = DatabaseUtility.getInstance();
			ResultSet rs = dbUtil.execute("SELECT * FROM `post` WHERE `id` = "
					+ id);
			if (rs != null) {
				rs.next();
				post = new Post();
				post.setId(rs.getInt(1));
				post.setTitle(rs.getString(3));
				post.setContent(rs.getString(4));
				post.setDate(rs.getDate(5));
			}
		} catch (SQLException ex) {
			System.err.println("Error when getting post with id = " + id);
		}
	}

	public String getComment() {
		return comment;
	}

	public List<Comment> getComments() {
		List<Comment> result = new ArrayList<>();
		
		FirebaseService inferno = new FirebaseServiceProxy();
		org.wbd.heroku.service.Comment[] comms;
		try {
			comms = inferno.listComment();
			for (org.wbd.heroku.service.Comment comm : comms) {
				Comment comment = new Comment();
				comment.setName(comm.getNama());
				comment.setEmail(comm.getEmail());
				comment.setTime(comm.getTanggal());
				comment.setContent(comm.getKonten());
				result.add(comment);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public String getContent() {
		return post.getContent();
	}

	public Date getDate() {
		return post.getDate();
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param id_user
	 * @return posts of id_user
	 */
	public List<Post> getOwnerPostList() {
		FirebaseService inferno = new FirebaseServiceProxy();
	List<Post> result = new ArrayList<>();
	org.wbd.heroku.service.Post[] posts;
	try {
		posts = inferno.listPost(6);
		for (org.wbd.heroku.service.Post p : posts) {
			Post post = new Post();
			post.setId(p.getId());
			post.setTitle(p.getJudul());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			post.setDate(df.parse(p.getTanggal()));
			post.setContent(p.getKonten());
			if (p.getId_author().equals(userData.getDetails().getUserId()))
				result.add(post);
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result;
	}

	public List<Post> getPublishednotDeletedPostList() {
		FirebaseService inferno = new FirebaseServiceProxy();
		List<Post> result = new ArrayList<>();
		org.wbd.heroku.service.Post[] posts;
		try {
			posts = inferno.listPost(6);
			for (org.wbd.heroku.service.Post p : posts) {
				Post post = new Post();
				post.setId(p.getId());
				post.setTitle(p.getJudul());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				post.setDate(df.parse(p.getTanggal()));
				post.setContent(p.getKonten());
				result.add(post);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Post> getSoftDeletedPostList() {
		FirebaseService inferno = new FirebaseServiceProxy();
		List<Post> result = new ArrayList<>();
		org.wbd.heroku.service.Post[] posts;
		try {
			posts = inferno.listPost(11);
			for (org.wbd.heroku.service.Post p : posts) {
				Post post = new Post();
				post.setId(p.getId());
				post.setTitle(p.getJudul());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				post.setDate(df.parse(p.getTanggal()));
				post.setContent(p.getKonten());
				result.add(post);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public String getTitle() {
		return post.getTitle();
	}

	public List<Post> getUnpublishedPostList() {
		FirebaseService inferno = new FirebaseServiceProxy();
		List<Post> result = new ArrayList<>();
		org.wbd.heroku.service.Post[] posts;
		try {
			posts = inferno.listPost(13);
			for (org.wbd.heroku.service.Post p : posts) {
				Post post = new Post();
				post.setId(p.getId());
				post.setTitle(p.getJudul());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				post.setDate(df.parse(p.getTanggal()));
				post.setContent(p.getKonten());
				result.add(post);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public String postComment() {
		FirebaseService inferno = new FirebaseServiceProxy();
		Date date = new Date(System.currentTimeMillis());
		String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			inferno.addComment(name, email, comment, newstring, id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setDummy(String lol) {}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String i) {
		id = i;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserData(UserData ud) {
		userData = ud;
	}

}
