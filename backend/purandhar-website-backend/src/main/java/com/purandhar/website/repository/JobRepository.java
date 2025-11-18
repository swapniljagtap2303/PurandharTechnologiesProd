package com.purandhar.website.repository;

import com.purandhar.website.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobApplication, Long> {
	
	 boolean existsByAEmailAndAPosition(String aEmail, String aPosition);

	
}
