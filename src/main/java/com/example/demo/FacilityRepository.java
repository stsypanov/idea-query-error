package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, FacilityPK> {

    @Query("select fac.product from Facility fac " +
            " where (fac.cpy.id = :cpyId and trunc(fac.pk.reportDate, 'MONTH') = trunc(:date, 'MONTH'))) " +
            " order by fac.product.code ")
    List<Product> findAllInCpyAndDate(@Param("cpyId") Long cpyId, @Param("date") Date date);
}
