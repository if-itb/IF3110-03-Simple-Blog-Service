package controller;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import entities.Post;

@ManagedBean
@RequestScoped
public class Search {

	public String keywords;
	public String finalkeywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String katakunci) {
		this.keywords = katakunci;
	}

	public void find(){
		finalkeywords=keywords;
	}
	
	public List<Post> getwantedPostList() {
		FirebaseService aeroga = new FirebaseServiceProxy();
		List<Post> FindedPost = new ArrayList<>();
		org.wbd.heroku.service.Post[] posts;
		
		//versi kmrn
		/*try {
			List<org.wbd.heroku.service.Post> FindedPost;

			FindedPost = new ArrayList<org.wbd.heroku.service.Post>(
					Arrays.asList(FBServiceProxy.search(this.keywords)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try{
			posts=aeroga.search(this.finalkeywords);
			//System.out.println(this.finalkeywords);
			//System.out.println(this.keywords);
			
			for (org.wbd.heroku.service.Post p : posts) {
				Post post = new Post();
				post.setId(p.getId());
				post.setTitle(p.getJudul());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				post.setDate(df.parse(p.getTanggal()));
				post.setContent(p.getKonten());				
				FindedPost.add(post);
			}
		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FindedPost;
		
	}
}
