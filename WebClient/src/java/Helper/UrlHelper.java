/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author upix
 */
public class UrlHelper {
    public static String getString(String url_addr) {
        try {
            URL url = new URL(url_addr);
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
             
            String line;
            String output = "";
            while ( (line = br.readLine()) != null)
                output += line;
             
            br.close();
            is.close();
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }
}
