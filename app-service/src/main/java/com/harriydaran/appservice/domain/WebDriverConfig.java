package com.harriydaran.appservice.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {

  private static final Logger LOGGER = Logger.getLogger("com.harriydaran.appservice.domain.WebDriverConfig");
  private WebDriver driver;

  public WebDriverConfig() {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    driver = new FirefoxDriver();
    LOGGER.log(Level.INFO, "Initialized WebDriver");
  }

  public WebDriver getDriver() {
    return driver;
  }

}
