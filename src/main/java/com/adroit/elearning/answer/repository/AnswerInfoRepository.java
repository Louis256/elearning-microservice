package com.adroit.elearning.answer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adroit.elearning.answer.model.AnswerInfo;



@Repository
public interface AnswerInfoRepository extends JpaRepository<AnswerInfo, Integer> {
	
	
	Optional<AnswerInfo> findAnswerByStudentid(Integer studentid);
	Optional<AnswerInfo> findAnswerByCourseid(Integer courseid);
	Optional<AnswerInfo> findAnswerByResult(String result);
	

}
