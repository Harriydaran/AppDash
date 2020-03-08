package com.harriydaran.webscraperservice;

import com.harriydaran.webscraperservice.model.Review;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

  private static final long DELAY = 2000;
//  private static final String APP = "com.rightmove.android";
//  private static final String APP = "com.cafelabs.curlme";
  private static final String APP = "com.amensah.easycoder";
  private static final String PLAYSTORE_URL = "https://play.google.com/store/apps/details?id=";

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get(PLAYSTORE_URL + APP  +"&showAllReviews=true");
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
        String xPathReview = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+count+"]/div/div[2]/div[2]/span[1]";
        String xPathFullReviewBtn = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+count+"]/div/div[2]/div[2]/span[1]/div/button";
        String xPathFullReviewText = "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+count+"]/div/div[2]/div[2]/span[2]";
        String cssSelectorShowAllReviewsBtn = "#fcxH9b > div.WpDbMd > c-wiz > div > div.ZfcPIb > div > div.JNury.Ekdcne > div > div > div.W4P4ne > div:nth-child(2) > div.PFAhAf > div";

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        List<WebElement> showAllReviewsBtn = driver.findElements(By.cssSelector(cssSelectorShowAllReviewsBtn));
        if (showAllReviewsBtn.size() > 0){
          showAllReviewsBtn.get(0).click();
        }

        WebElement reviewRaw = driver.findElement(By.xpath(xPathReview));
        Review review = new Review();
        if (reviewRaw.getText().contains("Full Review")){
          driver.findElement(By.xpath(xPathFullReviewBtn)).click();
          WebElement fullReviewText = driver.findElement(By.xpath(xPathFullReviewText));
          review.setText(fullReviewText.getText());
        }else {
          review.setText(reviewRaw.getText());
        }
        reviews.add(review);
        count = count + 1;
      }

    } catch (NoSuchElementException e) {
      e.printStackTrace();
      driver.close();
    } finally {
      driver.close();
      for(Review review: reviews){
        System.out.println(review.getText());
      }
    }


  }

  public static void gerReviews(){

  }

}
