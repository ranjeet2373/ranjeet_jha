package com.ustglobal.lms.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString.Exclude;

@Entity
@Table(name="student")
public class StudentBean {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int rollno;
	
	@Column
	private String name;
	
	@Column
	private String department;
	
	@Column
	private String gender;
	
	@Column
	private String password;
	
//	@Exclude
//	@OneToMany(mappedBy="student")
//	private List<BookIssue> sb;
//
//	public List<BookIssue> getBi() {
//		return sb;
//	}
//
//	public void setBi(List<BookIssue> bi) {
//		this.sb = sb;
//	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
