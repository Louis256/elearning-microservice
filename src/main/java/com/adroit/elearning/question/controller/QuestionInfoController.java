package com.adroit.elearning.question.controller;

import java.io.IOException;
import java.util.ArrayList;
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


import com.adroit.elearning.exception.RecordNotFoundException;

import com.adroit.elearning.question.service.QuestionInfoService;
import com.adroit.elearning.question.model.QuestionInfo;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 

@CrossOrigin()
@RestController
@RequestMapping("/question")
public class QuestionInfoController {

	@Autowired
	private QuestionInfoService questionInfoService;
	
	List<String> files = new ArrayList<String>();

	@GetMapping("/getallquestions")
	public ResponseEntity<List<QuestionInfo>> getAllQuestions() {
		List<QuestionInfo> list = questionInfoService.getAllQuestions();
		return new ResponseEntity<List<QuestionInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<QuestionInfo> getQuestionById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		QuestionInfo QuestionInfo = questionInfoService.getQuestionInfoById(id);
		return new ResponseEntity<QuestionInfo>(QuestionInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createorupdate")
	public ResponseEntity<QuestionInfo> createOrUpdateQuestionInfo(@ModelAttribute QuestionInfo QuestionInfo,@RequestParam(value="file") MultipartFile file) throws RecordNotFoundException, IOException {
	//public ResponseEntity<QuestionInfo> createOrUpdateQuestionInfo(@ModelAttribute QuestionInfo QuestionInfo) throws RecordNotFoundException {
	//public ResponseEntity<QuestionInfo> createOrUpdateQuestionInfo(@RequestBody QuestionInfo QuestionInfo) throws RecordNotFoundException {
		QuestionInfo updatedQuestionInfo = questionInfoService.createOrUpdateQuestionInfo(QuestionInfo,file);
		return new ResponseEntity<QuestionInfo>(updatedQuestionInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteQuestionById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		questionInfoService.deleteQuestionInfoById(id);
		return HttpStatus.FORBIDDEN;
	}
	
	@GetMapping("/get/teacherid/{teacherid}")
	public ResponseEntity<QuestionInfo> getQuestionByTeacherid(@PathVariable("teacherid") Integer teacherid) throws RecordNotFoundException {
		QuestionInfo QuestionInfo = questionInfoService.getQuestionInfoByTeacherid(teacherid);
		return new ResponseEntity<QuestionInfo>(QuestionInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/courseid/{courseid}")
	public ResponseEntity<List<QuestionInfo>> getQuestionByCourseid(@PathVariable("courseid") Integer courseid) throws RecordNotFoundException {	
		List<QuestionInfo> list = questionInfoService.getQuestionInfoByCourseid(courseid);
		return new ResponseEntity<List<QuestionInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/answer/{answer}")
	public ResponseEntity<QuestionInfo> getQuestionByAnswer(@PathVariable("answer") String answer) throws RecordNotFoundException {
		QuestionInfo QuestionInfo = questionInfoService.getQuestionInfoByAnswer(answer);
		return new ResponseEntity<QuestionInfo>(QuestionInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	/**
	//Store image in ProfilePictureStore folder
	@PostMapping("/upload")
	public ResponseEntity < String > handleFileUpload(@RequestParam("file") MultipartFile file) {
	 String message = "";
	 try {
	  questionInfoService.store(file);
	  message = "You successfully uploaded " + file.getOriginalFilename() + "!";
	  return ResponseEntity.status(HttpStatus.OK).body(message);
	 } catch (Exception e) {
	  message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
	  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	 }
 }
	//store image in MySQL
	private static final Logger logger = LoggerFactory.getLogger(QuestionInfoController.class);

    @PostMapping("/uploadFile")
    public @ResponseBody byte[] handleFileUpload(@RequestParam(value="file") MultipartFile file) throws IOException {
        return questionInfoService.saveFile(file);
    }
	 **/
    /**
    @GetMapping("/{id}")
    public HttpEntity getDocument(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity(documentService.getDocumentFile(id), httpHeaders, HttpStatus.OK);
    }

   **/


}
