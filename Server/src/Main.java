
import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */
public class Main {
	public static void main(String[] args) {
//		Database db = Database.getDatabase();
		Firebase db = new Firebase("https://if3110-34.firebaseio.com");
		Map<String, String> users = new HashMap<String, String>();
		users.put("alanisawesome", "sd");
		users.put("gracehop", "Ss");
		db.child("sa").setValue(123);
//		db.setValue("A", "ASDFASD");
//		Firebase fb = new Firebase("ok");
	}
//	db.setValue("Alex Wolfe");
}
