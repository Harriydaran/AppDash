package com.harriydaran.webscraperservice.domain;

import com.harriydaran.webscraperservice.model.Review;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// TODO: Scrape Review Date
// TODO: Scrape Review Rating
// TODO: Scrape Review Author

public class PlayStoreScraper {

  private static final long DELAY = 2000;

  private static final String PLAYSTORE_URL = "https://play.google.com/store/apps/details?id=";

  public static List<Review> scrape(final String appPackage) {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get(PLAYSTORE_URL + appPackage  +"&showAllReviews=true");
    List<Review> reviews = new ArrayList<>();

    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    int count = 1;

    try {
      while (true){

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        List<WebElement> showAllReviewsBtn = driver.findElements(By.cssSelector(cssSelectorShowAllReviewsBtn()));
        if (showAllReviewsBtn.size() > 0){
          showAllReviewsBtn.get(0).click();
          System.out.println("Button Clicked");
        }

        WebElement reviewRaw = driver.findElement(By.xpath(xPathReview(count)));
        Review review = new Review();
        if (reviewRaw.getText().contains("Full Review")){
          driver.findElement(By.xpath(xPathFullReviewBtn(count))).click();
          WebElement fullReviewText = driver.findElement(By.xpath(xPathFullReviewText(count)));
          review.setText(fullReviewText.getText());
        }else {
          review.setText(reviewRaw.getText());
        }
        WebElement authorRaw = reviewRaw.findElement(By.xpath(xPathReviewAuthor(count)));
        review.setAuthor(authorRaw.getText());
        reviews.add(review);
        count++;
      }

    } catch (NoSuchElementException e) {
      System.out.println("No more Elements");
    } finally {
      driver.close();
      for(Review review: reviews){
        System.out.println(review.getText());
      }
    }
    return reviews;
  }

  public static String xPathReviewAuthor(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[1]/div[1]/span"
  }

  public static String xPathReview(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[2]/span[1]";
  }

  public static String xPathFullReviewBtn(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[2]/span[1]/div/button";
  }

  public static String xPathFullReviewText(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[2]/span[2]";
  }

  public static String cssSelectorShowAllReviewsBtn(){
    return "#fcxH9b > div.WpDbMd > c-wiz > div > div.ZfcPIb > div > div.JNury.Ekdcne > div > div > div.W4P4ne > div:nth-child(2) > div.PFAhAf > div";
  }

}
