package com.blog.simple.bean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import simpleblog.service.endpoint.Post;
import simpleblog.service.endpoint.SimpleblogProxy;

@ManagedBean(name="searchBean")
@RequestScoped
public class SearchBean {
	private String keyword;
	private List<Post> listRslt;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public void search() throws IOException {
		System.out.println(keyword);
		SimpleblogProxy s = new SimpleblogProxy();
		Post[] posts = s.search(keyword);

		ArrayList<Post> list = new ArrayList<Post>();
        for(int i=0;i<posts.length;++i) {
     		   list.add(posts[i]);   
        }
        keyword="";
		setListRslt(list);
		
		FacesContext.getCurrentInstance().getExternalContext().dispatch("Search.xhtml");
	}

	public List<Post> getResultList() {
		return listRslt;
	}
	
	public List<Post> getListRslt() {
		return listRslt;
	}

	public void setListRslt(ArrayList<Post> listRslt) {
		this.listRslt = listRslt;
	}
}
