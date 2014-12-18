package com.blog.simple.db;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.rowset.CachedRowSet;

import simpleblog.service.endpoint.SimpleblogProxy;

import com.blog.simple.SHA512;
import com.blog.simple.model.User;
import com.blog.simple.model.User.Role;

public class UserDAOHeroku implements UserDAO {

	private SimpleblogProxy proxy;
	
	// specially created, since the original DAOFactory cannot be used to handle web services, only SQLs
	public UserDAOHeroku() {
		this.proxy = new SimpleblogProxy();
	}
	
	@Override
	public User find(Long id) throws DAOException {
		User ret = null;
		
		return ret;
	}

	@Override
	public User find(String name) throws DAOException {
		User ret = null;
		
		Collection<User> collect = selectUserAsCollection();
		User list[] = new User[collect.size()];
		collect.toArray(list);
		
		for(int i = 0; i < list.length && ret == null; i++) {
			if(list[i].getName().equals(name)) {
				ret = list[i];
			}
		}
		
		return ret;
	}

	@Override
	public User find(String name, String passwordHash) throws DAOException {
		User ret = null;
		
		Collection<User> collect = selectUserAsCollection();
		User list[] = new User[collect.size()];
		collect.toArray(list);
		
		for(int i = 0; i < list.length && ret == null; i++) {
			if(list[i].getName().equals(name) && list[i].getPassword().equals(passwordHash)) {
				ret = list[i];
			} else {
				//throw new DAOException("Caught not same password: " + passwordHash + " vs " + list[i].getPassword());
			}
		}
		
		return ret;
	}

	@Override
	public void create(User user) throws IllegalArgumentException, DAOException {
		String name = user.getName();
		String password = SHA512.hashText(user.getPassword());
		String role = user.getRoleDescription();
		String email = user.getEmail();
		
		try {
			proxy.addUser(name, password, email, role);
		} catch (RemoteException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(User user) throws IllegalArgumentException, DAOException {
		String id = user.getId().toString();
		String name = user.getName();
		String password = user.getPassword();
		String role = user.getRoleDescription();
		String email = user.getEmail();
		
		try {	
			proxy.editUser(id, name, password, role, email);
		} catch (RemoteException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void changePassword(User user, String newPasswordHash)
			throws IllegalArgumentException, DAOException {
		String id = user.getId().toString();
		String name = user.getName();
		String password = user.getPassword();
		String role = user.getRoleDescription();
		String email = user.getEmail();
		
		try {
			proxy.editUser(id, name, password, role, email);
		} catch (RemoteException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(User user) throws IllegalArgumentException, DAOException {
		delete(user.getId());
	}

	@Override
	public void delete(String id) throws DAOException {
		try {
			proxy.deleteUser(id.toString());
		} catch (RemoteException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public CachedRowSet selectUserAsRowSet() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> selectUserAsCollection() throws DAOException {
		Collection<User> ret = new ArrayList<>();
		
		try {
			simpleblog.service.endpoint.User[] listUser = proxy.listUser();
			
			for(simpleblog.service.endpoint.User user: listUser) {
				User temp = mapUser(user);
				
				ret.add(temp);
			}
		} catch (RemoteException e) {
			throw new DAOException(e);
		}
		
		return ret;
	}

	private static User mapUser(simpleblog.service.endpoint.User user) {
		User ret = new User();
		
		ret.setId(user.getId());
		ret.setName(user.getName());
		ret.setPassword(user.getPassword());
		ret.setRole(Role.getRole(user.getRole()));
		ret.setEmail(user.getEmail());
		
		return ret;
	}
}
