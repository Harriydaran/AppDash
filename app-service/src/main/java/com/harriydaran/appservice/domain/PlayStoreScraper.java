package com.harriydaran.appservice.domain;

import com.harriydaran.appservice.model.App;
import com.harriydaran.appservice.model.AppReviewSet;
import com.harriydaran.appservice.model.Review;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PlayStoreScraper {

  private static final long DELAY = 2000;
  private static final String PLAYSTORE_URL = "https://play.google.com/store/apps/details?id=";
  private static final Logger LOGGER = Logger.getLogger("com.harriydaran.webscraperservice.domain.PlayStoreScraper");

  public static AppReviewSet scrape(final String appPackage) {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get(PLAYSTORE_URL + appPackage  +"&showAllReviews=true");
    List<Review> reviews = new ArrayList<>();

    // TODO: Get App Category
    App app = new App();
    app.setAppPackage(appPackage);
    app.setName(convertPackageToAppName(appPackage));
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    int count = 1;
    String category = driver.findElement(By.xpath(xPathAppCategory())).getText();
    app.setCategory(category);
    try {
      while (true){

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        List<WebElement> showAllReviewsBtn = driver.findElements(By.cssSelector(cssSelectorShowAllReviewsBtn()));
        if (showAllReviewsBtn.size() > 0){
          showAllReviewsBtn.get(0).click();
        }

        WebElement reviewRaw = driver.findElement(By.xpath(xPathReview(count)));
        Review review = new Review();
        if (reviewRaw.getText().contains("Full Review")){
          driver.findElement(By.xpath(xPathFullReviewBtn(count))).click();
          WebElement fullReviewTextRaw = driver.findElement(By.xpath(xPathFullReviewText(count)));
          review.setText(fullReviewTextRaw.getText());
        }else {
          review.setText(reviewRaw.getText());
        }
        review.setApp(app);
        reviews.add(review);

        WebElement authorRaw = reviewRaw.findElement(By.xpath(xPathReviewAuthor(count)));
        review.setAuthor(authorRaw.getText());

        WebElement dateRaw = reviewRaw.findElement(By.xpath(xPathReviewDate(count)));
        review.setDate(new Date(dateRaw.getText()));

        WebElement ratingRaw = reviewRaw.findElement(By.xpath(xPathReviewRating(count)));
        review.setRating(convertRawRatingToInt(ratingRaw.getAttribute("aria-label")));

        count++;
      }

    } catch (NoSuchElementException e) {
      LOGGER.log(Level.INFO, "No more elements");
    } finally {
      driver.close();
      LOGGER.log(Level.INFO, "Closed web driver");
    }

    return new AppReviewSet(app, reviews);
  }

  public static String convertPackageToAppName(String appPackage){
    return appPackage.substring(appPackage.indexOf('.', appPackage.indexOf('.')+1)).substring(1);
  }

  public static int convertRawRatingToInt(String rawRating){
    return Integer.parseInt(String.valueOf(rawRating.charAt(6)));
  }

  public static String xPathReviewRating(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[1]/div[1]/div/span[1]/div/div";
  }

  public static String xPathReviewDate(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[1]/div[1]/div/span[2]";
  }

  public static String xPathReviewAuthor(int position){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div["+position+"]/div/div[2]/div[1]/div[1]/span";
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

  public static String xPathAppCategory(){
    return "/html/body/div[1]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz/c-wiz/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/span[2]/a";
  }

}
