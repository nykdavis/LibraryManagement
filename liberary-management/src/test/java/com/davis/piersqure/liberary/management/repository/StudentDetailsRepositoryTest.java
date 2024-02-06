package com.davis.piersqure.liberary.management.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.davis.piersqure.liberary.management.entity.StudentDetails;

@DataJpaTest
public class StudentDetailsRepositoryTest {
	
	@Autowired
	public StudentDetailsRepository  studentDetailsRepository;
	
	//BDD naming convention
	//JUnit test for Save StudentDetails
	@Test
	public void givenStudentObject_whenSave_thenReturn() {
		
		//given - precondition or setup.
		StudentDetails student = StudentDetails.builder()
				.studentId((long) 1)
				.firstName("Davis")
				.lastName("Nayak")
				.address("Bangalore")
				.branch("CS")
				.section("A")
				.build();
		
		
		//when - Action or behavior we are going to test.
		StudentDetails saveStudent = studentDetailsRepository.save(student);
		
		//then - verify the output.
		Assertions.assertThat(saveStudent).isNotNull();
		Assertions.assertThat(saveStudent.getStudentId()).isGreaterThan(0);
		
	}

}
