/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Database.DatabaseAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.penguasadunia.PenguasaDuniaService;
import org.penguasadunia.PenguasaDuniaService_Service;
import org.penguasadunia.ServiceComment;

/**
 *
 * @author kevinyu
 */
public class Comments {
    private static Comments instance;
    PenguasaDuniaService serviceEndpoint;
    
    private Comments() {
        serviceEndpoint = new PenguasaDuniaService_Service().getPenguasaDuniaServicePort();
    }
    
    public static Comments getInstance() {
        if (instance==null){
            instance = new Comments();
        }
        return instance;
    }
    
    public void addComment(Comment comment) {
        String isGuest;
        if (comment.isGuest()) {
            isGuest = "true";
        }
        else{
            isGuest = "false";
        }
        serviceEndpoint.addServiceComment(comment.getName(), comment.getEmail(), comment.getText(), comment.getTimeString(), comment.getPostId(),comment.getCreatorId(),isGuest);
    }
    
    public ArrayList<Comment> getCommentByPostId(String postId) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        List<ServiceComment> serviceComments = serviceEndpoint.listServiceComment();
        for (ServiceComment serviceComment : serviceComments) {
            if (serviceComment.getIdPost().equals(postId)) {
                Comment comment = new Comment();
                comment.setCreatorId(serviceComment.getIdUser());
                comment.setEmail(serviceComment.getEmail());
                comment.setGuest(serviceComment.getGuest().equals("true"));
                comment.setId(serviceComment.getKey());
                comment.setName(serviceComment.getUsername());
                comment.setPostId(serviceComment.getIdPost());
                comment.setText(serviceComment.getKomentar());
                comment.setTimeString(serviceComment.getTanggal());
                comments.add(comment);
            }
        }
        return comments;
    }
    
    public void deleteCommentByPostId(String postId) {
        ArrayList<Comment> comments = getCommentByPostId(postId);
        for (Comment comment : comments) {
            serviceEndpoint.deleteServiceComment(comment.getId());
        }
    }
    
}
