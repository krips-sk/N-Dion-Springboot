package com.example.learningJava.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learningJava.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	

	UserEntity findByEmpIDAndName(String emp,String name);

	List<UserEntity> findByCompany(String company);

	UserEntity findByEmailAndPassword(String mail, String password);

}
