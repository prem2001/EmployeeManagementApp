package com.in28minutes.learnspringboot.courses.controller;

import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<RegisterModel, Integer> { 
	RegisterModel findByEmailId (String  emailId);
	RegisterModel findByEmailIdAndPassword (String  emailId, String password);
	
}
