package com.adroit.elearning.teacher.controller;

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
import com.adroit.elearning.teacher.model.TeacherInfo;
import com.adroit.elearning.teacher.service.TeacherInfoService;

@CrossOrigin()
@RestController
@RequestMapping("/teacher")
public class TeacherInfoController {

	@Autowired
	private TeacherInfoService teacherInfoService;

	@GetMapping("/getallteachers")
	public ResponseEntity<List<TeacherInfo>> getAllTeachers() {
		List<TeacherInfo> list = teacherInfoService.getAllTeachers();
		return new ResponseEntity<List<TeacherInfo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<TeacherInfo> getTeacherById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		TeacherInfo TeacherInfo = teacherInfoService.getTeacherInfoById(id);
		return new ResponseEntity<TeacherInfo>(TeacherInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/get/emailid/{emailid}")
	public ResponseEntity<TeacherInfo> getTeacherByEmailId(@PathVariable("emailid") String emailid) throws RecordNotFoundException {
		TeacherInfo TeacherInfo = teacherInfoService.getTeacherInfoByEmailidId(emailid);
		return new ResponseEntity<TeacherInfo>(TeacherInfo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TeacherInfo> getLoginByEmailId(@RequestBody User user) throws LoginAuthenticationException {
		TeacherInfo TeacherInfo = teacherInfoService.getLoginByEmailId(user.getUsername(), user.getPassword());
		return new ResponseEntity<TeacherInfo>(TeacherInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createorupdate")
	public ResponseEntity<TeacherInfo> createOrUpdateTeacherInfo(@RequestBody TeacherInfo TeacherInfo) throws RecordNotFoundException {
		TeacherInfo updatedTeacherInfo = teacherInfoService.createOrUpdateTeacherInfo(TeacherInfo);
		return new ResponseEntity<TeacherInfo>(updatedTeacherInfo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteTeacherById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		teacherInfoService.deleteTeacherInfoById(id);
		return HttpStatus.FORBIDDEN;
	}

}
