/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.WebServiceRef;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;
import org.chamerling.heroku.service.IOException_Exception;
import org.chamerling.heroku.service.JSONException_Exception;
import org.chamerling.heroku.service.MalformedURLException_Exception;
import org.chamerling.heroku.service.ParseException_Exception;

/**
 *
 * @author Anggi
 */
@ManagedBean(name = "listPost", eager = true)
@RequestScoped
public class ListPost {

    
	private List<org.chamerling.heroku.service.Post> arrPostPublished;
	private List<org.chamerling.heroku.service.Post> arrPostUnpublished;
	private List<org.chamerling.heroku.service.Post> arrPostDeleted;
        private List<org.chamerling.heroku.service.Post> searchResult;
        private String keyword;
	
	public ListPost(){
            HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
            try {
                arrPostDeleted = new ArrayList<>();
                arrPostUnpublished = new ArrayList<>();
                arrPostPublished = new ArrayList<>();
                for(org.chamerling.heroku.service.Post p: hello.getListPost()){
                    if ((p.getStatus().equals("published")) && (p.getDeletedStatus().equals("notdeleted"))){
                        arrPostPublished.add(p);
                    } else if ((p.getStatus().equals("unpublished")) && (p.getDeletedStatus().equals("notdeleted"))){
                        arrPostUnpublished.add(p);
                    } else {
                        arrPostDeleted.add(p);
                    }
                }

            } catch (IOException_Exception | JSONException_Exception | MalformedURLException_Exception | ParseException_Exception ex) {
                Logger.getLogger(ListPost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        public String searchPost(){
//            System.out.println("--SEARCH--");
//            System.out.println("keyword="+keyword);
//            String haha = "hahaha";
//            System.out.println(haha.contains(this.keyword));
//            searchResult = new ArrayList<>();
//            for(org.chamerling.heroku.service.Post p: arrPostPublished){
//                if (p.getContent().contains(this.keyword) || p.getTitle().contains(this.keyword)){
//                    searchResult.add(p);
//                    System.out.println(p.getTitle());
//                }
//            }
//            return "search_result?faces-redirect=true";
//        }
	
        public String getKeyword(){
            return keyword;
        }
        public void setKeyword(String key){
            this.keyword = key;
        }
	public List<org.chamerling.heroku.service.Post> getArrPostPublished(){
		return arrPostPublished;
	}
        
        public List<org.chamerling.heroku.service.Post> getSearchResult(){
		return searchResult;
	}
	
	public List<org.chamerling.heroku.service.Post> getArrPostUnpublished(){
		return arrPostUnpublished;
	}
        
        public List<org.chamerling.heroku.service.Post> getArrPostDeleted(){
		return arrPostDeleted;
	}
        
        public void setSearchResult(List<org.chamerling.heroku.service.Post> temp){
            searchResult = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: temp){
               searchResult.add(p);
            }
        }
        
        public void setArrPostDeleted(List<org.chamerling.heroku.service.Post> temp){
            arrPostDeleted = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: temp){
                arrPostDeleted.add(p);
            }
        }
        public void setArrPostUnpublished(List<org.chamerling.heroku.service.Post> temp){
            arrPostPublished = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: temp){
                arrPostUnpublished.add(p);
            }
        }
        public void setArrPostPublished(List<org.chamerling.heroku.service.Post> temp){
            arrPostUnpublished = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: temp){
                arrPostUnpublished.add(p);
            }
        }

    

}
