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

    private int cid;
    private int pid;
    private String komentator;
    private String komen;
    private String email;
    private Date commentDate;

    public Komentar() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int commentID) {
        cid = commentID;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int postID) {
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

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date CommentDate) {
        commentDate = CommentDate;
    }
}
