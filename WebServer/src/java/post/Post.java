/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package post;

import com.firebase.client.Firebase;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author WILLY
 */
@WebService(serviceName = "Post")
public class Post {

	/**
	 * This is a sample web service operation
	 */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		Firebase fb = new Firebase("https://if3110-34.firebaseio.com/");
		fb.setValue("1231");
		return "ok";
	}
}
