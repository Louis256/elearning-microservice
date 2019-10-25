package com.adroit.elearning.answer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adroit.elearning.answer.model.AnswerInfo;
import com.adroit.elearning.answer.service.AnswerInfoService;
import com.adroit.elearning.exception.RecordNotFoundException;



@CrossOrigin()
@RestController
@RequestMapping("/answer")
public class AnswerInfoController {

	@Autowired
	private AnswerInfoService answerInfoService;

	@GetMapping("/getallanswers")
	public ResponseEntity<List<AnswerInfo>> getAllQuestions() {
		List<AnswerInfo> list = answerInfoService.getAllAnswers();
		return new ResponseEntity<List<AnswerInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<AnswerInfo> getAnswerById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		AnswerInfo AnswerInfo = answerInfoService.getAnswerInfoById(id);
		return new ResponseEntity<AnswerInfo>(AnswerInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createorupdate")
	public ResponseEntity<AnswerInfo> createOrUpdateAnswerInfo(@RequestBody AnswerInfo answerInfo) throws RecordNotFoundException {
		AnswerInfo updatedAnswerInfo = answerInfoService.createOrUpdateAnswerInfo(answerInfo);
		return new ResponseEntity<AnswerInfo>(updatedAnswerInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteAnswerById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		answerInfoService.deleteAnswerInfoById(id);
		return HttpStatus.FORBIDDEN;
	}
	
	@GetMapping("/get/studentid/{studentid}")
	public ResponseEntity<AnswerInfo> getQuestionByTeacherid(@PathVariable("studentid") Integer studentid) throws RecordNotFoundException {
		AnswerInfo AnswerInfo = answerInfoService.getAnswerInfoByStudentid(studentid);
		return new ResponseEntity<AnswerInfo>(AnswerInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/courseid/{courseid}")
	public ResponseEntity<AnswerInfo> getAnswerByCourseid(@PathVariable("courseid") Integer courseid) throws RecordNotFoundException {
		AnswerInfo AnswerInfo = answerInfoService.getAnswerInfoByCourseid(courseid);
		return new ResponseEntity<AnswerInfo>(AnswerInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/result/{result}")
	public ResponseEntity<AnswerInfo> getAnswerByResult(@PathVariable("result") String result) throws RecordNotFoundException {
		AnswerInfo AnswerInfo = answerInfoService.getAnswerInfoByResult(result);
		return new ResponseEntity<AnswerInfo>(AnswerInfo, new HttpHeaders(), HttpStatus.OK);
	}

}
