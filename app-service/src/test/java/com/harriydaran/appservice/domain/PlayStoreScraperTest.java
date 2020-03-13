package com.harriydaran.appservice.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.harriydaran.appservice.model.AppReviewSet;
import org.junit.jupiter.api.Test;

// TODO: Mock Network I/O
class PlayStoreScraperTest {

  @Test
  void testScrapeReturnsNotNull() {
    AppReviewSet appReviewSet;
    String appPackage = "com.cafelabs.curlme";
    appReviewSet = PlayStoreScraper.scrape(appPackage);
    assertNotNull(appReviewSet);
  }

  @Test
  void testScrapeReturnsNotNullApp() {
    AppReviewSet appReviewSet;
    String appPackage = "com.cafelabs.curlme";
    appReviewSet = PlayStoreScraper.scrape(appPackage);
    assertNotNull(appReviewSet.getApp());
  }

  @Test
  void testScrapeReturnsNotNullReviews() {
    AppReviewSet appReviewSet;
    String appPackage = "com.cafelabs.curlme";
    appReviewSet = PlayStoreScraper.scrape(appPackage);
    assertNotNull(appReviewSet.getReviews());
  }

  @Test
  void testConvertRawRatingToInt() {
    int i = PlayStoreScraper.convertRawRatingToInt("Rated 1 stars out of 5");
    assertEquals(1, i);
  }

  @Test
  void testXPathReviewRating() {
    int position = 6;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div[6]/div/div[2]/div[1]/div[1]/div/span[1]/div/div";
    assertEquals(expected, PlayStoreScraper.xPathReviewRating(position));
  }

  @Test
  void testXPathReviewDate() {
    int position = 7;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div[7]/div/div[2]/div[1]/div[1]/div/span[2]";
    assertEquals(expected, PlayStoreScraper.xPathReviewDate(position));
  }

  @Test
  void testXPathReviewAuthor() {
    int position = 8;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[1]/div[1]/span";
    assertEquals(expected, PlayStoreScraper.xPathReviewAuthor(position));
  }

  @Test
  void testXPathReview() {
    int position = 9;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[2]/span[1]";
    assertEquals(expected, PlayStoreScraper.xPathReview(position));
  }

  @Test
  void testXPathFullReviewBtn() {
    int position = 122;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div[122]/div/div[2]/div[2]/span[1]/div/button";
    assertEquals(expected, PlayStoreScraper.xPathFullReviewBtn(position));
  }

  @Test
  void testXPathFullReviewText() {
    int position = 77;
    String expected = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div[77]/div/div[2]/div[2]/span[2]";
    assertEquals(expected, PlayStoreScraper.xPathFullReviewText(position));
  }

  @Test
  void testCssSelectorShowAllReviewsBtn() {
    String expected = "#fcxH9b > div.WpDbMd > c-wiz > div > div.ZfcPIb > div > div.JNury.Ekdcne > div > div > div.W4P4ne > div:nth-child(2) > div.PFAhAf > div";
    assertEquals(expected, PlayStoreScraper.cssSelectorShowAllReviewsBtn());
  }

  @Test
  void testGetAppNameFromPackage(){
    String appPackage = "com.harriydaran.appdash";
    String expected = "appdash";
    assertEquals(expected, PlayStoreScraper.convertPackageToAppName(appPackage));
  }
}