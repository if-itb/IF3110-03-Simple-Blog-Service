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
public class PostModel {
	private String id;
	private String title;
	private long date;
	private String content;
	private boolean status;
	private long updated_at;
	
	public PostModel () {
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

	public long getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(long updated_at) {
		this.updated_at = updated_at;
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
