/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import java.sql.Date;

/**
 *
 * @author Yusuf
 */
public class Komentar {

    private String cid;
    private String pid;
    private String komentator;
    private String komen;
    private String email;
    private String commentDate;

    public Komentar() {
        cid="";
        pid="";
        komentator="guest";
        komen="";
        email="";
        java.util.Date date = new java.util.Date();
        commentDate = String.valueOf(date.getYear()+1900)+"-"+String.valueOf(date.getMonth()+1)+"-"+String.valueOf(date.getDate());
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String commentID) {
        cid = commentID;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String postID) {
        pid = postID;
    }

    public String getKomentator() {
        return komentator;
    }

    public void setKomentator(String komentator) {
        this.komentator = komentator;
    }

    public String getKomen() {
        return komen;
    }

    public void setKomen(String Komen) {
        komen = Komen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String CommentDate) {
        commentDate = CommentDate;
    }
}
