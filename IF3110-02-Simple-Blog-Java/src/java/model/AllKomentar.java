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
 * @author Afik
 */
public class AllKomentar {

    private String PID;
    private ArrayList<Komentar> allKomentar;

    /**
     * Creates a new instance of AllKomentar
     */
    public AllKomentar() {
    }
    
    public String getPID(){
        return PID;
    }
    
    public ArrayList <Komentar> getAllKomentar() {
        
        List<heroku.service.Komentar> X = service.BlogService.getInstance().listComment(PID);
        allKomentar.clear();
        
        for (int i =0; i < X.size(); i++) {
            allKomentar.add(service.Utility.soapToLocal(X.get(i)));
        }
        
        return allKomentar;
        /*
        allKomentar = new ArrayList<Komentar> (DAO.DAOFactory.getInstance("javabase.jdbc").getKomentarDAO().list(PID));
        System.out.println("flag : " + PID);
        return allKomentar;
                */
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
    
    public void setAllKomentar(ArrayList <Komentar> allKomentar) {
        this.allKomentar = allKomentar;
    }
}
