package com.blog.simple.model;

import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import simpleblog.service.endpoint.Post;
import simpleblog.service.endpoint.SimpleblogProxy;

@ManagedBean(name="editBean")
@RequestScoped
public class EditBean {
	private String id;
	private String judul;
	private String konten;
	private String tanggal;
	private String status;
	
	public void dispatchPost() throws RemoteException {
		setId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		SimpleblogProxy s = new SimpleblogProxy();
		Post post = null;
		while(judul==null) {
			post = s.getPost(id);

			setJudul(post.getJudul());
			setKonten(post.getKonten());
			setTanggal(post.getTanggal());
			setStatus(post.getStatus());
		}
	}

	public String editPost() throws RemoteException {
		SimpleblogProxy s = new SimpleblogProxy();
		s.editPost(id, judul, konten, tanggal);
		
		return "index.xhtml";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getKonten() {
		return konten;
	}

	public void setKonten(String konten) {
		this.konten = konten;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
