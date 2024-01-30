package com.davis.piersqure.liberary.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.piersqure.liberary.management.entity.BorrowBooks;

@Repository
public interface BorrowBooksRepository extends JpaRepository<BorrowBooks, Long> {

}
