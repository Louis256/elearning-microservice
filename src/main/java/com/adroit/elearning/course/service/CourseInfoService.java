package com.adroit.elearning.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adroit.elearning.course.repository.CourseInfoRepository;
import com.adroit.elearning.exception.LoginAuthenticationException;
import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.course.model.CourseInfo;


@Service
public class CourseInfoService {

	@Autowired
	private CourseInfoRepository courseInfoRepository;

	public List<CourseInfo> getAllCourses() {
		List<CourseInfo> courseList = courseInfoRepository.findAll();
		if (courseList.size() > 0) {
			return courseList;
		} else {
			return new ArrayList<CourseInfo>();
		}
	}

	public CourseInfo getCourseInfoById(Integer id) throws RecordNotFoundException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findById(id);
		if (CourseInfo.isPresent()) {
			return CourseInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}
	/**
	public CourseInfo getCourseInfoByEmailidId(String emailid) throws RecordNotFoundException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findByEmailid(emailid);
		if (CourseInfo.isPresent()) {
			return CourseInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given emailid");
		}
	}
	
	public CourseInfo getLoginByEmailId(String emailid, String password) throws LoginAuthenticationException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findByEmailid(emailid);
		if (CourseInfo.isPresent() && (new BCryptPasswordEncoder(12).matches(password, CourseInfo.get().getPassword()))) {
			return CourseInfo.get();
		} else {
			throw new LoginAuthenticationException("No student record exist for given emailid password combination");
		}
	}**/

	public CourseInfo createOrUpdateCourseInfo(CourseInfo entity) throws RecordNotFoundException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findById(entity.getId());
		if (CourseInfo.isPresent()) {
			CourseInfo newEntity = CourseInfo.get();
			newEntity.setId(entity.getId());
			newEntity.setDescription(entity.getDescription());
			newEntity.setTeacherid(entity.getTeacherid());
			newEntity.setSubscriptionfee(entity.getSubscriptionfee());
			newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			newEntity.setCoursename(entity.getCoursename());
			newEntity.setCategory(entity.getCategory());
			newEntity.setDifficultylevel(entity.getDifficultylevel());
			newEntity.setActive(entity.getActive());
			newEntity = courseInfoRepository.save(newEntity);
			return newEntity;
		} else {
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			entity.setId(entity.getId());
			entity.setDescription(entity.getDescription());
			entity.setTeacherid(entity.getTeacherid());
			entity.setSubscriptionfee(entity.getSubscriptionfee());
			entity.setCreateddate(sqlDate);
			entity.setUpdateddate(sqlDate);
			entity.setCoursename(entity.getCoursename());
			entity.setCategory(entity.getCategory());
			entity.setDifficultylevel(entity.getDifficultylevel());
			entity.setActive(entity.getActive());
			entity = courseInfoRepository.save(entity);
			return entity;
		}
	}

	public void deleteCourseInfoById(Integer id) throws RecordNotFoundException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findById(id);
		if (CourseInfo.isPresent()) {
			/*
			 * CourseInfo newEntity = CourseInfo.get(); newEntity.setStatus("VO");
			 * newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			 * newEntity = courseInfoRepository.save(newEntity);
			 */
			courseInfoRepository.delete(CourseInfo.get());
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}
	
	public CourseInfo getCourseInfoByTeacherid(String teacherid) throws RecordNotFoundException {
		Optional<CourseInfo> CourseInfo = courseInfoRepository.findByTeacherid(teacherid);
		if (CourseInfo.isPresent()) {
			return CourseInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given emailid");
		}
	}

}
