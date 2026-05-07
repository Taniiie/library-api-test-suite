package com.taniiie.library.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * POJO for nested map inside parent StreetsRoot containing city name and its list of streets
 */
public class CityStreets {
  @JsonProperty("City")
  private String city;

  @JsonProperty("Streets")
  private List<String> streets;

  public CityStreets() {}

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<String> getStreets() {
    return streets;
  }

  public void setStreets(List<String> streets) {
    this.streets = streets;
  }
}
