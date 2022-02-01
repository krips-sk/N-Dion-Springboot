package com.example.learningJava.resources;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningJava.entity.UserEntity;
import com.example.learningJava.repo.UserRepo;

import encoder.AES;

@RestController
@RequestMapping("/api")
public class UserResources {
	@Autowired
	private UserRepo userrepo;

	@PostMapping("/saveuser")
	public String saveuser(@RequestBody UserEntity user) {
		String company = "";
		try {
			List<UserEntity> res = userrepo.findByCompany(user.getCompany());
			if (!res.isEmpty()) {
				company = "Already exist";

			} else {
				userrepo.save(user);
				company = "Saved succesfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String mail, String password) {
		String msg="";
		try {
			UserEntity res = userrepo.findByEmailAndPassword(mail, password );
			if(res != null) {
				msg= "9999";
			}
			else {
				msg= "9990";
			}
		}
		catch(Exception error) {
			error.printStackTrace();
		}
		
		return msg;
		
	}

	@GetMapping("/getuserbyid")
	public Optional<UserEntity> getuserbyid(@RequestParam("id") Long ID) {
		Optional<UserEntity> enty = userrepo.findById(ID);
		return enty;
	}

	@GetMapping("/getuserbyemp")
	public UserEntity getuserbyemp(@RequestParam String emp, String name) {
		UserEntity empDet = userrepo.findByEmpIDAndName(emp, name);
		return empDet;
	}

	@GetMapping("/getalluser")
	public List<UserEntity> getalluser() {
		List<UserEntity> alluser = userrepo.findAll();
		return alluser;
	}
	
//	@GetMapping("/login")
//	public UserEntity login(@RequestParam String user, String password) {
//		UserEntity loginresp = userrepo.findAll();
//		return loginresp;
//	}
	
	@PostMapping("/registration")
	public UserEntity registration(@RequestBody UserEntity user) {
		final String secretKey = "ssshhhhhhhhhhh!!!!";
	    String encryptedString = AES.encrypt(user.getPassword(), secretKey) ;
	    user.setPassword(encryptedString);
//	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
		UserEntity register =userrepo.save(user);
		return register;
	}
}
