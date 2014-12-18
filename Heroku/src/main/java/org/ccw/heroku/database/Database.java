/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ccw.heroku.database;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ccw.heroku.model.Constant;

/**
 *
 * @author WILLY
 */
public class Database extends Firebase {
	private static Database database = new Database(Constant.FIREBASE_URL);
	
	private Database(String url) {
		super(url);
	}
	
	public static Database getDatabase() {
		return database;
	}

	public static String readURL(String urlString) {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder buffer = new StringBuilder();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read); 
			}

			return buffer.toString();
		} catch (IOException ex) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		
		return null;
	}
}
