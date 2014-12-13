package org.wbd.heroku.helper;

public class Post {
	private String judul, tanggal, konten, id_author;
	private boolean deleted, published;

	public boolean isDeleted() {
		return deleted;
	}

	public String getId_author() {
		return id_author;
	}

	public void setId_author(String id_author) {
		this.id_author = id_author;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getKonten() {
		return konten;
	}

	public void setKonten(String konten) {
		this.konten = konten;
	}
	
}
