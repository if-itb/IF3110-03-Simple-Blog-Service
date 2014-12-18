/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author calvin-pc
 */
public class SearchPostBean {

    /**
     * Creates a new instance of SearchPostBean
     */
    private String keyword;
    private List<Post> matchedPost;
    public SearchPostBean() {
        matchedPost = new ArrayList<Post>();
    }
    
    public void search() {
        //TODO minta ke webservice
        matchedPost.clear();
        List<heroku.service.Post> soapMatchedPost = service.BlogService.getInstance().searchPost(keyword);
        for ( heroku.service.Post post : soapMatchedPost) {
            matchedPost.add(service.Utility.soapToLocal(post));
        }
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the matchedPost
     */
    public List<Post> getMatchedPost() {
        return matchedPost;
    }
}
