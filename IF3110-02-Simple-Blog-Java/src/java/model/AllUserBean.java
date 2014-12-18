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
public class AllUserBean {
    
    private ArrayList <UserBean> allUser; 
    /**
     * Creates a new instance of AllUserBean
     */
    public AllUserBean() {
    }

    /**
     * @return the allUser
     */
    public ArrayList <UserBean> getAllUser() {
        List<heroku.service.UserBean> X = service.BlogService.getInstance().listUser();
        
        allUser = new ArrayList<UserBean>();
        for (int i =0; i < X.size() ; i++) {
            allUser.add(service.Utility.soapToLocal(X.get(i)));
        }
        
        return allUser;
        /*
        allUser = new ArrayList<UserBean> (DAO.DAOFactory.getInstance("javabase.jdbc").getUserDAO().list());
        return allUser;*/
    }

    /**
     * @param allUser the allUser to set
     */
    public void setAllUser(ArrayList <UserBean> allUser) {
        this.allUser = allUser;
    }
    
}
