package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;
import org.wbd.heroku.service.User;

import entities.UserDetails;

@ManagedBean
@ApplicationScoped
public class Hell {
	public List<UserDetails> getUserList() {
		List<UserDetails> result = new ArrayList<>();
		FirebaseService inferno = new FirebaseServiceProxy();
		User[] fire;
		try {
			fire = inferno.listUser();

			for (User fira : fire) {
				UserDetails new_user = new UserDetails();
				new_user.setUserId(fira.getId());
				new_user.setUsername(fira.getUsername());
				new_user.setPassword(fira.getPassword());
				new_user.setName(fira.getNama());
				new_user.setEmail(fira.getEmail());
				new_user.setRole(fira.getRole());
				result.add(new_user);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
