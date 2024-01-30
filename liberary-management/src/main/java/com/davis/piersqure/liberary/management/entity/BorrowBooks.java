package com.davis.piersqure.liberary.management.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBooks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrowId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentDetails student;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private LibraryDetails book;

	private LocalDate borrowDate;
	private LocalDate dueDate;

}
