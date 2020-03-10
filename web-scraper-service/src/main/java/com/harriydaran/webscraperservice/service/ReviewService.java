package com.harriydaran.webscraperservice.service;

import com.harriydaran.webscraperservice.dao.ReviewRepository;
import com.harriydaran.webscraperservice.domain.PlayStoreScraper;
import com.harriydaran.webscraperservice.model.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public List<Review> getReviews(final String app){
    List<Review> reviews = PlayStoreScraper.scrape(app);
    reviewRepository.saveAll(reviews);
    return reviews;
  }
}
