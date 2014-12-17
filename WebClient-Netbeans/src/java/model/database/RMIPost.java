/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.database;

import java.util.List;
import org.ccw.heroku.service.PostModel;

/**
 *
 * @author WILLY
 */
public class RMIPost {
	public RMIPost() {
		
	}
	
	public boolean updatePost(String id, String title, long date, String content, boolean status) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.updatePost(id, title, date, content, status);
	}
	
	public boolean deletePost(String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.deletePost(id);
	}

	public List<PostModel> getAllDeletedPosts() {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getAllDeletedPosts();
	}
	
	public List<PostModel> getAllPublishedPosts() {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getAllPublishedPosts();
	}

	public List<PostModel> getAllUnpublishedPosts() {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getAllUnpublishedPosts();
	}

	public PostModel getPost(String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getPost(id);
	}

	public void publishPost(String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		port.publishPost(id);
	}

	public boolean restorePost(String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.restorePost(id);
	}

	public String createPost(String title, long date, String content) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.createPost(title, date, content);
	}
}
