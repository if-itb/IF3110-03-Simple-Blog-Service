/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ASUS
 */
@ManagedBean(name = "searchPost", eager = true)
@SessionScoped
public class SearchPost {
    
    private List<org.chamerling.heroku.service.Post> searchResult;
        private String keyword;
    
    public String search(){
        ListPost list = new ListPost();
            System.out.println("--SEARCH--");
            System.out.println("keyword="+keyword);
            String haha = "hahaha";
            System.out.println(haha.contains(this.keyword));
            searchResult = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: list.getArrPostPublished()){
                if (p.getContent().contains(this.keyword) || p.getTitle().contains(this.keyword)){
                    searchResult.add(p);
                    System.out.println(p.getTitle());
                }
            }
            return "search_result?faces-redirect=true";
        }
    
     public String getKeyword(){
            return keyword;
        }
        public void setKeyword(String key){
            this.keyword = key;
        }
         public List<org.chamerling.heroku.service.Post> getSearchResult(){
		return searchResult;
	}
         public void setSearchResult(List<org.chamerling.heroku.service.Post> temp){
            searchResult = new ArrayList<>();
            for(org.chamerling.heroku.service.Post p: temp){
               searchResult.add(p);
            }
        }
}
