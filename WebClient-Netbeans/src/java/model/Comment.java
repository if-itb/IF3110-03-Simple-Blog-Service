/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.ccw.heroku.service.CommentModel;

/**
 *
 * @author christangga
 */
public class Comment {
	
	private String id;
	private String post_id;
	private String name;
	private String email;
	private long date;
	private String comment;
	
	/**
	 * Creates a new instance of Comment
	 */
	public Comment() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setCommentFromCommentmodel (CommentModel commentModel) {
		this.id = commentModel.getId();
		this.post_id = commentModel.getPostId();
		this.name = commentModel.getName();
		this.comment = commentModel.getComment();
		this.date = commentModel.getCreatedAt();
		this.email = commentModel.getEmail();
	}
	
	@Override
	public String toString() {
		return String.valueOf(id) + " " + String.valueOf(post_id) + " " + name + " " + email + " " + comment;
	}
}
