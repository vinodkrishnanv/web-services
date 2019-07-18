package com.nielsen.mcm.poc.webservices.rest.v1.repositories;

import com.nielsen.mcm.poc.webservices.rest.v1.models.MyApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyAppRepository extends JpaRepository<MyApp,Long> {
    List<MyApp> findAll();
}
