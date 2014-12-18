/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.Post;
import Model.Posts;
import java.util.ArrayList;

/**
 *
 * @author kevinyu
 */
public class PostsTest {
    
    public static void main(String[] args){
        
//        Post newPost = new Post();
//        newPost.setTitle("Melvin Pek");
//        newPost.setText("Melvin Pek kamu mau pergi ke mana");
//        newPost.setTimeString("2012-02-03");
//        newPost.setCreatorId("kevinyu");
//        Posts.getInstance().insertPostDB(newPost);
//        
//        ArrayList<Post> posts = Posts.getInstance().getUnpublishedPost();
//        for (Post post : posts) {
//            System.out.println("INFO POST unpublished");
//            System.out.println("Text : "+ post.getText());
//            System.out.println("CreatorId : "+ post.getCreatorId());
//            System.out.println("Id : "+ post.getId());
//            System.out.println("Time : "+ post.getTimeString());
//            if (post.isDeleted()){
//                System.out.println("Deleted : true");
//            }
//            else {
//                System.out.println("Deleted : false");
//            }
//        }
//        
//        ArrayList<Post> posts2 = Posts.getInstance().getPublishedPost();
//        for (Post post : posts2) {
//            System.out.println("INFO POST published");
//            System.out.println("Text : "+ post.getText());
//            System.out.println("CreatorId : "+ post.getCreatorId());
//            System.out.println("Id : "+ post.getId());
//            System.out.println("Time : "+ post.getTimeString());
//            if (post.isDeleted()){
//                System.out.println("Deleted : true");
//            }
//            else {
//                System.out.println("Deleted : false");
//            }
//        }
        
        ArrayList<Post> posts3 = Posts.getInstance().getPostBySearchKey("Melvin Pek");
        for (Post post : posts3) {
            System.out.println("INFO POST deleted");
            System.out.println("Text : "+ post.getText());
            System.out.println("CreatorId : "+ post.getCreatorId());
            System.out.println("Id : "+ post.getId());
            System.out.println("Time : "+ post.getTimeString());
            if (post.isPublished()){
                System.out.println("Published : true");
            }
            else {
                System.out.println("Published : false");
            }
        }
    }
}
