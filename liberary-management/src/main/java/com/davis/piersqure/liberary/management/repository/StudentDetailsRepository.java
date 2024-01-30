package com.davis.piersqure.liberary.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.piersqure.liberary.management.entity.StudentDetails;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {

	StudentDetails getStudentBystudentId(Long id);

}
