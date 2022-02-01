package com.example.learningJava.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningJava.entity.EmployeeEntity;
import com.example.learningJava.repo.EmployeeRepo;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	@RequestMapping(value = "/empdetails", method = RequestMethod.POST)
	public EmployeeEntity empdetails(@RequestBody EmployeeEntity details) {
		return emprepo.save(details);
	}
	

}
