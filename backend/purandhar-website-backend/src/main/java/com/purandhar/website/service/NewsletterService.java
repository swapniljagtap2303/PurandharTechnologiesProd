package com.purandhar.website.service;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.NewsletterSubscriber;

public interface NewsletterService {

	ApiResponse save(NewsletterSubscriber email);

}
