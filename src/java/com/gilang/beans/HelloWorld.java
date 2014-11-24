/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gilang.beans;

import javax.faces.bean.ManagedBean;




@ManagedBean(name="hello", eager=true)
public class HelloWorld {
	int waw;
	
	public HelloWorld(){
		waw = 1;
	}
	
	public int getWaw(){
		return waw;
	}
}
