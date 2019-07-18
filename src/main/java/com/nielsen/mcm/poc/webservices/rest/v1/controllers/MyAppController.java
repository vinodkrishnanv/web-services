package com.nielsen.mcm.poc.webservices.rest.v1.controllers;

import com.nielsen.mcm.poc.webservices.rest.v1.models.MyApp;
import com.nielsen.mcm.poc.webservices.rest.v1.service.MyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class MyAppController {

    @Autowired(required = true)
    @Qualifier("WebService")
    private MyAppService myAppService;

    @GetMapping("/checkStatus")
    public ResponseEntity<String> checkStatus() throws IOException {
        return ResponseEntity.accepted().body("OK");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() throws IOException {
        return ResponseEntity.accepted().body(myAppService.retrieveMessage());
    }

    @GetMapping("/myapps")
    @ResponseBody
    public List<MyApp> myapps() {
        return myAppService.findMyApps();
    }
}
