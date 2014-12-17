/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.ccw.heroku.service.PostModel;

/**
 *
 * @author christangga
 */
public class Post {

	private String id;
	private String title;
	private long date;
	private String content;
	private boolean status;
	
	/**
	 * Creates a new instance of Post
	 */
	public Post() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setPostFromPostmodel(PostModel postModel) {
		this.id = postModel.getId();
		this.title = postModel.getTitle();
		this.date = postModel.getDate();
		this.content = postModel.getContent();
		this.status = postModel.isStatus();
	}

	@Override
	public String toString() {
		if (status) {
			return String.valueOf(id) + " " + title + " " + date + " " + content + " true";
		} else {
			return String.valueOf(id) + " " + title + " " + date + " " + content + " false";
		}
	}
}
