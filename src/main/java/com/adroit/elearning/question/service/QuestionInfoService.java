package com.adroit.elearning.question.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adroit.elearning.exception.RecordNotFoundException;
import com.adroit.elearning.question.repository.QuestionInfoRepository;
import com.adroit.elearning.question.model.QuestionInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class QuestionInfoService {

	@Autowired
	private QuestionInfoRepository questionInfoRepository;

	public List<QuestionInfo> getAllQuestions() {
		List<QuestionInfo> questionList = questionInfoRepository.findAll();
		if (questionList.size() > 0) {
			return questionList;
		} else {
			return new ArrayList<QuestionInfo>();
		}
	}

	public QuestionInfo getQuestionInfoById(Integer id) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findById(id);
		if (QuestionInfo.isPresent()) {
			return QuestionInfo.get();
		} else {
			throw new RecordNotFoundException("No question record exist for given id");
		}
	}
	/**
	public QuestionInfo getQuestionInfoByEmailidId(String emailid) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findByEmailid(emailid);
		if (QuestionInfo.isPresent()) {
			return QuestionInfo.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given emailid");
		}
	}
	
	public QuestionInfo getLoginByEmailId(String emailid, String password) throws LoginAuthenticationException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findByEmailid(emailid);
		if (QuestionInfo.isPresent() && (new BCryptPasswordEncoder(12).matches(password, QuestionInfo.get().getPassword()))) {
			return QuestionInfo.get();
		} else {
			throw new LoginAuthenticationException("No student record exist for given emailid password combination");
		}
	}
	 * @throws IOException **/
	public QuestionInfo createOrUpdateQuestionInfo(QuestionInfo entity,MultipartFile file) throws RecordNotFoundException, IOException{
	//public QuestionInfo createOrUpdateQuestionInfo(QuestionInfo entity) throws RecordNotFoundException{
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findById(entity.getId());
		if (QuestionInfo.isPresent()) {
			QuestionInfo newEntity = QuestionInfo.get();
			newEntity.setId(entity.getId());			
			newEntity.setQuestiontext(entity.getQuestiontext());
			
			//store image
			newEntity.setQuestionimage(file.getBytes());
			
			newEntity.setOpt1(entity.getOpt1());
			newEntity.setOpt2(entity.getOpt2());
			newEntity.setOpt3(entity.getOpt3());
			newEntity.setOpt4(entity.getOpt4());	
			newEntity.setAnswer(entity.getAnswer());
			newEntity.setTeacherid(entity.getTeacherid());
			newEntity.setCourseid(entity.getCourseid());
			newEntity.setStatus("ED");
			newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			newEntity = questionInfoRepository.save(newEntity);
			return newEntity;
		} else {			
			entity.setId(entity.getId());
			entity.setQuestiontext(entity.getQuestiontext());
			entity.setQuestionimage(file.getBytes());			
			entity.setOpt1(entity.getOpt1());
			entity.setOpt2(entity.getOpt2());
			entity.setOpt3(entity.getOpt3());
			entity.setOpt4(entity.getOpt4());	
			entity.setAnswer(entity.getAnswer());
			entity.setTeacherid(entity.getTeacherid());
			entity.setCourseid(entity.getCourseid());
			entity.setStatus("PL");
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
			entity.setCreateddate(sqlDate);
			entity.setUpdateddate(sqlDate);
			entity = questionInfoRepository.save(entity);
			return entity;
		}
	}

	public void deleteQuestionInfoById(Integer id) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findById(id);
		if (QuestionInfo.isPresent()) {
			/*
			 * QuestionInfo newEntity = QuestionInfo.get(); newEntity.setStatus("VO");
			 * newEntity.setUpdateddate(new java.sql.Date(new java.util.Date().getTime()));
			 * newEntity = questionInfoRepository.save(newEntity);
			 */
			questionInfoRepository.delete(QuestionInfo.get());
		} else {
			throw new RecordNotFoundException("No question record exist for given id");
		}
	}
	
	public QuestionInfo getQuestionInfoByTeacherid(Integer teacherid) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findByTeacherid(teacherid);
		if (QuestionInfo.isPresent()) {
			return QuestionInfo.get();
		} else {
			throw new RecordNotFoundException("No question record exist for given emailid");
		}
	}
	
	public List<QuestionInfo> getQuestionInfoByCourseid(Integer courseid) throws RecordNotFoundException {
		List<QuestionInfo> questionList = questionInfoRepository.findByCourseid(courseid);
		if (questionList.size() > 0) {
			return questionList;
		} else {
			return new ArrayList<QuestionInfo>();
		}
	}

	
	public QuestionInfo getQuestionInfoByAnswer(String answer) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findByAnswer(answer);
		if (QuestionInfo.isPresent()) {
			return QuestionInfo.get();
		} else {
			throw new RecordNotFoundException("No question record exist for given emailid");
		}
	}
	
	public QuestionInfo getQuestionInfoByStatus(String status) throws RecordNotFoundException {
		Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findByStatus(status);
		if (QuestionInfo.isPresent()) {
			return QuestionInfo.get();
		} else {
			throw new RecordNotFoundException("No question record exist for given emailid");
		}
	}
	
	/**
	//Store image in folder ProfilePictureStore
	private final Path rootLocation = Paths.get("ProfilePictureStore");

	public void store(MultipartFile file) {
		try {
			System.out.println(file.getOriginalFilename());
			System.out.println(rootLocation.toUri());
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	//Store image path to MySQL
	//public QuestionInfo saveFile(MultipartFile file) throws IOException {
	public byte[] saveFile(MultipartFile file) throws IOException {
	    	QuestionInfo doc = new QuestionInfo();
	        //QuestionInfoService.doc.setDocName(file.getOriginalFilename());
	        
	    	doc.setQuestionimage(file.getBytes());
	        questionInfoRepository.save(doc);
	        return file.getBytes();
	        //return doc.toString();
	    }	
	**/
	    
//	    public byte[] getDocumentFile(Integer id) {
//	      return questionInfoRepository.findImageByQuestionid(id).getFile();
//	    }
	    /**
	    public List findAll() {
	        return (List) documentDao.findAll();
	    }
	    
	    public QuestionInfo findImageByQuestionid(Integer questionid) throws RecordNotFoundException {
			Optional<QuestionInfo> QuestionInfo = questionInfoRepository.findImageByQuestionid(questionid);
			if (QuestionInfo.isPresent()) {
				return QuestionInfo.get();
			} else {
				throw new RecordNotFoundException("No question record exist for given emailid");
			}
		}**/
}
