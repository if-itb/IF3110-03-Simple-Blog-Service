/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Gifari
 */

@ManagedBean(name = "memberController")
@ViewScoped

public class MemberController {
    private String id;
    private Member1 mem;
    
    public MemberController(){
        mem = new Member1();
    }
    
    public String getId(){
        return id;
    }
    public Member1 getMem(){
        return mem;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setMem(Member1 mem){
        this.mem = new Member1();
        this.mem.setId(mem.getId());
        this.mem.setEmail(mem.getEmail());
        this.mem.setName(mem.getName());
        this.mem.setPassword(mem.getPassword());
        this.mem.setRole(mem.getRole());
    }
    
    public void addMember(String Email, String Name, String Password, String Role){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.addMember(Email, Name, Password, Role);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public void edit(){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.editMember(mem.getId(), mem.getEmail(), mem.getName(), mem.getPassword(), mem.getRole());
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public void execute(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        org.chamerling.heroku.service.Member1 mm = hello.getMemberById(id);
        mem.setEmail(mm.getEmail());
        mem.setId(mm.getId());
        mem.setName(mm.getName());
        mem.setPassword(mm.getPassword());
        mem.setRole(mm.getRole());
        this.id = id;
    }
    
    public String deleteMember(String id){
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        hello.deleteMember(id);
        return "user?faces-redirect=true";
    }
}
