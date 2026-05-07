package com.taniiie.library.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taniiie.library.models.pojos.Cities;
import com.taniiie.library.models.pojos.StreetsRoot;
import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.List;
import java.util.Optional;

/**
 * A Rest Assured Filter that intercepts requests and returns mock data from local JSON files.
 * This helps bypass Cloudflare blocks or network issues during development/demos.
 */
public class MockFilter implements Filter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        String path = requestSpec.getUserDefinedPath();
        
        // Cities API: /{postcode}
        // Streets API: /{postcode}/{city}/streets
        
        if (path.endsWith("/streets")) {
            return mockStreetsResponse(requestSpec);
        } else if (path.matches("/\\d+") || path.contains("/{")) {
            return mockCitiesResponse(requestSpec);
        }

        return ctx.next(requestSpec, responseSpec);
    }

    private Response mockCitiesResponse(FilterableRequestSpecification requestSpec) {
        String path = requestSpec.getUserDefinedPath();
        String postalCode;
        
        if (path.contains("{")) {
            // It's a template, get from path params
            postalCode = requestSpec.getPathParams().getOrDefault("code", 
                         requestSpec.getPathParams().getOrDefault("postcode", "")).toString();
        } else {
            postalCode = path.substring(path.lastIndexOf("/") + 1);
        }
        
        List<Cities> allCities = JacksonUtils.getCitiesForPostalCode();
        
        Optional<Cities> match = allCities.stream()
                .filter(c -> c.getCode().equals(postalCode))
                .findFirst();

        try {
            if (match.isPresent()) {
                return new ResponseBuilder()
                        .setStatusCode(200)
                        .setContentType("application/json")
                        .setBody(objectMapper.writeValueAsString(match.get()))
                        .build();
            } else {
                return new ResponseBuilder()
                        .setStatusCode(404)
                        .setBody("")
                        .build();
            }
        } catch (Exception e) {
            return new ResponseBuilder().setStatusCode(500).build();
        }
    }

    private Response mockStreetsResponse(FilterableRequestSpecification requestSpec) {
        String path = requestSpec.getUserDefinedPath();
        String postalCode;
        String city;

        if (path.contains("{")) {
            postalCode = requestSpec.getPathParams().getOrDefault("code", "").toString();
            city = requestSpec.getPathParams().getOrDefault("city", "").toString();
        } else {
            // Path format: /{postcode}/{city}/streets
            String[] parts = path.split("/");
            if (parts.length < 4) return new ResponseBuilder().setStatusCode(404).build();
            postalCode = parts[parts.length - 3];
            city = parts[parts.length - 2];
        }
        
        List<StreetsRoot> allStreets = JacksonUtils.getStreetsForPostalCode();
        
        Optional<StreetsRoot> matchRoot = allStreets.stream()
                .filter(s -> s.getCode().equals(postalCode))
                .findFirst();

        try {
            if (matchRoot.isPresent()) {
                final String targetCity = city;
                Optional<com.taniiie.library.models.pojos.CityStreets> matchCity = matchRoot.get().getCityStreets().stream()
                        .filter(c -> c.getCity().equalsIgnoreCase(targetCity))
                        .findFirst();
                
                if (matchCity.isPresent()) {
                    return new ResponseBuilder()
                            .setStatusCode(200)
                            .setContentType("application/json")
                            .setBody(objectMapper.writeValueAsString(matchCity.get()))
                            .build();
                }
            }
            return new ResponseBuilder().setStatusCode(404).setBody("").build();
        } catch (Exception e) {
            return new ResponseBuilder().setStatusCode(500).build();
        }
    }
}
