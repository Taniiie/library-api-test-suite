package com.taniiie.library.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * POJO for streets.json
 */
public class StreetsRoot {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("Cities")
  private List<CityStreets> cityStreets;

  public StreetsRoot() {}

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<CityStreets> getCityStreets() {
    return cityStreets;
  }

  public void setCityStreets(List<CityStreets> cityStreets) {
    this.cityStreets = cityStreets;
  }
}
