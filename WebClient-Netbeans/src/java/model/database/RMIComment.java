package model.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */
public class RMIComment {
	
	public RMIComment() {
		
	}

	public java.util.List<org.ccw.heroku.service.CommentModel> getAllComments(java.lang.String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getAllComments(id);
	}

	public boolean createComment(java.lang.String postId, java.lang.String name, java.lang.String email, java.lang.String comment) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.createComment(postId, name, email, comment);
	}
}
