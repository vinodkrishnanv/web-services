package com.nielsen.mcm.poc.webservices.rest.v1.controllers;

import com.nielsen.mcm.poc.webservices.WebServicesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebServicesApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class MyAppControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveMyApps() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.getForEntity("/myapps", String.class);
        String expected = "[{\"id\":1,\"name\":\"MCM\"}]";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
}
