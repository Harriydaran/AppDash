package com.harriydaran.appservice.dao;

import com.harriydaran.appservice.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  List<Review> findByApp_Name(String app_name);
}
