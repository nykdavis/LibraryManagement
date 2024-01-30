package com.davis.piersqure.liberary.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.piersqure.liberary.management.entity.LibraryDetails;

@Repository
public interface LibraryDetailsRepository extends JpaRepository<LibraryDetails, Long> {
}