package com.harriydaran.webscraperservice.service;

import com.harriydaran.webscraperservice.dao.AppRepository;
import com.harriydaran.webscraperservice.dao.ReviewRepository;
import com.harriydaran.webscraperservice.domain.PlayStoreScraper;
import com.harriydaran.webscraperservice.model.AppReviewSet;
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
