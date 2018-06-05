package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    Long id;

    String code;
}
