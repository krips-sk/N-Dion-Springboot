package com.example.learningJava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="user_details")
public class UserEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="empID")
	public String empID;
	
	@Column(name="name")
	public String name;
	
	@Column(name="email")
	public String email;
	
	@Column(name="mobile")
	public String mobile;
	
	@Column(name="company")
	public String company;
	
	@Column(name="password")
	public String password;
	
	@ManyToMany(mappedBy = "userentity")
	private List<EmployeeEntity> employee=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}

	public UserEntity(Long id, String empID, String name, String email, String mobile, String company,
			String password) {
		super();
		this.id = id;
		this.empID = empID;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.company = company;
		this.password = password;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", empID=" + empID + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", company=" + company + " password=" + password + "]";
	}

	

	
	
	
}
