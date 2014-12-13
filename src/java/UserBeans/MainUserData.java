/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;


import com.firebase.client.Firebase;
import com.firebase.client.Transaction.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yusuf
 */
public class MainUserData {
    public static void main(String[] args){
        Firebase ref = new Firebase("https://simpleblogjsf.firebaseio.com/");
        ref.authWithCustomToken(null, null);
        Firebase komenRef = ref.child("komentar");
        Komentar komenParam = new Komentar();
        komenParam.setPid(4);
        komenParam.setCid(10);
        komenParam.setKomentator("hayyu");
        komenParam.setKomen("nyoba post ke firebase");
        komenParam.setEmail("hayyu@gmail.com");
//        Map<String, Komentar> komentar = new HashMap<String, Komentar>();
//        komentar.put("4", komenParam);
        String coba = "nyoba aja";
        komenRef.setValue(coba);
        komenRef.push();
    }
}
