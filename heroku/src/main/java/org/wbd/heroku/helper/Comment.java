package org.wbd.heroku.helper;

public class Comment {
	private String nama, email, kontent;
	private int id, id_post;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKontent() {
		return kontent;
	}

	public void setKontent(String kontent) {
		this.kontent = kontent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

}
