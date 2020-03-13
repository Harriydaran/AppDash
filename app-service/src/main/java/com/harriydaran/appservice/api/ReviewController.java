package com.harriydaran.appservice.api;

import com.harriydaran.appservice.dao.ReviewRepository;
import com.harriydaran.appservice.model.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewController(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @GetMapping("/{app}")
  public List<Review> getAppReviews(@PathVariable("app") final String app){
    return reviewRepository.findByApp_Name(app);
  }
}
