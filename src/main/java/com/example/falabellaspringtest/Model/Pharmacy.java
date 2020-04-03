package com.example.falabellaspringtest.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Pharmacy {

  private @Id @GeneratedValue Long id;
  private String commune;
  private String storeName;
  private String address;
  private String phone;
  private String lattitude;
  private String longitude;

  public Pharmacy() {
  }

  public Pharmacy(String commune, String storeName, String address, String phone, String lattitude, String longitude) {
    this.commune = commune;
    this.storeName = storeName;
    this.address = address;
    this.phone = phone;
    this.lattitude = lattitude;
    this.longitude = longitude;
  }

  public Pharmacy(Long id, String commune, String storeName, String address, String phone, String lattitude, String longitude) {
    this.id = id;
    this.commune = commune;
    this.storeName = storeName;
    this.address = address;
    this.phone = phone;
    this.lattitude = lattitude;
    this.longitude = longitude;
  }

}
