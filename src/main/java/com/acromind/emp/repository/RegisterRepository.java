package com.acromind.emp.repository;

import org.springframework.data.repository.CrudRepository;

import com.acromind.emp.model.RegisterModel;

public interface RegisterRepository extends CrudRepository<RegisterModel, Integer> { 
	RegisterModel findByEmailId (String  emailId);
	RegisterModel findByEmailIdAndPassword (String  emailId, String password);
	
}
