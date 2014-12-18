/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ccw.heroku.model;

/**
 *
 * @author WILLY
 */
public class CommentModel {
	private String id;
	private String post_id;
	private String name;
	private String email;
	private String comment;
	private long created_at;

	public CommentModel () {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(long created_at) {
		this.created_at = created_at;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id) + " " + String.valueOf(post_id) + " " + name + " " + email + " " + comment;
	}
}
