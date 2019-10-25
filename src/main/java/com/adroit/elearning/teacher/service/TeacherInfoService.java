package com.adroit.elearning.teacher.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adroit.elearning.exception.LoginAuthenticationException;
import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.teacher.model.TeacherInfo;
import com.adroit.elearning.teacher.repository.TeacherInfoRepository;

@Service
public class TeacherInfoService {

	@Autowired
	private TeacherInfoRepository teacherInfoRepository;

	public List<TeacherInfo> getAllTeachers() {
		List<TeacherInfo> employeeList = teacherInfoRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<TeacherInfo>();
		}
	}

	public TeacherInfo getTeacherInfoById(Integer id) throws RecordNotFoundException {
		Optional<TeacherInfo> TeacherInfo = teacherInfoRepository.findById(id);
		if (TeacherInfo.isPresent()) {
			return TeacherInfo.get();
		} else {
			throw new RecordNotFoundException("No teacher record exist for given id");
		}
	}

	public TeacherInfo getTeacherInfoByEmailidId(String emailid) throws RecordNotFoundException {
		Optional<TeacherInfo> TeacherInfo = teacherInfoRepository.findByEmailid(emailid);
		if (TeacherInfo.isPresent()) {
			return TeacherInfo.get();
		} else {
			throw new RecordNotFoundException("No teacher record exist for given emailid");
		}
	}
	
	public TeacherInfo getLoginByEmailId(String emailid, String password) throws LoginAuthenticationException {
		Optional<TeacherInfo> TeacherInfo = teacherInfoRepository.findByEmailid(emailid);
		if (TeacherInfo.isPresent() && (new BCryptPasswordEncoder(12).matches(password, TeacherInfo.get().getPassword()))) {
			return TeacherInfo.get();
		} else {
			throw new LoginAuthenticationException("No teacher record exist for given emailid password combination");
		}
	}

	public TeacherInfo createOrUpdateTeacherInfo(TeacherInfo entity) throws RecordNotFoundException {
		Optional<TeacherInfo> TeacherInfo = teacherInfoRepository.findById(entity.getId());
		if (TeacherInfo.isPresent()) {
			TeacherInfo newEntity = TeacherInfo.get();
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
			newEntity = teacherInfoRepository.save(newEntity);
			return newEntity;
		} else {
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			entity.setPassword(new BCryptPasswordEncoder(12).encode(entity.getPassword()));
			entity.setStatus("PL");
			entity.setCreateddate(sqlDate);
			entity.setUpdateddate(sqlDate);
			entity = teacherInfoRepository.save(entity);
			return entity;
		}
	}

	public void deleteTeacherInfoById(Integer id) throws RecordNotFoundException {
		Optional<TeacherInfo> TeacherInfo = teacherInfoRepository.findById(id);
		if (TeacherInfo.isPresent()) {
			/*
			 * TeacherInfo newEntity = TeacherInfo.get(); newEntity.setStatus("VO");
			 * newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			 * newEntity = teacherInfoRepository.save(newEntity);
			 */
			teacherInfoRepository.delete(TeacherInfo.get());
		} else {
			throw new RecordNotFoundException("No teacher record exist for given id");
		}
	}

}
