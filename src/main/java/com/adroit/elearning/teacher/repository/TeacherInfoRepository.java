package com.adroit.elearning.teacher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adroit.elearning.teacher.model.TeacherInfo;

@Repository
public interface TeacherInfoRepository extends JpaRepository<TeacherInfo, Integer> {

	Optional<TeacherInfo> findByEmailid(String emailid);

}
