package controller;

import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

@ManagedBean
@RequestScoped
public class EditPostStatus {
	private int id;

	public void delete(String id) {
		FirebaseService fire = new FirebaseServiceProxy();
		try {
			fire.setPostDelete(id, true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void undelete(String id) {
		FirebaseService fire = new FirebaseServiceProxy();
		try {
			fire.setPostDelete(id, false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void publish(String id) {
		FirebaseService fire = new FirebaseServiceProxy();
		try {
			fire.setPostPublish(id, true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unpublish(String id) {
		FirebaseService fire = new FirebaseServiceProxy();
		try {
			fire.setPostPublish(id, false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

}