package com.harriydaran.webscraperservice.api;

import com.harriydaran.webscraperservice.model.Review;
import com.harriydaran.webscraperservice.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
public class ReviewController {

  private ReviewService reviewService;

  @Autowired
  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/{app}")
  public List<Review> getReviews(@PathVariable("app") String app){
    return reviewService.getReviews(app);
  }

}
