package com.gilang.beans;

import com.gilang.sql.DBAdapter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hello", eager=true)
@SessionScoped
public class HelloWorld {
	int waw;
	
	public HelloWorld(){
		waw = 1;
		DBAdapter adapter = new DBAdapter();
		adapter.readDB();
		System.out.println("db update");
	}
	
	public int getWaw(){
		return waw;
	}
	
	public void print(){
		System.out.println("sdsahdsad");
	}
}
