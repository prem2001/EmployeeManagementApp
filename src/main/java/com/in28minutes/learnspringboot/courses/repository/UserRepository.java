package com.in28minutes.learnspringboot.courses.repository;

import org.springframework.data.repository.CrudRepository;


import com.in28minutes.learnspringboot.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

} 


