package com.adroit.elearning.answer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adroit.elearning.answer.model.AnswerInfo;
import com.adroit.elearning.answer.repository.AnswerInfoRepository;
import com.adroit.elearning.exception.RecordNotFoundException;



@Service
public class AnswerInfoService {

	@Autowired
	private AnswerInfoRepository answerInfoRepository;

	public List<AnswerInfo> getAllAnswers() {
		List<AnswerInfo> answerList = answerInfoRepository.findAll();
		if (answerList.size() > 0) {
			return answerList;
		} else {
			return new ArrayList<AnswerInfo>();
		}
	}

	public AnswerInfo getAnswerInfoById(Integer id) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findById(id);
		if (AnswerInfo.isPresent()) {
			return AnswerInfo.get();
		} else {
			throw new RecordNotFoundException("No answer record exist for given id");
		}
	}
	
	public AnswerInfo createOrUpdateAnswerInfo(AnswerInfo entity) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findById(entity.getId());
		if (AnswerInfo.isPresent()) {
			AnswerInfo newEntity = AnswerInfo.get();
			newEntity.setId(entity.getId());
			newEntity.setStudentid(entity.getStudentid());
			newEntity.setCourseid(entity.getCourseid());
			newEntity.setAnswerdata(entity.getAnswerdata());
			newEntity.setTotquestions(entity.getTotquestions());
			newEntity.setTotrightanswers(entity.getTotrightanswers());
			newEntity.setTotwronganswers(entity.getTotwronganswers());
			newEntity.setResult(entity.getResult());			
			newEntity = answerInfoRepository.save(newEntity);
			return newEntity;
		} else {
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());			
			entity.setCreateddate(sqlDate);
			entity = answerInfoRepository.save(entity);
			return entity;
		}
	}

	public void deleteAnswerInfoById(Integer id) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findById(id);
		if (AnswerInfo.isPresent()) {
			/*
			 * AnswerInfo newEntity = AnswerInfo.get(); newEntity.setStatus("VO");
			 * newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			 * newEntity = answerInfoRepository.save(newEntity);
			 */
			answerInfoRepository.delete(AnswerInfo.get());
		} else {
			throw new RecordNotFoundException("No answer record exist for given id");
		}
	}
	
	public AnswerInfo getAnswerInfoByStudentid(Integer studentid) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findAnswerByStudentid(studentid);
		if (AnswerInfo.isPresent()) {
			return AnswerInfo.get();
		} else {
			throw new RecordNotFoundException("No answer record exist for given teacherid");
		}
	}
	
	public AnswerInfo getAnswerInfoByCourseid(Integer courseid) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findAnswerByCourseid(courseid);
		if (AnswerInfo.isPresent()) {
			return AnswerInfo.get();
		} else {
			throw new RecordNotFoundException("No answer record exist for given courseid");
		}
	}
	
	public AnswerInfo getAnswerInfoByResult(String result) throws RecordNotFoundException {
		Optional<AnswerInfo> AnswerInfo = answerInfoRepository.findAnswerByResult(result);
		if (AnswerInfo.isPresent()) {
			return AnswerInfo.get();
		} else {
			throw new RecordNotFoundException("No answer record exist for given result");
		}
	}
		

}
