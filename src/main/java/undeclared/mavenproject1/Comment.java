/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package undeclared.mavenproject1;

/**
 *
 * @author Gilang
 */
public class Comment {
	
	public int id;
	public int postId;
	public String name;
	public String date;
	public String email;
	public String content;
	
	public Comment(){
		
	}
	
	public Comment(int postId, int commentid, String name, String date, String email, String content){
		this.postId = postId;
		id = commentid;
		this.name = name;
		this.date = date;
		this.email = email;
		this.content = content;
	}
}
