package org.wbd.heroku.helper;

public final class Post {
	private String judul, tanggal, konten, id_author, id;

	private boolean deleted, published;

	public Post() {

	}

	public Post(String judul, String tanggal, String konten, String id_author) {
		setJudul(judul);
		setTanggal(tanggal);
		setKonten(konten);
		setId_author(id_author);
	}

	public String getId() {
		return id;
	}

	public String getId_author() {
		return id_author;
	}

	public String getJudul() {
		return judul;
	}

	public String getKonten() {
		return konten;
	}

	public String getTanggal() {
		return tanggal;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public boolean isPublished() {
		return published;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId_author(String id_author) {
		this.id_author = id_author;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public void setKonten(String konten) {
		this.konten = konten;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	
	public int getMask() {
		int mask = 15;
		
		mask &= deleted ? 12 : 3;
		mask &= published ? 10 : 5;
		
		return mask;
	}

	@Override
	public String toString() {
		return "Judul = " + judul + "\nTanggal = " + tanggal + "\nKonten = "
				+ konten + "\nId Author = " + id_author + "\nPublished = "
				+ published + "\nDeleted = " + deleted;
	}

}
