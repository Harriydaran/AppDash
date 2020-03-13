package com.harriydaran.webscraperservice.dao;

import com.harriydaran.webscraperservice.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {

}
