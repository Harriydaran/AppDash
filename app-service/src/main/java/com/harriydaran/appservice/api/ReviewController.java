package com.harriydaran.appservice.api;

import com.harriydaran.appservice.model.Review;
import com.harriydaran.appservice.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  private ReviewService reviewService;

  @Autowired
  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/{app}")
  public List<Review> getAppReviews(@PathVariable("app") final String app){
    return reviewService.getAppReviews(app);
  }
}
