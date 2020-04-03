package com.example.falabellaspringtest.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.example.falabellaspringtest.Model.Pharmacy;
import com.example.falabellaspringtest.Repository.PharmacyRepository;

@RestController
@RequestMapping("/api/v1/pharmacies")
public class PharmacyController {

  private final static Logger logger = LoggerFactory.getLogger(PharmacyController.class);

  @Autowired
	private PharmacyRepository repository;


  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<Pharmacy> getAllPharmaciesByCommune(@RequestParam(required = false) String commune){
    logger.info("Getting all pharmacies by "+commune);
    if (commune != null) {
      return repository.findByCommune(commune);
    }
    return repository.findAll();
  }

}
