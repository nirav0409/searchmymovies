package com.in28minutes.springboot.tutorial.basics.application.configuration.loginManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManagerService {

	
//	@Autowired
//	PersonCrudManager personCrudManager;

	public void addUser(Person person) {
		// TODO Auto-generated method stub
	//	personCrudManager.save(person);
	}

	public boolean getUser(String user, String Password) {
		// TODO Auto-generated method stub
		return true;
	//	return personCrudManager.findById(user).isPresent();
	}

	
}
