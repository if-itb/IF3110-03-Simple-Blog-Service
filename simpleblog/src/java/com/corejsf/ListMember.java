/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

/**
 *
 * @author Arina Listyarini DA
 */

@ManagedBean(name = "listmember")
@RequestScoped
public class ListMember {
    private ArrayList<Member1> members;
    /**
     * Creates a new instance of ListMember
     */
    public ListMember() {
        members = new ArrayList<Member1>();
        HelloService hello = new HelloServiceImplService().getHelloServiceImplPort();
        for(org.chamerling.heroku.service.Member1 mem : hello.getMember().getMembers()){
            Member1 _mem = new Member1();
            _mem.setId(mem.getId());
            _mem.setEmail(mem.getEmail());
            _mem.setName(mem.getName());
            _mem.setPassword(mem.getPassword());
            _mem.setRole(mem.getRole());
            members.add(_mem);
        }
    }

    public void setMembers(ArrayList<Member1> members) {
        this.members = members;
    }
    
    
    
    public ArrayList<Member1> getMembers(){
        return members;
    }
    
}
