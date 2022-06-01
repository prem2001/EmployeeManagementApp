package com.in28minutes.learnspringboot.courses.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.repository.UserRepository;
import com.in28minutes.learnspringboot.model.User;

@RestController
public class EmployeeController {
	@Autowired
	private RegisterRepository registerRepository;

	@PostMapping("/register")
	public EmployeeResponseDto register(@RequestBody EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto response = new EmployeeResponseDto();

		RegisterModel model = new RegisterModel();
		String firstName = employeeRequestDto.getFirstName();
		model.setFirstName(firstName);
		String lastName = employeeRequestDto.getLastName();
		model.setLastName(lastName);
		String emailId = employeeRequestDto.getEmailId();
		model.setEmailId(emailId);
		String password = employeeRequestDto.getPassword();
		model.setPassword(password);

		RegisterModel returnvalue = registerRepository.findByEmailId(emailId);

		if (returnvalue == null) {
			response.setMessage("Register Successfully");
            response.setIsSuccess(true);
			registerRepository.save(model);
		} else {
		
			response.setMessage("Already exist");
			response.setIsSuccess(false);
		}
		return response;
	}

	@PostMapping("/login")
	public EmployeeLoginResponseDto login(@RequestBody EmployeeLoginRequestDto employeeLoginRequestDto) {
		EmployeeLoginResponseDto response = new EmployeeLoginResponseDto();

		String emailId = employeeLoginRequestDto.getEmailId();
		String password = employeeLoginRequestDto.getPassword();

		RegisterModel returnModel = registerRepository.findByEmailIdAndPassword(emailId, password);

		if (returnModel == null) {
			// not valid user
			response.setMessage("Login not Successfully");
			response.setIsSuccess(false);

		} else {
			// valid user
			response.setMessage("Login Successfully");
			response.setIsSuccess(true);

		}

		return response;

	}
}