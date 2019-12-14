package com.ustglobal.lms.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString.Exclude;

@Entity
@Table(name="book")
public class BookBean {
	
	@Id
	@GeneratedValue
	@Column
	private int bid;
	
	@Column
	private String bname;
	
	@Column
	private String bauthor;
	
	@Column
	private String publication;
	
//	@Exclude
//	@OneToMany(mappedBy="book")
//	private List<BookIssue> bb;
//	public List<BookIssue> getBb() {
//		return bb;
//	}
//
//	public void setBb(List<BookIssue> bb) {
//		this.bb = bb;
//	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	

}
