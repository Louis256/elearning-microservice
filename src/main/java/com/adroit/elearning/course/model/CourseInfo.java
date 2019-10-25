package com.adroit.elearning.course.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSEINFO")
public class CourseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "teacherid")
	private String teacherid;

	@Column(name = "subscriptionfee")
	private String subscriptionfee;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "updateddate")
	private Date updateddate;

	@Column(name = "coursename")
	private String coursename;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "difficultylevel")
	private String difficultylevel;
	
	@Column(name = "active")
	private String active;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getSubscriptionfee() {
		return subscriptionfee;
	}

	public void setSubscriptionfee(String subscriptionfee) {
		this.subscriptionfee = subscriptionfee;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficultylevel() {
		return difficultylevel;
	}

	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
