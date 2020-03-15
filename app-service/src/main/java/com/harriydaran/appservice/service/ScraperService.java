package com.harriydaran.appservice.service;

import com.harriydaran.appservice.dao.AppRepository;
import com.harriydaran.appservice.dao.ReviewRepository;
import com.harriydaran.appservice.domain.PlayStoreScraper;
import com.harriydaran.appservice.domain.WebDriverConfig;
import com.harriydaran.appservice.model.AppReviewSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScraperService {

  private ReviewRepository reviewRepository;
  private AppRepository appRepository;

  @Autowired
  public ScraperService(ReviewRepository reviewRepository,
      AppRepository appRepository) {
    this.reviewRepository = reviewRepository;
    this.appRepository = appRepository;
  }

  public AppReviewSet getReviews(final String appPackage){
    if (appExists(appPackage)) return null;
    PlayStoreScraper playStoreScraper = new PlayStoreScraper(new WebDriverConfig().getDriver());
    AppReviewSet appReviewSet = playStoreScraper.scrape(appPackage);
    appRepository.save(appReviewSet.getApp());
    reviewRepository.saveAll(appReviewSet.getReviews());
    return appReviewSet;
  }

  public boolean appExists(final String appPackage){
    return appRepository.findByAppPackage(appPackage) != null;
  }

}
