package com.harriydaran.appservice.api;

import com.harriydaran.appservice.model.AppReviewSet;
import com.harriydaran.appservice.service.ReviewService;
import com.harriydaran.appservice.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrape")
public class ScraperController {

  private ScraperService scraperService;

  @Autowired
  public ScraperController(ScraperService scraperService) {
    this.scraperService = scraperService;
  }

  @GetMapping("/{appPackage}")
  public AppReviewSet getReviews(@PathVariable("appPackage") String appPackage){
    return scraperService.getReviews(appPackage);
  }

}
