package com.example.falabellaspringtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

import com.example.falabellaspringtest.Model.Pharmacy;
import com.example.falabellaspringtest.Repository.PharmacyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.client.RestTemplate;

@Configuration
class LoadDatabase {

  private final static Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

  private final String URL_DATA = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7";

  @Bean
  CommandLineRunner initDatabase(PharmacyRepository repository) {
    return args -> {
      RestTemplate client = new RestTemplate();
      String jsonResult = client.getForObject(URL_DATA, String.class);
      JsonParser jsonParser = JsonParserFactory.getJsonParser();
      List<Object> listParsed = jsonParser.parseList(jsonResult);
      
      logger.info("STARTING TO LOAD INFORMATION");
      for(Object json : listParsed) {
          if(json instanceof Map) {
              Map<String,Object> jsonMapObject = (Map<String,Object>) json;
              repository.save(
                new Pharmacy(
                  jsonMapObject.get("comuna_nombre").toString(), 
                  jsonMapObject.get("local_nombre").toString(), 
                  jsonMapObject.get("local_direccion").toString(), 
                  jsonMapObject.get("local_telefono").toString(),
                  jsonMapObject.get("local_lat").toString(),
                  jsonMapObject.get("local_lng").toString())
              );
          }
      }
      logger.info("LOAD INFORMATION LOAD SUCCESSFULL");
    };
  }
}
