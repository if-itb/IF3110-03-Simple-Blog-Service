package controller;

import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

@ManagedBean
@RequestScoped
public class EditUser {
	private String user_id;
	private String user_username;
	private String user_password;
	private String user_name;
	private String user_email;
	private String user_strRole;
	private int user_role;	

	public void addUser() {
		DatabaseUtility dbUtil = DatabaseUtility.getInstance();

		String query = "INSERT INTO user (username, password, nama, email, role) "
				+ "VALUES ('"
				+ this.getUsername()
				+ "','"
				+ this.getPassword()
				+ "','"
				+ this.getName()
				+ "',"
				+ "'"
				+ this.getEmail()
				+ "'"
				+ "," + this.getRole() + ")";

		System.out.println(query);

		dbUtil.execute(query);
		
		setUsername("");
		setPassword("");
		setName("");
		setEmail("");
		setRole(10);
	}

	public void changeEmail() {
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.editUser(this.getId(), this.getUsername(), this.getPassword(), this.getName(), this.getEmail(), "Editor");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeName() {
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.editUser(this.getId(), this.getUsername(), this.getPassword(), this.getName(), this.getEmail(), "Editor");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changePassword(){
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.editUser(this.getId(), this.getUsername(), this.getPassword(), this.getName(), this.getEmail(), "Editor");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeRole() {
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.editUser(this.getId(), this.getUsername(), this.getPassword(), this.getName(), this.getEmail(), "Editor");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(String id) {
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.deleteUser(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getEmail() {
		return user_email;
	}

	public String getId() {
		return user_id;
	}

	public String getName() {
		return user_name;
	}

	public String getPassword() {
		return user_password;
	}

	public int getRole() {
		return user_role;
	}

	public String getStrRole() {
		return user_strRole;
	}

	public String getUsername() {
		return user_username;
	}

	public void Initialize(){
		
	}
	
	public void setEmail(String email) {
		user_email = email;
	}

	public void setId(String id) {
		user_id = id;
	}

	public void setName(String name) {
		user_name = name;
	}

	public void setPassword(String password) {
		user_password = password;
	}

	public void setRole(int role) {
		user_role = role;
	}

	public void setStrRole(String str) {
		user_strRole = str;
	}
	
	public void setUsername(String username) {
		user_username = username;
	}
	
	public void StrtoIntRole() {
		if (this.user_strRole=="Regular") user_role=10;
		else if (this.user_strRole=="Editor") user_role=20;
		else if (this.user_strRole=="Admin") user_role=30;
	}
	
	public String updateUser() {
		FirebaseService inferno = new FirebaseServiceProxy();
		try {
			inferno.editUser(this.getId(), this.getUsername(), this.getPassword(), this.getName(), this.getEmail(), "regular");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
}
