package com.harriydaran.appservice.api;

import com.harriydaran.appservice.model.App;
import com.harriydaran.appservice.service.AppService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apps")
public class AppController {

  private AppService appService;

  @Autowired
  public AppController(AppService appService) {
    this.appService = appService;
  }

  @GetMapping("/{id}")
  public Optional<App> getAppById(@PathVariable("id") final long id){
    return appService.getAppById(id);
  }

}
