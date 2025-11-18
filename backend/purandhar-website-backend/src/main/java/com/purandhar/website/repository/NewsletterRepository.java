package com.purandhar.website.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purandhar.website.model.NewsletterSubscriber;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterSubscriber, Long> {

	boolean existsByEmail(String email);

//	boolean existsByEmail(NewsletterSubscriber email);

}