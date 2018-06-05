package com.example.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Facility {
    @EmbeddedId
    FacilityPK pk;

    @ManyToOne
    @JoinColumn(name = "PRD_ID")
    Product product;

    @ManyToOne
    @JoinColumn(name = "CPY_ID")
    Cpy cpy;
}
