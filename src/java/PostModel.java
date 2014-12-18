/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;

/**
 *
 * @author Riady
 */
public class PostModel {
    public String id;
    public String judul;
    public String status;
    public String konten;
    public String date;
    public ArrayList<CommentModel> comment;
    public PostModel(){
        comment = new ArrayList();
    }
    public PostModel(String _id){
        id=_id;
        comment = new ArrayList();
    }
    
    public void addComment(CommentModel komen){
        comment.add(komen);
    }
}
