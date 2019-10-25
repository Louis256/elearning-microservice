package com.adroit.elearning.course.controller;

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

import com.adroit.elearning.course.service.CourseInfoService;
import com.adroit.elearning.exception.LoginAuthenticationException;
import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.login.model.User;
import com.adroit.elearning.course.model.CourseInfo;


@CrossOrigin()
@RestController
@RequestMapping("/course")
public class CourseInfoController {

	@Autowired
	private CourseInfoService courseInfoService;

	@GetMapping("/getallcourses")
	public ResponseEntity<List<CourseInfo>> getAllStudents() {
		List<CourseInfo> list = courseInfoService.getAllCourses();
		return new ResponseEntity<List<CourseInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<CourseInfo> getStudentById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		CourseInfo CourseInfo = courseInfoService.getCourseInfoById(id);
		return new ResponseEntity<CourseInfo>(CourseInfo, new HttpHeaders(), HttpStatus.OK);
	}
	/**
	@GetMapping("/get/emailid/{emailid}")
	public ResponseEntity<CourseInfo> getStudentByEmailId(@PathVariable("emailid") String emailid) throws RecordNotFoundException {
		CourseInfo CourseInfo = courseInfoService.getCourseInfoByEmailidId(emailid);
		return new ResponseEntity<CourseInfo>(CourseInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<CourseInfo> getLoginByEmailId(@RequestBody User user) throws LoginAuthenticationException {
		CourseInfo CourseInfo = courseInfoService.getLoginByEmailId(user.getUsername(), user.getPassword());
		return new ResponseEntity<CourseInfo>(CourseInfo, new HttpHeaders(), HttpStatus.OK);
	}**/

	@PostMapping("/createorupdate")
	public ResponseEntity<CourseInfo> createOrUpdateCourseInfo(@RequestBody CourseInfo CourseInfo) throws RecordNotFoundException {
		CourseInfo updatedCourseInfo = courseInfoService.createOrUpdateCourseInfo(CourseInfo);
		return new ResponseEntity<CourseInfo>(updatedCourseInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		courseInfoService.deleteCourseInfoById(id);
		return HttpStatus.FORBIDDEN;
	}
	@GetMapping("/get/teacherid/{teacherid}")
	public ResponseEntity<CourseInfo> getCourseByTeacherid(@PathVariable("teacherid") String teacherid) throws RecordNotFoundException {
		CourseInfo CourseInfo = courseInfoService.getCourseInfoByTeacherid(teacherid);
		return new ResponseEntity<CourseInfo>(CourseInfo, new HttpHeaders(), HttpStatus.OK);
	}
	

}
