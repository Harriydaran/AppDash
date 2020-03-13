package com.harriydaran.appservice.service;

import com.harriydaran.appservice.dao.AppRepository;
import com.harriydaran.appservice.model.App;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

  private AppRepository appRepository;

  @Autowired
  public AppService(AppRepository appRepository) {
    this.appRepository = appRepository;
  }

  public Optional<App> getAppById(final long id){
    return appRepository.findById(id);
  }

}
