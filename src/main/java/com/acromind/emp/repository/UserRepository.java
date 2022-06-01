package com.acromind.emp.repository;

import org.springframework.data.repository.CrudRepository;

import com.acromind.emp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

} 


