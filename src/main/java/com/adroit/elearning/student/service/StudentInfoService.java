package com.adroit.elearning.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adroit.elearning.exception.LoginAuthenticationException;
import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.student.model.StudentInfo;
import com.adroit.elearning.student.repository.StudentInfoRepository;

@Service
public class StudentInfoService {

	@Autowired
	private StudentInfoRepository studentInfoRepository;

	public List<StudentInfo> getAllStudents() {
		List<StudentInfo> employeeList = studentInfoRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<StudentInfo>();
		}
	}

	public StudentInfo getStudentInfoById(Integer id) throws RecordNotFoundException {
		Optional<StudentInfo> studentInfo = studentInfoRepository.findById(id);
		if (studentInfo.isPresent()) {
			return studentInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

	public StudentInfo getStudentInfoByEmailidId(String emailid) throws RecordNotFoundException {
		Optional<StudentInfo> studentInfo = studentInfoRepository.findByEmailid(emailid);
		if (studentInfo.isPresent()) {
			return studentInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given emailid");
		}
	}
	
	public StudentInfo getLoginByEmailId(String emailid, String password) throws LoginAuthenticationException {
		Optional<StudentInfo> studentInfo = studentInfoRepository.findByEmailid(emailid);
		if (studentInfo.isPresent() && (new BCryptPasswordEncoder(12).matches(password, studentInfo.get().getPassword()))) {
			return studentInfo.get();
		} else {
			throw new LoginAuthenticationException("No student record exist for given emailid password combination");
		}
	}

	public StudentInfo createOrUpdateStudentInfo(StudentInfo entity) throws RecordNotFoundException {
		Optional<StudentInfo> studentInfo = studentInfoRepository.findById(entity.getId());
		if (studentInfo.isPresent()) {
			StudentInfo newEntity = studentInfo.get();
			newEntity.setId(entity.getId());
			newEntity.setPassword(new BCryptPasswordEncoder(12).encode(entity.getPassword()));
			newEntity.setFirstname(entity.getFirstname());
			newEntity.setMiddlename(entity.getMiddlename());
			newEntity.setLastname(entity.getLastname());
			newEntity.setDob(entity.getDob());
			newEntity.setEmailid(entity.getEmailid());
			newEntity.setInstname(entity.getInstname());
			newEntity.setContactnumber(entity.getContactnumber());
			newEntity.setAddressline1(entity.getAddressline1());
			newEntity.setAddressline2(entity.getAddressline2());
			newEntity.setCity(entity.getCity());
			newEntity.setState(entity.getState());
			newEntity.setCountry(entity.getCountry());
			newEntity.setZipcode(entity.getZipcode());
			newEntity.setStatus("ED");
			newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			newEntity = studentInfoRepository.save(newEntity);
			return newEntity;
		} else {
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			entity.setPassword(new BCryptPasswordEncoder(12).encode(entity.getPassword()));
			entity.setStatus("PL");
			entity.setCreateddate(sqlDate);
			entity.setUpdateddate(sqlDate);
			entity = studentInfoRepository.save(entity);
			return entity;
		}
	}

	public void deleteStudentInfoById(Integer id) throws RecordNotFoundException {
		Optional<StudentInfo> studentInfo = studentInfoRepository.findById(id);
		if (studentInfo.isPresent()) {
			/*
			 * StudentInfo newEntity = studentInfo.get(); newEntity.setStatus("VO");
			 * newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			 * newEntity = studentInfoRepository.save(newEntity);
			 */
			studentInfoRepository.delete(studentInfo.get());
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

}
