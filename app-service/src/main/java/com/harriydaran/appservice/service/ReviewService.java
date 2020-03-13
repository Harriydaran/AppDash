package com.harriydaran.appservice.service;

import com.harriydaran.appservice.dao.AppRepository;
import com.harriydaran.appservice.dao.ReviewRepository;
import com.harriydaran.appservice.domain.PlayStoreScraper;
import com.harriydaran.appservice.model.AppReviewSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  private ReviewRepository reviewRepository;
  private AppRepository appRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository,
      AppRepository appRepository) {
    this.reviewRepository = reviewRepository;
    this.appRepository = appRepository;
  }

  public AppReviewSet getReviews(final String app){
    AppReviewSet appReviewSet = PlayStoreScraper.scrape(app);
    appRepository.save(appReviewSet.getApp());
    reviewRepository.saveAll(appReviewSet.getReviews());
    return appReviewSet;
  }
}
