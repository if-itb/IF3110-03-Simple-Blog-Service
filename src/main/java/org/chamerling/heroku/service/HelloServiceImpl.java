/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chamerling.heroku.service;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHi(String input) {
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}

}