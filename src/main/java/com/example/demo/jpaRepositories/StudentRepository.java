package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.StudentModel;

import jakarta.transaction.Transactional;
@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long>{

	@Transactional
    @Modifying
	@Query("delete FROM StudentModel s WHERE s.studentPrn = :studentPrn")
    void deleteByStudentPrn(@Param("studentPrn") String studentPrn);
	
	  @Transactional
      @Modifying
	  @Query("UPDATE StudentModel s SET s.studentName = :name, s.studentPrn = :prn WHERE s.studentPrn = :studentPrn")
	  void updateStudent(@Param("prn") String prn, @Param("name") String name);
	  
	  @Query("SELECT s.id FROM StudentModel s WHERE s.studentPrn = :studentPrn")
	    long getStudentByPrn(@Param("studentPrn") String studentPrn);  
	  StudentModel findByStudentPrn(String prn);
	  
	  //void deleteByStudentPrn(String prn);
	
}
	