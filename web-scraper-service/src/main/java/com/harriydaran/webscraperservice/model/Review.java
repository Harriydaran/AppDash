package com.harriydaran.webscraperservice.model;

import java.util.Date;

public class Review {

  private String text;
  private int rating;
  private Date date;
  private String author;   // Only Storing this to obtain gender analysis

  public Review() {
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
