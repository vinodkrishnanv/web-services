package com.nielsen.mcm.poc.webservices.rest.v1.service;

import com.nielsen.mcm.poc.webservices.rest.v1.models.MyApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface MyAppService {
    public String welcomeMessage = "EMPTY";
    public String retrieveMessage() throws IOException;
    public List<MyApp> findMyApps();
}
