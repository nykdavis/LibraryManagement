package com.davis.piersqure.liberary.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davis.piersqure.liberary.management.entity.StudentDetails;
import com.davis.piersqure.liberary.management.repository.StudentDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentDetailsController {

	@Autowired
	private StudentDetailsRepository studentRepository;

	@GetMapping("/allStudent")
	public List<StudentDetails> getAllStudent() {
		return studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDetails> getStudentById(@PathVariable Long id) {
		Optional<StudentDetails> student = Optional.ofNullable(studentRepository.getStudentBystudentId(id));
		return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<StudentDetails> createStudent(@RequestBody StudentDetails student){
		StudentDetails saveStudent = studentRepository.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDetails> updateStudent(@PathVariable Long id,@RequestBody StudentDetails student){
		Optional<StudentDetails> getStudent = Optional.ofNullable(studentRepository.getStudentBystudentId(id));
		if(getStudent.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		StudentDetails updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){	
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();		
	}

}
