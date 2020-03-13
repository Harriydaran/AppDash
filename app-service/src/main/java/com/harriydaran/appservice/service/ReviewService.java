package com.harriydaran.appservice.service;

import com.harriydaran.appservice.dao.ReviewRepository;
import com.harriydaran.appservice.model.Review;
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

  public List<Review> getAppReviews(final String app){
    return reviewRepository.findByApp_Name(app);
  }
}
