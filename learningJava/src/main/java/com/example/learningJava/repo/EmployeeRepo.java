package com.example.learningJava.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learningJava.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository< EmployeeEntity, Long>{

}
