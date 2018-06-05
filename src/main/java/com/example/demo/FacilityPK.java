package com.example.demo;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class FacilityPK implements Serializable {
    @Column
    Long id;
    @Column
    LocalDate reportDate;
}
