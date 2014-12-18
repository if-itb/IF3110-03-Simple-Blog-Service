/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Indam Muhammad
 */
@ManagedBean(name="commentAdd", eager=true)
@ViewScoped
public class CommentAdd implements Serializable {
    private String id_pos;

    public String getId_pos() {
        return id_pos;
    }

    public void setId_pos(String id_pos) {
        this.id_pos = id_pos;
    }

    public CommentAdd(){
    }
    
    public void addComment(String name, String email, String komentar){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        CurrentDate cdate = new CurrentDate();
        hello.addComment(id_pos, name, email, komentar, cdate.getCDate());
    }

    public void addCommentUser(String id, String komentar){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Member1 _mem = hello.getMemberById(id);
        CurrentDate cdate = new CurrentDate();
        hello.addComment(id_pos, _mem.getName(), _mem.getEmail(), komentar, cdate.getCDate());
    }

    public void execute(String i){
        id_pos = i;
    }
}