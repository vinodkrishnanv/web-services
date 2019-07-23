package com.nielsen.mcm.poc.webservices.rest.v1.controllers;

import com.nielsen.mcm.poc.webservices.WebServicesApplication;
import com.nielsen.mcm.poc.webservices.rest.v1.models.MyApp;
import com.nielsen.mcm.poc.webservices.rest.v1.service.MyAppService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = WebServicesApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class MyAppController2IT {
    @Mock
    MyAppService myAppServiceMock;

    @InjectMocks
    MyAppController myAppController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveMyAppsWithMockito() {
        ArrayList<MyApp> list = new ArrayList<MyApp>();
        list.add(new MyApp("MCM"));
        when(myAppServiceMock.findMyApps()).thenReturn(list);
        List<MyApp> result = myAppController.myapps();
        assertEquals(1, result.size());
    }
}
