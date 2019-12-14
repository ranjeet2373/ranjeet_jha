package com.ustglobal.lms.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BookIssue {
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollno",nullable=false)
	private StudentBean student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bid",nullable=false)
	private BookBean book;
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private Date issueDate;
	
	@Column
	private Date returnDate;
	

}
