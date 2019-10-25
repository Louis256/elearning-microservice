package com.adroit.elearning.student.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.adroit.elearning.exception.LoginAuthenticationException;
import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.login.model.User;
import com.adroit.elearning.student.model.StudentInfo;
import com.adroit.elearning.student.service.StudentInfoService;

@CrossOrigin()
@RestController
@RequestMapping("/student")
public class StudentInfoController {

	@Autowired
	private StudentInfoService studentInfoService;

	@GetMapping("/getallstudents")
	public ResponseEntity<List<StudentInfo>> getAllStudents() {
		List<StudentInfo> list = studentInfoService.getAllStudents();
		return new ResponseEntity<List<StudentInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<StudentInfo> getStudentById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		StudentInfo studentInfo = studentInfoService.getStudentInfoById(id);
		return new ResponseEntity<StudentInfo>(studentInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/emailid/{emailid}")
	public ResponseEntity<StudentInfo> getStudentByEmailId(@PathVariable("emailid") String emailid) throws RecordNotFoundException {
		StudentInfo studentInfo = studentInfoService.getStudentInfoByEmailidId(emailid);
		return new ResponseEntity<StudentInfo>(studentInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<StudentInfo> getLoginByEmailId(@RequestBody User user) throws LoginAuthenticationException {
		StudentInfo studentInfo = studentInfoService.getLoginByEmailId(user.getUsername(), user.getPassword());
		return new ResponseEntity<StudentInfo>(studentInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createorupdate")
	public ResponseEntity<StudentInfo> createOrUpdateStudentInfo(@RequestBody StudentInfo studentInfo) throws RecordNotFoundException {
		StudentInfo updatedStudentInfo = studentInfoService.createOrUpdateStudentInfo(studentInfo);
		return new ResponseEntity<StudentInfo>(updatedStudentInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		studentInfoService.deleteStudentInfoById(id);
		return HttpStatus.FORBIDDEN;
	}

}
