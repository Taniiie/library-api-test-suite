package com.taniiie.library.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * POJO for cities.json
 */
public class Cities {

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Cities")
  private List<String> cities;

  public Cities() {}

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<String> getCities() {
    return cities;
  }

  public void setCities(List<String> cities) {
    this.cities = cities;
  }
}
