package com.example.falabellaspringtest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.falabellaspringtest.Model.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

  @Query("SELECT new com.example.falabellaspringtest.Model.Pharmacy(id, commune, storeName, address, phone, lattitude, longitude)  FROM Pharmacy where commune = :commune") 
  List<Pharmacy>findByCommune(@Param("commune") String commune);
}
