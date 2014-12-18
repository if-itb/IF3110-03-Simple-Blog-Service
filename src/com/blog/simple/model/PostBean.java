package com.blog.simple.model;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import simpleblog.service.endpoint.Post;
import simpleblog.service.endpoint.SimpleblogProxy;
@ManagedBean(name="postBean")
@ViewScoped
public class PostBean {
	
	public List<Post> getPublishedPostList() throws RemoteException {		
		SimpleblogProxy s = new SimpleblogProxy();
		Post[] posts;
		posts = s.listPost();
		
		List<Post> list = new ArrayList<Post>();
		for(int i=0;i<posts.length;++i){ 
				if(posts[i].getStatus().equalsIgnoreCase("published"))
					list.add(posts[i]);
		}
		
		return list;
	}
	
	public List<Post> getUnpublishedPostList() throws RemoteException {
		SimpleblogProxy s = new SimpleblogProxy();
		Post[] posts;
		posts = s.listPost();
		
		List<Post> list = new ArrayList<Post>();
		for(int i=0;i<posts.length;++i) 
			if(posts[i].getStatus().equalsIgnoreCase("unpublished"))
				list.add(posts[i]);
		
		return list;
	}

	public List<Post> getPostList() throws RemoteException {
		SimpleblogProxy s = new SimpleblogProxy();
		Post[] posts;
		posts = s.listPost();
		
		List<Post> list = new ArrayList<Post>();
		for(int i=0;i<posts.length;++i)  
			list.add(posts[i]);
		
		return list;
	}
	
	public void deletePost() throws RemoteException {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		SimpleblogProxy s = new SimpleblogProxy();
		s.deletePost(id);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void publishPost() throws RemoteException {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		SimpleblogProxy s = new SimpleblogProxy();
		s.publishPost(id);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
