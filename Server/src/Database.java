
import com.firebase.client.Firebase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */

public class Database extends Firebase {
	
	private static Database myDatabase = new Database("https://if3110-34.firebaseio.com/");
	
	private Database(String url) {
		super(url);
	}
	
	public static Database getDatabase() {
		return myDatabase;
	}
}
