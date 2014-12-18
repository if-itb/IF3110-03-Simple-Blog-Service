package com.blog.simple.bean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import simpleblog.service.endpoint.SimpleblogProxy;

@ManagedBean(name="newPost")
@RequestScoped
public class NewPost {
    private String title;
    private String tanggal;
    private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

    public void add() throws RemoteException {
    	SimpleblogProxy s = new SimpleblogProxy();
    	boolean b = s.addPost(title, content, tanggal);
    	System.out.println("asdasd");
    	try {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
}