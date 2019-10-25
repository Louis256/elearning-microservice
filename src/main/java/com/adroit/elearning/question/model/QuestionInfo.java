package com.adroit.elearning.question.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONINFO")
public class QuestionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "questiontext")
	private String questiontext;

	@Column(name = "questionimage")
	@Lob
	private byte[] questionimage;

	@Column(name = "opt1")
	private String opt1;

	@Column(name = "opt2")
	private String opt2;

	@Column(name = "opt3")
	private String opt3;

	@Column(name = "opt4")
	private String opt4;

	@Column(name = "answer")
	private String answer;

	@Column(name = "teacherid")
	private int teacherid;

	@Column(name = "courseid")
	private int courseid;

	@Column(name = "status")
	private String status;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "updateddate")
	private Date updateddate;
	
	public QuestionInfo() {
		
	}
	
	
	public QuestionInfo(byte[] questionimage) {		
		this.questionimage = questionimage;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestiontext() {
		return questiontext;
	}


	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}


	public byte[] getQuestionimage() {
		return questionimage;
	}


	public void setQuestionimage(byte[] questionimage) {
		this.questionimage = questionimage;
	}


	public String getOpt1() {
		return opt1;
	}


	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}


	public String getOpt2() {
		return opt2;
	}


	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}


	public String getOpt3() {
		return opt3;
	}


	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}


	public String getOpt4() {
		return opt4;
	}


	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getTeacherid() {
		return teacherid;
	}


	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}


	public int getCourseid() {
		return courseid;
	}


	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
