package model.database;


import org.ccw.heroku.service.UserModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */
public class RMIUser {
	public RMIUser() {
		
	}

	public boolean createUser(java.lang.String email, java.lang.String username, java.lang.String password, java.lang.String role) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.createUser(email, username, password, role);
	}

	public boolean deleteUser(java.lang.String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.deleteUser(id);
	}

	public java.util.List<org.ccw.heroku.service.UserModel> getAllUsers() {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getAllUsers();
	}

	public UserModel getUser(java.lang.String id) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.getUser(id);
	}

	public boolean updateUser(java.lang.String id, java.lang.String email, java.lang.String username, java.lang.String password, java.lang.String role) {
		org.ccw.heroku.service.CCWwebserviceService service = new org.ccw.heroku.service.CCWwebserviceService();
		org.ccw.heroku.service.CCWwebservice port = service.getCCWwebservicePort();
		return port.updateUser(id, email, username, password, role);
	}
}
