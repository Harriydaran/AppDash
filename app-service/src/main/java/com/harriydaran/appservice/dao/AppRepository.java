package com.harriydaran.appservice.dao;

import com.harriydaran.appservice.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {

}
