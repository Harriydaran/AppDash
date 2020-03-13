package com.harriydaran.webscraperservice.model;

import java.util.List;

public class AppReviewSet {

  private App app;
  private List<Review> reviews;

  public AppReviewSet() {
  }

  public AppReviewSet(App app, List<Review> reviews) {
    this.app = app;
    this.reviews = reviews;
  }

  public App getApp() {
    return app;
  }

  public void setApp(App app) {
    this.app = app;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
