package com.adroit.elearning.question.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adroit.elearning.question.model.QuestionInfo;


@Repository
public interface QuestionInfoRepository extends JpaRepository<QuestionInfo, Integer> {
	
	Optional<QuestionInfo> findByTeacherid(Integer teacherid);
	List<QuestionInfo> findByCourseid(Integer courseid);
	Optional<QuestionInfo> findByAnswer(String answer);
	Optional<QuestionInfo> findByStatus(String status);
	//byte[] findImageByQuestionid(Integer id);
	//List<QuestionInfo> findAll();
	
}
