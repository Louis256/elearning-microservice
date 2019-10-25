package com.adroit.elearning.course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adroit.elearning.course.model.CourseInfo;


@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo, Integer> {

	//Optional<CourseInfo> findByEmailid(String emailid);
	Optional<CourseInfo> findByTeacherid(String teacherid);

}
