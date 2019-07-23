package com.nielsen.mcm.poc.webservices.rest.v1.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "myapps")
public class MyApp implements Serializable{
    private static final long serialVersionUID = -8470355343517818196L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public MyApp() {
        super();
    }

    public MyApp(String name) {
        this.name = name;
    }

    public MyApp(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
