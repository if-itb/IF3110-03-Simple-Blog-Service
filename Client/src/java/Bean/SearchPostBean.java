/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Model.Post;
import Model.Posts;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author kevinyu
 */
@ManagedBean

public class SearchPostBean {
   private ArrayList<Post> searchedPosts;
   private String searchKey;
   
   public SearchPostBean() {
       searchedPosts = new ArrayList<Post>();
   }

    public ArrayList<Post> getSearchedPosts() {
        return searchedPosts;
    }

    public void setSearchedPosts(ArrayList<Post> searchedPosts) {
        this.searchedPosts = searchedPosts;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
   
   public void search() {
       searchedPosts = Posts.getInstance().getPostBySearchKey(searchKey);
   }
}
