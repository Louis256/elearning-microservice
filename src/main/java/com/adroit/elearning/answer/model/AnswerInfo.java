package com.adroit.elearning.answer.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWERINFO")
public class AnswerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "studentid")
	private Integer studentid;

	@Column(name = "courseid")
	private Integer courseid;

	@Column(name = "answerdata")
	private Blob answerdata;
	
	@Column(name = "totquestions")
	private Integer totquestions;
	
	@Column(name = "totrightanswers")
	private Integer totrightanswers;
	
	@Column(name = "totwronganswers")
	private Integer totwronganswers;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "createddate")
	private Date createddate;
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	
	
	public Integer getStudentid() {
		return studentid;
	}

	
	
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}



	public Integer getCourseid() {
		return courseid;
	}



	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}



	public Blob getAnswerdata() {
		return answerdata;
	}



	public void setAnswerdata(Blob answerdata) {
		this.answerdata = answerdata;
	}



	public Integer getTotquestions() {
		return totquestions;
	}



	public void setTotquestions(Integer totquestions) {
		this.totquestions = totquestions;
	}



	public Integer getTotrightanswers() {
		return totrightanswers;
	}



	public void setTotrightanswers(Integer totrightanswers) {
		this.totrightanswers = totrightanswers;
	}



	public Integer getTotwronganswers() {
		return totwronganswers;
	}



	public void setTotwronganswers(Integer totwronganswers) {
		this.totwronganswers = totwronganswers;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public Date getCreateddate() {
		return createddate;
	}



	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}



	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
