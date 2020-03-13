package com.harriydaran.webscraperservice.api;

import com.harriydaran.webscraperservice.model.AppReviewSet;
import com.harriydaran.webscraperservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reviews")
public class ReviewScraperController {

  private ReviewService reviewService;

  @Autowired
  public ReviewScraperController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/{app}")
  public AppReviewSet getReviews(@PathVariable("app") String app){
    return reviewService.getReviews(app);
  }

}
