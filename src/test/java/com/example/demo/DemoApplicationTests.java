package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
    @Autowired
    FacilityRepository facilityRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void contextLoads() {
        facilityRepository.findAllInCpyAndDate(1L, new Date());

        String query = "select fac.product from Facility fac " +
                " where (fac.cpy.id = :cpyId and trunc(fac.pk.reportDate, 'MONTH') = trunc(:date, 'MONTH'))) " +
                " order by fac.product.code ";

        entityManager.createQuery(query, Product.class)
                .setParameter("cpyId", 1L)
                .setParameter("date", new Date())
                .getResultList();
    }

}
