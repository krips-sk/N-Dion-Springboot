package com.example.learningJava.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="s.no")
	private Long id;
	
	@Column(name="emprollno")
	private String emprollno;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="experience")
	private String experience;
	
	@ManyToMany
	private List<UserEntity> userentity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmprollno() {
		return emprollno;
	}

	public void setEmprollno(String emprollno) {
		this.emprollno = emprollno;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public List<UserEntity> getUserentity() {
		return userentity;
	}

	public void setUserentity(List<UserEntity> userentity) {
		this.userentity = userentity;
	}

}
