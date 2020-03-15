package com.harriydaran.appservice.api;

import static org.junit.jupiter.api.Assertions.*;

import com.harriydaran.appservice.model.AppReviewSet;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class ScraperControllerTest {

  @Test
  public void testScrapeRequestOnExistingAppInDatabaseIsRejected(){
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<AppReviewSet> responseEntity1 = restTemplate.getForEntity("http://localhost:8080/scrape/com.cafelabs.curlme", AppReviewSet.class);
    ResponseEntity<AppReviewSet> responseEntity2 = restTemplate.getForEntity("http://localhost:8080/scrape/com.cafelabs.curlme", AppReviewSet.class);
    AppReviewSet appReviewSet = responseEntity2.getBody();
    assertNotNull(responseEntity1.getBody());
    assertNull(appReviewSet);
  }

}