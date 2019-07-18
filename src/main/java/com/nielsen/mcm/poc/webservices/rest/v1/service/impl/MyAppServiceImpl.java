package com.nielsen.mcm.poc.webservices.rest.v1.service.impl;

import com.nielsen.mcm.poc.webservices.rest.v1.models.MyApp;
import com.nielsen.mcm.poc.webservices.rest.v1.repositories.MyAppRepository;
import com.nielsen.mcm.poc.webservices.rest.v1.service.MyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("WebService")
public class MyAppServiceImpl implements MyAppService {

    @Value("Hello World - From MyApp")
    private String welcomeMessage;

    @Autowired
    private MyAppRepository myAppRepository;
    public String retrieveMessage() {
        return welcomeMessage;
    }
    public List<MyApp> findMyApps() {
        return myAppRepository.findAll();
    }

}

